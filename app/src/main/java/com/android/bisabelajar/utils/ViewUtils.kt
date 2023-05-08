package com.android.bisabelajar.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.android.bisabelajar.R
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

//extention function load image glide
fun ImageView.loadImage(context: Context, url: String){
    Glide.with(context).load(url)
}

fun CircleImageView.loadImage(context: Context, url: String){
    Glide.with(context).load(url)
}

fun changeErrorStateEditText(context: Context, btn: AppCompatEditText, tv: TextView, errorMsg: String,
                             isError: Boolean){
    if (isError) {
        tv.text = errorMsg
        tv.visible()
        btn.background = ContextCompat.getDrawable(context, R.drawable.error_state_edittext_outline)
    } else {
        tv.text = ""
        tv.gone()
        btn.background = ContextCompat.getDrawable(context, R.drawable.normal_state_edittext_outline)
    }
    btn.background = ContextCompat.getDrawable(context, R.drawable.normal_state_edittext_outline)
}