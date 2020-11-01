package com.example.omninews.model

import com.google.gson.annotations.SerializedName

//Data from OmniApi
data class DataFromOmni(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("topics")
    val topics: List<Topic>)

//Topic Structure

data class Topic(
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type:String)

//Article Structure
data class Article(
    @SerializedName("title")
    val title: Title,
    @SerializedName("main_resource")
    val main_resource:Main_resource,
    @SerializedName("main_text")
    val main_text:Main_text
)

data class Title(
    @SerializedName("value")
    val value: String
)

data class Main_resource(
    @SerializedName("image_asset")
    val image_asset: Image_asset,
    @SerializedName("type")
    val type: String
)

data class Image_asset(
    @SerializedName("id")
    val id: String
)

data class Main_text(
    @SerializedName("type")
    val type: String,
    @SerializedName("paragraphs")
    val paragraphs: ArrayList<Paragraphs>,
    @SerializedName("vignette")
    val vignette: Vignette
)

data class Paragraphs(
    @SerializedName("text")
    val text: Text,
    @SerializedName("block_type")
    val block_type: String
)
data class Vignette(
    @SerializedName("title")
    val title: String,
    @SerializedName("bullet_color")
    val bullet_color: Bullet_color,
    @SerializedName("supertag")
    val supertag: Supertag
)
data class Bullet_color(
    @SerializedName("red")
    val red: String,
    @SerializedName("green")
    val green: String,
    @SerializedName("blue")
    val blue: String
)
data class Supertag(
    @SerializedName("topic_id")
    val topic_id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("text")
    val text: String
)
data class Text(
    @SerializedName("value")
    val value: String
)