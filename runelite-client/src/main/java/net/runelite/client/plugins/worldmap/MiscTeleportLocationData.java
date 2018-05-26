/*
 *
 *  * Copyright (c) 2018, forsco <https://github.com/forsco>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  *
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum MiscTeleportLocationData
{
	XERICS_LOOKOUT("Xeric's Talisman" , "Xeric's Lookout" , new WorldPoint(1576, 3528, 0), "xerics_talisman_teleport_icon.png"),
	XERICS_GLADE("Xeric's Talisman" , "Xeric's Glade" , new WorldPoint(1773, 3502, 0), "xerics_talisman_teleport_icon.png"),
	XERICS_INFERNO("Xeric's Talisman" , "Xeric's Inferno" , new WorldPoint(1504, 3819, 0), "xerics_talisman_teleport_icon.png"),
	XERICS_HEART("Xeric's Talisman" , "Xeric's Heart" , new WorldPoint(1641, 3670, 0), "xerics_talisman_teleport_icon.png"),
	XERICS_HONOUR("Xeric's Talisman" , "Xeric's Honour" , new WorldPoint(1254, 3559, 0), "xerics_talisman_teleport_icon.png");

	private final String tooltip;
	private final WorldPoint location;
	private final String iconPath;

	MiscTeleportLocationData(String item, String destination, WorldPoint location, String iconPath)
	{
		this.tooltip = item + " - " + destination;
		this.location = location;
		this.iconPath = iconPath;
	}
}
