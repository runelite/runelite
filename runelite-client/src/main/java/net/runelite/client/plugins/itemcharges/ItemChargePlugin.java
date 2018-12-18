/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.itemcharges;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
public class ItemChargePlugin extends Plugin
{
	private static final Pattern DODGY_CHECK_PATTERN = Pattern.compile(
		"Your dodgy necklace has (\\d+) charges? left\\.");
	private static final Pattern DODGY_PROTECT_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It has (\\d+) charges? left\\.");
	private static final Pattern DODGY_BREAK_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It then crumbles to dust\\.");
	private static final String RING_OF_RECOIL_BREAK_MESSAGE = "<col=7f007f>Your Ring of Recoil has shattered.</col>";

	private static final int MAX_DODGY_CHARGES = 10;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemChargeOverlay overlay;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemChargeConfig config;

	@Getter(AccessLevel.PACKAGE)
	private int dodgyCharges;

	private Map<EquipmentInventorySlot, Integer> currentInfoBoxIDs = new HashMap<>();

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		dodgyCharges = config.dodgyNecklace();

		currentInfoBoxIDs.put(EquipmentInventorySlot.AMULET, -1);
		currentInfoBoxIDs.put(EquipmentInventorySlot.RING, -1);
		currentInfoBoxIDs.put(EquipmentInventorySlot.GLOVES, -1);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("itemCharge"))
		{
			if (event.getKey().equals("showAmuletInfobox") && event.getNewValue().equals("false"))
			{
				removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
			}
			else if (event.getKey().equals("showBraceletInfobox") && event.getNewValue().equals("false"))
			{
				removeJewelleryInfobox(EquipmentInventorySlot.GLOVES);
			}
			else if (event.getKey().equals("showRingInfobox") && event.getNewValue().equals("false"))
			{
				removeJewelleryInfobox(EquipmentInventorySlot.RING);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		Matcher dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message);
		Matcher dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message);
		Matcher dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message);
		if (event.getType() == ChatMessageType.SERVER || event.getType() == ChatMessageType.FILTERED)
		{
			if (config.recoilNotification() && message.contains(RING_OF_RECOIL_BREAK_MESSAGE))
			{
				notifier.notify("Your Ring of Recoil has shattered");
			}
			else if (dodgyBreakMatcher.find())
			{
				if (config.dodgyNotification())
				{
					notifier.notify("Your dodgy necklace has crumbled to dust.");
				}

				setDodgyCharges(MAX_DODGY_CHARGES);
			}
			else if (dodgyCheckMatcher.find())
			{
				setDodgyCharges(Integer.parseInt(dodgyCheckMatcher.group(1)));
			}
			else if (dodgyProtectMatcher.find())
			{
				setDodgyCharges(Integer.parseInt(dodgyProtectMatcher.group(1)));
			}
		}
	}

	private void setDodgyCharges(int dodgyCharges)
	{
		this.dodgyCharges = dodgyCharges;
		config.dodgyNecklace(dodgyCharges);
		if (currentInfoBoxIDs.get(EquipmentInventorySlot.AMULET) == ItemID.DODGY_NECKLACE)
		{
			if (dodgyCharges > 0)
			{
				createJewelleryInfobox(ItemID.DODGY_NECKLACE, dodgyCharges, EquipmentInventorySlot.AMULET);
			}
			else
			{
				removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer().getItems().length > 14)
		{
			return;
		}

		Item[] items = event.getItemContainer().getItems();

		int amulet = -2;
		int bracelet = -2;
		int ring = -2;
		if (items.length >= 3)
		{
			if (config.showAmuletInfobox())
			{
				amulet = items[EquipmentInventorySlot.AMULET.getSlotIdx()].getId();
			}
			if (items.length >= 10)
			{
				if (config.showBraceletInfobox())
				{
					bracelet = items[EquipmentInventorySlot.GLOVES.getSlotIdx()].getId();
				}
				if (items.length >= 13)
				{
					if (config.showRingInfobox())
					{
						ring = items[EquipmentInventorySlot.RING.getSlotIdx()].getId();
					}
				}
			}
		}
		else
		{
			return;
		}

		if (amulet > 0)
		{
			if (amulet == ItemID.DODGY_NECKLACE)
			{
				if (dodgyCharges > 0)
				{
					createJewelleryInfobox(amulet, dodgyCharges, EquipmentInventorySlot.AMULET);
				}
				else
				{
					removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
				}
			}
			else
			{
				ItemWithCharge amuletCharges = ItemWithCharge.findItem(amulet);
				if (amuletCharges != null)
				{
				createJewelleryInfobox(amulet, amuletCharges.getCharges(), EquipmentInventorySlot.AMULET);
			}
			else
			{
					removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
				}
			}
		}
		else
		{
			removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
		}

		if (bracelet > 0)
		{
			ItemWithCharge braceletCharges = ItemWithCharge.findItem(bracelet);
			if (braceletCharges != null)
			{
				createJewelleryInfobox(bracelet, braceletCharges.getCharges(), EquipmentInventorySlot.GLOVES);
			}
			else
			{
				removeJewelleryInfobox(EquipmentInventorySlot.GLOVES);
			}
		}
		else
		{
			removeJewelleryInfobox(EquipmentInventorySlot.GLOVES);
		}

		if (ring > 0)
		{
			ItemWithCharge ringCharges = ItemWithCharge.findItem(ring);
			if (ringCharges != null)
			{
				createJewelleryInfobox(ring, ringCharges.getCharges(), EquipmentInventorySlot.RING);
			}
			else
			{
				removeJewelleryInfobox(EquipmentInventorySlot.RING);
			}
		}
		else
		{
			removeJewelleryInfobox(EquipmentInventorySlot.RING);
		}
	}

	private void createJewelleryInfobox(int id, int charges, EquipmentInventorySlot slotID)
	{
		removeJewelleryInfobox(slotID);
		ItemChargeInfobox i = new ItemChargeInfobox(itemManager.getItemComposition(id).getName(), itemManager.getImage(id), this, charges, slotID);
		infoBoxManager.addInfoBox(i);
		currentInfoBoxIDs.put(slotID, id);
	}

	private void removeJewelleryInfobox(EquipmentInventorySlot slotID)
	{
		infoBoxManager.removeIf(t -> t instanceof ItemChargeInfobox && ((ItemChargeInfobox) t).getSlotID() == slotID);
		currentInfoBoxIDs.remove(slotID);
	}
}