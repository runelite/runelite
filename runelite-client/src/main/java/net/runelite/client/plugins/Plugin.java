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
package net.runelite.client.plugins;

import com.google.common.base.Strings;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import net.runelite.client.RuneLite;
import net.runelite.client.util.Filepath;

public abstract class Plugin implements Module
{
	protected Injector injector;

	@Override
	public final int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public final boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public void configure(Binder binder)
	{
	}

	protected void startUp() throws Exception
	{
	}

	protected void shutDown() throws Exception
	{
	}

	public void resetConfiguration()
	{
	}

	public final Injector getInjector()
	{
		return injector;
	}

	public String getName()
	{
		return getClass().getAnnotation(PluginDescriptor.class).name();
	}

	/**
	 * Gets this plugin's data directory, located in .runelite/plugin-data/[internal-name]. If
	 * {@link PluginDescriptor#legacyDataDirectory()} is set, it will be migrated to the plugin's
	 * data directory on the first call of {@code getPluginDirectory}
	 */
	protected final Filepath getPluginDirectory() throws IOException
	{
		var desc = getClass().getAnnotation(PluginDescriptor.class);

		var internalName = desc.internalName();
		if (Strings.isNullOrEmpty(internalName))
		{
			throw new IllegalArgumentException("internalName must be set in @PluginDescriptor.");
		}

		if (!Files.exists(RuneLite.PLUGIN_DATA))
		{
			try
			{
				Files.createDirectories(RuneLite.PLUGIN_DATA);
			}
			catch (FileNotFoundException ignored)
			{
			}
		}

		var fp = Filepath.Unchecked.getRooted(RuneLite.PLUGIN_DATA)
			.joinSegment(internalName)
			.rooted();

		var legacyName = desc.legacyDataDirectory();
		if (!Strings.isNullOrEmpty(legacyName))
		{
			var legacy = Filepath.Unchecked.getLegacyPluginDirectory(RuneLite.RUNELITE_DIR.toPath(), legacyName);

			if (!fp.exists() && legacy.exists())
			{
				legacy.moveTo(fp);
			}
		}

		return fp;
	}
}
