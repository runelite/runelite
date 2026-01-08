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
package net.runelite.gradle.jarsign;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.plugins.BasePlugin;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.jvm.tasks.Jar;

public abstract class JarsignPlugin implements Plugin<Project>
{

	@Override
	public void apply(Project project)
	{
		JarsignExtension ext = project.getExtensions()
			.create(JarsignExtension.class, "jarsign", JarsignExtension.class);
		ext.getKeystore().convention(toRegularFileProvider(project, propProvider(project, "jarsignerKeystore")));
		ext.getStorePass().convention(propProvider(project, "jarsignerStorepass"));
		ext.getKeyPass().convention(propProvider(project, "jarsignerKeypass"));
		ext.getAlias().convention(propProvider(project, "jarsignerAlias"));

		project.getTasks()
			.withType(Jar.class, jarTask -> registerSignTask(project, jarTask, ext));
	}

	private void registerSignTask(Project project, Jar jarTask, JarsignExtension ext)
	{
		TaskProvider<JarsignTask> signTask = project.getTasks().register(
			jarTask.getName() + "Sign", JarsignTask.class, (jarsignTask) ->
			{
				jarsignTask.setGroup(BasePlugin.BUILD_GROUP);

				jarsignTask.getBuildTask().convention(jarTask);
				jarsignTask.getArchive().convention(jarTask.getArchiveFile());
				jarsignTask.getKeystore().convention(ext.getKeystore());
				jarsignTask.getStorePass().convention(ext.getStorePass());
				jarsignTask.getKeyPass().convention(ext.getKeyPass());
				jarsignTask.getAlias().convention(ext.getAlias());
			}
		);
		jarTask.finalizedBy(signTask);
	}

	private static Provider<String> propProvider(Project project, String key)
	{
		return project.provider(() ->
			(String) project.findProperty(key));
	}

	private static RegularFileProperty toRegularFileProvider(Project project, Provider<String> propProvider)
	{
		return project.getObjects()
			.fileProperty()
			.fileProvider(propProvider.map(project::file));
	}
}
