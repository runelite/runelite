/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
 * Copyright (c) 2019, Rheon <https://github.com/Rheon-D>
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
package net.runelite.client.plugins.statusbars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.VarPlayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.AlternateSprites;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChangesService;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.statusbars.config.BarMode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ImageUtil;

class StatusBarsOverlay extends Overlay
{
	private static final Color PRAYER_COLOR = new Color(50, 200, 200, 175);
	private static final Color ACTIVE_PRAYER_COLOR = new Color(57, 255, 186, 225);
	private static final Color HEALTH_COLOR = new Color(225, 35, 0, 125);
	private static final Color POISONED_COLOR = new Color(0, 145, 0, 150);
	private static final Color VENOMED_COLOR = new Color(0, 65, 0, 150);
	private static final Color HEAL_COLOR = new Color(255, 112, 6, 150);
	private static final Color PRAYER_HEAL_COLOR = new Color(57, 255, 186, 75);
	private static final Color ENERGY_HEAL_COLOR = new Color (199,  118, 0, 218);
	private static final Color RUN_STAMINA_COLOR = new Color(160, 124, 72, 255);
	private static final Color SPECIAL_ATTACK_COLOR = new Color(3, 153, 0, 195);
	private static final Color ENERGY_COLOR = new Color(199, 174, 0, 220);
	private static final Color DISEASE_COLOR = new Color(255, 193, 75, 181);
	private static final Color PARASITE_COLOR = new Color(196, 62, 109, 181);
	private static final int HEIGHT = 252;
	private static final int RESIZED_BOTTOM_HEIGHT = 272;
	private static final int IMAGE_SIZE = 17;
	private static final int ICON_DIMENSIONS = 26;
	private static final int RESIZED_BOTTOM_OFFSET_Y = 12;
	private static final int RESIZED_BOTTOM_OFFSET_X = 10;
	private static final int MAX_SPECIAL_ATTACK_VALUE = 100;
	private static final int MAX_RUN_ENERGY_VALUE = 100;

	private final Client client;
	private final StatusBarsConfig config;
	private final ItemStatChangesService itemStatService;
	private final SpriteManager spriteManager;

	private final Image prayerIcon;
	private Image heartIcon;
	private Image heartDisease;
	private Image heartPoison;
	private Image heartVenom;
	private Image specialIcon;
	private Image energyIcon;
	private final Map<BarMode, BarRenderer> barRenderers = new EnumMap<>(BarMode.class);

	@Inject
	private StatusBarsOverlay(Client client, StatusBarsConfig config, SkillIconManager skillIconManager, ItemStatChangesService itemstatservice, SpriteManager spriteManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.itemStatService = itemstatservice;
		this.spriteManager = spriteManager;

		prayerIcon = ImageUtil.resizeCanvas(ImageUtil.resizeImage(skillIconManager.getSkillImage(Skill.PRAYER, true), IMAGE_SIZE, IMAGE_SIZE), ICON_DIMENSIONS, ICON_DIMENSIONS);
		initRenderers();
	}

