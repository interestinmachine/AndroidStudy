package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_content_frag,container,false)
    }

    fun refresh(title:String,content:String) {
        val contentLayout = view?.findViewById<LinearLayout>(R.id.contentLayout)
        val newsTitle = view?.findViewById<TextView>(R.id.newsTitle)
        val newsContent = view?.findViewById<TextView>(R.id.newsContent)
        contentLayout?.visibility = View.VISIBLE
        newsTitle?.text = title
        newsContent?.text = content
    }

}