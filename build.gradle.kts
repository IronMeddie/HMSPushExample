
buildscript {
    repositories {
        maven("https://developer.huawei.com/repo/")
        maven {url = uri("https://developer.huawei.com/repo/") }
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        classpath("com.huawei.agconnect:agcp:1.9.1.301")
        classpath("com.android.tools.build:gradle:7.4.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
val user by extra("/Users/taranyukm/Documents/user.keystore")
val user1234 by extra(user)

