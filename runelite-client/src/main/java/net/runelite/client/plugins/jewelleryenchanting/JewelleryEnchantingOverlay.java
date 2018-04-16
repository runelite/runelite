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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

public class JewelleryEnchantingOverlay extends Overlay
{
	
	
	//Set up all the items that belongs to the different enchantment levels
	private Map<String, int[]> unEnchantedItems = new HashMap<String, int[]> ();
	
	private Color unEnchantedColor;
	private String clickedOption;
	
	private final JewelleryEnchantingConfig config;
	private final Client client;
	private final QueryRunner queryRunner;
	
	@Inject
	public JewelleryEnchantingOverlay (JewelleryEnchantingConfig config, Client client, QueryRunner queryRunner)
	{
		setPosition (OverlayPosition.DYNAMIC);
		setLayer (OverlayLayer.ABOVE_WIDGETS);
		this.config = config;
		this.client = client;
		this.queryRunner = queryRunner;
		
		//Set up the unechanted items
		unEnchantedItems.put ("Lvl-1 Enchant", new int[]
		{		//Level One UnEnchanted Items
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
		unEnchantedItems.put ("Lvl-2 Enchant", new int[]
		{		//Level Two UnEnchanted Items
				ItemID.EMERALD_RING,
				ItemID.EMERALD_NECKLACE,
				ItemID.EMERALD_BRACELET,
				ItemID.EMERALD_AMULET,
				ItemID.JADE_RING,
				ItemID.JADE_NECKLACE,
				ItemID.JADE_BRACELET,
				ItemID.JADE_AMULET
		});
		unEnchantedItems.put ("Lvl-3 Enchant", new int[]
		{		//Level Three UnEnchanted Items
				ItemID.RUBY_RING,
				ItemID.RUBY_BRACELET,
				ItemID.RUBY_AMULET,
				ItemID.RUBY_NECKLACE,
				ItemID.TOPAZ_RING,
				ItemID.TOPAZ_BRACELET,
				ItemID.TOPAZ_NECKLACE,
				ItemID.TOPAZ_AMULET
		});
		unEnchantedItems.put ("Lvl-4 Enchant", new int[]
		{		//Level Four UnEnchanted Items
				ItemID.DIAMOND_RING,
				ItemID.DIAMOND_NECKLACE,
				ItemID.DIAMOND_BRACELET,
				ItemID.DIAMOND_AMULET
		});
		unEnchantedItems.put ("Lvl-5 Enchant", new int[]
		{		//Level Five UnEnchanted Items
				ItemID.DRAGONSTONE_RING,
				ItemID.DRAGON_NECKLACE,
				ItemID.DRAGONSTONE_BRACELET,
				ItemID.DRAGONSTONE_AMULET
		});
		unEnchantedItems.put ("Lvl-6 Enchant", new int[]
		{		//Level Six UnEnchanted Items
				ItemID.ONYX_RING,
				ItemID.ONYX_NECKLACE,
				ItemID.ONYX_BRACELET,
				ItemID.ONYX_AMULET
		});
		unEnchantedItems.put ("Lvl-7 Enchant", new int[]
		{		//Level Seven UnEnchanted Items
				ItemID.ZENYTE_RING,
				ItemID.ZENYTE_NECKLACE,
				ItemID.ZENYTE_BRACELET,
				ItemID.ZENYTE_AMULET
		});
		
		//Set the colors
		unEnchantedColor = config.unEnchantedColor ();//new Color (config.unEnchantedColor ().getRed (), config.unEnchantedColor ().getGreen (), config.unEnchantedColor ().getBlue (), 128);
	}
	
	//When showing border look into the outline jagex uses when "using" items
	// method5855 is what's being used (Adam might not like this)
	@Override
	public Dimension render (Graphics2D graphics)
	{
		//Make sure we only start this if the player has clicked an enchantment level
		if (clickedOption != null)
		{
			//Query the players inventory
			Query inventoryQuery = new InventoryWidgetItemQuery ();
			WidgetItem[] inventoryItems = queryRunner.runQuery (inventoryQuery);
			//Let's make sure there is items in the players inventory
			if (inventoryItems != null && inventoryItems.length != 0)
			{
				//Let's loop through every item and display the overlay if it's an item for the current enchantment level
				for (WidgetItem item : inventoryItems)
				{
					//Check to see if this item is one of the item id's in the un-enchanted list
					if (arrayContains (unEnchantedItems.get (clickedOption), item.getId ()))
					{
						//Get the item with no shadow to better draw the shadow
						BufferedImage itemImage = client.createItemSprite (item.getId (), item.getQuantity (), 1, new Color(0,0,0).getRGB () & 0x00,
								0, false, Constants.CLIENT_DEFAULT_ZOOM).toBufferedImage ();
						//Get the outline image of the item
						itemImage = getOutline (itemImage, unEnchantedColor);
						//Draw the outlined image
						graphics.drawImage (itemImage, item.getCanvasLocation ().getX () + 1, item.getCanvasLocation ().getY () + 1, null);
					}
				}
			}
		}
		
		return null;
	}
	
	//Checks to see if an int array contains a given value
	private boolean arrayContains (int[] array, int valueToCheck)
	{
		for (int itemId : array)
		{
			if (itemId == valueToCheck)
				return true;
		}
		return false;
	}
	
	//This method takes a buffered image then draws an outline around it in a new buffered image with the passed color
	private BufferedImage getOutline (BufferedImage img, Color keyColor)
	{
		BufferedImage outline = new BufferedImage (img.getWidth (), img.getHeight (), img.getType ());
		
		for (int y = 0; y < img.getHeight(); y++)
		{
			for (int x = 0; x < img.getWidth(); x++)
			{
				//Get the current pixel at x/y
				int col = img.getRGB (x, y);
				//Let's check if any of the surrounding pixels are transparent and if so that means it's an outline
				if (col != 0 && (img.getRGB (x, y + 1) == 0 || img.getRGB (x, y - 1) == 0 || img.getRGB (x + 1, y) == 0 || img.getRGB (x - 1, y) == 0))
				{
					//Change the current pixel to the given color
					outline.setRGB(x, y, keyColor.getRGB ());
				}
			}
		}
		return outline;
	}
	
	public void updateConfig ()
	{
		//Set the colors
		unEnchantedColor = config.unEnchantedColor ();//new Color (config.unEnchantedColor ().getRed (), config.unEnchantedColor ().getGreen (), config.unEnchantedColor ().getBlue (), 128);
	}
	
	//Find out what the player is clicking on and make sure it's a jewelry enchantment
	public void onMenuOptionClicked (MenuOptionClicked event)
	{
		if (event.getMenuTarget ().contains ("Enchant"))
			clickedOption = event.getMenuTarget ().split (">")[1];
		else
			clickedOption = null;
	}
	
}
