/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
package net.runelite.launcher;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;

/*
   */

@Slf4j
public class OS
{
	/*
	 * XDG prefixed variables are OS-defaults
	 * non-prefixed variables are the running environment variables
	 * the minuscule variables are the runelite-specific variables
	 * */
	private static final Path CONFIG_HOME;
	private static final Path DATA_HOME;
	private static final Path CACHE_HOME;
	private static final Path STATE_HOME;
	private static final Path PICTURES_DIR;

	public enum OSType
	{
		Windows, MacOS, Linux, Other
	}

	private static final OSType DETECTED_OS;
	private static final String DETECTED_ARCH;

	private static final String placeholder = "%{project_name}";  // used on Windows
	static
	{
		String os = System.getProperty("os.name", "generic").toLowerCase();
		DETECTED_ARCH = System.getProperty("os.arch", "unknown");

		Path XDG_CONFIG_HOME;
		Path XDG_DATA_HOME;
		Path XDG_CACHE_HOME;
		Path XDG_STATE_HOME;
		Path XDG_PICTURES_DIR;

		if (os.contains("mac") || os.contains("darwin"))
		{
			XDG_CONFIG_HOME = Paths.get(System.getProperty("user.home"), "Library", "Preferences");
			XDG_DATA_HOME = Paths.get(System.getProperty("user.home"), "Library", "Application Support");
			XDG_CACHE_HOME = Paths.get(System.getProperty("user.home"), "Library", "Caches");
			// STATE is a newcomer to the standard. it was split apart from the cache directory... but not on MacOS (yet, at least)
			XDG_STATE_HOME = Paths.get(System.getProperty("user.home"), "Library", "Caches");
			XDG_RUNTIME_DIR = Paths.get(System.getProperty("user.home"), "Library", "Caches");

			XDG_PICTURES_DIR = Paths.get(System.getProperty("user.home"), "Pictures");

			DETECTED_OS = OSType.MacOS;
		}
		else if (os.contains("win"))
		{
			XDG_CONFIG_HOME = Paths.get(System.getProperty("user.home"), "AppData", "Roaming", placeholder, "Config");
			XDG_DATA_HOME = Paths.get(System.getProperty("user.home"), "AppData", "Local", placeholder, "Data" );
			XDG_CACHE_HOME = Paths.get(System.getProperty("user.home"), "AppData", "Local", placeholder, "Cache");
			XDG_STATE_HOME = Paths.get(System.getProperty("user.home"), "AppData", "Local", placeholder, "Cache");
			XDG_RUNTIME_DIR = Paths.get(System.getProperty("user.home"), "AppData", "Roaming", placeholder);

			XDG_PICTURES_DIR = Paths.get(System.getProperty("user.home"), "Pictures", placeholder);

			DETECTED_OS = OSType.Windows;
		}
		else if (os.contains("linux"))
		{
			XDG_CONFIG_HOME = Paths.get(System.getProperty("user.home"), ".config");
			XDG_DATA_HOME = Paths.get(System.getProperty("user.home"), ".local", "share");
			XDG_CACHE_HOME = Paths.get(System.getProperty("user.home"), ".cache");
			XDG_STATE_HOME = Paths.get(System.getProperty("user.home"), ".local", "state");
			//  the default runtime directory on systemd is /run/user/1000, but this depends on the init. other
			//  init systems should make sure they've exported the runtime directory to the environment
			XDG_RUNTIME_DIR = Paths.get("run", "user", System.getProperty("UID"));

			XDG_PICTURES_DIR = Paths.get(System.getProperty("user.home"), "Pictures");

			DETECTED_OS = OSType.Linux;
		}
		else
		{
			XDG_CONFIG_HOME = Paths.get(System.getProperty("user.home"), ".runelite", "config");
			XDG_DATA_HOME = Paths.get(System.getProperty("user.home"), ".runelite", "data");
			XDG_CACHE_HOME = Paths.get(System.getProperty("user.home"), ".runelite", "cache");
			XDG_STATE_HOME = Paths.get(System.getProperty("user.home"), ".runelite", "state");
			XDG_RUNTIME_DIR = Paths.get(System.getProperty("user.home"), ".runelite", "runtime");

			XDG_PICTURES_DIR = Paths.get(System.getProperty("user.home"), ".runelite", "Pictures");

			DETECTED_OS = OSType.Other;
		}

		// note: system variables don't have a placeholder for the appname.
		switch (DETECTED_OS)
		{
			case Linux:
			case Mac:
				PICTURES_DIR = Paths.get(System.getProperty("XDG_PICTURES_DIR", XDG_PICTURES_DIR.toString()));
				CONFIG_HOME = Paths.get(System.getProperty("XDG_CONFIG_HOME", XDG_CONFIG_HOME.toString()));
				DATA_HOME = Paths.get(System.getProperty("XDG_DATA_HOME", XDG_DATA_HOME.toString()));
				CACHE_HOME = Paths.get(System.getProperty("XDG_CACHE_HOME", XDG_CACHE_HOME.toString()));
				STATE_HOME = Paths.get(System.getProperty("XDG_STATE_HOME", XDG_STATE_HOME.toString()));
				RUNTIME_DIR = Paths.get(System.getProperty("XDG_RUNTIME_DIR", XDG_RUNTIME_DIR.toString()));
				break;
			case Windows:
			case Other:
			default:
				CONFIG_HOME = XDG_CONFIG_HOME.toString();
				DATA_HOME = XDG_DATA_HOME.toString();
				CACHE_HOME = XDG_CACHE_HOME.toString();
				STATE_HOME = XDG_STATE_HOME.toString();
				RUNTIME_DIR = XDG_RUNTIME_DIR.toString();
				PICTURES_DIR = XDG_PICTURES_DIR.toString();
				break;
		}

		log.debug("Detect OS: {}", DETECTED_OS);
	}


