import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler

@CacheableTask
open class FernflowerTask: DefaultTask() {

    @Input
    @Optional
    var extraArgs: List<String>? = null

    @Input
    @Optional
    var inputJar: String? = null

    @Input
    @Optional
    var outputDir: String? = null

    @InputFile
    @PathSensitive(PathSensitivity.ABSOLUTE)
    var getInputJar = project.file(inputJar ?: "${project.buildDir}/libs/${project.name}-${project.version}.jar")

    @OutputDirectory
    var getOutputDir = project.file(outputDir ?: "${project.buildDir}/decompiled-sources")


    @TaskAction
    fun decompile() {
        getOutputDir.mkdirs()
        val args = mutableListOf(getInputJar.toString(), getOutputDir.toString())
        if (extraArgs != null) {
            args.addAll(extraArgs!!)
        }

        ConsoleDecompiler.main(args.toTypedArray())
    }
}