package com.android.bacabacabaca.utils

import android.content.Context
import android.media.MediaPlayer
import com.android.bacabacabaca.R

fun playAudioFromRawAssets(context: Context, fileName: Int) {
    val mediaPlayer = MediaPlayer.create(context, fileName)
    mediaPlayer.start()
}