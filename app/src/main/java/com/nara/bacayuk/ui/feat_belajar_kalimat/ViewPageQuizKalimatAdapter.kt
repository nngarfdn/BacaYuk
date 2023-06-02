package com.nara.bacayuk.ui.feat_belajar_kalimat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nara.bacayuk.ui.feat_baca_huruf.quiz_baca_huruf.QuizFragment

class ViewPageQuizKalimatAdapter(Fa: FragmentActivity, val listener:(CharSequence)->Unit): FragmentStateAdapter(Fa) {

    private val dataFragments= mutableListOf(
        FragmentQuizKalimat.newInstance("0",listener),
    )

    init {
        generateDataFragment()
    }

    fun generateDataFragment(){
        for(i in 1..9){
            dataFragments.add(FragmentQuizKalimat.newInstance(i.toString(),listener))
        }
    }
    override fun getItemCount(): Int = dataFragments.size

    override fun createFragment(position: Int): Fragment =dataFragments[position]

}