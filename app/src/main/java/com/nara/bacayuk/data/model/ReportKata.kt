package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKata (
    val belajarVokal: BelajarVokal = BelajarVokal(),
    val quizSusunKata: ArrayList<SoalKata> = addSusunKata(),
    val quizPilganKata: ArrayList<SoalKata> = addSusunKata(),
): Parcelable

fun addSusunKata(): ArrayList<SoalKata>{
    val list = arrayListOf<SoalKata>()
    list.add(SoalKata(1, "bola", "bo-la-ha", false, "-", 0))
    list.add(SoalKata(2, "mata", "ma-ta-du", false, "-", 0))
    list.add(SoalKata(3, "siku", "si-ku-na", false, "-", 0))
    list.add(SoalKata(4, "kaki", "ka-ki-ro", false, "-", 0))
    list.add(SoalKata(5, "meja", "me-ja-fa", false, "-", 0))
    list.add(SoalKata(6, "buku", "bu-ku-ti", false, "-", 0))
    list.add(SoalKata(7, "baju", "ba-ju-re", false, "-", 0))
    list.add(SoalKata(8, "sepeda", "se-pe-da-ko", false, "-", 0))
    list.add(SoalKata(9, "petani", "pe-ta-ni-xi", false, "-", 0))
    list.add(SoalKata(10, "celana", "ce-la-na-vo", false, "-", 0))

    return list
}


@Parcelize
data class SoalKata(
    var level: Int=1,
    var correctAnswer: String = "",
    //dipisah - //ex: ma-na-mu //kalo pilgan, sapi-babi-anjing
    var optionList: String = "",
    var isCorrect: Boolean = false,
    var studentAnswer: String = "",
    var alreadyDone: Int = 0,
    var imageUrl: String=""
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