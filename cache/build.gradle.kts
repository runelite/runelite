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
    java
    `maven-publish`
    antlr
    alias(libs.plugins.lombok)
}

lombok.version = libs.versions.lombok.get()

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    antlr(libs.antlr.core)
    implementation(libs.antlr.runtime)

    implementation(libs.guava)
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
    implementation(libs.commons.compress)
    implementation(libs.gson)
    implementation(libs.commons.cli)
    implementation(libs.jna.core)

    testImplementation(libs.junit)
    testImplementation(libs.rs.cache)
}

// the gradle antlr plugin adds all of antlr to runtimeClasspath,
// workaround that https://github.com/gradle/gradle/issues/820
configurations {
    api {
        setExtendsFrom(extendsFrom.filterNot { it == antlr.get() })
    }
}

sourceSets {
    main {
        antlr { setSrcDirs(listOf("src/main/antlr4")) }
    }
}

publishing {
    publications {
        create<MavenPublication>("cache") {
            from(components["java"])
        }
    }
}

tasks.processTestResources {
    filesMatching("cache.properties") {
        filter { it.replace("\${rs.version}", libs.versions.rs.get()) }
        filter { it.replace("\${cache.version}", libs.versions.cache.get()) }
    }
}

tasks.test {
    enabled = false
    jvmArgs("-Xmx2048m")
}

// everything from here down is accounting for antlr sources in varying ways
tasks.named("sourcesJar", Jar::class) {
    dependsOn(tasks.generateGrammarSource)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    exclude("net/runelite/cache/script/assembler/*.interp")
    exclude("net/runelite/cache/script/assembler/*.tokens")
}

tasks.javadoc {
    exclude("net/runelite/cache/script/assembler/*.interp")
    exclude("net/runelite/cache/script/assembler/*.tokens")
}

tasks.checkstyleMain {
    exclude("net/runelite/cache/script/assembler/*.java")
}

tasks.generateGrammarSource {
    arguments.addAll(listOf("-package", "net.runelite.cache.script.assembler"))
}

afterEvaluate {
    tasks.named("generateEffectiveLombokConfig") {
        // lombok won't find anything in the antlr generated sources, but it looks in there regardless
        // and gradle complains if you don't provide an explicit task dependency between the two
        dependsOn(tasks.generateGrammarSource)
    }
}
