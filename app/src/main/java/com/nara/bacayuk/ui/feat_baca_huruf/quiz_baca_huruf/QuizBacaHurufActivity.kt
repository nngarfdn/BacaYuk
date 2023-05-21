package com.nara.bacayuk.ui.feat_baca_huruf.quiz_baca_huruf

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.databinding.ActivityQuizBacaHurufBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufActivity
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.openActivity

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

            toolbar.apply {
                txtTitle.text = getString(R.string.baca_huruf)
                txtTitle.setTextColor(resources.getColor(R.color.teal_600))
                imgActionRight.invisible()
                imageView.setOnClickListener {
                    finish()
                }
            }

            val pagerAdapter = ViewPageQuizAdapter(this@QuizBacaHurufActivity) { name = it.toString() }
            slideVP.adapter = pagerAdapter
            dotsIndicator.setViewPager2(slideVP)

            buttonNext.setOnClickListener {
                if (slideVP.currentItem < 1) {
                    slideVP.currentItem = slideVP.currentItem.plus(1)
                } else {
                    openActivity(this@QuizBacaHurufActivity, MenuBacaHurufActivity::class.java)
                    finish()
//                    openActivity(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
//                    val intent = Intent(this@MateriBacaHurufActivity, QuizBacaHurufActivity::class.java)
//                        .apply { putExtra(DATA, MateriBacaHurufActivity.dataAbjad as Abjad) }
//                    startActivity(intent)
                }
            }
        }
    }
}