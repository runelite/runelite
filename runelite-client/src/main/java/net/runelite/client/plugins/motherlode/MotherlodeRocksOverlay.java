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
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
class MotherlodeRocksOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final MotherlodePlugin plugin;

	private final BufferedImage miningIcon;
	private final BufferedImage targetMiningIcon;
	private static final Color miningIconOldColor = new Color(117, 123, 124);
	private static final Color miningIconNewColor = new Color(0, 150, 0);

	@Inject
	MotherlodeRocksOverlay(final Client client, final MotherlodePlugin plugin, final SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;

		miningIcon = iconManager.getSkillImage(Skill.MINING);
		targetMiningIcon = ImageUtil.recolorImage(miningIcon, miningIconNewColor, Color -> Color.getRGB() == miningIconOldColor.getRGB());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if ((!plugin.isShowVeins() && !plugin.isShowRockFalls()) || !plugin.isInMlm())
		{
			return null;
		}

		Player local = client.getLocalPlayer();

		renderTiles(graphics, local);

		return null;
	}

	private void renderTiles(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();
		if (plugin.isShowVeins())
		{
			for (WallObject vein : plugin.getVeins())
			{
				LocalPoint location = vein.getLocalLocation();
				if (localLocation.distanceTo(location) <= MAX_DISTANCE && plugin.isUpstairs(localLocation) == plugin.isUpstairs(vein.getLocalLocation()))
				{
					if (WorldPoint.fromLocal(client, location).equals(plugin.getTargetVeinLocation())
						&& plugin.isMining()
						&& plugin.isShowTargetVein())
					{
						renderVein(graphics, vein, true);
					}
					else
					{
						renderVein(graphics, vein, false);
					}
				}
			}
		}

		if (plugin.isShowRockFalls())
		{
			for (GameObject rock : plugin.getRocks())
			{
				LocalPoint location = rock.getLocalLocation();
				if (localLocation.distanceTo(location) <= MAX_DISTANCE)
				{
					plugin.checkMining();
					renderRock(graphics, rock);
				}
			}
		}
	}

	private void renderVein(Graphics2D graphics, WallObject vein, Boolean shouldRecolor)
	{
		Point canvasLoc = Perspective.getCanvasImageLocation(client, vein.getLocalLocation(), miningIcon, 150);

		if (canvasLoc != null && !shouldRecolor)
		{
			graphics.drawImage(miningIcon, canvasLoc.getX(), canvasLoc.getY(), null);
		}
		else if (canvasLoc != null)
		{
			graphics.drawImage(targetMiningIcon, canvasLoc.getX(), canvasLoc.getY(), null);
		}
	}

	private void renderRock(Graphics2D graphics, GameObject rock)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, rock.getLocalLocation());

		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, Color.red);
		}
	}
}
