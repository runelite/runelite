/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
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
import net.runelite.api.Skill;
import net.runelite.api.SkullIcon;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.PVP_WORLD_SAFE_ZONE;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.timers.GameIndicator.VENGEANCE_ACTIVE;
import static net.runelite.client.plugins.timers.GameTimer.*;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Timers",
	description = "Show various timers in an infobox",
	tags = {"combat", "items", "magic", "potions", "prayer", "overlay", "abyssal", "sire"}
)
@Slf4j
@Singleton
public class TimersPlugin extends Plugin
{
	private static final String ANTIFIRE_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your antifire potion has expired.</col>";
	private static final String CANNON_FURNACE_MESSAGE = "You add the furnace.";
	private static final String CANNON_PICKUP_MESSAGE = "You pick up the cannon. It's really heavy.";
	private static final String CANNON_REPAIR_MESSAGE = "You repair your cannon, restoring it to working order.";
	private static final String CHARGE_EXPIRED_MESSAGE = "<col=ef1020>Your magical charge fades away.</col>";
	private static final String CHARGE_MESSAGE = "<col=ef1020>You feel charged with magic power.</col>";
	private static final String EXTENDED_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String FROZEN_MESSAGE = "<col=ef1020>You have been frozen!</col>";
	private static final String GOD_WARS_ALTAR_MESSAGE = "you recharge your prayer.";
	private static final String IMBUED_HEART_READY_MESSAGE = "<col=ef1020>Your imbued heart has regained its magical power.</col>";
	private static final String IMBUED_HEART_NOTREADY_MESSAGE = "The heart is still drained of its power.";
	private static final String MAGIC_IMBUE_EXPIRED_MESSAGE = "Your Magic Imbue charge has ended.";
	private static final String MAGIC_IMBUE_MESSAGE = "You are charged to combine runes!";
	private static final String STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE = "Your protection fades away";
	private static final String STAFF_OF_THE_DEAD_SPEC_MESSAGE = "Spirits of deceased evildoers offer you their protection";
	private static final String STAMINA_DRINK_MESSAGE = "You drink some of your stamina potion.";
	private static final String STAMINA_SHARED_DRINK_MESSAGE = "You have received a shared dose of stamina potion.";
	private static final String STAMINA_EXPIRED_MESSAGE = "<col=8f4808>Your stamina potion has expired.</col>";
	private static final String SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your super antifire potion";
	private static final String SUPER_ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your super antifire potion has expired.</col>";
	private static final int VENOM_VALUE_CUTOFF = -40; // Antivenom < -40 =< Antipoison < 0
	private static final int POISON_TICK_LENGTH = 30;
	private static final String SUPER_ANTIVENOM_DRINK_MESSAGE = "You drink some of your super antivenom potion";
	private static final String KILLED_TELEBLOCK_OPPONENT_TEXT = "<col=4f006f>Your Tele Block has been removed because you killed ";
	private static final String PRAYER_ENHANCE_EXPIRED = "<col=ff0000>Your prayer enhance effect has worn off.</col>";
	private static final Pattern DEADMAN_HALF_TELEBLOCK_PATTERN = Pattern.compile("<col=4f006f>A Tele Block spell has been cast on you by (.+)\\. It will expire in 1 minute, 15 seconds\\.</col>");
	private static final Pattern FULL_TELEBLOCK_PATTERN = Pattern.compile("<col=4f006f>A Tele Block spell has been cast on you by (.+)\\. It will expire in 5 minutes, 0 seconds\\.</col>");
	private static final Pattern HALF_TELEBLOCK_PATTERN = Pattern.compile("<col=4f006f>A Tele Block spell has been cast on you by (.+)\\. It will expire in 2 minutes, 30 seconds\\.</col>");
	private static final Pattern DIVINE_POTION_PATTERN = Pattern.compile("You drink some of your divine (.+) potion\\.");

	private TimerTimer freezeTimer;
	private int freezeTime = -1; // time frozen, in game ticks

