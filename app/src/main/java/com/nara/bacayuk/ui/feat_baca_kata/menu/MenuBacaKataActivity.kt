package com.nara.bacayuk.ui.feat_baca_kata.menu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ActivityMenuBacaKataBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_kata.materi.MateriBacaVokalActivity
import com.nara.bacayuk.ui.feat_baca_kata.quiz.QuizMenuActivity
import com.nara.bacayuk.ui.feat_riwayat.huruf.RiwayatHurufActivity
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.openActivity

class MenuBacaKataActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMenuBacaKataBinding.inflate(layoutInflater) }
    var student: Student? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            toolbarAction.apply {
                //change bg rootview to teal_600
                imgActionRight.invisible()
                rootView.backgroundTintList = AppCompatResources.getColorStateList(this@MenuBacaKataActivity,
                    R.color.blue_500)

                //change tint image to white
                imageView.imageTintList = AppCompatResources.getColorStateList(this@MenuBacaKataActivity,
                    R.color.white)

                txtTitle.setTextColor(
                    AppCompatResources.getColorStateList(this@MenuBacaKataActivity,
                    R.color.white))

                txtTitle.text = "Baca Kata"
                imageView.setOnClickListener {
                    finish()
                }
            }

            student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("student", Student::class.java)
            } else {
                intent.getParcelableExtra("student") as Student?
            }

            btnVokal.setOnClickListener {
//                openActivity(this@MenuBacaKataActivity, MateriBacaHurufActivity::class.java)
                val intent = Intent(this@MenuBacaKataActivity,
                    MateriBacaHurufActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }
            btnSukuKata.setOnClickListener {
                val intent = Intent(this@MenuBacaKataActivity,
                    MenuBacaHurufActivity::class.java).apply {
                    putExtra("student", student)
                    putExtra("isKata", true)
                }
                startActivity(intent)
            }
            btnLatihanSukuKata.setOnClickListener {
                val intent = Intent(this@MenuBacaKataActivity,
                    QuizMenuActivity::class.java).apply {
                    putExtra("student", student)
                    putExtra("isKata", true)
                }
                startActivity(intent)
            }

        }
    }
}