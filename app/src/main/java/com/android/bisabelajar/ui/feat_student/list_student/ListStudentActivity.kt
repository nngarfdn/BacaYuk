package com.android.bisabelajar.ui.feat_student.list_student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.databinding.ActivityListStudentBinding
import com.android.bisabelajar.ui.feat_menu_utama.MainActivity
import com.android.bisabelajar.ui.listener.adapter.AdapterListener
import com.android.bisabelajar.utils.DATA
import com.android.bisabelajar.utils.openActivity

class ListStudentActivity : AppCompatActivity(), AdapterListener {
    private val binding: ActivityListStudentBinding by lazy {
        ActivityListStudentBinding.inflate(layoutInflater)
    }
    private val studentAdapter by lazy { StudentAdapter(this@ListStudentActivity) }
    private var selectedStudent: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        studentAdapter.submitData(getStudentList())

        binding.apply {

            toolbar.apply {
                txtTitle.text = getString(R.string.pilih_siswa)
            }

            rvAbjadKapital.apply {
                adapter = this@ListStudentActivity.studentAdapter
                layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@ListStudentActivity, 4)
            }

            btnSelect.setOnClickListener {
                Toast.makeText(this@ListStudentActivity, "${selectedStudent?.fullName}", Toast.LENGTH_SHORT).show()
                openActivity(this@ListStudentActivity, MainActivity::class.java)
            }
        }
    }

    private fun getStudentList(): ArrayList<Student?>? {
        val students = ArrayList<Student?>()
        students.add(Student("1", "Ada", "Maria", "Ada"))
        students.add(Student("2", "Joni", "Maria", "Abigail"))
        students.add(Student("3", "Budi", "Maria", "Abigail"))
        students.add(Student("4", "Andi", "Maria", "Abigail"))
        students.add(Student("11", "Ada", "Maria", "Ada"))
        students.add(Student("21", "Joni", "Maria", "Abigail"))
        students.add(Student("31", "Budi", "Maria", "Abigail"))
        students.add(Student("41", "Andi", "Maria", "Abigail"))
        return students
    }

    override fun onClick(data: Any?, position: Int?, view: View?) {
        selectedStudent = data as Student?
    }
}