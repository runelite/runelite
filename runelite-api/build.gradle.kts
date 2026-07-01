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
    checkstyle
    alias(libs.plugins.lombok)

    id("net.runelite.runelite-gradle-plugin.component")
}

lombok.version = libs.versions.lombok.get()

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(libs.slf4j.api)
    compileOnly(libs.findbugs)

    compileOnly(libs.jetbrains.annotations)

    testImplementation(libs.junit)
    testRuntimeOnly(libs.slf4j.simple)
}

val runtimeJar = tasks.register<Jar>("runtimeJar") {
    this@register.group = BasePlugin.BUILD_GROUP

    from(sourceSets.main.get().output)
    archiveClassifier = "runtime"

    /*  from JLS 13.1.3: references to a static field that is a constant variable (§4.12.4) must be resolved
                         at compile time to the value denoted by the constant variable's initializer *and* no references to the
                         field should be present in the code in a binary file.

        This permits us to remove the classes containing only these types of fields at runtime */
    exclude("net/runelite/api/annotations/*.class")
    exclude("net/runelite/api/clan/ClanID.class")
    exclude("net/runelite/api/dbtable/DBTableID*.class")
    exclude("net/runelite/api/widgets/ComponentID.class")
    exclude("net/runelite/api/widgets/InterfaceID.class")
    exclude("net/runelite/api/widgets/ItemQuantityMode.class")
    exclude("net/runelite/api/widgets/WidgetID*.class")
    exclude("net/runelite/api/widgets/WidgetModalMode.class")
    exclude("net/runelite/api/widgets/WidgetModelType.class")
    exclude("net/runelite/api/widgets/WidgetPositionMode.class")
    exclude("net/runelite/api/widgets/WidgetSizeMode.class")
    exclude("net/runelite/api/widgets/WidgetTextAlignment.class")
    exclude("net/runelite/api/widgets/WidgetType.class")
    exclude("net/runelite/api/AnimationID.class")
    exclude("net/runelite/api/CollisionDataFlag.class")
    exclude("net/runelite/api/EnumID.class")
    exclude("net/runelite/api/FontID.class")
    exclude("net/runelite/api/GraphicID.class")
    exclude("net/runelite/api/HintArrowType.class")
    exclude("net/runelite/api/HitsplatID.class")
    exclude("net/runelite/api/ItemID.class")
    exclude("net/runelite/api/KeyCode.class")
    exclude("net/runelite/api/NpcID.class")
    exclude("net/runelite/api/NullItemID.class")
    exclude("net/runelite/api/NullNpcID.class")
    exclude("net/runelite/api/NullObjectID.class")
    exclude("net/runelite/api/ObjectID.class")
    exclude("net/runelite/api/Opcodes.class")
    exclude("net/runelite/api/ParamID.class")
    exclude("net/runelite/api/ScriptID.class")
    exclude("net/runelite/api/SettingID.class")
    exclude("net/runelite/api/SkullIcon.class")
    exclude("net/runelite/api/SoundEffectID.class")
    exclude("net/runelite/api/SoundEffectVolume.class")
    exclude("net/runelite/api/SpriteID.class")
    exclude("net/runelite/api/StructID.class")
    exclude("net/runelite/api/Varbits.class")
    exclude("net/runelite/api/VarClientInt.class")
    exclude("net/runelite/api/VarClientStr.class")
    exclude("net/runelite/api/VarPlayer.class")
    exclude("net/runelite/api/gameval/*.class")
}
tasks.assemble { dependsOn(runtimeJar) }

publishing {
    publications {
        create<MavenPublication>("api") {
            from(components["java"])
            artifact(runtimeJar) { classifier = "runtime" }
        }
    }
}

tasks.withType<net.runelite.gradle.component.ComponentTask> {
    inputFile = file("src/main/interfaces/interfaces.toml")
    outputDirectory = file("build/generated/sources/runelite/java/main")
}

tasks.checkstyleMain {
    exclude("net/runelite/api/widgets/ComponentID.java")
    exclude("net/runelite/api/widgets/InterfaceID.java")
}

tasks.javadoc {
    title = "RuneLite API ${project.version} API"

    exclude(
        "net/runelite/api/gameval/**",
        "net/runelite/api/AnimationID.java",
        "net/runelite/api/ItemID.java",
        "net/runelite/api/NullItemID.java",
        "net/runelite/api/ObjectID.java",
        "net/runelite/api/NullObjectID.java",
        "net/runelite/api/NpcID.java",
        "net/runelite/api/NullNpcID.java",
    )
}
