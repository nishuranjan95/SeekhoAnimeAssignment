package com.example.seekhoanimeassignment

sealed interface State<out T> {
    data class Success<T>(var data:T):State<T>
    data class Failure(var error:String):State<Nothing>
    data class Loading(val msg: String):State<Nothing>
}