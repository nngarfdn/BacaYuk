package com.android.bisabelajar.utils

import android.content.Context
import android.content.Intent

fun openActivity(context: Context, activity: Class<*>) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
}