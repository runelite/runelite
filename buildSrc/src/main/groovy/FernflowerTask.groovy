import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler

class FernflowerTask extends DefaultTask {
    List<String> extraArgs
    String inputJar
    String outputDir

    @InputFile
    File getInputJar() {
        project.file(inputJar ?: project.buildDir.toString() + '/libs/' + project.getName() + '-' + project.version + '.jar')
    }

    @OutputDirectory
    File getOutputDir() {
        project.file(outputDir ?: project.buildDir.toString() + '/decompiled-sources')
    }

    @TaskAction
    void decompile() {
        getOutputDir().mkdirs()
        def args = [getInputJar().toString(), getOutputDir().toString()]
        if (extraArgs) {
            args.addAll(extraArgs)
        }

        ConsoleDecompiler.main(args as String[])
    }
}