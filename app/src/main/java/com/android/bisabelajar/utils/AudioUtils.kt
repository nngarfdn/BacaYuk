package com.android.bisabelajar.utils

import android.content.Context
import android.media.MediaPlayer

fun playAudioFromRawAssets(context: Context, fileName: Int) {
    val mediaPlayer = MediaPlayer.create(context, fileName)
    mediaPlayer.start()
}