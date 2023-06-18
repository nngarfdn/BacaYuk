package com.nara.bacayuk.ui.feat_student.list_student

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.databinding.ActivityListStudentBinding
import com.nara.bacayuk.ui.customview.ConfirmationDialogRedStyle
import com.nara.bacayuk.ui.feat_auth.login.LoginActivity
import com.nara.bacayuk.ui.feat_menu_utama.MainActivity
import com.nara.bacayuk.ui.feat_student.add_edit_student.AddEditStudentActivity
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.*
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils
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
        }

        listStudentViewModel.students.observe(this@ListStudentActivity) { response ->
            when (response) {
                is Response.Success -> {
                    if (response.data.isEmpty()){
                        handleEmptyState(true)
                    } else {
                        handleEmptyState(false)
                        studentAdapter.submitData(response.data)
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this@ListStudentActivity, response.message, Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }


        binding.apply {
            toolbar.apply {
                txtTitle.text = getString(com.nara.bacayuk.R.string.pilih_siswa)
                imageView.invisible()
                imgActionRight.setOnClickListener {
                    if (selectedStudent != null) {
                        showTip(true)
                    } else {
                        showTip(false)
                    }
                }
            }

            layoutStudent.rvAbjadKapital.apply {
                adapter = this@ListStudentActivity.studentAdapter
                layoutManager =
                    androidx.recyclerview.widget.GridLayoutManager(this@ListStudentActivity, 4)
            }

            binding.layoutStudent.btnSelect.isEnabled = selectedStudent!= null

            layoutStudent.btnSelect.setOnClickListener {
                val intent = Intent(this@ListStudentActivity, MainActivity::class.java).apply {
                    putExtra("student", selectedStudent)
                }
                startActivity(intent)
            }

            layoutEmpty.btnSelect.setOnClickListener {
                openActivity(this@ListStudentActivity, AddEditStudentActivity::class.java)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val uidUser = listStudentViewModel.getUID() ?: "-"
        Log.d("liststudent", "onResume: $uidUser")
        listStudentViewModel.getAllStudent(uidUser)
    }

    private fun showTip(isSelected: Boolean = false){
        val tooltip: SimpleTooltip = SimpleTooltip.Builder(this)
            .anchorView(binding.toolbar.imgActionRight)
            .gravity(Gravity.BOTTOM)
            .dismissOnOutsideTouch(true)
            .dismissOnInsideTouch(false)
            .modal(false)
            .animated(false)
            .showArrow(false)
            .margin(16f)
            .backgroundColor(resources.getColor(R.color.white))
            .contentView(com.nara.bacayuk.R.layout.layout_action_siswa)
            .focusable(true)
            .build()
        tooltip.show()

        val editSiswaText: TextView = tooltip?.findViewById(com.nara.bacayuk.R.id.txt_edit_siswa)!!
        val addSiswaText: TextView = tooltip?.findViewById(com.nara.bacayuk.R.id.txt_add_siswa)!!
        val deleteSiswaText: TextView =
            tooltip?.findViewById(com.nara.bacayuk.R.id.txt_delete_siswa)!!
        addSiswaText.setOnClickListener {
            openActivity(this@ListStudentActivity, AddEditStudentActivity::class.java)
        }

        editSiswaText.setOnClickListener {
            val intent = Intent(this@ListStudentActivity, AddEditStudentActivity::class.java)
                .apply {
                    putExtra(DATA, selectedStudent)
                    putExtra(EDIT, true)

                }
            startActivity(intent)
        }

        deleteSiswaText.setOnClickListener {
            val dialog = ConfirmationDialogRedStyle(
                this@ListStudentActivity,
                icon = com.nara.bacayuk.R.drawable.ic_baseline_delete_24,
                title = "Apakah Anda yakin akan menghapus profil siswa ini?",
                message = "Profil siswa akan dihapus permanen",
                onConfirmClickListener = {
                    val uidUser = listStudentViewModel.getUID() ?: "-"
                    selectedStudent?.uuid?.let { it1 ->
                        listStudentViewModel.deleteStudentFirestore(uidUser,
                            it1
                        )
                    }
                    onResume()
                }
            )
            dialog.show()

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

    private fun showBalloon(isSelected: Boolean = false) {

        val height = if (isSelected) 140 else 70
        balloon = createBalloon(this@ListStudentActivity) {
            setArrowSize(10)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(height)
            setArrowPosition(0.8f)
            setCornerRadius(4f)
            setAlpha(0.9f)
            setPaddingHorizontal(8)
            setPaddingVertical(4)
            setBackgroundColorResource(com.nara.bacayuk.R.color.white)
            setMarginHorizontal(24)
            setLayout(com.nara.bacayuk.R.layout.layout_action_siswa)
            setTextColorResource(com.nara.bacayuk.R.color.white)
            setTextIsHtml(true)
            setBackgroundColorResource(com.nara.bacayuk.R.color.white)
            setBalloonAnimation(BalloonAnimation.FADE)
            setLifecycleOwner(lifecycleOwner)

            balloon?.showAlignBottom(binding.toolbar.imgActionRight)
            Handler(Looper.getMainLooper()).postDelayed({ balloon?.dismiss() }, 2000)
        }


    }

    fun handleEmptyState(isEmpty: Boolean) {
        if (isEmpty) {
            binding.layoutEmpty.root.visible()
            binding.layoutStudent.root.gone()
        } else {
            binding.layoutEmpty.root.gone()
            binding.layoutStudent.root.visible()
        }
    }


    override fun onClick(data: Any?, position: Int?, view: View?, type: String) {
        selectedStudent = data as Student?
        binding.layoutStudent.btnSelect.isEnabled = selectedStudent!= null
    }
}