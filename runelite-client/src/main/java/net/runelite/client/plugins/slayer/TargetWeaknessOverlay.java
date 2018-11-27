/*
 * Copyright (c) 2018, Sam "Berry" Beresford <seb1g13@soton.ac.uk>
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
package net.runelite.client.plugins.slayer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class TargetWeaknessOverlay extends Overlay
{
	private final Client client;
	private final SlayerConfig config;
	private final SlayerPlugin plugin;
	private final ItemManager itemManager;

	@Inject
	private TargetWeaknessOverlay(Client client, SlayerConfig config, SlayerPlugin plugin, ItemManager itemManager)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.itemManager = itemManager;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.weaknessPrompt())
		{
			return null;
		}

		Task curTask = Task.getTask(plugin.getTaskName());
		if (curTask == null)
		{
			return null;
		}

		float threshold = 0f;
		switch (curTask)
		{
			case DESERT_LIZARDS:	threshold = 0.1f;	break;
			case GARGOYLES:			threshold = 0.086f; break;
			case ROCKSLUGS:			threshold = 0.185f; break;
		}


		List<NPC> targets = plugin.getHighlightedTargets();
		for (NPC target : targets)
		{
			float healthRatio = target.getHealthRatio();
			float healthScale = target.getHealth();
			if (healthRatio <= 0 || healthScale <= 0)
			{
				continue;
			}

			float currentHealth = healthRatio / healthScale;

			if (currentHealth <= threshold)
			{
				renderTargetItem(graphics, target, curTask);
			}
		}
		return null;
	}

	private void renderTargetItem(Graphics2D graphics, NPC actor, Task curTask)
	{
		BufferedImage image = null;
		switch (curTask)
		{
			case DESERT_LIZARDS:	image = itemManager.getImage(ItemID.ICE_COOLER);	break;
			case GARGOYLES:			image = itemManager.getImage(ItemID.ROCK_HAMMER);	break;
			case ROCKSLUGS:			image = itemManager.getImage(ItemID.BAG_OF_SALT);	break;
		}

		LocalPoint actorPosition = actor.getLocalLocation();
		int offset = actor.getLogicalHeight() + 40;

		if (actorPosition != null && image != null)
		{
			Point imageLoc = Perspective.getCanvasImageLocation(client, actorPosition, image, offset);
			if (imageLoc != null)
			{
				OverlayUtil.renderImageLocation(graphics, imageLoc, image);
			}
		}
	}
}
