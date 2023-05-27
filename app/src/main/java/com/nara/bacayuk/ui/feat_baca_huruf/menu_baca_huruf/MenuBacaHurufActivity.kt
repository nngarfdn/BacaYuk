package com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ActivityMenuBacaHurufBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.invisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuBacaHurufActivity : AppCompatActivity(), AdapterListener {

    private val binding by lazy { ActivityMenuBacaHurufBinding.inflate(layoutInflater) }
    private val adapterAbjadMenuAdapter by lazy { AbjadMenuAdapter(this@MenuBacaHurufActivity) }
    var student: Student? = null
    private val menuBacaHurufViewModel: MenuBacaHurufViewModel by viewModel()
    private val listAbjadMenu = arrayListOf<Abjad>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }

        Log.d("menubaca", "${student?.uuid}")

        menuBacaHurufViewModel.getAllReports(student?.uuid ?: "-")

        menuBacaHurufViewModel.reports.observe(this@MenuBacaHurufActivity) { response ->
            when (response) {
                is Response.Success -> {
                    response.data.forEach {
                        //get index 1 of string
                        val abjad = Abjad(
                            id = it.abjadName,
                            abjadNonKapital = it.abjadName[1].toString(),
                            abjadKapital = it.abjadName[0].toString(),
                            suara = "-",
                            reportHuruf = it
                        )
                        listAbjadMenu.add(abjad)
                    }
                    adapterAbjadMenuAdapter.submitData(listAbjadMenu)
                }

                is Response.Error -> {
                    response.message?.let {
                        Log.d("menubaca", it)
                    }
                }

                else -> {}
            }
        }

        binding.apply {
            toolbarAction.apply {
                //change bg rootview to teal_600
                imgActionRight.invisible()
                rootView.backgroundTintList = AppCompatResources.getColorStateList(this@MenuBacaHurufActivity,
                        R.color.teal_600)

                //change tint image to white
                imageView.imageTintList = AppCompatResources.getColorStateList(this@MenuBacaHurufActivity,
                        R.color.white)

                txtTitle.setTextColor(AppCompatResources.getColorStateList(this@MenuBacaHurufActivity,
                        R.color.white))

                txtTitle.text = getString(R.string.baca_huruf)
                imageView.setOnClickListener {
                    finish()
                }
            }

            rvAbjad.apply {
                adapter = adapterAbjadMenuAdapter
                layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@MenuBacaHurufActivity, 4)
            }
        }

    }

    override fun onClick(data: Any?, position: Int?, view: View?) {
        val intent = Intent(this@MenuBacaHurufActivity, MateriBacaHurufActivity::class.java)
            .apply {
                putExtra(DATA, data as Abjad)
                putExtra("student", student)
            }
        startActivity(intent)

    }
}