package com.otus.otusfragmentsnew

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.otus.otusfragmentsnew.recyclerTwo.NewsAdapter
import com.otus.otusfragmentsnew.recyclerTwo.NewsItem

class NewsListFragment : Fragment() {
    companion object {
        const val TAG = "NewsListFragment"
    }

    // 4. хороший
    /*var listener: OnNewsClickListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity is OnNewsClickListener) {
            listener = activity as OnNewsClickListener
        } else {
            throw Exception("Activity must implement OnNewsClickListener")
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<RecyclerView>(R.id.recyclerView)
            .adapter = NewsAdapter(
            LayoutInflater.from(requireContext()), listOf(
                NewsItem(0, "News 0"),
                NewsItem(1, "News 1"),
                NewsItem(2, "News 2"),
                NewsItem(3, "News 3"),
                NewsItem(4, "News 4")
            )
        ) {
            // 1. (activity as MainActivity).openNewsDetailed() плохо
            // 2. listener?.onNewsClick(it) ну такое

            // 4.1
            (activity as? OnNewsClickListener)?.onNewsClick(it)

        }
    }

    interface OnNewsClickListener {
        fun onNewsClick(newsItem: NewsItem)
    }
}