import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import java.io.File

class BootstrapPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register<BootstrapTask>("bootstrapStaging") {
            dependsOn("jar")
            dependsOn("shadowJar")

            type = "staging"
            clientJar = project.tasks["jar"].outputs.files.singleFile

            dependsOn(project.parent!!.project(":runelite-api").tasks["jar"])
            dependsOn(project.parent!!.project(":runescape-api").tasks["jar"])
            dependsOn(project.parent!!.project(":http-api").tasks["jar"])
            dependsOn(project.parent!!.project(":injected-client").tasks["jar"])

            doLast {

                project.copy {
                    from(project.tasks["jar"])
                    from(project.parent!!.project(":runelite-api").tasks["jar"])
                    from(project.parent!!.project(":runescape-api").tasks["jar"])
                    from(project.parent!!.project(":http-api").tasks["jar"])
                    from(project.parent!!.project(":injected-client").tasks["jar"])

                    into("${project.buildDir}/bootstrap/${type}/")
                }
            }
        }

        project.tasks.register<BootstrapTask>("bootstrapStable") {
            dependsOn("jar")
            dependsOn("shadowJar")

            type = "stable"
            clientJar = project.tasks["jar"].outputs.files.singleFile

            dependsOn(project.parent!!.project(":runelite-api").tasks["jar"])
            dependsOn(project.parent!!.project(":runescape-api").tasks["jar"])
            dependsOn(project.parent!!.project(":http-api").tasks["jar"])
            dependsOn(project.parent!!.project(":injected-client").tasks["jar"])

            doLast {

                project.copy {
                    from(project.tasks["jar"])
                    from(project.parent!!.project(":runelite-api").tasks["jar"])
                    from(project.parent!!.project(":runescape-api").tasks["jar"])
                    from(project.parent!!.project(":http-api").tasks["jar"])
                    from(project.parent!!.project(":injected-client").tasks["jar"])

                    into("${project.buildDir}/bootstrap/${type}/")
                }
            }
        }

        project.tasks.register<BootstrapTask>("bootstrapNightly") {
            dependsOn("jar")
            dependsOn("shadowJar")

            type = "nightly"
            clientJar = project.tasks["jar"].outputs.files.singleFile

            dependsOn(project.parent!!.project(":runelite-api").tasks["jar"])
            dependsOn(project.parent!!.project(":runescape-api").tasks["jar"])
            dependsOn(project.parent!!.project(":http-api").tasks["jar"])
            dependsOn(project.parent!!.project(":injected-client").tasks["jar"])

            doLast {

                project.copy {
                    from(project.tasks["jar"])
                    from(project.parent!!.project(":runelite-api").tasks["jar"])
                    from(project.parent!!.project(":runescape-api").tasks["jar"])
                    from(project.parent!!.project(":http-api").tasks["jar"])
                    from(project.parent!!.project(":injected-client").tasks["jar"])

                    into("${project.buildDir}/bootstrap/${type}/")
                }
            }
        }
    }
}