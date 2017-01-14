/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.injector;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.objectwebasm.NonloadingClassWriter;
import net.runelite.deob.clientver.ClientVersion;
import net.runelite.deob.injection.Injector;
import net.runelite.deob.util.JarUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.objectweb.asm.ClassWriter;

@Mojo(
	name = "runelite-injector",
	defaultPhase = LifecyclePhase.GENERATE_RESOURCES
)
public class InjectMojo extends AbstractMojo
{
	@Parameter(defaultValue = "${project.build.outputDirectory}")
	private File outputDirectory;

	@Parameter(defaultValue = "${net.runelite.rs:rs-client:jar}", readonly = true, required = true)
	private String rsClientPath;

	@Parameter(defaultValue = "${net.runelite.rs:vanilla:jar}", readonly = true, required = true)
	private String vanillaPath;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
		Log log = getLog();

		ClientVersion ver = new ClientVersion(new File(vanillaPath));
		int version;
		try
		{
			version = ver.getVersion();
		}
		catch (IOException ex)
		{
			throw new MojoExecutionException("Unable to read vanilla client version", ex);
		}

		log.info("Vanilla client version " + version);

		ClassGroup rs;
		ClassGroup vanilla;

		try
		{
			rs = JarUtil.loadJar(new File(rsClientPath));
			vanilla = JarUtil.loadJar(new File(vanillaPath));
		}
		catch (IOException ex)
		{
			throw new MojoExecutionException("Unable to load dependency jars", ex);
		}

		Injector injector = new Injector(rs, vanilla);
		injector.inject();

		try
		{
			writeClasses(vanilla, outputDirectory);
		}
		catch (IOException ex)
		{
			throw new MojoExecutionException("Unable to write classes", ex);
		}

		log.info("Injector wrote " + vanilla.getClasses().size() + " classes");
	}

	private void writeClasses(ClassGroup group, File outputDirectory) throws IOException
	{
		for (ClassFile cf : group.getClasses())
		{
			ClassWriter writer = new NonloadingClassWriter(group, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
			cf.accept(writer);

			File classFile = getClassFile(outputDirectory, cf);

			try (FileOutputStream fout = new FileOutputStream(classFile, false))
			{
				fout.write(writer.toByteArray());
			}
		}
	}

	private File getClassFile(File base, ClassFile cf)
	{
		File f = base;

		String[] parts = cf.getName().split("/");
		for (int i = 0; i < parts.length - 1; ++i)
		{
			String part = parts[i];

			f = new File(f, part);
		}

		f.mkdirs();
		f = new File(f, parts[parts.length - 1] + ".class");

		return f;
	}

}
