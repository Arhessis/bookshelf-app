package com.example.bookshelf.data

import com.example.bookshelf.R
import com.example.bookshelf.network.BookItem
import com.example.bookshelf.network.ImageLinks
import com.example.bookshelf.network.VolumeInfo

class FakeBookshelfRepository : BookshelfRepository {
    override suspend fun getBooks(query: String): List<BookItem> {
        return listOf(
            BookItem(
                id = "1",
                volumeInfo = VolumeInfo(
                    title = "Project Hail Mary",
                    imageLinks = ImageLinks(thumbnail = "", localDrawableRes = R.drawable.book_cover_1)
                )
            ),
            BookItem(
                id = "2",
                volumeInfo = VolumeInfo(
                    title = "The Odyssey",
                    imageLinks = ImageLinks(thumbnail = "", localDrawableRes = R.drawable.book_cover_2)
                )
            ),
            BookItem(
                id = "3",
                volumeInfo = VolumeInfo(
                    title = "Dune",
                    imageLinks = ImageLinks(thumbnail = "", localDrawableRes = R.drawable.book_cover_3)
                )
            )
        )
    }
}