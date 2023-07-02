package com.nara.bacayuk.ui.customview

import android.app.Dialog
import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat
import com.nara.bacayuk.R
import com.nara.bacayuk.databinding.DialogConfirmationBinding
import com.nara.bacayuk.databinding.LayoutStatusAnswerBinding

class AnswerStatusDialog(
    context: Context,
    private val icon: Int = R.drawable.ic_checklist,
    private val status: String,

    ): Dialog(context) {
    private val binding by lazy { LayoutStatusAnswerBinding.inflate(layoutInflater) }
        init {
        setContentView(binding.root)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.color.transparent))
        binding.apply {
            imgIcon.setImageResource(icon)
            txtStatus.text = status
            btnSelect.setOnClickListener {
                dismiss()
            }
        }
    }
}

interface OnDialogShow{
    fun onDialogShow(button: Button)
}