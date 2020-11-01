package com.example.omninews.AdapterTopic

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.R
import com.example.omninews.model.Topic

class TopicAdapter (val list:ArrayList<Topic>, val context: Context) : RecyclerView.Adapter<TopicViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_topic,parent,false)
        return TopicViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = list[position]
        holder.setData(topic,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}