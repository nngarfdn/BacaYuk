package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKalimat (
        val quizSusunKata: ArrayList<SoalKata> = addSusunKalimat(),
        val quizPilganKata: ArrayList<SoalKata> = addLatihanBacaKalimat(),
): Parcelable

fun addSusunKalimat(): ArrayList<SoalKata> {
        val list = arrayListOf<SoalKata>()
        list.add(SoalKata(1, "ibu sapu lantai", "ibu-sapu-lantai", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%201.png?alt=media&token=35a80b63-5401-444b-be23-facb00f9b330"))
        list.add(SoalKata(2, "ayah siram bunga", "ayah-siram-bunga", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%202.png?alt=media&token=baaaf488-583f-40d3-9c43-86812a1a7e02"))
        list.add(SoalKata(3, "kakak baca buku", "kakak-baca-buku", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%203.png?alt=media&token=515bb325-cb48-4da5-ab07-ac1f5ba6fba5"))
        list.add(SoalKata(4, "adik pakai baju", "adik-pakai-baju", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%204.png?alt=media&token=150bb886-7aa5-4aeb-b0dc-ab7302284e57"))
        list.add(SoalKata(5, "ibu pakai sepatu", "ibu-pakai-sepatu", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%205.png?alt=media&token=e73b99e4-fa83-4f71-8f71-90e45de49e7d"))
        list.add(SoalKata(6, "ibu makan roti", "ibu-makan-roti", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%206.png?alt=media&token=1b0f2704-d80c-434c-b035-6de34a944d42"))
        list.add(SoalKata(7, "adik makan kue", "adik-makan-kue", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%207.png?alt=media&token=ef6bf48f-e1b5-4158-9d75-ff1fe3adeca3"))
        list.add(SoalKata(8, "adik naik sepeda", "adik-naik-sepeda", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%208.png?alt=media&token=6ac23a32-b949-45e4-b32e-d43debcdd910"))
        list.add(SoalKata(9, "ayah sedang berlari", "ayah-sedang-berlari", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%209.png?alt=media&token=6f34a6a8-7007-4d9f-91b4-d9e2dd5dcc83"))
        list.add(SoalKata(10, "adik minum susu", "adik-minum-susu", false, "-", 0, "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F03_BacaKalimat%2F3%20-%20susunKalimat%20-%2010.png?alt=media&token=892aa39f-8fc0-462c-9532-d6d50db66464"))
        return list
}

fun addLatihanBacaKalimat(): ArrayList<SoalKata> {
        val list = arrayListOf<SoalKata>()
        list.add(
                SoalKata(
                        1,
                        "adik main boneka",
                        "adik main boneka-kakak makan buah-ayah sedang berlari",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%201.png?alt=media&token=bbbe3d6b-9940-4553-89d2-ecb449601576"
                )
        )
        list.add(
                SoalKata(
                        2,
                        "ibu siram bunga",
                        "ibu siram bunga-kakak baca buku-adik main bola",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%202.png?alt=media&token=0162b6cf-3eed-48b6-98ad-08c4729e1a83"
                )
        )
        list.add(
                SoalKata(
                        3,
                        "ayah pakai sepatu",
                        "ayah pakai sepatu-ibu makan roti-kakak main boneka",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%203.png?alt=media&token=87ddc00f-3706-4599-8889-59c048c1f23e"
                )
        )
        list.add(
                SoalKata(
                        4,
                        "ibu baca buku",
                        "ibu baca buku-ayah naik sepeda-adik makan es krim",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%204.png?alt=media&token=54e8fa80-3719-44f5-ae6f-5902e8776084"
                )
        )
        list.add(
                SoalKata(
                        5,
                        "ayah pakai topi",
                        "ayah pakai topi-adik makan roti-kakak main bola",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%205.png?alt=media&token=54d00d78-4f59-4b82-982c-76ac8bd63f1c"
                )
        )
        list.add(
                SoalKata(
                        6,
                        "adik sedang berlari",
                        "adik sedang berlari-kakak makan roti-ayah siram bunga",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%207.png?alt=media&token=63a97828-2467-488d-a242-0e7341923e93"
                )
        )
        list.add(
                SoalKata(
                        7,
                        "ayah naik sepeda",
                        "ayah naik sepeda-ibu makan kue-kakak main bola",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%206.png?alt=media&token=56a7ae12-7a16-48ff-8b7e-2fbe077e639c"
                )
        )
        list.add(
                SoalKata(
                        8,
                        "adik main bola",
                        "adik main bola-kakak siram bunga-ayah baca buku",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%208.png?alt=media&token=105ddfc9-dcf3-4c41-a6bf-0d087446ee1c"
                )
        )
        list.add(
                SoalKata(
                        9,
                        "ayah baca koran",
                        "ayah baca koran-ayah main bola-ibu siram bunga",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%209.png?alt=media&token=c7d62195-8392-4229-8a51-5bd5cbeadccf"
                )
        )
        list.add(
                SoalKata(
                        10,
                        "adik makan es krim",
                        "adik makan es krim-ibu makan roti-ayah pakai topi",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/image%2F04_LatihanBacaKalimat%2F4%20-%20latihanBacaKalimat%20-%2010.png?alt=media&token=e6f207aa-1893-4d7b-9eaa-ab4d800aff2f"
                )
        )
        return list
}