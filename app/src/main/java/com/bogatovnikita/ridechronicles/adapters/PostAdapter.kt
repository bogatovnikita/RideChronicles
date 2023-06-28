package com.bogatovnikita.ridechronicles.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.databinding.ItemPostBinding
import com.bogatovnikita.ridechronicles.models.PostModel
import com.bumptech.glide.Glide

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHoled>() {

    private val postList: MutableList<PostModel> = mutableListOf()

    fun setData(postList: List<PostModel>) {
        this.postList.clear()
        this.postList.addAll(postList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHoled {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHoled(binding)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: PostViewHoled, position: Int) {
        holder.bind(postList[position])
    }

    class PostViewHoled(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostModel) {
            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.image)

            binding.date.text = item.date
            binding.description.text = item.text
            binding.favoriteCount.text = item.likeCount.toString()
            binding.commentCount.text = item.commentCount.toString()
        }
    }
}