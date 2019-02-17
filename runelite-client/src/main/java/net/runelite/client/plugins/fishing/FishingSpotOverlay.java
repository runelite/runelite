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
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
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

	private static HashMap<WorldPoint, FishingSpotInfo> SPOTS_LIST = new HashMap<>();

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

			FishingSpotInfo spotsInfo = SPOTS_LIST.get(npc.getWorldLocation());
			if (spotsInfo == null)
			{
				spotsInfo = new FishingSpotInfo(spot, npc);
				SPOTS_LIST.put(npc.getWorldLocation(), spotsInfo);
			}
			else
			{
				int spotCount = spotsInfo.getCount(spot);
				if (spotCount >= 1)
				{
					spotsInfo.incrementCount(spot);
				}
				else
				{
					spotsInfo.addSpot(spot, npc);
				}
			}
		}

		for (HashMap.Entry<WorldPoint, FishingSpotInfo> entry : SPOTS_LIST.entrySet())
		{
			WorldPoint tile = entry.getKey();
			FishingSpotInfo fishingSpots = entry.getValue();

			// minnow fishing spots will only ever share tiles with other minnow fishing spots
			FishingSpot possibleMinnowSpot = fishingSpots.getSpot(0);
			NPC firstSpot  = fishingSpots.getNpc(0);
			Color color = firstSpot.getGraphic() == GraphicID.FLYING_FISH ? Color.RED : Color.CYAN;

			if (possibleMinnowSpot == FishingSpot.MINNOW && config.showMinnowOverlay())
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

			for (int i = 0; i < fishingSpots.getSize(); i++)
			{
				FishingSpot spot = fishingSpots.getSpot(i);
				NPC npc = fishingSpots.getNpc(i);

				int spotCount = fishingSpots.getCount(spot);

				if (config.showSpotIcons())
				{
					BufferedImage fishImage = null;

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
						Point imageLocation = npc.getCanvasImageLocation(fishImage, 34);
						if (imageLocation != null)
						{
							int offset = (i * 34) - ((34 * (fishingSpots.getSize() - 1)) / 2);
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
					Point textLocation = npc.getCanvasTextLocation(graphics, text, 74 + (i * 20));
					if (textLocation != null)
					{
						OverlayUtil.renderTextLocation(graphics, textLocation, text, color.darker());
					}
				}
			}
		}

		return null;
	}

	private class FishingSpotInfo
	{
		private ArrayList<FishingSpot> spotList;
		private ArrayList<NPC> npcList;
		private ArrayList<Integer> countList;

		FishingSpotInfo(FishingSpot spot, NPC npc)
		{
			spotList = new ArrayList<>();
			spotList.add(spot);

			npcList = new ArrayList<>();
			npcList.add(npc);

			countList = new ArrayList<>();
			countList.add(1);
		}

		public FishingSpot getSpot(int i)
		{
			return spotList.get(i);
		}

		public NPC getNpc(int i)
		{
			return npcList.get(i);
		}

		public int getSize()
		{
			return spotList.size();
		}

		public int getCount(FishingSpot spot)
		{
			int index = exists(spot);
			if (index != -1)
			{
				return countList.get(index);
			}
			else
			{
				return 0;
			}
		}

		public void incrementCount(FishingSpot spot)
		{
			int index = exists(spot);
			if (index != -1)
			{
				int currentVal = countList.get(index);
				countList.set(index, currentVal + 1);
			}
		}

		// Returns index of spot within the ArrayList
		public int exists(FishingSpot spot)
		{
			for (int i = 0; i < spotList.size(); i++)
			{
				if (spotList.get(i) == spot)
				{
					return i;
				}
			}
			return -1;
		}

		public void addSpot(FishingSpot spot, NPC npc)
		{
			spotList.add(spot);
			npcList.add(npc);
			countList.add(1);
		}
	}
}
