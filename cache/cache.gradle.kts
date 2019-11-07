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
    id(Plugins.jarTest.first) version Plugins.jarTest.second
}

description = "Cache"

dependencies {
    annotationProcessor(Libraries.lombok)

    api(project(":http-api"))

    compileOnly(Libraries.lombok)

    implementation(Libraries.gson)
    implementation(Libraries.guava)
    implementation(Libraries.commonsCli)
    implementation(Libraries.nettyBuffer)
    implementation(Libraries.antlr)
    implementation(Libraries.apacheCommonsCompress)
    implementation(Libraries.slf4jApi)

    testImplementation(Libraries.junit)
    testImplementation(group = "net.runelite.rs", name = "cache", version = "${ProjectVersions.cacheversion}")
    testImplementation(Libraries.slf4jSimple)
}

tasks {
    "processTestResources"(ProcessResources::class) {
        val tokens = mapOf(
                "rs.version" to ProjectVersions.rsversion.toString(),
                "cache.version" to ProjectVersions.cacheversion.toString()
        )

        inputs.properties(tokens)

        from("src/test/resources") {
            include("cache.properties")

            filter<ReplaceTokens>("tokens" to tokens)
        }
    }
}
