package com.olesya.medicon

import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ServicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(services: String, position: Int){
        val servicesButton: Button = itemView.findViewById(R.id.services_list_button)
        servicesButton.text = services
    }
}