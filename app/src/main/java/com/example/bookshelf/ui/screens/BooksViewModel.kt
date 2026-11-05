package com.example.bookshelf.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.network.BookItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val bookSearch: List<BookItem>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BooksViewModel(private val bookshelfRepository: BookshelfRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<BooksUiState>(BooksUiState.Loading)
    val uiState: StateFlow<BooksUiState> = _uiState.asStateFlow()

    init {
        getBooks("jazz history")
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            _uiState.value = BooksUiState.Loading
            try {
                val result = bookshelfRepository.getBooks(query)
                _uiState.value = BooksUiState.Success(result)
            } catch (e: IOException) {
                _uiState.value = BooksUiState.Error
            } catch (e: HttpException) {
                _uiState.value = BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                BooksViewModel(bookshelfRepository)
            }
        }
    }
}