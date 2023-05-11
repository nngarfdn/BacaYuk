package com.android.bisabelajar.ui.feat_baca_huruf.quiz_baca_huruf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bisabelajar.R
import com.android.bisabelajar.databinding.ActivityQuizBacaHurufBinding

class QuizBacaHurufActivity : AppCompatActivity() {

    private val binding by lazy { ActivityQuizBacaHurufBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}