package com.nara.bacayuk.ui.feat_riwayat.huruf

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.databinding.ItemAbjadMenuBinding
import com.nara.bacayuk.databinding.ItemRiwayatHurufBinding
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.visible


class RiwayatHurufAdapter :
    RecyclerView.Adapter<RiwayatHurufAdapter.RecentAdapterViewHolder>() {
    inner class RecentAdapterViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    private val diffCallback = object : DiffUtil.ItemCallback<Abjad>() {
        override fun areItemsTheSame(oldItem: Abjad, newItem: Abjad): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Abjad, newItem: Abjad): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(list: ArrayList<Abjad>) {

        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapterViewHolder {

        val binding =
            ItemRiwayatHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentAdapterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecentAdapterViewHolder, position: Int) {
        holder.view.apply {
            val data = differ.currentList[position]
            val report = data.reportHuruf
            Log.d("TAG", "onBindViewHolder: $data")
            val binding = ItemRiwayatHurufBinding.bind(this)
            binding.txtAbjad.text = data?.abjadNonKapital
//            binding.imgChecklist.invisible()
            binding.apply {
                txtMateriKapital.setCompoundDrawablesWithIntrinsicBounds(
                     ContextCompat.getDrawable(
                        context,
                        if (report.materiHurufKapital) R.drawable.ic_finished else R.drawable.ic_unfinished
                    ),  null, null, null
                )

                txtMateriNonkapital.setCompoundDrawablesWithIntrinsicBounds(
                     ContextCompat.getDrawable(
                        context,
                        if (report.materiHurufNonKapital) R.drawable.ic_finished else R.drawable.ic_unfinished
                    ), null, null, null
                )

                txtMateriPerbedaan.setCompoundDrawablesWithIntrinsicBounds(
                    ContextCompat.getDrawable(
                        context,
                        if (report.materiPerbedaanHuruf) R.drawable.ic_finished else R.drawable.ic_unfinished
                    ), null, null, null
                )

                txtQuizKapital.setCompoundDrawablesWithIntrinsicBounds(
                     ContextCompat.getDrawable(
                        context,
                        if (report.quizHurufKapital) R.drawable.ic_finished else R.drawable.ic_unfinished
                    ), null, null, null
                )

                txtQuizNonkapital.setCompoundDrawablesWithIntrinsicBounds(
                     ContextCompat.getDrawable(
                        context,
                        if (report.quizHurufNonKapital) R.drawable.ic_finished else R.drawable.ic_unfinished
                    ), null, null, null
                )

            }


        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}

