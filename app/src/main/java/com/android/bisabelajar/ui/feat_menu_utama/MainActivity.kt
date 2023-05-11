package com.android.bisabelajar.ui.feat_menu_utama

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.databinding.ActivityMainBinding
import com.android.bisabelajar.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.android.bisabelajar.ui.feat_hurufkapital.AbjadKapitalActivity
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
            btnBacaHuruf.setOnClickListener {
                openActivity(this@MainActivity, MenuBacaHurufActivity::class.java)
            }

        }

//        mainViewModel.register("tester01@gmail.com", "12345678")
//        mainViewModel.saveUser(User("12345", "tes1@gmail.com", "tes"))
//        mainViewModel.getUser("12345")
//        mainViewModel.user.observe( this) { response ->
//            when(response){
//                is Response.Success -> {
//                    Toast.makeText(this, "data: ${response.data.email}", Toast.LENGTH_SHORT).show()
//                    Log.d("mainViewModel", "onCreate: ${response.data.email}")
//                }
//                is Response.Error -> {
//                    Toast.makeText(this, "${response.message}", Toast.LENGTH_SHORT).show()
//                    Log.d("mainViewModel", "onCreate: ${response.message}")
//                }
//                else -> {
//
//                }
//            }
//        }
//        mainViewModel.saveEmail("nanang@gmail.com")
//
//        val email = mainViewModel.getEmail()
//        Toast.makeText(this, "$email", Toast.LENGTH_SHORT).show()
    }


}