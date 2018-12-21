/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.PVP_WORLD_SAFE_ZONE;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.timers.GameIndicator.VENGEANCE_ACTIVE;
import static net.runelite.client.plugins.timers.GameTimer.*;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Timers",
	description = "Show various timers in an infobox",
	tags = {"combat", "items", "magic", "potions", "prayer", "overlay", "abyssal", "sire"}
)
@Slf4j
public class TimersPlugin extends Plugin
{
	private static final String ANTIFIRE_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your antifire potion has expired.</col>";
	private static final String ANTIVENOM_DRINK_MESSAGE = "You drink some of your antivenom potion";
	private static final String CANNON_FURNACE_MESSAGE = "You add the furnace.";
	private static final String CANNON_PICKUP_MESSAGE = "You pick up the cannon. It's really heavy.";
	private static final String CANNON_REPAIR_MESSAGE = "You repair your cannon, restoring it to working order.";
	private static final String CHARGE_EXPIRED_MESSAGE = "<col=ef1020>Your magical charge fades away.</col>";
	private static final String CHARGE_MESSAGE = "<col=ef1020>You feel charged with magic power.</col>";
	private static final String DEADMAN_HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A teleblock spell has been cast on you. It will expire in 1 minute, 15 seconds.</col>";
	private static final String EXTENDED_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String FROZEN_MESSAGE = "<col=ef1020>You have been frozen!</col>";
	private static final String FULL_TELEBLOCK_MESSAGE = "<col=4f006f>A teleblock spell has been cast on you. It will expire in 5 minutes, 0 seconds.</col>";
	private static final String GOD_WARS_ALTAR_MESSAGE = "you recharge your prayer.";
	private static final String HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A teleblock spell has been cast on you. It will expire in 2 minutes, 30 seconds.</col>";
	private static final String IMBUED_HEART_READY_MESSAGE = "<col=ef1020>Your imbued heart has regained its magical power.</col>";
	private static final String MAGIC_IMBUE_EXPIRED_MESSAGE = "Your Magic Imbue charge has ended.";
	private static final String MAGIC_IMBUE_MESSAGE = "You are charged to combine runes!";
	private static final String SANFEW_SERUM_DRINK_MESSAGE = "You drink some of your Sanfew Serum.";
	private static final String STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE = "Your protection fades away";
	private static final String STAFF_OF_THE_DEAD_SPEC_MESSAGE = "Spirits of deceased evildoers offer you their protection";
	private static final String STAMINA_DRINK_MESSAGE = "You drink some of your stamina potion.";
	private static final String STAMINA_SHARED_DRINK_MESSAGE = "You have received a shared dose of stamina potion.";
	private static final String STAMINA_EXPIRED_MESSAGE = "<col=8f4808>Your stamina potion has expired.</col>";
	private static final String SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your super antifire potion";
	private static final String SUPER_ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your super antifire potion has expired.</col>";
	private static final String SUPER_ANTIVENOM_DRINK_MESSAGE = "You drink some of your super antivenom potion";
	private static final String VENGEANCE_USED_MESSAGE = "Taste vengeance!";

	private TimerTimer freezeTimer;
	private int freezeTime = -1; // time frozen, in game ticks

	private int lastRaidVarb;
	private int lastWildernessVarb;
	private WorldPoint lastPoint;
	private TeleportWidget lastTeleportClicked;
	private int lastAnimation;
	private boolean loggedInRace;
	private boolean widgetHiddenChangedOnPvpWorld;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

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
		lastRaidVarb = -1;
		lastPoint = null;
		lastTeleportClicked = null;
		lastAnimation = -1;
		loggedInRace = false;
		widgetHiddenChangedOnPvpWorld = false;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int raidVarb = client.getVar(Varbits.IN_RAID);
		if (lastRaidVarb != raidVarb)
		{
			removeGameTimer(OVERLOAD_RAID);
			removeGameTimer(PRAYER_ENHANCE);
			lastRaidVarb = raidVarb;
		}

		int inWilderness = client.getVar(Varbits.IN_WILDERNESS);

