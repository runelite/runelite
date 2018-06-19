/*
 * Copyright (c) 2016-2018, Dewin <dewin@dewinster.com>
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
package net.runelite.client.plugins.vorkath;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

class VorkathOverlay extends Overlay
{
	private static final int INFOBOX_DIMENSION_SIZE = 52;

	private final VorkathPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();
	private BufferedImage mergedImage;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private VorkathOverlay(final VorkathPlugin plugin)
	{
		this.plugin = plugin;

		setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());
		panelComponent.setPreferredSize(new Dimension(INFOBOX_DIMENSION_SIZE, INFOBOX_DIMENSION_SIZE));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInArea())
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (plugin.getVorkathState() == VorkathState.TICKER_FIRE_PHASE)
		{
			drawTickerPhasePanel();
		}
		else
		{
			drawDefaultPanel();
		}

		return panelComponent.render(graphics);
	}

	private void drawDefaultPanel()
	{
		final VorkathState specialAttack = plugin.getNextSpecialAttack();
		final BufferedImage poisonImage = spriteManager.getSprite(SpriteID.HITSPLAT_GREEN_POISON, 0);
		final BufferedImage freezeImage = spriteManager.getSprite(SpriteID.SPELL_ICE_BARRAGE, 0);

		switch (specialAttack)
		{
			case IDLE:
				if (mergedImage == null && poisonImage != null && freezeImage != null)
				{
					mergedImage = new BufferedImage(poisonImage.getWidth() + freezeImage.getWidth() + 3, poisonImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
					final Graphics graphics = mergedImage.getGraphics();
					graphics.drawImage(poisonImage, 0, 0, null);
					graphics.drawImage(freezeImage, poisonImage.getWidth() + 3, 0, null);
					graphics.dispose();
				}

				panelComponent.getChildren().add(new VorkathPhaseInfoBox(mergedImage, plugin.getAttacksTillSpecial()));
				break;
			case TICKER_FIRE_PHASE:
				panelComponent.getChildren().add(new VorkathPhaseInfoBox(poisonImage, plugin.getAttacksTillSpecial()));
				break;
			case FREEZE_PHASE:
				panelComponent.getChildren().add(new VorkathPhaseInfoBox(freezeImage, plugin.getAttacksTillSpecial()));
				break;
		}
	}

	private void drawTickerPhasePanel()
	{
		final BufferedImage poisonImage = spriteManager.getSprite(SpriteID.HITSPLAT_GREEN_POISON, 0);
		panelComponent.getChildren().add(
			new VorkathPhaseInfoBox(poisonImage, plugin.getAmountOfPoisonBoltsLeft()));
	}
}
