package com.github.leventarican.gitbrowser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.main.*

class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }

    fun startBrowse(view: View) {
        val intent = Intent(this, Overview::class.java).apply {
            putExtra("username", et_username.text.toString())
        }
        startActivity(intent)
    }
}