/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.GraphicID;
import net.runelite.api.NPC;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class FishingSpotOverlay extends Overlay
{
	private final FishingPlugin plugin;
	private final FishingConfig config;

	@Inject
	ItemManager itemManager;

	@Inject
	public FishingSpotOverlay(FishingPlugin plugin, FishingConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		NPC[] fishingSpots = plugin.getFishingSpots();
		if (fishingSpots == null)
		{
			return null;
		}

		for (NPC npc : fishingSpots)
		{
			FishingSpot spot = FishingSpot.getSpot(npc.getId());

			if (spot == null)
			{
				continue;
			}

			Color color = npc.getGraphic() == GraphicID.FLYING_FISH ? Color.RED : Color.CYAN;
			if (config.showIcons())
			{
				BufferedImage fishImage = getFishImage(spot);
				if (fishImage != null)
				{
					OverlayUtil.renderActorOverlayImage(graphics, npc, fishImage, color.darker(), npc.getLogicalHeight());
				}
			}
			else
			{
				String text = spot.getName();
				OverlayUtil.renderActorOverlay(graphics, npc, text, color.darker());
			}
		}

		return null;
	}

	private BufferedImage getFishImage(FishingSpot spot)
	{
		BufferedImage fishImage = itemManager.getImage(spot.getFishSpriteId());
		return fishImage;
	}
}
