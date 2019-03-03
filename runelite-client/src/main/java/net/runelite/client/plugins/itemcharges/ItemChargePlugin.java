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
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
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
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
public class ItemChargePlugin extends Plugin
{
	private static final Pattern DODGY_CHECK_PATTERN = Pattern.compile(
		"Your dodgy necklace has (\\d+) charges? left\\.");
	private static final Pattern SLAUGHTER_CHECK_PATTERN = Pattern.compile(
		"Your bracelet of slaughter has (\\d{1,2}) charge[s]? left.");
	private static final Pattern EXPEDITIOUS_CHECK_PATTERN = Pattern.compile(
		"Your expeditious bracelet has (\\d{1,2}) charge[s]? left.");
	private static final Pattern DODGY_PROTECT_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It has (\\d+) charges? left\\.");
	private static final Pattern SLAUGHTER_ACTIVATE_PATTERN = Pattern.compile(
		"Your bracelet of slaughter prevents your slayer count decreasing. It has (\\d{1,2}) charge[s]? left.");
	private static final Pattern EXPEDITIOUS_ACTIVATE_PATTERN = Pattern.compile(
		"Your expeditious bracelet helps you progress your slayer (?:task )?faster. It has (\\d{1,2}) charge[s]? left.");
	private static final Pattern DODGY_BREAK_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It then crumbles to dust\\.");
	private static final String RING_OF_RECOIL_BREAK_MESSAGE = "<col=7f007f>Your Ring of Recoil has shattered.</col>";

	private static final int MAX_DODGY_CHARGES = 10;
	private static final int MAX_SLAUGHTER_CHARGES = 30;
	private static final int MAX_EXPEDITIOUS_CHARGES = 30;

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

		if (!config.showSlayerBracelets())
		{
			removeInfobox(ItemWithSlot.BRACELET_OF_SLAUGHTER);
			removeInfobox(ItemWithSlot.EXPEDITIOUS_BRACELET);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		Matcher dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message);
		Matcher slaughterCheckMatcher = SLAUGHTER_CHECK_PATTERN.matcher(message);
		Matcher expeditiousCheckMatcher = EXPEDITIOUS_CHECK_PATTERN.matcher(message);
		Matcher dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message);
		Matcher slaughterActivateMatcher = SLAUGHTER_ACTIVATE_PATTERN.matcher(message);
		Matcher expeditiousActivateMatcher = EXPEDITIOUS_ACTIVATE_PATTERN.matcher(message);
		Matcher dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message);

		if (event.getType() == ChatMessageType.SERVER || event.getType() == ChatMessageType.FILTERED)
		{
			if (config.recoilNotification() && message.contains(RING_OF_RECOIL_BREAK_MESSAGE))
			{
				notifier.notify("Your Ring of Recoil has shattered");
			}
			else if (dodgyCheckMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyCheckMatcher.group(1)));
			}
			else if (slaughterCheckMatcher.find())
			{
				updateBraceletOfSlaughterCharges(Integer.parseInt(slaughterCheckMatcher.group(1)));
			}
			else if (expeditiousCheckMatcher.find())
			{
				updateExpeditiousCharges(Integer.parseInt(expeditiousCheckMatcher.group(1)));
			}
			else if (dodgyProtectMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyProtectMatcher.group(1)));
			}
			else if (slaughterActivateMatcher.find())
			{
				updateBraceletOfSlaughterCharges(Integer.parseInt(slaughterActivateMatcher.group(1)));
			}
			else if (expeditiousActivateMatcher.find())
			{
				updateExpeditiousCharges(Integer.parseInt(expeditiousActivateMatcher.group(1)));
			}
			else if (dodgyBreakMatcher.find())
			{
				if (config.dodgyNotification())
				{
					notifier.notify("Your dodgy necklace has crumbled to dust.");
				}

				updateDodgyNecklaceCharges(MAX_DODGY_CHARGES);
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

		if (config.showSlayerBracelets())
		{
			updateJewelleryInfobox(ItemWithSlot.BRACELET_OF_SLAUGHTER, items);
			updateJewelleryInfobox(ItemWithSlot.EXPEDITIOUS_BRACELET, items);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Widget braceletBreakWidget = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);

		if (braceletBreakWidget != null)
		{
			String braceletText = Text.removeTags(braceletBreakWidget.getText()); //remove color and linebreaks
			if (braceletText.contains("bracelet of slaughter"))
			{
				config.slaughter(MAX_SLAUGHTER_CHARGES);
			}
			else if (braceletText.contains("expeditious bracelet"))
			{
				config.expeditious(MAX_EXPEDITIOUS_CHARGES);
			}
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

	private void updateBraceletOfSlaughterCharges(final int value)
	{
		config.slaughter(value);

		if (config.showInfoboxes() && config.showSlayerBracelets())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.BRACELET_OF_SLAUGHTER, itemContainer.getItems());
		}
	}

	private void updateExpeditiousCharges(final int value)
	{
		config.expeditious(value);

		if (config.showInfoboxes() && config.showSlayerBracelets())
		{
			final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			if (itemContainer == null)
			{
				return;
			}

			updateJewelleryInfobox(ItemWithSlot.EXPEDITIOUS_BRACELET, itemContainer.getItems());
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
			else if (id == ItemID.BRACELET_OF_SLAUGHTER && type == ItemWithSlot.BRACELET_OF_SLAUGHTER)
			{
				charges = config.slaughter();
			}
			else if (id == ItemID.EXPEDITIOUS_BRACELET && type == ItemWithSlot.EXPEDITIOUS_BRACELET)
			{
				charges = config.expeditious();
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