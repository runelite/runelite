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
package net.runelite.client.plugins.timersandbuffs;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
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
import static net.runelite.api.VarPlayer.LAST_HOME_TELEPORT;
import static net.runelite.api.VarPlayer.LAST_MINIGAME_TELEPORT;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varp;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.timersandbuffs.GameCounter.*;
import static net.runelite.client.plugins.timersandbuffs.GameTimer.*;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.RSTimeUnit;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Timers & Buffs",
	configName = "TimersPlugin",
	description = "Show various timers and buffs in an infobox",
	tags = {"combat", "items", "magic", "potions", "prayer", "overlay", "abyssal", "sire", "inferno", "fight", "caves", "cape", "timer", "tzhaar", "thieving", "pickpocket", "hunter", "impling", "puro", "buff"}
)
@Slf4j
public class TimersAndBuffsPlugin extends Plugin
{
	private static final String ABYSSAL_SIRE_STUN_MESSAGE = "The Sire has been disorientated temporarily.";
	private static final String CANNON_BASE_MESSAGE = "You place the cannon base on the ground.";
	private static final String CANNON_STAND_MESSAGE = "You add the stand.";
	private static final String CANNON_BARRELS_MESSAGE = "You add the barrels.";
	private static final String CANNON_FURNACE_MESSAGE = "You add the furnace.";
	private static final String CANNON_PICKUP_MESSAGE = "You pick up the cannon. It's really heavy.";
	private static final String CANNON_REPAIR_MESSAGE = "You repair your cannon, restoring it to working order.";
	private static final String CANNON_DESTROYED_MESSAGE = "Your cannon has been destroyed!";
	private static final String CANNON_BROKEN_MESSAGE = "<col=ef1020>Your cannon has broken!";
	private static final String FROZEN_MESSAGE = "<col=ef1020>You have been frozen!</col>";
	private static final String STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE = "Your protection fades away";
	private static final String STAFF_OF_THE_DEAD_SPEC_MESSAGE = "Spirits of deceased evildoers offer you their protection";
	private static final String PRAYER_ENHANCE_EXPIRED = "<col=ff0000>Your prayer enhance effect has worn off.</col>";
	private static final String SHADOW_VEIL_MESSAGE = ">Your thieving abilities have been enhanced.</col>";
	private static final String RESURRECT_THRALL_MESSAGE_START = ">You resurrect a ";
	private static final String RESURRECT_THRALL_MESSAGE_END = " thrall.</col>";
	private static final String WARD_OF_ARCEUUS_MESSAGE = ">Your defence against Arceuus magic has been strengthened.</col>";
	private static final String MARK_OF_DARKNESS_MESSAGE = "You have placed a Mark of Darkness upon yourself.</col>";
	private static final String PICKPOCKET_FAILURE_MESSAGE = "You fail to pick ";
	private static final String DODGY_NECKLACE_PROTECTION_MESSAGE = "Your dodgy necklace protects you.";
	private static final String SHADOW_VEIL_PROTECTION_MESSAGE = "Your attempt to steal goes unnoticed.";
	private static final String SILK_DRESSING_MESSAGE = "You quickly apply the dressing to your wounds.";
	private static final String BLESSED_CRYSTAL_SCARAB_MESSAGE = "You crack the crystal in your hand.";
	private static final String LIQUID_ADRENALINE_MESSAGE = "You drink some of the potion, reducing the energy cost of your special attacks.</col>";
	private static final Set<Integer> STAVES_OF_THE_DEAD = new ImmutableSet.Builder<Integer>()
		.addAll(ItemVariationMapping.getVariations(ItemID.STAFF_OF_THE_DEAD))
		.addAll(ItemVariationMapping.getVariations(ItemID.TOXIC_STAFF_UNCHARGED))
		.add(ItemID.STAFF_OF_LIGHT)
		.add(ItemID.STAFF_OF_BALANCE)
		.build();

	private static final int VENOM_VALUE_CUTOFF = -38; // Antivenom < -38 <= Antipoison < 0
	private static final int POISON_TICK_LENGTH = 30;
	private static final int OVERLOAD_TICK_LENGTH = 25;
	private static final int ANTIFIRE_TICK_LENGTH = 30;
	private static final int SUPERANTIFIRE_TICK_LENGTH = 20;

	static final int FIGHT_CAVES_REGION_ID = 9551;
	static final int INFERNO_REGION_ID = 9043;
	private static final Pattern TZHAAR_WAVE_MESSAGE = Pattern.compile("Wave: (\\d+)");
	private static final Pattern TZHAAR_PAUSED_MESSAGE = Pattern.compile("The (?:Inferno|Fight Cave) has been paused. You may now log out.");

