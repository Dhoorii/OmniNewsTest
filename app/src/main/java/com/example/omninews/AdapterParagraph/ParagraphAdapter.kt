package com.example.omninews.AdapterParagraph

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.R

class ParagraphAdapter(val list: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ParagraphViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParagraphViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_paragraph,parent,false)
        return ParagraphViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: ParagraphViewHolder, position: Int) {
        val item = list[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}