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

plugins {
    id("com.github.hauner.jarTest") version "1.0.1"
}

description = "Cache"

dependencies {
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    api(project(":http-api"))

    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "com.google.guava", name = "guava", version = "28.2-jre")
    implementation(group = "commons-cli", name = "commons-cli", version = "1.4")
    implementation(group = "io.netty", name = "netty-buffer", version = "4.1.48.Final")
    implementation(group = "org.antlr", name = "antlr4-runtime", version = "4.8-1")
    implementation(group = "org.apache.commons", name = "commons-compress", version = "1.20")
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.30")

    testAnnotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    testCompileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    testImplementation(group = "junit", name = "junit", version = "4.13")
    testImplementation(group = "net.runelite.rs", name = "cache", version = "${ProjectVersions.cacheversion}")
}

tasks {
    processTestResources {
        finalizedBy("filterTestResources")
    }

    register<Copy>("filterTestResources") {
        val tokens = mapOf(
                "rs.version" to ProjectVersions.rsversion.toString(),
                "cache.version" to ProjectVersions.cacheversion.toString()
        )

        inputs.properties(tokens)

        from("src/test/resources") {
            include("cache.properties")
        }
        into("${buildDir}/resources/test")

        filter(ReplaceTokens::class, "tokens" to tokens)
        filteringCharset = "UTF-8"
    }
}
