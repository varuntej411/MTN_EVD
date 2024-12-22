plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlinx.serialization)
    alias(libs.plugins.hilt.version)
    alias(libs.plugins.room.version)
    alias(libs.plugins.ksp.version)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.mtn.evd"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mtn.evd"
        minSdk = 26
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = true
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //navigation compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //hilt dagger
    implementation(libs.androidx.hilt.android)
    ksp(libs.androidx.hilt.compiler)
    ksp(libs.hilt.androidx.compiler)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.kotlinx.serialisation.json)
    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    //Room Database
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.guava)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.paging.guava)
    // OkHttp3
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(platform(libs.okhttp.bom))
    //coil image loader
    implementation(libs.androidx.coil)
    implementation(libs.androidx.coil.compose)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.google.gson)
    implementation(libs.converter.gson)
    implementation(libs.retrofit.adapters)
    //data store preferences
    implementation(libs.androidx.datastore)
    // paging
    implementation(libs.androidx.paging)
    implementation(libs.androidx.paging.compose)
    // Accompanist
    implementation(libs.accompanist.permission)
    // Viewpager2
    implementation(libs.androidx.viewpager2)
    //splashscreen
    implementation(libs.androidx.splash.screen)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}