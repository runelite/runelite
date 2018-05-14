/*
 * Copyright (c) 2018 Nicholas I
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

package net.runelite.client.plugins.prayerindicator;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.itemstats.potions.PrayerPotion;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor (
	name = "Prayer Indicator"
)
public class PrayerIndicatorPlugin extends Plugin
{
	
	@Inject
	private PrayerIndicatorOverlay overlay;
	
	@Inject
	private PrayerIndicatorConfig config;
	
	@Inject
	private ItemManager itemManager;
	
	@Inject
	private InfoBoxManager infoBoxManager;
	
	@Inject
	private Client client;
	
	@Getter(AccessLevel.PACKAGE)
	private Counter indicator;
	
	@Getter(AccessLevel.PACKAGE)
	private boolean playerPrayerLow = false;
	
	@Getter(AccessLevel.PACKAGE)
	private int playerPotionID = -1;
	
	@Override
	public Overlay getOverlay ()
	{
		return overlay;
	}
	
	@Provides
	PrayerIndicatorConfig getConfig (ConfigManager configManager)
	{
		return configManager.getConfig(PrayerIndicatorConfig.class);
	}
	
	@Subscribe
	public void onGameStateChanged (GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN && indicator == null)
			indicator = new Counter(itemManager.getImage(ItemID.PRAYER_POTION4), this, "");
	}
	
	@Subscribe
	public void onConfigChanged (ConfigChanged event)
	{
		if (!config.inInfoBox())
			if (infoBoxManager.getInfoBoxes().contains (indicator))
				infoBoxManager.removeInfoBox(indicator);
	}
	
	@Subscribe
	public void onBoostedLevelChanged (BoostedLevelChanged boostedLevelChanged)
	{
		if (boostedLevelChanged.getSkill() == Skill.PRAYER && playerPotionID != -1)
		{
			checkPlayerPrayer();
		}
	}
	
	@Subscribe
	public void onItemContainerChanged (ItemContainerChanged container)
	{
		if (container.getItemContainer().getItems() != null && container.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			//Go ahead and set potionID to -1 so if the player doesn't have a potion in their inventory the program will know this
			int potionID = -1;
			
			int[] prayerIds = {
				ItemID.PRAYER_POTION1,
				ItemID.PRAYER_POTION2,
				ItemID.PRAYER_POTION3,
				ItemID.PRAYER_POTION4,
				ItemID.PRAYER_POTION1_20396,
				ItemID.PRAYER_POTION2_20395,
				ItemID.PRAYER_POTION3_20394,
				ItemID.PRAYER_POTION4_20393
			};
			
			int[] superRestoreIds = {
				ItemID.SUPER_RESTORE1,
				ItemID.SUPER_RESTORE2,
				ItemID.SUPER_RESTORE3,
				ItemID.SUPER_RESTORE4
			};
			
			int[] sanfewIds = {
				ItemID.SANFEW_SERUM1,
				ItemID.SANFEW_SERUM2,
				ItemID.SANFEW_SERUM3,
				ItemID.SANFEW_SERUM4
			};
			
			for (Item item : container.getItemContainer().getItems())
			{
				if (arrayContains(sanfewIds, item.getId()))
				{
					potionID = ItemID.SANFEW_SERUM4;
					//Break out of the loop because this is the best potion the player can have
					break;
				}
				else if (arrayContains(superRestoreIds, item.getId()))
				{
					potionID = ItemID.SUPER_RESTORE4;
				}
				else if (potionID != ItemID.SUPER_RESTORE4 && arrayContains(prayerIds, item.getId()))
				{
					potionID = ItemID.PRAYER_POTION4;
				}
			}
			
			//After we set the potionID let's check if the players prayer is lower then that potion
			if (potionID != -1)
				checkPlayerPrayer();
			//Now set the players potion id
			playerPotionID = potionID;
		}
	}
	
	private boolean arrayContains (int[] array, int value)
	{
		for (int num : array)
		{
			if (num == value)
				return true;
		}
		return false;
	}
	
	private void checkPlayerPrayer ()
	{
		//Now let's get how much prayer will be healed from a regular prayer potion
		int potionHealing = new PrayerPotion(1).heals(client) + 6;
		//Now that we have how much a regular prayer potion heals the player let's add onto it based
		//	on if the player has a super restore or a sanfew serum
		if (playerPotionID == ItemID.SUPER_RESTORE1)
			potionHealing += 1;
		else if (playerPotionID == ItemID.SANFEW_SERUM1)
			potionHealing += 2;
		
		//Now get how many prayer points the player has and their base amount
		int currentPrayerPoints = client.getBoostedSkillLevel(Skill.PRAYER);
		int basePrayerPoints = client.getRealSkillLevel(Skill.PRAYER);
		//Finally let's check to see if the player needs to drink a potion based on the potionHealing/basePrayerPoints/currentPrayerPoints
		if ((basePrayerPoints - potionHealing) >= currentPrayerPoints)
			playerPrayerLow = true;
		else
			playerPrayerLow = false;
	}
}
