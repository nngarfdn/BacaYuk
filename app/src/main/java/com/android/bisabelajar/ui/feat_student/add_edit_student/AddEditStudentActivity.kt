package com.android.bisabelajar.ui.feat_student.add_edit_student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.databinding.ActivityAddEditStudentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.UUID

class AddEditStudentActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddEditStudentBinding.inflate(layoutInflater) }
    private val addEditStudentViewModel: AddEditStudentViewModel by viewModel()
    private var isEditStudent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btnSave.setOnClickListener {
                val name = edtName.text.toString()
                val kelas = edtKelas.text.toString()
                val noAbsen = edtNoabsen.text.toString()
                val asalSekolah = edtAsalSekolah.text.toString()
                val thMasukSekolah = edtTahunMasukSekolah.text.toString()
                //generate uid for new student
                val randomUid = UUID.randomUUID().toString()
                val uuid = if (isEditStudent) "edit" else randomUid

                val student = Student(
                    uuid = uuid,
                    fullName = name,
                    kelas = kelas,
                    noAbsen = noAbsen,
                    asalSekolah = asalSekolah,
                    tahunMasukSekolah = thMasukSekolah,
                )
                addEditStudentViewModel.addUserToFirestore("BQtV1OANehgRrkT9YCYQIlaBjkW2", student)
            }
        }
    }
}