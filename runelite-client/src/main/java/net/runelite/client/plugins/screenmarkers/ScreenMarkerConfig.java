/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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
package net.runelite.client.plugins.screenmarkers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(
		name = "Screen Markers",
		keyName = "screenmarkers",
		description = "Configuration for the screen markers plugin"
)
public interface ScreenMarkerConfig extends Config
{
	@ConfigItem(
			keyName = "displayMarkers",
			name = "Display markers",
			description = "Configures whether or not to display markers",
			position = 1
	)
	default boolean displayMarkers() { return true; }

	@ConfigItem(
			keyName = "markerThickness",
			name = "Border Thickness",
			description = "Thickness of the border for new markers",
			position = 2
	)
	default int markerThickness()
	{
		return 3;
	}

	@ConfigItem(
			keyName = "markerColor",
			name = "Marker Color",
			description = "Configures the color to use for new markers",
			position = 3
	)
	default Color markerColor()
	{
		return Color.RED.darker();
	}

	@ConfigItem(
			keyName = "addMarkers",
			name = "Marker Creation Mode",
			description = "Allows markers to be added to the screen",
			position = 4
	)
	default boolean addMarkers() { return false; }

	@ConfigItem(
			keyName = "addMarkers",
			name = "",
			description = ""
	)
	void addMarkers(boolean addMarkers);

	@ConfigItem(
			keyName = "markerData",
			name = "Screen Marker Data",
			description = "Contains serialized marker data",
			hidden = true
	)
	default String markerData() { return ""; }

	@ConfigItem(
			keyName = "markerData",
			name = "",
			description = ""
	)
	void markerData(String markerData);
}
