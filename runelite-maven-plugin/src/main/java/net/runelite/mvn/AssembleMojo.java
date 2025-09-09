/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.mvn;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.savers.ScriptSaver;
import net.runelite.cache.script.RuneLiteInstructions;
import net.runelite.cache.script.assembler.Assembler;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.tomlj.Toml;
import org.tomlj.TomlParseError;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

@Mojo(
	name = "assemble",
	defaultPhase = LifecyclePhase.GENERATE_RESOURCES
)
public class AssembleMojo extends AbstractMojo
{
	@Parameter(required = true)
	private File scriptDirectory;

	@Parameter(required = true)
	private File outputDirectory;

	@Parameter(required = true)
	private File componentsFile;

	private final Log log = getLog();

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
		RuneLiteInstructions instructions = new RuneLiteInstructions();
		instructions.init();

		Assembler assembler = new Assembler(instructions, buildComponentSymbols(componentsFile));
		ScriptSaver saver = new ScriptSaver();

		int count = 0;
		File scriptOut = new File(outputDirectory, Integer.toString(IndexType.CLIENTSCRIPT.getNumber()));
		scriptOut.mkdirs();

		for (File scriptFile : scriptDirectory.listFiles((dir, name) -> name.endsWith(".rs2asm")))
		{
			log.debug("Assembling " + scriptFile);

			try (FileInputStream fin = new FileInputStream(scriptFile))
			{
				ScriptDefinition script = assembler.assemble(fin);
				byte[] packedScript = saver.save(script);

				File targetFile = new File(scriptOut, Integer.toString(script.getId()));
				Files.write(packedScript, targetFile);

				// Copy hash file

				File hashFile = new File(scriptDirectory, Files.getNameWithoutExtension(scriptFile.getName()) + ".hash");
				if (hashFile.exists())
				{
					Files.copy(hashFile, new File(scriptOut, Integer.toString(script.getId()) + ".hash"));
				}
				else if (script.getId() < 10000) // Scripts >=10000 are RuneLite scripts, so they shouldn't have a .hash
				{
					throw new MojoExecutionException("Unable to find hash file for " + scriptFile);
				}

				++count;
			}
			catch (IOException ex)
			{
				throw new MojoFailureException("unable to open file", ex);
			}
		}

		log.info("Assembled " + count + " scripts");
	}

	private Map<String, Object> buildComponentSymbols(File file) throws MojoExecutionException
	{
		TomlParseResult result;
		try
		{
			result = Toml.parse(file.toPath());
		}
		catch (IOException e)
		{
			throw new MojoExecutionException("unable to read component file " + file.getName(), e);
		}

		if (result.hasErrors())
		{
			for (TomlParseError err : result.errors())
			{
				log.error(err.toString());
			}
			throw new MojoExecutionException("unable to parse component file " + file.getName());
		}

		Map<String, Object> symbols = new HashMap<>();
		for (var entry : result.entrySet())
		{
			var interfaceName = entry.getKey();
			TomlTable tbl = (TomlTable) entry.getValue();

			if (!tbl.contains("id"))
			{
				throw new MojoExecutionException("interface " + interfaceName + " has no id");
			}

			int interfaceId = (int) (long) tbl.getLong("id");
			if (interfaceId < 0 || interfaceId > 0xffff)
			{
				throw new MojoExecutionException("interface id out of range for " + interfaceName);
			}

			for (var entry2 : tbl.entrySet())
			{
				var componentName = entry2.getKey();
				if (componentName.equals("id"))
				{
					continue;
				}

				int id = (int) (long) entry2.getValue();
				if (id < 0 || id > 0xffff)
				{
					throw new MojoExecutionException("component id out of range for " + componentName);
				}

				var fullName = interfaceName.toLowerCase(Locale.ENGLISH) + ":" + componentName.toLowerCase(Locale.ENGLISH);
				int componentId = (interfaceId << 16) | id;

				symbols.put(fullName, componentId);
			}
		}

		return symbols;
	}
}
