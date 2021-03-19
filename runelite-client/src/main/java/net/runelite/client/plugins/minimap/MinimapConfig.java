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

@ConfigGroup("minimap")
public interface MinimapConfig extends Config
{
	@ConfigItem(
		keyName = "item",
		name = "Item color",
		description = "Set the minimap color items are drawn in"
	)
	default Color itemColor() //mapdot 0
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
		keyName = "npc",
		name = "NPC color",
		description = "Set the minimap color NPCs are drawn in"
	)
	default Color npcColor() //mapdot 1
	{
		return new Color(255, 255, 0);
	}

	@ConfigItem(
		keyName = "player",
		name = "Player color",
		description = "Set the minimap Color players are drawn in"
	)
	default Color playerColor() //mapdot 2
	{
		return new Color(255, 255, 255);
	}

	@ConfigItem(
		keyName = "friend",
		name = "Friends color",
		description = "Set the minimap color your friends are drawn in"
	)
	default Color friendColor() //mapdot 3
	{
		return new Color(0, 255, 0);
	}

	@ConfigItem(
		keyName = "team",
		name = "Team color",
		description = "Set the minimap color your team is drawn in"
	)
	default Color teamColor() //mapdot 4
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		keyName = "clan",
		name = "Friends Chat color",
		description = "Set the minimap color your friends chat members are drawn in"
	)
	default Color friendsChatColor() //mapdot 5
	{
		return new Color(170, 0, 190);
	}

	@ConfigItem(
		keyName = "hideMinimap",
		name = "Hide minimap",
		description = "Do not show the minimap on screen (Resizable only)"
	)
	default boolean hideMinimap()
	{
		return false;
	}
}
