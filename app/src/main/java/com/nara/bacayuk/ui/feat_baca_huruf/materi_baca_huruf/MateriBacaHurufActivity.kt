package com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.databinding.ActivityMateriBacaHurufBinding
import com.nara.bacayuk.ui.feat_baca_huruf.quiz_baca_huruf.QuizBacaHurufActivity
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.invisible

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

            toolbar.apply {
                txtTitle.text = getString(R.string.baca_huruf)
                txtTitle.setTextColor(resources.getColor(R.color.teal_600))
                imgActionRight.invisible()
                imageView.setOnClickListener {
                    finish()
                }
            }

            val pagerAdapter = ViewPageAdapter(this@MateriBacaHurufActivity) { name = it.toString() }
            slideVP.adapter = pagerAdapter
            dotsIndicator.setViewPager2(slideVP)

            buttonNext.setOnClickListener {
                if (slideVP.currentItem < 2) {
                    slideVP.currentItem = slideVP.currentItem.plus(1)
                } else {
//                    openActivity(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
                    val intent = Intent(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
                        .apply { putExtra(DATA, dataAbjad as Abjad) }
                    startActivity(intent)
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
//        binding.slideVP.registerOnPageChangeCallback(switchButton)
    }
}