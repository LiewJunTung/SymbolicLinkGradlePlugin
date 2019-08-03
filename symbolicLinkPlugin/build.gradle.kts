import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.10.0"
}

pluginBundle {
    website = "https://github.com/LiewJunTung/SymbolicLinkGradlePlugin"
    vcsUrl = "https://github.com/LiewJunTung/SymbolicLinkGradlePlugin"
    tags = listOf("symbolic link", "linux")
}

gradlePlugin {
    plugins {
        create("symbolicPlugin") {
            id = "com.liewjuntung.symbolicPlugin"
            implementationClass = "com.liewjuntung.symbolicPlugin.SymbolicLinkPlugin"
            displayName = "Symbolic Link Plugin"
            description = "A plugin to do symbolic link"
        }
    }
}

group = "com.liewjuntung"
version = "1.0.1.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
