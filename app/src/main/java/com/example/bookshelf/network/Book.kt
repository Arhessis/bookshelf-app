package com.example.bookshelf.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class BookQueryResponse(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    @SerialName("imageLinks") val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String = "",
    val localDrawableRes: Int? = null
) {
    val httpsThumbnail: String
        get() = thumbnail.replace("http:", "https:")
}