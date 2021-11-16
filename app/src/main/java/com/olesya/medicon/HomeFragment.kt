package com.olesya.medicon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val servicesList: List<String> = listOf(
            "Андрология, урология",
            "Гинекология, репродуктология",
            "Дерматовенерология",
            "Лабораторные анализы",
            "Лечение алкоголизма, наркология",
            "Мануальная терапия",
            "Обследование УЗИ, ЭКГ",
            "Стоматология",
            "Терапия, семейная медицина",
            "Физиотерапия",
            "Эндокринология"
        )

        val servicesRecyclerView: RecyclerView = view.findViewById(R.id.services_recycler_view)
        servicesRecyclerView.layoutManager= LinearLayoutManager(container!!.context, LinearLayoutManager.VERTICAL, false)

        servicesRecyclerView.adapter = ServicesAdapter(servicesList)

        return view
    }

}