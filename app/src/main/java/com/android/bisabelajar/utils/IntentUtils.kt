package com.android.bisabelajar.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

fun openActivity(context: Context, activity: Class<*>) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
}

//open activity with passing parcelable
//fun openActivity(context: Context, activity: Class<*>, data: Any?, key: String) {
//    val intent = Intent(context, activity)
//    intent.putExtra(key, data)
//    context.startActivity(intent)
//}



