plugins {
    id("com.android.application")
    id("jacoco")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

jacoco {
    toolVersion = Versions.jacoco
    reportsDir = file("${buildDir}/reports")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolVersion)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = Apps.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName(BuildTypes.RELEASE) {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompatibility
        targetCompatibility = Apps.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }

    sourceSets {
        getByName(SourceSets.MAIN).java.srcDir("src/main/kotlin")
        getByName(SourceSets.TEST).java.srcDir("src/test/kotlin")
        getByName(SourceSets.AndroidTest).java.srcDir("src/androidTest/kotlin")
    }
}

dependencies {

    api(project(":data"))
    api(project(":domain"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)

    // ConstraintLayout
    implementation(Libs.constraintLayout)

    // Android, Kotlin
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.annotation)

    // Android Anko
    implementation(Libs.anko)

    // Android View Libraries
    implementation(Libs.material)
    implementation(Libs.recyclerview)
    implementation(Libs.cardview)

    // Retrofit, OkHttp, Gson
    implementation(Libs.retrofit2)
    implementation(Libs.okHttp3)
    implementation(Libs.converterGson)
    implementation(Libs.adapterRxJava2)
    implementation(Libs.gson)

    // RxJava2
    implementation(Libs.rxJava2)
    implementation(Libs.rxAndroid)
    implementation(Libs.rxKotlin)

    // LifeCycleExtension && Kotlin extension
    implementation(Libs.lifecycleViewModelExt)
    implementation(Libs.lifeCycleLiveDataExt)
    implementation(Libs.lifeCycleRuntimeExt)
    implementation(Libs.lifeCycleCommonJava8)
    implementation(Libs.fragmentExt)
    implementation(Libs.activityExt)

    // Room
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    implementation(Libs.roomRxJava2)
    kapt(Libs.roomCompiler)

    // Glide
    implementation(Libs.glide)
    implementation(Libs.glideOkHttpIntegration)
    kapt(Libs.glideCompiler)

    // Koin
    implementation(Libs.koin)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)
    testImplementation(TestLibs.koinTest)

    // Lottie
    implementation(Libs.lottie)

    // Testing
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espresso)
}
