/*
 * Copyright (c) 2026, IceIceFuego
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
package net.runelite.client.ui.overlay;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(OverlayConfig.GROUP_NAME)
public interface OverlayConfig extends Config
{
	String GROUP_NAME = "overlayconfig";

	@ConfigSection(
		name = "Zone stacking",
		description = "Configure the stacking direction for each overlay snap zone.",
		position = 0
	)
	String zoneStacking = "zoneStacking";

	@ConfigItem(
		keyName = "topLeftZoneDirection",
		name = "Top left",
		description = "Stacking direction for the top-left overlay zone.",
		position = 0,
		section = zoneStacking
	)
	default OverlayZoneDirection topLeftZoneDirection()
	{
		return OverlayZoneDirection.VERTICAL;
	}

	@ConfigItem(
		keyName = "topCenterZoneDirection",
		name = "Top center",
		description = "Stacking direction for the top-center overlay zone.",
		position = 1,
		section = zoneStacking
	)
	default OverlayZoneDirection topCenterZoneDirection()
	{
		return OverlayZoneDirection.VERTICAL;
	}

	@ConfigItem(
		keyName = "topRightZoneDirection",
		name = "Top right",
		description = "Stacking direction for the top-right overlay zone.",
		position = 2,
		section = zoneStacking
	)
	default OverlayZoneDirection topRightZoneDirection()
	{
		return OverlayZoneDirection.VERTICAL;
	}

	@ConfigItem(
		keyName = "bottomLeftZoneDirection",
		name = "Bottom left",
		description = "Stacking direction for the bottom-left overlay zone.",
		position = 3,
		section = zoneStacking
	)
	default OverlayZoneDirection bottomLeftZoneDirection()
	{
		return OverlayZoneDirection.HORIZONTAL;
	}

	@ConfigItem(
		keyName = "bottomRightZoneDirection",
		name = "Bottom right",
		description = "Stacking direction for the bottom-right overlay zone.",
		position = 4,
		section = zoneStacking
	)
	default OverlayZoneDirection bottomRightZoneDirection()
	{
		return OverlayZoneDirection.HORIZONTAL;
	}

	@ConfigItem(
		keyName = "aboveChatboxRightZoneDirection",
		name = "Above chatbox right",
		description = "Stacking direction for the above-chatbox-right overlay zone.",
		position = 5,
		section = zoneStacking
	)
	default OverlayZoneDirection aboveChatboxRightZoneDirection()
	{
		return OverlayZoneDirection.VERTICAL;
	}

	@ConfigItem(
		keyName = "canvasTopRightZoneDirection",
		name = "Canvas top right",
		description = "Stacking direction for the canvas top-right overlay zone.",
		position = 6,
		section = zoneStacking
	)
	default OverlayZoneDirection canvasTopRightZoneDirection()
	{
		return OverlayZoneDirection.VERTICAL;
	}
}
