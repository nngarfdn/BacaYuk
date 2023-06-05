package com.nara.bacayuk.ui.feat_baca_kata.quiz

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.SoalKata
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.model.addSusunKata
import com.nara.bacayuk.databinding.ActivityQuizMenuBinding
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.AbjadMenuAdapter
import com.nara.bacayuk.ui.feat_baca_kata.menu.MenuBacaKataActivity
import com.nara.bacayuk.ui.feat_belajar_kalimat.QuizKalimatActivity
import com.nara.bacayuk.ui.feat_belajar_kalimat.QuizPilganKalimatActivity
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.ui.listener.adapter.AdapterQuizListener
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.openActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizMenuActivity : AppCompatActivity(), AdapterListener {

    private val binding by lazy { ActivityQuizMenuBinding.inflate(layoutInflater) }
    private val adapterQuizMenuAdapter1 by lazy { QuizMenuAdapter(this@QuizMenuActivity, "susun") }
    private val adapterQuizMenuAdapter2 by lazy { QuizMenuAdapter(this@QuizMenuActivity,"pilgan") }
    private val quizViewModel: QuizViewModel by viewModel()
    var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }

        Log.d("idstudent", "onCreate ${student?.uuid}")

        quizViewModel.getAllReportKataFromFirestore(student?.uuid ?: "-")

        binding.apply {
            toolbarAction.apply {
                //change bg rootview to teal_600
                imgActionRight.invisible()
                rootView.backgroundTintList = AppCompatResources.getColorStateList(this@QuizMenuActivity,
                    R.color.blue_500)

                //change tint image to white
                imageView.imageTintList = AppCompatResources.getColorStateList(this@QuizMenuActivity,
                    R.color.white)

                txtTitle.setTextColor(
                    AppCompatResources.getColorStateList(this@QuizMenuActivity,
                        R.color.white))

                txtTitle.text = "Baca Kata"
                imageView.setOnClickListener {
                    finish()
                }
            }


            rvSusunKata.apply {
                adapter = adapterQuizMenuAdapter1
                layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@QuizMenuActivity, 4)
            }
            rvBacaKata.apply {
                adapter = adapterQuizMenuAdapter2
                layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@QuizMenuActivity, 4)
            }
        }

        quizViewModel.reportKatas.observe(this@QuizMenuActivity) { response ->
            when (response) {
                is Response.Success -> {
                    adapterQuizMenuAdapter1.submitData(response.data.quizSusunKata)
                    adapterQuizMenuAdapter2.submitData(response.data.quizPilganKata)
                    Log.d("reportKatas", response.data.quizSusunKata.toString())
                }
                else -> {

                }
            }
        }
    }



    override fun onClick(data: Any?, position: Int?, view: View?, type: String) {
        when(type) {
            "pilgan" -> {
                val intent = Intent(this@QuizMenuActivity, QuizPilganKalimatActivity::class.java).apply {
                    putExtra("student", student)
                    putExtra("quiz", data as SoalKata)
                }
                startActivity(intent)
            }
            "susun" -> {
                val intent = Intent(this@QuizMenuActivity, QuizKalimatActivity::class.java).apply {
                    putExtra("student", student)
                    putExtra("quiz", data as SoalKata)
                }
                startActivity(intent)
            }
        }
    }

}