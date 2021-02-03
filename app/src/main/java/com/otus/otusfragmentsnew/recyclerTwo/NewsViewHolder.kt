package com.otus.otusfragmentsnew.recyclerTwo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: NewsItem) {
        (itemView as TextView).text = item.title
    }
}