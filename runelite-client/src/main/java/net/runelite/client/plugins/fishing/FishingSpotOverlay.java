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
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FishingSpotOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(FishingSpotOverlay.class);

	private final BufferedImage[] imgCache = new BufferedImage[FishingSpot.values().length - 1];

	public List<int[]> ids = null;

	private final FishingConfig config;
	private final static Client client = RuneLite.getClient();

	public FishingSpotOverlay(Fishing plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();

	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		if (ids == null)
		{
			ids = new LinkedList<int[]>();
			updateConfig();
		}

		NPC[] npcs = client.getNpcs();
		if (npcs != null && (npcs.length - 1) > 0)
		{
			for (NPC npc : npcs)
			{
				if (npc != null)
				{
					FishingSpot spot = FishingSpot.getSpot(npc.getId());

					if (spot == null || !ids.contains(spot.getIds()))
					{
						continue;
					}

					if (config.showIcons())
					{
						BufferedImage fishImage = getFishImage(spot);
						OverlayUtil.renderActorOverlay(graphics, npc, fishImage, Color.cyan.darker());
					}
					else
					{
						String text = spot.getName();
						OverlayUtil.renderActorOverlay(graphics, npc, text, Color.cyan.darker());
					}
				}
			}
		}

		return null;
	}

	private BufferedImage getFishImage(FishingSpot spot)
	{
		int fishIdx = spot.ordinal();
		BufferedImage fishImage = null;

		if (imgCache[fishIdx] != null)
		{
			return imgCache[fishIdx];
		}

		try
		{
			String fishIconPath = "/skills/fishing/" + spot.getImage() + ".png";
			logger.debug("Loading fish icon from {}", fishIconPath);
			fishImage = ImageIO.read(FishingSpotOverlay.class.getResourceAsStream(fishIconPath));
			imgCache[fishIdx] = fishImage;
		}
		catch (IOException e)
		{
			logger.debug("Error Loading fish icons {}", e);
		}

		return fishImage;
	}

	public void updateConfig()
	{
		ids.clear();
		if (config.showShrimp())
		{
			ids.add(FishingSpot.SHRIMP.getIds());
		}
		if (config.showLobster())
		{
			ids.add(FishingSpot.LOBSTER.getIds());
		}
		if (config.showShark())
		{
			ids.add(FishingSpot.SHARK.getIds());
		}
		if (config.showMonkfish())
		{
			ids.add(FishingSpot.MONKFISH.getIds());
		}
		if (config.showSalmon())
		{
			ids.add(FishingSpot.SALMON.getIds());
		}
		if (config.showBarb())
		{
			ids.add(FishingSpot.BARB_FISH.getIds());
		}
		if (config.showAngler())
		{
			ids.add(FishingSpot.ANGLERFISH.getIds());
		}
		if (config.showMinnow())
		{
			ids.add(FishingSpot.MINNOW.getIds());
		}
	}
}
