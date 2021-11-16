package com.olesya.medicon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class ServicesAdapter(private val servicesList: List<String>):
    RecyclerView.Adapter<ServicesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val servicesItemView = LayoutInflater.from(parent.context).inflate(R.layout.services_list_item,parent,false)
        return ServicesViewHolder(servicesItemView)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        val services = servicesList[position]
        holder.bind(services, position)
    }

    override fun getItemCount(): Int {
        return servicesList.size
    }
}