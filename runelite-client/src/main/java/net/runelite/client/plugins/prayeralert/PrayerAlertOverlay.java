// prayeralert - Plugin for the OSRS RuneLite client to alert the player when their prayer is low.
// Copyright (C) 2019  lachlan-smith, mikkikur

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

package net.runelite.client.plugins.prayeralert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.itemstats.stats.Stat;
import net.runelite.client.plugins.itemstats.stats.Stats;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Singleton
class PrayerAlertOverlay extends Overlay
{
	private final Client client;
	private final PrayerAlertPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();
	private final ItemManager itemManager;

	private final Stat prayer = Stats.PRAYER;

	@Inject
	private PrayerAlertOverlay(final Client client, final PrayerAlertPlugin plugin, final ItemManager itemManager)
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		int prayerLevel = getPrayerLevel();
		int prayerPoints = getPrayerPoints();
		if (plugin.isOldRenderMode())
		{
			if (plugin.isAlwaysShowAlert())
			{
				boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
				if (drink)
				{
					oldPrayerRestorePanel(graphics);
				}
			}
			else
			{
				boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
				boolean hasPrayerPotion = checkInventoryForPotion();
				if (drink && hasPrayerPotion)
				{
					oldPrayerRestorePanel(graphics);
				}
			}
		}
		else
		{
			if (plugin.isAlwaysShowAlert())
			{
				boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
				if (drink)
				{
					prayerRestorePanel(panelComponent, graphics);
				}
			}
			else
			{
				boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
				boolean hasPrayerPotion = checkInventoryForPotion();
				if (drink && hasPrayerPotion)
				{
					prayerRestorePanel(panelComponent, graphics);
				}
			}
		}
		return panelComponent.render(graphics);
	}

	private int getPrayerLevel()
	{
		return prayer.getMaximum(client);
	}

	private int getPrayerPoints()
	{
		return prayer.getValue(client);
	}

	private boolean drinkPrayerPotion(int prayerLevel, int prayerPoints)
	{
		boolean drink = false;
		int prayerPotionRestoreValue = 7;
		double quarterOfPrayerLevel = (0.25) * (double) prayerLevel;

		prayerPotionRestoreValue = prayerPotionRestoreValue + (int) quarterOfPrayerLevel;

		if (prayerPoints < (prayerLevel - prayerPotionRestoreValue))
		{
			drink = true;
		}

		return drink;
	}

	private boolean checkInventoryForPotion()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		Item[] inventoryItems;
		boolean hasPrayerPotion = false;

		int[] potionID = {ItemID.PRAYER_POTION1, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION1_20396, ItemID.PRAYER_POTION2_20395,
			ItemID.PRAYER_POTION3_20394, ItemID.PRAYER_POTION4_20393, ItemID.PRAYER_MIX1, ItemID.PRAYER_MIX2, ItemID.SUPER_RESTORE1, ItemID.SUPER_RESTORE2,
			ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE_MIX1, ItemID.SUPER_RESTORE_MIX2};

		if (inventory != null)
		{
			inventoryItems = inventory.getItems();
			for (Item item : inventoryItems)
			{
				for (int prayerPotionId : potionID)
				{
					if (item.getId() == prayerPotionId)
					{
						hasPrayerPotion = true;
						break;
					}
				}
			}
		}

		return hasPrayerPotion;
	}

	private void prayerRestorePanel(PanelComponent panelComponent, Graphics2D graphics)
	{
		ImageComponent component = new ImageComponent(itemManager.getImage(ItemID.PRAYER_POTION4));
		component.translate(2, 0);
		panelComponent.getChildren().add(component);
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Drink")
			.color(Color.RED)
			.build());
		panelComponent.setPreferredSize(new Dimension(
			graphics.getFontMetrics().stringWidth("Drink") + 14, 0));
	}

	private void oldPrayerRestorePanel(Graphics2D graphics)
	{
		graphics.translate(-100, 15);
		graphics.setColor(new Color(0.2f, 0.2f, 0.2f, 0.5f));
		graphics.fillRect(0, 0, 100, 45);

		graphics.drawImage(itemManager.getImage(ItemID.PRAYER_POTION4), null, 14, 7);

		Font dropShadow1 = FontManager.getRunescapeFont();
		dropShadow1 = dropShadow1.deriveFont(Font.PLAIN);
		graphics.setFont(dropShadow1);
		graphics.setColor(new Color(0f, 0f, 0f, 0.6f));
		graphics.drawString("Drink", 56, 20);

		Font drinkFont1 = FontManager.getRunescapeFont();
		drinkFont1 = drinkFont1.deriveFont(Font.PLAIN);
		graphics.setFont(drinkFont1);
		graphics.setColor(new Color(1.0f, 0.03529412f, 0.0f));
		graphics.translate(-0.8, -0.8);
		graphics.drawString("Drink", 56, 20);

		Font dropShadow2 = FontManager.getRunescapeFont();
		dropShadow2 = dropShadow2.deriveFont(Font.PLAIN);
		graphics.setFont(dropShadow2);
		graphics.setColor(new Color(0f, 0f, 0f, 0.6f));
		graphics.drawString("Potion", 53, 40);

		Font drinkFont2 = FontManager.getRunescapeFont();
		drinkFont2 = drinkFont2.deriveFont(Font.PLAIN);
		graphics.setFont(drinkFont2);
		graphics.setColor(new Color(1.0f, 0.03529412f, 0.0f));
		graphics.translate(-0.8, -0.8);
		graphics.drawString("Potion", 53, 40);
	}
}
