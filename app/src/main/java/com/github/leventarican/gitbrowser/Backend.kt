package com.github.leventarican.gitbrowser

import android.util.Log
import com.github.leventarican.gitbrowser.entity.Repository
import org.json.JSONArray
import java.net.URL

/**
 * we need only one instance of this
 */
object Backend {
    fun parse(username: String) : MutableList<Repository> {
        val api = "https://api.github.com/users/$username/repos"
        val response = URL(api).readText()
        val result = mutableListOf<Repository>()
        val userJson = JSONArray(response)
        for (i in 0 until userJson.length()) {
            val jsonObject = userJson.getJSONObject(i)
            val name = jsonObject.get("name") as String
            val description= jsonObject.get("description") as? String
            val updatedAt = jsonObject.get("updated_at") as String
            val language = jsonObject.get("language") as? String
            Log.d("#code#", "name: $name; description: $description; updated_at: $updatedAt; language: $language")
            result.add(Repository(name, description, updatedAt, language))
        }
        return result
    }
}