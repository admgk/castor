package com.ignismark.castor.data

import kotlinx.serialization.Serializable

@Serializable
data class NestedJsonModel(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val id: String,
    val volumeInfo: Book
)
