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
package net.runelite.client.plugins.timers;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Prayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.timers.GameTimer.ANTIDOTEPLUS;
import static net.runelite.client.plugins.timers.GameTimer.ANTIDOTEPLUSPLUS;
import static net.runelite.client.plugins.timers.GameTimer.ANTIFIRE;
import static net.runelite.client.plugins.timers.GameTimer.ANTIPOISON;
import static net.runelite.client.plugins.timers.GameTimer.ANTIVENOM;
import static net.runelite.client.plugins.timers.GameTimer.ANTIVENOMPLUS;
import static net.runelite.client.plugins.timers.GameTimer.BIND;
import static net.runelite.client.plugins.timers.GameTimer.CANNON;
import static net.runelite.client.plugins.timers.GameTimer.CHARGE;
import static net.runelite.client.plugins.timers.GameTimer.ENTANGLE;
import static net.runelite.client.plugins.timers.GameTimer.EXANTIFIRE;
import static net.runelite.client.plugins.timers.GameTimer.EXSUPERANTIFIRE;
import static net.runelite.client.plugins.timers.GameTimer.FULLTB;
import static net.runelite.client.plugins.timers.GameTimer.GOD_WARS_ALTAR;
import static net.runelite.client.plugins.timers.GameTimer.HALFBIND;
import static net.runelite.client.plugins.timers.GameTimer.HALFENTANGLE;
import static net.runelite.client.plugins.timers.GameTimer.HALFSNARE;
import static net.runelite.client.plugins.timers.GameTimer.HALFTB;
import static net.runelite.client.plugins.timers.GameTimer.ICEBARRAGE;
import static net.runelite.client.plugins.timers.GameTimer.ICEBLITZ;
import static net.runelite.client.plugins.timers.GameTimer.ICEBURST;
import static net.runelite.client.plugins.timers.GameTimer.ICERUSH;
import static net.runelite.client.plugins.timers.GameTimer.IMBUEDHEART;
import static net.runelite.client.plugins.timers.GameTimer.MAGICIMBUE;
import static net.runelite.client.plugins.timers.GameTimer.OVERLOAD;
import static net.runelite.client.plugins.timers.GameTimer.OVERLOAD_RAID;
import static net.runelite.client.plugins.timers.GameTimer.PRAYER_ENHANCE;
import static net.runelite.client.plugins.timers.GameTimer.SANFEW;
import static net.runelite.client.plugins.timers.GameTimer.SNARE;
import static net.runelite.client.plugins.timers.GameTimer.STAFF_OF_THE_DEAD;
import static net.runelite.client.plugins.timers.GameTimer.STAMINA;
import static net.runelite.client.plugins.timers.GameTimer.SUPERANTIFIRE;
import static net.runelite.client.plugins.timers.GameTimer.SUPERANTIPOISON;
import static net.runelite.client.plugins.timers.GameTimer.VENGEANCE;
import static net.runelite.client.plugins.timers.GameTimer.VENGEANCEOTHER;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Timers"
)
public class TimersPlugin extends Plugin
{
	private int lastRaidVarb;

	@Inject
	private Client client;

