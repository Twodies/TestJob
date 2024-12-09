package com.example.testjob.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.DataTicketOffer
import com.example.testjob.databinding.ItemMusicBinding

class AdapterOffers(
    private val offers: List<DataTicketOffer>
) : RecyclerView.Adapter<AdapterOffers.MusicViewHolder>() {

    class MusicViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(music: DataTicketOffer) {
            binding.item = music
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val offer = offers[position]
        holder.bind(offer)
    }

    override fun getItemCount(): Int = offers.size
}
