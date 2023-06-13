package com.nara.bacayuk.utils

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer

fun playAudioFromRawAssets(context: Context, fileName: Int) {
    val mediaPlayer = MediaPlayer.create(context, fileName)
    mediaPlayer.start()
}

fun playAudioFromUrl(url: String) {
    val mediaPlayer = MediaPlayer()
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

    try{
        mediaPlayer.apply {
            setDataSource(url)
            prepare()
            start()
        }
    } catch (e: Exception){
        e.printStackTrace()
    }
}