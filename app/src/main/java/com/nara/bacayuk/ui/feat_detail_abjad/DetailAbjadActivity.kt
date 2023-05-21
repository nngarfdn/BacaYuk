package com.nara.bacayuk.ui.feat_detail_abjad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nara.bacayuk.R
import com.nara.bacayuk.databinding.ActivityDetailAbjadBinding
import com.nara.bacayuk.utils.playAudioFromRawAssets

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