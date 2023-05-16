package com.android.bisabelajar.ui.feat_student.list_student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.databinding.ActivityListStudentBinding
import com.android.bisabelajar.ui.feat_auth.login.LoginActivity
import com.android.bisabelajar.ui.feat_menu_utama.MainActivity
import com.android.bisabelajar.ui.feat_student.add_edit_student.AddEditStudentActivity
import com.android.bisabelajar.ui.listener.adapter.AdapterListener
import com.android.bisabelajar.utils.*
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListStudentActivity : AppCompatActivity(), AdapterListener {
    private val binding: ActivityListStudentBinding by lazy {
        ActivityListStudentBinding.inflate(layoutInflater)
    }
    private var balloon: Balloon? = null
    private val studentAdapter by lazy { StudentAdapter(this@ListStudentActivity) }
    private var selectedStudent: Student? = null
    private val listStudentViewModel: ListStudentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user: User? = listStudentViewModel.getUserDataStore()


        if (user == null || user.email == "") {
            openActivity(this@ListStudentActivity, LoginActivity::class.java)
        } else {
            user.apply {
                Toast.makeText(this@ListStudentActivity, uuid, Toast.LENGTH_SHORT).show()
            }
        }

        studentAdapter.submitData(getStudentList())

        binding.apply {

            toolbar.apply {
                txtTitle.text = getString(R.string.pilih_siswa)
                imgActionRight.setOnClickListener {
                    if (selectedStudent != null) {
                        showBalloon(true)
                    } else {
                        showBalloon(false)
                    }
                }
            }

            rvAbjadKapital.apply {
                adapter = this@ListStudentActivity.studentAdapter
                layoutManager =
                    androidx.recyclerview.widget.GridLayoutManager(this@ListStudentActivity, 4)
            }

            binding.btnSelect.isEnabled = selectedStudent!= null

            btnSelect.setOnClickListener {
                Toast.makeText(
                    this@ListStudentActivity,
                    "${selectedStudent?.fullName}",
                    Toast.LENGTH_SHORT
                ).show()
                openActivity(this@ListStudentActivity, MainActivity::class.java)
            }
        }
    }

    private fun showBalloon(isSelected: Boolean = false) {

        val height = if (isSelected) 140 else 70

//        val height = if (isSelected) 175 else 105

        balloon = createBalloon(this@ListStudentActivity) {
            setArrowSize(10)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(height)
            setArrowPosition(0.8f)
            setCornerRadius(4f)
            setAlpha(0.9f)
            setPaddingHorizontal(8)
            setPaddingVertical(4)
            setBackgroundColorResource(R.color.white)
            setMarginHorizontal(24)
            setLayout(R.layout.layout_action_siswa)
            setTextColorResource(R.color.white)
            setTextIsHtml(true)
            setBackgroundColorResource(R.color.white)
            setBalloonAnimation(BalloonAnimation.FADE)
            setLifecycleOwner(lifecycleOwner)

            balloon?.showAlignBottom(binding.toolbar.imgActionRight)
            Handler(Looper.getMainLooper()).postDelayed({ balloon?.dismiss() }, 2000)
        }

        val editSiswaText: TextView = balloon?.getContentView()?.findViewById(R.id.txt_edit_siswa)!!
        val addSiswaText: TextView = balloon?.getContentView()?.findViewById(R.id.txt_add_siswa)!!
        val deleteSiswaText: TextView =
            balloon?.getContentView()?.findViewById(R.id.txt_delete_siswa)!!
        addSiswaText.setOnClickListener {
            openActivity(this@ListStudentActivity, AddEditStudentActivity::class.java)
        }

        editSiswaText.setOnClickListener {
            val intent = Intent(this@ListStudentActivity, AddEditStudentActivity::class.java)
                .apply { putExtra(DATA, selectedStudent) }
            startActivity(intent)
        }

        if (isSelected) {
            editSiswaText.visible()
            deleteSiswaText.visible()
            addSiswaText.visible()
        } else {
            editSiswaText.gone()
            deleteSiswaText.gone()
            addSiswaText.visible()
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
        binding.btnSelect.isEnabled = selectedStudent!= null
    }
}