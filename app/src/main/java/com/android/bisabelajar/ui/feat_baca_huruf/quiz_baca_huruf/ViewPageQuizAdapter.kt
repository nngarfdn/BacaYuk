package com.android.bisabelajar.ui.feat_baca_huruf.quiz_baca_huruf

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.bisabelajar.ui.feat_baca_huruf.materi_baca_huruf.Huruf1Fragment

class ViewPageQuizAdapter(Fa: FragmentActivity, listener:(CharSequence)->Unit): FragmentStateAdapter(Fa) {
    private val dataFragments= mutableListOf(
        QuizFragment.newInstance("0",listener),
        QuizFragment.newInstance("1",listener)
    )
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =dataFragments[position]

}