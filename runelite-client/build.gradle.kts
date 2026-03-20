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

import java.io.ByteArrayOutputStream

plugins {
    java
    `java-library`
    `maven-publish`
    pmd
    alias(libs.plugins.lombok)

    id("net.runelite.runelite-gradle-plugin.assemble")
    id("net.runelite.runelite-gradle-plugin.index")
    id("net.runelite.runelite-gradle-plugin.jarsign")
}

lombok.version = libs.versions.lombok.get()

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    api("net.runelite:runelite-api:${project.version}")
    implementation(project(":jshell"))
    runtimeOnly("net.runelite:injected-client:${project.version}")

    api(libs.rl.http.api)
    api(libs.rl.discord)
    api(libs.rl.awt)
    compileOnly(libs.rl.orange)

    api(libs.slf4j.api)
    api(libs.logback.classic) {
        exclude("org.slf4j", "slf4j-api")
    }
    api(libs.jopt)
    api(libs.guava) {
        exclude("com.google.code.findbugs", "jsr305")
        exclude("com.google.errorprone", "error_prone_annotations")
        exclude("com.google.j2objc", "j2objc-annotations")
        exclude("org.codehaus.mojo", "animal-sniffer-annotations")
    }
    api(variantOf(libs.guice.core) { classifier("no_aop") }) {
        exclude("com.google.guava", "guava")
    }
    api(libs.gson)
    api(libs.flatlaf.core)
    implementation(libs.flatlaf.extras)
    api(libs.commons.text)
    api(libs.jna.core)
    api(libs.jna.platform)
    api(libs.findbugs)
    compileOnly(libs.jetbrains.annotations)
    api(libs.protobuf)
    api(libs.lwjgl.core)
    api(libs.lwjgl.opengl)
    api(libs.lwjgl.opencl)

    for (platform in listOf(
        "linux",
        "linux-arm64",
        "macos",
        "macos-arm64",
        "windows-x86",
        "windows",
        "windows-arm64",
    )) {
        runtimeOnly(variantOf(libs.lwjgl.core) { classifier("natives-$platform") })
        runtimeOnly(variantOf(libs.lwjgl.opengl) { classifier("natives-$platform") })
    }

    testImplementation(libs.junit)
    testImplementation(libs.hamcrest)
    testImplementation(libs.mockito)
    testImplementation(libs.guice.testlib)
    testImplementation(libs.guice.grapher)
    testImplementation(libs.okhttp.mockserver)
}

val shadowJar = tasks.register<Jar>("shadowJar") {
    dependsOn(configurations.runtimeClasspath)
    manifest {
        attributes["Main-Class"] = "net.runelite.client.RuneLite"
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(sourceSets.main.get().output)
    from(configurations.runtimeClasspath.map { it.map { if (it.isDirectory) it else zipTree(it) } })

    exclude(
        "META-INF/INDEX.LIST",
        "META-INF/*.SF",
        "META-INF/*.DSA",
        "META-INF/*.RSA",
        "**/module-info.class"
    )

    group = BasePlugin.BUILD_GROUP
    archiveClassifier = "shadow"
    archiveFileName = project.name + "-" + project.version + "-shaded.jar"
}
tasks.assemble { dependsOn(shadowJar) }

publishing {
    publications {
        create<MavenPublication>("runelite-client") {
            from(components["java"])
            artifact(shadowJar) { classifier = "shaded" }
        }
    }
}

val assemble = tasks.withType<net.runelite.gradle.assemble.AssembleTask> {
    scriptDirectory = file("src/main/scripts")
    outputDirectory = sourceSets.main.map { File(it.output.resourcesDir, "runelite") }
    componentsFile = file("../runelite-api/src/main/interfaces/interfaces.toml")
}

tasks.withType<net.runelite.gradle.index.IndexTask> {
    archiveOverlayDirectory = assemble.single().outputDirectory
    indexFile = archiveOverlayDirectory.file("index")
}

tasks.processResources {
    inputs.property("projectVersion", project.version)

    val commit = ByteArrayOutputStream()
    exec {
        commandLine("git", "rev-parse", "--short=7", "HEAD")
        standardOutput = commit
    }

    val dirty = ByteArrayOutputStream()
    exec {
        commandLine("git", "status", "--short")
        standardOutput = dirty
    }

    filesMatching("net/runelite/client/runelite.properties") {
        filter { it.replace("\${project.version}", project.version.toString()) }
        filter { it.replace("\${git.commit.id.abbrev}", commit.toString().trim()) }
        filter { it.replace("\${git.dirty}", dirty.toString().isNotBlank().toString()) }
    }
}

tasks.compileJava {
    options.isFork = true
}

tasks.jar {
    exclude("**/.clang-format")
}

pmd {
    toolVersion = "7.2.0"
    ruleSetFiles("./pmd-ruleset.xml")
    isConsoleOutput = true
    incrementalAnalysis = true
    isIgnoreFailures = false
    threads = Runtime.getRuntime().availableProcessors()
}
tasks.pmdMain {
    exclude("**/RuntimeTypeAdapterFactory.java")
    exclude("**/net/runelite/client/party/Party.java")
}
tasks.pmdTest { enabled = false }

tasks.checkstyleMain {
    exclude("net/runelite/client/util/RuntimeTypeAdapterFactory.java") // vendored
    exclude("net/runelite/client/party/Party.java") // generated by protobuf
}

tasks.withType<Test> {
    systemProperty("glslang.path", providers.gradleProperty("glslangPath").getOrElse(""))
}

tasks.javadoc {
    title = "RuneLite Client ${project.version} API"
}
