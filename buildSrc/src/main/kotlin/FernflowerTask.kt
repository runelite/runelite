import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import java.io.File

open class FernflowerTask: DefaultTask() {

    var extraArgs: List<String>? = null
    var inputJar: String? = null
    var outputDir: String? = null

    fun getInputJar(): File {
        return project.file(inputJar ?: project.buildDir.toString() + "/libs/" + project.name + '-' + project.version + ".jar")
    }

    fun getOutputDir(): File {
        return project.file(outputDir ?: project.buildDir.toString() + "/decompiled-sources")
    }

    @TaskAction
    fun decompile() {
        getOutputDir().mkdirs()
        val args = mutableListOf(getInputJar().toString(), getOutputDir().toString())
        if (extraArgs != null) {
            args.addAll(extraArgs!!)
        }

        ConsoleDecompiler.main(args.toTypedArray())
    }
}