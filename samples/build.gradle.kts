plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

android {
    namespace = "com.slidezxc.wixy.samples"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        applicationId = "com.slidezxc.wixy.samples"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kotlin {
        sourceSets.debug {
            kotlin.srcDirs.add(file("build/generated/ksp/debug/kotlin"))
        }
        sourceSets.release {
            kotlin.srcDirs.add(file("build/generated/ksp/release/kotlin"))
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.runner)
    // ksp
    implementation(project(":wixy-core"))
    ksp(project(":wixy-core"))
}