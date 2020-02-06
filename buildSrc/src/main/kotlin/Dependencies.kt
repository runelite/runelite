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

object ProjectVersions {
    const val launcherVersion = "2.0.4"
    const val rlVersion = "1.6.6-SNAPSHOT"

    const val openosrsVersion = "2.1.26-SNAPSHOT"

    const val rsversion = 188
    const val cacheversion = 165
}

object Plugins {
    const val grgitPlugin = "org.ajoberstar.grgit:grgit-core:4.0.1"
    const val versionsPlugin = "com.github.ben-manes:gradle-versions-plugin:0.27.0"
    const val injectorPlugin = "com.openosrs:injector-plugin:1.0.3.1"
    val testLogger = Pair("com.adarshr.test-logger", "2.0.0")
    val versions = Pair("com.github.ben-manes.versions", "0.27.0")
    val latestVersion = Pair("se.patrikerdes.use-latest-versions", "0.2.13")
    val grgit = Pair("org.ajoberstar.grgit", "4.0.1")
    val jarTest = Pair("com.github.hauner.jarTest", "1.0.1")
    val shadow = Pair("com.github.johnrengelman.shadow", "5.2.0")
}

object Libraries {
    private object Versions {
        const val annotations = "18.0.0"
        const val antlr = "4.7.2"
        const val apacheCommonsCompress = "1.19"
        const val apacheCommonsCsv = "1.7"
        const val apacheCommonsText = "1.8"
        const val asm = "7.2"
        const val commonsCli = "1.4"
        const val discord = "1.1"
        const val fernflower = "07082019"
        const val findbugs = "3.0.2"
        const val gson = "2.8.6"
        const val guava = "28.2-jre"
        const val guice = "4.2.2"
        const val h2 = "1.4.200"
        const val hamcrest = "2.2"
        const val javax = "1.3.2"
        const val javaxInject = "1"
        const val jna = "5.5.0"
        const val jogamp = "2.3.2"
        const val jopt = "5.0.4"
        const val jooq = "3.12.3"
        const val junit = "4.13"
        const val jupiter = "5.6.0-M1"
        const val logback = "1.2.3"
        const val lombok = "1.18.10"
        const val mavenPluginAnnotations = "3.6.0"
        const val mavenPluginApi = "3.6.3"
        const val mockito = "3.2.4"
        const val naturalMouse = "2.0.2"
        const val netty = "4.1.44.Final"
        const val okhttp3 = "4.3.0"
        const val orangeExtensions = "1.0"
        const val petitparser = "2.3.1"
        const val plexus = "3.3.0"
        const val radiance = "2.5.1"
        const val rxjava = "2.2.16"
        const val rxrelay = "2.1.1"
        const val sisu = "0.3.4"
        const val sentry = "1.7.29"
        const val slf4j = "1.7.30"
    }

