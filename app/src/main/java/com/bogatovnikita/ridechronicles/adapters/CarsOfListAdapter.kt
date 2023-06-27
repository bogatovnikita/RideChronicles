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
    RecyclerView.Adapter<CarsOfListAdapter.CarsOfListViewHolder>() {

    private val dataList: MutableList<CarForList> = mutableListOf()

    fun setData(dataList: List<CarForList>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsOfListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListOfCarBinding.inflate(inflater, parent, false)
        return CarsOfListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarsOfListViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onClick(dataList[position].id)
        }
    }

    override fun getItemCount(): Int = dataList.size

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
}