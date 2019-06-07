/*
 * Copyright (c) 2019, Spedwards <https://github.com/Spedwards>
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
package net.runelite.client.plugins.profiles;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("profiles")
public interface ProfilesConfig extends Config
{
	@ConfigItem(
		keyName = "profilesData",
		name = "",
		description = "",
		hidden = true
	)
	default String profilesData()
	{
		return "";
	}

	@ConfigItem(
		keyName = "profilesData",
		name = "",
		description = ""
	)
	void profilesData(String str);

	@ConfigItem(
		keyName = "salt",
		name = "",
		description = "",
		hidden = true
	)
	default String salt()
	{
		return "";
	}

	@ConfigItem(
		keyName = "salt",
		name = "",
		description = ""
	)
	void salt(String key);

	@ConfigItem(
		keyName = "rememberPassword",
		name = "Remember Password",
		description = "Remembers passwords for accounts"
	)
	default boolean rememberPassword()
	{
		return true;
	}

	@ConfigItem(
		keyName = "streamerMode",
		name = "Hide email addresses",
		description = "Hides your account emails"
	)
	default boolean isStreamerMode()
	{
		return false;
	}

	@ConfigItem(
		keyName = "switchPanel",
		name = "Auto-open Panel",
		description = "Automatically switch to the account switcher panel on the login screen"
	)
	default boolean switchPanel()
	{
		return false;
	}
}