	private void initRenderers()
	{
		barRenderers.put(BarMode.DISABLED, null);
		barRenderers.put(BarMode.HITPOINTS, new BarRenderer(
			() -> client.getRealSkillLevel(Skill.HITPOINTS),
			() -> client.getBoostedSkillLevel(Skill.HITPOINTS),
			() -> getRestoreValue(Skill.HITPOINTS.getName()),
			() ->
			{
				final int poisonState = client.getVar(VarPlayer.IS_POISONED);

				if (poisonState >= 1000000)
				{
					return VENOMED_COLOR;
				}

				if (poisonState > 0)
				{
					return POISONED_COLOR;
				}

				if (client.getVar(VarPlayer.DISEASE_VALUE) > 0)
				{
					return DISEASE_COLOR;
				}

				if (client.getVar(Varbits.PARASITE) >= 1)
				{
					return PARASITE_COLOR;
				}

				return HEALTH_COLOR;
			},
			() -> HEAL_COLOR,
			() ->
			{
				final int poisonState = client.getVar(VarPlayer.IS_POISONED);

				if (poisonState > 0 && poisonState < 50)
				{
					return heartPoison;
				}

				if (poisonState >= 1000000)
				{
					return heartVenom;
				}

				if (client.getVar(VarPlayer.DISEASE_VALUE) > 0)
				{
					return heartDisease;
				}

				return heartIcon;
			}
		));
		barRenderers.put(BarMode.PRAYER, new BarRenderer(
			() -> client.getRealSkillLevel(Skill.PRAYER),
			() -> client.getBoostedSkillLevel(Skill.PRAYER),
			() -> getRestoreValue(Skill.PRAYER.getName()),
			() ->
			{
				Color prayerColor = PRAYER_COLOR;

				for (Prayer pray : Prayer.values())
				{
					if (client.isPrayerActive(pray))
					{
						prayerColor = ACTIVE_PRAYER_COLOR;
						break;
					}
				}

				return prayerColor;
			},
			() -> PRAYER_HEAL_COLOR,
			() -> prayerIcon
		));
		barRenderers.put(BarMode.RUN_ENERGY, new BarRenderer(
			() -> MAX_RUN_ENERGY_VALUE,
			client::getEnergy,
			() -> getRestoreValue("Run Energy"),
			() ->
			{
				if (client.getVar(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
				{
					return RUN_STAMINA_COLOR;
				}
				else
				{
					return ENERGY_COLOR;
				}
			},
			() -> ENERGY_HEAL_COLOR,
			() -> energyIcon
		));
		barRenderers.put(BarMode.SPECIAL_ATTACK, new BarRenderer(
			() -> MAX_SPECIAL_ATTACK_VALUE,
			() -> client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) / 10,
			() -> 0,
			() -> SPECIAL_ATTACK_COLOR,
			() -> SPECIAL_ATTACK_COLOR,
			() -> specialIcon
		));
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		Viewport curViewport = null;
		Widget curWidget = null;

		for (Viewport viewport : Viewport.values())
		{
			final Widget viewportWidget = client.getWidget(viewport.getViewport());
			if (viewportWidget != null && !viewportWidget.isHidden())
			{
				curViewport = viewport;
				curWidget = viewportWidget;
				break;
			}
		}

		if (curViewport == null)
		{
			return null;
		}

		final Point offsetLeft = curViewport.getOffsetLeft();
		final Point offsetRight = curViewport.getOffsetRight();
		final Point location = curWidget.getCanvasLocation();
		final int height, offsetLeftBarX, offsetLeftBarY, offsetRightBarX, offsetRightBarY;

		if (curViewport == Viewport.RESIZED_BOTTOM)
		{
			height = RESIZED_BOTTOM_HEIGHT;
			offsetLeftBarX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetLeft.getX());
			offsetLeftBarY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
			offsetRightBarX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetRight.getX());
			offsetRightBarY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
		}
		else
		{
			height = HEIGHT;
			offsetLeftBarX = (location.getX() - offsetLeft.getX());
			offsetLeftBarY = (location.getY() - offsetLeft.getY());
			offsetRightBarX = (location.getX() - offsetRight.getX()) + curWidget.getWidth();
			offsetRightBarY = (location.getY() - offsetRight.getY());
		}

		buildIcons();

		BarRenderer left = barRenderers.get(config.leftBarMode());
		BarRenderer right = barRenderers.get(config.rightBarMode());

		if (left != null)
		{
			left.renderBar(config, g, offsetLeftBarX, offsetLeftBarY, height);
		}

		if (right != null)
		{
			right.renderBar(config, g, offsetRightBarX, offsetRightBarY, height);
		}

		return null;
	}

	private int getRestoreValue(String skill)
	{
		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;
		final MenuEntry entry = menuSize > 0 ? menu[menuSize - 1] : null;
		int restoreValue = 0;

		if (entry != null && entry.getParam1() == WidgetInfo.INVENTORY.getId())
		{
			final Effect change = itemStatService.getItemStatChanges(entry.getIdentifier());

			if (change != null)
			{
				for (final StatChange c : change.calculate(client).getStatChanges())
				{
					final int value = c.getTheoretical();

					if (value != 0 && c.getStat().getName().equals(skill))
					{
						restoreValue = value;
					}
				}
			}
		}

		return restoreValue;
	}

	private void buildIcons()
	{
		if (heartIcon != null && heartDisease != null && heartPoison != null && heartVenom != null && energyIcon != null && specialIcon != null)
		{
			return;
		}

		heartIcon = ImageUtil.resizeCanvas(Objects.requireNonNull(spriteManager.getSprite(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, 0)), ICON_DIMENSIONS, ICON_DIMENSIONS);
		heartDisease = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.DISEASE_HEART), ICON_DIMENSIONS, ICON_DIMENSIONS);
		heartPoison = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.POISON_HEART), ICON_DIMENSIONS, ICON_DIMENSIONS);
		heartVenom = ImageUtil.resizeCanvas(ImageUtil.loadImageResource(AlternateSprites.class, AlternateSprites.VENOM_HEART), ICON_DIMENSIONS, ICON_DIMENSIONS);
		energyIcon = ImageUtil.resizeCanvas(Objects.requireNonNull(spriteManager.getSprite(SpriteID.MINIMAP_ORB_WALK_ICON, 0)), ICON_DIMENSIONS, ICON_DIMENSIONS);
		specialIcon = ImageUtil.resizeCanvas(Objects.requireNonNull(spriteManager.getSprite(SpriteID.MINIMAP_ORB_SPECIAL_ICON, 0)), ICON_DIMENSIONS, ICON_DIMENSIONS);
	}
}