	public static OSType getOs(@Nonnull String os)
	{
		return getOS(os);
	}

	public static OSType getOs()
	{
		return getOS();
	}

	public static OSType getOS(@Nonnull String os)
	{
		if (os.contains("mac") || os.contains("darwin"))
		{
			return OSType.MacOS;
		}
		else if (os.contains("win"))
		{
			return OSType.Windows;
		}
		else if (os.contains("linux"))
		{
			return OSType.Linux;
		}
		else
		{
			return OSType.Other;
		}
	}

	public static OSType getOS()
	{
		return DETECTED_OS;
	}
	public static String getArch()
	{
		return DETECTED_ARCH;
	}

	public static boolean equals(String os)
	{
		return DETECTED_OS.equals(getOS(os.toLowerCase()));
	}

	public static String getXDG(@Nonnull String home, String appName) throws IllegalArgumentException
	{
		if (appName == null)
		{
			appName = "";
		}

		String config_home;
		String data_home;
		String cache_home;
		String state_home;
		String pictures_dir;
		String runtime_dir;

		if (OS.equals("windows"))
		{
			config_home = CONFIG_HOME.toString().replace(placeholder, appName);
			data_home = DATA_HOME.toString().replace(placeholder, appName);
			cache_home = CACHE_HOME.toString().replace(placeholder, appName);
			state_home = STATE_HOME.toString().replace(placeholder, appName);
			runtime_dir = RUNTIME_DIR.toString().replace(placeholder, appName);
		}
		else
		{
			config_home = Paths.get(CONFIG_HOME.toString(), appName).toString();
			data_home = Paths.get(DATA_HOME.toString(), appName).toString();
			cache_home = Paths.get(CACHE_HOME.toString(), appName).toString();
			state_home = Paths.get(STATE_HOME.toString(), appName).toString();
			runtime_dir = Paths.get(RUNTIME_DIR.toString(), appName).toString();
		}
		pictures_dir = Paths.get(PICTURES_DIR.toString(), appName).toString();

		switch (home.toLowerCase())
		{
			case "config":
				return config_home; 
			case "data":
				return data_home;
			case "cache":
				return cache_home;
			case "state":
				return state_home;
			case "runtime":
				return state_home;
			case "pictures":
			case "screenshots":
				return pictures_dir;
			default:
				throw new IllegalArgumentException("XDG paths must be config, data, cache or state");
		}
	}
	
	public static boolean isCompatible(String platformName, String platformArch)
	{
		if (platformName == null)
		{
			return false;
		}

		OSType platformOS = OS.getOS(platformName);

		// we should document why we are using the platform name when we don't find a match for the platform os
		if (platformOS == OSType.Other ? platformName.equals(DETECTED_OS) : platformOS == DETECTED_OS)
		{
			if (platformArch == null || platformArch.equals(DETECTED_ARCH))
			{
				return true;
			}
		}
		return false;
	}
}
