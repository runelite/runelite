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
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import javax.inject.Inject;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class FishingSpotOverlay extends Overlay
{
	private static final Duration MINNOW_MOVE = Duration.ofSeconds(15);
	private static final Duration MINNOW_WARN = Duration.ofSeconds(3);

	private final FishingPlugin plugin;
	private final FishingConfig config;
	private final Client client;
	private final ItemManager itemManager;

	private static HashMap<WorldPoint, Multiset<NPC>> SPOTS_LIST = new HashMap<>();

	@Setter(AccessLevel.PACKAGE)
	private boolean hidden;

	@Inject
	private FishingSpotOverlay(FishingPlugin plugin, FishingConfig config, Client client, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (hidden)
		{
			return null;
		}

		SPOTS_LIST.clear();

		for (NPC npc : plugin.getFishingSpots())
		{
			FishingSpot spot = FishingSpot.getSPOTS().get(npc.getId());

			if (spot == null)
			{
				continue;
			}

			if (config.onlyCurrentSpot() && plugin.getCurrentSpot() != null && plugin.getCurrentSpot() != spot)
			{
				continue;
			}

			Multiset<NPC> npcList = SPOTS_LIST.get(npc.getWorldLocation());
			if (npcList == null)
			{
				npcList = HashMultiset.create();
				SPOTS_LIST.put(npc.getWorldLocation(), npcList);
			}

			npcList.add(npc);
		}

		for (HashMap.Entry<WorldPoint, Multiset<NPC>> entry : SPOTS_LIST.entrySet())
		{
			NPC npcArray[] = entry.getValue().toArray(new NPC[0]);

			Multiset<FishingSpot> spotList = HashMultiset.create();
			for (NPC npc : npcArray)
			{
				FishingSpot spot = FishingSpot.getSPOTS().get(npc.getId());
				spotList.add(spot);
			}

			// minnow fishing spots will only ever share tiles with other minnow fishing spots
			NPC firstSpot = npcArray[0];
			Color color = spotList.contains(FishingSpot.MINNOW) ? Color.RED : Color.CYAN;

			if (spotList.contains(FishingSpot.MINNOW) && config.showMinnowOverlay())
			{
				MinnowSpot minnowSpot = plugin.getMinnowSpots().get(firstSpot.getIndex());
				if (minnowSpot != null)
				{
					long millisLeft = MINNOW_MOVE.toMillis() - Duration.between(minnowSpot.getTime(), Instant.now()).toMillis();
					if (millisLeft < MINNOW_WARN.toMillis())
					{
						color = Color.ORANGE;
					}

					LocalPoint localPoint = firstSpot.getLocalLocation();
					Point location = Perspective.localToCanvas(client, localPoint, client.getPlane());

					if (location != null)
					{
						ProgressPieComponent pie = new ProgressPieComponent();
						pie.setFill(color);
						pie.setBorderColor(color);
						pie.setPosition(location);
						pie.setProgress((float) millisLeft / MINNOW_MOVE.toMillis());
						pie.render(graphics);
					}
				}
			}

			if (config.showSpotTiles())
			{
				// each entry in the list corresponds to the same tile
				Polygon poly = firstSpot.getCanvasTilePoly();
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, color.darker());
				}
			}

			FishingSpot spotArray[] = spotList.elementSet().toArray(new FishingSpot[0]);
			for (int i = 0; i < spotArray.length; i++)
			{
				// Use the first NPC to get the canvas location of the tile
				NPC firstNPC = npcArray[0];
				FishingSpot spot = spotArray[i];
				int spotCount = spotList.count(spotArray[i]);

				if (config.showSpotIcons())
				{
					BufferedImage fishImage;
					if (spotCount > 1 && !(config.showSpotNames()))
					{
						fishImage = itemManager.getImage(spot.getFishSpriteId(), spotCount, true);
					}
					else
					{
						fishImage = itemManager.getImage(spot.getFishSpriteId());
					}

					if (fishImage != null)
					{
						Point imageLocation = firstNPC.getCanvasImageLocation(fishImage, 34);
						if (imageLocation != null)
						{
							int offset = (i * 34) - ((34 * (spotArray.length - 1)) / 2);
							Point shiftedImageLocation = new Point(imageLocation.getX() + offset, imageLocation.getY());
							OverlayUtil.renderImageLocation(graphics, shiftedImageLocation, fishImage);
						}
					}
				}

				if (config.showSpotNames())
				{
					String text = spot.getName();
					if (spotCount > 1)
					{
						text += " (" +  spotCount + ")";
					}
					Point textLocation = firstNPC.getCanvasTextLocation(graphics, text, 74 + (i * 20));
					if (textLocation != null)
					{
						OverlayUtil.renderTextLocation(graphics, textLocation, text, color.darker());
					}
				}
			}
		}

		return null;
	}
}
