package com.android.bisabelajar.ui.feat_baca_huruf.menu_baca_huruf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.android.bisabelajar.R
import com.android.bisabelajar.data.model.Abjad
import com.android.bisabelajar.data.model.getDataAbjad
import com.android.bisabelajar.databinding.ActivityMenuBacaHurufBinding
import com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.android.bisabelajar.ui.listener.adapter.AdapterListener
import com.android.bisabelajar.utils.DATA
import com.android.bisabelajar.utils.openActivity

class MenuBacaHurufActivity : AppCompatActivity(), AdapterListener {

    private val binding by lazy { ActivityMenuBacaHurufBinding.inflate(layoutInflater) }
    private val adapterAbjadMenuAdapter by lazy { AbjadMenuAdapter(this@MenuBacaHurufActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            toolbarAction.apply {
                //change bg rootview to teal_600
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
            adapterAbjadMenuAdapter.submitData(getDataAbjad())
            rvAbjad.apply {
                adapter = adapterAbjadMenuAdapter
                layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@MenuBacaHurufActivity, 4)
            }
        }

    }

    override fun onClick(data: Any?, position: Int?, view: View?) {
        val intent = Intent(this@MenuBacaHurufActivity, MateriBacaHurufActivity::class.java)
            .apply { putExtra(DATA, data as Abjad) }
        startActivity(intent)

    }
}