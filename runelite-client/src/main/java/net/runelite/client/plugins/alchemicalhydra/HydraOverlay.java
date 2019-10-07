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
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.IndexDataBase;
import net.runelite.api.Prayer;
import net.runelite.api.Sprite;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.ImageUtil;

@Singleton
class HydraOverlay extends Overlay
{
	static final int IMGSIZE = 36;

	private final HydraPlugin plugin;
	private final Client client;
	private final SpriteManager spriteManager;
	private final PanelComponent panelComponent = new PanelComponent();

	private BufferedImage stunImg;

	@Setter(AccessLevel.PACKAGE)
	private Color safeCol;

	@Setter(AccessLevel.PACKAGE)
	private Color medCol;

	@Setter(AccessLevel.PACKAGE)
	private Color badCol;

	@Setter(AccessLevel.PACKAGE)
	private int stunTicks;

	@Inject
	HydraOverlay(final HydraPlugin plugin, final Client client, final SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		this.setPosition(OverlayPosition.BOTTOM_RIGHT);
		panelComponent.setOrientation(ComponentOrientation.VERTICAL);
	}

	@Override
	public Dimension render(Graphics2D graphics2D)
	{
		final Hydra hydra = plugin.getHydra();
		panelComponent.getChildren().clear();

		if (hydra == null)
		{
			return null;
		}

		// First add stunned thing if needed
		if (stunTicks > 0)
		{
			addStunOverlay();
		}


		if (plugin.isCounting())
		{
			// Add spec box second, to keep it above pray
			addSpecOverlay(hydra);

			// Finally add prayer box
			addPrayOverlay(hydra);
		}

		panelComponent.setPreferredSize(new Dimension(40, 0));
		panelComponent.setBorder(new Rectangle(0, 0, 0, 0));

		return panelComponent.render(graphics2D);
	}

	private void addStunOverlay()
	{
		final InfoBoxComponent stunComponent = new InfoBoxComponent();

		stunComponent.setBackgroundColor(badCol);
		stunComponent.setImage(getStunImg());
		stunComponent.setText("        " + stunTicks);
		stunComponent.setPreferredSize(new Dimension(40, 40));

		panelComponent.getChildren().add(stunComponent);
	}

	private void addSpecOverlay(final Hydra hydra)
	{
		final HydraPhase phase = hydra.getPhase();
		final int nextSpec = hydra.getNextSpecialRelative();

		if (nextSpec > 3)
		{
			return;
		}
		final InfoBoxComponent specComponent = new InfoBoxComponent();

		if (nextSpec == 0)
		{
			specComponent.setBackgroundColor(badCol);
		}
		else if (nextSpec == 1)
		{
			specComponent.setBackgroundColor(medCol);
		}

		specComponent.setImage(phase.getSpecImage(spriteManager));
		specComponent.setText("        " + nextSpec); // hacky way to not have to figure out how to move text
		specComponent.setPreferredSize(new Dimension(40, 40));

		panelComponent.getChildren().add(specComponent);
	}

	private void addPrayOverlay(final Hydra hydra)
	{
		final Prayer nextPrayer = hydra.getNextAttack().getPrayer();
		final int nextSwitch = hydra.getNextSwitch();

		InfoBoxComponent prayComponent = new InfoBoxComponent();

		if (nextSwitch == 1)
		{
			prayComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? medCol : badCol);
		}
		else
		{
			prayComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? safeCol : badCol);
		}

		prayComponent.setImage(hydra.getNextAttack().getImage(spriteManager));
		prayComponent.setText("        " + nextSwitch);
		prayComponent.setColor(Color.white);
		prayComponent.setPreferredSize(new Dimension(40, 40));

		panelComponent.getChildren().add(prayComponent);
	}

	boolean onGameTick()
	{
		return --stunTicks <= 0;
	}

	private BufferedImage getStunImg()
	{
		if (stunImg == null)
		{
			stunImg = createStunImage(client);
		}

		return stunImg;
	}

	private static BufferedImage createStunImage(Client client)
	{
		final Sprite root = getSprite(client, SpriteID.BIG_ASS_GREY_ENTANGLE);
		final Sprite mark = getSprite(client, SpriteID.TRADE_EXCLAMATION_MARK_ITEM_REMOVAL_WARNING);

		if (mark == null || root == null)
		{
			return null;
		}

		final Sprite sprite = ImageUtil.mergeSprites(client, ImageUtil.resizeSprite(client, root, IMGSIZE, IMGSIZE), mark);

		return sprite.toBufferedImage();
	}

	private static Sprite getSprite(Client client, int id)
	{
		final IndexDataBase spriteDb = client.getIndexSprites();
		if (spriteDb == null)
		{
			return null;
		}

		final Sprite[] sprites = client.getSprites(spriteDb, id, 0);
		if (sprites == null)
		{
			return null;
		}

		return sprites[0];
	}
}
