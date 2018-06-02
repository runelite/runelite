/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
 * Creation date : 26-5-2018
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
package net.runelite.client.plugins.StatusBars;

import java.awt.*;
import java.awt.image.BufferedImage;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import javax.inject.Inject;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.util.QueryRunner;

@Slf4j
public class StatusBarsOverlay extends Overlay
{
	// Static colors
	final static Color DEPLETED = new Color(25, 25, 25, 150);
	final static Color PRAYER_COLOR = new Color(50, 200, 200, 200);
	final static Color QUICK_PRAYER_COLOR = new Color(57, 255, 186, 225);
	final static Color BACKGROUND = new Color(0, 0 , 0, 150);
	final static Color HEALTH_COLOR = new Color(200, 35, 0, 150);
	final static Color POISONED_COLOR = new Color(0, 145, 0, 150);
	final static Color VENOMED_COLOR = new Color(0, 65, 0, 150);
	final static Color COUNTER_COLOR = new Color(255, 255,  255, 255);
	final static Color NO_COLOR = new Color(0, 0, 0, 0);
	final static Color HEAL_COLOR = new Color (255, 112, 6, 150);
	final static Color PRAYER_HEAL_COLOR = new Color(57, 255, 186, 75);
	final private static int HEIGHT = 252;
	final private static int WIDTH = 20;
	final private static int PADDING = 1;
	final private static int HEALTH_LOCATION_X = 2;
	final private static int PRAYER_LOCATION_X = 3;
	final private static double PRAYER_BOOST = 0.27;
	private Client client;
	private StatusBarsConfig config;
	private SkillIconManager skillIconManager;
	private Color healthBar;
	private Color prayerBar;
	private Color counter;


	@Inject
	public StatusBarsOverlay(Client client, StatusBarsConfig config, SkillIconManager skillIconManager)
	{
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.skillIconManager = skillIconManager;
	}

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private HolyWrench holyWrench;

	@Override
	public Dimension render(Graphics2D g)
	{
		//Variables
		int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);
		int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		int poisonState = client.getVar(VarPlayer.IS_POISONED);
		int counterHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int counterPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		int quickPrayerState = client.getVar(Varbits.QUICK_PRAYER);
		int imageSize = 17;
		double boostedPrayerRestore = 0.25;

		//Store images
		BufferedImage healthImage = skillIconManager.getSkillImage(Skill.HITPOINTS, true);
		BufferedImage prayerImage = skillIconManager.getSkillImage(Skill.PRAYER, true);
		BufferedImage noImage = new BufferedImage(17, 17, BufferedImage.TYPE_INT_ARGB);

		//Code to toggle skill icons
		if (!config.enableSkillIcon())
		{
			healthImage = noImage;
			prayerImage = noImage;
		}

		//Code to toggle counters
		if (config.enableCounter())
		{
			counter = COUNTER_COLOR;
		}
		else
		{
			counter = NO_COLOR;
		}

		// If the player gets inflicted with poison or venom the colors will be replaced to indicate this status.
		if (poisonState > 0 && poisonState < 37)
		{
			healthBar = POISONED_COLOR;
		}
		else if (poisonState > 1000000)
		{
			healthBar = VENOMED_COLOR;
		}
		else
		{
			healthBar = HEALTH_COLOR;
		}

		if (quickPrayerState == 1)
		{
			prayerBar = QUICK_PRAYER_COLOR;
		}
		else
		{
			prayerBar = PRAYER_COLOR;
		}

		if (holyWrench.hasWrench(client))
		{
			boostedPrayerRestore = PRAYER_BOOST;
		}

		PrayerHealValue(currentPrayer, maxPrayer, boostedPrayerRestore);
		FoodHealValue(currentHealth, maxHealth);

