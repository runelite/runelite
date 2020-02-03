/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, winterdaze
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
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.FIRE_CAPE;
import static net.runelite.api.ItemID.INFERNAL_CAPE;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetInfo.PVP_WORLD_SAFE_ZONE;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.timers.GameIndicator.VENGEANCE_ACTIVE;
import static net.runelite.client.plugins.timers.GameTimer.*;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Timers",
	description = "Show various timers in an infobox",
	tags = {"combat", "items", "magic", "potions", "prayer", "overlay", "abyssal", "sire", "inferno", "fight", "caves", "cape", "timer", "tzhaar"}
)
@Slf4j
public class TimersPlugin extends Plugin
{
	private static final String ABYSSAL_SIRE_STUN_MESSAGE = "The Sire has been disorientated temporarily.";
	private static final String ANTIFIRE_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your antifire potion has expired.</col>";
	private static final String CANNON_FURNACE_MESSAGE = "You add the furnace.";
	private static final String CANNON_PICKUP_MESSAGE = "You pick up the cannon. It's really heavy.";
	private static final String CANNON_REPAIR_MESSAGE = "You repair your cannon, restoring it to working order.";
	private static final String CANNON_DESTROYED_MESSAGE = "Your cannon has been destroyed!";
	private static final String CHARGE_EXPIRED_MESSAGE = "<col=ef1020>Your magical charge fades away.</col>";
	private static final String CHARGE_MESSAGE = "<col=ef1020>You feel charged with magic power.</col>";
	private static final String EXTENDED_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String FROZEN_MESSAGE = "<col=ef1020>You have been frozen!</col>";
	private static final String GAUNTLET_ENTER_MESSAGE = "You enter the Gauntlet.";
	private static final String GOD_WARS_ALTAR_MESSAGE = "you recharge your prayer.";
	private static final String IMBUED_HEART_READY_MESSAGE = "<col=ef1020>Your imbued heart has regained its magical power.</col>";
	private static final String MAGIC_IMBUE_EXPIRED_MESSAGE = "Your Magic Imbue charge has ended.";
	private static final String MAGIC_IMBUE_MESSAGE = "You are charged to combine runes!";
	private static final String STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE = "Your protection fades away";
	private static final String STAFF_OF_THE_DEAD_SPEC_MESSAGE = "Spirits of deceased evildoers offer you their protection";
	private static final String STAMINA_DRINK_MESSAGE = "You drink some of your stamina potion.";
	private static final String STAMINA_SHARED_DRINK_MESSAGE = "You have received a shared dose of stamina potion.";
	private static final String STAMINA_EXPIRED_MESSAGE = "<col=8f4808>Your stamina potion has expired.</col>";
	private static final String SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your super antifire potion";
	private static final String SUPER_ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your super antifire potion has expired.</col>";
	private static final String KILLED_TELEBLOCK_OPPONENT_TEXT = "Your Tele Block has been removed because you killed ";
	private static final String PRAYER_ENHANCE_EXPIRED = "<col=ff0000>Your prayer enhance effect has worn off.</col>";
	private static final String ENDURANCE_EFFECT_MESSAGE = "Your Ring of endurance doubles the duration of your stamina potion's effect.";

	private static final Pattern TELEBLOCK_PATTERN = Pattern.compile("A Tele Block spell has been cast on you(?: by .+)?\\. It will expire in (?<mins>\\d+) minutes?(?:, (?<secs>\\d+) seconds?)?\\.");
	private static final Pattern DIVINE_POTION_PATTERN = Pattern.compile("You drink some of your divine (.+) potion\\.");
	private static final int VENOM_VALUE_CUTOFF = -40; // Antivenom < -40 <= Antipoison < 0
	private static final int POISON_TICK_LENGTH = 30;

