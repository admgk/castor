package com.ignismark.castor.data

data class Book(
    val title: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val thumbnail: String
)