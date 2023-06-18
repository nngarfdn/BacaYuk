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
import com.nara.bacayuk.utils.playAudioFromUrl
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import sh.tyy.wheelpicker.core.WheelPickerRecyclerView


class MateriBacaVokalActivity : AppCompatActivity(), AdapterListener,
    WheelPickerRecyclerView.WheelPickerRecyclerViewListener {
    private val binding by lazy { ActivityMateriBacaVokalBinding.inflate(layoutInflater) }
    private val bacaVocalAdapter by lazy { BacaVokalAdapter(this@MateriBacaVokalActivity) }
    var student: Student? = null
    var dataAbjad: Abjad? = null
    private val menuBacaHurufViewModel: MenuBacaHurufViewModel by viewModel()
    private var listBelajarSuku = mutableListOf<BelajarSuku>()
    private var selectedPosition = 0
    var listQuestions: MutableList<String> = mutableListOf("a","i","u","e","o")
    var lastChoice = "-"

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

//            resetVokal()

            txtAnswer.setOnClickListener {
                if (lastChoice != "-") {
                    txtAnswer.text = "-"
                    lastChoice = "-"
                    listQuestions = mutableListOf("a","i","u","e","o")
//                    resetVokal()
                }
            }

            txtAbjad.text = dataAbjad?.abjadNonKapital

            var layoutManagerA = DiscreteScrollLayoutManager(this@MateriBacaVokalActivity, object : DiscreteScrollLayoutManager.ScrollStateListener{
                override fun onIsBoundReachedFlagChange(isBoundReached: Boolean) {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

                override fun onScrollStart() {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

                override fun onScrollEnd() {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

                override fun onScroll(currentViewPosition: Float) {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

                override fun onCurrentViewFirstLayout() {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

                override fun onDataSetChangeChangedPosition() {
                    Log.d("menubaca", "onCurrentViewFirstLayout")
                }

            }, DSVOrientation.VERTICAL)

            bacaVocalAdapter.submitData(listOf("-","a", "i", "u", "e", "o"))
            rvAbjadKapital.apply {
                adapter = bacaVocalAdapter
                layoutManager = layoutManagerA
            }

            opta.opt1.text = "a"
            opti.opt1.text = "i"
            optu.opt1.text = "u"
            opte.opt1.text = "e"
            opto.opt1.text = "o"


            opta.root.setOnClickListener {
                lastChoice = "a"
                txtAnswer.text = "a"
            }
            opti.root.setOnClickListener {
                lastChoice = "i"
                txtAnswer.text = "i"
            }
            optu.root.setOnClickListener {
                lastChoice = "u"
                txtAnswer.text = "u"
            }
            opte.root.setOnClickListener {
                lastChoice = "e"
                txtAnswer.text = "e"
            }
            opto.root.setOnClickListener {
                lastChoice = "o"
                txtAnswer.text = "o"
            }

            binding.imgSound.setOnClickListener{
                for(item in listBelajarSuku){
                    if (dataAbjad?.abjadNonKapital == item.abjadName[1].toString()) {
                        Log.d("ceksound", "$lastChoice - ${item.AudioBelajarSuku.audioA} ")
                        when(lastChoice){
                            "a" -> playAudioFromUrl(item.AudioBelajarSuku.audioA)
                            "i" -> playAudioFromUrl(item.AudioBelajarSuku.audioI)
                            "u" -> playAudioFromUrl(item.AudioBelajarSuku.audioU)
                            "e" -> playAudioFromUrl(item.AudioBelajarSuku.audioE)
                            "o" -> playAudioFromUrl(item.AudioBelajarSuku.audioO)
                        }
                    }
                }
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

    private fun ActivityMateriBacaVokalBinding.resetVokal() {
        placeholder.removeAllViews()
        for (data in listQuestions) {
            val item = ItemQuizSusunBinding.inflate(layoutInflater)
            val textView = TextView(this@MateriBacaVokalActivity)
            textView.text = data

            val opt1 = TextView(this@MateriBacaVokalActivity)
            opt1.id = View.generateViewId()
//            opt1.background = ContextCompat.getDrawable(this@MateriBacaVokalActivity, com.nara.bacayuk.R.drawable.button_outline_rounded_focused_purple)
            opt1.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            opt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
            opt1.text = data
            opt1.setPadding(8,0,8,0)
            opt1.setTextColor(ContextCompat.getColor(this@MateriBacaVokalActivity, com.nara.bacayuk.R.color.teal_600))
            opt1.gravity = Gravity.CENTER
           opt1.setOnClickListener {
                lastChoice = data
                item.opt1.animate().alpha(1.0f)
                    .setDuration(500)
                    .setStartDelay((10).toLong())
                    .withEndAction {
                        binding.txtAnswer.text = data
                        lastChoice = data
                        listQuestions = mutableListOf("a","i","u","e","o")
                    }
                    .start()
            }
            placeholder.addView(opt1)
        }
    }
    
    override fun didSelectItem(position: Int) {
        selectedPosition = position
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





