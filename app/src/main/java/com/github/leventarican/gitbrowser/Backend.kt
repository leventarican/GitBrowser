package com.github.leventarican.gitbrowser

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

object Backend {
//    internal val api = "https://api.github.com/users/leventarican"
    internal val api = "https://api.github.com/users/leventarican/repos"

    fun parse(userAPI: String) : List<String> {
        var response = "not initialized"
        val result = mutableListOf<String>()
        response = URL(userAPI).readText()
//            Thread.sleep(2000)
        Log.d("#code#", "### $response")
        val userJson = JSONArray(response)
        for (i in 0 until userJson.length()) {
            val cloneUrl = userJson.getJSONObject(i).get("clone_url") as String
//                Log.d("#code#", "clone url: $cloneUrl")
            result.add(cloneUrl)
        }

        Log.d("#code#", "# ${result.size}")

        return result
    }
}