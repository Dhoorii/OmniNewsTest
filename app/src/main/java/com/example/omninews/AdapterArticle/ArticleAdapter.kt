package com.example.omninews.AdapterArticle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.model.Article
import com.example.omninews.R

class ArticleAdapter (val list:ArrayList<Article>, val context: Context) : RecyclerView.Adapter<ArticleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_article,parent,false)
        return ArticleViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = list[position]
        holder.setData(article,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}