package com.nara.bacayuk.ui.feat_belajar_kalimat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.ReportKalimat
import com.nara.bacayuk.data.model.ReportKata
import com.nara.bacayuk.data.model.SoalKata
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ActivityQuizPilganKalimatBinding
import com.nara.bacayuk.ui.customview.AnswerStatusDialog
import com.nara.bacayuk.ui.feat_baca_kata.quiz.QuizViewModel
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizPilganKalimatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityQuizPilganKalimatBinding.inflate(layoutInflater) }
    var student: Student? = null
    var soalKata: SoalKata? = null
    var listQuestions: MutableList<String> = mutableListOf()
    var listAnswer: MutableList<String> = mutableListOf()
    private val quizViewModel: QuizViewModel by viewModel()
    var sizeQuestion = 0
    var isKata: Boolean = false
    var reportKata: ReportKata? = null
    var reportKalimat: ReportKalimat? = null

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

        isKata = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getBooleanExtra("isKata", false)
        } else {
            intent.getBooleanExtra("isKata", false)
        }

        if (isKata) {
            reportKata = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("data", ReportKata::class.java)
            } else {
                intent.getParcelableExtra("data" ) as ReportKata?
            }
        } else {
            reportKalimat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("data", ReportKalimat::class.java)
            } else {
                intent.getParcelableExtra("data" ) as ReportKalimat?
            }
        }


        listQuestions = stringToList(soalKata?.optionList ?: "", "-")
        listQuestions.shuffle()
        sizeQuestion = listQuestions.size

        binding.apply {
            toolbar.apply {
                txtTitle.text =if(isKata) "Baca Kata" else "Baca Kalimat"
                imageView.setOnClickListener { onBackPressed() }
                imgActionRight.invisible()
            }
            opt1.setText(listQuestions[0])
            opt2.setText(listQuestions[1])
            opt3.setText(listQuestions[2])
//            opt4.setText(listQuestions[3])
            imageView4.loadImage(this@QuizPilganKalimatActivity, soalKata?.imageUrl?:"")
            rbAnswer.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton: RadioButton = findViewById(checkedId)
                val selectedText = selectedRadioButton.text.toString()
                btnLogin.setOnClickListener {
                    if (selectedText == soalKata?.correctAnswer) {
                        if (reportKata!= null) {
                            for(item in reportKata!!.quizPilganKata){
                                if (item.level == soalKata!!.level){
                                    item.isCorrect = true
                                    val index = item.level - 1
                                    reportKata!!.quizPilganKata[index]= item
                                    quizViewModel.updateReportKata(
                                        student?.uuid ?: "-", reportKata!!
                                    )
                                }
                            }
                        }

                        if (reportKalimat!= null) {
                            for(item in reportKalimat!!.quizPilganKata){
                                if (item.level == soalKata!!.level){
                                    item.isCorrect = true
                                    val index = item.level - 1
                                    reportKalimat!!.quizPilganKata[index]= item
                                    quizViewModel.updateReportKalimat(
                                        student?.uuid ?: "-", reportKalimat!!
                                    )
                                }
                            }
                        }

                        val dialog = AnswerStatusDialog(
                            this@QuizPilganKalimatActivity,
                            icon = R.drawable.ic_checklist,
                            status =  "Benar"
                        )
                        dialog.show()
                        val layoutParams = WindowManager.LayoutParams()
                        layoutParams.copyFrom(dialog.getWindow()?.getAttributes())
                        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
                        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
                        dialog.getWindow()?.setAttributes(layoutParams)
                    }

                    else {
                        val dialog = AnswerStatusDialog(
                            this@QuizPilganKalimatActivity,
                            icon = R.drawable.ic_wrong_answer,
                            status =  "Salah"
                        )
                        dialog.show()
                        val layoutParams = WindowManager.LayoutParams()
                        layoutParams.copyFrom(dialog.getWindow()?.getAttributes())
                        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
                        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
                        dialog.getWindow()?.setAttributes(layoutParams)
                    }
                }
            }
        }
    }

    fun stringToList(str: String, separator: String): MutableList<String> {
        return str.split(separator).toMutableList()
    }
}