package com.example.mythirdapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val res = resources
        val myListView: ListView = findViewById(R.id.myListView)
        val items = res.getStringArray(R.array.items)
        val prices = res.getStringArray(R.array.prices)
        val descriptions = res.getStringArray(R.array.descriptions)

        val itemAdapter = ItemAdapter(this, items, prices, descriptions)
        myListView.adapter = itemAdapter


        myListView.setOnItemClickListener { adapterView, view, i, l ->
            val showDetailActivity = Intent(this, DetailActivity::class.java)
            showDetailActivity.putExtra("com.example.mythirdapplication.ITEM_INDEX", i)
            startActivity(showDetailActivity)
        }

    }
}