	private int lastRaidVarb;
	private int lastWildernessVarb;
	private int lastVengCooldownVarb;
	private int lastIsVengeancedVarb;
	private int lastPoisonVarp;
	private int nextPoisonTick;
	private WorldPoint lastPoint;
	private TeleportWidget lastTeleportClicked;
	private int lastAnimation;
	private boolean loggedInRace;
	private boolean widgetHiddenChangedOnPvpWorld;
	private boolean skulledLastTick = false;
	private boolean imbuedHeartClicked;

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

	@Inject
	private EventBus eventBus;

	private boolean showHomeMinigameTeleports;
	private boolean showAntiPoison;
	private boolean showAntiFire;
	private boolean showStamina;
	private boolean showOverload;
	private boolean showPrayerEnhance;
	private boolean showCannon;
	private boolean showMagicImbue;
	private boolean showCharge;
	private boolean showImbuedHeart;
	private boolean showVengeance;
	private boolean showVengeanceActive;
	@Setter(AccessLevel.PACKAGE)
	private boolean showTeleblock;
	private boolean showFreezes;
	private boolean showGodWarsAltar;
	private boolean showSkull;
	private boolean showStaffOfTheDead;
	private boolean showAbyssalSireStun;
	private boolean showDivine;

	@Provides
	TimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TimersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		infoBoxManager.removeIf(t -> t instanceof TimerTimer);
		lastRaidVarb = -1;
		lastPoint = null;
		lastTeleportClicked = null;
		lastAnimation = -1;
		loggedInRace = false;
		widgetHiddenChangedOnPvpWorld = false;
		lastPoisonVarp = 0;
		nextPoisonTick = 0;
		imbuedHeartClicked = false;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(WidgetHiddenChanged.class, this, this::onWidgetHiddenChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(LocalPlayerDeath.class, this, this::onLocalPlayerDeath);
		eventBus.subscribe(BoostedLevelChanged.class, this, this::onBoostedLevelChanged);
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		int raidVarb = client.getVar(Varbits.IN_RAID);
		int vengCooldownVarb = client.getVar(Varbits.VENGEANCE_COOLDOWN);
		int isVengeancedVarb = client.getVar(Varbits.VENGEANCE_ACTIVE);
		int poisonVarp = client.getVar(VarPlayer.POISON);

		if (lastRaidVarb != raidVarb)
		{
			removeGameTimer(OVERLOAD_RAID);
			removeGameTimer(PRAYER_ENHANCE);
			lastRaidVarb = raidVarb;
		}

		if (lastVengCooldownVarb != vengCooldownVarb && this.showVengeance)
		{
			if (vengCooldownVarb == 1)
			{
				createGameTimer(VENGEANCE);
			}
			else
			{
				removeGameTimer(VENGEANCE);
			}

			lastVengCooldownVarb = vengCooldownVarb;
		}

		if (lastIsVengeancedVarb != isVengeancedVarb && this.showVengeanceActive)
		{
			if (isVengeancedVarb == 1)
			{
				createGameIndicator(VENGEANCE_ACTIVE);
			}
			else
			{
				removeGameIndicator(VENGEANCE_ACTIVE);
			}

			lastIsVengeancedVarb = isVengeancedVarb;
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

		if (lastPoisonVarp != poisonVarp && this.showAntiPoison)
		{
			if (nextPoisonTick - client.getTickCount() <= 0 || lastPoisonVarp == 0)
			{
				nextPoisonTick = client.getTickCount() + 30;
			}

			if (poisonVarp >= 0)
			{
				removeGameTimer(ANTIPOISON);
				removeGameTimer(ANTIVENOM);
			}
			else if (poisonVarp >= VENOM_VALUE_CUTOFF)
			{
				int duration = 600 * (nextPoisonTick - client.getTickCount() + Math.abs((poisonVarp + 1) * POISON_TICK_LENGTH));
				removeGameTimer(ANTIVENOM);
				createGameTimer(ANTIPOISON, duration);
			}
			else
			{
				int duration = 600 * (nextPoisonTick - client.getTickCount() + Math.abs((poisonVarp + 1 - VENOM_VALUE_CUTOFF) * POISON_TICK_LENGTH));
				removeGameTimer(ANTIPOISON);
				createGameTimer(ANTIVENOM, duration);
			}

			lastPoisonVarp = poisonVarp;
		}
	}

	private void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();
		if (WorldType.isPvpWorld(client.getWorldType())
			&& WidgetInfo.TO_GROUP(widget.getId()) == WidgetID.PVP_GROUP_ID)
		{
			widgetHiddenChangedOnPvpWorld = true;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("timers"))
		{
			return;
		}

		updateConfig();

		if (!this.showHomeMinigameTeleports)
		{
			removeGameTimer(HOME_TELEPORT);
			removeGameTimer(MINIGAME_TELEPORT);
		}

		if (!this.showAntiFire)
		{
			removeGameTimer(ANTIFIRE);
			removeGameTimer(EXANTIFIRE);
			removeGameTimer(SUPERANTIFIRE);
		}

		if (!this.showStamina)
		{
			removeGameTimer(STAMINA);
		}

		if (!this.showOverload)
		{
			removeGameTimer(OVERLOAD);
			removeGameTimer(OVERLOAD_RAID);
		}

		if (!this.showPrayerEnhance)
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (!this.showDivine)
		{
			removeGameTimer(DIVINE_SUPER_ATTACK);
			removeGameTimer(DIVINE_SUPER_STRENGTH);
			removeGameTimer(DIVINE_SUPER_DEFENCE);
			removeGameTimer(DIVINE_SUPER_COMBAT);
			removeGameTimer(DIVINE_RANGING);
			removeGameTimer(DIVINE_MAGIC);
		}

		if (!this.showCannon)
		{
			removeGameTimer(CANNON);
		}

		if (!this.showMagicImbue)
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (!this.showCharge)
		{
			removeGameTimer(CHARGE);
		}

		if (!this.showImbuedHeart)
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (!this.showStaffOfTheDead)
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (!this.showVengeance)
		{
			removeGameTimer(VENGEANCE);
		}

		if (!this.showVengeanceActive)
		{
			removeGameIndicator(VENGEANCE_ACTIVE);
		}

		if (!this.showTeleblock)
		{
			removeTbTimers();
		}

		if (!this.showFreezes)
		{
			removeGameTimer(BIND);
			removeGameTimer(SNARE);
			removeGameTimer(ENTANGLE);
			removeGameTimer(ICERUSH);
			removeGameTimer(ICEBURST);
			removeGameTimer(ICEBLITZ);
			removeGameTimer(ICEBARRAGE);
		}

		if (!config.showAntiPoison())
		{
			removeGameTimer(ANTIPOISON);
			removeGameTimer(ANTIVENOM);
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (this.showStamina
			&& event.getOption().contains("Drink")
			&& (event.getIdentifier() == ItemID.STAMINA_MIX1
			|| event.getIdentifier() == ItemID.STAMINA_MIX2
			|| event.getIdentifier() == ItemID.EGNIOL_POTION_1
			|| event.getIdentifier() == ItemID.EGNIOL_POTION_2
			|| event.getIdentifier() == ItemID.EGNIOL_POTION_3
			|| event.getIdentifier() == ItemID.EGNIOL_POTION_4))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(STAMINA);
			return;
		}

		if (this.showAntiFire
			&& event.getOption().contains("Drink")
			&& (event.getIdentifier() == ItemID.ANTIFIRE_MIX1
			|| event.getIdentifier() == ItemID.ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(ANTIFIRE);
			return;
		}

		if (this.showAntiFire
			&& event.getOption().contains("Drink")
			&& (event.getIdentifier() == ItemID.EXTENDED_ANTIFIRE_MIX1
			|| event.getIdentifier() == ItemID.EXTENDED_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(EXANTIFIRE);
			return;
		}

		if (this.showAntiFire
			&& event.getOption().contains("Drink")
			&& (event.getIdentifier() == ItemID.SUPER_ANTIFIRE_MIX1
			|| event.getIdentifier() == ItemID.SUPER_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(SUPERANTIFIRE);
			return;
		}

		if (this.showAntiFire
			&& event.getOption().contains("Drink")
			&& (event.getIdentifier() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX1
			|| event.getIdentifier() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(EXSUPERANTIFIRE);
			return;
		}

		TeleportWidget teleportWidget = TeleportWidget.of(event.getParam1());
		if (teleportWidget != null)
		{
			lastTeleportClicked = teleportWidget;
		}

		if (this.showImbuedHeart
			&& event.getOption().contains("Invigorate"))
		{
			// Needs a hook as there's a few cases where potions boost the same amount as the heart
			imbuedHeartClicked = true;
		}
	}

	void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (this.showStamina && (event.getMessage().equals(STAMINA_DRINK_MESSAGE) || event.getMessage().equals(STAMINA_SHARED_DRINK_MESSAGE)))
		{
			createGameTimer(STAMINA);
		}

		if (this.showStamina && event.getMessage().equals(STAMINA_EXPIRED_MESSAGE))
		{
			removeGameTimer(STAMINA);
		}

		if (this.showAntiFire && event.getMessage().equals(ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(ANTIFIRE);
		}

		if (this.showAntiFire && event.getMessage().equals(EXTENDED_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXANTIFIRE);
		}

		if (this.showGodWarsAltar && event.getMessage().equalsIgnoreCase(GOD_WARS_ALTAR_MESSAGE))//Normal altars are "You recharge your Prayer points." while gwd is "You recharge your Prayer."
		{
			createGameTimer(GOD_WARS_ALTAR);
		}

		if (this.showAntiFire && event.getMessage().equals(EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXSUPERANTIFIRE);
		}

		if (this.showAntiFire && event.getMessage().equals(ANTIFIRE_EXPIRED_MESSAGE))
		{
			//they have the same expired message
			removeGameTimer(ANTIFIRE);
			removeGameTimer(EXANTIFIRE);
		}

		if (this.showOverload && event.getMessage().startsWith("You drink some of your") && event.getMessage().contains("overload"))
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

		if (this.showCannon && (event.getMessage().equals(CANNON_FURNACE_MESSAGE) || event.getMessage().contains(CANNON_REPAIR_MESSAGE)))
		{
			createGameTimer(CANNON);
		}

		if (this.showCannon && event.getMessage().equals(CANNON_PICKUP_MESSAGE))
		{
			removeGameTimer(CANNON);
		}

		if (this.showMagicImbue && event.getMessage().equals(MAGIC_IMBUE_MESSAGE))
		{
			createGameTimer(MAGICIMBUE);
		}

		if (event.getMessage().equals(MAGIC_IMBUE_EXPIRED_MESSAGE))
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (this.showTeleblock)
		{
			if (FULL_TELEBLOCK_PATTERN.matcher(event.getMessage()).find())
			{
				createGameTimer(FULLTB);
			}
			else if (HALF_TELEBLOCK_PATTERN.matcher(event.getMessage()).find())
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
			else if (DEADMAN_HALF_TELEBLOCK_PATTERN.matcher(event.getMessage()).find())
			{
				createGameTimer(DMM_HALFTB);
			}
			else if (event.getMessage().startsWith(KILLED_TELEBLOCK_OPPONENT_TEXT))
			{
				removeTbTimers();
			}
		}

		if (this.showAntiFire && event.getMessage().contains(SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(SUPERANTIFIRE);
		}

		if (this.showAntiFire && event.getMessage().equals(SUPER_ANTIFIRE_EXPIRED_MESSAGE))
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (this.showImbuedHeart && event.getMessage().contains(IMBUED_HEART_NOTREADY_MESSAGE))
		{
			imbuedHeartClicked = false;
			return;
		}

		if (this.showImbuedHeart && event.getMessage().equals(IMBUED_HEART_READY_MESSAGE))
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (this.showPrayerEnhance && event.getMessage().startsWith("You drink some of your") && event.getMessage().contains("prayer enhance"))
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (this.showPrayerEnhance && event.getMessage().equals(PRAYER_ENHANCE_EXPIRED))
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (this.showCharge && event.getMessage().equals(CHARGE_MESSAGE))
		{
			createGameTimer(CHARGE);
		}

		if (this.showCharge && event.getMessage().equals(CHARGE_EXPIRED_MESSAGE))
		{
			removeGameTimer(CHARGE);
		}

		if (this.showStaffOfTheDead && event.getMessage().contains(STAFF_OF_THE_DEAD_SPEC_MESSAGE))
		{
			createGameTimer(STAFF_OF_THE_DEAD);
		}

		if (this.showStaffOfTheDead && event.getMessage().contains(STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE))
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (this.showFreezes && event.getMessage().equals(FROZEN_MESSAGE))
		{
			freezeTimer = createGameTimer(ICEBARRAGE);
			freezeTime = client.getTickCount();
		}

		if (config.showDivine())
		{
			Matcher mDivine = DIVINE_POTION_PATTERN.matcher(event.getMessage());
			if (mDivine.find())
			{
				switch (mDivine.group(1))
				{
					case "super attack":
						createGameTimer(DIVINE_SUPER_ATTACK);
						break;

					case "super strength":
						createGameTimer(DIVINE_SUPER_STRENGTH);
						break;

					case "super defence":
						createGameTimer(DIVINE_SUPER_DEFENCE);
						break;

					case "combat":
						createGameTimer(DIVINE_SUPER_COMBAT);
						break;

					case "ranging":
						createGameTimer(DIVINE_RANGING);
						break;

					case "magic":
						createGameTimer(DIVINE_MAGIC);
						break;
				}
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		loggedInRace = false;

		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return;
		}

		WorldPoint currentWorldPoint = player.getWorldLocation();

		final boolean isSkulled = player.getSkullIcon() != null && player.getSkullIcon() != SkullIcon.SKULL_FIGHT_PIT;

		if (isSkulled != skulledLastTick && this.showSkull)
		{
			skulledLastTick = isSkulled;
			if (isSkulled)
			{
				createGameTimer(SKULL);
			}
			else
			{
				removeGameTimer(SKULL);
			}
		}

		if (freezeTimer != null &&
			// assume movement means unfrozen
			freezeTime != client.getTickCount()
			&& !currentWorldPoint.equals(lastPoint))
		{
			removeGameTimer(freezeTimer.getTimer());
			freezeTimer = null;
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

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				removeTbTimers();
				break;
			case LOGGED_IN:
				loggedInRace = true;
				break;
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();

		if (this.showAbyssalSireStun
			&& actor instanceof NPC)
		{
			int npcId = ((NPC) actor).getId();

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

		Player player = client.getLocalPlayer();

		if (player == null || actor != player)
		{
			return;
		}

		if (this.showHomeMinigameTeleports
			&& player.getAnimation() == AnimationID.IDLE
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

		if (config.showDFSSpecial() && lastAnimation == AnimationID.DRAGONFIRE_SHIELD_SPECIAL)
		{
			createGameTimer(DRAGON_FIRE_SHIELD);
		}

		lastAnimation = player.getAnimation();
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		Actor actor = event.getActor();
		Player player = client.getLocalPlayer();

		if (player == null || actor != client.getLocalPlayer())
		{
			return;
		}

		if (this.showImbuedHeart && actor.getSpotAnimation() == IMBUEDHEART.getGraphicId())
		{
			createGameTimer(IMBUEDHEART);
		}

		if (this.showFreezes)
		{
			if (actor.getSpotAnimation() == BIND.getGraphicId())
			{
				createGameTimer(BIND);
			}

			if (actor.getSpotAnimation() == SNARE.getGraphicId())
			{
				createGameTimer(SNARE);
			}

			if (actor.getSpotAnimation() == ENTANGLE.getGraphicId())
			{
				createGameTimer(ENTANGLE);
			}

			// downgrade freeze based on graphic, if at the same tick as the freeze message
			if (freezeTime == client.getTickCount())
			{
				if (actor.getSpotAnimation() == ICERUSH.getGraphicId())
				{
					removeGameTimer(ICEBARRAGE);
					freezeTimer = createGameTimer(ICERUSH);
				}

				if (actor.getSpotAnimation() == ICEBURST.getGraphicId())
				{
					removeGameTimer(ICEBARRAGE);
					freezeTimer = createGameTimer(ICEBURST);
				}

				if (actor.getSpotAnimation() == ICEBLITZ.getGraphicId())
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
	private void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
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

	private void onNpcDespawned(NpcDespawned npcDespawned)
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

	private void onLocalPlayerDeath(LocalPlayerDeath event)
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer().isRemovedOnDeath());
	}

	private void onBoostedLevelChanged(BoostedLevelChanged event)
	{
		Skill skill = event.getSkill();

		if (skill != Skill.MAGIC || !this.showImbuedHeart || !imbuedHeartClicked)
		{
			return;
		}

		int magicLvl = client.getRealSkillLevel(skill);
		int magicBoost = client.getBoostedSkillLevel(skill);
		int heartBoost = 1 + (int) (magicLvl * 0.1);

		if (magicBoost - magicLvl != heartBoost)
		{
			return;
		}

		imbuedHeartClicked = false;
		createGameTimer(IMBUEDHEART);
	}

	private TimerTimer createGameTimer(final GameTimer timer)
	{
		removeGameTimer(timer);

		TimerTimer t = new TimerTimer(timer, this);
		switch (timer.getImageType())
		{
			case SPRITE:
				spriteManager.getSpriteAsync(timer.getImageId(), 0, t);
				break;
			case ITEM:
				t.setImage(itemManager.getImage(timer.getImageId()));
				break;
		}
		t.setTooltip(timer.getDescription());
		infoBoxManager.addInfoBox(t);
		return t;
	}

	private TimerTimer createGameTimer(final GameTimer timer, final int duration)
	{
		removeGameTimer(timer);

		TimerTimer t = new TimerTimer(timer, duration, this);
		switch (timer.getImageType())
		{
			case SPRITE:
				spriteManager.getSpriteAsync(timer.getImageId(), 0, t);
				break;
			case ITEM:
				t.setImage(itemManager.getImage(timer.getImageId()));
				break;
		}
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

		IndicatorIndicator indicator = new IndicatorIndicator(gameIndicator, this);
		switch (gameIndicator.getImageType())
		{
			case SPRITE:
				spriteManager.getSpriteAsync(gameIndicator.getImageId(), 0, indicator);
				break;
			case ITEM:
				indicator.setImage(itemManager.getImage(gameIndicator.getImageId()));
				break;
		}
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

	private void updateConfig()
	{
		this.showHomeMinigameTeleports = config.showHomeMinigameTeleports();
		this.showAntiPoison = config.showAntiPoison();
		this.showAntiFire = config.showAntiFire();
		this.showStamina = config.showStamina();
		this.showOverload = config.showOverload();
		this.showPrayerEnhance = config.showPrayerEnhance();
		this.showCannon = config.showCannon();
		this.showMagicImbue = config.showMagicImbue();
		this.showCharge = config.showCharge();
		this.showImbuedHeart = config.showImbuedHeart();
		this.showVengeance = config.showVengeance();
		this.showVengeanceActive = config.showVengeanceActive();
		this.showTeleblock = config.showTeleblock();
		this.showFreezes = config.showFreezes();
		this.showGodWarsAltar = config.showGodWarsAltar();
		this.showSkull = config.showSkull();
		this.showStaffOfTheDead = config.showStaffOfTheDead();
		this.showAbyssalSireStun = config.showAbyssalSireStun();
		this.showDivine = config.showDivine();
	}
}