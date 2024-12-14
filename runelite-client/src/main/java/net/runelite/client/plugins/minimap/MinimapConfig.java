/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.minimap;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(MinimapConfig.GROUP)
public interface MinimapConfig extends Config
{
	String GROUP = "minimap";

	@ConfigSection(
		name = "Minimap dot colors",
		description = "The colors of dots on the minimap.",
		position = 0
	)
	String minimapDotSection = "minimapDotSection";

	@ConfigItem(
		keyName = "zoom",
		name = "Zoom",
		description = "Enables zooming on the minimap."
	)
	default boolean zoom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideMinimap",
		name = "Hide minimap",
		description = "Do not show the minimap on screen (resizable only)."
	)
	default boolean hideMinimap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "item",
		name = "Item color",
		description = "Set the minimap color items are drawn in.",
		section = minimapDotSection
	)
	Color itemColor();

	@ConfigItem(
		keyName = "npc",
		name = "NPC color",
		description = "Set the minimap color NPCs are drawn in.",
		section = minimapDotSection
	)
	Color npcColor();

	@ConfigItem(
		keyName = "player",
		name = "Player color",
		description = "Set the minimap color players are drawn in.",
		section = minimapDotSection
	)
	Color playerColor();

	@ConfigItem(
		keyName = "friend",
		name = "Friends color",
		description = "Set the minimap color your friends are drawn in.",
		section = minimapDotSection
	)
	Color friendColor();

	@ConfigItem(
		keyName = "team",
		name = "Team color",
		description = "Set the minimap color your team is drawn in.",
		section = minimapDotSection
	)
	Color teamColor();

	@ConfigItem(
		keyName = "clan", // old name from prior to clans
		name = "Friends chat color",
		description = "Set the minimap color your friends chat members are drawn in.",
		section = minimapDotSection
	)
	Color friendsChatColor();

	@ConfigItem(
		keyName = "clanchat",
		name = "Clan chat color",
		description = "Set the minimap color your clan chat members are drawn in.",
		section = minimapDotSection
	)
	Color clanChatColor();
}
