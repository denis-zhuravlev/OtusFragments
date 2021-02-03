package com.otus.otusfragmentsnew.recyclerTwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otus.otusfragmentsnew.R

class NewsAdapter(private val layoutInflater: LayoutInflater,
                  private val items: List<NewsItem>,
                  private val listener: ((newsItem: NewsItem) -> Unit)?) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(layoutInflater.inflate(R.layout.item_news, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            listener?.invoke(items[position])
        }
    }
}