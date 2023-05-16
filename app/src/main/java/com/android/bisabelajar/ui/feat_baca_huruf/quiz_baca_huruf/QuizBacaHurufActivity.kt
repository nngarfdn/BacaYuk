package com.android.bisabelajar.ui.feat_baca_huruf.quiz_baca_huruf

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.databinding.ActivityQuizBacaHurufBinding
import com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf.ViewPageAdapter
import com.android.bisabelajar.utils.DATA

class QuizBacaHurufActivity : AppCompatActivity() {

    private val binding by lazy { ActivityQuizBacaHurufBinding.inflate(layoutInflater) }
    private var name = ""
    companion object {
        var dataAbjad: Abjad? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MateriBacaHurufActivity.dataAbjad = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(DATA, Abjad::class.java)
        } else {
            intent.getParcelableExtra(DATA) as Abjad?
        }

        binding.apply {
            val pagerAdapter = ViewPageQuizAdapter(this@QuizBacaHurufActivity) { name = it.toString() }
            slideVP.adapter = pagerAdapter
            dotsIndicator.setViewPager2(slideVP)

            buttonNext.setOnClickListener {
                if (slideVP.currentItem < 2) {
                    slideVP.currentItem = slideVP.currentItem.plus(1)
                } else {
//                    openActivity(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
//                    val intent = Intent(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
//                        .apply { putExtra(DATA, MateriBacaHurufActivity.dataAbjad as Abjad) }
//                    startActivity(intent)
                }
            }
        }
    }
}