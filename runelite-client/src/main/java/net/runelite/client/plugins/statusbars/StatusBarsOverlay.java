/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Affliction;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChangesService;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.statusorbs.StatusOrbsPlugin;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.ImageUtil;

class StatusBarsOverlay extends Overlay
{
	private static final BufferedImage HEART_DISEASE;
	private static final BufferedImage HEART_POISON;
	private static final BufferedImage HEART_VENOM;
	private static final BufferedImage HEART_POISON_DISEASE;
	private static final BufferedImage HEART_VENOM_DISEASE;
	static
	{
		HEART_DISEASE = ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-DISEASE.png");
		HEART_POISON = ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-POISON.png");
		HEART_VENOM = ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-VENOM.png");
		HEART_POISON_DISEASE = ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-POISON-DISEASE.png");
		HEART_VENOM_DISEASE = ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-VENOM-DISEASE.png");
	}
	private static final Color PRAYER_COLOR = new Color(50, 200, 200, 175);
	private static final Color QUICK_PRAYER_COLOR = new Color(57, 255, 186, 225);
	private static final Color BACKGROUND = new Color(0, 0, 0, 150);
	private static final Color HEALTH_COLOR = new Color(225, 35, 0, 125);
	private static final Color POISONED_COLOR = new Color(0, 145, 0, 150);
	private static final Color VENOMED_COLOR = new Color(0, 65, 0, 150);
	private static final Color DISEASED_COLOR = new Color(166, 132, 62, 255);
	private static final Color HEAL_COLOR = new Color(255, 112, 6, 150);
	private static final Color PRAYER_HEAL_COLOR = new Color(57, 255, 186, 75);
	private static final Color OVERHEAL_COLOR = new Color(216, 255, 139, 150);
	private static final int HEIGHT = 252;
	private static final int RESIZED_BOTTOM_HEIGHT = 272;
	private static final int WIDTH = 20;
	private static final int PADDING = 1;
	private static final int IMAGE_SIZE = 17;
	private static final int HEALTH_LOCATION_X = 0;
	private static final int PRAYER_LOCATION_X = 1;
	private static final int RESIZED_BOTTOM_OFFSET_Y = 12;
	private static final int RESIZED_BOTTOM_OFFSET_X = 10;
	private static final int OVERHEAL_OFFSET = 2;
	private static final int HEAL_OFFSET = 3;
	private static final int ICON_AND_COUNTER_OFFSET_X = 1;
	private static final int ICON_AND_COUNTER_OFFSET_Y = 21;
	private static final int SKILL_ICON_HEIGHT = 35;
	private static final int COUNTER_ICON_HEIGHT = 18;
	private static final int OFFSET = 2;
	private final Client client;
	private final StatusBarsConfig config;
	private final SkillIconManager skillIconManager;
	private final TextComponent textComponent = new TextComponent();
	private final ItemStatChangesService itemStatService;
	private final SpriteManager spriteManager;

