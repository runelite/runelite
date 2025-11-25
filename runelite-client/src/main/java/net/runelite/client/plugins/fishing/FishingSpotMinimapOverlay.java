/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.fishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.SpotanimID;
import net.runelite.client.game.FishingSpot;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class FishingSpotMinimapOverlay extends Overlay
{
	private final FishingPlugin plugin;
	private final FishingConfig config;

	@Setter(AccessLevel.PACKAGE)
	private boolean hidden;

	@Inject
	public FishingSpotMinimapOverlay(FishingPlugin plugin, FishingConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (hidden)
		{
			return null;
		}

		for (NPC npc : plugin.getFishingSpots())
		{
			FishingSpot spot = FishingSpot.findSpot(npc.getId());

			if (spot == null)
			{
				continue;
			}

			if (config.onlyCurrentSpot() && plugin.getCurrentSpot() != null && plugin.getCurrentSpot() != spot)
			{
				continue;
			}

			Color color = npc.getGraphic() == SpotanimID.MINNOW_FISHING_FLYINGFISH
				? config.getMinnowsOverlayColor()
				: npc.getId() == NpcID.TEMPOROSS_HARPOONFISH_FISHINGSPOT_SPECIAL
				? config.getHarpoonfishOverlayColor()
				: config.getOverlayColor();

			net.runelite.api.Point minimapLocation = npc.getMinimapLocation();
			if (minimapLocation != null)
			{
				OverlayUtil.renderMinimapLocation(graphics, minimapLocation, color.darker());
			}
		}

		return null;
	}
}
