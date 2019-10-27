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

group = "com.openosrs.rs"
description = "Injector"

val deobfuscatedJar = "${project.extra["rootPath"]}/runescape-client/build/libs/runescape-client-${ProjectVersions.rlVersion}.jar"
val vanillaJar = "${buildDir}/vanilla-${ProjectVersions.rsversion}.jar"

val vanilla = configurations.create("vanilla")

dependencies {
    annotationProcessor(Libraries.sisu)

    compileOnly(Libraries.mavenPluginAnnotations)

    implementation(Libraries.guava)
    implementation(Libraries.mavenPluginApi)
    implementation(Libraries.asmAll)
    implementation(Libraries.asmUtil)
    implementation(project(":deobfuscator"))
    implementation(project(":runelite-mixins"))
    implementation(project(":runelite-api"))
    implementation(project(":runescape-api"))

    testImplementation(Libraries.junit)
    testImplementation(Libraries.mockitoCore)
    testImplementation(project(":deobfuscator"))
    testImplementation(project(path = ":deobfuscator", configuration = "testArchives"))

    vanilla(Libraries.vanilla)
}

tasks {
    register<Copy>("copyVanilla") {
        copy {
            from(configurations.get("vanilla"))
            into("$buildDir")
        }
    }

    register<JavaExec>("inject") {
        dependsOn("copyVanilla")

        classpath = project.sourceSets.main.get().runtimeClasspath
        main = "net.runelite.injector.Injector"
        args(listOf(deobfuscatedJar, vanillaJar, project.extra["injectedClassesPath"]))
    }

    compileJava {
        dependsOn(":runescape-client:build")

        inputs.dir(project(":runescape-client").projectDir.absolutePath)
        inputs.dir(project(":runescape-api").projectDir.absolutePath)
        inputs.dir(project(":runelite-mixins").projectDir.absolutePath)
    }

    jar {
        dependsOn("inject")
    }
}
