/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

package net.runelite.client.plugins.objectindicators;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("objectindicators")
public interface ObjectIndicatorsConfig extends Config
{
	@ConfigSection(
		name = "Render style",
		description = "The render style of object highlighting",
		position = 0
	)
	String renderStyleSection = "renderStyleSection";

	@ConfigItem(
		position = 0,
		keyName = "highlightHull",
		name = "Highlight hull",
		description = "Configures whether or not object should be highlighted by hull",
		section = renderStyleSection
	)
	default boolean highlightHull()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "highlightOutline",
		name = "Highlight outline",
		description = "Configures whether or not the model of the object should be highlighted by outline",
		section = renderStyleSection
	)
	default boolean highlightOutline()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightClickbox",
		name = "Highlight clickbox",
		description = "Configures whether the object's clickbox should be highlighted",
		section = renderStyleSection
	)
	default boolean highlightClickbox()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "highlightTile",
		name = "Highlight tile",
		description = "Configures whether the object's tile should be highlighted",
		section = renderStyleSection
	)
	default boolean highlightTile()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "markerColor",
		name = "Marker color",
		description = "Configures the color of newly created object markers",
		section = renderStyleSection
	)
	default Color markerColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "fillColor",
		name = "Fill color",
		description = "Configures the fill color of newly created object markers",
		section = renderStyleSection
	)
	Color fillColor();

	@ConfigItem(
		position = 6,
		keyName = "borderWidth",
		name = "Border Width",
		description = "Width of the marked object border",
		section = renderStyleSection
	)
	default double borderWidth()
	{
		return 2;
	}

	@ConfigItem(
		position = 7,
		keyName = "outlineFeather",
		name = "Outline feather",
		description = "Specify between 0-4 how much of the model outline should be faded",
		section = renderStyleSection
	)
	@Range(
		min = 0,
		max = 4
	)
	default int outlineFeather()
	{
		return 0;
	}
}
