package com.liewjuntung.symbolicPlugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SymbolicLinkPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("symbolicLinkExtension", SymbolicLinkExtension::class.java)
        project.afterEvaluate {
            it.tasks.register("readyMadeSymbolicLink") { task ->
                task.doLast {
                    createSymbolicLink(extension.actualFileLocation, extension.symbolicFileDir, extension.rename)
                }
            }
        }
    }
}

open class SymbolicLinkExtension {
    var actualFileLocation: String? = null
    var symbolicFileDir: String? = null
    var rename: String? = null
}