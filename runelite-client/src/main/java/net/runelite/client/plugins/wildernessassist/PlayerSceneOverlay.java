/*
 * Copyright (c) 2018, Connor <contact@connor-parks.email>
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

package net.runelite.client.plugins.wildernessassist;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class PlayerSceneOverlay extends Overlay
{
	private final float HUE_YELLOW = 0.1666667f;
	private final float HUE_TENTH_STEP = 0.01666667f;

	private final Client client;
	private final WildernessAssistConfig config;
	private final WildernessAssistPlugin plugin;

	@Inject
	private PlayerSceneOverlay(Client client, WildernessAssistConfig config, WildernessAssistPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Player localPlayer = client.getLocalPlayer();
		final int localTeam = localPlayer.getTeam();
		final int wildernessLevel = plugin.getWildernessLevel();

		if (wildernessLevel == 0)
		{
			return null;
		}

		for (Player player : client.getCachedPlayers())
		{
			if (player == null || player.getName() == null || player == localPlayer)
			{
				continue;
			}

			if (player.isFriend() && config.shouldIgnoreFriends())
			{
				continue;
			}

			if (player.isClanMember() && config.shouldIgnoreClanMembers())
			{
				continue;
			}

			if (localTeam != 0 && localTeam == player.getTeam() && config.shouldIgnoreTeamMembers())
			{
				continue;
			}

			if (!plugin.withinCombatLevelRange(localPlayer, player, wildernessLevel))
			{
				continue;
			}

			int difficulty = plugin.getScaledDifficulty(localPlayer, player, wildernessLevel);

			renderPlayerOverlay(graphics, player, difficulty);
		}

		return null;
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player player, int difficulty)
	{
		LocalPoint lp = player.getLocalLocation();
		Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, 1);

		if (tilePoly == null)
		{
			return;
		}

		final Color color = Color.getHSBColor(HUE_YELLOW + (HUE_TENTH_STEP * difficulty), 1f, 1f);

		final TileBrightness brightness = config.getTileBrightness();

		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), brightness.getStroke()));
		graphics.setStroke(new BasicStroke(1));
		graphics.draw(tilePoly);

		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), brightness.getFill()));
		graphics.fill(tilePoly);
	}
}
