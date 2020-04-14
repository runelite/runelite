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

description = "RuneLite Wiki scraper"

dependencies {
    api(project(":cache"))
    api(project(":runelite-api"))

    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "com.google.guava", name = "guava", version = "28.2-jre")
    implementation(group = "com.github.petitparser", name = "java-petitparser", version = "2.3.1")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "4.5.0")
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.30")
    implementation(group = "org.slf4j", name = "slf4j-simple", version = "1.7.30")

    implementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.6.1")
}

tasks {
    register<JavaExec>("npcStatsScrape") {
        group = "openosrs"

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("npcStats", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }

    register<JavaExec>("itemStatsScrape") {
        group = "openosrs"

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("itemStats", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }

    register<JavaExec>("itemLimitsScrape") {
        group = "openosrs"

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("itemLimits", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }
}
