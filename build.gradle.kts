plugins {
    kotlin("jvm") version "2.0.21"
    id("io.qameta.allure") version "2.12.0"
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
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
    testImplementation("io.rest-assured:json-path:5.4.0")

    // JSON (Kotlin)
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.17.0")

    //Allure
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")
    testRuntimeOnly("io.qameta.allure:allure-junit-platform:2.27.0")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("allure.results.directory", layout.buildDirectory.dir("allure-results").get().asFile.absolutePath)
}

allure {
    version.set("2.27.0")
    adapter {
        frameworks {
            junit5 {
                adapterVersion.set("2.27.0")
            }
        }
    }
}