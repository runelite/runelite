/*
 * Copyright (c) 2018, JerwuQu <marcus@ramse.se>
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

package net.runelite.client.plugins.weaponcharges;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Weapon Charges"
)
@Slf4j
public class WeaponChargesPlugin extends Plugin
{
	private static final int WEAPON_SLOT = EquipmentInventorySlot.WEAPON.getSlotIdx();
	private static final Pattern ibansCheckString = Pattern.compile("You have ([0-9]+) charges left on the staff.");
	private static final String ibansRechargeString = "You hold the staff above the well...";

	private WeaponChargesCounter counter;

	private ChargedWeapon rechargedWeapon;

	@Inject
	private Client client;

	@Inject
	private WeaponChargesOverlay overlay;

	@Inject
	private ItemManager itemManager;

	@Inject
	private WeaponChargesConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Provides
	WeaponChargesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WeaponChargesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		processChargesCounter();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeChargesCounter();
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public Integer getCharges(ChargedWeapon weapon)
	{
		if ((weapon == ChargedWeapon.IBANS_STAFF || weapon == ChargedWeapon.IBANS_STAFF_U) && config.ibansCharges() >= 0)
		{
			return config.ibansCharges();
		}
		else
		{
			return null;
		}
	}

	public Color getChargesColor(int charges)
	{
		return charges > 100 ? Color.WHITE : Color.RED;
	}

	private void addChargesCounter(ChargedWeapon weapon)
	{
		if (counter != null)
		{
			if (counter.getChargedWeapon() == weapon) return;
			removeChargesCounter();
		}

		counter = new WeaponChargesCounter(itemManager.getImage(weapon.getItemId()), this, weapon);
		infoBoxManager.addInfoBox(counter);
		log.debug("Added Weapon Charges Counter");
	}

	private void removeChargesCounter()
	{
		if (counter != null)
		{
			infoBoxManager.removeInfoBox(counter);
			counter = null;
			log.debug("Removed Weapon Charges Counter");
		}
	}

	private void processChargesCounter()
	{
		final ChargedWeapon equippedWeapon = getEquippedWeapon();
		if (config.showChargesInfoBox() && equippedWeapon != null)
		{
			addChargesCounter(equippedWeapon);
		}
		else
		{
			removeChargesCounter();
		}
	}

	public ChargedWeapon getChargedWeaponFromId(int itemId)
	{
		for (ChargedWeapon weapon : ChargedWeapon.values())
		{
			if (itemId == weapon.getItemId()) return weapon;
		}

		return null;
	}

	private ChargedWeapon getEquippedWeapon()
	{
		final ItemContainer equipContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipContainer != null)
		{
			Item[] equippedItems = equipContainer.getItems();
			if (equippedItems.length >= WEAPON_SLOT)
			{
				return getChargedWeaponFromId(equippedItems[WEAPON_SLOT].getId());
			}
		}

		return null;
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		processChargesCounter();
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		processChargesCounter();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		final String menuTarget = event.getMenuTarget();
		for (ChargedWeapon weapon : ChargedWeapon.values())
		{
			if (menuTarget.contains(">" + weapon.getItemName() + "<"))
			{
				rechargedWeapon = weapon;
				return;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER) return;

		final String message = event.getMessage();

		// Recharge
		if (message.equals(ibansRechargeString))
		{
			config.ibansCharges(rechargedWeapon.getRechargeAmount());
		}

		// Check charges
		final Matcher match = ibansCheckString.matcher(message);
		if (match.find())
		{
			config.ibansCharges(Integer.parseInt(match.group(1)));
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();
		if (actor == client.getLocalPlayer())
		{
			if (actor.getAnimation() == AnimationID.MAGIC_IBANS_BLAST)
			{
				config.ibansCharges(config.ibansCharges() - 1);
			}
		}
	}
}
