/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2018, https://github.com/runeliteplusplus
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

package net.runelite.client.plugins.zulrah;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class ZulrahJadOverlay extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private final ZulrahConfig config;
	private final ZulrahPlugin plugin;
	private final SpriteManager spriteManager;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private Client client;

	@Inject
	private ZulrahJadOverlay(ZulrahConfig config, ZulrahPlugin plugin, SpriteManager spriteManager)
	{
		this.config = config;
		this.plugin = plugin;
		this.spriteManager = spriteManager;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.ZulrahJadHelper())
		{
			return null;
		}
		NPC Zulrah = plugin.Zulrah;
		if (Zulrah != null)
		{
			if (plugin.jadphase > 0)
			{
				if (plugin.jadphase == 1)
				{
					if (plugin.jadflip)
					{
						final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);
					}
					else
					{
						final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);
					}
				}
				else if (plugin.jadphase == 2)
				{
					if (plugin.jadflip)
					{
						final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);
					}
					else
					{
						final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);
					}
				}
				return imagePanelComponent.render(graphics);
			}
		}
		return null;
	}
}
