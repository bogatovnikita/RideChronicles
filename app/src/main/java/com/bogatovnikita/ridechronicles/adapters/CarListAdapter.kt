package com.bogatovnikita.ridechronicles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.databinding.ItemListOfCarBinding
import com.bogatovnikita.ridechronicles.models.CarForListModel
import com.bumptech.glide.Glide

class CarListAdapter(private val onClick: (Long) -> Unit) :
    RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {

    private val dataList: MutableList<CarForListModel> = mutableListOf()

    fun setData(dataList: List<CarForListModel>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListOfCarBinding.inflate(inflater, parent, false)
        return CarListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onClick(dataList[position].id)
        }
    }

    override fun getItemCount(): Int = dataList.size

    class CarListViewHolder(private val binding: ItemListOfCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarForListModel) {
            binding.title.text = item.name

            Glide.with(itemView.context)
                .load(item.urlPhoto)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.picture)
        }
    }
}