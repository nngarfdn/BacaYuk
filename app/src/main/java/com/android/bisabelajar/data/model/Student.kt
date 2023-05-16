package com.android.bisabelajar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val uuid: String="",
    val fullName: String="",
    val noAbsen: String="",
    val kelas: String="",
    val tahunMasukSekolah: String="",
    val asalSekolah: String="",
    val profilPicture: String=""
): Parcelable