package com.android.bacabacabaca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bacabacabaca.databinding.ActivityMainBinding
import com.android.bacabacabaca.feat_hurufkapital.AbjadKapitalActivity
import com.android.bacabacabaca.feat_urutabjad.UrutAbjadActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnAbjadKapital.setOnClickListener {
                startActivity(Intent(this@MainActivity, AbjadKapitalActivity::class.java))
            }
            btnUrutAbjad.setOnClickListener {
                startActivity(Intent(this@MainActivity, UrutAbjadActivity::class.java))
            }
        }

    }


}