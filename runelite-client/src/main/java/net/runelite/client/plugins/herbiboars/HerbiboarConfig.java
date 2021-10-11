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
package net.runelite.client.plugins.herbiboars;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("herbiboar")
public interface HerbiboarConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "showStart",
		name = "Show Start Objects",
		description = "Show highlights for starting rocks and logs"
	)
	default boolean isStartShown()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "showClickboxes",
		name = "Show Clickboxes",
		description = "Show clickboxes on trail objects and tunnels instead of tiles"
	)
	default boolean showClickBoxes()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 2,
		keyName = "colorStart",
		name = "Start Color",
		description = "Color for rocks that start the trails"
	)
	default Color getStartColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 3,
		keyName = "showTunnel",
		name = "Show End Tunnels",
		description = "Show highlights for tunnels with herbiboars"
	)
	default boolean isTunnelShown()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "colorTunnel",
		name = "Tunnel Color",
		description = "Color for tunnels with herbiboars"
	)
	default Color getTunnelColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 5,
		keyName = "showObject",
		name = "Show Trail Objects",
		description = "Show highlights for mushrooms, mud, seaweed, etc"
	)
	default boolean isObjectShown()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 6,
		keyName = "colorGameObject",
		name = "Trail Object Color",
		description = "Color for mushrooms, mud, seaweed, etc"
	)
	default Color getObjectColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 7,
		keyName = "showTrail",
		name = "Show Trail",
		description = "Show highlights for trail prints"
	)
	default boolean isTrailShown()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "colorTrail",
		name = "Trail Color",
		description = "Color for mushrooms, mud, seaweed, etc"
	)
	default Color getTrailColor()
	{
		return Color.WHITE;
	}
}
