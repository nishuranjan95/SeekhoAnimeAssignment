package com.example.seekhoanimeassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoanimeassignment.State
import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import com.example.seekhoanimeassignment.data.repository.AnimeDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class DetailsViewModel(private val repository: AnimeDetailsRepository) :ViewModel() {

    private val _detailData = MutableStateFlow<State<AnimeDetailResponse>>(State.Loading("loading"))
    val detailData: StateFlow<State<AnimeDetailResponse>>
        get() = _detailData

    fun fetchData(mail_id:String) {
        viewModelScope.launch {
            repository.getAnimeDetail(mail_id)
                .catch { ex->
                    _detailData.value=State.Failure(ex.toString())
                }
                .collect{
                    _detailData.value=State.Success(it)
                }

        }
    }

}