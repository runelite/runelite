/*
 * Copyright (c) 2019, Bartvollebregt <https://github.com/Bartvollebregt>
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

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.maxhit.calculators.MagicMaxHitCalculator;
import net.runelite.client.plugins.maxhit.calculators.MeleeMaxHitCalculator;
import net.runelite.client.plugins.maxhit.calculators.RangeMaxHitCalculator;

@PluginDescriptor(
	name = "Max Hit",
	description = "Adds the max hit of the equipped weapon to the equipment and stats widget",
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class MaxHitPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	private void onItemContainerChanged(final ItemContainerChanged event)
	{
		this.updateMaxHitWidget();
	}

	private void onConfigChanged(final ConfigChanged event)
	{
		this.updateMaxHitWidget();
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		this.updateMaxHitWidget();
	}

	private void updateMaxHitWidget()
	{
		Widget equipmentStats = client.getWidget(WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER);

		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		Item[] equipedItems = new Item[14];

		if (equipmentStats != null && !equipmentStats.isHidden())
		{
			if (equipmentContainer != null)
			{
				equipedItems = equipmentContainer.getItems();
			}

			MeleeMaxHitCalculator meleeMaxHitCalculator = new MeleeMaxHitCalculator(this.client, equipedItems);
			RangeMaxHitCalculator rangeMaxHitCalculator = new RangeMaxHitCalculator(this.client, equipedItems);
			MagicMaxHitCalculator magicMaxHitCalculator = new MagicMaxHitCalculator(this.client, equipedItems);

			MaxHit maxHit = new MaxHit(meleeMaxHitCalculator.getMaxHit(), rangeMaxHitCalculator.getMaxHit(), magicMaxHitCalculator.getMaxHit());
			this.setWidgetMaxHit(maxHit);
		}
	}

	private void setWidgetMaxHit(MaxHit maxhit)
	{
		Widget equipYourCharacter = client.getWidget(WidgetInfo.EQUIP_YOUR_CHARACTER);
		String maxHitText = "Melee Max Hit: " + maxhit.getMaxMeleeHit();
		maxHitText += "<br>Range Max Hit: " + maxhit.getMaxRangeHit();
		maxHitText += "<br>Magic Max Hit: " + maxhit.getMaxMagicHit();


		equipYourCharacter.setText(maxHitText);
	}

	private static class MaxHit
	{
		private final double maxMeleeHit;
		private final double maxRangeHit;
		private final double maxMagicHit;

		MaxHit(double maxMeleeHit, double maxRangeHit, double maxMagicHit)
		{
			this.maxMeleeHit = maxMeleeHit;
			this.maxRangeHit = maxRangeHit;
			this.maxMagicHit = maxMagicHit;
		}

		double getMaxMeleeHit()
		{
			return maxMeleeHit;
		}

		double getMaxRangeHit()
		{
			return maxRangeHit;
		}

		double getMaxMagicHit()
		{
			return maxMagicHit;
		}
	}
}