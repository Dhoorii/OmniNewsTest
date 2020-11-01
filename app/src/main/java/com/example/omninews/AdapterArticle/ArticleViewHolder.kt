package com.example.omninews.AdapterArticle

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omninews.AdapterTopic.WHATTYPE
import com.example.omninews.DetailsActivity
import com.example.omninews.R
import com.example.omninews.model.Article
import com.squareup.picasso.Picasso

class ArticleViewHolder(itemView: View, val context: Context):RecyclerView.ViewHolder(itemView)
{
    val URLPhoto: String = "https://gfx-android.omni.se/images/"
    private var mTitleView: TextView? = null
    private var mImageView: ImageView? = null
    var currectArticle: Article? = null
    var currentPosition: Int = 0
    init {
        mTitleView = itemView.findViewById(R.id.textViewTitleArticle)
        mImageView = itemView.findViewById(R.id.imageView)
        itemView.setOnClickListener{
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra(WHATTYPE, "ARTICLE")
                putExtra("TYPE", currectArticle!!.main_text.type)
                val arrayList : ArrayList<String> = ArrayList()
                currectArticle!!.main_text.paragraphs.forEach{
                    arrayList.add(it.text.value)
                }
                putExtra("Paragraph",arrayList)
                putExtra("VignetteTitle", currectArticle!!.main_text.vignette.title)
                putExtra("SuperTagTitle", currectArticle?.main_text?.vignette?.supertag?.title)
                putExtra("SuperTagTopicID", currectArticle!!.main_text?.vignette?.supertag?.topic_id)
                putExtra("SuperTagText", currectArticle!!.main_text?.vignette?.supertag?.text)
                putExtra("Color", "RED "+currectArticle!!.main_text.vignette.bullet_color.red + " GREEN "+currectArticle!!.main_text.vignette.bullet_color.green+" BLUE "+currectArticle!!.main_text.vignette.bullet_color.blue)
            }
            context.startActivity(intent)
        }
    }

    fun setData(article: Article, pos: Int)
    {
        this.currectArticle = article
        this.currentPosition = pos
        mTitleView?.text = article.title.value
        if (article.main_resource.type.equals("Image"))
        {
            Picasso.with(context).load(URLPhoto+article.main_resource.image_asset.id).into(mImageView)
        }

    }
}