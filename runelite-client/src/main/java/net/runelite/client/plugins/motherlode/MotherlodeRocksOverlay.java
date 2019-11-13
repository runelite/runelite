/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class MotherlodeRocksOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final SkillIconManager iconManager;

	private final BufferedImage miningIcon;

	@Inject
	MotherlodeRocksOverlay(Client client, MotherlodePlugin plugin, MotherlodeConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.iconManager = iconManager;

		miningIcon = getScaledMiningIcon();
	}

	private BufferedImage getScaledMiningIcon()
	{
		BufferedImage miningIcon = iconManager.getSkillImage(Skill.MINING);

		int newW = (int) (miningIcon.getWidth() * (config.oreScaling() / 100.0f));
		int newH = (int) (miningIcon.getHeight() * (config.oreScaling() / 100.0f));

		if (newW <= 0)
		{
			newW = miningIcon.getWidth();
		}
		if (newH <= 0)
		{
			newH = miningIcon.getHeight();
		}

		Image tmp = miningIcon.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage bImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics2D = bImg.createGraphics();
		graphics2D.drawImage(tmp, 0, 0, null);
		graphics2D.dispose();

		return bImg;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Only render if the user is in MLM and wants to render veins or rockfalls
		if ((config.showVeins() || config.showRockFalls()) && plugin.isInMlm()) {
			Player local = client.getLocalPlayer();

			if (local != null)
			{
				renderTiles(graphics, local);
			}
		}

		return null;
	}

	private void renderTiles(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();

		if (config.showVeins())
		{
			plugin.getVeins().forEach(vein ->
			{
				LocalPoint location = vein.getLocalLocation();

				if (localLocation.distanceTo(location) <= MAX_DISTANCE)
				{
					// Only draw veins on the same level
					if (plugin.isUpstairs(localLocation) == plugin.isUpstairs(location))
					{
						renderVein(graphics, vein);
					}
				}
			});
		}

		if (config.showRockFalls())
		{
			plugin.getRocks().forEach(rock ->
			{
				LocalPoint location = rock.getLocalLocation();

				if (localLocation.distanceTo(location) <= MAX_DISTANCE)
				{
					// Only draw rockfalls on the same level
					if (plugin.isUpstairs(localLocation) == plugin.isUpstairs(location))
					{
						renderRock(graphics, rock);
					}
				}
			});
		}
	}

	private void renderVein(Graphics2D graphics, WallObject vein)
	{
		Point canvasLoc = Perspective.getCanvasImageLocation(client, vein.getLocalLocation(), miningIcon, 150);

		if (canvasLoc != null)
			graphics.drawImage(getScaledMiningIcon(), canvasLoc.getX(), canvasLoc.getY(), null);
	}

	private void renderRock(Graphics2D graphics, GameObject rock)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, rock.getLocalLocation());

		if (poly != null)
			OverlayUtil.renderPolygon(graphics, poly, Color.red);
	}
}
