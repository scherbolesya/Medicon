package com.olesya.medicon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationMenu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        bottomNavigationMenu.setOnItemReselectedListener{ item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> {
                    fragment = HomeFragment()

                }
                R.id.share -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, "Скачай приложение Medicon по ссылке")
                    val chooser = Intent.createChooser(intent, "Поделиться!!!")
                    startActivity(chooser)
                    fragment = HomeFragment()
                }
                R.id.contact -> {
                    fragment = ContactFragment()
                }
                R.id.menu -> {
                    fragment = MenuFragment()
                }

            }
            replacefragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM)?:R.id.home
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    private fun replacefragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}