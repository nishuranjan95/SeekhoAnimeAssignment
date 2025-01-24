package com.example.seekhoanimeassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seekhoanimeassignment.R
import com.example.seekhoanimeassignment.data.model.TopRatedData
import com.example.seekhoanimeassignment.databinding.SingleItemTopRatingBinding

class TopRatingAdapter(private val datalist: List<TopRatedData?>, private val onItemClick:(String) -> Unit): RecyclerView.Adapter<TopRatingAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding:SingleItemTopRatingBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int){

            Glide.with(binding.img.context)
                .load(datalist[position]?.images?.webp?.image_url)
                .placeholder(R.drawable.ds)
                .into(binding.img)
            binding.rating.text= datalist[position]?.score
            binding.title.text= datalist[position]?.title
            binding.countEp.text= "${datalist[position]?.episodes}"
            binding.root.setOnClickListener{
                datalist[position]?.mal_id?.let { it1 -> onItemClick(it1.toString()) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SingleItemTopRatingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}