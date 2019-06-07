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
package net.runelite.client.plugins.mining;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import api.Client;
import api.GameObject;
import api.Perspective;
import api.Player;
import api.Point;
import api.Skill;
import api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class MiningRocksOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final MiningPlugin plugin;
	private final MiningConfig config;

	private final BufferedImage miningIcon;

	@Inject
	MiningRocksOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;

		miningIcon = iconManager.getSkillImage(Skill.MINING);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Player local = client.getLocalPlayer();

		renderTiles(graphics, local);

		return null;
	}

	private void renderTiles(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();

		if (config.showMiningRocks())
		{
			for (GameObject rock : plugin.getRocks())
			{

				LocalPoint location = rock.getLocalLocation();
				if (localLocation.distanceTo(location) <= MAX_DISTANCE)
				{
					renderMiningRock(graphics, rock);
				}
			}
		}

	}

	private void renderMiningRock(Graphics2D graphics, GameObject rock)
	{
		Point canvasLoc = Perspective.getCanvasImageLocation(client, rock.getLocalLocation(), miningIcon, 0);
		if (canvasLoc != null)
		{
			graphics.drawImage(miningIcon, canvasLoc.getX(), canvasLoc.getY(), null);
		}
	}

//	private void renderMiningRockSquare(Graphics2D graphics, GameObject rock)
//	{
//		Polygon poly = Perspective.getCanvasTilePoly(client, rock.getLocalLocation());
//
//		if (poly != null)
//		{
//			OverlayUtil.renderPolygon(graphics, poly, Color.red);
//		}
//	}

}
