package com.nara.bacayuk.data.model

data class ReportKalimat (
        val level: String,
        val correctAnswer: String = "",
        //dipisah - //ex: ma-na-mu //kalo pilgan, sapi-babi-anjing
        val optionList: String = "",
        var isCorrect: Boolean = false,
        var studentAnswer: String = "",
        val isAlreadyDone: Boolean = false,
)