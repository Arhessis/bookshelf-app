# Bookshelf App - Jetpack Compose

An Android application built with Jetpack Compose that queries the Google Books API to search, browse, and display book collections. Developed as part of Unit 5 of Google's *Android Basics with Compose* curriculum to demonstrate modern Android networking, asynchronous data handling, and repository architecture.

---

## ✨ Features

- **Google Books REST API Integration:** Fetches real-time book metadata and cover images using Retrofit and Kotlin Serialization.
- **Asynchronous Image Loading:** Loads and caches book cover thumbnails asynchronously using Coil.
- **Repository Architecture:** Decouples network data retrieval from the presentation layer through a clean Repository pattern and Dependency Injection (AppContainer).
- **UI State Management:** Handles Loading, Success, and Error states cleanly with Kotlin `StateFlow` and Compose UI.
- **Material 3 Design:** Displays books in an adaptive scrollable grid with high-quality Material 3 cards and typography.

---

## 🛠️ Architecture & Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose (Material 3)
- **Networking:** Retrofit 2 & OkHttp 3
- **Serialization:** Kotlinx Serialization (JSON parsing)
- **Image Loading:** Coil Compose
- **Concurrency:** Kotlin Coroutines
- **Pattern:** Model-View-ViewModel (MVVM) + Repository Pattern + Unidirectional Data Flow (UDF)

---

## 📂 Project Architecture Overview

```text
com.example.bookshelf/
│
├── data/
│   ├── AppContainer.kt          # Manual Dependency Injection container
│   ├── BookshelfRepository.kt   # Repository interface and implementation
│   └── BookshelfApplication.kt  # Application class providing container access
│
├── network/
│   ├── BooksApiService.kt       # Retrofit service interface definition
│   └── Book.kt                  # Kotlinx Serialization data transfer objects (DTOs)
│
├── ui/
│   ├── screens/                 # BooksGridScreen, ErrorScreen, LoadingScreen
│   ├── BooksViewModel.kt        # ViewModel managing UI state and API requests
│   └── BookshelfApp.kt          # Top-level Scaffold and navigation layout
│
└── MainActivity.kt              # App entry point
