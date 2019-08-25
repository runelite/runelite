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
package net.runelite.client.plugins.shayzieninfirmary;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class ShayzienInfirmaryOverlay extends Overlay
{
	private final ShayzienInfirmaryPlugin plugin;

	private BufferedImage medPackImage;

	@Inject
	public ShayzienInfirmaryOverlay(final ShayzienInfirmaryPlugin plugin, final ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.plugin = plugin;

		medPackImage = itemManager.getImage(ItemID.SHAYZIEN_MEDPACK);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isNotAtInfirmary())
		{
			return null;
		}

		for (NPC npc : plugin.getUnhealedSoldiers())
		{

			Polygon tilePoly = npc.getCanvasTilePoly();

			if (tilePoly == null)
			{
				continue;
			}

			OverlayUtil.renderPolygon(graphics, npc.getCanvasTilePoly(), Color.ORANGE);

			Point imageLocation = npc.getCanvasImageLocation(medPackImage, 25);

			if (imageLocation == null)
			{
				continue;
			}

			Composite originalComposite = graphics.getComposite();
			Composite translucentComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);

			graphics.setComposite(translucentComposite);

			OverlayUtil.renderImageLocation(graphics, imageLocation, medPackImage);

			graphics.setComposite(originalComposite);
		}

		return null;
	}
}