	private TimerTimer freezeTimer;
	private int freezeTime = -1; // time frozen, in game ticks

	private final Map<GameTimer, TimerTimer> varTimers = new EnumMap<>(GameTimer.class);

	private int nextPoisonTick;
	private int nextOverloadRefreshTick;
	private int nextAntifireTick;
	private int nextSuperAntifireTick;
	private WorldPoint lastPoint;
	private ElapsedTimer tzhaarTimer;

	private final Map<GameCounter, BuffCounter> varCounters = new EnumMap<>(GameCounter.class);
	private static final int ECLIPSE_MOON_REGION_ID = 6038;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	@Inject
	private TimersAndBuffsConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Provides
	TimersAndBuffsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TimersAndBuffsConfig.class);
	}

	@Override
	public void startUp()
	{
		if (config.showHomeMinigameTeleports())
		{
			checkTeleport(LAST_HOME_TELEPORT);
			checkTeleport(LAST_MINIGAME_TELEPORT);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer);
		lastPoint = null;
		nextPoisonTick = 0;
		nextOverloadRefreshTick = 0;
		nextAntifireTick = 0;
		nextSuperAntifireTick = 0;
		removeTzhaarTimer();
		varTimers.clear();
		infoBoxManager.removeIf(buffCounter -> buffCounter instanceof BuffCounter);
		varCounters.clear();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarbitId() == Varbits.IN_RAID)
		{
			removeVarTimer(OVERLOAD_RAID);
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (event.getVarbitId() == Varbits.VENGEANCE_COOLDOWN && config.showVengeance())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(VENGEANCE);
			}
			else
			{
				removeGameTimer(VENGEANCE);
			}
		}

		if (event.getVarbitId() == Varbits.SPELLBOOK_SWAP && config.showSpellbookSwap())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(SPELLBOOK_SWAP);
			}
			else
			{
				removeGameTimer(SPELLBOOK_SWAP);
			}
		}

		if (event.getVarbitId() == Varbits.HEAL_GROUP_COOLDOWN && config.showHealGroup())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(HEAL_GROUP);
			}
			else
			{
				removeGameTimer(HEAL_GROUP);
			}
		}

		if (event.getVarbitId() == Varbits.DEATH_CHARGE_COOLDOWN && config.showArceuusCooldown())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(DEATH_CHARGE_COOLDOWN);
			}
			else
			{
				removeGameTimer(DEATH_CHARGE_COOLDOWN);
			}
		}

		if (event.getVarbitId() == Varbits.CORRUPTION_COOLDOWN && config.showArceuusCooldown())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(CORRUPTION_COOLDOWN);
			}
			else
			{
				removeGameTimer(CORRUPTION_COOLDOWN);
			}
		}

		if (event.getVarbitId() == Varbits.RESURRECT_THRALL_COOLDOWN && config.showArceuusCooldown())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(RESURRECT_THRALL_COOLDOWN);
			}
			else
			{
				removeGameTimer(RESURRECT_THRALL_COOLDOWN);
			}
		}

		if (event.getVarbitId() == Varbits.SHADOW_VEIL_COOLDOWN && config.showArceuusCooldown())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(SHADOW_VEIL_COOLDOWN);
			}
			else
			{
				removeGameTimer(SHADOW_VEIL_COOLDOWN);
			}
		}

		if (event.getVarbitId() == Varbits.WARD_OF_ARCEUUS_COOLDOWN && config.showArceuusCooldown())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(WARD_OF_ARCEUUS_COOLDOWN);
			}
			else
			{
				removeGameTimer(WARD_OF_ARCEUUS_COOLDOWN);
			}
		}

		if (event.getVarbitId() == Varbits.VENGEANCE_ACTIVE && config.showVengeanceActive())
		{
			updateVarCounter(VENGEANCE_ACTIVE, event.getValue());
		}

		if (event.getVarbitId() == Varbits.DEATH_CHARGE && config.showArceuus())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(DEATH_CHARGE, Duration.of(client.getRealSkillLevel(Skill.MAGIC), RSTimeUnit.GAME_TICKS));
			}
			else
			{
				removeGameTimer(DEATH_CHARGE);
			}
		}

		if (event.getVarbitId() == Varbits.RESURRECT_THRALL && event.getValue() == 0 && config.showArceuus())
		{
			removeGameTimer(RESURRECT_THRALL);
		}

		if (event.getVarbitId() == Varbits.SHADOW_VEIL && event.getValue() == 0 && config.showArceuus())
		{
			removeGameTimer(SHADOW_VEIL);
		}

		if (event.getVarpId() == VarPlayer.POISON && config.showAntiPoison())
		{
			final int poisonVarp = event.getValue();
			final int tickCount = client.getTickCount();

			if (poisonVarp == 0)
			{
				nextPoisonTick = -1;
			}
			else if (nextPoisonTick - tickCount <= 0)
			{
				nextPoisonTick = tickCount + POISON_TICK_LENGTH;
			}

			updateVarTimer(ANTIPOISON, event.getValue(),
				i -> i >= 0 || i < VENOM_VALUE_CUTOFF,
				i -> nextPoisonTick - tickCount + Math.abs((i + 1) * POISON_TICK_LENGTH));
			updateVarTimer(ANTIVENOM, event.getValue(),
				i -> i >= VENOM_VALUE_CUTOFF,
				i -> nextPoisonTick - tickCount + Math.abs((i + 1 - VENOM_VALUE_CUTOFF) * POISON_TICK_LENGTH));
		}

		if ((event.getVarbitId() == Varbits.NMZ_OVERLOAD_REFRESHES_REMAINING
			|| event.getVarbitId() == Varbits.COX_OVERLOAD_REFRESHES_REMAINING) && config.showOverload())
		{
			final int overloadVarb = event.getValue();
			final int tickCount = client.getTickCount();

			if (overloadVarb <= 0)
			{
				nextOverloadRefreshTick = -1;
			}
			else if (nextOverloadRefreshTick - tickCount <= 0)
			{
				nextOverloadRefreshTick = tickCount + OVERLOAD_TICK_LENGTH;
			}

			GameTimer overloadTimer = client.getVarbitValue(Varbits.IN_RAID) == 1 ? OVERLOAD_RAID : OVERLOAD;
			updateVarTimer(overloadTimer, overloadVarb, i -> nextOverloadRefreshTick - tickCount + (i - 1) * OVERLOAD_TICK_LENGTH);
		}

		if (event.getVarbitId() == Varbits.TELEBLOCK && config.showTeleblock())
		{
			updateVarTimer(TELEBLOCK, event.getValue() - 100, i -> i <= 0, IntUnaryOperator.identity());
		}

		if (event.getVarpId() == VarPlayer.CHARGE_GOD_SPELL && config.showCharge())
		{
			updateVarTimer(CHARGE, event.getValue(), i -> i * 2);
		}

		if (event.getVarbitId() == Varbits.IMBUED_HEART_COOLDOWN && config.showImbuedHeart())
		{
			updateVarTimer(IMBUEDHEART, event.getValue(), i -> i * 10);
		}

		if (event.getVarbitId() == Varbits.DRAGONFIRE_SHIELD_COOLDOWN && config.showDFSSpecial())
		{
			updateVarTimer(DRAGON_FIRE_SHIELD, event.getValue(), i -> i * 8);
		}

		if (event.getVarpId() == LAST_HOME_TELEPORT && config.showHomeMinigameTeleports())
		{
			checkTeleport(LAST_HOME_TELEPORT);
		}

		if (event.getVarpId() == LAST_MINIGAME_TELEPORT && config.showHomeMinigameTeleports())
		{
			checkTeleport(LAST_MINIGAME_TELEPORT);
		}

		if (event.getVarbitId() == Varbits.RUN_SLOWED_DEPLETION_ACTIVE
			|| event.getVarbitId() == Varbits.STAMINA_EFFECT
			|| event.getVarbitId() == Varbits.RING_OF_ENDURANCE_EFFECT)
		{
			// staminaEffectActive is checked to match https://github.com/Joshua-F/cs2-scripts/blob/741271f0c3395048c1bad4af7881a13734516adf/scripts/%5Bproc%2Cbuff_bar_get_value%5D.cs2#L25
			int staminaEffectActive = client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE);
			int staminaPotionEffectVarb = client.getVarbitValue(Varbits.STAMINA_EFFECT);
			int enduranceRingEffectVarb = client.getVarbitValue(Varbits.RING_OF_ENDURANCE_EFFECT);

			final int totalStaminaEffect = staminaPotionEffectVarb + enduranceRingEffectVarb;
			if (staminaEffectActive == 1 && config.showStamina())
			{
				updateVarTimer(STAMINA, totalStaminaEffect, i -> i * 10);
			}
		}

		if (event.getVarbitId() == Varbits.ANTIFIRE && config.showAntiFire())
		{
			final int antifireVarb = event.getValue();
			final int tickCount = client.getTickCount();

			if (antifireVarb == 0)
			{
				nextAntifireTick = -1;
			}
			else if (nextAntifireTick - tickCount <= 0)
			{
				nextAntifireTick = tickCount + ANTIFIRE_TICK_LENGTH;
			}

			updateVarTimer(ANTIFIRE, antifireVarb, i -> nextAntifireTick - tickCount + (i - 1) * ANTIFIRE_TICK_LENGTH);
		}

		if (event.getVarbitId() == Varbits.SUPER_ANTIFIRE && config.showAntiFire())
		{
			final int superAntifireVarb = event.getValue();
			final int tickCount = client.getTickCount();

			if (superAntifireVarb == 0)
			{
				nextSuperAntifireTick = -1;
			}
			else if (nextSuperAntifireTick - tickCount <= 0)
			{
				nextSuperAntifireTick = tickCount + SUPERANTIFIRE_TICK_LENGTH;
			}

			updateVarTimer(SUPERANTIFIRE, event.getValue(), i -> nextSuperAntifireTick - tickCount + (i - 1) * SUPERANTIFIRE_TICK_LENGTH);
		}

		if (event.getVarbitId() == Varbits.MAGIC_IMBUE && config.showMagicImbue())
		{
			updateVarTimer(MAGICIMBUE, event.getValue(), i -> i * 10);
		}

		if (event.getVarbitId() == Varbits.DIVINE_SUPER_ATTACK && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_COMBAT) > event.getValue())
			{
				return;
			}

			updateVarTimer(DIVINE_SUPER_ATTACK, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_SUPER_STRENGTH && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_COMBAT) > event.getValue())
			{
				return;
			}

			updateVarTimer(DIVINE_SUPER_STRENGTH, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_SUPER_DEFENCE && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_COMBAT) > event.getValue()
				|| client.getVarbitValue(Varbits.DIVINE_BASTION) > event.getValue()
				|| client.getVarbitValue(Varbits.DIVINE_BATTLEMAGE) > event.getValue()
				// When drinking a dose of moonlight potion while already under its effects, desync between
				// Varbits.MOONLIGHT_POTION and Varbits.DIVINE_SUPER_DEFENCE can occur, with the latter being 1 tick
				// greater
				|| client.getVarbitValue(Varbits.MOONLIGHT_POTION) >= event.getValue())
			{
				return;
			}

			if (client.getVarbitValue(Varbits.MOONLIGHT_POTION) < event.getValue())
			{
				removeVarTimer(MOONLIGHT_POTION);
			}

			updateVarTimer(DIVINE_SUPER_DEFENCE, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_RANGING && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_BASTION) > event.getValue())
			{
				return;
			}

			updateVarTimer(DIVINE_RANGING, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_MAGIC && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_BATTLEMAGE) > event.getValue())
			{
				return;
			}

			updateVarTimer(DIVINE_MAGIC, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_SUPER_COMBAT && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_ATTACK) == event.getValue())
			{
				removeVarTimer(DIVINE_SUPER_ATTACK);
			}
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_STRENGTH) == event.getValue())
			{
				removeVarTimer(DIVINE_SUPER_STRENGTH);
			}
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_DEFENCE) == event.getValue())
			{
				removeVarTimer(DIVINE_SUPER_DEFENCE);
			}

			updateVarTimer(DIVINE_SUPER_COMBAT, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_BASTION && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_RANGING) == event.getValue())
			{
				removeVarTimer(DIVINE_RANGING);
			}
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_DEFENCE) == event.getValue())
			{
				removeVarTimer(DIVINE_SUPER_DEFENCE);
			}

			updateVarTimer(DIVINE_BASTION, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.DIVINE_BATTLEMAGE && config.showDivine())
		{
			if (client.getVarbitValue(Varbits.DIVINE_MAGIC) == event.getValue())
			{
				removeVarTimer(DIVINE_MAGIC);
			}
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_DEFENCE) == event.getValue())
			{
				removeVarTimer(DIVINE_SUPER_DEFENCE);
			}

			updateVarTimer(DIVINE_BATTLEMAGE, event.getValue(), IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.BUFF_STAT_BOOST && config.showOverload())
		{
			updateVarTimer(SMELLING_SALTS, event.getValue(), i -> i * 25);
		}

		if (event.getVarbitId() == Varbits.MENAPHITE_REMEDY && config.showMenaphiteRemedy())
		{
			updateVarTimer(MENAPHITE_REMEDY, event.getValue(), i -> i * 25);
		}

		if (event.getVarbitId() == Varbits.LIQUID_ADERNALINE_ACTIVE && event.getValue() == 0 && config.showLiquidAdrenaline())
		{
			removeGameTimer(LIQUID_ADRENALINE);
		}

		if (event.getVarbitId() == Varbits.FARMERS_AFFINITY && config.showFarmersAffinity())
		{
			updateVarTimer(FARMERS_AFFINITY, event.getValue(), i -> i * 20);
		}

		if (event.getVarbitId() == Varbits.GOD_WARS_ALTAR_COOLDOWN && config.showGodWarsAltar())
		{
			updateVarTimer(GOD_WARS_ALTAR, event.getValue(), i -> i * 100);
		}

		if (event.getVarbitId() == Varbits.CURSE_OF_THE_MOONS && config.showCurseOfTheMoons())
		{
			final int regionID = WorldPoint.fromLocal(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
			if (regionID == ECLIPSE_MOON_REGION_ID)
			{
				updateVarCounter(CURSE_OF_THE_MOONS_ECLIPSE, event.getValue());
			}
			else
			{
				updateVarCounter(CURSE_OF_THE_MOONS_BLUE, event.getValue());
			}
		}

		if (event.getVarbitId() == Varbits.COLOSSEUM_DOOM && config.showColosseumDoom())
		{
			updateVarCounter(COLOSSEUM_DOOM, event.getValue());
		}

		if (event.getVarbitId() == Varbits.MOONLIGHT_POTION && config.showMoonlightPotion())
		{
			int moonlightValue = event.getValue();
			// Increase the timer by 1 tick in case of desync due to drinking a dose of moonlight potion while already
			// under its effects. Otherwise, the timer would be 1 tick shorter than it is meant to be.
			if (client.getVarbitValue(Varbits.DIVINE_SUPER_DEFENCE) == moonlightValue + 1)
			{
				moonlightValue++;
			}

			updateVarTimer(MOONLIGHT_POTION, moonlightValue, IntUnaryOperator.identity());
		}

		if (event.getVarbitId() == Varbits.BUFF_GOADING_POTION && config.showGoading())
		{
			updateVarTimer(GOADING, event.getValue(), i -> i * 6);
		}

		if (event.getVarbitId() == Varbits.BUFF_PRAYER_REGENERATION && config.showPrayerRegneration())
		{
			updateVarTimer(PRAYER_REGENERATION, event.getValue(), i -> i * 12);
		}

		if (event.getVarbitId() == Varbits.SCURRIUS_FOOD_PILE_COOLDOWN && config.showScurriusFoodPile())
		{
			updateVarTimer(SCURRIUS_FOOD_PILE, event.getValue(), i -> i * 100);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(TimersAndBuffsConfig.GROUP))
		{
			return;
		}

		if (!config.showHomeMinigameTeleports())
		{
			removeGameTimer(HOME_TELEPORT);
			removeGameTimer(MINIGAME_TELEPORT);
		}
		else
		{
			checkTeleport(LAST_HOME_TELEPORT);
			checkTeleport(LAST_MINIGAME_TELEPORT);
		}

		if (!config.showAntiFire())
		{
			removeVarTimer(ANTIFIRE);
			removeVarTimer(SUPERANTIFIRE);
		}

		if (!config.showStamina())
		{
			removeVarTimer(STAMINA);
		}

		if (!config.showOverload())
		{
			removeGameTimer(OVERLOAD);
			removeGameTimer(OVERLOAD_RAID);
			removeGameTimer(SMELLING_SALTS);
		}

		if (!config.showPrayerEnhance())
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (!config.showDivine())
		{
			removeVarTimer(DIVINE_SUPER_ATTACK);
			removeVarTimer(DIVINE_SUPER_STRENGTH);
			removeVarTimer(DIVINE_SUPER_DEFENCE);
			removeVarTimer(DIVINE_RANGING);
			removeVarTimer(DIVINE_MAGIC);
			removeVarTimer(DIVINE_SUPER_COMBAT);
			removeVarTimer(DIVINE_BASTION);
			removeVarTimer(DIVINE_BATTLEMAGE);
		}

		if (!config.showCannon())
		{
			removeGameTimer(CANNON);
			removeGameTimer(CANNON_REPAIR);
		}

		if (!config.showMagicImbue())
		{
			removeVarTimer(MAGICIMBUE);
		}

		if (!config.showCharge())
		{
			removeGameTimer(CHARGE);
		}

		if (!config.showImbuedHeart())
		{
			removeVarTimer(IMBUEDHEART);
		}

		if (!config.showDFSSpecial())
		{
			removeVarTimer(DRAGON_FIRE_SHIELD);
		}

		if (!config.showStaffOfTheDead())
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (!config.showVengeance())
		{
			removeGameTimer(VENGEANCE);
		}

		if (!config.showHealGroup())
		{
			removeGameTimer(HEAL_GROUP);
		}

		if (!config.showVengeanceActive())
		{
			removeVarCounter(VENGEANCE_ACTIVE);
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

		if (!config.showArceuus())
		{
			removeGameTimer(DEATH_CHARGE);
			removeGameTimer(RESURRECT_THRALL);
			removeGameTimer(SHADOW_VEIL);
			removeGameTimer(WARD_OF_ARCEUUS);
			removeGameTimer(MARK_OF_DARKNESS);
		}

		if (!config.showArceuusCooldown())
		{
			removeGameTimer(DEATH_CHARGE_COOLDOWN);
			removeGameTimer(RESURRECT_THRALL_COOLDOWN);
			removeGameTimer(SHADOW_VEIL_COOLDOWN);
			removeGameTimer(WARD_OF_ARCEUUS_COOLDOWN);
			removeGameTimer(CORRUPTION_COOLDOWN);
			removeGameTimer(MARK_OF_DARKNESS_COOLDOWN);
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

		if (!config.showFarmersAffinity())
		{
			removeVarTimer(FARMERS_AFFINITY);
		}

		if (!config.showGodWarsAltar())
		{
			removeVarTimer(GOD_WARS_ALTAR);
		}

		if (!config.showLiquidAdrenaline())
		{
			removeGameTimer(LIQUID_ADRENALINE);
		}

		if (!config.showMenaphiteRemedy())
		{
			removeVarTimer(MENAPHITE_REMEDY);
		}

		if (!config.showSilkDressing())
		{
			removeGameTimer(SILK_DRESSING);
		}

		if (!config.showBlessedCrystalScarab())
		{
			removeGameTimer(BLESSED_CRYSTAL_SCARAB);
		}

		if (!config.showAbyssalSireStun())
		{
			removeGameTimer(ABYSSAL_SIRE_STUN);
		}

		if (!config.showPickpocketStun())
		{
			removeGameTimer(PICKPOCKET_STUN);
		}

		if (!config.showSpellbookSwap())
		{
			removeGameTimer(SPELLBOOK_SWAP);
		}

		if (!config.showCurseOfTheMoons())
		{
			removeVarCounter(CURSE_OF_THE_MOONS_BLUE);
			removeVarCounter(CURSE_OF_THE_MOONS_ECLIPSE);
		}

		if (!config.showColosseumDoom())
		{
			removeVarCounter(COLOSSEUM_DOOM);
		}

		if (!config.showMoonlightPotion())
		{
			removeVarTimer(MOONLIGHT_POTION);
		}

		if (!config.showGoading())
		{
			removeVarTimer(GOADING);
		}

		if (!config.showPrayerRegneration())
		{
			removeVarTimer(PRAYER_REGENERATION);
		}

		if (!config.showScurriusFoodPile())
		{
			removeVarTimer(SCURRIUS_FOOD_PILE);
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

		if (message.contains(DODGY_NECKLACE_PROTECTION_MESSAGE) || message.contains(SHADOW_VEIL_PROTECTION_MESSAGE))
		{
			removeGameTimer(PICKPOCKET_STUN);
		}

		if (message.contains(PICKPOCKET_FAILURE_MESSAGE) && config.showPickpocketStun() && message.contains("pocket"))
		{
			if (message.contains("hero") || message.contains("elf"))
			{
				createGameTimer(PICKPOCKET_STUN, Duration.ofSeconds(6));
			}
			else
			{
				createGameTimer(PICKPOCKET_STUN, Duration.ofSeconds(5));
			}
		}

		if (message.equals(ABYSSAL_SIRE_STUN_MESSAGE) && config.showAbyssalSireStun())
		{
			createGameTimer(ABYSSAL_SIRE_STUN);
		}

		if (message.equals(CANNON_BASE_MESSAGE) || message.equals(CANNON_STAND_MESSAGE)
			|| message.equals(CANNON_BARRELS_MESSAGE) || message.equals(CANNON_FURNACE_MESSAGE)
			|| message.contains(CANNON_REPAIR_MESSAGE))
		{
			removeGameTimer(CANNON_REPAIR);

			if (config.showCannon())
			{
				TimerTimer cannonTimer = createGameTimer(CANNON);
				cannonTimer.setTooltip(cannonTimer.getTooltip() + " - World " + client.getWorld());
			}
		}
		else if (message.equals(CANNON_BROKEN_MESSAGE))
		{
			removeGameTimer(CANNON);

			if (config.showCannon())
			{
				TimerTimer cannonTimer = createGameTimer(CANNON_REPAIR);
				cannonTimer.setTooltip(cannonTimer.getTooltip() + " - World " + client.getWorld());
			}
		}
		else if (message.equals(CANNON_PICKUP_MESSAGE) || message.equals(CANNON_DESTROYED_MESSAGE))
		{
			removeGameTimer(CANNON);
			removeGameTimer(CANNON_REPAIR);
		}

		if (message.startsWith("You drink some of your") && message.contains("prayer enhance") && config.showPrayerEnhance())
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (message.equals(PRAYER_ENHANCE_EXPIRED) && config.showPrayerEnhance())
		{
			removeGameTimer(PRAYER_ENHANCE);
		}

		if (message.contains(STAFF_OF_THE_DEAD_SPEC_MESSAGE) && config.showStaffOfTheDead())
		{
			createGameTimer(STAFF_OF_THE_DEAD);
		}

		if (message.contains(STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE) && config.showStaffOfTheDead())
		{
			removeGameTimer(STAFF_OF_THE_DEAD);
		}

		if (message.equals(FROZEN_MESSAGE) && config.showFreezes())
		{
			freezeTimer = createGameTimer(ICEBARRAGE);
			freezeTime = client.getTickCount();
		}

		if (config.showArceuus())
		{
			final int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
			if (message.endsWith(SHADOW_VEIL_MESSAGE))
			{
				createGameTimer(SHADOW_VEIL, Duration.of(magicLevel, RSTimeUnit.GAME_TICKS));
			}
			else if (message.endsWith(WARD_OF_ARCEUUS_MESSAGE))
			{
				createGameTimer(WARD_OF_ARCEUUS, Duration.of(magicLevel, RSTimeUnit.GAME_TICKS));
			}
			else if (message.endsWith(MARK_OF_DARKNESS_MESSAGE))
			{
				createGameTimer(MARK_OF_DARKNESS, Duration.of(magicLevel, RSTimeUnit.GAME_TICKS));
			}
			else if (message.contains(RESURRECT_THRALL_MESSAGE_START) && message.endsWith(RESURRECT_THRALL_MESSAGE_END))
			{
				// by default the thrall lasts 1 tick per magic level
				int t = client.getBoostedSkillLevel(Skill.MAGIC);
				// ca tiers being completed boosts this
				if (client.getVarbitValue(Varbits.COMBAT_ACHIEVEMENT_TIER_GRANDMASTER) == 2)
				{
					t += t; // 100% boost
				}
				else if (client.getVarbitValue(Varbits.COMBAT_ACHIEVEMENT_TIER_MASTER) == 2)
				{
					t += t / 2; // 50% boost
				}
				createGameTimer(RESURRECT_THRALL, Duration.of(t, RSTimeUnit.GAME_TICKS));
			}
		}

		if (message.endsWith(MARK_OF_DARKNESS_MESSAGE) && config.showArceuusCooldown())
		{
			final int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
			createGameTimer(MARK_OF_DARKNESS_COOLDOWN, Duration.of(magicLevel - 10, RSTimeUnit.GAME_TICKS));
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

		if (message.equals(SILK_DRESSING_MESSAGE) && config.showSilkDressing())
		{
			createGameTimer(SILK_DRESSING);
		}

		if (message.equals(BLESSED_CRYSTAL_SCARAB_MESSAGE) && config.showBlessedCrystalScarab())
		{
			createGameTimer(BLESSED_CRYSTAL_SCARAB);
		}

		if (message.equals(LIQUID_ADRENALINE_MESSAGE) && config.showLiquidAdrenaline())
		{
			createGameTimer(LIQUID_ADRENALINE);
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

	private void checkTeleport(@Varp int varPlayer)
	{
		final GameTimer teleport;
		switch (varPlayer)
		{
			case LAST_HOME_TELEPORT:
				teleport = HOME_TELEPORT;
				break;
			case LAST_MINIGAME_TELEPORT:
				teleport = MINIGAME_TELEPORT;
				break;
			default:
				// Other var changes are not handled as teleports
				return;
		}

		int lastTeleport = client.getVarpValue(varPlayer);
		long lastTeleportSeconds = (long) lastTeleport * 60;
		Instant teleportExpireInstant = Instant.ofEpochSecond(lastTeleportSeconds).plus(teleport.getDuration());
		Duration remainingTime = Duration.between(Instant.now(), teleportExpireInstant);

		if (remainingTime.getSeconds() > 0)
		{
			createGameTimer(teleport, remainingTime);
		}
		else
		{
			removeGameTimer(teleport);
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
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case LOADING:
				if (tzhaarTimer != null && !isInFightCaves() && !isInInferno())
				{
					removeTzhaarTimer();
					config.tzhaarStartTime(null);
					config.tzhaarLastTime(null);
				}
				// Varbits.COLOSSEUM_DOOM is not set to 0 when teleporting out of the Colosseum.
				removeVarCounter(COLOSSEUM_DOOM);
				break;
			case LOGIN_SCREEN:
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
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (actor.getGraphic() == BIND.getGraphicId() && config.showFreezes())
		{
			freezeTimer = createGameTimer(BIND);
			freezeTime = client.getTickCount();
		}

		if (actor.getGraphic() == SNARE.getGraphicId() && config.showFreezes())
		{
			freezeTimer = createGameTimer(SNARE);
			freezeTime = client.getTickCount();
		}

		if (actor.getGraphic() == ENTANGLE.getGraphicId() && config.showFreezes())
		{
			freezeTimer = createGameTimer(ENTANGLE);
			freezeTime = client.getTickCount();
		}

		// downgrade freeze based on graphic, if at the same tick as the freeze message
		if (freezeTime == client.getTickCount() && config.showFreezes())
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

	/**
	 * Remove SOTD timer when equipment is changed.
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
		if (weapon == null || !STAVES_OF_THE_DEAD.contains(weapon.getId()))
		{
			// remove sotd timer if the staff has been unwielded
			removeGameTimer(STAFF_OF_THE_DEAD);
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

	@VisibleForTesting
	void removeGameTimer(GameTimer timer)
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer && ((TimerTimer) t).getTimer() == timer);
	}

	private void updateVarTimer(final GameTimer gameTimer, final int varValue, final IntUnaryOperator tickDuration)
	{
		updateVarTimer(gameTimer, varValue, i -> i == 0, tickDuration);
	}

	private void updateVarTimer(final GameTimer gameTimer, final int varValue, final IntPredicate removeTimerCheck, final IntUnaryOperator tickDuration)
	{
		TimerTimer timer = varTimers.get(gameTimer);
		int ticks = tickDuration.applyAsInt(varValue);
		final Duration duration = Duration.of(ticks, RSTimeUnit.GAME_TICKS);

		if (removeTimerCheck.test(varValue))
		{
			removeVarTimer(gameTimer);
		}
		// Reset the timer when its duration increases in order to allow it to turn red at the correct time even when refreshed early
		else if (timer == null || ticks > timer.ticks)
		{
			timer = createGameTimer(gameTimer, duration);
			timer.ticks = ticks;
			varTimers.put(gameTimer, timer);
		}
		else
		{
			timer.ticks = ticks;
			timer.updateDuration(duration);
		}
	}

	private void removeVarTimer(final GameTimer gameTimer)
	{
		removeGameTimer(gameTimer);
		varTimers.remove(gameTimer);
	}

	private void updateVarCounter(final GameCounter gameCounter, final int varValue)
	{
		BuffCounter buffCounter = varCounters.get(gameCounter);

		if (varValue == 0)
		{
			removeVarCounter(gameCounter);
		}
		else if (buffCounter == null)
		{
			buffCounter = createBuffCounter(gameCounter, varValue);
			varCounters.put(gameCounter, buffCounter);
		}
		else
		{
			buffCounter.setCount(varValue);
		}
	}

	private BuffCounter createBuffCounter(GameCounter gameCounter, int count)
	{
		removeBuffCounter(gameCounter);

		BuffCounter buffCounter = new BuffCounter(this, gameCounter, count);
		switch (gameCounter.getImageType())
		{
			case SPRITE:
				spriteManager.getSpriteAsync(gameCounter.getImageId(), 0, buffCounter);
				break;
			case ITEM:
				buffCounter.setImage(itemManager.getImage(gameCounter.getImageId()));
				break;
		}
		buffCounter.setTooltip(gameCounter.getDescription());
		infoBoxManager.addInfoBox(buffCounter);
		return buffCounter;
	}

	private void removeVarCounter(final GameCounter gameCounter)
	{
		removeBuffCounter(gameCounter);
		varCounters.remove(gameCounter);
	}

	private void removeBuffCounter(GameCounter gameCounter)
	{
		infoBoxManager.removeIf(b -> b instanceof BuffCounter && ((BuffCounter) b).getGameCounter() == gameCounter);
	}
}
