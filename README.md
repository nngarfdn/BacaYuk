# BacaYuk

BacaYuk demonstrates modern Android development using Firebase, Koin, Coroutines, Flow, ViewModel, and Material Design, based on the MVVM architecture.

[![App Screenshot](https://gcdnb.pbrd.co/images/ykuUM2xeyGiS.png?o=1)](https://play.google.com/store/apps/details?id=com.nara.bacayuk)

## Purpose

BacaYuk is an Android-based digital learning media application designed for students with intellectual disabilities in special schools. This innovative application serves as an alternative to conventional reading learning methods, assisting teachers in effectively teaching students and enhancing their reading skills.

## Download

To download the latest APK, visit the [PlayStore](https://play.google.com/store/apps/details?id=com.nara.bacayuk).

## Tech Stack & Open-source Libraries

- Minimum SDK level: 21
- Language: Kotlin

**Asynchronous Programming:**
- Coroutines for managing asynchronous operations.
- Flow for handling asynchronous data streams.

**Jetpack Components:**
- Lifecycle: To observe Android lifecycles and manage UI states based on lifecycle changes.
- ViewModel: For managing UI-related data and making it lifecycle-aware, ensuring data survives configuration changes.
- ViewBinding: For binding UI components to data sources in a more efficient and type-safe manner, reducing the need for manual UI updates.
- Koin: For dependency injection, making it easier to manage dependencies in your app.
- Navigation: For navigating between fragments and handling the navigation UI.

**Material Design:**
- Material Components: A library for material design components, including ripple animations and CardView.

**Image Loading:**
- Glide and GlidePalette: Glide is used for loading images from the network, and GlidePalette allows you to extract and work with colors from the loaded images.

**Data Storage:**
- DataStore: For managing and storing app-specific data in a key-value format.

**UI Components:**
- ViewPager2: For creating swipeable screens.
- DotsIndicator: For displaying indicators for ViewPager2.
- Balloon: A library for creating tooltips and pop-up messages.
- Android-Simple-Tooltip: For showing simple and customizable tooltips.

**UI Testing:**
- Espresso: For UI testing of Android applications.

## Architecture

The BacaYuk project is built upon the foundational principles of the MVVM (Model-View-ViewModel) architecture and incorporates the Repository pattern as a structural framework. This architectural design closely aligns with Google's official recommendations for building robust and maintainable Android applications, following Google's official architecture guidance.

![Architecture](https://gcdnb.pbrd.co/images/LYlURD0P7jvp.png?o=1)

## Instrumentation Testing

![Test Results](https://gcdnb.pbrd.co/images/7jyCpHWPKdIm.png?o=1)
