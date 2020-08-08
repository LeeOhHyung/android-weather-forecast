plugins {
    id("kotlin")
}

dependencies {
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.rxJava2)
    implementation(Libs.rxKotlin)
    implementation(TestLibs.junit)
}
