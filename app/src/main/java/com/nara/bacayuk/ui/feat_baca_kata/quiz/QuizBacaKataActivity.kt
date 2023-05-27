package com.nara.bacayuk.ui.feat_baca_kata.quiz

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nara.bacayuk.databinding.ActivityQuizBacaKataBinding


class QuizBacaKataActivity : AppCompatActivity() {

    var x1 = 0f
    var y1 = 0f
    var x2 = 0f
    var y2 = 0f

    private val binding by lazy { ActivityQuizBacaKataBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            textList.setOnClickListener {
                val draw = DrawView(this@QuizBacaKataActivity)
                val x1: Float = textList.getX()
                val y1: Float = textList.getY()
                draw.addSourcePoint(x1, y1)
                Log.d("list", "text positions x1:$x1 y1:$y1")
            }
        }



    }

}