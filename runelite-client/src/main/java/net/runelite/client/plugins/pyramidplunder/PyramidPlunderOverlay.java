/*
 * Copyright (c) 2020 Mitchell <https://github.com/Mitchell-Kovacs>
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
package net.runelite.client.plugins.pyramidplunder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.time.Duration;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.GRAND_GOLD_CHEST_CLOSED_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.GRAND_GOLD_CHEST_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.SARCOPHAGUS_CLOSED_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.SARCOPHAGUS_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.SPEARTRAP_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.TOMB_DOOR_CLOSED_ID;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.TOMB_DOOR_WALL_IDS;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.URN_CLOSED_IDS;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.URN_IDS;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.RSTimeUnit;

class PyramidPlunderOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;

	private final PyramidPlunderPlugin plugin;

	private final PyramidPlunderConfig config;

	private static final Duration PYRAMID_PLUNDER_DURATION = Duration.of(501, RSTimeUnit.GAME_TICKS);


	private Integer penultimateFloor;
	private int thievingLevel;

	@Inject
	private PyramidPlunderOverlay(Client client, PyramidPlunderPlugin plugin, PyramidPlunderConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;

		this.thievingLevel = client.getRealSkillLevel(Skill.THIEVING);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget ppWidget = client.getWidget(ComponentID.PYRAMID_PLUNDER_DATA);
		if (ppWidget == null)
		{
			return null;
		}

		ppWidget.setHidden(config.hideTimer());

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

		int realThievingLevel = client.getRealSkillLevel(Skill.THIEVING);

		if (this.thievingLevel != realThievingLevel)
		{
			this.thievingLevel = realThievingLevel;
			this.penultimateFloor = (realThievingLevel - 1) / 10 - 2;
		}

		// Highlight convex hulls of urns, chests, and sarcophagus
		int currentFloor = client.getVarbitValue(Varbits.PYRAMID_PLUNDER_ROOM);
		for (GameObject object : plugin.getObjectsToHighlight())
		{
			if (shouldHighlightObjectOnFloor(object.getId(), currentFloor) && object.getLocalLocation().distanceTo(playerLocation) <= MAX_DISTANCE)
			{
				highlightObject(graphics, object);
			}
		}

		Point mousePosition = client.getMouseCanvasPosition();

		// Highlight clickboxes of speartraps and tomb doors
		plugin.getTilesToHighlight().forEach((object, tile) ->
		{
			if (!config.highlightDoors() && TOMB_DOOR_WALL_IDS.contains(object.getId())
				|| !config.highlightSpeartraps() && SPEARTRAP_ID == object.getId()
				|| tile.getPlane() != client.getPlane()
				|| object.getLocalLocation().distanceTo(playerLocation) >= MAX_DISTANCE)
			{
				return;
			}

			Color highlightColor;
			if (SPEARTRAP_ID == object.getId())
			{
				// this varbit is set to 1 when you enter a room and 0 once you get passed the spike traps
				if (client.getVarbitValue(Varbits.PYRAMID_PLUNDER_ROOM_LOCATION) != 1)
				{
					return;
				}

				highlightColor = config.highlightSpeartrapsColor();
			}
			else
			{
				ObjectComposition impostor = client.getObjectDefinition(object.getId()).getImpostor();
				if (impostor.getId() != TOMB_DOOR_CLOSED_ID)
				{
					return;
				}

				highlightColor = config.highlightDoorsColor();
			}

			Shape objectClickbox = object.getClickbox();
			if (objectClickbox != null)
			{
				if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
				{
					graphics.setColor(highlightColor.darker());
				}
				else
				{
					graphics.setColor(highlightColor);
				}

				graphics.draw(objectClickbox);
				graphics.setColor(ColorUtil.colorWithAlpha(highlightColor, highlightColor.getAlpha() / 5));
				graphics.fill(objectClickbox);
			}
		});

		return null;
	}

	private void highlightObject(Graphics2D graphics, GameObject object)
	{
		ObjectComposition impostor = client.getObjectDefinition(object.getId()).getImpostor();

		if (URN_CLOSED_IDS.contains(impostor.getId())
			|| GRAND_GOLD_CHEST_CLOSED_ID == impostor.getId()
			|| SARCOPHAGUS_CLOSED_ID == impostor.getId())
		{
			Shape shape = object.getConvexHull();

			if (shape != null)
			{
				OverlayUtil.renderPolygon(graphics, shape, config.highlightContainersColor());
			}
		}
	}

	private boolean shouldHighlightObjectOnFloor(int objectId, int currentFloor)
	{
		if (URN_IDS.contains(objectId))
		{
			boolean shouldHighlightPenultimateUrns = config.highlightPenultimateUrns() && URN_IDS.contains(objectId);
			return
				currentFloor > this.penultimateFloor && shouldHighlightPenultimateUrns ||
					currentFloor >= config.highlightUrnsFloor() ||
					currentFloor == this.penultimateFloor && shouldHighlightPenultimateUrns && stillWithinTimeLimit();

		}
		else if (GRAND_GOLD_CHEST_ID == objectId)
		{
			return currentFloor >= config.highlightChestFloor();
		}
		else if (SARCOPHAGUS_ID == objectId)
		{
			return currentFloor >= config.highlightSarcophagusFloor();
		}
		return false;
	}

	private boolean stillWithinTimeLimit()
	{
		if (config.highlightUrnsUntil() == 0)
		{
			return true;
		}
		int ppTimer = client.getVar(Varbits.PYRAMID_PLUNDER_TIMER);
		Duration remaining = PYRAMID_PLUNDER_DURATION.minus(ppTimer, RSTimeUnit.GAME_TICKS);
		// Want to stop highlighting on the second, plus another second to account for 501 ticks
		int correctedTimeUtil = config.highlightUrnsUntil() + 2;
		return remaining.compareTo(Duration.ofSeconds(correctedTimeUtil)) >= 0;
	}
}
