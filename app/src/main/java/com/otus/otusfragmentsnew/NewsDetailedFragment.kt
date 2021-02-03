package com.otus.otusfragmentsnew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsDetailedFragment : Fragment() {
    companion object {
        const val TAG = "NewsDetailedFragment"
        const val EXTRA_TITLE = "EXTRA_TITLE"

        fun newInstance(title: String): NewsDetailedFragment {
            val args = Bundle()
            args.putString(EXTRA_TITLE, title)

            val fragment = NewsDetailedFragment()
            fragment.arguments = args
            return fragment
        }

        fun newInstanceKotlin(title: String): NewsDetailedFragment {
            return NewsDetailedFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TITLE, title)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as TextView).text = arguments?.getString(EXTRA_TITLE) ?: "default"
    }
}