/*
 * Copyright (c) 2020 dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.alchemicalhydra.overlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.IndexDataBase;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.api.SpritePixels;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraConfig;
import net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin;
import net.runelite.client.plugins.alchemicalhydra.entity.Hydra;
import net.runelite.client.plugins.alchemicalhydra.entity.HydraPhase;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import static net.runelite.client.ui.overlay.components.ComponentConstants.STANDARD_BACKGROUND_COLOR;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.ImageUtil;

@Singleton
public class AttackOverlay extends Overlay
{
	public static final int IMAGE_SIZE = 36;

	private static final String INFO_BOX_TEXT_PADDING = "        ";
	private static final Dimension INFO_BOX_DIMENSION = new Dimension(40, 40);

	private static final PanelComponent panelComponent = new PanelComponent();

	private static final InfoBoxComponent stunComponent = new InfoBoxComponent();
	private static final InfoBoxComponent phaseSpecialComponent = new InfoBoxComponent();
	private static final InfoBoxComponent prayerComponent = new InfoBoxComponent();

	private static final int STUN_TICK_DURATION = 7;

	static
	{
		panelComponent.setOrientation(ComponentOrientation.VERTICAL);
		panelComponent.setBorder(new Rectangle(0, 0, 0, 0));
		panelComponent.setPreferredSize(new Dimension(40, 0));

		stunComponent.setPreferredSize(INFO_BOX_DIMENSION);
		phaseSpecialComponent.setPreferredSize(INFO_BOX_DIMENSION);
		prayerComponent.setPreferredSize(INFO_BOX_DIMENSION);
	}

	private final Client client;

	private final AlchemicalHydraPlugin plugin;
	private final AlchemicalHydraConfig config;

	private final SpriteManager spriteManager;

	private int stunTicks;

	private Hydra hydra;

	@Inject
	AttackOverlay(final Client client, final AlchemicalHydraPlugin plugin, final AlchemicalHydraConfig config, final SpriteManager spriteManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.spriteManager = spriteManager;

		stunComponent.setBackgroundColor(config.dangerColor());
		stunComponent.setImage(createStunImage());

		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		hydra = plugin.getHydra();

		if (hydra == null)
		{
			return null;
		}

		clearPanelComponent();

		updateStunComponent();

		updatePhaseSpecialComponent();

		if (config.hidePrayerOnSpecial() && isSpecialAttack())
		{
			return panelComponent.render(graphics2D);
		}

		updatePrayerComponent();

		renderPrayerWidget(graphics2D);

		return panelComponent.render(graphics2D);
	}

	public void decrementStunTicks()
	{
		if (stunTicks > 0)
		{
			--stunTicks;
		}
	}

	public void setStunTicks()
	{
		stunTicks = STUN_TICK_DURATION;
	}

	private void clearPanelComponent()
	{
		final List<LayoutableRenderableEntity> children = panelComponent.getChildren();

		if (!children.isEmpty())
		{
			children.clear();
		}
	}

	private void updateStunComponent()
	{
		if (stunTicks <= 0)
		{
			return;
		}

		stunComponent.setText(INFO_BOX_TEXT_PADDING + stunTicks);

		panelComponent.getChildren().add(stunComponent);
	}

	private void updatePhaseSpecialComponent()
	{
		final int nextSpec = hydra.getNextSpecialRelative();

		if (nextSpec > 3 || nextSpec < 0)
		{
			return;
		}

		if (nextSpec == 0)
		{
			phaseSpecialComponent.setBackgroundColor(config.dangerColor());
		}
		else if (nextSpec == 1)
		{
			phaseSpecialComponent.setBackgroundColor(config.warningColor());
		}
		else
		{
			phaseSpecialComponent.setBackgroundColor(STANDARD_BACKGROUND_COLOR);
		}

		phaseSpecialComponent.setImage(hydra.getPhase().getSpecialImage(spriteManager));
		phaseSpecialComponent.setText(INFO_BOX_TEXT_PADDING + nextSpec);

		panelComponent.getChildren().add(phaseSpecialComponent);
	}

	private void updatePrayerComponent()
	{
		final Prayer nextPrayer = hydra.getNextAttack().getPrayer();
		final int nextSwitch = hydra.getNextSwitch();

		if (nextSwitch == 1)
		{
			prayerComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? config.warningColor() : config.dangerColor());
		}
		else
		{
			prayerComponent.setBackgroundColor(client.isPrayerActive(nextPrayer) ? config.safeColor() : config.dangerColor());
		}

		prayerComponent.setImage(hydra.getNextAttack().getImage(spriteManager));
		prayerComponent.setText(INFO_BOX_TEXT_PADDING + nextSwitch);

		panelComponent.getChildren().add(prayerComponent);
	}

	private void renderPrayerWidget(final Graphics2D graphics2D)
	{
		final Prayer prayer = hydra.getNextAttack().getPrayer();

		OverlayUtil.renderPrayerOverlay(graphics2D, client, prayer, prayer == Prayer.PROTECT_FROM_MAGIC ? Color.CYAN : Color.GREEN);
	}

	private boolean isSpecialAttack()
	{
		final HydraPhase phase = hydra.getPhase();

		switch (phase)
		{
			case FLAME:
				final NPC npc = hydra.getNpc();
				return hydra.getNextSpecialRelative() == 0 || (npc != null && npc.getInteracting() == null);
			case POISON:
			case LIGHTNING:
			case ENRAGED:
				return hydra.getNextSpecialRelative() == 0;
		}

		return false;
	}

	private BufferedImage createStunImage()
	{
		final SpritePixels root = getSprite(SpriteID.BIG_ASS_GREY_ENTANGLE);
		final SpritePixels mark = getSprite(SpriteID.TRADE_EXCLAMATION_MARK_ITEM_REMOVAL_WARNING);

		if (mark == null || root == null)
		{
			return null;
		}

		final SpritePixels sprite = ImageUtil.mergeSprites(client, ImageUtil.resizeSprite(client, root, IMAGE_SIZE, IMAGE_SIZE), mark);

		return sprite.toBufferedImage();
	}

	private SpritePixels getSprite(final int spriteId)
	{
		final IndexDataBase spriteDatabase = client.getIndexSprites();

		if (spriteDatabase == null)
		{
			return null;
		}

		final SpritePixels[] sprites = client.getSprites(spriteDatabase, spriteId, 0);

		if (sprites == null)
		{
			return null;
		}

		return sprites[0];
	}
}
