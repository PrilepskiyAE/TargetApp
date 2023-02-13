package com.prilepskiy.myapplication.ui.noteInfo


import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.prilepskiy.myapplication.databinding.FragmentNoteInfoBinding
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.ui.base.*
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListFragment
import com.prilepskiy.myapplication.ui.targetMain.stepsList.StepListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteInfoFragment : FragmentBaseNCMVVM<NoteInfoViewModel, FragmentNoteInfoBinding>() {
    override val binding: FragmentNoteInfoBinding by viewBinding()
    override val viewModel: NoteInfoViewModel by viewModels()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private var url: String = "empty"
    private var idNote: Long = 0
    private var title: String = ""
    private var idTagert: Long = 0
    private var stat:Boolean=true

    // val args:NoteInfoFragmentArgs by navArgs()
    override fun onView() {

        idNote = arguments?.takeIf { it.containsKey(NoteListFragment.ID) }?.getLong(
            NoteListFragment.ID
        ) ?: getUniqueId()
        title = arguments?.takeIf { it.containsKey(NoteListFragment.TITLE) }?.getString(
            NoteListFragment.TITLE
        ) ?: ""
        idTagert = arguments?.takeIf { it.containsKey(NoteListFragment.IDTARGET) }?.getLong(
            NoteListFragment.IDTARGET
        )!!
        url = arguments?.takeIf { it.containsKey(NoteListFragment.RESID) }?.getString(
            NoteListFragment.RESID
        ) ?: "empty"
        stat=arguments?.takeIf { it.containsKey(NoteListFragment.STAT) }?.getBoolean(
            NoteListFragment.STAT
        ) ?: false
        Log.d("TAG", "onView: $idNote, $title $idTagert $url")
        if (stat) {
            binding.etNote.setText(title)
            loadImage(binding.imgLogo2, url)
        }

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                it.data?.apply {
                    loadImage(binding.imgLogo2, data.toString())
                    url = data.toString()

                }
            }


    }


    override fun onViewClick() {
        with(binding){
        tvLabel.setOnClickListener {
            if (!stat) {
                viewModel.addNewNote(
                    NoteModel(
                        idNote,
                        etNote.text.toString(),
                        idTagert,
                        url,
                        getData()
                    )
                )

            } else {
                Log.d("TAG99", "mod:1 ")
                viewModel.modification(
                    NoteModel(
                        idNote,
                        etNote.text.toString(),
                        idTagert,
                        url,getData()
                    )
                )
            }

            popBackStack()
        }
        btRevert.setOnClickListener { findNavController().popBackStack() }
        imgLogo2.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            activityResultLauncher.launch(intent)
        }
        tvDelete.setOnClickListener {
            viewModel.delete(
                NoteModel(
                    idNote,
                    binding.etNote.text.toString(),
                    idTagert,
                    url
                )
            )
            findNavController().popBackStack()
        }
    }
    }


}