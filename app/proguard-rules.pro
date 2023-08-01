
# Jika Anda menggunakan Kotlin, tambahkan aturan ini agar kode Kotlin berfungsi dengan baik
-dontwarn kotlin.**
-keep class kotlin.** { *; }

# Jika Anda menggunakan AndroidX, tambahkan aturan ini agar library AndroidX berfungsi dengan baik
-dontwarn androidx.**
-keep class androidx.** { *; }

# Jika Anda menggunakan AndroidX, tambahkan aturan ini agar library AndroidX berfungsi dengan baik
-dontwarn androidx.**
-keep class androidx.** { *; }


# Jika Anda menggunakan AndroidX, tambahkan aturan ini agar library AndroidX berfungsi dengan baik
-dontwarn androidx.**
-keep class androidx.** { *; }

# Rules for Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# Rules for Firebase
-keepnames class com.google.firebase.** { *; }
-keepnames class org.apache.http.** { *; }
-keepnames class com.firebase.** { *; }

# Rules for Koin
-keep class org.koin.** { *; }

# Rules for Mockito
-dontwarn org.mockito.**
-keep class org.mockito.** { *; }

# Rules for Balloon
-keep class com.skydoves.** { *; }

# Rules for WheelPicker
-keep class sh.tyy.** { *; }

# Rules for SimpleTooltip
-keep class com.github.douglasjunior.** { *; }

# Rules for Android Simple Tooltip
-keep class com.github.iammert.** { *; }

# Rules for DiscreteScrollView
-keep class com.yarolegovich.** { *; }

# Rules for ViewPager2
-keep class androidx.viewpager2.** { *; }

# Rules for Material Intro View
-keep class com.github.iammert.** { *; }
