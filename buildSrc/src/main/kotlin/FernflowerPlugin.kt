import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException

class FernflowerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("decompile", FernflowerTask::class.java).run {
            dependsOn(project.tasks.getByName("jar"))

            doFirst {
                if (!project.tasks.getByName("jar").didWork) {
                    throw StopExecutionException()
                }
            }
        }
    }
}