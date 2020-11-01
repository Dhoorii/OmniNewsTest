package com.example.omninews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.AdapterParagraph.ParagraphAdapter

var WHATTYPE = "com.example.omninews.Adapter"
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var listView : RecyclerView = findViewById(R.id.articleListParagraph)
        var textView : TextView = findViewById(R.id.textViewType)


        val message = intent.getStringExtra(WHATTYPE)
        if (message.equals("TOPIC"))
        {
            var type = intent.getStringExtra("TYPE")
            textView.text = type
            textView.setTextSize(40.0F)
            listView.visibility = View.GONE
        }
        else if(message.equals("ARTICLE"))
        {
            var type = intent.getStringExtra("TYPE")
            var paragraphList = intent.getStringArrayListExtra("Paragraph") as ArrayList<String>
            val layoutManager = LinearLayoutManager(this)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            listView.layoutManager = layoutManager

            var vignetteTitle = intent.getStringExtra("VignetteTitle")
            var superTagTitle = intent.getStringExtra("SuperTagTitle")
            var superTagTopicID = intent.getStringExtra("SuperTagTopicID")
            var superTagText = intent.getStringExtra("SuperTagText")
            var color = intent.getStringExtra("Color")
            listView.visibility = View.VISIBLE
            textView.text = "Type =" + type +
                    "\r\nvignette title " + vignetteTitle +
                    "\r\nvignette bullet_color " + color +
                    "\r\nvignette supertag topic_ID " + superTagTopicID +
                    "\r\nvignette title " + superTagTitle +
                    "\r\nvignette title " + superTagText

            val adapter = ParagraphAdapter(paragraphList,this)
            listView?.adapter = adapter
        }
    }
}