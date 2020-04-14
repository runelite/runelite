/*
 * Copyright (c) 2019 ThatGamerBlue
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

apply<FernflowerPlugin>()

description = "Injected Client"

plugins {
    id("com.openosrs.injector")
}

val vanillaDep by configurations.creating
val rsapiDep by configurations.creating
val rsclientDep by configurations.creating
val mixinsDep by configurations.creating
val combined by configurations.creating {
    extendsFrom(rsapiDep, rsclientDep, mixinsDep, vanillaDep)
    isCanBeResolved = true
    isCanBeConsumed = false
}

configurations {
    all {
        isTransitive = false
        outgoing.artifact(tasks.inject.get().output)
    }
}

dependencies {
    vanillaDep(group = "net.runelite.rs", name = "vanilla", version = ProjectVersions.rsversion.toString())
    rsapiDep(project(":runescape-api"))
    rsclientDep(project(":runescape-client"))
    mixinsDep(project(":runelite-mixins"))
}

injector {
    mixins.set(mixinsDep.singleFile)
    rsapi.set(rsapiDep.singleFile)
    rsclient.set(rsclientDep.singleFile)
    vanilla.set(vanillaDep.singleFile)
}

sourceSets {
    main {
        output.dir(tasks.inject.get().output.get().asFile.parentFile, "builtBy" to tasks.inject)
    }
}

// keep the sourcesets etc but remove useless tasks
tasks {
    inject {
        dependsOn(configurations["combined"])
    }
    classes {
        enabled = false
    }
    compileJava {
        enabled = false
    }
    jar {
        enabled = false
    }
    processResources {
        enabled = false
    }
}
