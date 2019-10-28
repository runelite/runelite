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

description = "Script Assembler Plugin"

dependencies {
    annotationProcessor(Libraries.sisu)

    compileOnly(Libraries.mavenPluginAnnotations)

    implementation(Libraries.guava)
    implementation(Libraries.mavenPluginApi)
    implementation(Libraries.slf4jNop)
    implementation(project(":cache"))
    implementation(project(":runelite-api"))
}

tasks {
    register<JavaExec>("assembleMojo") {
        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.script.AssembleMojo"
        args(listOf(
                "${project.extra["rootPath"]}/runelite-client/src/main/scripts",
                "${project.extra["rootPath"]}/runelite-client/src/main/resources/runelite"
        ))
    }

    register<JavaExec>("indexMojo") {
        dependsOn("assembleMojo")

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.script.IndexMojo"
        args(listOf(
                "${project.extra["rootPath"]}/runelite-client/src/main/resources/runelite",
                "${project.extra["rootPath"]}/runelite-client/src/main/resources/runelite/index"
        ))
    }

    compileJava {
        outputs.upToDateWhen {false}

        finalizedBy("indexMojo")
    }
}