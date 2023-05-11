package com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.databinding.ActivityMateriBacaHurufBinding
import com.android.bisabelajar.ui.feat_urutabjad.UrutAbjadActivity
import com.android.bisabelajar.utils.DATA
import com.android.bisabelajar.utils.openActivity

class MateriBacaHurufActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMateriBacaHurufBinding.inflate(layoutInflater) }
    private var name = ""
    companion object {
        var dataAbjad: Abjad? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataAbjad = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(DATA, Abjad::class.java)
        } else {
            intent.getParcelableExtra(DATA) as Abjad?
        }

        binding.apply {
            val pagerAdapter = ViewPageAdapter(this@MateriBacaHurufActivity) { name = it.toString() }
            slideVP.adapter = pagerAdapter
            dotsIndicator.setViewPager2(slideVP)

            buttonNext.setOnClickListener {
                if (slideVP.currentItem < 2) {
                    slideVP.currentItem = slideVP.currentItem.plus(1)
                } else {
//                    openActivity(this@MateriBacaHurufActivity, UrutAbjadActivity::class.java)
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
//        binding.slideVP.registerOnPageChangeCallback(switchButton)
    }
}