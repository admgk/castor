package com.ignismark.castor.data.local

import com.ignismark.castor.data.Book
import com.ignismark.castor.data.BookItem
import com.ignismark.castor.data.ImageLinks

object LocalBookDataProvider {
    val book = listOf(
        BookItem(
            id = "mockId",
            volumeInfo = Book(
                title = "Check Internet connection",
                authors = emptyList(),
                publisher = "",
                publishedDate = "",
                imageLinks = ImageLinks(
                    smallThumbnail = "",
                    thumbnail = ""
                )
            )
        )
    )
}