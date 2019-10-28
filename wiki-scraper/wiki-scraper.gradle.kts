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

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

description = "RuneLite Wiki scraper"

dependencies {
    api(project(":cache"))
    api(project(":runelite-api"))

    annotationProcessor(Libraries.lombok)

    compileOnly(Libraries.lombok)

    implementation(Libraries.gson)
    implementation(Libraries.guava)
    implementation(Libraries.petitparser)
    implementation(Libraries.okhttp3)
    implementation(Libraries.slf4jApi)
    implementation(Libraries.slf4jSimple)

    testImplementation(Libraries.jupiter)
}

tasks {
    register<JavaExec>("npcStatsScrape") {
        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("npcStats", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }

    register<JavaExec>("itemStatsScrape") {
        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("itemStats", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }

    register<JavaExec>("itemLimitsScrape") {
        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.data.App"
        args(listOf("itemLimits", rootProject.file("./runelite-client/src/main/resources/").absolutePath))
    }
}
