package com.nara.bacayuk.ui.feat_menu_utama

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.databinding.ActivityMainBinding
import com.nara.bacayuk.ui.feat_auth.login.LoginActivity
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.quiz_baca_huruf.SusunSukuKataActivity
import com.nara.bacayuk.ui.feat_baca_kata.materi.MateriBacaVokalActivity
import com.nara.bacayuk.ui.feat_baca_kata.menu.MenuBacaKataActivity
import com.nara.bacayuk.ui.feat_baca_kata.quiz.QuizBacaKataActivity
import com.nara.bacayuk.ui.feat_belajar_kalimat.QuizKalimatActivity
import com.nara.bacayuk.ui.feat_belajar_kalimat.QuizPilganKalimatActivity
import com.nara.bacayuk.ui.feat_riwayat.menu.MenuRiwayatActivity
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
                val intent = Intent(this@MainActivity, MenuBacaKataActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }

            btnRiwayat.setOnClickListener {
                val intent = Intent(this@MainActivity, MenuRiwayatActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }

            btnBacaKalimat.setOnClickListener {
                val intent = Intent(this@MainActivity, QuizPilganKalimatActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }


        }

        val user: User? = mainViewModel.getUserDataStore()
        user?.uuid?.let { mainViewModel.getUser(it) }
        Log.d("materihuruf", "${user?.uuid}, ${MateriBacaHurufActivity.student?.uuid}")
        mainViewModel.user.observe(this@MainActivity) { response ->
            when (response) {
                is Response.Success -> {
                    Log.d("LoginActivity", "onCreate: ${student?.isReadyHurufDataSet}")
                    if (student?.isReadyHurufDataSet == false) {
                        response.data.uuid?.let {
                            mainViewModel.createReportHurufDataSets(
                                true,
                                it, student.uuid ?: "-",
                                student
                            )
                        }
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this, "${response.e?.message}", Toast.LENGTH_SHORT).show()
                    Log.d("LoginActivity", "onCreate: ${response.message}")
                }
                else -> {

                }
            }
        }
    }

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