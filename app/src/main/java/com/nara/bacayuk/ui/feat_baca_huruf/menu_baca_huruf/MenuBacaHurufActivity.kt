package com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.getDataAbjad
import com.nara.bacayuk.databinding.ActivityMenuBacaHurufBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.DATA
import com.nara.bacayuk.utils.invisible

class MenuBacaHurufActivity : AppCompatActivity(), AdapterListener {

    private val binding by lazy { ActivityMenuBacaHurufBinding.inflate(layoutInflater) }
    private val adapterAbjadMenuAdapter by lazy { AbjadMenuAdapter(this@MenuBacaHurufActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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