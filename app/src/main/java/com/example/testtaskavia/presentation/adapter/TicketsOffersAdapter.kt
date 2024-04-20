package com.example.testtaskavia.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.TicketsOffer
import com.example.testtaskavia.R
import com.example.testtaskavia.databinding.TicketsOfferItemBinding
import com.example.testtaskavia.presentation.utils.ext.formatIntWithSpaces

class TicketsOffersAdapter: RecyclerView.Adapter<TicketsOffersAdapter.TicketsOffersViewHolder>() {

    var data: List<TicketsOffer> = listOf()
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }
    class TicketsOffersViewHolder(val binding: TicketsOfferItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsOffersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TicketsOfferItemBinding.inflate(inflater, parent, false)

        return TicketsOffersViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TicketsOffersViewHolder, position: Int) {
        val ticketOffer = data[position]
        val context = holder.itemView.context
        val cardColor = when(ticketOffer.id){
            1 -> context.resources.getColor(R.color.red)
            10 -> context.resources.getColor(R.color.blue)
            30 -> context.resources.getColor(R.color.white)
            else -> context.resources.getColor(R.color.white)
        }


        with(holder.binding){
            tvName.text = ticketOffer.title
            cardIcon.setCardBackgroundColor(cardColor)
            tvPrice.text = context.getString(R.string.price_pattern2, ticketOffer.price.formatIntWithSpaces())
            tvTimeRange.text = ticketOffer.timeRange.joinToString(separator = " ")
        }
    }
}