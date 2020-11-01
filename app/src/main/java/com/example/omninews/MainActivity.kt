package com.example.omninews

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.AdapterArticle.ArticleAdapter
import com.example.omninews.AdapterTopic.TopicAdapter
import com.example.omninews.Retrofit.ApiClient
import com.example.omninews.model.Article
import com.example.omninews.model.DataFromOmni
import com.example.omninews.model.Topic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var context = this
    var itemListView : RecyclerView? = null
    var articleListView : RecyclerView? = null
    var radioGroup : RadioGroup? = null
    var editText : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextSearch)
        radioGroup = findViewById(R.id.radioGroup)
        itemListView = findViewById(R.id.itemListView)
        articleListView = findViewById(R.id.articleListView)
        val layoutManager = LinearLayoutManager(this)
        val layoutManagerArticle = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManagerArticle.orientation = LinearLayoutManager.VERTICAL
        itemListView?.layoutManager = layoutManager
        articleListView?.layoutManager = layoutManagerArticle


        //getData("stockholm")
    }

    fun getData(searchResult: String)
    {
        val call: Call<DataFromOmni> = ApiClient.getDataFromRetrofit.getDataFromOmninews("https://omni-content.omni.news/search?query="+searchResult)
        call.enqueue(object  : Callback<DataFromOmni>
        {
            override fun onResponse(
                call: Call<DataFromOmni>,
                response: Response<DataFromOmni>
            ) {

                val topicList: ArrayList<Topic> = ArrayList()
                val articleList: ArrayList<Article> = ArrayList()
                response!!.body()!!.topics.forEach{
                    topicList.add(it)
                }
                response!!.body()!!.articles.forEach {
                    articleList.add(it)
                }
                val adapter = TopicAdapter(topicList,context)
                itemListView?.adapter = adapter

                val adapterArticle = ArticleAdapter(articleList,context)
                articleListView?.adapter = adapterArticle
            }

            override fun onFailure(call: Call<DataFromOmni>, t: Throwable) {
            }
        })
    }

    fun radio_button_Article(view: View) {
        itemListView?.visibility = View.GONE
        articleListView?.visibility = View.VISIBLE
    }
    fun radio_button_topic(view: View) {
        itemListView?.visibility = View.VISIBLE
        articleListView?.visibility = View.GONE
    }

    fun onClickSearch(view: View) {
        if (!editText?.text.toString().equals(""))
        {
            getData(editText?.text.toString())
        }
    }
}