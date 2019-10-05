/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.hydra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class BabyHydraPrayOverlay extends Overlay
{
	private final BabyHydraPlugin plugin;

	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private BufferedImage prayMage;
	private BufferedImage prayRanged;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	@Inject
	private BabyHydraPrayOverlay(final BabyHydraPlugin plugin, final SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (prayMage == null)
		{
			prayMage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
		}
		if (prayRanged == null)
		{
			prayRanged = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
		}

		if (plugin.getHydra() != null && plugin.getHydras().containsKey(plugin.getHydra().getIndex()))
		{
			int val = plugin.getHydras().get(plugin.getHydra().getIndex());
			if (val != 0 && plugin.getHydraattacks().containsKey(plugin.getHydra().getIndex()))
			{
				int attack = plugin.getHydraattacks().get(plugin.getHydra().getIndex());
				if (attack == 8261)
				{
					if (val == 3)
					{
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayMage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);

						return imagePanelComponent.render(graphics);
					}
					else
					{
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayRanged));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);

						return imagePanelComponent.render(graphics);
					}
				}
				else if (attack == 8262)
				{
					if (val == 3)
					{
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayRanged));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);

						return imagePanelComponent.render(graphics);
					}
					else
					{
						imagePanelComponent.getChildren().clear();
						imagePanelComponent.getChildren().add(new ImageComponent(prayMage));
						imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
							? ComponentConstants.STANDARD_BACKGROUND_COLOR
							: NOT_ACTIVATED_BACKGROUND_COLOR);

						return imagePanelComponent.render(graphics);
					}
				}
			}
		}
		return null;
	}
}
