package com.nara.bacayuk.data.model

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize

@Parcelize
data class Abjad(
    var id: String = "",
    var abjadNonKapital: String = "",
    var abjadKapital: String = "",
    var suara: String = ""
): Parcelable

fun getAllDataAbjadNonKapital(): List<String>{
    return listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u",
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


fun getDataAbjad(): ArrayList<Abjad> {
    val list = ArrayList<Abjad>()
    list.add(Abjad(
        id = "Aa",
        abjadNonKapital = "a",
        abjadKapital = "A",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Bb",
        abjadNonKapital = "b",
        abjadKapital = "B",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Cc",
        abjadNonKapital = "c",
        abjadKapital = "C",
        suara = "linksuara"
    ))
    list.add(Abjad(
        id = "Dd",
        abjadNonKapital = "d",
        abjadKapital = "D",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ee",
        abjadNonKapital = "e",
        abjadKapital = "E",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ff",
        abjadNonKapital = "f",
        abjadKapital = "F",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Gg",
        abjadNonKapital = "g",
        abjadKapital = "G",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Hh",
        abjadNonKapital = "h",
        abjadKapital = "H",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ii",
        abjadNonKapital = "i",
        abjadKapital = "I",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Jj",
        abjadNonKapital = "j",
        abjadKapital = "J",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Kk",
        abjadNonKapital = "k",
        abjadKapital = "K",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ll",
        abjadNonKapital = "l",
        abjadKapital = "L",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Mm",
        abjadNonKapital = "m",
        abjadKapital = "M",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Nn",
        abjadNonKapital = "n",
        abjadKapital = "N",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Oo",
        abjadNonKapital = "o",
        abjadKapital = "O",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Pp",
        abjadNonKapital = "p",
        abjadKapital = "P",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Qq",
        abjadNonKapital = "q",
        abjadKapital = "Q",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Rr",
        abjadNonKapital = "r",
        abjadKapital = "R",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ss",
        abjadNonKapital = "s",
        abjadKapital = "S",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Tt",
        abjadNonKapital = "t",
        abjadKapital = "T",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Uu",
        abjadNonKapital = "u",
        abjadKapital = "U",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Vv",
        abjadNonKapital = "v",
        abjadKapital = "V",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Ww",
        abjadNonKapital = "w",
        abjadKapital = "W",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Xx",
        abjadNonKapital = "x",
        abjadKapital = "X",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Yy",
        abjadNonKapital = "y",
        abjadKapital = "Y",
        suara = "linksuara"))
    list.add(Abjad(
        id = "Zz",
        abjadNonKapital = "z",
        abjadKapital = "Z",
        suara = "linksuara"))
    return list
}