package com.liewjuntung.symbolicPlugin

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

internal class SymbolicLinkTest {
    lateinit var tmpFile: File

    @BeforeEach
    fun setUp() {
        File("build/test").mkdirs()
        tmpFile = File("build/test/testfile.txt")
        tmpFile.writeText("Hello")
    }

    @AfterEach
    fun tearDown() {
        tmpFile.parentFile.deleteRecursively()
    }

    @Test
    fun link() {
        assertTrue(tmpFile.exists())
        println(tmpFile.path)
        createSymbolicLink(tmpFile.path, tmpFile.parent, "somelink.txt")
        Thread.sleep(100)
        val tmpSymLink = File("${tmpFile.parent}/somelink.txt")
        assertTrue(tmpSymLink.exists())
    }
}