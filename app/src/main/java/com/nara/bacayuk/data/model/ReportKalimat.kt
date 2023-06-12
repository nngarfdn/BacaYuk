package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportKalimat (
        val quizSusunKata: ArrayList<SoalKata> = addSusunKalimat(),
        val quizPilganKata: ArrayList<SoalKata> = addLatihanBacaKalimat(),
): Parcelable

fun addSusunKalimat(): ArrayList<SoalKata>{
        val list = arrayListOf<SoalKata>()
        list.add(SoalKata(1, "ibu menyapu lantai", "ibu-menyapu-lantai", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%201.png?alt=media&token=aaa2f302-8b95-4d85-88de-50ae8d7cc358"))
        list.add(SoalKata(2, "ayah menyiram bunga", "ayah-menyiram-bunga", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%202.png?alt=media&token=ae66c58b-7c4f-4977-a8f9-6aaf22eb344b"))
        list.add(SoalKata(3, "kakak membaca buku", "kakak-membaca-buku", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%203.png?alt=media&token=874b1876-54d1-4b7c-ab19-af9ebaebb579"))
        list.add(SoalKata(4, "kakak sedang sikat gigi", "kakak-sedang-sikat-gigi", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%204.png?alt=media&token=6412c9d1-ed85-4065-98a0-ec67c0ce7b0d"))
        list.add(SoalKata(5, "hujan sangat lebat", "hujan-sangat-lebat", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%205.png?alt=media&token=3ff12b5b-8957-4de2-b99c-1b7b6b02d3bc"))
        list.add(SoalKata(6, "ibu memasak sayur", "ibu-memasak-sayur", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%206.png?alt=media&token=32ea2232-9204-4d34-a1e0-694d8d8cdda9"))
        list.add(SoalKata(7, "pesawat terbang tinggi", "pesawat-terbang-tinggi", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%207.png?alt=media&token=2d17c1ae-f73e-4e39-8c3b-af59804a06a3"))
        list.add(SoalKata(8, "adik sedang belajar", "adik-sedang-belajar", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%208.png?alt=media&token=4a079788-b4c4-4400-a803-77869459e8a6"))
        list.add(SoalKata(9, "burung terbang tinggi", "burung-terbang-tinggi", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%209.png?alt=media&token=c0b6680f-0ad7-46fd-a7c4-b7aadd0b99e6"))
        list.add(SoalKata(10, "adik sedang makan", "adik-sedang-makan", false, "-", 0,"https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/susunKalimat%20-%2010.png?alt=media&token=e54d96e5-655e-41ea-90fe-62655aeed76c"))
        return list
}

fun addLatihanBacaKalimat(): ArrayList<SoalKata> {
        val list = arrayListOf<SoalKata>()
        list.add(
                SoalKata(
                        1,
                        "Ayah menyiram tanaman menggunakan selang",
                        "Ayah menyiram tanaman menggunakan selang-Selang menyiram ayah menggunakan tanaman-Menggunakan ayah menyiram tanaman dan selang-Tanaman menyiram ayah dan selang",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%201.png?alt=media&token=e4252ede-a3ba-4e51-b8a7-34e07a379f68"
                )
        )
        list.add(
                SoalKata(
                        2,
                        "Ibu memasak makanan yang enak",
                        "Ibu memasak makanan yang enak-Enak makan ibu lagi masak-Masak enak makanan ibu-Makanan masak ibu yang enak",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%202.png?alt=media&token=355b42b0-1233-42d7-a0c4-7eb970e3c0f9"
                )
        )
        list.add(
                SoalKata(
                        3,
                        "Kakak sedang belajar matematika di papan tulis",
                        "Kakak sedang belajar matematika di papan tulis-Di papan tulis matematika sedang belajar kakak-Matematika sedang belajar kakak",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%203.png?alt=media&token=232c8b07-af81-4206-8e7c-47e3c2b9a171"
                )
        )
        list.add(
                SoalKata(
                        4,
                        "Adik sedang belajar membaca di meja",
                        "Adik sedang belajar membaca di meja-Meja sedang belajar adik membaca-Meja sedang belajar adik membaca-Belajar membaca meja dan adik",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%204.png?alt=media&token=3fa4f083-1612-4806-867e-cbafbbf0cd0a"
                )
        )
        list.add(
                SoalKata(
                        5,
                        "Ayah dan Ibu sedang memasak di dapur",
                        "Ayah dan Ibu sedang memasak di dapur-Dapur sedang memasak ibu dan ayah-Ayah sedang memasak ibu di dapur-Ibu memasak dapur dan ayah",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%205.png?alt=media&token=5b1e3a1e-12e4-4aaa-aa55-230afd0cb973"
                )
        )
        list.add(
                SoalKata(
                        6,
                        "Kakak sedang berenang di kolam",
                        "Kakak sedang berenang di kolam-sedang kolam di renang kakak-kolam sedang berenang di kakak-berenang kakak di kolam sedang",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%206.png?alt=media&token=77b605cb-27e5-4f10-9e48-5f2cebe9d545"
                )
        )
        list.add(
                SoalKata(
                        7,
                        "Ibu sedang mewarnai gambar",
                        "Ibu sedang mewarnai gambar-mewarnai ibu dan gambar-sedang gambar mewarnai ibu-gambar sedang mewarnai ibu",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%207.png?alt=media&token=88b9fe36-9eae-4405-807a-f94d0edb4abe"
                )
        )
        list.add(
                SoalKata(
                        8,
                        "Aku dan ibu sedang menanam pohon di kebun",
                        "Aku dan ibu sedang menanam pohon di kebun-Kebun dan aku sedang menanam ibu di pohon-Kebun pohon menanam sedang di aku-Sedang menanam kebun di aku dan ibu",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%208.png?alt=media&token=dd221fb3-4330-4c00-af4b-fa4a18b8432e"
                )
        )
        list.add(
                SoalKata(
                        9,
                        "Kakek sedang membaca koran di taman",
                        "Kakek sedang membaca koran di taman-koran sedang membara di taman-taman membaca kakek dan koran-membaca kakek bersama taman di koran",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%209.png?alt=media&token=9e43b2a0-2857-4719-a6cc-1779873fea96"
                )
        )
        list.add(
                SoalKata(
                        10,
                        "Adik sedang bermain bola di lapangan",
                        "Lapangan sedang bermain bola bersama adik-Bermain bola di adik bersama lapangan-Bola di lapangan bernain bersama adik",
                        false,
                        "-",
                        0,
                        "https://firebasestorage.googleapis.com/v0/b/bisabelajar-b0579.appspot.com/o/latihanBacaKalimat%20-%2010.png?alt=media&token=f750c9d6-6d2a-45f0-abca-763c9918365b"
                )
        )
        return list
}