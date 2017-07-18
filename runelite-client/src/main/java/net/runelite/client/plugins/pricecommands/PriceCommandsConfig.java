/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.pricecommands;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "pricecommands",
	name = "Chat commands",
	description = "Configuration for chat commands"
)
public interface PriceCommandsConfig
{
	@ConfigItem(
			keyName = "enabled",
			name = "Enable",
			description = "Configures whether chat commands are enabled"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "enableRecolor",
			name = "Enable command recolor",
			description = "Configures whether chat commands are recolored"
	)
	default boolean recolorEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hexColorPublic",
			name = "Public chat",
			description = "Color of Public chat"
	)
	default String getPublicRecolor()
	{
		return "0000FF";
	}

	@ConfigItem(
			keyName = "hexColorPublicH",
			name = "Public chat highlight",
			description = "Color of Public chat highlight"
	)
	default String getPublicHRecolor()
	{
		return "000000";
	}

	@ConfigItem(
			keyName = "hexColorPrivate",
			name = "Private chat",
			description = "Color of Private chat"
	)
	default String getPrivateRecolor()
	{
		return "0088FF";
	}

	@ConfigItem(
			keyName = "hexColorPrivateH",
			name = "Private chat highlight",
			description = "Color of Private chat highlight"
	)
	default String getPrivateHRecolor()
	{
		return "002783";
	}

	@ConfigItem(
			keyName = "hexColorCc",
			name = "Clan chat",
			description = "Color of Clan chat"
	)
	default String getCcRecolor()
	{
		return "900000";
	}

	@ConfigItem(
			keyName = "hexColorCcH",
			name = "Clan chat Highlight",
			description = "Color of Clan chat highlight"
	)
	default String getCcHRecolor()
	{
		return "000000";
	}

}
