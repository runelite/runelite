import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException
import org.gradle.api.tasks.diagnostics.DependencyReportTask
import org.gradle.kotlin.dsl.register

class FernflowerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register<FernflowerTask>("decompile") {
            dependsOn(project.tasks.getByName("jar"))

            doFirst {
                if (!project.tasks.getByName("jar").didWork) {
                    throw StopExecutionException()
                }
            }
        }
    }
}