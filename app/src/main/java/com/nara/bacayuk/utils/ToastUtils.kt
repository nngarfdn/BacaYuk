package com.nara.bacayuk.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.nara.bacayuk.databinding.CustomToastBinding


fun showAddSuccessToast(context: Context) {
    // Inflate custom toast layout menggunakan view binding
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val toastBinding = CustomToastBinding.inflate(inflater)
    // Buat toast dan atur view, posisi, dan durasi
    val toast = Toast(context)
    toast.view = toastBinding.root
    toast.setGravity(Gravity.TOP, 0, 20)
    toast.duration = Toast.LENGTH_LONG
    // Tampilkan toast
    toast.show()
}

fun showQuizToast(context: Context, type: ToastType) {
    // Inflate custom toast layout menggunakan view binding
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val toastBinding = CustomToastBinding.inflate(inflater)
    toastBinding.customToastMessage.text = when (type) {
        ToastType.VOKAL -> "Berhasil selesaikan belajar huruf vokal"
        ToastType.SUKU_KATA -> "Berhasil selesaikan belajar suku kata"
    }
    // Buat toast dan atur view, posisi, dan durasi
    val toast = Toast(context)
    toast.view = toastBinding.root
    toast.setGravity(Gravity.TOP, 0, 20)
    toast.duration = Toast.LENGTH_LONG
    // Tampilkan toast
    toast.show()
}

enum class ToastType {
    VOKAL,SUKU_KATA
}
