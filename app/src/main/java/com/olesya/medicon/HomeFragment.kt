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

        val bannerList: List<Banner> = listOf(
            Banner(R.drawable.ban_covid, "ул.Баныкина, 32А, 2 этаж, офис 21"),
            Banner(R.drawable.ban_teeth, "+7 (8482) 26-05-00"),
            Banner(R.drawable.ban_ban, "ул.Баныкина, 32А, 2 этаж, офис 21"),
            Banner(R.drawable.ban_covid, "+7 (8482) 26-05-00"),
            Banner(R.drawable.ban_teeth, "ул.Баныкина, 32А, 2 этаж, офис 21"),
            Banner(R.drawable.ban_ban, "+7 (8482) 26-33-00")
        )

        val servicesRecyclerView: RecyclerView = view.findViewById(R.id.services_recycler_view)
        val bannerRecyclerView: RecyclerView = view.findViewById(R.id.banner_recycler_view)
        servicesRecyclerView.layoutManager= LinearLayoutManager(container!!.context, LinearLayoutManager.VERTICAL, false)
        servicesRecyclerView.adapter = ServicesAdapter(servicesList)

        bannerRecyclerView.layoutManager = LinearLayoutManager(container!!.context, LinearLayoutManager.HORIZONTAL,false)
        bannerRecyclerView.adapter = BannerAdapter(bannerList)

        return view
    }

}

//Adapter  = View on RecyclerView
//ViewHolder  = data on View