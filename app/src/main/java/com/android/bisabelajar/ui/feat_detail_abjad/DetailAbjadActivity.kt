package com.android.bisabelajar.ui.feat_detail_abjad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bisabelajar.R
import com.android.bisabelajar.databinding.ActivityDetailAbjadBinding
import com.android.bisabelajar.utils.playAudioFromRawAssets

class DetailAbjadActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailAbjadBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            img1.setOnClickListener {
                playAudioFromRawAssets(this@DetailAbjadActivity, R.raw.rocket)
            }
        }

    }
}