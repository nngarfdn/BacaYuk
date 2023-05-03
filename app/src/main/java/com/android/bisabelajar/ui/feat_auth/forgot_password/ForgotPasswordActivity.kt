package com.android.bisabelajar.ui.feat_auth.forgot_password

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.bisabelajar.R
import com.android.bisabelajar.databinding.ActivityForgotPasswordBinding
import com.android.bisabelajar.ui.customview.ConfirmationDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordActivity : AppCompatActivity() {
    
    private val binding by lazy { ActivityForgotPasswordBinding.inflate(layoutInflater) }
    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                val dialog = ConfirmationDialog(
                    this@ForgotPasswordActivity,
                    title = "Konfirmasi Pengiriman",
                    message = "Apakah Anda yakin email yang telah Anda entri benar?",
                    onConfirmClickListener = {
                        forgotPasswordViewModel.forgotPassword(edtEmail.text.toString())
                        Toast.makeText(this@ForgotPasswordActivity, "Berhasil", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                )
                dialog.show()
            }
        }

    }
}