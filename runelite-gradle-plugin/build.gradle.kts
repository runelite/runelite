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

plugins {
    `java-gradle-plugin`
    pmd
}

dependencies {
    implementation("net.runelite:cache:${project.version}")

    implementation(libs.guava)
    implementation(libs.tomlj)
    implementation(libs.javapoet)
}

gradlePlugin {
    plugins {
        create("rl-assemble") {
            id = "net.runelite.runelite-gradle-plugin.assemble"
            implementationClass = "net.runelite.gradle.assemble.AssemblePlugin"
        }
        create("rl-component") {
            id = "net.runelite.runelite-gradle-plugin.component"
            implementationClass = "net.runelite.gradle.component.ComponentPlugin"
        }
        create("rl-index") {
            id = "net.runelite.runelite-gradle-plugin.index"
            implementationClass = "net.runelite.gradle.index.IndexPlugin"
        }
        create("rl-jarsign") {
            id = "net.runelite.runelite-gradle-plugin.jarsign"
            implementationClass = "net.runelite.gradle.jarsign.JarsignPlugin"
        }
    }
}

pmd {
    toolVersion = "7.2.0"
    ruleSetFiles("./pmd-ruleset.xml")
    isConsoleOutput = true
    incrementalAnalysis = true
    isIgnoreFailures = false
    threads = Runtime.getRuntime().availableProcessors()
}
