
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.huawei.agconnect")
    id("com.google.gms.google-services")
}

android {
    signingConfigs {
        getByName("debug") {
            storeFile = file("user.keystore")
            storePassword = "123456"
            keyAlias = "user1234"
            keyPassword = "123456"
            enableV1Signing = true
            enableV2Signing = true
        }
    }
    namespace = "com.ironmeddie.testapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ironmeddie.testapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // AppMetrica SDK.
    implementation("io.appmetrica.analytics:analytics:7.2.0")
    implementation("io.appmetrica.analytics:push:4.0.0")
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.firebase:firebase-messaging:22.0.0")
    implementation("com.google.android.gms:play-services-base:17.5.0")
    implementation("io.appmetrica.analytics:push-provider-hms:4.0.0")
    implementation("io.appmetrica.analytics:push-provider-firebase:4.0.0")

    implementation("com.huawei.hms:push:6.12.0.300")
    implementation("com.huawei.hms:hmscoreinstaller:6.7.0.300")

}
