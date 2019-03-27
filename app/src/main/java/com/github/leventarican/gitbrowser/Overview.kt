package com.github.leventarican.gitbrowser

import android.app.Activity
import android.os.Bundle
import android.util.Log

class Overview : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview)

        Log.d("#code#", "default api: ${Backend.api}")
        val username = intent.getStringExtra("username")
        val api = Regex("(\\w+)$").replace(Backend.api, username)
        Log.d("#code#", "default api: ${Backend.api}; users api: $api")

        Backend.parse(api)
    }
}