package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKata (
    val belajarVokal: BelajarVokal = BelajarVokal(),
    val quizSusunKata: ArrayList<SoalKata> = arrayListOf(),
    val quizPilganKata: ArrayList<SoalKata> = arrayListOf(),
): Parcelable

@Parcelize
data class SoalKata(
    val correctAnswer: String = "",
    //dipisah - //ex: ma-na-mu //kalo pilgan, sapi-babi-anjing
    val optionList: String = "",
    var isCorrect: Boolean = false,
    var studentAnswer: String = "",
    val isAlreadyDone: Boolean = false,
): Parcelable
@Parcelize
data class BelajarVokal (
    var isADone: Boolean = false,
    var isIDone: Boolean = false,
    var isUDone: Boolean = false,
    var isEDone: Boolean = false,
    var isODone: Boolean = false,
): Parcelable
@Parcelize
class BelajarSuku (
        var abjadName: String = "",
        val belajarVokal: BelajarVokal = BelajarVokal()
): Parcelable