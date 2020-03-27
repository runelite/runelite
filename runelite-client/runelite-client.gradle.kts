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
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    id(Plugins.shadow.first) version Plugins.shadow.second
    java
}


apply<BootstrapPlugin>()

description = "RuneLite Client"

dependencies {
    annotationProcessor(Libraries.lombok)
    annotationProcessor(Libraries.pf4j)

    api(project(":runelite-api"))

    compileOnly(Libraries.javax)
    compileOnly(Libraries.lombok)
    compileOnly(Libraries.orangeExtensions)

    implementation(Libraries.logback)
    implementation(Libraries.gson)
    implementation(Libraries.guava)
    implementation(Libraries.guice)
    implementation(Libraries.h2)
    implementation(Libraries.rxrelay)
    implementation(Libraries.okhttp3)
    implementation(Libraries.rxjava)
    implementation(Libraries.jna)
    implementation(Libraries.javagroups)
    implementation(Libraries.jnaPlatform)
    implementation(Libraries.discord)
    implementation(Libraries.substance)
    implementation(Libraries.jopt)
    implementation(Libraries.apacheCommonsText)
    implementation(Libraries.annotations)
    implementation(Libraries.jogampGluegen)
    implementation(Libraries.jogampJogl)
    implementation(Libraries.jooq)
    implementation(Libraries.jooqCodegen)
    implementation(Libraries.jooqMeta)
    implementation(Libraries.sentry)
    implementation(Libraries.semver)
    implementation(Libraries.slf4jApi)
    implementation(Libraries.pf4j) {
        exclude(group = "org.slf4j")
    }
    implementation(Libraries.pf4jUpdate)
    implementation(project(":http-api"))

    runtimeOnly(Libraries.trident)
    runtimeOnly(Libraries.jogampGluegenLinuxAmd64)
    runtimeOnly(Libraries.jogampGluegenLinuxI586)
    runtimeOnly(Libraries.jogampGluegenWindowsAmd64)
    runtimeOnly(Libraries.jogampGluegenWindowsI586)
    runtimeOnly(Libraries.jogampJoglLinuxAmd64)
    runtimeOnly(Libraries.jogampJoglLinuxI586)
    runtimeOnly(Libraries.jogampJoglWindowsAmd64)
    runtimeOnly(Libraries.jogampJoglWindowsI586)
    runtimeOnly(project(":injected-client"))
    runtimeOnly(project(":runescape-api"))

    testAnnotationProcessor(Libraries.lombok)

    testCompileOnly(Libraries.lombok)

    testImplementation(Libraries.guiceGrapher)
    testImplementation(Libraries.guiceTestlib)
    testImplementation(Libraries.hamcrest)
    testImplementation(Libraries.junit)
    testImplementation(Libraries.mockitoCore)
    testImplementation(Libraries.mockitoInline)
    testImplementation(Libraries.okhttp3Webserver)
    testImplementation(Libraries.slf4jApi)
}

fun formatDate(date: Date?) = with(date ?: Date()) {
    SimpleDateFormat("MM-dd-yyyy").format(this)
}

fun pluginPath(): String {
    if (project.hasProperty("pluginPath")) {
        return project.property("pluginPath").toString()
    }
    return ""
}

tasks {
    build {
        finalizedBy("shadowJar")
    }

    processResources {
        finalizedBy("filterResources")
    }

    register<Copy>("filterResources") {
        val tokens = mapOf(
                "project.version" to ProjectVersions.rlVersion,
                "rs.version" to ProjectVersions.rsversion.toString(),
                "open.osrs.version" to ProjectVersions.openosrsVersion,
                "open.osrs.builddate" to formatDate(Date()),
                "plugin.path" to pluginPath()
        )

        inputs.properties(tokens)

        from("src/main/resources") {
            include("sentry.properties")
        }
        into("${buildDir}/resources/main")

        from("src/main/resources/net/runelite/client") {
            include("open.osrs.properties")
        }
        into("${buildDir}/resources/main/net/runelite/client")

        filter(ReplaceTokens::class, "tokens" to tokens)
        filteringCharset = "UTF-8"
    }

    jar {
        manifest {
            attributes(mutableMapOf("Main-Class" to "net.runelite.client.RuneLite"))
        }
    }

    shadowJar {
        archiveClassifier.set("shaded")
    }

    withType<BootstrapTask> {
        group = "openosrs"
    }

    register<JavaExec>("RuneLite.main()") {
        group = "openosrs"

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.client.RuneLite"
    }
}