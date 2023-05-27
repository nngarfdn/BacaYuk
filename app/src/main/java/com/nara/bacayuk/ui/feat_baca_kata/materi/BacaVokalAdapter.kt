package com.nara.bacayuk.ui.feat_baca_kata.materi

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.databinding.ItemSiswaBinding
import com.nara.bacayuk.databinding.ItemVokalBinding
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.utils.loadImage


class BacaVokalAdapter(val listener: AdapterListener): RecyclerView.Adapter<BacaVokalAdapter.RecentAdapterViewHolder>() {

    var selectedVocal: String = "A"

    inner class RecentAdapterViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    private val diffCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(list: List<String>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapterViewHolder {
        //return binding
        val binding = ItemVokalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentAdapterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecentAdapterViewHolder, position: Int) {
        holder.view.apply {
            val data = differ.currentList[position]
            Log.d("TAG", "onBindViewHolder: $data")
            val binding = ItemVokalBinding.bind(this)
            binding.txtAbjad.text = data

            //if selected change border image and background text to primary_500
            if (data == selectedVocal) {
                binding.txtAbjad.setTextColor(resources.getColor(R.color.teal_600))
            } else {
                binding.txtAbjad.setTextColor(resources.getColor(R.color.unselected_vocal))
            }

//            notifyDataSetChanged()
//            listener.onClick(data, position, binding.root)
        }
    }



    override fun getItemCount(): Int = differ.currentList.size

}

