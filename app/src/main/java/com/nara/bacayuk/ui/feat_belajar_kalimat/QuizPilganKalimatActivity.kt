package com.nara.bacayuk.ui.feat_belajar_kalimat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.nara.bacayuk.R
import com.nara.bacayuk.databinding.ActivityQuizPilganKalimatBinding

class QuizPilganKalimatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityQuizPilganKalimatBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            rbAnswer.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton: RadioButton = findViewById(checkedId)
                val selectedText = selectedRadioButton.text.toString()
                btnLogin.setOnClickListener {
                    Toast.makeText(this@QuizPilganKalimatActivity, "Kamu memilih $selectedText", Toast.LENGTH_SHORT).show()
                }

            }


        }
    }
}