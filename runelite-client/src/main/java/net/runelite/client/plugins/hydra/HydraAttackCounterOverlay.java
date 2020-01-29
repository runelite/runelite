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
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class HydraAttackCounterOverlay extends Overlay
{
	private final HydraPlugin hydraPlugin;

	private final Client client;

	@Setter(AccessLevel.PACKAGE)
	private Map<Integer, Hydra> hydras;

	@Setter(AccessLevel.PACKAGE)
	private boolean isBoldAttackCounterOverlay;

	@Inject
	private HydraAttackCounterOverlay(final HydraPlugin hydraPlugin, final Client client)
	{
		this.hydraPlugin = hydraPlugin;
		this.client = client;
		this.hydras = new HashMap<>();
		this.isBoldAttackCounterOverlay = false;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		if (!hydraPlugin.isPlayerAtHydraRegion())
		{
			return null;
		}

		for (final NPC npc : client.getNpcs())
		{
			final Hydra hydra = hydras.get(npc.getIndex());

			if (hydra == null)
			{
				continue;
			}

			if (isBoldAttackCounterOverlay)
			{
				graphics.setFont(FontManager.getRunescapeBoldFont());
			}
			else
			{
				graphics.setFont(FontManager.getRunescapeFont());
			}

			renderAnimationAttackType(graphics, hydra);
			renderAttackCount(graphics, hydra);
		}

		return null;
	}

	private void renderAnimationAttackType(final Graphics2D graphics, final Hydra hydra)
	{
		final HydraAnimation hydraAnimation = hydra.getHydraAnimation();

		if (hydraAnimation == null)
		{
			return;
		}

		final int heightOffset = 100;

		final Point textLocation = hydra.getCanvasTextLocation(graphics, "TEMP!",
			hydra.getLogicalHeight() + heightOffset);

		if (textLocation == null)
		{
			return;
		}

		final boolean attackCountIsMax = hydra.getAttackCount() == Hydra.MAX_ATTACK_COUNT;

		switch (hydraAnimation)
		{
			case RANGE:
				if (attackCountIsMax)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, HydraAnimation.MAGIC.getText(),
						HydraAnimation.MAGIC.getColor());
				}
				else
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, HydraAnimation.RANGE.getText(),
						HydraAnimation.RANGE.getColor());
				}
				break;
			case MAGIC:
				if (attackCountIsMax)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, HydraAnimation.RANGE.getText(),
						HydraAnimation.RANGE.getColor());
				}
				else
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, HydraAnimation.MAGIC.getText(),
						HydraAnimation.MAGIC.getColor());
				}
				break;
			default:
				break;
		}
	}

	private void renderAttackCount(final Graphics2D graphics, final Hydra hydra)
	{
		final int attackCount = hydra.getAttackCount();

		final int heightOffset = 30;

		final Point textLocation = hydra.getCanvasTextLocation(graphics, Integer.toString(attackCount),
			hydra.getLogicalHeight() + heightOffset);

		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, Integer.toString(attackCount), Color.WHITE);
		}
	}
}
