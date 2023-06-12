package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKata (
    val belajarVokal: BelajarVokal = BelajarVokal(),
    val quizSusunKata: ArrayList<SoalKata> = addSusunKata(),
    val quizPilganKata: ArrayList<SoalKata> = addLatihanBacaKata(),
): Parcelable

fun addSusunKata(): ArrayList<SoalKata> {
    val list = arrayListOf<SoalKata>()
    list.add(SoalKata(1, "bola", "bo-la-ha", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%201.png?alt=media&token=4848e518-5174-4f53-b833-46e312abfee6"))
    list.add(SoalKata(2, "mata", "ma-ta-du", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%202.png?alt=media&token=03ce3f84-abd9-487e-b71f-847f7efb45f2"))
    list.add(SoalKata(3, "siku", "si-ku-na", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%203.png?alt=media&token=d027b01b-8729-4c04-a6b0-ae94ec193710"))
    list.add(SoalKata(4, "kaki", "ka-ki-ro", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%204.png?alt=media&token=2bc759aa-080e-4824-a702-dbe3b2187e0e"))
    list.add(SoalKata(5, "meja", "me-ja-fa", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%205.png?alt=media&token=59480336-3a0f-4b8a-a81d-34ce4b679d76"))
    list.add(SoalKata(6, "buku", "bu-ku-ti", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%206.png?alt=media&token=6e680cdb-6686-481e-8936-7a39a329aa36"))
    list.add(SoalKata(7, "baju", "ba-ju-re", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%207.png?alt=media&token=b359ebd5-7931-4592-a3e5-5e0f08c0ef4a"))
    list.add(SoalKata(8, "sepeda", "se-pe-da-ko", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%208.png?alt=media&token=e4318360-79a4-4087-ba91-4ffb3e18695b"))
    list.add(SoalKata(9, "petani", "pe-ta-ni-xi", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%209.png?alt=media&token=decdc317-e442-4bd9-9c4b-6a6baf493495"))
    list.add(SoalKata(10, "celana", "ce-la-na-vo", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKata%20-%2010.png?alt=media&token=2f1249bf-e042-4a0b-a55a-d9d5ddb6bd3c"))
    return list
}

fun addLatihanBacaKata(): ArrayList<SoalKata>{
    val list = arrayListOf<SoalKata>()
    list.add(SoalKata(1, "bicara", "bicara-makan-tidur-belajar", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%201.png?alt=media&token=5e4157ef-8877-4876-b83d-d00420ca2318"))
    list.add(SoalKata(2, "bumi", "bumi-bulan-matahari-pluto", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%202.png?alt=media&token=3defb464-929b-48f6-94dd-5bbabe7c8408"))
    list.add(SoalKata(3, "kota", "kota-halte-pasar-stasiun", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%203.png?alt=media&token=bfcdfdb8-7142-400e-b6f7-a0d30b176f61"))
    list.add(SoalKata(4, "desa", "desa-bandara-cafe-pasar", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%204.png?alt=media&token=8348d333-7c8b-4fba-a360-9dd5b0f255af"))
    list.add(SoalKata(5, "roti", "roti-kue-ayam-nasi", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%205.png?alt=media&token=b3f8a126-1169-4aa0-9a2f-0a04065e611b"))
    list.add(SoalKata(6, "susu", "susu-teh-soda-air", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%206.png?alt=media&token=4ef04b77-f5a6-446a-b36c-791d9ac29b64"))
    list.add(SoalKata(7, "kopi", "kopi-soda-air-susu", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%207.png?alt=media&token=e14887b9-0db1-4aa3-be4d-9ca6a4214f09"))
    list.add(SoalKata(8, "nasi", "nasi-beras-bubur-padi", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%208.png?alt=media&token=66e31948-81de-4213-8e2d-c22c53293567"))
    list.add(SoalKata(9, "gula", "gula-permen-sirup-jamu", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%209.png?alt=media&token=4b1babf6-0fca-43e8-8a2a-20fc4bb42f2f"))
    list.add(SoalKata(10, "sapi", "sapi-kuda-ikan-banteng", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKata%20-%2010.png?alt=media&token=ad2e66a1-9236-4d28-88ab-36a670d9ba22"))
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