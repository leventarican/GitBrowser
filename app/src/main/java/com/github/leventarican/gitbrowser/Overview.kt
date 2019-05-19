package com.github.leventarican.gitbrowser

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlin.concurrent.thread

class Overview : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview)

        val username = intent.getStringExtra("username")
        val repositories = findViewById<RecyclerView>(R.id.rv_repositories)
        repositories.layoutManager = LinearLayoutManager(this)
        thread {
            val items = Backend.parse(username)
            runOnUiThread {
                repositories.adapter = RepositoryAdapter(items)
            }
        }
    }
}