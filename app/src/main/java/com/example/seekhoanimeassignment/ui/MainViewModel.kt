package com.example.seekhoanimeassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoanimeassignment.State
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import com.example.seekhoanimeassignment.data.repository.TopRatedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class MainViewModel(private val repository: TopRatedRepository) :ViewModel() {

    private val _TopRatedData = MutableStateFlow<State<TopRatedResponse>>(State.Loading("loading"))
    val topRatedData: StateFlow<State<TopRatedResponse>>
        get() = _TopRatedData

    fun fetchData() {
        viewModelScope.launch {
            repository.getTopRatedAnime()
                .catch { ex->
                    _TopRatedData.value=State.Failure(ex.toString())
                }
                .collect{
                    _TopRatedData.value=State.Success(it)
                }

        }
    }

}