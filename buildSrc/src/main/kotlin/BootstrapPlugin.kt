import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

class BootstrapPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        val clientJar by configurations.creating {
            isCanBeConsumed = false
            isCanBeResolved = true
            isTransitive = false
        }
        val bootstrapDependencies by configurations.creating {
            extendsFrom(clientJar)
            isCanBeConsumed = false
            isCanBeResolved = true
            isTransitive = false
        }

        dependencies {
            clientJar(tasks["jar"].outputs.files)
            bootstrapDependencies(project(":runelite-api"))
            bootstrapDependencies(project(":runescape-api"))
            bootstrapDependencies(project(":http-api"))
            bootstrapDependencies(project(":injected-client"))
        }

        tasks.register<BootstrapTask>("bootstrapStaging", "staging")
        tasks.register<BootstrapTask>("bootstrapNightly", "nightly")
        tasks.register<BootstrapTask>("bootstrapStable", "stable")

        tasks.withType<BootstrapTask> {
            dependsOn(bootstrapDependencies)
            dependsOn("publish")
            dependsOn(project(":runelite-api").tasks["publish"])
            dependsOn(project(":runescape-api").tasks["publish"])
            dependsOn(project(":http-api").tasks["publish"])
            dependsOn(project(":injected-client").tasks["publish"])

            this.clientJar = clientJar.singleFile

            doLast {
                copy {
                    from(bootstrapDependencies)
                    into("${buildDir}/bootstrap/${type}/")
                }
                copy {
                    from(
                            "${buildDir}/repo/.",
                            "${parent?.projectDir}/injected-client/build/repo/.",
                            "${parent?.projectDir}/runelite-api/build/repo/.",
                            "${parent?.projectDir}/http-api/build/repo/.",
                            "${parent?.projectDir}/runescape-api/build/repo/."
                    )
                    into("${buildDir}/bootstrap/repo/${type}")
                }
            }
        }
    }
}
