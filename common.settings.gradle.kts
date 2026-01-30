/*
 * Copyright (c) 2024, LlemonDuck <napkinorton@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

dependencyResolutionManagement {
    repositories {
        maven(uri("https://repo.runelite.net")) {
            name = "rrn"

            content {
                includeGroupAndSubgroups("net.runelite")
            }
        }
        mavenCentral {
            content { excludeGroupAndSubgroups("net.runelite") }
        }
    }

    versionCatalogs {
        create("libs") {
            from(files("./libs.versions.toml"))
        }
    }
}

// set up some defaults
val rootProps = file("./gradle.properties").inputStream().use { stream ->
    java.util.Properties().apply { load(stream) }
}
val checkstyleDir = file("./config/checkstyle/")
gradle.beforeProject {
    apply(plugin = "idea")
    apply(plugin = "checkstyle")
    group = rootProps["project.build.group"] as String
    version = rootProps["project.build.version"] as String

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release = 11
    }
}

gradle.afterProject {
    tasks.withType<Javadoc> {
        (this.options as StandardJavadocDocletOptions).apply {
            quiet()
            encoding("UTF-8")
            use(true)
            bottom("Copyright © 2014")
            links(
                "https://docs.oracle.com/en/java/javase/11/docs/api/"
            )
        }
    }

    // shared checkstyle config
    extensions.findByType<CheckstyleExtension>()?.run {
        toolVersion = "8.3"
        configDirectory = file("../config/checkstyle")
    }

    // shared publishing config
    tasks.withType<GenerateModuleMetadata> { enabled = false }
    extensions.findByType<org.gradle.api.publish.PublishingExtension>()?.run {
        repositories {
            maven(uri(providers.gradleProperty("rrnUrl").getOrElse("https://repo.runelite.net"))) {
                name = "rrn"
                if (url.scheme != "file") {
                    credentials(PasswordCredentials::class) {
                        username = providers.gradleProperty("rrnPublishUsername").orElse(providers.gradleProperty("rrnUsername")).getOrElse("")
                        password = providers.gradleProperty("rrnPublishPassword").orElse(providers.gradleProperty("rrnPassword")).getOrElse("")
                    }
                }
            }
        }
    }

    // produce reproducible outputs
    tasks.withType<AbstractArchiveTask> {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }

    tasks.withType<Test> {
        testLogging {
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    extensions.findByType<org.gradle.plugins.ide.idea.model.IdeaModel>()?.run {
        module {
            isDownloadSources = true
            isDownloadJavadoc = true
        }
    }
}
