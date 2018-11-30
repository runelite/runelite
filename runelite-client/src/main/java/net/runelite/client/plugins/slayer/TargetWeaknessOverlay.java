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
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.NPCManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.Text;

class TargetWeaknessOverlay extends Overlay
{
	private final Client client;
	private final SlayerConfig config;
	private final SlayerPlugin plugin;
	private final ItemManager itemManager;
	private final NPCManager npcManager;

	@Inject
	private TargetWeaknessOverlay(Client client, SlayerConfig config, SlayerPlugin plugin, ItemManager itemManager, NPCManager npcManager)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.npcManager = npcManager;
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
		if (curTask == null || curTask.getWeaknessThreshold() < 0 || curTask.getWeaknessItem() < 0)
		{
			return null;
		}

		int threshold = curTask.getWeaknessThreshold();
		BufferedImage image = itemManager.getImage(curTask.getWeaknessItem());

		if (image == null)
		{
			return null;
		}

		List<NPC> targets = plugin.getHighlightedTargets();
		for (NPC target : targets)
		{
			int currentHealth = calculateHealth(target);

			if (currentHealth > 0 && currentHealth <= threshold)
			{
				renderTargetItem(graphics, target, image);
			}
		}
		return null;
	}


	/**
	 * Based on how health is calculated in OpponentInfoOverlay
	 */
	private int calculateHealth(NPC target)
	{
		if (target == null || target.getName() == null || target.getHealth() <= 0)
		{
			return -1;
		}

		int healthRatio = target.getHealthRatio();
		int healthScale = target.getHealth();
		String targetName = Text.removeTags(target.getName());
		Integer maxHealth = npcManager.getHealth(targetName, target.getCombatLevel());
		if (healthRatio < 0 || healthScale <= 0 || maxHealth == null)
		{
			return 0;
		}
		int minCurHealth = 1;
		int maxCurHealth;
		if (healthScale > 1)
		{
			if (healthRatio > 1)
			{
				// This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
				// health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
				minCurHealth = (maxHealth * (healthRatio - 1) + healthScale - 2) / (healthScale - 1);
			}
			maxCurHealth = (maxHealth * healthRatio - 1) / (healthScale - 1);
			if (maxCurHealth > maxHealth)
			{
				maxCurHealth = maxHealth;
			}
		}
		else
		{
			// If healthScale is 1, healthRatio will always be 1 unless health = 0
			// so we know nothing about the upper limit except that it can't be higher than maxHealth
			maxCurHealth = maxHealth;
		}
		// Take the average of min and max possible healths
		return (minCurHealth + maxCurHealth + 1) / 2;
	}

	private void renderTargetItem(Graphics2D graphics, NPC actor, BufferedImage image)
	{
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
