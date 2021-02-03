package com.otus.otusfragmentsnew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.otus.otusfragmentsnew.recyclerTwo.NewsItem

class MainActivity : AppCompatActivity(), NewsListFragment.OnNewsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openNewsList()
    }

    private fun openNewsDetailed(newsItem: NewsItem) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, NewsDetailedFragment.newInstance(newsItem.title), NewsDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }


    private fun openNewsList() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,  NewsListFragment(), NewsListFragment.TAG)
            .commit()
    }

    // 3. довольно хороший
    /*override fun onAttachFragment(fragment: Fragment) {
        if (fragment is NewsListFragment) {
            fragment.listener = this
        }
    }*/

    override fun onNewsClick(newsItem: NewsItem) {
        openNewsDetailed(newsItem)
    }

    override fun onBackPressed() {
        //super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            //Toast.makeText(this, "Уверены, что хотите выйти?", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
