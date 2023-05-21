package com.nara.bacayuk.ui.feat_splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.nara.bacayuk.databinding.ActivitySpashScreenBinding
import com.nara.bacayuk.ui.feat_menu_utama.MainActivity

class SpashScreenActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySpashScreenBinding.inflate(layoutInflater) }
    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        object : CountDownTimer(SPLASH_TIME_OUT, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Tidak perlu melakukan apa-apa pada setiap tick
            }

            override fun onFinish() {
                // Intent untuk berpindah ke MainActivity
                val intent = Intent(this@SpashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}