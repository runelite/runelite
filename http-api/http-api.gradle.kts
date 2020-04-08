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

description = "Web API"

dependencies {
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    compileOnly(group = "javax.inject", name = "javax.inject", version = "1")
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "com.google.guava", name = "guava", version = "28.2-jre")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "4.5.0")
    implementation(group = "io.reactivex.rxjava3", name = "rxjava", version = "3.0.2")
    implementation(group = "org.apache.commons", name = "commons-csv", version = "1.8")
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.30")
    implementation(project(":runelite-api"))

    testImplementation(group = "com.squareup.okhttp3", name = "mockwebserver", version = "4.5.0")
    testImplementation(group = "junit", name = "junit", version = "4.13")
    testImplementation(group = "org.slf4j", name = "slf4j-simple", version = "1.7.30")
}

tasks {
    processResources {
        finalizedBy("filterResources")
    }

    register<Copy>("filterResources") {
        val tokens = mapOf(
                "projectver" to ProjectVersions.rlVersion,
                "rsver" to ProjectVersions.rsversion.toString(),
                "gitcommit" to project.extra["gitCommit"]
        )

        inputs.properties(tokens)

        from("src/main/resources") {
            include("runelite.properties")
        }
        into("${buildDir}/resources/main")

        filter(ReplaceTokens::class, "tokens" to tokens)
        filteringCharset = "UTF-8"
    }
}
