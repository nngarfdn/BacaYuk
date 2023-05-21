package com.nara.bacayuk.data.model

data class ReportHuruf(
    //format "Aa" , "Bb"
    val abjadName: String = "",
    val materiHurufNonKapital:Boolean = false,
    val materiHurufKapital: Boolean = false,
    val quizHurufNonKapital: Boolean = false,
    val quizHurufKapital: Boolean = false,
)

