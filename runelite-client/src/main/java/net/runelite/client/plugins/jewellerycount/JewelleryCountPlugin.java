/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.jewellerycount;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Jewellery Count"
)
@Slf4j
public class JewelleryCountPlugin extends Plugin
{
	@Inject
	private JewelleryCountOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private JewelleryCountConfig config;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Provides
	JewelleryCountConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(JewelleryCountConfig.class);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER)
		{
			if (config.recoilNotification() && event.getMessage().contains("<col=7f007f>Your Ring of Recoil has shattered.</col>"))
			{
				notifier.notify("Your Ring of Recoil has shattered");
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("jewelleryCount"))
		{
			log.info(event.getNewValue());
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
	public void onInventoryChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer().getItems().length > 13)
		{
			return;
		}

		int amulet = -2;
		int bracelet = -2;
		int ring = -2;
		if (event.getItemContainer().getItems().length >= 3)
		{
			if (config.showAmuletInfobox())
			{
				amulet = event.getItemContainer().getItems()[EquipmentInventorySlot.AMULET.getSlotIdx()].getId();
			}
			if (event.getItemContainer().getItems().length >= 10)
			{
				if (config.showBraceletInfobox())
				{
					bracelet = event.getItemContainer().getItems()[EquipmentInventorySlot.GLOVES.getSlotIdx()].getId();
				}
				if (event.getItemContainer().getItems().length == 13)
				{
					if (config.showRingInfobox())
					{
						ring = event.getItemContainer().getItems()[EquipmentInventorySlot.RING.getSlotIdx()].getId();
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
			JewelleryCharges amuletCharges = JewelleryCharges.getCharges(amulet);
			if (amuletCharges != null)
			{
				createJewelleryInfobox(amulet, amuletCharges.getCharges(), EquipmentInventorySlot.AMULET);
			}
			else
			{
				removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
			}
		}
		else
		{
			removeJewelleryInfobox(EquipmentInventorySlot.AMULET);
		}

		if (bracelet > 0)
		{
			JewelleryCharges braceletCharges = JewelleryCharges.getCharges(bracelet);
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
			JewelleryCharges ringCharges = JewelleryCharges.getCharges(ring);
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
		JewelleryInfobox i = new JewelleryInfobox(itemManager.getImage(id), this, charges, slotID);
		infoBoxManager.addInfoBox(i);
	}

	public void removeJewelleryInfobox(EquipmentInventorySlot slotID)
	{
		infoBoxManager.removeIf(t -> t instanceof JewelleryInfobox && ((JewelleryInfobox) t).getSlotID() == slotID);
	}
}