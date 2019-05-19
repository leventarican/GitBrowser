package com.github.leventarican.gitbrowser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.main.*

class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }

    fun startBrowse(view: View) {
        val username =
            if (et_username.isBlank()) {
                et_username.hint.toString()
            } else {
                et_username.text.toString()
            }
        val intent = Intent(this, Overview::class.java).apply {
            putExtra("username", username)
        }
        startActivity(intent)
    }
}

fun EditText.isBlank() : Boolean {
    return this.text.toString().isBlank()
}