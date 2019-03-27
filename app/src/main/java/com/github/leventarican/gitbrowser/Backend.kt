package com.github.leventarican.gitbrowser

import android.util.Log
import org.json.JSONObject
import java.net.URL

object Backend {
    internal val api = "https://api.github.com/users/leventarican"

    fun parse(userAPI: String) {
        var response = "not initialized"
        Thread(Runnable {
            response = URL(userAPI).readText()
            Thread.sleep(2000)
            Log.d("#code#", "### $response")

            val userJson = JSONObject(response)
            Log.d("#code#", "public repos: ${userJson.get("public_repos")}")
        }).start()
    }
}