	static final int FIGHT_CAVES_REGION_ID = 9551;
	static final int INFERNO_REGION_ID = 9043;
	private static final int NMZ_MAP_REGION_ID = 9033;
	private static final Pattern TZHAAR_WAVE_MESSAGE = Pattern.compile("Wave: (\\d+)");
	private static final String TZHAAR_DEFEATED_MESSAGE = "You have been defeated!";
	private static final Pattern TZHAAR_COMPLETE_MESSAGE = Pattern.compile("Your (?:TzTok-Jad|TzKal-Zuk) kill count is:");
	private static final Pattern TZHAAR_PAUSED_MESSAGE = Pattern.compile("The (?:Inferno|Fight Cave) has been paused. You may now log out.");

	private TimerTimer freezeTimer;
	private int freezeTime = -1; // time frozen, in game ticks

	private TimerTimer staminaTimer;
	private boolean wasWearingEndurance;

	private int lastRaidVarb;
	private int lastVengCooldownVarb;
	private int lastIsVengeancedVarb;
	private int lastPoisonVarp;
	private int lastPvpVarb;
	private int nextPoisonTick;
	private WorldPoint lastPoint;
	private TeleportWidget lastTeleportClicked;
	private int lastAnimation;
	private boolean widgetHiddenChangedOnPvpWorld;
	private ElapsedTimer tzhaarTimer;
	private int imbuedHeartClickTick = -1;
	private int lastBoostedMagicLevel = -1;

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
	public void startUp()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			lastBoostedMagicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer);
		lastRaidVarb = -1;
		lastPoint = null;
		lastTeleportClicked = null;
		lastAnimation = -1;
		widgetHiddenChangedOnPvpWorld = false;
		lastPoisonVarp = 0;
		nextPoisonTick = 0;
		removeTzhaarTimer();
		staminaTimer = null;
		imbuedHeartClickTick = -1;
		lastBoostedMagicLevel = -1;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int raidVarb = client.getVar(Varbits.IN_RAID);
		int vengCooldownVarb = client.getVar(Varbits.VENGEANCE_COOLDOWN);
		int isVengeancedVarb = client.getVar(Varbits.VENGEANCE_ACTIVE);
		int poisonVarp = client.getVar(VarPlayer.POISON);
		int pvpVarb = client.getVar(Varbits.PVP_SPEC_ORB);

		if (lastRaidVarb != raidVarb)
		{
			removeGameTimer(OVERLOAD_RAID);
			removeGameTimer(PRAYER_ENHANCE);
			lastRaidVarb = raidVarb;
		}

		if (lastVengCooldownVarb != vengCooldownVarb && config.showVengeance())
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

		if (lastIsVengeancedVarb != isVengeancedVarb && config.showVengeanceActive())
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

		if (lastPoisonVarp != poisonVarp && config.showAntiPoison())
		{
			final int tickCount = client.getTickCount();

			if (nextPoisonTick - tickCount <= 0 || lastPoisonVarp == 0)
			{
				nextPoisonTick = tickCount + POISON_TICK_LENGTH;
			}

			if (poisonVarp >= 0)
			{
				removeGameTimer(ANTIPOISON);
				removeGameTimer(ANTIVENOM);
			}
			else if (poisonVarp >= VENOM_VALUE_CUTOFF)
			{
				Duration duration = Duration.ofMillis((long) Constants.GAME_TICK_LENGTH * (nextPoisonTick - tickCount + Math.abs((poisonVarp + 1) * POISON_TICK_LENGTH)));
				removeGameTimer(ANTIVENOM);
				createGameTimer(ANTIPOISON, duration);
			}
			else
			{
				Duration duration = Duration.ofMillis((long) Constants.GAME_TICK_LENGTH * (nextPoisonTick - tickCount + Math.abs((poisonVarp + 1 - VENOM_VALUE_CUTOFF) * POISON_TICK_LENGTH)));
				removeGameTimer(ANTIPOISON);
				createGameTimer(ANTIVENOM, duration);
			}

			lastPoisonVarp = poisonVarp;
		}

		if (lastPvpVarb != pvpVarb)
		{
			if (pvpVarb == 0)
			{
				log.debug("Left a PVP zone, clearing teleblock timer");
				removeGameTimer(TELEBLOCK);
			}

			lastPvpVarb = pvpVarb;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(TimersConfig.GROUP))
		{
			return;
		}

		if (!config.showHomeMinigameTeleports())
		{
			removeGameTimer(HOME_TELEPORT);
			removeGameTimer(MINIGAME_TELEPORT);
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

		if (!config.showDivine())
		{
			removeGameTimer(DIVINE_SUPER_ATTACK);
			removeGameTimer(DIVINE_SUPER_STRENGTH);
			removeGameTimer(DIVINE_SUPER_DEFENCE);
			removeGameTimer(DIVINE_SUPER_COMBAT);
			removeGameTimer(DIVINE_RANGING);
			removeGameTimer(DIVINE_MAGIC);
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

		if (!config.showVengeanceActive())
		{
			removeGameIndicator(VENGEANCE_ACTIVE);
		}

		if (!config.showTeleblock())
		{
			removeGameTimer(TELEBLOCK);
		}

		if (!config.showFreezes())
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

		if (!config.showTzhaarTimers())
		{
			removeTzhaarTimer();
		}
		else
		{
			createTzhaarTimer();
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (config.showStamina()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.STAMINA_MIX1
			|| event.getId() == ItemID.STAMINA_MIX2
			|| event.getId() == ItemID.EGNIOL_POTION_1
			|| event.getId() == ItemID.EGNIOL_POTION_2
			|| event.getId() == ItemID.EGNIOL_POTION_3
			|| event.getId() == ItemID.EGNIOL_POTION_4))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createStaminaTimer();
			return;
		}

		if (config.showAntiFire()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.ANTIFIRE_MIX1
			|| event.getId() == ItemID.ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(ANTIFIRE);
			return;
		}

		if (config.showAntiFire()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.EXTENDED_ANTIFIRE_MIX1
			|| event.getId() == ItemID.EXTENDED_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(EXANTIFIRE);
			return;
		}

		if (config.showAntiFire()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.SUPER_ANTIFIRE_MIX1
			|| event.getId() == ItemID.SUPER_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(SUPERANTIFIRE);
			return;
		}

		if (config.showAntiFire()
			&& event.getMenuOption().contains("Drink")
			&& (event.getId() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX1
			|| event.getId() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX2))
		{
			// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
			createGameTimer(EXSUPERANTIFIRE);
			return;
		}

		if (event.getMenuOption().contains("Invigorate")
			&& event.getId() == ItemID.IMBUED_HEART)
		{
			imbuedHeartClickTick = client.getTickCount();
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
		final String message = event.getMessage();
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (message.equals(ABYSSAL_SIRE_STUN_MESSAGE) && config.showAbyssalSireStun())
		{
			createGameTimer(ABYSSAL_SIRE_STUN);
		}

		if (message.equals(ENDURANCE_EFFECT_MESSAGE))
		{
			wasWearingEndurance = true;
		}

		if (config.showStamina() && (message.equals(STAMINA_DRINK_MESSAGE) || message.equals(STAMINA_SHARED_DRINK_MESSAGE)))
		{
			createStaminaTimer();
		}

		if (message.equals(STAMINA_EXPIRED_MESSAGE) || message.equals(GAUNTLET_ENTER_MESSAGE))
		{
			removeGameTimer(STAMINA);
			staminaTimer = null;
		}

		if (config.showAntiFire() && message.equals(ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(ANTIFIRE);
		}

		if (config.showAntiFire() && message.equals(EXTENDED_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXANTIFIRE);
		}

		if (config.showGodWarsAltar() && message.equalsIgnoreCase(GOD_WARS_ALTAR_MESSAGE))//Normal altars are "You recharge your Prayer points." while gwd is "You recharge your Prayer."
		{
			createGameTimer(GOD_WARS_ALTAR);
		}

		if (config.showAntiFire() && message.equals(EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(EXSUPERANTIFIRE);
		}

		if (config.showAntiFire() && message.equals(ANTIFIRE_EXPIRED_MESSAGE))
		{
			//they have the same expired message
			removeGameTimer(ANTIFIRE);
			removeGameTimer(EXANTIFIRE);
		}

		if (config.showOverload() && message.startsWith("You drink some of your") && message.contains("overload"))
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

		if (config.showCannon() && (message.equals(CANNON_FURNACE_MESSAGE) || message.contains(CANNON_REPAIR_MESSAGE)))
		{
			TimerTimer cannonTimer = createGameTimer(CANNON);
			cannonTimer.setTooltip(cannonTimer.getTooltip() + " - World " + client.getWorld());
		}

		if (config.showCannon() && (message.equals(CANNON_PICKUP_MESSAGE) || message.equals(CANNON_DESTROYED_MESSAGE)))
		{
			removeGameTimer(CANNON);
		}

		if (config.showMagicImbue() && message.equals(MAGIC_IMBUE_MESSAGE))
		{
			createGameTimer(MAGICIMBUE);
		}

		if (message.equals(MAGIC_IMBUE_EXPIRED_MESSAGE))
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (config.showTeleblock())
		{
			Matcher m = TELEBLOCK_PATTERN.matcher(message);
			if (m.find())
			{
				String minss = m.group("mins");
				String secss = m.group("secs");
				int mins = Integer.parseInt(minss);
				int secs = secss != null ? Integer.parseInt(secss) : 0;
				createGameTimer(TELEBLOCK, Duration.ofSeconds(mins * 60 + secs));
			}
			else if (message.contains(KILLED_TELEBLOCK_OPPONENT_TEXT))
			{
				removeGameTimer(TELEBLOCK);
			}
		}

		if (config.showAntiFire() && message.contains(SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(SUPERANTIFIRE);
		}

		if (config.showAntiFire() && message.equals(SUPER_ANTIFIRE_EXPIRED_MESSAGE))
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (config.showImbuedHeart() && message.equals(IMBUED_HEART_READY_MESSAGE))
		{
			removeGameTimer(IMBUEDHEART);
		}

		if (config.showPrayerEnhance() && message.startsWith("You drink some of your") && message.contains("prayer enhance"))
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (config.showPrayerEnhance() && message.equals(PRAYER_ENHANCE_EXPIRED))
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (config.showCharge() && message.equals(CHARGE_MESSAGE))
		{
			createGameTimer(CHARGE);
		}

		if (config.showCharge() && message.equals(CHARGE_EXPIRED_MESSAGE))
		{
			removeGameTimer(CHARGE);
		}

		if (config.showStaffOfTheDead() && message.contains(STAFF_OF_THE_DEAD_SPEC_MESSAGE))
		{
			createGameTimer(STAFF_OF_THE_DEAD);
		}

		if (config.showStaffOfTheDead() && message.contains(STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE))
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (config.showFreezes() && message.equals(FROZEN_MESSAGE))
		{
			freezeTimer = createGameTimer(ICEBARRAGE);
			freezeTime = client.getTickCount();
		}

		if (config.showDivine())
		{
			Matcher mDivine = DIVINE_POTION_PATTERN.matcher(message);
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

					case "bastion":
						createGameTimer(DIVINE_BASTION);
						break;

					case "battlemage":
						createGameTimer(DIVINE_BATTLEMAGE);
						break;
				}
			}
		}

		if (message.equals(TZHAAR_DEFEATED_MESSAGE) || TZHAAR_COMPLETE_MESSAGE.matcher(message).matches())
		{
			log.debug("Stopping tzhaar timer");
			removeTzhaarTimer();
			config.tzhaarStartTime(null);
			config.tzhaarLastTime(null);
			return;
		}

		if (TZHAAR_PAUSED_MESSAGE.matcher(message).find())
		{
			log.debug("Pausing tzhaar timer");
			config.tzhaarLastTime(Instant.now());
			if (config.showTzhaarTimers())
			{
				createTzhaarTimer();
			}
			return;
		}

		Matcher matcher = TZHAAR_WAVE_MESSAGE.matcher(message);
		if (matcher.find())
		{
			int wave = Integer.parseInt(matcher.group(1));
			if (wave == 1)
			{
				log.debug("Starting tzhaar timer");

				Instant now = Instant.now();
				if (isInInferno())
				{
					// The first wave message of the inferno comes six seconds after the ingame timer starts counting
					config.tzhaarStartTime(now.minus(Duration.ofSeconds(6)));
				}
				else
				{
					config.tzhaarStartTime(now);
				}
				config.tzhaarLastTime(null);

				if (config.showTzhaarTimers())
				{
					createTzhaarTimer();
				}
			}
			else if (config.tzhaarStartTime() != null && config.tzhaarLastTime() != null)
			{
				log.debug("Unpausing tzhaar timer");

				// Advance start time by how long it has been paused
				Instant tzhaarStartTime = config.tzhaarStartTime();
				tzhaarStartTime = tzhaarStartTime.plus(Duration.between(config.tzhaarLastTime(), Instant.now()));
				config.tzhaarStartTime(tzhaarStartTime);

				config.tzhaarLastTime(null);
				if (config.showTzhaarTimers())
				{
					createTzhaarTimer();
				}
			}
		}
	}

	private boolean isInFightCaves()
	{
		return client.getMapRegions() != null && ArrayUtils.contains(client.getMapRegions(), FIGHT_CAVES_REGION_ID);
	}

	private boolean isInInferno()
	{
		return client.getMapRegions() != null && ArrayUtils.contains(client.getMapRegions(), INFERNO_REGION_ID);
	}

	private boolean isInNightmareZone()
	{
		return client.getLocalPlayer() != null && client.getLocalPlayer().getWorldLocation().getPlane() > 0 && ArrayUtils.contains(client.getMapRegions(), NMZ_MAP_REGION_ID);
	}

	private void createTzhaarTimer()
	{
		removeTzhaarTimer();

		int imageItem = isInFightCaves() ? FIRE_CAPE : (isInInferno() ? INFERNAL_CAPE : -1);
		if (imageItem == -1)
		{
			return;
		}

		tzhaarTimer = new ElapsedTimer(itemManager.getImage(imageItem), this, config.tzhaarStartTime(), config.tzhaarLastTime());
		infoBoxManager.addInfoBox(tzhaarTimer);
	}

	private void removeTzhaarTimer()
	{
		if (tzhaarTimer != null)
		{
			infoBoxManager.removeInfoBox(tzhaarTimer);
			tzhaarTimer = null;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
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
		if (widget != null && !widget.isSelfHidden())
		{
			log.debug("Entered safe zone in PVP world, clearing Teleblock timer.");
			removeGameTimer(TELEBLOCK);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case LOADING:
				if (!isInNightmareZone())
				{
					removeGameTimer(OVERLOAD);
				}

				if (tzhaarTimer != null && !isInFightCaves() && !isInInferno())
				{
					removeTzhaarTimer();
					config.tzhaarStartTime(null);
					config.tzhaarLastTime(null);
				}
				break;
			case LOGIN_SCREEN:
				lastBoostedMagicLevel = -1;
				// fall through
			case HOPPING:
				// pause tzhaar timer if logged out without pausing
				if (config.tzhaarStartTime() != null && config.tzhaarLastTime() == null)
				{
					config.tzhaarLastTime(Instant.now());
					log.debug("Pausing tzhaar timer");
				}

				removeTzhaarTimer(); // will be readded by the wave message
				removeGameTimer(TELEBLOCK);
				break;
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

		if (config.showHomeMinigameTeleports()
			&& client.getLocalPlayer().getAnimation() == AnimationID.IDLE
			&& (lastAnimation == AnimationID.BOOK_HOME_TELEPORT_5
			|| lastAnimation == AnimationID.COW_HOME_TELEPORT_6
			|| lastAnimation == AnimationID.LEAGUE_HOME_TELEPORT_6))
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

		lastAnimation = client.getLocalPlayer().getAnimation();
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (config.showFreezes())
		{
			if (actor.getGraphic() == BIND.getGraphicId())
			{
				createGameTimer(BIND);
			}

			if (actor.getGraphic() == SNARE.getGraphicId())
			{
				createGameTimer(SNARE);
			}

			if (actor.getGraphic() == ENTANGLE.getGraphicId())
			{
				createGameTimer(ENTANGLE);
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
	 * Remove SOTD timer and update stamina timer when equipment is changed.
	 */
	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
	{
		if (itemContainerChanged.getContainerId() != InventoryID.EQUIPMENT.getId())
		{
			return;
		}

		ItemContainer container = itemContainerChanged.getItemContainer();

		Item weapon = container.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx());
		if (weapon == null ||
			(weapon.getId() != ItemID.STAFF_OF_THE_DEAD &&
				weapon.getId() != ItemID.TOXIC_STAFF_OF_THE_DEAD &&
				weapon.getId() != ItemID.STAFF_OF_LIGHT &&
				weapon.getId() != ItemID.TOXIC_STAFF_UNCHARGED))
		{
			// remove sotd timer if the staff has been unwielded
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (wasWearingEndurance)
		{
			Item ring = container.getItem(EquipmentInventorySlot.RING.getSlotIdx());

			// when using the last ring charge the ring changes to the uncharged version, ignore that and don't
			// halve the timer
			if (ring == null || (ring.getId() != ItemID.RING_OF_ENDURANCE && ring.getId() != ItemID.RING_OF_ENDURANCE_UNCHARGED_24844))
			{
				wasWearingEndurance = false;
				if (staminaTimer != null)
				{
					// Remaining duration gets divided by 2
					Duration remainingDuration = Duration.between(Instant.now(), staminaTimer.getEndTime()).dividedBy(2);
					// This relies on the chat message to be removed, which could be after the timer has been culled;
					// so check there is still remaining time
					if (!remainingDuration.isNegative() && !remainingDuration.isZero())
					{
						log.debug("Halving stamina timer");
						staminaTimer.setDuration(remainingDuration);
					}
				}
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
	public void onActorDeath(ActorDeath actorDeath)
	{
		if (actorDeath.getActor() == client.getLocalPlayer())
		{
			infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer().isRemovedOnDeath());
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() != Skill.MAGIC)
		{
			return;
		}

		final int boostedMagicLevel = statChanged.getBoostedLevel();

		if (imbuedHeartClickTick < 0
			|| client.getTickCount() > imbuedHeartClickTick + 3 // allow for 2 ticks of lag
			|| !config.showImbuedHeart())
		{
			lastBoostedMagicLevel = boostedMagicLevel;
			return;
		}

		final int boostAmount = boostedMagicLevel - statChanged.getLevel();
		final int boostChange = boostedMagicLevel - lastBoostedMagicLevel;
		final int heartBoost = 1 + (statChanged.getLevel() / 10);

		if ((boostAmount == heartBoost || (lastBoostedMagicLevel != -1 && boostChange == heartBoost))
			&& boostChange > 0)
		{
			createGameTimer(IMBUEDHEART);
		}

		lastBoostedMagicLevel = boostedMagicLevel;
	}

	private void createStaminaTimer()
	{
		Duration duration = Duration.ofMinutes(wasWearingEndurance ? 4 : 2);
		staminaTimer = createGameTimer(STAMINA, duration);
	}

	private TimerTimer createGameTimer(final GameTimer timer)
	{
		if (timer.getDuration() == null)
		{
			throw new IllegalArgumentException("Timer with no duration");
		}
		return createGameTimer(timer, timer.getDuration());
	}

	private TimerTimer createGameTimer(final GameTimer timer, Duration duration)
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
}
