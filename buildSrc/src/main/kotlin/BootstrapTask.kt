import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.get
import java.io.File
import java.security.MessageDigest
import javax.inject.Inject

open class BootstrapTask @Inject constructor(@Input val type: String) : DefaultTask() {

    @InputFile
    @PathSensitive(PathSensitivity.ABSOLUTE)
    var clientJar: File? = null

    @Input
    val launcherJvm11Arguments = arrayOf("-XX:+DisableAttachMechanism", "-Drunelite.launcher.nojvm=true", "-Xmx512m", "-Xss2m", "-XX:CompileThreshold=1500", "-Djna.nosys=true")

    @Input
    val launcherArguments = arrayOf("-XX:+DisableAttachMechanism", "-Drunelite.launcher.nojvm=true", "-Xmx512m", "-Xss2m", "-XX:CompileThreshold=1500", "-Xincgc", "-XX:+UseConcMarkSweepGC", "-XX:+UseParNewGC", "-Djna.nosys=true")

    @Input
    val clientJvmArguments = arrayOf("-XX:+DisableAttachMechanism", "-Xmx512m", "-Xss2m", "-XX:CompileThreshold=1500", "-Xincgc", "-XX:+UseConcMarkSweepGC", "-XX:+UseParNewGC", "-Djna.nosys=true", "-Dawt.useSystemAAFontSettings=on", "-Dswing.aatext=true")

    @Input
    val clientJvm9Arguments = arrayOf("-XX:+DisableAttachMechanism", "-Xmx512m", "-Xss2m", "-XX:CompileThreshold=1500", "-Djna.nosys=true", "-Dawt.useSystemAAFontSettings=on", "-Dswing.aatext=true")

    private fun hash(file: ByteArray): String {
        return MessageDigest.getInstance("SHA-256").digest(file).fold("", { str, it -> str + "%02x".format(it) })
    }

    private fun getArtifacts(): Array<JsonBuilder> {
        val artifacts = ArrayList<JsonBuilder>()

        project.configurations["runtimeClasspath"].resolvedConfiguration.resolvedArtifacts.forEach {
            val module = it.moduleVersion.id.toString()

            val splat = module.split(":")
            val name = splat[1]
            val group = splat[0]
            val version = splat[2]
            lateinit var path: String

            if (it.file.name.contains(ProjectVersions.rlVersion)) {
                path = "https://github.com/open-osrs/hosting/raw/master/${type}/${it.file.name}"
            } else if (!group.contains("runelite")) {
                path = "https://repo.maven.apache.org/maven2/" + group.replace(".", "/") + "/${name}/$version/${name}-$version"
                if (it.classifier != null && it.classifier != "no_aop") {
                    path += "-${it.classifier}"
                }
                path += ".jar"
            } else if (it.file.name.contains("trident") || it.file.name.contains("discord") || it.file.name.contains("substance")) {
                path = "https://repo.runelite.net/net/runelite/"
                if (!it.file.name.contains("discord")) {
                    path += "pushingpixels/"
                }
                path += "${name}/$version/${name}-$version.jar"
            }

            val artifactFile = File(it.file.absolutePath)

            artifacts.add(JsonBuilder(
                    "name" to it.file.name,
                    "path" to path,
                    "size" to artifactFile.length(),
                    "hash" to hash(artifactFile.readBytes())
            ))
        }

        artifacts.add(JsonBuilder(
                "name" to clientJar!!.name,
                "path" to "https://github.com/open-osrs/hosting/raw/master/${type}/${clientJar!!.name}",
                "size" to clientJar!!.length(),
                "hash" to hash(clientJar!!.readBytes())
        ))

        return artifacts.toTypedArray()
    }

    @TaskAction
    fun bootstrap() {
        val json = JsonBuilder(
                "projectVersion" to ProjectVersions.openosrsVersion,
                "minimumLauncherVersion" to ProjectVersions.launcherVersion,
                "launcherJvm11Arguments" to launcherJvm11Arguments,
                "launcherArguments" to launcherArguments,
                "clientJvmArguments" to clientJvmArguments,
                "clientJvm9Arguments" to clientJvm9Arguments,
                "buildCommit" to project.extra["gitCommit"],
                "artifacts" to getArtifacts()
        ).toString()

        val bootstrapDir = File("${project.buildDir}/bootstrap")
        bootstrapDir.mkdirs()

        File(bootstrapDir, "bootstrap-${type}.json").printWriter().use { out ->
            out.println(json)
        }
    }
}
