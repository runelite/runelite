/*
 * Copyright (c) 2024, LlemonDuck <napkinorton@gmail.com>
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

package net.runelite.gradle.assemble;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.savers.ScriptSaver;
import net.runelite.cache.script.RuneLiteInstructions;
import net.runelite.cache.script.assembler.Assembler;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;
import org.tomlj.Toml;
import org.tomlj.TomlParseError;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

@CacheableTask
public abstract class AssembleTask extends DefaultTask
{
	@InputDirectory
	@PathSensitive(PathSensitivity.RELATIVE)
	public abstract DirectoryProperty getScriptDirectory();

	@OutputDirectory
	public abstract DirectoryProperty getOutputDirectory();

	@InputFile
	@PathSensitive(PathSensitivity.RELATIVE)
	public abstract RegularFileProperty getComponentsFile();

	private final Logger log = getLogger();

	@TaskAction
	public void assembleRs2Asm() throws IOException
	{
		File scriptDirectory = getScriptDirectory().getAsFile().get();
		File outputDirectory = getOutputDirectory().getAsFile().get();
		File componentsFile = getComponentsFile().getAsFile().get();

		RuneLiteInstructions instructions = new RuneLiteInstructions();
		instructions.init();

		Assembler assembler = new Assembler(instructions, buildComponentSymbols(componentsFile));
		ScriptSaver saver = new ScriptSaver();

		int count = 0;
		File scriptOut = new File(outputDirectory, Integer.toString(IndexType.CLIENTSCRIPT.getNumber()));
		scriptOut.mkdirs();

		for (File scriptFile : scriptDirectory.listFiles((dir, name) -> name.endsWith(".rs2asm")))
		{
			log.debug("Assembling {}", scriptFile);

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
					throw new FileNotFoundException("Unable to find hash file for " + scriptFile);
				}

				++count;
			}
		}

		log.lifecycle("Assembled {} scripts", count);
	}

	private Map<String, Object> buildComponentSymbols(File file)
	{
		TomlParseResult result;
		try
		{
			result = Toml.parse(file.toPath());
		}
		catch (IOException e)
		{
			throw new RuntimeException("unable to read component file " + file.getName(), e);
		}

		if (result.hasErrors())
		{
			for (TomlParseError err : result.errors())
			{
				log.error(err.toString());
			}
			throw new RuntimeException("unable to parse component file " + file.getName());
		}

		Map<String, Object> symbols = new HashMap<>();
		for (var entry : result.entrySet())
		{
			var interfaceName = entry.getKey();
			TomlTable tbl = (TomlTable) entry.getValue();

			if (!tbl.contains("id"))
			{
				throw new RuntimeException("interface " + interfaceName + " has no id");
			}

			int interfaceId = (int) (long) tbl.getLong("id");
			if (interfaceId < 0 || interfaceId > 0xffff)
			{
				throw new RuntimeException("interface id out of range for " + interfaceName);
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
					throw new RuntimeException("component id out of range for " + componentName);
				}

				var fullName = interfaceName.toLowerCase(Locale.ENGLISH) + ":" + componentName.toLowerCase(Locale.ENGLISH);
				int componentId = (interfaceId << 16) | id;

				symbols.put(fullName, componentId);
			}
		}

		return symbols;
	}
}
