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
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

public class JewelleryEnchantingOverlay extends Overlay
{
	
	
	//Set up all the items that belongs to the different enchantment levels
	private Map<String, int[]> unEnchantedItems = new HashMap<String, int[]> ();
	private Map<String, int[]> enchantedItems = new HashMap<String, int[]> ();
	private Map<String, Boolean> enchantmentConfigPrefs = new HashMap<String, Boolean> ();
	
	private Color unEnchantedColor;
	private Color enchantedColor;
	private String clickedOption;
	
	private final JewelleryEnchantingPlugin plugin;
	private final JewelleryEnchantingConfig config;
	private final Client client;
	private final QueryRunner queryRunner;
	private final ItemManager itemManager;
	
	@Inject
	public JewelleryEnchantingOverlay (JewelleryEnchantingPlugin plugin, JewelleryEnchantingConfig config, Client client, QueryRunner queryRunner, ItemManager itemManager)
	{
		setPosition (OverlayPosition.DYNAMIC);
		setLayer (OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config= config;
		this.client = client;
		this.queryRunner = queryRunner;
		this.itemManager = itemManager;
		
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
		//Set up the enchanted items
		enchantedItems.put ("Lvl-1 Enchant", new int[]
		{		//Level One Enchanted Items
				ItemID.RING_OF_RECOIL,
				ItemID.GAMES_NECKLACE8,
				ItemID.BRACELET_OF_CLAY,
				ItemID.AMULET_OF_MAGIC,
				ItemID.RING_OF_PURSUIT,
				ItemID.EXPEDITIOUS_BRACELET,
				ItemID.DODGY_NECKLACE,
				ItemID.AMULET_OF_BOUNTY
		});
		enchantedItems.put ("Lvl-2 Enchant", new int[]
		{		//Level Two Enchanted Items
				ItemID.RING_OF_DUELING8,
				ItemID.BINDING_NECKLACE,
				ItemID.CASTLE_WARS_BRACELET3,
				ItemID.AMULET_OF_DEFENCE,
				ItemID.AMULET_OF_NATURE,
				ItemID.RING_OF_RETURNING5,
				ItemID.NECKLACE_OF_PASSAGE5,
				ItemID.FLAMTAER_BRACELET,
				ItemID.AMULET_OF_CHEMISTRY
		});
		enchantedItems.put ("Lvl-3 Enchant", new int[]
		{		//Level Three Enchanted Items
				ItemID.RING_OF_FORGING,
				ItemID.INOCULATION_BRACELET,
				ItemID.AMULET_OF_STRENGTH,
				ItemID.DIGSITE_PENDANT_5,
				ItemID.EFARITAYS_AID,
				ItemID.BRACELET_OF_SLAUGHTER,
				ItemID.NECKLACE_OF_FAITH,
				ItemID.BURNING_AMULET5
		});
		enchantedItems.put ("Lvl-4 Enchant", new int[]
		{		//Level Four Enchanted Items
				ItemID.RING_OF_LIFE,
				ItemID.PHOENIX_NECKLACE,
				ItemID.DIAMOND_BRACELET,
				ItemID.DIAMOND_AMULET
		});
		enchantedItems.put ("Lvl-5 Enchant", new int[]
		{		//Level Five Enchanted Items
				ItemID.RING_OF_WEALTH,
				ItemID.SKILLS_NECKLACE,
				ItemID.COMBAT_BRACELET,
				ItemID.AMULET_OF_GLORY
		});
		enchantedItems.put ("Lvl-6 Enchant", new int[]
		{		//Level Six Enchanted Items
				ItemID.RING_OF_STONE,
				ItemID.BERSERKER_NECKLACE,
				ItemID.REGEN_BRACELET,
				ItemID.AMULET_OF_FURY
		});
		enchantedItems.put ("Lvl-8 Enchant", new int[]
		{		//Level Seven Enchanted Items
				ItemID.RING_OF_SUFFERING,
				ItemID.NECKLACE_OF_ANGUISH,
				ItemID.TORMENTED_BRACELET,
				ItemID.AMULET_OF_TORTURE
		});
		//Set up the enchantment config preferences array
		enchantmentConfigPrefs.put ("Lvl-1 Enchant", config.showLvlOneEnchants ());
		enchantmentConfigPrefs.put ("Lvl-2 Enchant", config.showLvlTwoEnchants ());
		enchantmentConfigPrefs.put ("Lvl-3 Enchant", config.showLvlThreeEnchants ());
		enchantmentConfigPrefs.put ("Lvl-4 Enchant", config.showLvlFourEnchants ());
		enchantmentConfigPrefs.put ("Lvl-5 Enchant", config.showLvlFiveEnchants ());
		enchantmentConfigPrefs.put ("Lvl-6 Enchant", config.showLvlSixEnchants ());
		enchantmentConfigPrefs.put ("Lvl-7 Enchant", config.showLvlSevenEnchants ());
		//Set the colors
		unEnchantedColor = new Color (config.unEnchantedColor ().getRed (), config.unEnchantedColor ().getGreen (), config.unEnchantedColor ().getBlue (), 128);
		enchantedColor = new Color (config.enchantedColor ().getRed (), config.enchantedColor ().getGreen (), config.enchantedColor ().getBlue (), 128);
	}
	
	//When showing border look into the outline jagex uses when "using" items
	// method5855 is what's being used (Adam might not like this)
	@Override
	public Dimension render (Graphics2D graphics)
	{
		//Make sure we only start this if the player has clicked an enchantment level
		if (clickedOption != null)
		{
			//Now make sure the player want's this enchantment level to be overlayed
			if (enchantmentConfigPrefs.get (clickedOption))
			{
				//Now query the players inventory
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
							BufferedImage itemImage = overlayColor (itemManager.getImage (item.getId ()), unEnchantedColor);
							graphics.drawImage (itemImage, item.getCanvasLocation ().getX () + 1, item.getCanvasLocation ().getY () + 1, null);
						}
						//Do the same for the enchanted list
						if (arrayContains (enchantedItems.get (clickedOption), item.getId ()))
						{
							BufferedImage itemImage = overlayColor (itemManager.getImage (item.getId ()), enchantedColor);
							graphics.drawImage (itemImage, item.getCanvasLocation ().getX () + 1, item.getCanvasLocation ().getY () + 1, null);
						}
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
	
	private static BufferedImage overlayColor(BufferedImage img, Color keyColor) {
		for (int y = 0; y < img.getHeight(); y++)
		{
			for (int x = 0; x < img.getWidth(); x++)
			{
				//Get the current pixel at x/y
				int col = img.getRGB (x, y);
				//Check to see if the current pixel is not transparent
				if ((col>>24) != 0x00)
				{
					//Change the current pixel to the given color
					img.setRGB(x, y, keyColor.getRGB ());
				}
			}
		}
		return img;
	}
	
	public void updateConfig ()
	{
		//Clear the dictionary for the config prefs
		enchantmentConfigPrefs.clear ();
		//Set up the enchantment config preferences array
		enchantmentConfigPrefs.put ("Lvl-1 Enchant", config.showLvlOneEnchants ());
		enchantmentConfigPrefs.put ("Lvl-2 Enchant", config.showLvlTwoEnchants ());
		enchantmentConfigPrefs.put ("Lvl-3 Enchant", config.showLvlThreeEnchants ());
		enchantmentConfigPrefs.put ("Lvl-4 Enchant", config.showLvlFourEnchants ());
		enchantmentConfigPrefs.put ("Lvl-5 Enchant", config.showLvlFiveEnchants ());
		enchantmentConfigPrefs.put ("Lvl-6 Enchant", config.showLvlSixEnchants ());
		enchantmentConfigPrefs.put ("Lvl-7 Enchant", config.showLvlSevenEnchants ());
		//Set the colors
		unEnchantedColor = new Color (config.unEnchantedColor ().getRed (), config.unEnchantedColor ().getGreen (), config.unEnchantedColor ().getBlue (), 128);
		enchantedColor = new Color (config.enchantedColor ().getRed (), config.enchantedColor ().getGreen (), config.enchantedColor ().getBlue (), 128);
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
