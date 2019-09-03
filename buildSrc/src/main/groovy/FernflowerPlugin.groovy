import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException

class FernflowerPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('decompile', type: FernflowerTask) {
            it.dependsOn(project.tasks.jar)
            it.doFirst {
                if (!project.tasks.jar.didWork) {
                    throw new StopExecutionException()
                }
            }
        }
    }
}
