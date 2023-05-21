package com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.databinding.ItemAbjadMenuBinding
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.invisible


class AbjadMenuAdapter(val listener: AdapterListener): RecyclerView.Adapter<AbjadMenuAdapter.RecentAdapterViewHolder>() {
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

        differ.submitList(list) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapterViewHolder {
        //return binding
        val binding = ItemAbjadMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentAdapterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecentAdapterViewHolder, position: Int) {
        holder.view.apply {
            val data = differ.currentList[position]
            Log.d("TAG", "onBindViewHolder: $data")
            val binding = ItemAbjadMenuBinding.bind(this)
            binding.txtAbjad.text = data?.abjadKapital
            binding.imgChecklist.invisible()
//            if (position < 10) {
//                binding.imgChecklist.visible()
//            } else {
//                binding.imgChecklist.invisible()
//            }
            rootView.setOnClickListener {
                listener.onClick(data, position, binding.root)
            }
        }
    }



    override fun getItemCount(): Int = differ.currentList.size

}

