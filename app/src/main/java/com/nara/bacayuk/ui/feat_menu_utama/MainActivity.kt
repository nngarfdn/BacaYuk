package com.nara.bacayuk.ui.feat_menu_utama

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.databinding.ActivityMainBinding
import com.nara.bacayuk.ui.feat_auth.login.LoginActivity
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_kata.materi.MateriBacaVokalActivity
import com.nara.bacayuk.ui.feat_baca_kata.quiz.QuizBacaKataActivity
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.openActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }


        binding.apply {

            toolbar.txtTitle.text = "Menu Utama"

            txtName.text = "Guest"
            btnBacaHuruf.setOnClickListener {
                val intent = Intent(this@MainActivity, MenuBacaHurufActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }

            btnLogout.setOnClickListener {
                Toast.makeText(this@MainActivity, "Cooming Soon", Toast.LENGTH_SHORT).show()
                mainViewModel.logOutUser()
                cekUser()
                cekUser()
            }

            btnBacaKata.setOnClickListener {
                openActivity(this@MainActivity, QuizBacaKataActivity::class.java)
            }
        }
    }                //cooming soon
//                Toast.makeText(this@MainActivity, "Cooming Soon", Toast.LENGTH_SHORT).show()
//                openActivity(this@MainActivity, MateriBacaHurufActivity::class.java)

    private fun cekUser() {
        val user: User? = mainViewModel.getUserDataStore()

        if (user == null || user.email == "") {
            openActivity(this@MainActivity, LoginActivity::class.java)
        } else {
            user.apply {
                Toast.makeText(this@MainActivity, uuid, Toast.LENGTH_SHORT).show()
            }
        }
    }


}