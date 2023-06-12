package com.nara.bacayuk.ui.feat_baca_kata.materi

import android.R
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.math.MathUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.nara.bacayuk.data.model.*
import com.nara.bacayuk.databinding.ActivityMateriBacaVokalBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufViewModel
import com.nara.bacayuk.ui.feat_baca_kata.quiz.QuizViewModel

import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.DATA
import org.koin.androidx.viewmodel.ext.android.viewModel
import sh.tyy.wheelpicker.core.BaseWheelPickerView
import sh.tyy.wheelpicker.core.WheelPickerRecyclerView


class MateriBacaVokalActivity : AppCompatActivity(), AdapterListener,
    WheelPickerRecyclerView.WheelPickerRecyclerViewListener {
    private val binding by lazy { ActivityMateriBacaVokalBinding.inflate(layoutInflater) }
    private val bacaVocalAdapter by lazy { BacaVokalAdapter(this@MateriBacaVokalActivity) }
    var student: Student? = null
    var dataAbjad: Abjad? = null
    private val menuBacaHurufViewModel: MenuBacaHurufViewModel by viewModel()
    private var listBelajarSuku = mutableListOf<BelajarSuku>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataAbjad = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(DATA, Abjad::class.java)
        } else {
            intent.getParcelableExtra(DATA) as Abjad?
        }

        student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            intent.getParcelableExtra("student") as Student?
        }

        menuBacaHurufViewModel.getAllBelajarVokal(student?.uuid ?: "-")

        menuBacaHurufViewModel.vokals.observe(this@MateriBacaVokalActivity) { response ->
            when (response) {
                is Response.Success -> {
                    listBelajarSuku = response.data.toMutableList()
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

            txtAbjad.text = dataAbjad?.abjadNonKapital
            var layoutManagerA = LinearLayoutManager(this@MateriBacaVokalActivity)
            bacaVocalAdapter.submitData(listOf("-","a", "i", "u", "e", "o"))
            rvAbjadKapital.apply {
                adapter = bacaVocalAdapter
                layoutManager = layoutManagerA
            }

            rvAbjadKapital.setWheelListener(this@MateriBacaVokalActivity)

            btnSelect.setOnClickListener {
                Log.d("menubaca", "select luar: ${dataAbjad?.abjadNonKapital} ")
                for(item in listBelajarSuku){
                    if (dataAbjad?.abjadNonKapital == item.abjadName[1].toString()) {
                        //todo call viewmodel update
                        Log.d("menubaca", "select luar: ${dataAbjad?.abjadName}  ${item.abjadName}")
                        item.belajarVokal.isADone = true
                        item.belajarVokal.isIDone = true
                        item.belajarVokal.isUDone = true
                        item.belajarVokal.isEDone = true
                        item.belajarVokal.isODone = true
                        menuBacaHurufViewModel.updateBelajarSuku(student?.uuid?: "-", item)
                    }
                }
            }
        }

    }

    override fun didSelectItem(position: Int) {
        when (position) {
            0 -> {

            }
            1 -> {
                bacaVocalAdapter.selectedVocal = "a"
                bacaVocalAdapter.notifyDataSetChanged()
            }
            2 -> {
                bacaVocalAdapter.selectedVocal = "i"
                bacaVocalAdapter.notifyDataSetChanged()
            }
            3 -> {
                bacaVocalAdapter.selectedVocal = "u"
                bacaVocalAdapter.notifyDataSetChanged()
            }
            4 -> {
                bacaVocalAdapter.selectedVocal = "e"
                bacaVocalAdapter.notifyDataSetChanged()
            }
            5 -> {
                bacaVocalAdapter.selectedVocal = "o"
                bacaVocalAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onClick(data: Any?, position: Int?, view: View?, type: String) {
        Log.d("menubaca", "data clicked")

    }

}