    const val annotations = "org.jetbrains:annotations:${Versions.annotations}"
    const val antlr = "org.antlr:antlr4-runtime:${Versions.antlr}"
    const val apacheCommonsCompress = "org.apache.commons:commons-compress:${Versions.apacheCommonsCompress}"
    const val apacheCommonsCsv = "org.apache.commons:commons-csv:${Versions.apacheCommonsCsv}"
    const val apacheCommonsText = "org.apache.commons:commons-text:${Versions.apacheCommonsText}"
    const val asmAll = "org.ow2.asm:asm:${Versions.asm}"
    const val asmUtil = "org.ow2.asm:asm-util:${Versions.asm}"
    const val commonsCli = "commons-cli:commons-cli:${Versions.commonsCli}"
    const val discord = "net.runelite:discord:${Versions.discord}"
    const val fernflower = "net.runelite:fernflower:${Versions.fernflower}"
    const val findbugs = "com.google.code.findbugs:jsr305:${Versions.findbugs}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val guava = "com.google.guava:guava:${Versions.guava}"
    const val guice = "com.google.inject:guice:${Versions.guice}:no_aop"
    const val guiceGrapher = "com.google.inject.extensions:guice-grapher:${Versions.guice}"
    const val guiceTestlib = "com.google.inject.extensions:guice-testlib:${Versions.guice}"
    const val h2 = "com.h2database:h2:${Versions.h2}"
    const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    const val javax = "javax.annotation:javax.annotation-api:${Versions.javax}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    const val jna = "net.java.dev.jna:jna:${Versions.jna}"
    const val jnaPlatform = "net.java.dev.jna:jna-platform:${Versions.jna}"
    const val jogampJogl = "org.jogamp.jogl:jogl-all:${Versions.jogamp}"
    const val jogampGluegen = "org.jogamp.gluegen:gluegen-rt:${Versions.jogamp}"
    const val jogampGluegenLinuxAmd64 = "org.jogamp.gluegen:gluegen-rt:${Versions.jogamp}:natives-linux-amd64"
    const val jogampGluegenLinuxI586 = "org.jogamp.gluegen:gluegen-rt:${Versions.jogamp}:natives-linux-i586"
    const val jogampGluegenWindowsAmd64 = "org.jogamp.gluegen:gluegen-rt:${Versions.jogamp}:natives-windows-amd64"
    const val jogampGluegenWindowsI586 = "org.jogamp.gluegen:gluegen-rt:${Versions.jogamp}:natives-windows-i586"
    const val jogampJoglLinuxAmd64 = "org.jogamp.jogl:jogl-all:${Versions.jogamp}:natives-linux-amd64"
    const val jogampJoglLinuxI586 = "org.jogamp.jogl:jogl-all:${Versions.jogamp}:natives-linux-i586"
    const val jogampJoglWindowsAmd64 = "org.jogamp.jogl:jogl-all:${Versions.jogamp}:natives-windows-amd64"
    const val jogampJoglWindowsI586 = "org.jogamp.jogl:jogl-all:${Versions.jogamp}:natives-windows-i586"
    const val jopt = "net.sf.jopt-simple:jopt-simple:${Versions.jopt}"
    const val jooq = "org.jooq:jooq:${Versions.jooq}"
    const val jooqCodegen = "org.jooq:jooq-codegen:${Versions.jooq}"
    const val jooqMeta = "org.jooq:jooq-meta:${Versions.jooq}"
    const val junit = "junit:junit:${Versions.junit}"
    const val jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}"
    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
    const val lombok = "org.projectlombok:lombok:${Versions.lombok}"
    const val mavenPluginAnnotations = "org.apache.maven.plugin-tools:maven-plugin-annotations:${Versions.mavenPluginAnnotations}"
    const val mavenPluginApi = "org.apache.maven:maven-plugin-api:${Versions.mavenPluginApi}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val naturalMouse = "com.github.joonasvali.naturalmouse:naturalmouse:${Versions.naturalMouse}"
    const val nettyBuffer = "io.netty:netty-buffer:${Versions.netty}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val okhttp3Webserver = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp3}"
    const val orangeExtensions = "net.runelite:orange-extensions:${Versions.orangeExtensions}"
    const val petitparser = "com.github.petitparser:java-petitparser:${Versions.petitparser}"
    const val plexus = "org.codehaus.plexus:plexus-utils:${Versions.plexus}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxrelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxrelay}"
    const val sisu = "org.eclipse.sisu:org.eclipse.sisu.inject:${Versions.sisu}"
    const val slf4jApi = "org.slf4j:slf4j-api:${Versions.slf4j}"
    const val slf4jNop = "org.slf4j:slf4j-nop:${Versions.slf4j}"
    const val slf4jSimple = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    const val sentry = "io.sentry:sentry:${Versions.sentry}"
    const val substance = "org.pushing-pixels:radiance-substance:${Versions.radiance}"
    const val trident = "org.pushing-pixels:radiance-trident:${Versions.radiance}"
    const val vanilla = "net.runelite.rs:vanilla:${ProjectVersions.rsversion}"
}
