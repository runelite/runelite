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

import org.apache.tools.ant.filters.ReplaceTokens
import java.util.Date
import java.text.SimpleDateFormat

buildscript {
    dependencies {
        classpath(gradleApi())
    }
}

plugins {
    id(Plugins.shadow.first) version Plugins.shadow.second
    java
}

description = "RuneLite Client"

dependencies {
    annotationProcessor(Libraries.lombok)

    compileOnly(Libraries.javax)
    compileOnly(Libraries.orangeExtensions)
    compileOnly(Libraries.lombok)

    implementation(Libraries.logback)
    implementation(Libraries.gson)
    implementation(Libraries.guava)
    implementation(Libraries.guice)
    implementation(Libraries.h2)
    implementation(Libraries.rxrelay)
    implementation(Libraries.okhttp3)
    implementation(Libraries.rxjava)
    implementation(Libraries.jna)
    implementation(Libraries.jnaPlatform)
    implementation(Libraries.discord)
    implementation(Libraries.substance)
    implementation(Libraries.jopt)
    implementation(Libraries.apacheCommonsText)
    implementation(Libraries.httpcore)
    implementation(Libraries.httpmime)
    implementation(Libraries.plexus)
    implementation(Libraries.javassist)
    implementation(Libraries.annotations)
    implementation(Libraries.jogampGluegen)
    implementation(Libraries.jogampJogl)
    implementation(Libraries.jooq)
    implementation(Libraries.jooqCodegen)
    implementation(Libraries.jooqMeta)
    implementation(Libraries.asmTree)
    implementation(Libraries.slf4jApi)
    implementation(Libraries.jclCore)
    implementation(project(":http-api"))
    implementation(project(":runelite-api"))
    implementation(Libraries.jbsdiff) {
        exclude(module = "xz")
    }
    implementation(Libraries.naturalMouse)
    runtime(Libraries.trident)
    runtime(Libraries.jogampGluegenLinuxAmd64)
    runtime(Libraries.jogampGluegenLinuxI586)
    runtime(Libraries.jogampGluegenWindowsAmd64)
    runtime(Libraries.jogampGluegenWindowsI586)
    runtime(Libraries.jogampJoglLinuxAmd64)
    runtime(Libraries.jogampJoglLinuxI586)
    runtime(Libraries.jogampJoglWindowsAmd64)
    runtime(Libraries.jogampJoglWindowsI586)
    runtime(project(":injected-client"))
    runtime(project(":runescape-api"))

    testAnnotationProcessor(Libraries.lombok)

    testCompileOnly(Libraries.lombok)

    testImplementation(Libraries.guiceGrapher)
    testImplementation(Libraries.guiceTestlib)
    testImplementation(Libraries.junit)
    testImplementation(Libraries.hamcrest)
    testImplementation(Libraries.mockitoCore)
    testImplementation(Libraries.mockitoInline)
    testImplementation(Libraries.slf4jApi)
}

fun formatDate(date: Date?) = with(date ?: Date()) {
    SimpleDateFormat("MM-dd-yyyy").format(this)
}

tasks {
    register<DependencyReportTask>("dependencyReportFile") {
        outputFile = file("dependencies.txt")
        setConfiguration("runtimeClasspath")
    }

    build {
        finalizedBy("shadowJar")
    }

    "processResources"(ProcessResources::class) {
        val tokens = mapOf(
                "project.version" to ProjectVersions.rlVersion,
                "rs.version" to ProjectVersions.rsversion.toString(),
                "open.osrs.version" to ProjectVersions.openosrsVersion,
                "open.osrs.builddate" to formatDate(Date()),
                "launcher.version" to ProjectVersions.launcherVersion
        )

        inputs.properties(tokens)

        from("src/main/resources") {
            include("open.osrs.properties")

            filter<ReplaceTokens>("tokens" to tokens)
        }
    }

    jar {
        manifest {
            attributes(mutableMapOf("Main-Class" to "net.runelite.client.RuneLite"))
        }
    }

    shadowJar {
        dependsOn("dependencyReportFile")

        archiveClassifier.set("shaded")

        exclude("net/runelite/injector/**")
    }
}