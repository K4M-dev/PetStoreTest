plugins {
    kotlin("jvm") version "2.0.21"
}

kotlin {
    jvmToolchain(22)
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

    // REST API
    testImplementation("io.rest-assured:rest-assured:5.4.0")

    // JSON (Kotlin)
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")

    //Allure
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")
}

tasks.test {
    useJUnitPlatform()
}