/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class HydraPrayerOverlay extends Overlay
{
	private static final Color ACTIVATED_BACKGROUND_COLOR = new Color(0, 150, 0, 150);
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

	private final HydraPlugin hydraPlugin;

	private final Client client;

	private final SpriteManager spriteManager;

	private final PanelComponent panelComponent;

	@Setter(AccessLevel.PACKAGE)
	private Map<Integer, Hydra> hydras;

	private BufferedImage bufferedImageRange;
	private BufferedImage bufferedImageMagic;

	@Inject
	private HydraPrayerOverlay(final HydraPlugin hydraPlugin, final Client client, final SpriteManager spriteManager)
	{
		this.hydraPlugin = hydraPlugin;
		this.client = client;
		this.spriteManager = spriteManager;
		this.panelComponent = new PanelComponent();
		this.hydras = new HashMap<>();
		this.bufferedImageRange = null;
		this.bufferedImageMagic = null;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final NPC npc = hydraPlugin.getInteractingNpc();

		if (npc == null)
		{
			return null;
		}

		final Hydra hydra = hydras.get(npc.getIndex());

		if (hydra == null)
		{
			return null;
		}

		final HydraAnimation hydraAnimation = hydra.getHydraAnimation();

		if (hydraAnimation == null || !HydraPlugin.VALID_HYDRA_ANIMATIONS.contains(hydraAnimation))
		{
			return null;
		}

		if (bufferedImageMagic == null)
		{
			bufferedImageMagic = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
		}

		if (bufferedImageRange == null)
		{
			bufferedImageRange = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
		}

		final boolean attackCountIsMax = hydra.getAttackCount() == Hydra.MAX_ATTACK_COUNT;

		switch (hydraAnimation)
		{
			case RANGE:
				if (attackCountIsMax)
				{
					return renderPanelMagic(graphics);
				}
				else
				{
					return renderPanelRange(graphics);
				}
			case MAGIC:
				if (attackCountIsMax)
				{
					return renderPanelRange(graphics);
				}
				else
				{
					return renderPanelMagic(graphics);
				}
			default:
				break;
		}

		return null;
	}

	private Dimension renderPanelMagic(final Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(new ImageComponent(bufferedImageMagic));
		panelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
			? ACTIVATED_BACKGROUND_COLOR
			: NOT_ACTIVATED_BACKGROUND_COLOR);

		return panelComponent.render(graphics);
	}

	private Dimension renderPanelRange(final Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(new ImageComponent(bufferedImageRange));
		panelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
			? ACTIVATED_BACKGROUND_COLOR
			: NOT_ACTIVATED_BACKGROUND_COLOR);

		return panelComponent.render(graphics);
	}
}
