package com.github.leventarican.gitbrowser

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.leventarican.gitbrowser.entity.Repository

class RepositoryAdapter(private val items: MutableList<Repository>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.overview_item, parent, false) as CardView
        return ViewHolder(v)
    }

//    companion object {
//        class ViewHolder(val v: CardView) : RecyclerView.ViewHolder(v)
//    }
    class ViewHolder(val v: CardView) : RecyclerView.ViewHolder(v)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepositoryAdapter.ViewHolder, position: Int) {
        holder.v.findViewById<TextView>(R.id.name).text = items[position].name
        holder.v.findViewById<TextView>(R.id.description).text = items[position].description
        holder.v.findViewById<TextView>(R.id.updated_at).text = items[position].updatedAt
        val language = items[position].language
        holder.v.findViewById<TextView>(R.id.language).text = language
        val icon = when (language) {
            "Java" -> R.drawable.java
            "Kotlin" -> R.drawable.kotlin
            "JavaScript" -> R.drawable.js
            "Python" -> R.drawable.python
            "C++" -> R.drawable.cpp
            "HTML" -> R.drawable.html
            else -> R.drawable.git
        }
        holder.v.findViewById<ImageView>(R.id.iv_icon).setImageResource(icon)
    }

}