plugins {
    jacoco
}

defaultTasks("clean", "build", "test")

buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://maven.fabric.io/public")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jacoco:org.jacoco.core:${Versions.jacoco}")
    }
}

allprojects {
    apply(plugin = "jacoco")

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://maven.google.com/")
        }
    }

    jacoco {
        toolVersion = Versions.jacoco
    }

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
