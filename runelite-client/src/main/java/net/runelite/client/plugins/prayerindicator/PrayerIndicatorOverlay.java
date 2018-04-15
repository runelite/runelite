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

import com.google.inject.Inject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.Skill;
import net.runelite.api.queries.InventoryItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.itemstats.potions.PrayerPotion;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QueryRunner;

public class PrayerIndicatorOverlay extends Overlay
{
	
	//Set up some constants that will be used later on
	private final float THICKNESS = 2f;			// This will set how thick the circle should be
	
	private Color orbIndicatorColor = new Color (0, 255, 255, 255);
	private int alphaOffset = -10;			// How much to subtract/add to the alpha of the indicator orb
	private int playerPotionID;				// The current ItemID of the potion the player is carrying
	private BufferedImage prayPotIcon;
	private Counter indicator;				// The indicator that will go in the info box if the player chooses to have it shown
	
	//private PrayerIndicatorPlugin plugin;
	private final Client client;
	private final PrayerIndicatorConfig config;
	private final InfoBoxManager infoBoxManager;
	private final QueryRunner queryRunner;
	
	@Inject
	private ItemManager itemManager;
	
	@Inject
	private PrayerIndicatorPlugin plugin;
	
	@Inject
	public PrayerIndicatorOverlay (QueryRunner queryRunner, Client client, PrayerIndicatorConfig config, InfoBoxManager infoBoxManager)
	{
		setPosition (OverlayPosition.DYNAMIC);
		setLayer (OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.infoBoxManager = infoBoxManager;
		this.queryRunner = queryRunner;
	}
	
	// This method will be called every game tick and will be used to fade the orb indicator in and out
	public void onTick ()
	{
		//Every game tick let's get what kind of prayer potion the player has
		playerPotionID = getPlayerPotion ();
		
		//Let's make sure the infoBox indicator is set
		if (indicator == null)
		{
			prayPotIcon = itemManager.getImage (ItemID.PRAYER_POTION4);
			indicator = new Counter (prayPotIcon, plugin, "");
		}
	}
	
	// This method will go every time the config was changed and is only used for if the player deactivates the info box display so it can be properly be removed
	public void onConfigChanged ()
	{
		if (!config.inInfoBox () && infoBoxManager.getInfoBoxes ().contains (indicator))
			infoBoxManager.removeInfoBox (indicator);
	}
	
	@Override
	public Dimension render (Graphics2D graphics)
	{
		//Before adding it to the infoBox let's make the sure the player want's it to be there
		if (config.inInfoBox ())
		{
			if (isPlayerPrayerLow ())
			{
				if (!infoBoxManager.getInfoBoxes ().contains (indicator))
					infoBoxManager.addInfoBox (indicator);
			} else
			{
				if (infoBoxManager.getInfoBoxes ().contains (indicator))
					infoBoxManager.removeInfoBox (indicator);
			}
		}
		
		//First let's make sure that the orb indicator actually needs be drawn
		if (isPlayerPrayerLow ())
		{
			//Before drawing the orb let's make sure the player want's it to be drawn
			if (config.displayOverOrb ())
			{
				//Let's get the quick xp orb widget
				Widget quickPrayOrb = client.getWidget (WidgetInfo.QUICK_PRAYER_ORB);
				//Make sure the prayer orb isn't deactivated
				if (quickPrayOrb == null)
				{
					return null;
				}
				
				//Get the bounds of the quick prayer orb
				Rectangle2D orbBounds = quickPrayOrb.getBounds ().getBounds2D ();
				if (orbBounds.getX () <= 0)
				{
					return null;
				}
				
				//We need to offset the bounds due to it including the prayer number
				//	This is easily achieved by just using the height for the width
				//	Then it also needs to be changed so that it fills the entire prayer orb
				double orbOffsetSize = orbBounds.getHeight ();
				//Do the same but for the x coord
				//	However this time it's achieved by just adding onto the existing
				//	x coord with the difference of the original width and offset width.
				//	Then we have to also make sure the coord is changed based on the added size of the circle.
				double orbOffsetX = (orbBounds.getX () + (orbBounds.getWidth () - orbOffsetSize));
				//Do the same for the y coord
				double orbOffsetY = orbBounds.getY () - 2d;
				
				//Every game tick add or subtract to the transparency of the orb indicator
				//First we need to check if the orb's alpha value is >= 1 or <= 0.5f
				if (orbIndicatorColor.getAlpha () >= 255)
				{
					//Since the orb's alpha is at the top most value the alphaOffset needs to be set to a negative to subtract from it
					alphaOffset = -5;
				} else if (orbIndicatorColor.getAlpha () <= 100)
				{
					//Since the orb's alpha is at the bottom most value the alphaOffset needs to be set to a positive to add to it
					alphaOffset = 5;
				}
				
				//Now actually change the alpha
				orbIndicatorColor = new Color (
						orbIndicatorColor.getRed (),
						orbIndicatorColor.getGreen (),
						orbIndicatorColor.getBlue (),
						orbIndicatorColor.getAlpha () + alphaOffset);
				
				graphics.setColor (orbIndicatorColor);
				graphics.setStroke (new BasicStroke (THICKNESS));
				//Let's create a 2d ellipse object so we can set the x/y value as a double rather then an int for a more precise position
				Ellipse2D.Double shape = new Ellipse2D.Double (orbOffsetX, orbOffsetY, orbOffsetSize, orbOffsetSize);
				graphics.draw (shape);
				
				return new Dimension ((int) orbBounds.getWidth (), (int) orbBounds.getHeight ());
			}
		}
		
		return null;
	}
	
	// Returns if the players prayer is lower then how much their current prayer potion heals for
	private boolean isPlayerPrayerLow ()
	{
		//First let's check if the player even has a potion in their inventory
		if (playerPotionID != -1)
		{
			//Now let's get how much prayer will be healed from a regular prayer potion
			int potionHealing = new PrayerPotion (1).heals (client) + 6;
			//Now that we have how much a regular prayer potion heals the player let's add onto it based
			//	on if the player has a super restore or a sanfew serum
			if (playerPotionID == ItemID.SUPER_RESTORE1)
				potionHealing += 1;
			else if (playerPotionID == ItemID.SANFEW_SERUM1)
				potionHealing += 2;
			
			//Now get how many prayer points the player has and their base amount
			int currentPrayerPoints = client.getBoostedSkillLevel (Skill.PRAYER);
			int basePrayerPoints = client.getRealSkillLevel (Skill.PRAYER);
			//Finally let's check to see if the player needs to drink a potion based on the potionHealing/basePrayerPoints/currentPrayerPoints
			if ((basePrayerPoints - potionHealing) >= currentPrayerPoints)
				return true;
		}
		return false;
	}
	
	// Returns if the the player has either a prayer potion, a super restore potion, or a sanfew serum
	//		Will return the sanfew serum over the super restore potion
	// 		Will return the super restore potion over the prayer potion
	//		Returns null if the player has neither
	private int getPlayerPotion ()
	{
		//Check to see if the player has any sanfew serums in their inventory
		Query query = new InventoryItemQuery (InventoryID.INVENTORY).idEquals (ItemID.SANFEW_SERUM1,
				ItemID.SANFEW_SERUM2,
				ItemID.SANFEW_SERUM3,
				ItemID.SANFEW_SERUM4);
		//Now fetch the query items
		Item[] items = queryRunner.runQuery (query);
		if (items.length != 0)
			//The user has a sanfew serum potion so return that ID
			return ItemID.SANFEW_SERUM1;
		
		//Now do the same for super restore potions
		query = new InventoryItemQuery (InventoryID.INVENTORY).idEquals (ItemID.SUPER_RESTORE1,
				ItemID.SUPER_RESTORE2,
				ItemID.SUPER_RESTORE3,
				ItemID.SUPER_RESTORE4);
		items = queryRunner.runQuery (query);
		if (items.length != 0)
			return ItemID.SUPER_RESTORE1;
		
		//Now do the same thing for prayer potions
		query = new InventoryItemQuery (InventoryID.INVENTORY).idEquals (ItemID.PRAYER_POTION1,
				ItemID.PRAYER_POTION2,
				ItemID.PRAYER_POTION3,
				ItemID.PRAYER_POTION4,
				ItemID.PRAYER_POTION1_20396,
				ItemID.PRAYER_POTION2_20395,
				ItemID.PRAYER_POTION3_20394,
				ItemID.PRAYER_POTION4_20393);
		items = queryRunner.runQuery (query);
		if (items.length != 0)
			return ItemID.PRAYER_POTION1;
		
		//Return 0 since the player doesn't have any prayer potions
		return -1;
	}
}
