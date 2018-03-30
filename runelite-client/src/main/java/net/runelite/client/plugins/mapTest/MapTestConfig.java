/*
 * Copyright (c) 2018 Morgan Lewis <http://github.com/MESLewis>
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
package net.runelite.client.plugins.mapTest;

import java.awt.Dimension;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "devtoolsmap",
	name = "Dev Tools Map",
	description = "Configuration for developer tools map test"
)
public interface MapTestConfig extends Config
{
	@ConfigItem(
		keyName = "mapTestCoords",
		name = "Coordinates",
		description = "Coordinates to display",
		position = 2
	)
	default Dimension mapTestCoords()
	{
		return new Dimension(3222, 3217);
	}

	@ConfigItem(
		keyName = "mapTestSize",
		name = "Display Size",
		description = "",
		position = 3
	)
	default Dimension mapTestDisplay()
	{
		return new Dimension(100, 100);
	}

	@ConfigItem(
		keyName = "mapTestZoom",
		name = "Zoom",
		description = "",
		position = 4
	)
	default int mapTestZoom()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "mapTestMarkerCoords",
		name = "Map Marker",
		description = "Coordinates to display a mark on the map",
		position = 5
	)
	default Dimension mapTestMarkerCoords()
	{
		return new Dimension(3225, 3217);
	}
}
