package com.android.bisabelajar.ui.feat_student.add_edit_student

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.databinding.ActivityAddEditStudentBinding
import com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.android.bisabelajar.utils.DATA
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.UUID

class AddEditStudentActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddEditStudentBinding.inflate(layoutInflater) }
    private val addEditStudentViewModel: AddEditStudentViewModel by viewModel()
    private var isEditStudent = false
    private var dataStudent: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataStudent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(DATA, Student::class.java)
        } else {
            intent.getParcelableExtra(DATA) as Student?
        }



        binding.apply {

            if (dataStudent!=null) {
                isEditStudent = true
                edtName.setText(dataStudent!!.fullName)
                edtKelas.setText(dataStudent!!.kelas)
                edtNoabsen.setText(dataStudent!!.noAbsen)
                edtAsalSekolah.setText(dataStudent!!.asalSekolah)
                edtTahunMasukSekolah.setText(dataStudent!!.tahunMasukSekolah)
            }


            btnSave.setOnClickListener {
                val name = edtName.text.toString()
                val kelas = edtKelas.text.toString()
                val noAbsen = edtNoabsen.text.toString()
                val asalSekolah = edtAsalSekolah.text.toString()
                val thMasukSekolah = edtTahunMasukSekolah.text.toString()
                //generate uid for new student
                val randomUid = UUID.randomUUID().toString()
                val uuid = if (isEditStudent) dataStudent?.uuid else randomUid

                val student = Student(
                    uuid = uuid ?: "-",
                    fullName = name,
                    kelas = kelas,
                    noAbsen = noAbsen,
                    asalSekolah = asalSekolah,
                    tahunMasukSekolah = thMasukSekolah,
                )
                val uidUser = addEditStudentViewModel.getUID() ?: "-"
                addEditStudentViewModel.addUserToFirestore(uidUser, student)
            }

            addEditStudentViewModel.isSuccess.observe(this@AddEditStudentActivity) { response ->
                when (response) {
                    is Response.Success -> {
                        Toast.makeText(this@AddEditStudentActivity, "Berhasil", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    is Response.Error -> {
                        Toast.makeText(this@AddEditStudentActivity, response.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }
            }
        }
    }
}