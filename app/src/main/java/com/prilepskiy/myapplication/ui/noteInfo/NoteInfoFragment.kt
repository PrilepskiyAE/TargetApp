package com.prilepskiy.myapplication.ui.noteInfo


import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.prilepskiy.myapplication.databinding.FragmentNoteInfoBinding
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.TargetModel

import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.getUniqueId
import com.prilepskiy.myapplication.ui.base.loadImage
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteInfoFragment : FragmentBaseNCMVVM<NoteInfoViewModel, FragmentNoteInfoBinding>() {
    override val binding: FragmentNoteInfoBinding by viewBinding()
    override val viewModel: NoteInfoViewModel by viewModels()
    private var target: TargetModel? = ContractTarget.getDataTarget()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private var url: String = "empty"
    private var idNote: Long = 0
    private var title: String = ""
    private var idTagert: Long = 0


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
        ) ?: target?.id ?: 0
        url = arguments?.takeIf { it.containsKey(NoteListFragment.RESID) }?.getString(
            NoteListFragment.RESID
        ) ?: "empty"

        Log.d("TAG", "onView: $idNote, $title $idTagert $url")
        if (arguments != null) {
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
        binding.tvLabel.setOnClickListener {
            if (arguments == null){
                viewModel.addNewNote(
                    NoteModel(
                        idNote,
                        binding.etNote.text.toString(),
                        "",
                        idTagert,
                        url
                    )
                )
                Log.d("TAG99", "add:2 ")
            }
            else {
                Log.d("TAG99", "mod:1 ")
                viewModel.modification(
                NoteModel(
                    idNote,
                    binding.etNote.text.toString(),
                    "",
                    idTagert,
                    url
                )
            )
            }

            popBackStack()
        }
        binding.btRevert.setOnClickListener { findNavController().popBackStack() }
        binding.imgLogo2.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            activityResultLauncher.launch(intent)
        }
    }


}