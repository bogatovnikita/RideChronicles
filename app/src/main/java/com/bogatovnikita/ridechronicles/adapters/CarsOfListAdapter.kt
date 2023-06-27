package com.bogatovnikita.ridechronicles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.databinding.ItemListOfCarBinding
import com.bogatovnikita.ridechronicles.models.CarForList
import com.bumptech.glide.Glide

class CarsOfListAdapter(private val onClick: (Long) -> Unit) :
    ListAdapter<CarForList, CarsOfListAdapter.CarsOfListViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsOfListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListOfCarBinding.inflate(inflater, parent, false)
        return CarsOfListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarsOfListViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClick(getItem(position).id)
        }
    }

    class CarsOfListViewHolder(private val binding: ItemListOfCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarForList) {
            binding.title.text = item.name

            Glide.with(itemView.context)
                .load(item.urlPhoto)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.picture)
        }
    }

    object ItemCallback : DiffUtil.ItemCallback<CarForList>() {
        override fun areItemsTheSame(oldItem: CarForList, newItem: CarForList) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CarForList, newItem: CarForList) =
            oldItem == newItem

    }

}