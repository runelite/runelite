/*
 * Copyright (c) 2018, John Pettenger
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.runecraft;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
public class DenseRunestoneOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2600;
	private static final int Z_OFFSET = 200;

	private final Client client;
	private final RunecraftPlugin plugin;
	private final RunecraftConfig config;
	private final SkillIconManager skillIconManager;

	@Inject
	private DenseRunestoneOverlay(
		Client client, RunecraftPlugin plugin, RunecraftConfig config, SkillIconManager skillIconManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.skillIconManager = skillIconManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showDenseRunestoneIndicator())
		{
			return null;
		}

		boolean northStoneMineable = plugin.isDenseRunestoneNorthMineable();
		boolean southStoneMineable = plugin.isDenseRunestoneSouthMineable();
		GameObject northStone = plugin.getDenseRunestoneNorth();
		GameObject southStone = plugin.getDenseRunestoneSouth();

		if (northStoneMineable && northStone != null)
		{
			showPickaxeIndicator(graphics, northStone);
		}
		if (southStoneMineable && southStone != null)
		{
			showPickaxeIndicator(graphics, southStone);
		}

		return null;
	}

	private void showPickaxeIndicator(Graphics2D graphics, GameObject gameObject)
	{
		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		LocalPoint gameObjectLocation = gameObject.getLocalLocation();
		if (gameObjectLocation.distanceTo(playerLocation) < MAX_DISTANCE)
		{
			OverlayUtil.renderImageLocation(
				client, graphics, gameObjectLocation,
				skillIconManager.getSkillImage(Skill.MINING, false), Z_OFFSET);
		}
	}
}
