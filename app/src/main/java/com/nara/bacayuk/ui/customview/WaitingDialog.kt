package com.nara.bacayuk.ui.customview

import android.app.Dialog
import android.content.Context
import androidx.core.content.ContextCompat
import com.nara.bacayuk.R
import com.nara.bacayuk.databinding.DialogConfirmationBinding
import com.nara.bacayuk.databinding.LayoutStatusAnswerBinding
import com.nara.bacayuk.databinding.LayoutWaitingDialogBinding

class WaitingDialog(
    context: Context,
    private val status: String,
    private val listener: OnDialogShow
    ): Dialog(context) {
    var status1 = status
    val binding by lazy { LayoutWaitingDialogBinding.inflate(layoutInflater) }
        init {
        setContentView(binding.root)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.color.transparent))
        binding.apply {
            txtStatus.text = status1
            btnSelect.setOnClickListener {
                dismiss()
            }
            listener.onDialogShow(btnSelect)
        }
    }
}