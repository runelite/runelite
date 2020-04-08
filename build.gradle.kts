/*
 * Copyright (c) 2019 Owain van Brakel <https://github.com/Owain94>
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

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.ajoberstar.grgit.Grgit

buildscript {
    repositories {
        gradlePluginPortal()
        mavenLocal()
        maven(url = "https://raw.githubusercontent.com/open-osrs/hosting/master")
    }
    dependencies {
        classpath("org.ajoberstar.grgit:grgit-core:4.0.1")
        classpath("com.github.ben-manes:gradle-versions-plugin:0.28.0")
        classpath("com.openosrs:injector-plugin:${ProjectVersions.openosrsInjectorVersion}")
    }
}

plugins {
    id("com.adarshr.test-logger") version "2.0.0" apply false
    id("com.github.ben-manes.versions") version "0.28.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.13"
    id("org.ajoberstar.grgit") version "4.0.1"
    id("com.simonharrer.modernizer") version "1.8.0-1" apply false

    application
}

val grgit = Grgit.open(mapOf("dir" to rootProject.projectDir.absolutePath))
val localGitCommit = grgit.head().id

fun isNonStable(version: String): Boolean {
    return listOf("ALPHA", "BETA", "RC").any {
        version.toUpperCase().contains(it)
    }
}

allprojects {
    group = "com.openosrs"
    version = ProjectVersions.openosrsVersion
    apply<MavenPublishPlugin>()
}

subprojects {
    repositories {
        if (System.getenv("JITPACK") != null)
            mavenLocal()
        jcenter()
        maven(url = "https://jitpack.io")
        maven(url = "https://mvnrepository.com/artifact")

        exclusiveContent {
            forRepository {
                maven {
                    url = uri("https://repo.runelite.net")
                }
            }
            filter {
                includeGroup("net.runelite.rs")
                includeModule("net.runelite", "discord")
                includeModule("net.runelite", "orange-extensions")
            }
        }
        exclusiveContent {
            forRepository {
                maven {
                    url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master")
                }
            }
            filter {
                includeModule("net.runelite", "fernflower")
                includeModule("com.openosrs.rxrelay3", "rxrelay")
            }
        }
    }

    apply<JavaLibraryPlugin>()
    //apply<MavenPublishPlugin>()
    apply(plugin = "com.adarshr.test-logger")
    apply(plugin = "com.github.ben-manes.versions")
    apply(plugin = "se.patrikerdes.use-latest-versions")

    project.extra["gitCommit"] = localGitCommit
    project.extra["rootPath"] = rootDir.toString().replace("\\", "/")

    if (this.name != "runescape-client") {
        apply<CheckstylePlugin>()

        configure<CheckstyleExtension> {
            maxWarnings = 0
            toolVersion = "8.25"
            isShowViolations = true
            isIgnoreFailures = false
        }
    }
    if (this.name == "runelite-client" || this.name == "runelite-api") {
        apply(plugin = "com.simonharrer.modernizer")
    }

    configure<PublishingExtension> {
        repositories {
            maven {
                url = uri("$buildDir/repo")
            }
        }
        publications {
            register("mavenJava", MavenPublication::class) {
                from(components["java"])
            }
        }
    }

    tasks {
        java {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }

        withType<Checkstyle> {
            group = "verification"

            exclude("**/ScriptVarType.java")
            exclude("**/LayoutSolver.java")
            exclude("**/RoomType.java")
        }

        named<DependencyUpdatesTask>("dependencyUpdates") {
            checkForGradleUpdate = false

            resolutionStrategy {
                componentSelection {
                    all {
                        if (candidate.displayName.contains("fernflower") || isNonStable(candidate.version)) {
                            reject("Non stable")
                        }
                    }
                }
            }
        }
    }
}

application {
    mainClassName = "net.runelite.client.RuneLite"
}

tasks {
    named<JavaExec>("run") {
        group = "openosrs"

        classpath = project(":runelite-client").sourceSets.main.get().runtimeClasspath
    }

    named<DependencyUpdatesTask>("dependencyUpdates") {
        checkForGradleUpdate = false

        resolutionStrategy {
            componentSelection {
                all {
                    if (candidate.displayName.contains("fernflower") || isNonStable(candidate.version)) {
                        reject("Non stable")
                    }
                }
            }
        }
    }
}
