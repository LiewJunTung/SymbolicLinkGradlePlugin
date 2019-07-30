package com.liewjuntung.symbolicPlugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File


abstract class SymbolicLink: DefaultTask() {

    var actualFilePath: String? = null
    var symbolicDirPath: String? = null
    var rename: String? = null

    @TaskAction
    fun link() {
        val aPath = actualFilePath ?: throw Exception("actualPath not set")
        val sPath = symbolicDirPath ?: throw Exception("symbolicPath not set")


        val actualFile = File(aPath)
        if (!actualFile.exists()) {
            throw Exception("$aPath not found")
        }
        val symbolicDirFile = File(sPath)
        val pb = ProcessBuilder()

        if (!symbolicDirFile.exists()) {
            symbolicDirFile.mkdirs()
        }
        pb.directory(symbolicDirFile)

        val symbolicRelativePath = symbolicDirFile.toPath().relativize(actualFile.toPath())
        println(symbolicRelativePath.toString())
        pb.command("ln", "-s", symbolicRelativePath.toString(), rename ?: ".")
        pb.directory(symbolicDirFile)
        pb.start()
    }
}