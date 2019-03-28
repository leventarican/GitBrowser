package com.github.leventarican.gitbrowser

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.github.leventarican.gitbrowser.Backend.api
import kotlin.concurrent.thread

class Overview : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview)

        Log.d("#code#", "default api: ${Backend.api}")
//        val username = intent.getStringExtra("username")
//        username?.let {
//            val api = Regex("(\\w+)\\/(repos)\$").replace(Backend.api, "$username/repos")
//            Log.d("#code#", "default api: ${Backend.api}; users api: $api")
//        }

        val repositories = findViewById<RecyclerView>(R.id.rv_repositories)
        repositories.layoutManager = LinearLayoutManager(this)
        thread {
            val items = Backend.parse(api)
            Log.d("#code#", "--- ${items.size}")
            runOnUiThread {
                repositories.adapter = RepositoryAdapter(items)
            }
        }
    }
}