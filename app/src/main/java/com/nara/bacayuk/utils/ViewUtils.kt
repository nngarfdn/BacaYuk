package com.nara.bacayuk.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.nara.bacayuk.R
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
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(context)
        .load(url)
        .placeholder(circularProgressDrawable)
        .error(R.drawable.outline_image_not_supported_24)
        .into(this)
}

fun CircleImageView.loadImage(context: Context, url: String){
    Glide.with(context).load(url).into(this)
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

