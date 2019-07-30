import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.10.0"
}

pluginBundle {
    website = "<substitute your project website>"
    vcsUrl = "<uri to project source repository>"
    tags = listOf("symbolic link", "linux")
}

gradlePlugin {
    plugins {
        create("symbolicPlugin") {
            id = "com.liewjuntung.symbolicPlugin"
            implementationClass = "com.liewjuntung.symbolic_plugin.SymbolicPlugin"
            displayName = "Symbolic Link Plugin"
            description = "A plugin to do symbolic link"
        }
    }
}


group = "com.liewjuntung"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.register("copyFoo", Copy::class) {
    from("$projectDir/foo.txt")
    into("$projectDir/fooDir")

}

tasks.register("deleteFoo", Delete::class) {
    delete = setOf("$projectDir/fooDir")
}