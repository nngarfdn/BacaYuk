package com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(Fa: FragmentActivity, listener:(CharSequence)->Unit): FragmentStateAdapter(Fa) {
    private val dataFragments= mutableListOf(
        Huruf1Fragment.newInstance("0",listener),
        Huruf1Fragment.newInstance("1",listener),
        Huruf1Fragment.newInstance("2",listener)
    )
    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment =dataFragments[position]
}