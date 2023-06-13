package com.nara.bacayuk.ui.feat_baca_kata.quiz

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nara.bacayuk.data.model.SoalKata
import com.nara.bacayuk.databinding.ItemAbjadMenuBinding
import com.nara.bacayuk.ui.listener.adapter.AdapterListener
import com.nara.bacayuk.ui.listener.adapter.AdapterQuizListener
import com.nara.bacayuk.utils.invisible
import com.nara.bacayuk.utils.visible


class QuizMenuAdapter(val listener: AdapterListener, val type: String) :
    RecyclerView.Adapter<QuizMenuAdapter.RecentAdapterViewHolder>() {

    inner class RecentAdapterViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    private val diffCallback = object : DiffUtil.ItemCallback<SoalKata>() {
        override fun areItemsTheSame(oldItem: SoalKata, newItem: SoalKata): Boolean {
            return oldItem.level == newItem.level
        }

        override fun areContentsTheSame(oldItem: SoalKata, newItem: SoalKata): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }


    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(list: ArrayList<SoalKata>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapterViewHolder {

        val binding =
            ItemAbjadMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentAdapterViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: RecentAdapterViewHolder, position: Int) {
        holder.view.apply {
            val data = differ.currentList[position]
            Log.d("TAG", "onBindViewHolder: $data")
            val binding = ItemAbjadMenuBinding.bind(this)
            binding.txtAbjad.text = (position + 1).toString()
            binding.imgChecklist.invisible()
            Log.d("isDone", "onBindViewHolder: ${data.alreadyDone}")

            if (data.isCorrect
            ) {
                binding.imgChecklist.visible()
            } else {
                binding.imgChecklist.invisible()
            }

            rootView.setOnClickListener {
                listener.onClick(data, position, binding.root,type)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}

