package com.nara.bacayuk.ui.feat_riwayat.menu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ActivityMenuRiwayatBinding
import com.nara.bacayuk.ui.feat_riwayat.huruf.RiwayatHurufActivity

class MenuRiwayatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMenuRiwayatBinding.inflate(layoutInflater) }
    var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }

        binding.apply {
            textView.text = student?.fullName
            btnHuruf.setOnClickListener {
                val intent = Intent(this@MenuRiwayatActivity, RiwayatHurufActivity::class.java).apply {
                    putExtra("student", student)
                }
                startActivity(intent)
            }
        }
    }
}