	@Inject
	private StatusBarsOverlay(Client client, StatusBarsConfig config, SkillIconManager skillIconManager, ItemStatChangesService itemstatservice, SpriteManager spriteManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.skillIconManager = skillIconManager;
		this.itemStatService = itemstatservice;
		this.spriteManager = spriteManager;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		final Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		if (widgetBankTitleBar != null && !widgetBankTitleBar.isHidden())
		{
			return null;
		}

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

		if (curViewport == null || curWidget.isHidden())
		{
			return null;
		}

		final Point offsetLeft = curViewport.getOffsetLeft();
		final Point offsetRight = curViewport.getOffsetRight();
		final Point location = curWidget.getCanvasLocation();
		final int height, offsetHealthX, offsetHealthY, offsetPrayerX, offsetPrayerY;

		if (curViewport == Viewport.RESIZED_BOTTOM)
		{
			height = RESIZED_BOTTOM_HEIGHT;
			offsetHealthX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetLeft.getX());
			offsetHealthY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
			offsetPrayerX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetRight.getX());
			offsetPrayerY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
		}
		else
		{
			height = HEIGHT;
			offsetHealthX = (location.getX() - offsetLeft.getX());
			offsetHealthY = (location.getY() - offsetLeft.getY());
			offsetPrayerX = (location.getX() - offsetRight.getX()) + curWidget.getWidth();
			offsetPrayerY = (location.getY() - offsetRight.getY());
		}


		Affliction state = client.getCurrentAffliction();
		final Color healthBar;

		BufferedImage sprite = null;
		switch (state)
		{
			case POISON_DISEASED:
				healthBar = POISONED_COLOR;
				sprite = HEART_POISON_DISEASE;
				break;
			case POISONED:
				healthBar = POISONED_COLOR;
				sprite = HEART_POISON;
				break;
			case VENOM_DISEASED:
				healthBar = VENOMED_COLOR;
				sprite = HEART_VENOM_DISEASE;
				break;
			case VENOMED:
				healthBar = VENOMED_COLOR;
				sprite = HEART_VENOM;
				break;
			case DISEASED:
				healthBar = DISEASED_COLOR;
				sprite = HEART_DISEASE;
				break;
			case NONE:
			default:
				healthBar = HEALTH_COLOR;
		}

		final int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int quickPrayerState = client.getVar(Varbits.QUICK_PRAYER);
		final Color prayerBar = quickPrayerState == 1 ? QUICK_PRAYER_COLOR : PRAYER_COLOR;

		renderBar(g, offsetHealthX, offsetHealthY,
			maxHealth, currentHealth, height, healthBar);

		renderBar(g, offsetPrayerX, offsetPrayerY,
			maxPrayer, currentPrayer, height, prayerBar);

		if (config.enableRestorationBars())
		{
			final MenuEntry[] menu = client.getMenuEntries();
			final int menuSize = menu.length;
			final MenuEntry entry = menu[menuSize - 1];
			final Effect change = itemStatService.getItemStatChanges(entry.getIdentifier());
			int prayerHealValue = 0;
			int foodHealValue = 0;

			if (change != null &
				entry.getParam1() == WidgetInfo.INVENTORY.getId() &&
				entry.getIdentifier() != ItemID.SPICY_STEW)
			{
				final StatsChanges statsChanges = change.calculate(client);

				for (final StatChange c : statsChanges.getStatChanges())
				{
					if (c.getStat().getName().equals(Skill.HITPOINTS.getName()))
					{
						foodHealValue = Integer.parseInt(c.getTheoretical());
					}

					if (c.getStat().getName().equals(Skill.PRAYER.getName()))
					{
						prayerHealValue = Integer.parseInt(c.getTheoretical());
					}

					if (foodHealValue != 0 && prayerHealValue != 0)
					{
						break;
					}
				}
			}

			renderHealingBar(g, offsetHealthX, offsetHealthY,
				maxHealth, currentHealth, height,
				foodHealValue, HEAL_COLOR);

			renderHealingBar(g, offsetPrayerX, offsetPrayerY,
				maxPrayer, currentPrayer, height,
				prayerHealValue, PRAYER_HEAL_COLOR);
		}

		if (config.enableSkillIcon() || config.enableCounter())
		{
			final Image healthImage = sprite != null ? sprite : spriteManager.getSprite(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, 0);
			final Image prayerImage = ImageUtil.resizeImage(skillIconManager.getSkillImage(Skill.PRAYER, true), IMAGE_SIZE, IMAGE_SIZE);
			final int counterHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
			final int counterPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
			final String counterHealthText = Integer.toString(counterHealth);
			final String counterPrayerText = Integer.toString(counterPrayer);

			renderIconsAndCounters(g, offsetPrayerX, offsetPrayerY, prayerImage, counterPrayerText, PRAYER_LOCATION_X);
			renderIconsAndCounters(g, offsetHealthX, offsetHealthY, healthImage, counterHealthText, HEALTH_LOCATION_X);
		}

		return null;
	}

	private static void renderBar(Graphics2D graphics, int x, int y, int max, int current, int height, Color filled)
	{
		graphics.setColor(BACKGROUND);
		graphics.drawRect(x, y, WIDTH - PADDING, height - PADDING);
		graphics.fillRect(x, y, WIDTH, height);

		final int filledHeight = getBarHeight(max, current, height);
		graphics.setColor(filled);
		graphics.fillRect(x + PADDING,
			y + PADDING + (height - filledHeight),
			WIDTH - PADDING * OFFSET,
			filledHeight - PADDING * OFFSET);
	}

	private static void renderHealingBar(Graphics2D graphics, int x, int y, int max, int current, int height, int heal, Color color)
	{
		if (heal <= 0)
		{
			return;
		}

		final int filledCurrentHeight = getBarHeight(max, current, height);
		int filledHeight = getBarHeight(max, heal, height);
		graphics.setColor(color);

		if (filledHeight + filledCurrentHeight > height)
		{
			final int overHeal = filledHeight + filledCurrentHeight - height;
			filledHeight = filledHeight - overHeal + OVERHEAL_OFFSET;
			graphics.setColor(OVERHEAL_COLOR);
			graphics.fillRect(x + PADDING,
				y - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				WIDTH - PADDING * OVERHEAL_OFFSET,
				filledHeight - PADDING * OVERHEAL_OFFSET);
		}
		else
		{
			graphics.fillRect(x + PADDING,
				y - OVERHEAL_OFFSET - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				WIDTH - PADDING * OVERHEAL_OFFSET,
				filledHeight + OVERHEAL_OFFSET - PADDING * OVERHEAL_OFFSET);
		}
	}

	private static int getBarHeight(int base, int current, int size)
	{
		final double ratio = (double) current / base;

		if (ratio >= 1)
		{
			return size;
		}

		return (int) Math.round(ratio * size);
	}

	private void renderIconsAndCounters(Graphics2D graphics, int x, int y, Image image, String counterText, int counterPadding)
	{
		final int widthOfCounter = graphics.getFontMetrics().stringWidth(counterText);
		final int centerText = (WIDTH - PADDING) / 2 - (widthOfCounter / 2);

		if (config.enableCounter())
		{
			graphics.setFont(FontManager.getRunescapeSmallFont());
			textComponent.setColor(Color.WHITE);
			textComponent.setText(counterText);
			textComponent.setPosition(new java.awt.Point(x + centerText + counterPadding, y + COUNTER_ICON_HEIGHT));
		}
		else
		{
			textComponent.setText("");
		}

		if (config.enableSkillIcon())
		{
			graphics.drawImage(image, x + ICON_AND_COUNTER_OFFSET_X + PADDING, y + ICON_AND_COUNTER_OFFSET_Y - image.getWidth(null), null);
			textComponent.setPosition(new java.awt.Point(x + centerText + counterPadding, y + SKILL_ICON_HEIGHT));
		}

		textComponent.render(graphics);
	}
}
