package com.android.bisabelajar.ui.feat_menu_utama

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.databinding.ActivityMainBinding
import com.android.bisabelajar.ui.feat_auth.login.LoginActivity
import com.android.bisabelajar.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.android.bisabelajar.ui.feat_hurufkapital.AbjadKapitalActivity
import com.android.bisabelajar.ui.feat_student.list_student.ListStudentActivity
import com.android.bisabelajar.ui.feat_urutabjad.UrutAbjadActivity
import com.android.bisabelajar.utils.openActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.apply {

            toolbar.txtTitle.text = "Menu Utama"

            btnBacaHuruf.setOnClickListener {
                openActivity(this@MainActivity, MenuBacaHurufActivity::class.java)
            }

            btnLogout.setOnClickListener {
                mainViewModel.logOutUser()
                cekUser()
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