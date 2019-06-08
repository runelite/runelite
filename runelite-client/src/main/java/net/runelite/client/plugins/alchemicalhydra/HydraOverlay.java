/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.alchemicalhydra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
class HydraOverlay extends Overlay
{
	private final HydraPlugin plugin;
	private final Client client;
	private final SpriteManager spriteManager;
	private final PanelComponent panelComponent = new PanelComponent();
	private static final Color redBgCol = new Color(156, 0, 0, 156);
	private static final Color yelBgCol = new Color(200, 156, 0, 156);
	private static final Color grnBgCol = new Color(0, 156, 0, 156);

	@Inject
	HydraOverlay(HydraPlugin plugin, Client client, SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setOrientation(ComponentOrientation.VERTICAL);
	}

	@Override
	public Dimension render(Graphics2D graphics2D)
	{
		Hydra hydra = plugin.getHydra();
		panelComponent.getChildren().clear();

		if (hydra == null || client == null)
		{
			return null;
		}

		//Add spec overlay first, to keep it above pray
		HydraPhase phase = hydra.getPhase();
		int attackCount = hydra.getAttackCount();
		int nextSpec = hydra.getNextSpecial() - attackCount;

		if (nextSpec <= 3)
		{
			InfoBoxComponent specComponent = new InfoBoxComponent();

			if (nextSpec == 0)
			{
				specComponent.setBackgroundColor(redBgCol);
			}
			else if (nextSpec == 1)
			{
				specComponent.setBackgroundColor(yelBgCol);
			}
			Image specImg = scaleImg(spriteManager.getSprite(phase.getSpecImage(), 0));

			specComponent.setImage(specImg);
			specComponent.setText("        " + (nextSpec)); //hacky way to not have to figure out how to move text
			specComponent.setPreferredSize(new Dimension(40, 40));
			panelComponent.getChildren().add(specComponent);
		}


		Prayer nextPrayer = hydra.getNextAttack().getPrayer();
		Image prayImg = scaleImg(getPrayerImage(hydra.getNextAttack().getPrayer()));
		int nextSwitch = hydra.getNextSwitch();

		InfoBoxComponent prayComponent = new InfoBoxComponent();

		if (nextSwitch == 1)
		{
			prayComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? yelBgCol : redBgCol);
		}
		else
		{
			prayComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? grnBgCol : redBgCol);
		}

		prayComponent.setImage(prayImg);
		prayComponent.setText("        " + nextSwitch);
		prayComponent.setColor(Color.white);
		prayComponent.setPreferredSize(new Dimension(40, 40));
		panelComponent.getChildren().add(prayComponent);

		panelComponent.setPreferredSize(new Dimension(40, 0));
		panelComponent.setBorder(new Rectangle(0, 0, 0, 0));
		return panelComponent.render(graphics2D);
	}

	private BufferedImage getPrayerImage(Prayer pray)
	{
		return pray == Prayer.PROTECT_FROM_MAGIC
			? spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0)
			: spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
	}

	private Image scaleImg(final Image img)
	{
		if (img == null)
		{
			return null;
		}
		final double width = img.getWidth(null);
		final double height = img.getHeight(null);
		final double size = 36; // Limit size to 2 as that is minimum size not causing breakage
		final double scalex = size / width;
		final double scaley = size / height;
		final double scale = Math.min(scalex, scaley);
		final int newWidth = (int) (width * scale);
		final int newHeight = (int) (height * scale);
		final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		final Graphics g = scaledImage.createGraphics();
		g.drawImage(img, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return scaledImage;
	}
}
