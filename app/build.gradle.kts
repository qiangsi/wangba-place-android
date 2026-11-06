import java.util.Properties

plugins {
    id("com.android.application")
}

android {
    namespace = "com.qiangsi.wangbaplace"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.qiangsi.wangbaplace"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.1.0"
    }

    signingConfigs {
        create("release") {
            val ksProps = Properties()
            val f = rootProject.file("keystore/keystore.properties")
            if (f.exists()) {
                f.inputStream().use { ksProps.load(it) }
                storeFile = rootProject.file(ksProps["storeFile"] as String)
                storePassword = ksProps["storePassword"] as String
                keyAlias = ksProps["keyAlias"] as String
                keyPassword = ksProps["keyPassword"] as String
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
