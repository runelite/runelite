/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.dagannothkings.overlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.dagannothkings.DagannothKingsConfig;
import net.runelite.client.plugins.dagannothkings.DagannothKingsPlugin;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class InfoboxOverlay extends Overlay
{
	private static final BufferedImage[] SPRITES = new BufferedImage[3];

	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

	private static final Dimension INFO_BOX_DIMENSION = new Dimension(40, 40);

	private static final PanelComponent PANEL_COMPONENT = new PanelComponent();
	private static final InfoBoxComponent PRAYER_COMPONENT = new InfoBoxComponent();

	static
	{
		PANEL_COMPONENT.getChildren().add(PRAYER_COMPONENT);
		PANEL_COMPONENT.setPreferredSize(INFO_BOX_DIMENSION);
		PANEL_COMPONENT.setBorder(new Rectangle(0, 0, 0, 0));

		PRAYER_COMPONENT.setPreferredSize(INFO_BOX_DIMENSION);
	}

	private final Client client;

	private final DagannothKingsPlugin plugin;
	private final DagannothKingsConfig config;

	private final SpriteManager spriteManager;

	@Inject
	public InfoboxOverlay(final Client client, final DagannothKingsPlugin plugin, final DagannothKingsConfig config, final SpriteManager spriteManager)
	{
		super(plugin);

		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.spriteManager = spriteManager;

		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		final Set<DagannothKing> dagannothKings = plugin.getDagannothKings();

		if (!config.showPrayerInfoboxOverlay() || dagannothKings.isEmpty())
		{
			return null;
		}

		final DagannothKing dk = dagannothKings.stream().sorted().findFirst().orElse(null);

		updatePrayerComponent(dk.getAttackStyle().getPrayer());

		return PANEL_COMPONENT.render(graphics2D);
	}

	private void updatePrayerComponent(final Prayer prayer)
	{
		PRAYER_COMPONENT.setBackgroundColor(client.isPrayerActive(prayer)
			? ComponentConstants.STANDARD_BACKGROUND_COLOR
			: NOT_ACTIVATED_BACKGROUND_COLOR);

		PRAYER_COMPONENT.setImage(getPrayerSprite(prayer));
	}

	private BufferedImage getPrayerSprite(final Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				if (SPRITES[0] == null)
				{
					SPRITES[0] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0));
				}

				return SPRITES[0];
			case PROTECT_FROM_MISSILES:
				if (SPRITES[1] == null)
				{
					SPRITES[1] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0));
				}

				return SPRITES[1];
			case PROTECT_FROM_MELEE:
				if (SPRITES[2] == null)
				{
					SPRITES[2] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0));
				}

				return SPRITES[2];
			default:
				throw new IllegalStateException("Unexpected prayer: " + prayer);
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
		final double size = 36;
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
