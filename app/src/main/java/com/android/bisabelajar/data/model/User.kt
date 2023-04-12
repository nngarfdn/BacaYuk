package com.android.bisabelajar.data.model

data class User(
    val id: String,
    val email: String,
    val fullName: String
){
    constructor() : this("", "", "")
}