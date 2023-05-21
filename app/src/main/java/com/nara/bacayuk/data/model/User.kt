package com.nara.bacayuk.data.model

data class User(
    val uuid: String?,
    val email: String?,
    var fullName: String?
){
    constructor() : this("", "", "")
}