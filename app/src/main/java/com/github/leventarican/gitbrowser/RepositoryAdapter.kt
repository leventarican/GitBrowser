package com.github.leventarican.gitbrowser

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class RepositoryAdapter(private val items: List<String>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RepositoryAdapter.ViewHolder {
        return ViewHolder(TextView(p0.context))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: RepositoryAdapter.ViewHolder, p1: Int) {
        p0.textView.text = items[p1]
    }
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}