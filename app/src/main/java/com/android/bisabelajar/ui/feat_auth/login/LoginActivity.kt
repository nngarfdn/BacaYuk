package com.android.bisabelajar.ui.feat_auth.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.android.bisabelajar.R
import com.android.bisabelajar.databinding.ActivityLoginBinding
import com.android.bisabelajar.utils.gone
import com.android.bisabelajar.utils.visible

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            toolbar.txtTitle.text = getString(R.string.masuk)
            btnLogin.setOnClickListener {
                changeErrorStateEditText(edtEmail, txtEmailError, "Email tidak boleh kosong", true)
            }
        }
    }

    fun changeErrorStateEditText(btn: AppCompatEditText, tv: TextView, errorMsg: String,
                                 isError: Boolean){
        if (isError) {
            tv.text = errorMsg
            tv.visible()
            btn.background = ContextCompat.getDrawable(this, R.drawable.error_state_edittext_outline)
        } else {
            tv.text = ""
            tv.gone()
            btn.background = ContextCompat.getDrawable(this, R.drawable.normal_state_edittext_outline)
        }
        btn.background = ContextCompat.getDrawable(this, R.drawable.error_state_edittext_outline)
    }
}