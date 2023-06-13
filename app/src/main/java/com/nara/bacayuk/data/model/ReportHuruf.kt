package com.nara.bacayuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportHuruf(
    //format "Aa" , "Bb"
    val abjadName: String = "",
    var materiHurufNonKapital:Boolean = false,
    var materiHurufKapital: Boolean = false,
    var materiPerbedaanHuruf: Boolean = false,
    var quizHurufNonKapital: Boolean = false,
    var quizHurufKapital: Boolean = false,
): Parcelable