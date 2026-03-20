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

tasks.register("cleanAll") {
    gradle.includedBuilds.forEach { build -> this@register.dependsOn(build.task(":clean")) }
    subprojects.forEach { proj -> this@register.dependsOn(proj.tasks["clean"]) }
}

tasks.register("buildAll") {
    gradle.includedBuilds.forEach { build -> this@register.dependsOn(build.task(":build")) }
    subprojects.forEach { proj -> this@register.dependsOn(proj.tasks["build"]) }
}

tasks.register("assembleAll") {
    gradle.includedBuilds.forEach { build -> this@register.dependsOn(build.task(":assemble")) }
    subprojects.forEach { proj -> this@register.dependsOn(proj.tasks["assemble"]) }
}

tasks.register("testAll") {
    gradle.includedBuilds.forEach { build -> this@register.dependsOn(build.task(":test")) }
    subprojects.forEach { proj -> this@register.dependsOn(proj.tasks["test"]) }
}

tasks.register("publishAll") {
    this@register.dependsOn(project(":client").tasks["publish"])
    this@register.dependsOn(project(":jshell").tasks["publish"])

    this@register.dependsOn(gradle.includedBuild("cache").task(":publish"))
    this@register.dependsOn(gradle.includedBuild("runelite-api").task(":publish"))
}

tasks.register("publishAllToMavenLocal") {
    this@register.dependsOn(project(":client").tasks["publishToMavenLocal"])
    this@register.dependsOn(project(":jshell").tasks["publishToMavenLocal"])

    this@register.dependsOn(gradle.includedBuild("cache").task(":publishToMavenLocal"))
    this@register.dependsOn(gradle.includedBuild("runelite-api").task(":publishToMavenLocal"))
}
