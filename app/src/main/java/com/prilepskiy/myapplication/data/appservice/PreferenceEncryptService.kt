package com.prilepskiy.myapplication.data.appservice

interface PreferenceEncryptService {
    fun getData():String?
    fun setData(data: String)
}