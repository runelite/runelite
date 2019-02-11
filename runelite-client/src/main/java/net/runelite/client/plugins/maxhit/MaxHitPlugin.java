/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.maxhit;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.maxhit.calculators.MeleeMaxHitCalculator;

import javax.inject.Inject;
import java.text.DecimalFormat;

//import net.runelite.client.plugins.maxhit.calculators.MagicMaxHitCalculator;
//import net.runelite.client.plugins.maxhit.calculators.RangeMaxHitCalculator;

@PluginDescriptor(
		name = "maxhitplugin",
		description = "Max Hit Calculator",
		enabledByDefault = false
)
public class MaxHitPlugin extends Plugin
{
	private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");

	private boolean equipmentStatsIsOpen = false;

	@Inject
	private Client client;

	@Inject
	private MaxHitConfig config;

	@Provides
	MaxHitConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MaxHitConfig.class);
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		updateMaxHitWidget();
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		updateMaxHitWidget();
	}

	private void updateMaxHitWidget() {
		Widget equipmentStats = client.getWidget(WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER);
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);

		if (equipmentContainer != null && equipmentStats != null && !equipmentStats.isHidden()) {
			Item[] equipedItems = equipmentContainer.getItems();

			MeleeMaxHitCalculator meleeMaxHitCalculator = new MeleeMaxHitCalculator(this.client, equipedItems, this.config.prayer());
//			RangeMaxHitCalculator rangeMaxHitCalculator = new RangeMaxHitCalculator(this.client, equipedItems, this.config.prayer());
//			MagicMaxHitCalculator magicMaxHitCalculator = new MagicMaxHitCalculator(this.client, equipedItems, this.config.prayer());

			MaxHit maxHit = new MaxHit(meleeMaxHitCalculator.calculate(), 0, 0);
			this.setWidgetMaxHit(maxHit);
		}
	}

	private void setWidgetMaxHit(MaxHit maxhit) {
		Widget equipYourCharacter = client.getWidget(WidgetInfo.EQUIP_YOUR_CHARACTER);
		String maxHitText = "Melee Max Hit: " + maxhit.getMaxMeleeHit();
		maxHitText += "<br>Range Max Hit: " + maxhit.getMaxRangeHit();
		maxHitText += "<br>Magic Max Hit: " + maxhit.getMaxMagicHit();


		equipYourCharacter.setText(maxHitText);
	}

	private class MaxHit {
		private double maxMeleeHit;
		private double maxRangeHit;
		private double maxMagicHit;

		public MaxHit(double maxMeleeHit, double maxRangeHit, double maxMagicHit) {
			this.maxMeleeHit = maxMeleeHit;
			this.maxRangeHit = maxRangeHit;
			this.maxMagicHit = maxMagicHit;
		}

		public double getMaxMeleeHit() {
			return maxMeleeHit;
		}

		public double getMaxRangeHit() {
			return maxRangeHit;
		}

		public double getMaxMagicHit() {
			return maxMagicHit;
		}
	}

}
