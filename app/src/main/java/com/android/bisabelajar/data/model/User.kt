package com.android.bisabelajar.data.model

data class User(
    val uuid: String,
    val email: String,
    val fullName: String
){
    constructor() : this("", "", "")
}