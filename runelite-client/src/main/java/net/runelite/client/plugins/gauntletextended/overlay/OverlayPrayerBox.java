/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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

package net.runelite.client.plugins.gauntletextended.overlay;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig.PrayerHighlightMode;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin;
import net.runelite.client.plugins.gauntletextended.entity.Hunllef;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.awt.image.BufferedImage;

@Singleton
public class OverlayPrayerBox extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

	private final Client client;

	private final GauntletExtendedPlugin plugin;
	private final GauntletExtendedConfig config;

	private final SpriteManager spriteManager;

	private final PanelComponent panelComponent;
	private final InfoBoxComponent infoBoxComponent;

	private BufferedImage spriteProtectFromMagic;
	private BufferedImage spriteProtectFromRange;

	@Inject
	OverlayPrayerBox(final Client client, final GauntletExtendedPlugin plugin, final GauntletExtendedConfig config, final SpriteManager spriteManager)
	{
		super(plugin);

		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.spriteManager = spriteManager;

		this.panelComponent = new PanelComponent();
		this.infoBoxComponent = new InfoBoxComponent();

		infoBoxComponent.setColor(Color.WHITE);
		infoBoxComponent.setPreferredSize(new Dimension(40, 40));

		panelComponent.getChildren().add(infoBoxComponent);
		panelComponent.setPreferredSize(new Dimension(40, 40));
		panelComponent.setBorder(new Rectangle(0, 0, 0, 0));

		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
		determineLayer();
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final PrayerHighlightMode prayerHighlightMode = config.prayerOverlay();

		if (prayerHighlightMode == PrayerHighlightMode.NONE || prayerHighlightMode == PrayerHighlightMode.WIDGET)
		{
			return null;
		}

		final Hunllef hunllef = plugin.getHunllef();

		if (hunllef == null)
		{
			return null;
		}

		final NPC npc = hunllef.getNpc();

		if (npc == null || npc.isDead())
		{
			return null;
		}

		final Prayer prayer = hunllef.getAttackPhase().getPrayer();

		infoBoxComponent.setImage(getPrayerSprite(prayer));

		infoBoxComponent.setBackgroundColor(client.isPrayerActive(prayer)
			? ComponentConstants.STANDARD_BACKGROUND_COLOR
			: NOT_ACTIVATED_BACKGROUND_COLOR);

		return panelComponent.render(graphics);
	}

	public void determineLayer()
	{
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	private BufferedImage getPrayerSprite(final Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				if (spriteProtectFromMagic == null)
				{
					spriteProtectFromMagic = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0));
				}

				return spriteProtectFromMagic;
			case PROTECT_FROM_MISSILES:
				if (spriteProtectFromRange == null)
				{
					spriteProtectFromRange = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0));
				}

				return spriteProtectFromRange;
			default:
				throw new IllegalStateException("Unexpected boss attack phase prayer: " + prayer);
		}
	}

	private static BufferedImage scaleSprite(final BufferedImage bufferedImage)
	{
		if (bufferedImage == null)
		{
			return null;
		}

		final double width = bufferedImage.getWidth(null);
		final double height = bufferedImage.getHeight(null);
		final double size = 36; // Limit size to 2 as that is minimum size not causing breakage
		final double scalex = size / width;
		final double scaley = size / height;
		final double scale = Math.min(scalex, scaley);
		final int newWidth = (int) (width * scale);
		final int newHeight = (int) (height * scale);
		final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		final Graphics g = scaledImage.createGraphics();
		g.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
		g.dispose();

		return scaledImage;
	}
}