	@Inject
	private TimersConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Provides
	TimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TimersConfig.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer);
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		int raidVarb = client.getVar(Varbits.IN_RAID);
		if (lastRaidVarb != raidVarb)
		{
			removeGameTimer(OVERLOAD_RAID);
			removeGameTimer(PRAYER_ENHANCE);
			lastRaidVarb = raidVarb;
		}
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		if (!config.showAntidotePlus())
		{
			removeGameTimer(ANTIDOTEPLUS);
		}

		if (!config.showAntidotePlusPlus())
		{
			removeGameTimer(ANTIDOTEPLUSPLUS);
		}

		if (!config.showSanfew())
		{
			removeGameTimer(SANFEW);
		}

		if (!config.showAntiVenom())
		{
			removeGameTimer(ANTIVENOM);
		}

		if (!config.showAntiVenomPlus())
		{
			removeGameTimer(ANTIVENOMPLUS);
		}

		if (!config.showAntiFire())
		{
			removeGameTimer(ANTIFIRE);
		}

		if (!config.showExAntiFire())
		{
			removeGameTimer(EXANTIFIRE);
		}

		if (!config.showSuperAntiFire())
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (!config.showStamina())
		{
			removeGameTimer(STAMINA);
		}

		if (!config.showOverload())
		{
			removeGameTimer(OVERLOAD);
			removeGameTimer(OVERLOAD_RAID);
		}

		if (!config.showPrayerEnhance())
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (!config.showCannon())
		{
			removeGameTimer(CANNON);
		}

		if (!config.showMagicImbue())
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (!config.showCharge())
		{
			removeGameTimer(CHARGE);
		}

		if (!config.showImbuedHeart())
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (!config.showStaffOfTheDead())
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (!config.showVengeance())
		{
			removeGameTimer(VENGEANCE);
		}

		if (!config.showVengeanceOther())
		{
			removeGameTimer(VENGEANCEOTHER);
		}

		if (!config.showTeleblock())
		{
			removeGameTimer(FULLTB);
			removeGameTimer(HALFTB);
		}

		if (!config.showFreezes())
		{
			removeGameTimer(BIND);
			removeGameTimer(HALFBIND);
			removeGameTimer(SNARE);
			removeGameTimer(HALFSNARE);
			removeGameTimer(ENTANGLE);
			removeGameTimer(HALFENTANGLE);
			removeGameTimer(ICERUSH);
			removeGameTimer(ICEBURST);
			removeGameTimer(ICEBLITZ);
			removeGameTimer(ICEBARRAGE);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (config.showAntidotePlusPlus()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.ANTIDOTE1_5958
			|| event.getId() == ItemID.ANTIDOTE2_5956
			|| event.getId() == ItemID.ANTIDOTE3_5954
			|| event.getId() == ItemID.ANTIDOTE4_5952))
		{
			// Needs menu option hook because drink message is intercepting with antipoison message
			createGameTimer(ANTIDOTEPLUSPLUS);
			return;
		}

		if (config.showAntidotePlus()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.ANTIDOTE1
			|| event.getId() == ItemID.ANTIDOTE2
			|| event.getId() == ItemID.ANTIDOTE3
			|| event.getId() == ItemID.ANTIDOTE4))
		{
			// Needs menu option hook because drink message is intercepting with antipoison message
			createGameTimer(ANTIDOTEPLUS);
			return;
		}

		if (config.showAntiPoison()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.ANTIPOISON1
			|| event.getId() == ItemID.ANTIPOISON2
			|| event.getId() == ItemID.ANTIPOISON3
			|| event.getId() == ItemID.ANTIPOISON4))
		{
			createGameTimer(ANTIPOISON);
			return;
		}

		if (config.showSuperantipoison()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.SUPERANTIPOISON1
			|| event.getId() == ItemID.SUPERANTIPOISON2
			|| event.getId() == ItemID.SUPERANTIPOISON3
			|| event.getId() == ItemID.SUPERANTIPOISON4))
		{
			createGameTimer(SUPERANTIPOISON);
			return;
		}

		if (config.showStamina()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.STAMINA_MIX1
			|| event.getId() == ItemID.STAMINA_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(STAMINA);
			return;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{

		if (event.getType() != ChatMessageType.FILTERED && event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (config.showStamina() && event.getMessage().equals("You drink some of your stamina potion."))
		{
			createGameTimer(STAMINA);
		}

		if (event.getMessage().equals("<col=8f4808>Your stamina potion has expired.</col>"))
		{
			removeGameTimer(STAMINA);
		}

		if (config.showAntiFire() && event.getMessage().equals("You drink some of your antifire potion."))
		{
			createGameTimer(ANTIFIRE);
		}

		if (config.showExAntiFire() && event.getMessage().equals("You drink some of your extended antifire potion."))
		{
			createGameTimer(EXANTIFIRE);
		}

		if (config.showGodWarsAltar() && event.getMessage().equalsIgnoreCase("you recharge your prayer."))//Normal altars are "You recharge your Prayer points." while gwd is "You recharge your Prayer."
		{
			createGameTimer(GOD_WARS_ALTAR);
		}

		if (config.showExSuperAntifire() && event.getMessage().equals("You drink some of your extended super antifire potion."))
		{
			createGameTimer(EXSUPERANTIFIRE);
		}

		if (event.getMessage().equals("<col=7f007f>Your antifire potion has expired.</col>"))
		{
			//they have the same expired message
			removeGameTimer(ANTIFIRE);
			removeGameTimer(EXANTIFIRE);
		}

		if (config.showOverload() && event.getMessage().startsWith("You drink some of your") && event.getMessage().contains("overload"))
		{
			if (client.getVar(Varbits.IN_RAID) == 1)
			{
				createGameTimer(OVERLOAD_RAID);
			}
			else
			{
				createGameTimer(OVERLOAD);
			}

		}

		if (config.showCannon() && (event.getMessage().equals("You add the furnace.") || event.getMessage().contains("You repair your cannon, restoring it to working order.")))
		{
			createGameTimer(CANNON);
		}

		if (event.getMessage().equals("You pick up the cannon. It's really heavy."))
		{
			removeGameTimer(CANNON);
		}

		if (config.showAntiVenomPlus() && event.getMessage().contains("You drink some of your super antivenom potion"))
		{
			createGameTimer(ANTIVENOMPLUS);
		}

		if (config.showMagicImbue() && event.getMessage().equals("You are charged to combine runes!"))
		{
			createGameTimer(MAGICIMBUE);
		}

		if (event.getMessage().equals("Your Magic Imbue charge has ended."))
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (config.showTeleblock() && event.getMessage().equals("<col=4f006f>A teleblock spell has been cast on you. It will expire in 5 minutes, 0 seconds.</col>"))
		{
			createGameTimer(FULLTB);
		}

		if (config.showTeleblock() && event.getMessage().equals("<col=4f006f>A teleblock spell has been cast on you. It will expire in 2 minutes, 30 seconds.</col>"))
		{
			createGameTimer(HALFTB);
		}

		if (config.showSuperAntiFire() && event.getMessage().contains("You drink some of your super antifire potion"))
		{
			createGameTimer(SUPERANTIFIRE);
		}

		if (event.getMessage().equals("<col=7f007f>Your super antifire potion has expired.</col>"))
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (event.getMessage().equals("<col=ef1020>Your imbued heart has regained its magical power.</col>"))
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (config.showAntiVenom() && event.getMessage().contains("You drink some of your antivenom potion"))
		{
			createGameTimer(ANTIVENOM);
		}

		if (config.showSanfew() && event.getMessage().contains("You drink some of your Sanfew Serum."))
		{
			createGameTimer(SANFEW);
		}

		if (config.showPrayerEnhance() && event.getMessage().startsWith("You drink some of your") && event.getMessage().contains("prayer enhance"))
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (config.showCharge() && event.getMessage().equals("<col=ef1020>You feel charged with magic power.</col>"))
		{
			createGameTimer(CHARGE);
		}

		if (event.getMessage().equals("<col=ef1020>Your magical charge fades away.</col>"))
		{
			removeGameTimer(CHARGE);
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (config.showVengeanceOther() && actor.getAnimation() == AnimationID.VENGEANCE_OTHER)
		{
			createGameTimer(VENGEANCEOTHER);
		}
	}


	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (config.showImbuedHeart() && actor.getGraphic() == IMBUEDHEART.getGraphicId())
		{
			createGameTimer(IMBUEDHEART);
		}

		if (config.showVengeance() && actor.getGraphic() == VENGEANCE.getGraphicId())
		{
			createGameTimer(VENGEANCE);
		}

		if (config.showStaffOfTheDead() && actor.getGraphic() == STAFF_OF_THE_DEAD.getGraphicId())
		{
			createGameTimer(STAFF_OF_THE_DEAD);
		}

		if (config.showFreezes())
		{
			if (actor.getGraphic() == BIND.getGraphicId())
			{
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
				{
					createGameTimer(HALFBIND);
				}
				else
				{
					createGameTimer(BIND);
				}
			}

			if (actor.getGraphic() == SNARE.getGraphicId())
			{
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
				{
					createGameTimer(HALFSNARE);
				}
				else
				{
					createGameTimer(SNARE);
				}
			}

			if (actor.getGraphic() == ENTANGLE.getGraphicId())
			{
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
				{
					createGameTimer(HALFENTANGLE);
				}
				else
				{
					createGameTimer(ENTANGLE);
				}
			}

			if (actor.getGraphic() == ICERUSH.getGraphicId())
			{
				createGameTimer(ICERUSH);
			}

			if (actor.getGraphic() == ICEBURST.getGraphicId())
			{
				createGameTimer(ICEBURST);
			}

			if (actor.getGraphic() == ICEBLITZ.getGraphicId())
			{
				createGameTimer(ICEBLITZ);
			}

			if (actor.getGraphic() == ICEBARRAGE.getGraphicId())
			{
				createGameTimer(ICEBARRAGE);
			}
		}
	}

	/**
	 * remove SOTD timer when weapon is changed
	 *
	 * @param itemContainerChanged
	 */
	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
	{
		ItemContainer container = itemContainerChanged.getItemContainer();
		if (container == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			Item[] items = container.getItems();
			int weaponIdx = EquipmentInventorySlot.WEAPON.getSlotIdx();

			if (items == null || weaponIdx >= items.length)
			{
				removeGameTimer(STAFF_OF_THE_DEAD);
				return;
			}

			Item weapon = items[weaponIdx];
			if (weapon == null)
			{
				removeGameTimer(STAFF_OF_THE_DEAD);
				return;
			}

			switch (weapon.getId())
			{
				case ItemID.STAFF_OF_THE_DEAD:
				case ItemID.TOXIC_STAFF_OF_THE_DEAD:
				case ItemID.STAFF_OF_LIGHT:
				case ItemID.TOXIC_STAFF_UNCHARGED:
					// don't reset timer if still weilding staff
					return;
				default:
					removeGameTimer(STAFF_OF_THE_DEAD);
			}
		}
	}

	public void createGameTimer(GameTimer timer)
	{
		removeGameTimer(timer);

		TimerTimer t = new TimerTimer(timer, this);
		t.setTooltip(timer.getDescription());
		infoBoxManager.addInfoBox(t);
	}

	public void removeGameTimer(GameTimer timer)
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer() == timer);
	}
}