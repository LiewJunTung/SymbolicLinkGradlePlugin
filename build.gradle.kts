import com.liewjuntung.symbolicPlugin.SymbolicLink
import com.liewjuntung.symbolicPlugin.SymbolicLinkExtension
import com.liewjuntung.symbolicPlugin.createSymbolicLink

plugins {
    kotlin("jvm") version "1.3.41"
    id("com.liewjuntung.symbolicPlugin") version "1.0.1.3"
}

tasks.register("createSymbolicLink", SymbolicLink::class){
    actualFilePath = "test.txt"
    symbolicDirPath = "build/test/"
    rename = "testlink.txt"
}

tasks.register("createSymbolicLink2"){
    doLast {
        createSymbolicLink("test.txt", "build/test/", "link1.txt")
        createSymbolicLink("test.txt", "build/test/", "link2.txt")
        createSymbolicLink("test.txt", "build/test/", "link3.txt")
    }
}

configure<SymbolicLinkExtension> {
    actualFileLocation = "test.txt"
    symbolicFileDir = "build/test/symbolic/"
    rename = "pluginLink.txt"
}