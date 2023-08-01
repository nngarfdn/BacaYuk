package com.nara.bacayuk.ui.feat_baca_kata.materi

import android.R
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.marginStart
import androidx.recyclerview.widget.LinearLayoutManager
import com.nara.bacayuk.data.model.*
import com.nara.bacayuk.databinding.ActivityMateriBacaVokalBinding
import com.nara.bacayuk.databinding.ItemQuizSusunBinding
import com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf.MenuBacaHurufViewModel
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.playAudioFromRawAssetsFileString
import com.nara.bacayuk.utils.playAudioFromUrl
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import sh.tyy.wheelpicker.core.WheelPickerRecyclerView


class MateriBacaVokalActivity : AppCompatActivity()
    {
    private val binding by lazy { ActivityMateriBacaVokalBinding.inflate(layoutInflater) }
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
            toolbar.apply { 
                txtTitle.text = "Belajar Suku Kata"
                imageView.setOnClickListener { onBackPressed() }
                imgActionRight.invisible()
            }
            val abjad = dataAbjad?.abjadNonKapital
            "${abjad}a".also { opta.txtAbjad.text = it }
            "${abjad}i".also { opti.txtAbjad.text = it }
            "${abjad}u".also { optu.txtAbjad.text = it }
            "${abjad}e".also { opte.txtAbjad.text = it }
            "${abjad}o".also { opto.txtAbjad.text = it }

            opta.root.setOnClickListener {
                playAudioFromRawAssetsFileString(this@MateriBacaVokalActivity,"${abjad}_a")
            }
            opti.root.setOnClickListener {
                playAudioFromRawAssetsFileString(this@MateriBacaVokalActivity,"${abjad}_i")
            }
            optu.root.setOnClickListener {
                playAudioFromRawAssetsFileString(this@MateriBacaVokalActivity,"${abjad}_u")
            }
            opte.root.setOnClickListener {
                playAudioFromRawAssetsFileString(this@MateriBacaVokalActivity,"${abjad}_e")
            }
            opto.root.setOnClickListener {
                playAudioFromRawAssetsFileString(this@MateriBacaVokalActivity,"${abjad}_o")
            }


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
                        onBackPressed()
                        finish()
                    }
                }
            }
        }
    }



}





