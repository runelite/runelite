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
package net.runelite.client.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ConfigData
{
	private final File configPath;

	private final ConcurrentHashMap<String, String> properties;
	private Map<String, String> patchChanges = new HashMap<>();

	ConfigData(File configPath)
	{
		this.configPath = configPath;

		Properties props = new Properties();
		try (FileInputStream in = new FileInputStream(configPath);
			InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8))
		{
			props.load(reader);
		}
		catch (FileNotFoundException ignored)
		{
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}

		properties = new ConcurrentHashMap<>(props.size());
		props.forEach((k, v) -> properties.put((String) k, (String) v));
	}

	String getProperty(String key)
	{
		return properties.get(key);
	}

	synchronized String setProperty(String key, String value)
	{
		String old = properties.put(key, value);
		if (!Objects.equals(old, value))
		{
			patchChanges.put(key, value);
		}
		return old;
	}

	synchronized String unset(String key)
	{
		String old = properties.remove(key);
		if (old != null)
		{
			patchChanges.put(key, null);
		}
		return old;
	}

	synchronized void putAll(Map<String, String> values)
	{
		patchChanges.putAll(values);
		properties.putAll(values);
	}

	Set<String> keySet()
	{
		return properties.keySet();
	}

	Map<String, String> get()
	{
		return Collections.unmodifiableMap(properties);
	}

	synchronized Map<String, String> swapChanges()
	{
		if (patchChanges.isEmpty())
		{
			return Collections.emptyMap();
		}

		Map<String, String> p = patchChanges;
		patchChanges = new HashMap<>();
		return p;
	}

	void patch(Map<String, String> patch)
	{
		// load + patch + store instead of just flushing the in-memory properties to disk so that
		// multiple clients editing one config data (such as rs profile config) get their data merged
		// correctly

		File lckFile = new File(configPath.getParentFile(), configPath.getName() + ".lck");
		try (FileOutputStream lockOut = new FileOutputStream(lckFile);
			FileChannel lckChannel = lockOut.getChannel())
		{
			lckChannel.lock();

			Properties tempProps = new Properties();
			try (FileInputStream in = new FileInputStream(configPath);
				InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8))
			{
				tempProps.load(reader);
			}
			catch (FileNotFoundException e)
			{
				log.debug("config file {} does not exist", configPath);
			}

			if (tempProps.isEmpty())
			{
				// this probably doesn't happen outside of the very first save (when no file exists)
				// but to be safe in the event the prop is deleted off disk, flush the entire properties
				// from memory
				tempProps.putAll(properties);
			}
			else
			{
				// apply patches
				for (Map.Entry<String, String> entry : patch.entrySet())
				{
					if (entry.getValue() == null)
					{
						tempProps.remove(entry.getKey());
					}
					else
					{
						tempProps.put(entry.getKey(), entry.getValue());
					}
				}
			}

			File tempFile = File.createTempFile("runelite_config", null, configPath.getParentFile());
			try (FileOutputStream out = new FileOutputStream(tempFile);
				FileChannel channel = out.getChannel();
				OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8))
			{
				channel.lock();
				tempProps.store(writer, "RuneLite configuration");
				writer.flush();
				channel.force(true);
			}

			try
			{
				Files.move(tempFile.toPath(), configPath.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
			}
			catch (AtomicMoveNotSupportedException ex)
			{
				log.debug("atomic move not supported", ex);
				Files.move(tempFile.toPath(), configPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException ex)
		{
			log.error("unable to save configuration file", ex);
		}
		lckFile.delete();
	}
}
