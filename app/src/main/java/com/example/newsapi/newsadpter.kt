package com.example.newsapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_row.view.*

class Newsadpter(val articles : ArrayList<classobject>) : RecyclerView.Adapter<Newsadpter.NewsHolder>(){
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Newsadpter.NewsHolder {
        val li = LayoutInflater.from(p0.context)
        val inflater = li.inflate(R.layout.item_row,p0, false)
        return NewsHolder(inflater)
    }

    override fun getItemCount(): Int {
        return  articles.size
    }

    override fun onBindViewHolder(newsHolder: Newsadpter.NewsHolder, p1: Int) {
        val current = articles.get(p1)
        newsHolder.itemView.tvtitle.text = current.title
        newsHolder.itemView.tvdiscription.text = current.description
        newsHolder.itemView.tvdate.text = current.publishedAt

        Picasso.get().load(current.urlToImage).into(newsHolder.itemView.ivtextimage)





    }

}
