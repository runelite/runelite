/*
 * Copyright (c) 2019 Owain van Brakel <https://github.com/Owain94>
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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ConfigGroup("openosrs")
public interface LauncherConfig extends Config
{
	@Getter(AccessLevel.PRIVATE)
	@AllArgsConstructor
	enum BootstrapMode
	{
		STABLE("Stable"),
		NIGHTLY("Nightly");

		private String name;

		@Override
		public String toString()
		{
			return getName();
		}
	}

	@ConfigTitleSection(
		keyName = "launcherTitle",
		name = "Launcher",
		description = "",
		position = -1
	)
	default Title launcherTitle()
	{
		return new Title();
	}

	@ConfigTitleSection(
		keyName = "updateChannelTitle",
		name = "Update channel",
		description = "",
		position = 1,
		titleSection = "launcherTitle"
	)
	default Title updateChannelTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 2,
		keyName = "askMode",
		name = "Prompt for update channel",
		description = "Ask for nightly or stable every startup",
		titleSection = "updateChannelTitle"
	)
	default boolean askMode()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bootstrapMode",
		name = "Update channel",
		description = "Select the update channel",
		titleSection = "updateChannelTitle",
		position = 3,
		hide = "askMode"
	)
	default BootstrapMode bootstrapMode()
	{
		return BootstrapMode.STABLE;
	}

	@ConfigTitleSection(
		keyName = "miscLauncherTitle",
		name = "Miscellaneous",
		description = "",
		position = 4,
		titleSection = "launcherTitle"
	)
	default Title miscLauncherTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 5,
		keyName = "disableHw",
		name = "Disable hardware acceleration",
		description = "Enable this if you have graphical issues",
		titleSection = "miscLauncherTitle",
		warning = "Toggling this setting requires a restart of the client"
	)
	default boolean disableHw()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "advancedTitle",
		name = "Advanced",
		description = "",
		position = 6,
		titleSection = "launcherTitle"
	)
	default Title advancedTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 7,
		keyName = "noJvm",
		name = "Use system java (caution!)",
		description = "Enable this if you want to make use of the system java version instead of the launcher bundled version",
		titleSection = "advancedTitle",
		warning = "Toggling this setting requires a restart of the client"
	)
	default boolean noJvm()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "useProxy",
		name = "Use SOCKS5 proxy",
		description = "Enable the client to use a proxy",
		titleSection = "advancedTitle",
		warning = "Toggling this setting requires a restart of the client"
	)
	default boolean useProxy()
	{
		return false;
	}

	@ConfigItem(
		keyName = "proxyDetails",
		name = "Proxy details",
		description = "The format for this field is ip:port or ip:port:user:pass",
		titleSection = "advancedTitle",
		position = 9,
		hidden = true,
		unhide = "useProxy"
	)
	default String proxyDetails()
	{
		return "";
	}
}