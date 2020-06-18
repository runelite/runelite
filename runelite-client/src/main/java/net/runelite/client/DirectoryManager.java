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

	public static File getDataFolder()
	{
		if (System.getProperty("os.name").contains("nux"))
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
		if (System.getProperty("os.name").contains("nux"))
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
		if (System.getProperty("os.name").contains("nux"))
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
}
