package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKalimat (
        val quizSusunKata: ArrayList<SoalKata> = addSusunKalimat(),
        val quizPilganKata: ArrayList<SoalKata> = addSusunKalimat(),
): Parcelable

fun addSusunKalimat(): ArrayList<SoalKata>{
        val list = arrayListOf<SoalKata>()
        list.add(SoalKata(1, "ibu meyapu lantai", "ibu-meyapu-lantai", false, "-", 0))
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