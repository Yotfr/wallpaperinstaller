plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.categories"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":domain:categories"))
    implementation(project(":domain:model"))
    implementation(project(":core:resources"))
    implementation(project(":core:designsystem"))
    implementation(project(":feature:shared"))

    coil()
    coroutinesCore()
    coroutinesAndroid()
    navigation()
    navigationHiltExt()
    hilt()
    compose()
    viewModelKtx()
    coreKtx()
    runtimeKtx()
}