package com.nara.bacayuk.ui.feat_baca_kata.materi

import android.R
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
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
import com.nara.bacayuk.databinding.ActivityMateriBacaVokalBinding

import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import sh.tyy.wheelpicker.core.BaseWheelPickerView
import sh.tyy.wheelpicker.core.WheelPickerRecyclerView


class MateriBacaVokalActivity : AppCompatActivity(), AdapterListener,
    WheelPickerRecyclerView.WheelPickerRecyclerViewListener {
    private val binding by lazy { ActivityMateriBacaVokalBinding.inflate(layoutInflater) }
    private val bacaVocalAdapter by lazy { BacaVokalAdapter(this@MateriBacaVokalActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            var layoutManagerA = LinearLayoutManager(this@MateriBacaVokalActivity)
            bacaVocalAdapter.submitData(listOf("-","a", "i", "u", "e", "o"))
            rvAbjadKapital.apply {
                adapter = bacaVocalAdapter
                layoutManager = layoutManagerA
            }

            rvAbjadKapital.setWheelListener(this@MateriBacaVokalActivity)
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

    override fun onClick(data: Any?, position: Int?, view: View?) {
        Log.d("onclick", "onClick:  $position")

    }

}





