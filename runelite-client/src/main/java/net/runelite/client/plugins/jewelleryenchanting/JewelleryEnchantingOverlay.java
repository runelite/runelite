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

package net.runelite.client.plugins.jewelleryenchanting;

import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.SpritePixels;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

public class JewelleryEnchantingOverlay extends Overlay
{
	private final JewelleryEnchantingPlugin plugin;
	private final JewelleryEnchantingConfig config;
	private final Client client;
	private final QueryRunner queryRunner;
	
	private Map<String, int[]> unenchantedItems = new HashMap<> ();
	
	@Inject
	public JewelleryEnchantingOverlay (JewelleryEnchantingPlugin plugin, JewelleryEnchantingConfig config, Client client, QueryRunner queryRunner)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.queryRunner = queryRunner;
		
		//Set up the unenchanted items dictionary
		unenchantedItems.put("Lvl-1 Enchant", new int[]
		{	//Level One Unenchanted Items
			ItemID.SAPPHIRE_RING,
			ItemID.SAPPHIRE_NECKLACE,
			ItemID.SAPPHIRE_BRACELET,
			ItemID.SAPPHIRE_BRACELET_11072,
			ItemID.SAPPHIRE_AMULET,
			ItemID.OPAL_RING,
			ItemID.OPAL_BRACELET,
			ItemID.OPAL_NECKLACE,
			ItemID.OPAL_AMULET
		});
		unenchantedItems.put("Lvl-2 Enchant", new int[]
		{	//Level Two Unenchanted Items
			ItemID.EMERALD_RING,
			ItemID.EMERALD_NECKLACE,
			ItemID.EMERALD_BRACELET,
			ItemID.EMERALD_AMULET,
			ItemID.JADE_RING,
			ItemID.JADE_NECKLACE,
			ItemID.JADE_BRACELET,
			ItemID.JADE_AMULET
		});
		unenchantedItems.put("Lvl-3 Enchant", new int[]
		{	//Level Three Unenchanted Items
			ItemID.RUBY_RING,
			ItemID.RUBY_BRACELET,
			ItemID.RUBY_AMULET,
			ItemID.RUBY_NECKLACE,
			ItemID.TOPAZ_RING,
			ItemID.TOPAZ_BRACELET,
			ItemID.TOPAZ_NECKLACE,
			ItemID.TOPAZ_AMULET
		});
		unenchantedItems.put("Lvl-4 Enchant", new int[]
		{	//Level Four Unenchanted Items
			ItemID.DIAMOND_RING,
			ItemID.DIAMOND_NECKLACE,
			ItemID.DIAMOND_BRACELET,
			ItemID.DIAMOND_AMULET
		});
		unenchantedItems.put("Lvl-5 Enchant", new int[]
		{	//Level Five Unenchanted Items
			ItemID.DRAGONSTONE_RING,
			ItemID.DRAGON_NECKLACE,
			ItemID.DRAGONSTONE_BRACELET,
			ItemID.DRAGONSTONE_AMULET
		});
		unenchantedItems.put("Lvl-6 Enchant", new int[]
		{	//Level Six Unenchanted Items
			ItemID.ONYX_RING,
			ItemID.ONYX_NECKLACE,
			ItemID.ONYX_BRACELET,
			ItemID.ONYX_AMULET
		});
		unenchantedItems.put("Lvl-7 Enchant", new int[]
		{	//Level Seven Unenchanted Items
			ItemID.ZENYTE_RING,
			ItemID.ZENYTE_NECKLACE,
			ItemID.ZENYTE_BRACELET,
			ItemID.ZENYTE_AMULET
		});
	}
	
	@Override
	public Dimension render (Graphics2D graphics)
	{
		//Make sure we only start this if the player has clicked an enchantment level
		if (plugin.getClickedOption() == null)
			return null;
		
		//Query the players inventory
		Query inventoryQuery = new InventoryWidgetItemQuery();
		WidgetItem[] inventoryItems = queryRunner.runQuery(inventoryQuery);
		//Let's make sure there is items in the players inventory
		//	Must make sure it's also not null for when the player's inventory is empty
		if (inventoryItems != null && inventoryItems.length != 0)
		{
			//Let's loop through every item and display the overlay if it's an item for the current enchantment level
			for (WidgetItem item : inventoryItems)
			{
				//Check to see if this item is one of the item id's in the un-enchanted list
				if (arrayContains(unenchantedItems.get(plugin.getClickedOption()), item.getId()))
				{
					//Create a SpritePixels of the item
					SpritePixels itemSprite = client.createItemSprite(item.getId(), item.getQuantity(), 1, 0, 0, false, Constants.CLIENT_DEFAULT_ZOOM);
					//Now take the itemSprite and turn the outline on with the config color
					itemSprite.setOutline(config.unenchantedColor().getRGB());
					//Draw the itemSprite over the item
					itemSprite.drawAt(item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1);
					//Now remove the outline from the itemSprite or else the outline will keep growing
					itemSprite.removeOutline(config.unenchantedColor().getRGB());
				}
			}
		}
		
		return null;
	}
	
	/** Checks to see if an int array contains a given value */
	private boolean arrayContains (int[] array, int valueToCheck)
	{
		for (int itemId : array)
		{
			if (itemId == valueToCheck)
				return true;
		}
		return false;
	}
}
