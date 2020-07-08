import org.gradle.api.JavaVersion

object BuildTypes {
    const val DEBUG: String = "debug"
    const val RELEASE: String = "release"
}

object SourceSets {
    const val MAIN: String = "main"
    const val TEST: String = "test"
    const val AndroidTest: String = "androidTest"
}

object Apps {
    val sourceCompatibility: JavaVersion = JavaVersion.VERSION_1_8
    val targetCompatibility: JavaVersion = JavaVersion.VERSION_1_8
    const val jvmTarget: String = "1.8"
    const val compileSdk: Int = 29
    const val minSdk: Int = 23
    const val targetSdk: Int = 29
    const val buildToolVersion: String = "29.0.3"
    const val versionCode: Int = 1
    const val versionName: String = "1.0.0"
    const val testInstrumentationRunner: String = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val gradle: String = "4.0.0"
    const val kotlin: String = "1.3.72"

    const val constraintLayout: String = "2.0.0-beta7"
    const val coreKtx: String = "1.3.0"
    const val appcompat: String = "1.1.0"
    const val annotation: String = "1.1.0"
    const val anko: String = "0.10.8"
    const val material: String = "1.3.0-alpha01"
    const val cardView: String = "1.0.0"
    const val recyclerview: String = "1.1.0"
    const val retrofit2: String = "2.7.0"
    const val okhttp3: String = "4.2.2"
    const val converterGson: String = "2.6.2"
    const val adapterRxJava2: String = "2.7.0"
    const val gson: String = "2.8.6"
    const val rxJava2: String = "2.2.13"
    const val rxAndroid: String = "2.1.1"
    const val rxKotlin: String = "2.4.0"
    const val lifeCycleExtension: String = "2.2.0"
    const val fragmentKtx: String = "1.2.5"
    const val activityKtx: String = "1.1.0"
    const val room: String = "2.2.5"
    const val glide: String = "4.11.0"
    const val glideOkHttpIntegration: String = "4.9.0"
    const val koin: String = "2.0.1"
    const val lottie: String = "3.4.0"
    const val logger: String = "2.2.0"

    const val junit: String = "4.12"
    const val junitExt: String = "1.1.1"
    const val espresso: String = "3.2.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val anko = "org.jetbrains.anko:anko:${Versions.anko}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.adapterRxJava2}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val lifecycleViewModelExt = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleExtension}"
    const val lifeCycleLiveDataExt = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleExtension}"
    const val lifeCycleRuntimeExt = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleExtension}"
    const val lifeCycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycleExtension}"
    const val fragmentExt = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val activityExt = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomRxJava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideOkHttpIntegration = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideOkHttpIntegration}"
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val logger = "com.orhanobut:logger:${Versions.logger}"
}

object TestLibs {
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}