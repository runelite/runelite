/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
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

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
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
	private static final Pattern BINDING_CHECK_PATTERN = Pattern.compile(
		"You have ([0-9]+|one) charges? left before your Binding necklace disintegrates\\.");
	private static final Pattern BINDING_USED_PATTERN = Pattern.compile(
		"You bind the temple's power into (mud|lava|steam|dust|smoke|mist) runes\\.");
	private static final String BINDING_BREAK_TEXT = "Your Binding necklace has disintegrated.";
	private static final Pattern RING_OF_FORGING_CHECK_PATTERN = Pattern.compile(
		"You can smelt ([0-9+]+|one) more pieces? of iron ore before a ring melts\\.");
	private static final String RING_OF_FORGING_USED_TEXT = "You retrieve a bar of iron.";
	private static final String RING_OF_FORGING_BREAK_TEXT = "<col=7f007f>Your Ring of Forging has melted.</col>";

	private static final int MAX_DODGY_CHARGES = 10;
	private static final int MAX_BINDING_CHARGES = 16;
	private static final int MAX_EXPLORER_RING_CHARGES = 30;
	private static final int MAX_RING_OF_FORGING_CHARGES = 140;

	private int lastExplorerRingCharge = -1;

	@Inject
	private Client client;

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

	// Limits destroy callback to once per tick
	private int lastCheckTick;

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		infoBoxManager.removeIf(ItemChargeInfobox.class::isInstance);
		lastCheckTick = -1;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("itemCharge"))
		{
			return;
		}

		if (!config.showInfoboxes())
		{
			infoBoxManager.removeIf(ItemChargeInfobox.class::isInstance);
			return;
		}

		if (!config.showTeleportCharges())
		{
			removeInfobox(ItemWithSlot.TELEPORT);
		}

		if (!config.showAbyssalBraceletCharges())
		{
			removeInfobox(ItemWithSlot.ABYSSAL_BRACELET);
		}

		if (!config.showDodgyCount())
		{
			removeInfobox(ItemWithSlot.DODGY_NECKLACE);
		}

		if (!config.showBindingNecklaceCharges())
		{
			removeInfobox(ItemWithSlot.BINDING_NECKLACE);
		}

		if (!config.showExplorerRingCharges())
		{
			removeInfobox(ItemWithSlot.EXPLORER_RING);
		}

		if (!config.showRingOfForgingCount())
		{
			removeInfobox(ItemWithSlot.RING_OF_FORGING);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		Matcher dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message);
		Matcher dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message);
		Matcher dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message);
		Matcher bindingNecklaceCheckMatcher = BINDING_CHECK_PATTERN.matcher(event.getMessage());
		Matcher bindingNecklaceUsedMatcher = BINDING_USED_PATTERN.matcher(event.getMessage());
		Matcher ringOfForgingCheckMatcher = RING_OF_FORGING_CHECK_PATTERN.matcher(message);

		if (event.getType() == ChatMessageType.GAMEMESSAGE || event.getType() == ChatMessageType.SPAM)
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

				updateDodgyNecklaceCharges(MAX_DODGY_CHARGES);
			}
			else if (dodgyCheckMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyCheckMatcher.group(1)));
			}
			else if (dodgyProtectMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyProtectMatcher.group(1)));
			}
			else if (message.contains(BINDING_BREAK_TEXT))
			{
				if (config.bindingNotification())
				{
					notifier.notify(BINDING_BREAK_TEXT);
				}

				// This chat message triggers before the used message so add 1 to the max charges to ensure proper sync
				updateBindingNecklaceCharges(MAX_BINDING_CHARGES + 1);
			}
			else if (bindingNecklaceUsedMatcher.find())
			{
				updateBindingNecklaceCharges(config.bindingNecklace() - 1);
			}
			else if (bindingNecklaceCheckMatcher.find())
			{
				final String match = bindingNecklaceCheckMatcher.group(1);

				int charges = 1;
				if (!match.equals("one"))
				{
					charges = Integer.parseInt(match);
				}

				updateBindingNecklaceCharges(charges);
			}
			else if (ringOfForgingCheckMatcher.find())
			{
				final String match = ringOfForgingCheckMatcher.group(1);

				int charges = 1;
				if (!match.equals("one"))
				{
					charges = Integer.parseInt(match);
				}
				updateRingOfForgingCharges(charges);
			}
			else if (message.equals(RING_OF_FORGING_USED_TEXT))
			{
				final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

				// Determine if the player smelted with a Ring of Forging equipped.
				if (equipment == null)
				{
					return;
				}

				Item[] items = equipment.getItems();
				if (EquipmentInventorySlot.RING.getSlotIdx() < items.length
					&& items[EquipmentInventorySlot.RING.getSlotIdx()].getId() == ItemID.RING_OF_FORGING)
				{
					int charges = Ints.constrainToRange(config.ringOfForging() - 1, 0, MAX_RING_OF_FORGING_CHARGES);
					updateRingOfForgingCharges(charges);
				}
			}
			else if (message.equals(RING_OF_FORGING_BREAK_TEXT))
			{
				if (config.ringOfForgingNotification())
				{
					notifier.notify("Your ring of forging has melted.");
				}

				updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES);
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.EQUIPMENT) || !config.showInfoboxes())
		{
			return;
		}

		final Item[] items = event.getItemContainer().getItems();

		if (config.showTeleportCharges())
		{
			updateJewelleryInfobox(ItemWithSlot.TELEPORT, items);
		}

		if (config.showDodgyCount())
		{
			updateJewelleryInfobox(ItemWithSlot.DODGY_NECKLACE, items);
		}

		if (config.showAbyssalBraceletCharges())
		{
			updateJewelleryInfobox(ItemWithSlot.ABYSSAL_BRACELET, items);
		}

		if (config.showBindingNecklaceCharges())
		{
			updateJewelleryInfobox(ItemWithSlot.BINDING_NECKLACE, items);
		}

		if (config.showExplorerRingCharges())
		{
			updateJewelleryInfobox(ItemWithSlot.EXPLORER_RING, items);
		}

		if (config.showRingOfForgingCount())
		{
			updateJewelleryInfobox(ItemWithSlot.RING_OF_FORGING, items);
		}
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"destroyOnOpKey".equals(event.getEventName()))
		{
			return;
		}

		final int yesOption = client.getIntStack()[client.getIntStackSize() - 1];
		if (yesOption == 1)
		{
			checkDestroyWidget();
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged event)
	{
		int explorerRingCharge = client.getVar(Varbits.EXPLORER_RING_ALCHS);
		if (lastExplorerRingCharge != explorerRingCharge)
		{
			updateExplorerRingCharges(explorerRingCharge);
		}
	}

	private void updateDodgyNecklaceCharges(final int value)
	{
		config.dodgyNecklace(value);

		if (config.showInfoboxes() && config.showDodgyCount())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.DODGY_NECKLACE, itemContainer.getItems());
		}
	}

	private void updateBindingNecklaceCharges(final int value)
	{
		config.bindingNecklace(value);

		if (config.showInfoboxes() && config.showBindingNecklaceCharges())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.BINDING_NECKLACE, itemContainer.getItems());
		}
	}

	private void updateExplorerRingCharges(final int value)
	{
		// Note: Varbit counts upwards. We count down from the maximum charges.
		config.explorerRing(MAX_EXPLORER_RING_CHARGES - value);

		if (config.showInfoboxes() && config.showExplorerRingCharges())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.EXPLORER_RING, itemContainer.getItems());
		}
	}

	private void updateRingOfForgingCharges(final int value)
	{
		config.ringOfForging(value);

		if (config.showInfoboxes() && config.showRingOfForgingCount())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.RING_OF_FORGING, itemContainer.getItems());
		}
	}

	private void checkDestroyWidget()
	{
		final int currentTick = client.getTickCount();
		if (lastCheckTick == currentTick)
		{
			return;
		}
		lastCheckTick = currentTick;

		final Widget widgetDestroyItemName = client.getWidget(WidgetInfo.DESTROY_ITEM_NAME);
		if (widgetDestroyItemName == null)
		{
			return;
		}

		switch (widgetDestroyItemName.getText())
		{
			case "Binding necklace":
				updateBindingNecklaceCharges(MAX_BINDING_CHARGES);
				break;
			case "Dodgy necklace":
				updateDodgyNecklaceCharges(MAX_DODGY_CHARGES);
				break;
			case "Ring of forging":
				updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES);
				break;
		}
	}

	private void updateJewelleryInfobox(ItemWithSlot item, Item[] items)
	{
		for (final EquipmentInventorySlot equipmentInventorySlot : item.getSlots())
		{
			updateJewelleryInfobox(item, items, equipmentInventorySlot);
		}
	}

	private void updateJewelleryInfobox(ItemWithSlot type, Item[] items, EquipmentInventorySlot slot)
	{
		removeInfobox(type, slot);

		if (slot.getSlotIdx() >= items.length)
		{
			return;
		}

		final int id = items[slot.getSlotIdx()].getId();
		if (id < 0)
		{
			return;
		}

		final ItemWithCharge itemWithCharge = ItemWithCharge.findItem(id);
		int charges = -1;

		if (itemWithCharge == null)
		{
			if (id == ItemID.DODGY_NECKLACE && type == ItemWithSlot.DODGY_NECKLACE)
			{
				charges = config.dodgyNecklace();
			}
			else if (id == ItemID.BINDING_NECKLACE && type == ItemWithSlot.BINDING_NECKLACE)
			{
				charges = config.bindingNecklace();
			}
			else if ((id >= ItemID.EXPLORERS_RING_1 && id <= ItemID.EXPLORERS_RING_4) && type == ItemWithSlot.EXPLORER_RING)
			{
				charges = config.explorerRing();
			}
			else if (id == ItemID.RING_OF_FORGING && type == ItemWithSlot.RING_OF_FORGING)
			{
				charges = config.ringOfForging();
			}
		}
		else if (itemWithCharge.getType() == type.getType())
		{
			charges = itemWithCharge.getCharges();
		}

		if (charges <= 0)
		{
			return;
		}

		final String name = itemManager.getItemComposition(id).getName();
		final BufferedImage image = itemManager.getImage(id);
		final ItemChargeInfobox infobox = new ItemChargeInfobox(this, image, name, charges, type, slot);
		infoBoxManager.addInfoBox(infobox);
	}

	private void removeInfobox(final ItemWithSlot item)
	{
		infoBoxManager.removeIf(t -> t instanceof ItemChargeInfobox && ((ItemChargeInfobox) t).getItem() == item);
	}

	private void removeInfobox(final ItemWithSlot item, final EquipmentInventorySlot slot)
	{
		infoBoxManager.removeIf(t ->
		{
			if (!(t instanceof ItemChargeInfobox))
			{
				return false;
			}

			final ItemChargeInfobox i = (ItemChargeInfobox)t;
			return i.getItem() == item && i.getSlot() == slot;
		});
	}

	Color getColor(int charges)
	{
		Color color = Color.WHITE;
		if (charges <= config.veryLowWarning())
		{
			color = config.veryLowWarningColor();
		}
		else if (charges <= config.lowWarning())
		{
			color = config.lowWarningolor();
		}
		return color;
	}
}
