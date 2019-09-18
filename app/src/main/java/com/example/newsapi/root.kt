package com.example.newsapi

import java.util.*

class root(
    val status : String,
val totalResults : Int ,
    val articles : ArrayList<classobject>
)

class classobject (
    val source : objectclass,
    val  author : String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage : String,
    val publishedAt  : String,

    val content :String
)

class objectclass(
    val id : String,
    val name :  String
)
