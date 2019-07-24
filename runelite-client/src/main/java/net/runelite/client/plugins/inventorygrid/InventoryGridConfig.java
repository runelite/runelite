/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.inventorygrid;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("inventorygrid")
public interface InventoryGridConfig extends Config
{
	@ConfigItem(
		keyName = "showItem",
		name = "Show item",
		description = "Show a preview of the item in the new slot",
		position = 1
	)
	default boolean showItem()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGrid",
		name = "Show grid",
		description = "Show a grid on the inventory while dragging",
		position = 2
	)
	default boolean showGrid()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHighlight",
		name = "Highlight background",
		description = "Show a background highlight on the new slot",
		position = 3
	)
	default boolean showHighlight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dragDelay",
		name = "Drag Delay",
		description = "Time in ms to wait after item press before showing grid",
		position = 4
	)
	@Range(min = 100)
	default int dragDelay()
	{
		return 100;
	}

	@Alpha
	@ConfigItem(
		keyName = "gridColor",
		name = "Grid color",
		description = "The color of the grid",
		position = 5
	)
	default Color gridColor()
	{
		return new Color(255, 255, 255, 45);
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightColor",
		name = "Highlight color",
		description = "The color of the new inventory slot highlight",
		position = 6
	)
	default Color highlightColor()
	{
		return new Color(0, 255, 0, 45);
	}
}
