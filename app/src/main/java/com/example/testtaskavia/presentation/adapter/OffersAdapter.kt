package com.example.testtaskavia.presentation.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Offer
import com.example.testtaskavia.R
import com.example.testtaskavia.databinding.FragmentAirTicketsBinding
import com.example.testtaskavia.databinding.OfferCardBinding
import com.example.testtaskavia.presentation.utils.ext.formatIntWithSpaces

class OffersAdapter: RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    var data: List<Offer> = listOf()
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }
    class OffersViewHolder(val binding: OfferCardBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OfferCardBinding.inflate(inflater, parent, false)

        return OffersViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val offer = data[position]
        val context = holder.itemView.context
        val imgId = when(offer.id){
            1 -> R.drawable.img1
            2 -> R.drawable.img2
            3 -> R.drawable.img3
            else -> R.drawable.img1
        }

        with(holder.binding){
            tvName.text = offer.title
            tvCity.text = offer.town
            tvPrice.text = context.getString(R.string.price_pattern, offer.price.formatIntWithSpaces())

            Glide
                .with(context)
                .load(imgId)
                .transform()
                .centerCrop()
                .into(imgOffer);
        }
    }
}