		if (lastWildernessVarb != inWilderness
			&& client.getGameState() == GameState.LOGGED_IN
			&& !loggedInRace)
		{
			if (!WorldType.isPvpWorld(client.getWorldType())
				&& inWilderness == 0)
			{
				log.debug("Left wilderness in non-PVP world, clearing Teleblock timer.");
				removeTbTimers();
			}

			lastWildernessVarb = inWilderness;
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();
		if (WorldType.isPvpWorld(client.getWorldType())
			&& WidgetInfo.TO_GROUP(widget.getId()) == WidgetInfo.PVP_CONTAINER.getGroupId())
		{
			widgetHiddenChangedOnPvpWorld = true;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!config.showHomeMinigameTeleports())
		{
			removeGameTimer(HOME_TELEPORT);
			removeGameTimer(MINIGAME_TELEPORT);
		}

		if (!config.showAntiPoison())
		{
			removeGameTimer(ANTIDOTEPLUS);
			removeGameTimer(ANTIDOTEPLUSPLUS);
			removeGameTimer(SANFEW);
			removeGameTimer(ANTIVENOM);
			removeGameTimer(ANTIVENOMPLUS);
		}

		if (!config.showAntiFire())
		{
			removeGameTimer(ANTIFIRE);
			removeGameTimer(EXANTIFIRE);
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
			removeGameTimer(VENGEANCEOTHER);
		}

		if (!config.showTeleblock())
		{
			removeTbTimers();
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
		if (config.showAntiPoison()
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

		if (config.showAntiPoison()
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

		if (config.showAntiPoison()
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

		TeleportWidget teleportWidget = TeleportWidget.of(event.getWidgetId());
		if (teleportWidget != null)
		{
			lastTeleportClicked = teleportWidget;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (config.showVengeanceActive() && event.getMessage().equals(VENGEANCE_USED_MESSAGE) && event.getType() == ChatMessageType.PUBLIC
			&& Text.toJagexName(event.getName()).equals(client.getLocalPlayer().getName()))
		{
			removeGameIndicator(VENGEANCE_ACTIVE);
		}

		if (event.getType() != ChatMessageType.FILTERED && event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (config.showStamina() && (event.getMessage().equals(STAMINA_DRINK_MESSAGE) || event.getMessage().equals(STAMINA_SHARED_DRINK_MESSAGE)))
		{
			createGameTimer(STAMINA);
		}

		if (config.showStamina() && event.getMessage().equals(STAMINA_EXPIRED_MESSAGE))
		{
			removeGameTimer(STAMINA);
		}

		if (config.showAntiFire() && event.getMessage().equals(ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(ANTIFIRE);
		}

		if (config.showAntiFire() && event.getMessage().equals(EXTENDED_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXANTIFIRE);
		}

		if (config.showGodWarsAltar() && event.getMessage().equalsIgnoreCase(GOD_WARS_ALTAR_MESSAGE))//Normal altars are "You recharge your Prayer points." while gwd is "You recharge your Prayer."
		{
			createGameTimer(GOD_WARS_ALTAR);
		}

		if (config.showAntiFire() && event.getMessage().equals(EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXSUPERANTIFIRE);
		}

		if (config.showAntiFire() && event.getMessage().equals(ANTIFIRE_EXPIRED_MESSAGE))
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

		if (config.showCannon() && (event.getMessage().equals(CANNON_FURNACE_MESSAGE) || event.getMessage().contains(CANNON_REPAIR_MESSAGE)))
		{
			createGameTimer(CANNON);
		}

		if (config.showCannon() && event.getMessage().equals(CANNON_PICKUP_MESSAGE))
		{
			removeGameTimer(CANNON);
		}

		if (config.showAntiPoison() && event.getMessage().contains(SUPER_ANTIVENOM_DRINK_MESSAGE))
		{
			createGameTimer(ANTIVENOMPLUS);
		}

		if (config.showMagicImbue() && event.getMessage().equals(MAGIC_IMBUE_MESSAGE))
		{
			createGameTimer(MAGICIMBUE);
		}

		if (event.getMessage().equals(MAGIC_IMBUE_EXPIRED_MESSAGE))
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (config.showTeleblock() && event.getMessage().equals(FULL_TELEBLOCK_MESSAGE))
		{
			createGameTimer(FULLTB);
		}

		if (config.showTeleblock() && event.getMessage().equals(HALF_TELEBLOCK_MESSAGE))
		{
			if (client.getWorldType().contains(WorldType.DEADMAN)
				&& !client.getWorldType().contains(WorldType.SEASONAL_DEADMAN)
				&& !client.getWorldType().contains(WorldType.DEADMAN_TOURNAMENT))
			{
				createGameTimer(DMM_FULLTB);
			}
			else
			{
				createGameTimer(HALFTB);
			}
		}

		if (config.showTeleblock() && event.getMessage().equals(DEADMAN_HALF_TELEBLOCK_MESSAGE))
		{
			createGameTimer(DMM_HALFTB);
		}

		if (config.showAntiFire() && event.getMessage().contains(SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(SUPERANTIFIRE);
		}

		if (config.showAntiFire() && event.getMessage().equals(SUPER_ANTIFIRE_EXPIRED_MESSAGE))
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (config.showImbuedHeart() && event.getMessage().equals(IMBUED_HEART_READY_MESSAGE))
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (config.showAntiPoison() && event.getMessage().contains(ANTIVENOM_DRINK_MESSAGE))
		{
			createGameTimer(ANTIVENOM);
		}

		if (config.showAntiPoison() && event.getMessage().contains(SANFEW_SERUM_DRINK_MESSAGE))
		{
			createGameTimer(SANFEW);
		}

		if (config.showPrayerEnhance() && event.getMessage().startsWith("You drink some of your") && event.getMessage().contains("prayer enhance"))
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (config.showCharge() && event.getMessage().equals(CHARGE_MESSAGE))
		{
			createGameTimer(CHARGE);
		}

		if (config.showCharge() && event.getMessage().equals(CHARGE_EXPIRED_MESSAGE))
		{
			removeGameTimer(CHARGE);
		}

		if (config.showStaffOfTheDead() && event.getMessage().contains(STAFF_OF_THE_DEAD_SPEC_MESSAGE))
		{
			createGameTimer(STAFF_OF_THE_DEAD);
		}

		if (config.showStaffOfTheDead() && event.getMessage().contains(STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE))
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (config.showFreezes() && event.getMessage().equals(FROZEN_MESSAGE))
		{
			freezeTimer = createGameTimer(ICEBARRAGE);
			freezeTime = client.getTickCount();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		loggedInRace = false;

		Player player = client.getLocalPlayer();
		WorldPoint currentWorldPoint = player.getWorldLocation();

		if (freezeTimer != null)
		{
			// assume movement means unfrozen
			if (freezeTime != client.getTickCount()
				&& !currentWorldPoint.equals(lastPoint))
			{
				removeGameTimer(freezeTimer.getTimer());
				freezeTimer = null;
			}
		}

		lastPoint = currentWorldPoint;

		if (!widgetHiddenChangedOnPvpWorld)
		{
			return;
		}

		widgetHiddenChangedOnPvpWorld = false;

		Widget widget = client.getWidget(PVP_WORLD_SAFE_ZONE);
		if (widget != null
			&& !widget.isSelfHidden())
		{
			log.debug("Entered safe zone in PVP world, clearing Teleblock timer.");
			removeTbTimers();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				removeGameIndicator(VENGEANCE_ACTIVE);
				removeTbTimers();
				break;
			case LOGGED_IN:
				loggedInRace = true;
				break;
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();

		if (config.showAbyssalSireStun()
			&& actor instanceof NPC)
		{
			int npcId = ((NPC)actor).getId();

			switch (npcId)
			{
				// Show the countdown when the Sire enters the stunned state.
				case NpcID.ABYSSAL_SIRE_5887:
					createGameTimer(ABYSSAL_SIRE_STUN);
					break;

				// Hide the countdown if the Sire isn't in the stunned state.
				// This is necessary because the Sire leaves the stunned
				// state early once all all four respiratory systems are killed.
				case NpcID.ABYSSAL_SIRE:
				case NpcID.ABYSSAL_SIRE_5888:
				case NpcID.ABYSSAL_SIRE_5889:
				case NpcID.ABYSSAL_SIRE_5890:
				case NpcID.ABYSSAL_SIRE_5891:
				case NpcID.ABYSSAL_SIRE_5908:
					removeGameTimer(ABYSSAL_SIRE_STUN);
					break;
			}
		}

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (config.showVengeance()
			&& actor.getAnimation() == AnimationID.ENERGY_TRANSFER_VENGEANCE_OTHER
			&& actor.getInteracting().getGraphic() == VENGEANCEOTHER.getGraphicId())
		{
			createGameTimer(VENGEANCEOTHER);
		}

		if (config.showHomeMinigameTeleports()
			&& client.getLocalPlayer().getAnimation() == AnimationID.IDLE
			&& (lastAnimation == AnimationID.BOOK_HOME_TELEPORT_5
			|| lastAnimation == AnimationID.COW_HOME_TELEPORT_6))
		{
			if (lastTeleportClicked == TeleportWidget.HOME_TELEPORT)
			{
				createGameTimer(HOME_TELEPORT);
			}
			else if (lastTeleportClicked == TeleportWidget.MINIGAME_TELEPORT)
			{
				createGameTimer(MINIGAME_TELEPORT);
			}
		}

		lastAnimation = client.getLocalPlayer().getAnimation();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (config.showVengeanceActive() && event.getGroupId() == WidgetID.ENTERING_HOUSE_GROUP_ID)
		{
			removeGameIndicator(VENGEANCE_ACTIVE);
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

		if (config.showVengeanceActive() && actor.getGraphic() == VENGEANCE_ACTIVE.getGraphicId())
		{
			createGameIndicator(VENGEANCE_ACTIVE);
		}

		if (config.showFreezes())
		{
			if (actor.getGraphic() == BIND.getGraphicId())
			{
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
					&& !client.getWorldType().contains(WorldType.SEASONAL_DEADMAN)
					&& !client.getWorldType().contains(WorldType.DEADMAN_TOURNAMENT))
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
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
					&& !client.getWorldType().contains(WorldType.SEASONAL_DEADMAN)
					&& !client.getWorldType().contains(WorldType.DEADMAN_TOURNAMENT))
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
				if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
					&& !client.getWorldType().contains(WorldType.SEASONAL_DEADMAN)
					&& !client.getWorldType().contains(WorldType.DEADMAN_TOURNAMENT))
				{
					createGameTimer(HALFENTANGLE);
				}
				else
				{
					createGameTimer(ENTANGLE);
				}
			}

			// downgrade freeze based on graphic, if at the same tick as the freeze message
			if (freezeTime == client.getTickCount())
			{
				if (actor.getGraphic() == ICERUSH.getGraphicId())
				{
					removeGameTimer(ICEBARRAGE);
					freezeTimer = createGameTimer(ICERUSH);
				}

				if (actor.getGraphic() == ICEBURST.getGraphicId())
				{
					removeGameTimer(ICEBARRAGE);
					freezeTimer = createGameTimer(ICEBURST);
				}

				if (actor.getGraphic() == ICEBLITZ.getGraphicId())
				{
					removeGameTimer(ICEBARRAGE);
					freezeTimer = createGameTimer(ICEBLITZ);
				}
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
					// don't reset timer if still wielding staff
					return;
				default:
					removeGameTimer(STAFF_OF_THE_DEAD);
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();

		if (!npc.isDead())
		{
			return;
		}

		int npcId = npc.getId();

		if (npcId == NpcID.ZOMBIFIED_SPAWN || npcId == NpcID.ZOMBIFIED_SPAWN_8063)
		{
			removeGameTimer(ICEBARRAGE);
		}
	}

	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath event)
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer().isRemovedOnDeath());
	}

	private TimerTimer createGameTimer(final GameTimer timer)
	{
		removeGameTimer(timer);

		BufferedImage image = timer.getImage(itemManager, spriteManager);
		TimerTimer t = new TimerTimer(timer, this, image);
		t.setTooltip(timer.getDescription());
		infoBoxManager.addInfoBox(t);
		return t;
	}

	private void removeGameTimer(GameTimer timer)
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer() == timer);
	}

	private IndicatorIndicator createGameIndicator(GameIndicator gameIndicator)
	{
		removeGameIndicator(gameIndicator);

		BufferedImage image = gameIndicator.getImage(itemManager, spriteManager);
		IndicatorIndicator indicator = new IndicatorIndicator(gameIndicator, image, this);
		indicator.setTooltip(gameIndicator.getDescription());
		infoBoxManager.addInfoBox(indicator);

		return indicator;
	}

	private void removeGameIndicator(GameIndicator indicator)
	{
		infoBoxManager.removeIf(t -> t instanceof IndicatorIndicator && ((IndicatorIndicator) t).getIndicator() == indicator);
	}

	private void removeTbTimers()
	{
		removeGameTimer(FULLTB);
		removeGameTimer(HALFTB);
		removeGameTimer(DMM_FULLTB);
		removeGameTimer(DMM_HALFTB);
	}
}
