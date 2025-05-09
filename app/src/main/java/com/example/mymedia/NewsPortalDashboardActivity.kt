package com.example.mymedia

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsPortalDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_portal_dashboard)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val listViewNews = findViewById<ListView>(R.id.listViewNews)


        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")


        tvGreeting.text = "Hello, $username"


        val newsList = listOf(
            "Berita 1: Teknologi AI terbaru...",
            "Berita 2: Android Studio Update",
            "Berita 3: Kotlin Tips & Tricks",
            "Berita 4: UI/UX Trends 2025"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, newsList)
        listViewNews.adapter = adapter
    }
}
