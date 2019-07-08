/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
@Singleton
public class PortalWeaknessOverlay extends Overlay
{
	private final PestControlPlugin plugin;
	private final Client client;

	private final BufferedImage magicImage;
	private final BufferedImage rangedImage;
	private final BufferedImage stabImage;
	private final BufferedImage slashImage;
	private final BufferedImage crushImage;

	@Inject
	PortalWeaknessOverlay(
		final PestControlPlugin plugin,
		final Client client,
		final ItemManager itemManager,
		final SkillIconManager skillIconManager
	)
	{
		this.plugin = plugin;
		this.client = client;

		this.magicImage = skillIconManager.getSkillImage(Skill.MAGIC);
		this.rangedImage = skillIconManager.getSkillImage(Skill.RANGED);

		this.stabImage = itemManager.getImage(ItemID.WHITE_DAGGER);
		this.slashImage = itemManager.getImage(ItemID.WHITE_SCIMITAR);
		this.crushImage = itemManager.getImage(ItemID.WHITE_WARHAMMER);

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	private Point getPortalPoint(Portal portal)
	{
		WorldPoint portalLocation = portal.getLocation();
		LocalPoint localLocation = LocalPoint.fromWorld(client, portalLocation);

		if (localLocation == null)
		{
			return null;
		}

		// We can use any image here as it's only needed to calculate the position

		int zOffset = 100;
		return Perspective.getCanvasImageLocation(client, localLocation, magicImage, zOffset);

	}

	private void renderPortalWeakness(Graphics2D graphics, Portal portal, BufferedImage image)
	{
		Point portalPoint = getPortalPoint(portal);

		if (portalPoint != null)
		{
			Composite originalComposite = graphics.getComposite();
			Composite translucentComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			graphics.setComposite(translucentComposite);

			OverlayUtil.renderImageLocation(graphics, portalPoint, image);

			graphics.setComposite(originalComposite);
		}
	}

	private void renderDoublePortalWeakness(
		Graphics2D graphics,
		Portal portal,
		BufferedImage imageLeft,
		BufferedImage imageRight
	)
	{
		Point portalPoint = getPortalPoint(portal);

		if (portalPoint != null)
		{
			Point portalLeft = new Point(
				portalPoint.getX() - (imageLeft.getWidth() / 2) - 5,
				portalPoint.getY()
			);

			Point portalRight = new Point(
				portalPoint.getX() + (imageRight.getWidth() / 2) + 5,
				portalPoint.getY()
			);

			Composite originalComposite = graphics.getComposite();
			Composite translucentComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
			graphics.setComposite(translucentComposite);

			OverlayUtil.renderImageLocation(graphics, portalLeft, imageLeft);
			OverlayUtil.renderImageLocation(graphics, portalRight, imageRight);

			graphics.setComposite(originalComposite);
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Game game = plugin.getGame();

		if (game == null)
		{
			return null;
		}

		for (Portal portal : game.getPortals())
		{
			if (!portal.isDead())
			{
				switch (portal.getColor())
				{
					case BLUE:
					{
						renderPortalWeakness(graphics, portal, magicImage);
						break;
					}
					case YELLOW:
					{
						renderDoublePortalWeakness(graphics, portal, stabImage, slashImage);
						break;
					}
					case RED:
					{
						renderPortalWeakness(graphics, portal, crushImage);
						break;
					}
					case PURPLE:
					{
						renderPortalWeakness(graphics, portal, rangedImage);
						break;
					}
				}
			}
		}

		return null;
	}
}