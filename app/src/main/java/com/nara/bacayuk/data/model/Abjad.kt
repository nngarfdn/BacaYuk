package com.nara.bacayuk.data.model

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize

@Parcelize
data class Abjad(
    var id: String = "",
    var abjadNonKapital: String = "",
    var abjadKapital: String = "",
    var suara: String = "",
    val abjadName: String = "",
    val belajarSuku: BelajarSuku? = BelajarSuku(),
    val reportHuruf: ReportHuruf? = ReportHuruf(),
    val reportKata: ReportKata? = ReportKata(),
): Parcelable

fun getAllDataAbjadNonKapital(): List<String>{
    return listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u",
            "v","w","x","y","z")
}

fun getAllDataAbjadNonKapitalNonVokal(): List<String>{
    return listOf("b","c","d","f","g","h","j","k","l","m","n","o","p","q","r","s","t",
        "v","w","x","y","z")
}

fun getAllDataAbjadKapital(): List<String>{
    return listOf("A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","Q","R","S","T","U",
            "V","W","X","Y","Z")
}

fun getTwoRandomAbjadNonKapital(tidakDiambil: String): List<String> {
    val allAbjad = getAllDataAbjadNonKapital().toMutableList()
    //remove value tidak diambil
    allAbjad.remove(tidakDiambil)
    Log.d("tidakDiambil", "$allAbjad $tidakDiambil")
    val randomIndices = (allAbjad.indices).shuffled().take(2)
    return randomIndices.map { allAbjad[it] }
}

fun getTwoRandomAbjadKapital(tidakDiambil: String): List<String> {
    val allAbjad = getAllDataAbjadKapital().toMutableList()
    //remove value tidak diambil
    allAbjad.remove(tidakDiambil)
    Log.d("tidakDiambil", "$allAbjad $tidakDiambil")
    val randomIndices = (allAbjad.indices).shuffled().take(2)
    return randomIndices.map { allAbjad[it] }
}


