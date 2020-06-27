/*
 * Copyright (c) 2020, ThaChillera <ThaChillera@protonmail.com>
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
package net.runelite.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryManager
{
	public static final File DATA_DIR = getDataFolder();
	public static final File CACHE_DIR = getCacheFolder();
	public static final File PLUGINS_DIR = new File(DATA_DIR, "plugins");
	public static final File PROFILES_DIR = new File(getConfigFolder(), "profiles");
	public static final File SCREENSHOT_DIR = new File(DATA_DIR, "screenshots");
	public static final File LOGS_DIR = new File(DATA_DIR, "logs");
	public static final File DEFAULT_SESSION_FILE = new File(DATA_DIR, "session");
	public static final File DEFAULT_CONFIG_FILE = new File(getConfigFolder(), "settings.properties");

	private static final boolean isUnix = System.getProperty("os.name").contains("nux");

	public static File getDataFolder()
	{
		if (isUnix)
		{ //unix
			String dataLocation = System.getenv("XDG_DATA_HOME");
			if (dataLocation == null || dataLocation.isEmpty())
			{
				return new File(System.getenv("HOME") + "/.local/share/runelite");
			}
			else
			{
				return new File(dataLocation + "/runelite");
			}
		}
		else
		{
			return new File(System.getProperty("user.home"), ".runelite");
		}
	}

	public static File getCacheFolder()
	{
		if (isUnix)
		{ //unix
			String cacheLocation = System.getenv("XDG_CACHE_HOME");
			if (cacheLocation == null || cacheLocation.isEmpty())
			{
				return new File(System.getenv("HOME") + "/.cache/runelite");
			}
			else
			{
				return new File(cacheLocation + "/runelite");
			}
		}
		else
		{
			return new File(DATA_DIR, "cache");
		}
	}

	public static File getConfigFolder()
	{
		if (isUnix)
		{ //unix
			String configLocation = System.getenv("XDG_CONFIG_HOME");
			if (configLocation == null || configLocation.isEmpty())
			{
				return new File(System.getenv("HOME") + "/.config/runelite");
			}
			else
			{
				return new File(configLocation + "/runelite");
			}
		}
		else
		{
			return DATA_DIR;
		}
	}

	public static void moveOldConfig() throws IOException
	{
		File oldLocation = new File(System.getProperty("user.home"), ".runelite");

		if (isUnix && oldLocation.exists())
		{
			//Copy files, and finally delete, so a failure won't destroy your old config folder

			deleteFolder(getConfigFolder().toPath());
			getConfigFolder().mkdirs();
			Files.copy(new File(oldLocation, "settings.properties").toPath(), DEFAULT_CONFIG_FILE.toPath());
			copyFolder(new File(oldLocation, "profiles").toPath(), new File(DEFAULT_CONFIG_FILE, "profiles").toPath());

			deleteFolder(CACHE_DIR.toPath());
			CACHE_DIR.mkdirs();
			copyFolder(new File(oldLocation, "cache").toPath(), CACHE_DIR.toPath());

			deleteFolder(DATA_DIR.toPath());
			DATA_DIR.mkdirs();
			ArrayList<String> contents = new ArrayList<>(Arrays.asList(oldLocation.list()));
			contents.remove("settings.properties");
			contents.remove("profiles");
			contents.remove("cache");
			for (String location : contents)
			{
				File file = new File(oldLocation, location);
				if (file.isFile())
				{
					Files.copy(file.toPath(), new File(DATA_DIR, location).toPath());
				}
				else
				{
					copyFolder(file.toPath(), new File(DATA_DIR, location).toPath());
				}
			}

			deleteFolder(oldLocation.toPath());
		}
	}

	private static void copyFolder(Path sourceFolder, Path destinationFolder) throws IOException
	{
		Files.walkFileTree(sourceFolder, new FileVisitor<Path>()
		{
			@Override
			public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException
			{
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException
			{
				Path destinationFile = destinationFolder.resolve(sourceFolder.relativize(path));
				destinationFile.toFile().getParentFile().mkdirs();
				Files.copy(path, destinationFile);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException
			{
				throw new IOException("Visit Failed");
			}

			@Override
			public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException
			{
				return FileVisitResult.CONTINUE;
			}
		});
	}

	private static void deleteFolder(Path folder) throws IOException
	{
		if (folder.toFile().exists())
		{
			Files.walk(folder)
				.sorted(Comparator.reverseOrder())
				.map(Path::toFile)
				.forEach(File::delete);
		}
	}
}
