package com.example.omninews.AdapterTopic

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.DetailsActivity
import com.example.omninews.R
import com.example.omninews.model.Topic

var WHATTYPE = "com.example.omninews.Adapter"
class TopicViewHolder(itemView: View,val context: Context):RecyclerView.ViewHolder(itemView)
{
    private var mTitleView: TextView? = null
    var currectTopic: Topic? = null
    var currentPosition: Int = 0
    init {
        mTitleView = itemView.findViewById(R.id.textViewText)
        itemView.setOnClickListener{
            Toast.makeText(context, currectTopic!!.title+ " ",Toast.LENGTH_SHORT).show()
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra(WHATTYPE, "TOPIC")
                putExtra("TYPE", currectTopic!!.type)
            }
            context.startActivity(intent)
        }
    }

    fun setData(topic: Topic, pos: Int)
    {
        this.currectTopic = topic
        this.currentPosition = pos
        mTitleView?.text = topic.title
    }
}