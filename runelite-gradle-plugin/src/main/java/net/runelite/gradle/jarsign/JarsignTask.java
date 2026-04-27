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

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;
import org.gradle.jvm.tasks.Jar;

@CacheableTask
public abstract class JarsignTask extends DefaultTask
{

	public JarsignTask()
	{
		dependsOn(getBuildTask());
		onlyIf(
			"target archive must be specified",
			_t -> getArchive().getAsFile().get().exists()
		);

		onlyIf(
			"keystore properties are set",
			_t ->
				getKeystore().isPresent() &&
					getStorePass().isPresent() &&
					getKeyPass().isPresent() &&
					getAlias().isPresent()
		);
	}

	@Input
	public abstract Property<Jar> getBuildTask();

	@InputFile
	@PathSensitive(PathSensitivity.RELATIVE)
	public abstract RegularFileProperty getArchive();

	@InputFile
	@PathSensitive(PathSensitivity.RELATIVE)
	public abstract RegularFileProperty getKeystore();

	@Input
	public abstract Property<String> getStorePass();

	@Input
	public abstract Property<String> getKeyPass();

	@Input
	public abstract Property<String> getAlias();

	@TaskAction
	public void signArtifact()
	{
		getProject().exec(exec ->
			exec.commandLine(
				"jarsigner",
				"-keystore", getKeystore().getAsFile().get().getAbsolutePath(),
				"-storepass", getStorePass().get(),
				"-keypass", getKeyPass().get(),
				getArchive().getAsFile().get().getAbsolutePath(),
				getAlias().get()
			));
	}

}
