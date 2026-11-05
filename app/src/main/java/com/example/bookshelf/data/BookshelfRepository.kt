package com.example.bookshelf.data

import com.example.bookshelf.network.BookItem
import com.example.bookshelf.network.BooksApiService

interface BookshelfRepository {
    suspend fun getBooks(query: String): List<BookItem>
}

class DefaultBookshelfRepository(
    private val booksApiService: BooksApiService
) : BookshelfRepository {
    override suspend fun getBooks(query: String): List<BookItem> {
        return booksApiService.getBooks(query).items
    }
}