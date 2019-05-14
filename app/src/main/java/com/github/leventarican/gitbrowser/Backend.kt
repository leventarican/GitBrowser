package com.github.leventarican.gitbrowser

import android.util.Log
import com.github.leventarican.gitbrowser.entity.Repository
import org.json.JSONArray
import java.net.URL

object Backend {
//    internal val api = "https://api.github.com/users/leventarican"
    internal val api = "https://api.github.com/users/leventarican/repos"

    fun parse(userAPI: String) : MutableList<Repository> {
        var response = "not initialized"
        val result = mutableListOf<Repository>()
        response = URL(userAPI).readText()
//            Thread.sleep(2000)
        Log.d("#code#", "### $response")
        val userJson = JSONArray(response)
        for (i in 0 until userJson.length()) {
            val jsonObject = userJson.getJSONObject(i)
            val cloneUrl = jsonObject.get("clone_url") as String
            val language = jsonObject.get("language") as? String // can be null
            val updatedAt = jsonObject.get("updated_at") as String
            val description= jsonObject.get("description") as? String
            Log.d("#code#", "clone_url: $cloneUrl; language: $language; updated_at: $updatedAt; description: $description")
            result.add(Repository(cloneUrl, language, updatedAt, description))
        }

        return result
    }
}