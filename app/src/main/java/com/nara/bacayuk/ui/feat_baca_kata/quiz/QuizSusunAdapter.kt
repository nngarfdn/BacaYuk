package com.nara.bacayuk.ui.feat_baca_kata.quiz

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nara.bacayuk.databinding.ItemAbjadMenuBinding
import com.nara.bacayuk.databinding.ItemQuizSusunBinding
import com.nara.bacayuk.ui.listener.adapter.AdapterQuizListener
import com.nara.bacayuk.ui.listener.adapter.ViewPositionListener
import com.nara.bacayuk.utils.invisible


class QuizSusunAdapter(val listener: AdapterQuizListener, val viewPosition: ViewPositionListener, val type: String) :
    RecyclerView.Adapter<QuizSusunAdapter.RecentAdapterViewHolder>() {

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

    fun submitData(list: MutableList<String>) {
        differ.submitList(list)
    }

    val items: MutableList<String> = differ.currentList.toMutableList()
    val count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapterViewHolder {

        val binding =
            ItemQuizSusunBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentAdapterViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: RecentAdapterViewHolder, position: Int) {
        holder.view.apply {
            val data = differ.currentList[position]
            Log.d("TAG", "onBindViewHolder: $data")
            val binding = ItemQuizSusunBinding.bind(this)
            binding.opt1.text = data
            binding.jwb.text = data
            viewPosition.getView(binding.root, type)
            rootView.setOnClickListener {
                listener.onClick(data, position, binding.opt1,binding.jwb, type)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}

