package com.nara.bacayuk.ui.listener.adapter

import android.view.View

interface AdapterListener {
    fun onClick(data: Any?, position: Int?, view: View?)
}

interface AdapterQuizListener {
    fun onClick(data: Any?, position: Int?, view: View?, type: String)
}