package com.android.bacabacabaca.ui.feat_detail_abjad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bacabacabaca.R
import com.android.bacabacabaca.databinding.ActivityDetailAbjadBinding
import com.android.bacabacabaca.utils.playAudioFromRawAssets

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