package com.nara.bacayuk.ui.feat_belajar_kalimat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.SoalKata
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ActivityQuizPilganKalimatBinding

class QuizPilganKalimatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityQuizPilganKalimatBinding.inflate(layoutInflater) }
    var student: Student? = null
    var soalKata: SoalKata? = null
    var listQuestions: MutableList<String> = mutableListOf()
    var listAnswer: MutableList<String> = mutableListOf()
    var sizeQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }

        soalKata = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("quiz", SoalKata::class.java)
        } else {
            intent.getParcelableExtra("quiz") as SoalKata?
        }

        listQuestions = stringToList(soalKata?.optionList ?: "", "-")
        listQuestions.shuffle()
        sizeQuestion = listQuestions.size

        binding.apply {
            opt1.setText(listQuestions[0])
            opt2.setText(listQuestions[1])
            opt3.setText(listQuestions[2])
            opt4.setText(listQuestions[3])
            rbAnswer.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton: RadioButton = findViewById(checkedId)
                val selectedText = selectedRadioButton.text.toString()
                btnLogin.setOnClickListener {
                    if (selectedText == soalKata?.correctAnswer) {
                        Toast.makeText(this@QuizPilganKalimatActivity, "Benarr", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this@QuizPilganKalimatActivity, "Kamu memilih $selectedText", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun stringToList(str: String, separator: String): MutableList<String> {
        return str.split(separator).toMutableList()
    }
}