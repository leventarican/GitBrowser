package com.github.leventarican.gitbrowser

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.leventarican.gitbrowser.entity.Repository

class RepositoryAdapter(private val items: MutableList<Repository>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.overview_item, parent, false) as RelativeLayout
        return ViewHolder(v)
    }

//    companion object {
//        class ViewHolder(val v: RelativeLayout) : RecyclerView.ViewHolder(v)
//    }
    class ViewHolder(val v: RelativeLayout) : RecyclerView.ViewHolder(v)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepositoryAdapter.ViewHolder, position: Int) {
        holder.v.findViewById<TextView>(R.id.clone_url).text = items[position].cloneUrl
        holder.v.findViewById<TextView>(R.id.language).text = items[position].language
        holder.v.findViewById<TextView>(R.id.updated_at).text = items[position].updatedAt
        holder.v.findViewById<TextView>(R.id.description).text = items[position].description
    }

}