package com.example.omninews.AdapterParagraph

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.R

class ParagraphViewHolder(itemView: View, val context: Context):RecyclerView.ViewHolder(itemView)
{
    private var mTitleView: TextView? = null
    init {
        mTitleView = itemView.findViewById(R.id.textViewText)
    }

    fun setData(item: String)
    {
        mTitleView?.text = item
    }
}