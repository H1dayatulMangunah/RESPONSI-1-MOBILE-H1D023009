plugins {
    id("kotlin-kapt")
    id("com.android.application") // Cara deklarasi yang lebih umum
    id("org.jetbrains.kotlin.android") // Cara deklarasi yang lebih umum
}

android {
    namespace = "com.example.responsi1mobileh1d023009"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.responsi1mobileh1d023009"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        // Ganti ke versi 1.8 yang lebih umum dan didukung luas
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8" // Sesuaikan dengan compileOptions
    }

    buildFeatures {
        viewBinding = true
    }
    // Blok viewBinding { enable = true } ini redundan (berlebihan)
    // dan sudah tidak diperlukan lagi. Cukup dengan buildFeatures saja.
}

dependencies {

    // Dependensi standar (libs) Anda sudah benar.
    // Pastikan file libs.versions.toml Anda sudah benar isinya.
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Dependensi yang Anda tambahkan manual
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Perbaikan Penting: Hapus dependensi OkHttp yang lama
    // implementation("com.squareup.okhttp:4.12.0") // Hapus baris ini
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    // Catatan: Retrofit versi 2.9.0 sudah secara otomatis membawa OkHttp3.
    // Anda hanya perlu menambahkan logging-interceptor jika butuh melihat log jaringan.

    // Dependensi Glide
    implementation("com.github.bumptech.glide:glide:4.16.0") // Versi lebih baru dan stabil
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // Dependensi Lifecycle & Coroutines
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0") // Sesuaikan versi

    // Dependensi Fragment
    implementation("androidx.fragment:fragment-ktx:1.8.2")

    // Dependensi untuk testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
