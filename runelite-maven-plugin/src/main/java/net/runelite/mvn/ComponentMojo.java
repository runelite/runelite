/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.lang.model.element.Modifier;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.tomlj.Toml;
import org.tomlj.TomlParseError;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

@Mojo(
	name = "pack-components",
	defaultPhase = LifecyclePhase.GENERATE_SOURCES
)
public class ComponentMojo extends AbstractMojo
{
	@Parameter(defaultValue = "${project}")
	private MavenProject project;

	@Parameter(required = true)
	private File inputDirectory;

	@Parameter(required = true)
	private File outputDirectory;

	private final Log log = getLog();
	private final Set<Integer> seenInterfaces = new HashSet<>();
	private final Set<Integer> seenComponents = new HashSet<>();

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
		TypeSpec.Builder interfaceType = TypeSpec.classBuilder("InterfaceID")
			.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
			.addAnnotation(Deprecated.class);

		TypeSpec.Builder componentType = TypeSpec.classBuilder("ComponentID")
			.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
			.addAnnotation(Deprecated.class);

		for (File file : inputDirectory.listFiles((dir, name) -> name.endsWith(".toml")))
		{
			executeOne(file, interfaceType, componentType);
		}

		writeClass("net.runelite.api.widgets", interfaceType.build());
		writeClass("net.runelite.api.widgets", componentType.build());

		// https://stackoverflow.com/a/30760908
		project.addCompileSourceRoot(outputDirectory.getAbsolutePath());
	}

	private void executeOne(File file, TypeSpec.Builder interfaceType, TypeSpec.Builder componentType) throws MojoExecutionException
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

			if (seenInterfaces.contains(interfaceId))
			{
				throw new MojoExecutionException("duplicate interface id " + interfaceId);
			}
			seenInterfaces.add(interfaceId);

			addField(interfaceType, interfaceName.toUpperCase(Locale.ENGLISH), interfaceId, null);

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

				var fullName = interfaceName.toUpperCase(Locale.ENGLISH) + "_" + componentName.toUpperCase(Locale.ENGLISH);
				var comment = interfaceId + ":" + id;
				int componentId = (interfaceId << 16) | id;

				if (seenComponents.contains(componentId))
				{
					throw new MojoExecutionException("duplicate component id " + comment);
				}
				seenComponents.add(componentId);

				addField(componentType, fullName, componentId, comment);
			}
		}
	}

	private static void addField(TypeSpec.Builder type, String name, int value, String comment)
	{
		FieldSpec.Builder field = FieldSpec.builder(int.class, name)
			.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
			.initializer("$L", value);
		if (comment != null)
		{
			field.addJavadoc(comment);
		}
		type.addField(field.build());
	}

	private void writeClass(String pkg, TypeSpec type) throws MojoExecutionException
	{
		JavaFile javaFile = JavaFile.builder(pkg, type)
			.build();

		try
		{
			javaFile.writeTo(outputDirectory);
		}
		catch (IOException e)
		{
			throw new MojoExecutionException("unable to write java class", e);
		}
	}
}