		for (Viewport viewport : Viewport.values())
		{
			Widget viewportWidget = client.getWidget(viewport.getViewport());

			if (viewportWidget != null && !viewportWidget.isHidden())
			{
				Widget widget = client.getWidget(viewport.getViewport());
				Point location = viewportWidget.getCanvasLocation();
				Point offsetLeft = viewport.getOffsetLeft();
				Point offsetRight = viewport.getOffsetRight();
				int counterHealthX  = HEALTH_LOCATION_X;
				int counterPrayerX = PRAYER_LOCATION_X;
				int height = HEIGHT;
				int offsetPrayerX = (location.getX() - offsetRight.getX());
				int offsetHealthX = (location.getX() - offsetLeft.getX());
				int offsetHealthY = (location.getY() - offsetLeft.getY());
				int offsetPrayerY = (location.getY() - offsetRight.getY());
				String counterHealthText = Integer.toString(counterHealth);
				String counterPrayerText = Integer.toString(counterPrayer);

				if (viewport == Viewport.RESIZED_BOTTOM && !widget.isHidden())
				{
					offsetPrayerY = (location.getY() - 18 - offsetRight.getY());
					offsetHealthY = (location.getY() - 18 - offsetRight.getY());
					height += 20;
				}
				else if (viewport == Viewport.RESIZED_BOX && widget.isHidden())
				{
					return null;
				}
				else
				{
					offsetPrayerX = (location.getX() + widget.getWidth() - offsetRight.getX());
				}

				// Render the HP and Prayer bar
				renderBar(g, offsetHealthX , offsetHealthY,
					maxHealth, currentHealth, WIDTH + 1, height,
					PADDING, healthBar, healthImage.getScaledInstance(imageSize , imageSize , Image.SCALE_AREA_AVERAGING), counter , counterHealthText, counterHealthX);
				renderBar(g, offsetPrayerX, offsetPrayerY ,
					maxPrayer, currentPrayer, WIDTH, height,
					PADDING, prayerBar, prayerImage.getScaledInstance(imageSize , imageSize , Image.SCALE_AREA_AVERAGING), counter , counterPrayerText , counterPrayerX);

				// Bar for healing health or payer points
				renderHealingBar(g, offsetHealthX , offsetHealthY,
						maxHealth, currentHealth, WIDTH + 1, height,
						PADDING, FoodHealValue(currentHealth, maxHealth), HEAL_COLOR);
				renderHealingBar(g, offsetPrayerX , offsetPrayerY,
						maxPrayer, currentPrayer, WIDTH, height,
						PADDING, PrayerHealValue(currentPrayer, maxPrayer, boostedPrayerRestore), PRAYER_HEAL_COLOR);
			}
		}
		return null;
	}

	private void renderBar(Graphics2D graphics, int x, int y, int max, int current, int width, int height, int padding, Color filled, Image image, Color counter_color, String counter, int counter_x)
	{
		//draw background
		graphics.setColor(BACKGROUND);
		graphics.fillRect(x, y, width, height);

		//draw bar background
		graphics.setColor(DEPLETED);
		graphics.fillRect(x + padding, y + padding, width - padding * 2, height - padding * 2);

		//draw bar with current health or prayer points
		int filledHeight = getBarHeight(max, current, height);
		graphics.setColor(filled);
		graphics.fillRect(x + padding, y + padding + (height - filledHeight), width - padding * 2, filledHeight - padding * 2);

		//draw counter
		graphics.setColor(counter_color);
		graphics.setFont(FontManager.getRunescapeSmallFont());

		if (config.enableCounter() && !config.enableSkillIcon())
		{
			graphics.drawString(counter, x + counter_x  + padding, y + 20);
		}
		else
		{
			graphics.drawString(counter, x + counter_x + padding, y + 35);
		}

		//draw icons
		graphics.drawImage(image, x + 1 + padding, y + 21 - image.getWidth(null), null);
	}

	private void renderHealingBar(Graphics2D graphics, int x, int y, int max, int current, int width, int height, int padding, int heal, Color color)
	{
		int filledHeight = getBarHeight(max, heal, height);
		int filledCurrentHeight = getBarHeight(max, current, height);
		int overHeal = 0;
		graphics.setColor(color);

		if (filledHeight + filledCurrentHeight > height)
		{
			overHeal = filledHeight + filledCurrentHeight - height;
			filledHeight = filledHeight - overHeal + 2;
			graphics.fillRect(x + padding, y - filledCurrentHeight + (height - filledHeight) + 3 , width - padding * 2, filledHeight - padding * 2);
		}
		else
		{
			graphics.fillRect(x + padding, y - filledCurrentHeight + (height - filledHeight) + 3 , width - padding * 2, filledHeight - padding * 2);
		}
	}

	//calculate bar height with set size in mind
	private int getBarHeight(int base, int current, int size)
	{
		double ratio = (double) current / (double) base;

		if (ratio >= 1)
		{
			return size;
		}
		else
		{
			return (int) Math.round((ratio * size));
		}
	}

	// get the amount of health a food heals when hovering with the mouse over the item.
	private int FoodHealValue(int currentHealth, int maxHealth)
	{
		java.awt.Point mousePos = new java.awt.Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
		WidgetItem[] inventory = queryRunner.runQuery(new InventoryWidgetItemQuery());
		int hpHealAmount = 0;

		for (WidgetItem item : inventory)
		{
			if (item.getCanvasBounds().contains(mousePos))
			{
				int foundItemID = item.getId();

				if (currentHealth <= maxHealth)
				{
					for (FoodValues foodId : FoodValues.values())
					{
						int value = foodId.getFoodId();
						if (value == foundItemID)
						{
							if (foodId.getFoodName() == "SARA")
							{
								double calculateHealth = maxHealth * 0.15 + 2;
								long longValue = Math.round(calculateHealth);
								hpHealAmount = (int) longValue;
							}
							else
							{
								hpHealAmount = foodId.getValue();
							}

						}
					}
				}
			}
		}
		return hpHealAmount;
	}

	// Get the amount of prayer Points a potion heals and calculate the value when hovering with the mouse over the item.
	private int PrayerHealValue(int currentPrayer, int maxPrayer, double boostedPrayerRestore)
	{
		java.awt.Point mousePos = new java.awt.Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
		WidgetItem[] inventory = queryRunner.runQuery(new InventoryWidgetItemQuery());
		int prayerHealAmount = 0;

		for (WidgetItem item : inventory)
		{
			if (item.getCanvasBounds().contains(mousePos))
			{
				int foundItemID = item.getId();

				if (currentPrayer <= maxPrayer)
				{
					for (PotionValues potionId : PotionValues.values())
					{
						int value = potionId.getPotionId();
						if (value == foundItemID)
						{
							prayerHealAmount = potionId.getPotionValue();
							double doubleValue = Math.floor(prayerHealAmount + maxPrayer * boostedPrayerRestore);
							long longValue = Math.round(doubleValue);
							prayerHealAmount = (int) longValue;
						}
					}
				}
			}
		}
		return prayerHealAmount;
	}
}