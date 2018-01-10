/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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

@ConfigGroup(
	keyName = "runelite",
	name = "RuneLite",
	description = "Configuration for RuneLite client options"
)
public interface RuneLiteConfig extends Config
{
	@ConfigItem(
		keyName = "chatCommandsRecolorEnabled",
		name = "Enable chat commands recolor",
		description = "Determines if recoloring of custom RuneLite chat commands is enabled"
	)
	default boolean chatCommandsRecolorEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "uiEnableCustomChrome",
		name = "Enable custom window chrome",
		description = "Use Runelite's custom window title and borders.",
		confirmationWarining = "Please restart your client after changing this setting"
	)
	default boolean enableCustomChrome()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enablePlugins",
		name = "Enable loading of external plugins",
		description = "Enable loading of external plugins",
		confirmationWarining = "WARNING: Using untrusted third party plugins is a SECURITY RISK\n"
		+ " and can result in loss of YOUR ACCOUNT, and compromise the security\n"
		+ "of your computer. Are you sure you want to do this?",
		warnOnEnable = true
	)
	default boolean enablePlugins()
	{
		return false;
	}
}
