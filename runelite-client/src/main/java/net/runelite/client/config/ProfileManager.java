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

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Slf4j
public class ProfileManager
{
	private static final File PROFILES_DIR = new File(RuneLite.RUNELITE_DIR, "profiles2");
	private static final File PROFILES = new File(PROFILES_DIR, "profiles.json");

	private final Gson gson;

	static
	{
		PROFILES_DIR.mkdirs();
	}

	public class Lock implements AutoCloseable
	{
		private final File lockFile;
		private final FileOutputStream lockOut;
		private final FileChannel lockChannel;
		private final List<ConfigProfile> profiles;
		private boolean modified = false;

		@SneakyThrows
		public Lock()
		{
			lockFile = new File(PROFILES_DIR, "profiles.lck");
			lockOut = new FileOutputStream(lockFile);
			lockChannel = lockOut.getChannel();
			lockChannel.lock();
			profiles = new ArrayList<>(load());
		}

		private List<ConfigProfile> load()
		{
			try (FileInputStream in = new FileInputStream(PROFILES))
			{
				return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Profiles.class)
					.getProfiles();
			}
			catch (FileNotFoundException ex)
			{
				return Collections.emptyList();
			}
			catch (IOException | JsonSyntaxException e)
			{
				log.error("unable to read profiles", e);
				return Collections.emptyList();
			}
		}

		@Override
		@SneakyThrows
		public void close()
		{
			if (modified)
			{
				log.debug("saving {} profiles", profiles.size());

				File tempFile = File.createTempFile("runelite_profiles", null, PROFILES_DIR);
				try (FileOutputStream out = new FileOutputStream(tempFile);
					FileChannel channel = lockOut.getChannel();
					OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8))
				{
					Profiles profilesData = new Profiles();
					profilesData.setProfiles(profiles);
					gson.toJson(profilesData, writer);
					writer.flush();
					channel.force(true);
				}

				try
				{
					Files.move(tempFile.toPath(), PROFILES.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
				}
				catch (AtomicMoveNotSupportedException ex)
				{
					log.debug("atomic move not supported", ex);
					Files.move(tempFile.toPath(), PROFILES.toPath(), StandardCopyOption.REPLACE_EXISTING);
				}
			}

			lockOut.close();
			lockFile.delete();
		}

		public List<ConfigProfile> getProfiles()
		{
			return profiles;
		}

		public ConfigProfile createProfile(String name, long id)
		{
			if (findProfile(id) != null)
			{
				throw new IllegalArgumentException("profile " + id + " already exists");
			}

			ConfigProfile profile = new ConfigProfile(id);
			profile.setName(name);
			profile.setSync(false);
			profile.setRev(-1);
			profile.setDefaultForRsProfiles(new ArrayList<>());
			profiles.add(profile);
			modified = true;
			log.debug("Created profile {}", profile);
			return profile;
		}

		public ConfigProfile createProfile(String name)
		{
			return createProfile(name, System.nanoTime());
		}

		public ConfigProfile findProfile(String name)
		{
			return findProfile((profile) -> profile.getName().equals(name));
		}

		public ConfigProfile findProfile(long id)
		{
			return findProfile((profile) -> profile.getId() == id);
		}

		public ConfigProfile findProfile(Predicate<ConfigProfile> condition)
		{
			for (ConfigProfile configProfile: profiles)
			{
				if (condition.test(configProfile))
				{
					return configProfile;
				}
			}
			return null;
		}

		public void removeProfile(long id)
		{
			// keep the properties around on disk as a backup. If this profile is active on another client
			// the profile will be recreated there later with the same id.
			modified |= profiles.removeIf(p -> p.getId() == id);
		}

		public void renameProfile(ConfigProfile profile, String name)
		{
			File oldFile = profileConfigFile(profile);
			profile.setName(name);
			modified = true;
			File newFile = profileConfigFile(profile);

			if (!oldFile.exists())
			{
				// no config file is valid if the profile hasn't been used yet.
				log.info("Old profile file {} does not exist", oldFile.getName());
				return;
			}

			try
			{
				Files.move(
					oldFile.toPath(),
					newFile.toPath(),
					StandardCopyOption.REPLACE_EXISTING
				);
				log.info("Renamed profile file {} to {}", oldFile.getName(), newFile.getName());
			}
			catch (IOException e)
			{
				log.error("error renaming profile", e);
			}
		}

		public void dirty()
		{
			modified = true;
		}
	}

	public Lock lock()
	{
		return new Lock();
	}

	public static File profileConfigFile(ConfigProfile profile)
	{
		return new File(PROFILES_DIR, profile.getName() + "-" + profile.getId() + ".properties");
	}
}
