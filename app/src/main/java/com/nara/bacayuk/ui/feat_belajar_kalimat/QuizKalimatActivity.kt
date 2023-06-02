package com.nara.bacayuk.ui.feat_belajar_kalimat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nara.bacayuk.R
import com.nara.bacayuk.databinding.ActivityQuizKalimatBinding

class QuizKalimatActivity : AppCompatActivity() {
    private val binding by lazy { ActivityQuizKalimatBinding.inflate(layoutInflater) }

    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            opt1.setOnClickListener {
                when (count) {
                    1 -> {
                        count++
                        moveView(opt1, ans1)
                    }
                    2 -> {
                        count++
                        moveView(opt1, ans2)
                    }
                    3 -> {
                        count++
                        moveView(opt1, ans3)
                    }
                }
            }

            opt2.setOnClickListener {
                when (count) {
                    1 -> {
                        count++
                        moveView(opt2, ans1)
                    }
                    2 -> {
                        count++
                        moveView(opt2, ans2)
                    }
                    3 -> {
                        count++
                        moveView(opt2, ans3)
                    }
                }
            }

            opt3.setOnClickListener {
                when (count) {
                    1 -> {
                        count++
                        moveView(opt3, ans1)
                    }
                    2 -> {
                        count++
                        moveView(opt3, ans2)
                    }
                    3 -> {
                        count++
                        moveView(opt3, ans3)
                    }
                }
            }

        }

    }

    private fun moveView(viewToBeMoved: View, targetView: View) {
        val targetX: Float =
            targetView.x + targetView.width / 2 - viewToBeMoved.width / 2
        val targetY: Float =
            targetView.y + targetView.height / 2 - viewToBeMoved.height / 2

        viewToBeMoved.animate()
            .x(targetX)
            .y(targetY)
            .setDuration(1000)
            .withEndAction {
                targetView.visibility = View.INVISIBLE
            }
            .start()
    }

}