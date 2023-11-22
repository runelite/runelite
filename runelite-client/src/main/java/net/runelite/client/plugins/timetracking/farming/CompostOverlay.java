/*
 * Copyright (c) 2022 Grom-met
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking.farming;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeTrackingPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

public class CompostOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;
	private final Client client;
	private final TimeTrackingConfig config;
	private final CompostTracker tracker;
	private final FarmingWorld farmingWorld;
	private final ModelOutlineRenderer modelOutlineRenderer;
	private final ArrayList<FarmingPatch> regionPatches;

	@Inject
	private CompostOverlay(Client client, TimeTrackingPlugin plugin, TimeTrackingConfig config, CompostTracker tracker, FarmingWorld farmingWorld, ModelOutlineRenderer modelOutlineRenderer)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.tracker = tracker;
		this.farmingWorld = farmingWorld;
		this.modelOutlineRenderer = modelOutlineRenderer;
		regionPatches = new ArrayList<>();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.compostHighlights())
		{
			return null;
		}

		LocalPoint playerLocalLocation = client.getLocalPlayer().getLocalLocation();
		WorldPoint playerWorldLocation = client.getLocalPlayer().getWorldLocation();
		for (FarmingRegion region : farmingWorld.getRegionsForLocation(playerWorldLocation))
		{
			// Only get patches in the region that have been treated with compost
			regionPatches.addAll(new ArrayList<>((Arrays.stream(region.getPatches())
				.filter(fp -> tracker.getCompostState(fp) != null))
				.collect(Collectors.toList())));
		}

		if (regionPatches.isEmpty())
		{
			return null;
		}

		// Only want tiles on the same plane as the player
		for (Tile[] tiles : client.getScene().getTiles()[playerWorldLocation.getPlane()])
		{
			for (Tile tile : tiles)
			{
				GameObject gameObject = tile.getGameObjects()[0];
				if (gameObject == null)
				{
					continue;
				}
				if (gameObject.getLocalLocation().distanceTo(playerLocalLocation) > MAX_DISTANCE)
				{
					continue;
				}
				int objectVarbit = client.getObjectDefinition(gameObject.getId()).getVarbitId();
				if (objectVarbit == -1)
				{
					continue;
				}
				for (FarmingPatch fp : regionPatches)
				{
					if (objectVarbit == fp.getVarbit())
					{
						switch (tracker.getCompostState(fp))
						{
							case COMPOST:
							{
								modelOutlineRenderer.drawOutline(gameObject, config.borderWidth(), config.compostHighlightColor(), config.outlineFeather());
								break;
							}
							case SUPERCOMPOST:
							{
								modelOutlineRenderer.drawOutline(gameObject, config.borderWidth(), config.supercompostHighlightColor(), config.outlineFeather());
								break;
							}
							case ULTRACOMPOST:
							{
								modelOutlineRenderer.drawOutline(gameObject, config.borderWidth(), config.ultracompostHighlightColor(), config.outlineFeather());
								break;
							}
						}
					}
				}
			}
		}

		regionPatches.clear();
		return null;
	}
}
