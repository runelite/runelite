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
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
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
import net.runelite.client.util.RSTimeUnit;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Timers",
	description = "Show various timers in an infobox",
	tags = {"combat", "items", "magic", "potions", "prayer", "overlay", "abyssal", "sire", "inferno", "fight", "caves", "cape", "timer", "tzhaar", "thieving", "pickpocket"}
)
@Slf4j
public class TimersPlugin extends Plugin
{
	private static final String ABYSSAL_SIRE_STUN_MESSAGE = "The Sire has been disorientated temporarily.";
	private static final String ANTIFIRE_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your antifire potion has expired.</col>";
	private static final String CANNON_BASE_MESSAGE = "You place the cannon base on the ground.";
	private static final String CANNON_STAND_MESSAGE = "You add the stand.";
	private static final String CANNON_BARRELS_MESSAGE = "You add the barrels.";
	private static final String CANNON_FURNACE_MESSAGE = "You add the furnace.";
	private static final String CANNON_PICKUP_MESSAGE = "You pick up the cannon. It's really heavy.";
	private static final String CANNON_REPAIR_MESSAGE = "You repair your cannon, restoring it to working order.";
	private static final String CANNON_DESTROYED_MESSAGE = "Your cannon has been destroyed!";
	private static final String CANNON_BROKEN_MESSAGE = "<col=ef1020>Your cannon has broken!";
	private static final String EXTENDED_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String FROZEN_MESSAGE = "<col=ef1020>You have been frozen!</col>";
	private static final String GOD_WARS_ALTAR_MESSAGE = "you recharge your prayer.";
	private static final String MAGIC_IMBUE_EXPIRED_MESSAGE = "Your Magic Imbue charge has ended.";
	private static final String MAGIC_IMBUE_MESSAGE = "You are charged to combine runes!";
	private static final String STAFF_OF_THE_DEAD_SPEC_EXPIRED_MESSAGE = "Your protection fades away";
	private static final String STAFF_OF_THE_DEAD_SPEC_MESSAGE = "Spirits of deceased evildoers offer you their protection";
	private static final String SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your super antifire potion";
	private static final String SUPER_ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your super antifire potion has expired.</col>";
	private static final String PRAYER_ENHANCE_EXPIRED = "<col=ff0000>Your prayer enhance effect has worn off.</col>";
	private static final String SHADOW_VEIL_MESSAGE = ">Your thieving abilities have been enhanced.</col>";
	private static final String DEATH_CHARGE_MESSAGE = ">Upon the death of your next foe, some of your special attack energy will be restored.</col>";
	private static final String DEATH_CHARGE_ACTIVATE_MESSAGE = ">Some of your special attack energy has been restored.</col>";
	private static final String RESURRECT_THRALL_MESSAGE_START = ">You resurrect a ";
	private static final String RESURRECT_THRALL_MESSAGE_END = " thrall.</col>";
	private static final String RESURRECT_THRALL_DISAPPEAR_MESSAGE_START = ">Your ";
	private static final String RESURRECT_THRALL_DISAPPEAR_MESSAGE_END = " thrall returns to the grave.</col>";
	private static final String WARD_OF_ARCEUUS_MESSAGE = ">Your defence against Arceuus magic has been strengthened.</col>";
	private static final String PICKPOCKET_FAILURE_MESSAGE = "You fail to pick ";
	private static final String DODGY_NECKLACE_PROTECTION_MESSAGE = "Your dodgy necklace protects you.";
	private static final String SHADOW_VEIL_PROTECTION_MESSAGE = "Your attempt to steal goes unnoticed.";
	private static final String SILK_DRESSING_MESSAGE = "You quickly apply the dressing to your wounds.";
	private static final String BLESSED_CRYSTAL_SCARAB_MESSAGE = "You crack the crystal in your hand.";
	private static final String LIQUID_ADRENALINE_MESSAGE = "You drink some of the potion, reducing the energy cost of your special attacks.</col>";

	private static final Pattern DIVINE_POTION_PATTERN = Pattern.compile("You drink some of your divine (.+) potion\\.");
	private static final int VENOM_VALUE_CUTOFF = -38; // Antivenom < -38 <= Antipoison < 0
	private static final int POISON_TICK_LENGTH = 30;
	private static final int OVERLOAD_TICK_LENGTH = 25;

	static final int FIGHT_CAVES_REGION_ID = 9551;
	static final int INFERNO_REGION_ID = 9043;
	private static final Pattern TZHAAR_WAVE_MESSAGE = Pattern.compile("Wave: (\\d+)");
	private static final String TZHAAR_DEFEATED_MESSAGE = "You have been defeated!";
	private static final Pattern TZHAAR_PAUSED_MESSAGE = Pattern.compile("The (?:Inferno|Fight Cave) has been paused. You may now log out.");

	private TimerTimer freezeTimer;
	private int freezeTime = -1; // time frozen, in game ticks

	private TimerTimer staminaTimer;
	private TimerTimer buffTimer;
	private TimerTimer remedyTimer;

	private boolean imbuedHeartTimerActive;
	private int nextPoisonTick;
	private int nextOverloadRefreshTick;
	private WorldPoint lastPoint;
	private int lastAnimation;
	private ElapsedTimer tzhaarTimer;

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
		if (config.showHomeMinigameTeleports())
		{
			checkTeleport(VarPlayer.LAST_HOME_TELEPORT);
			checkTeleport(VarPlayer.LAST_MINIGAME_TELEPORT);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof TimerTimer);
		lastPoint = null;
		lastAnimation = -1;
		nextPoisonTick = 0;
		nextOverloadRefreshTick = 0;
		removeTzhaarTimer();
		staminaTimer = null;
		imbuedHeartTimerActive = false;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarbitId() == Varbits.IN_RAID)
		{
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

		if (event.getVarbitId() == Varbits.VENGEANCE_ACTIVE && config.showVengeanceActive())
		{
			if (event.getValue() == 1)
			{
				createGameIndicator(VENGEANCE_ACTIVE);
			}
			else
			{
				removeGameIndicator(VENGEANCE_ACTIVE);
			}
		}

		if (event.getVarpId() == VarPlayer.POISON.getId() && config.showAntiPoison())
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

			if (poisonVarp >= 0)
			{
				removeGameTimer(ANTIPOISON);
				removeGameTimer(ANTIVENOM);
			}
			else if (poisonVarp >= VENOM_VALUE_CUTOFF)
			{
				Duration duration = Duration.of(nextPoisonTick - tickCount + Math.abs((poisonVarp + 1) * POISON_TICK_LENGTH), RSTimeUnit.GAME_TICKS);
				removeGameTimer(ANTIVENOM);
				createGameTimer(ANTIPOISON, duration);
			}
			else
			{
				Duration duration = Duration.of(nextPoisonTick - tickCount + Math.abs((poisonVarp + 1 - VENOM_VALUE_CUTOFF) * POISON_TICK_LENGTH), RSTimeUnit.GAME_TICKS);
				removeGameTimer(ANTIPOISON);
				createGameTimer(ANTIVENOM, duration);
			}
		}

		if ((event.getVarbitId() == Varbits.NMZ_OVERLOAD_REFRESHES_REMAINING
			|| event.getVarbitId() == Varbits.COX_OVERLOAD_REFRESHES_REMAINING) && config.showOverload())
		{
			final int overloadVarb = event.getValue();
			final int tickCount = client.getTickCount();

			if (nextOverloadRefreshTick - tickCount <= 0)
			{
				nextOverloadRefreshTick = tickCount + OVERLOAD_TICK_LENGTH;
			}

			if (overloadVarb <= 0)
			{
				nextOverloadRefreshTick = -1;
				removeGameTimer(OVERLOAD);
				removeGameTimer(OVERLOAD_RAID);
			}
			else
			{
				GameTimer overloadTimer = client.getVarbitValue(Varbits.IN_RAID) == 1 ? OVERLOAD_RAID : OVERLOAD;
				createGameTimer(overloadTimer, Duration.of(nextOverloadRefreshTick - tickCount + (overloadVarb - 1L) * OVERLOAD_TICK_LENGTH, RSTimeUnit.GAME_TICKS));
			}
		}

		if (event.getVarbitId() == Varbits.TELEBLOCK && config.showTeleblock())
		{
			final int teleblockVarb = event.getValue();
			if (teleblockVarb > 100)
			{
				// Reduce by 100 ticks because the blocking effect subsides and immunity period supervenes
				createGameTimer(TELEBLOCK, Duration.of((teleblockVarb - 100), RSTimeUnit.GAME_TICKS));
			}
			else
			{
				removeGameTimer(TELEBLOCK);
			}
		}

		if (event.getVarpId() == VarPlayer.CHARGE_GOD_SPELL.getId() && config.showCharge())
		{
			final int chargeSpellVarp = event.getValue();
			if (chargeSpellVarp > 0)
			{
				createGameTimer(CHARGE, Duration.of((chargeSpellVarp * 2L), RSTimeUnit.GAME_TICKS));
			}
			else
			{
				removeGameTimer(CHARGE);
			}
		}

		if (event.getVarbitId() == Varbits.IMBUED_HEART_COOLDOWN && config.showImbuedHeart())
		{
			final int imbuedHeartCooldownVarb = event.getValue();
			if (imbuedHeartCooldownVarb == 0)
			{
				removeGameTimer(IMBUEDHEART);
				imbuedHeartTimerActive = false;
			}
			else if (!imbuedHeartTimerActive)
			{
				createGameTimer(IMBUEDHEART, Duration.of(10L * imbuedHeartCooldownVarb, RSTimeUnit.GAME_TICKS));
				imbuedHeartTimerActive = true;
			}
		}

		if (event.getVarpId() == VarPlayer.LAST_HOME_TELEPORT.getId() && config.showHomeMinigameTeleports())
		{
			checkTeleport(VarPlayer.LAST_HOME_TELEPORT);
		}

		if (event.getVarpId() == VarPlayer.LAST_MINIGAME_TELEPORT.getId() && config.showHomeMinigameTeleports())
		{
			checkTeleport(VarPlayer.LAST_MINIGAME_TELEPORT);
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
				final Duration staminaDuration = Duration.of(10L * totalStaminaEffect, RSTimeUnit.GAME_TICKS);

				if (totalStaminaEffect == 0)
				{
					removeGameTimer(STAMINA);
					staminaTimer = null;
				}
				else if (staminaTimer == null)
				{
					staminaTimer = createGameTimer(STAMINA, staminaDuration);
				}
				else
				{
					staminaTimer.updateDuration(staminaDuration);
				}
			}
		}

		if (event.getVarbitId() == Varbits.BUFF_STAT_BOOST && config.showOverload())
		{
			int serverTicks = event.getValue() * 25; // from [proc,buff_bar_get_value]
			Duration duration = Duration.of(serverTicks, RSTimeUnit.GAME_TICKS);
			if (serverTicks == 0)
			{
				removeGameTimer(SMELLING_SALTS);
				buffTimer = null;
			}
			else if (buffTimer == null)
			{
				buffTimer = createGameTimer(SMELLING_SALTS, duration);
			}
			else
			{
				buffTimer.updateDuration(duration);
			}
		}

		if (event.getVarbitId() == Varbits.MENAPHITE_REMEDY && config.showMenaphiteRemedy())
		{
			int remedyDuration = event.getValue() * 25;
			Duration duration = Duration.of(remedyDuration, RSTimeUnit.GAME_TICKS);

			if (remedyDuration == 0)
			{
				removeGameTimer(MENAPHITE_REMEDY);
				remedyTimer = null;
			}
			else if (remedyTimer == null)
			{
				remedyTimer = createGameTimer(MENAPHITE_REMEDY, duration);
			}
			else
			{
				remedyTimer.updateDuration(duration);
			}
		}

		if (event.getVarbitId() == Varbits.LIQUID_ADERNALINE_ACTIVE && config.showLiquidAdrenaline())
		{
			if (event.getValue() == 1)
			{
				createGameTimer(LIQUID_ADRENALINE);
			}
			else
			{
				removeGameTimer(LIQUID_ADRENALINE);
			}
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
		else
		{
			checkTeleport(VarPlayer.LAST_HOME_TELEPORT);
			checkTeleport(VarPlayer.LAST_MINIGAME_TELEPORT);
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
			staminaTimer = null;
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
			imbuedHeartTimerActive = false;
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

		if (!config.showLiquidAdrenaline())
		{
			removeGameTimer(LIQUID_ADRENALINE);
		}

		if (!config.showMenaphiteRemedy())
		{
			removeGameTimer(MENAPHITE_REMEDY);
			remedyTimer = null;
		}

		if (!config.showSilkDressing())
		{
			removeGameTimer(SILK_DRESSING);
		}

		if (!config.showBlessedCrystalScarab())
		{
			removeGameTimer(BLESSED_CRYSTAL_SCARAB);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.isItemOp() && event.getMenuOption().equals("Drink"))
		{

			if ((event.getItemId() == ItemID.ANTIFIRE_MIX1
				|| event.getItemId() == ItemID.ANTIFIRE_MIX2)
				&& config.showAntiFire())
			{
				// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
				createGameTimer(ANTIFIRE);
				return;
			}

			if ((event.getItemId() == ItemID.EXTENDED_ANTIFIRE_MIX1
				|| event.getItemId() == ItemID.EXTENDED_ANTIFIRE_MIX2)
				&& config.showAntiFire())
			{
				// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
				createGameTimer(EXANTIFIRE);
				return;
			}

			if ((event.getItemId() == ItemID.SUPER_ANTIFIRE_MIX1
				|| event.getItemId() == ItemID.SUPER_ANTIFIRE_MIX2)
				&& config.showAntiFire())
			{
				// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
				createGameTimer(SUPERANTIFIRE);
				return;
			}

			if ((event.getItemId() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX1
				|| event.getItemId() == ItemID.EXTENDED_SUPER_ANTIFIRE_MIX2)
				&& config.showAntiFire())
			{
				// Needs menu option hook because mixes use a common drink message, distinct from their standard potion messages
				createGameTimer(EXSUPERANTIFIRE);
				return;
			}
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

		if (config.showCannon())
		{
			if (message.equals(CANNON_BASE_MESSAGE) || message.equals(CANNON_STAND_MESSAGE)
				|| message.equals(CANNON_BARRELS_MESSAGE) || message.equals(CANNON_FURNACE_MESSAGE)
				|| message.contains(CANNON_REPAIR_MESSAGE))
			{
				removeGameTimer(CANNON_REPAIR);
				TimerTimer cannonTimer = createGameTimer(CANNON);
				cannonTimer.setTooltip(cannonTimer.getTooltip() + " - World " + client.getWorld());
			}
			else if (message.equals(CANNON_BROKEN_MESSAGE))
			{
				removeGameTimer(CANNON);
				TimerTimer cannonTimer = createGameTimer(CANNON_REPAIR);
				cannonTimer.setTooltip(cannonTimer.getTooltip() + " - World " + client.getWorld());
			}
			else if (message.equals(CANNON_PICKUP_MESSAGE) || message.equals(CANNON_DESTROYED_MESSAGE))
			{
				removeGameTimer(CANNON);
				removeGameTimer(CANNON_REPAIR);
			}
		}

		if (config.showMagicImbue() && message.equals(MAGIC_IMBUE_MESSAGE))
		{
			createGameTimer(MAGICIMBUE);
		}

		if (message.equals(MAGIC_IMBUE_EXPIRED_MESSAGE))
		{
			removeGameTimer(MAGICIMBUE);
		}

		if (config.showAntiFire() && message.contains(SUPER_ANTIFIRE_DRINK_MESSAGE))
		{
			createGameTimer(SUPERANTIFIRE);
		}

		if (config.showAntiFire() && message.equals(SUPER_ANTIFIRE_EXPIRED_MESSAGE))
		{
			removeGameTimer(SUPERANTIFIRE);
		}

		if (config.showPrayerEnhance() && message.startsWith("You drink some of your") && message.contains("prayer enhance"))
		{
			createGameTimer(PRAYER_ENHANCE);
		}

		if (config.showPrayerEnhance() && message.equals(PRAYER_ENHANCE_EXPIRED))
		{
			removeGameTimer(PRAYER_ENHANCE);
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

		if (config.showArceuus())
		{
			Duration duration = Duration.of(client.getRealSkillLevel(Skill.MAGIC), RSTimeUnit.GAME_TICKS);
			if (message.endsWith(SHADOW_VEIL_MESSAGE))
			{
				createGameTimer(SHADOW_VEIL, duration);
			}
			else if (message.endsWith(WARD_OF_ARCEUUS_MESSAGE))
			{
				createGameTimer(WARD_OF_ARCEUUS, duration);
			}
			else if (message.endsWith(DEATH_CHARGE_MESSAGE))
			{
				createGameTimer(DEATH_CHARGE, duration);
			}
			else if (message.endsWith(DEATH_CHARGE_ACTIVATE_MESSAGE))
			{
				removeGameTimer(DEATH_CHARGE);
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
			else if (message.contains(RESURRECT_THRALL_DISAPPEAR_MESSAGE_START) && message.endsWith(RESURRECT_THRALL_DISAPPEAR_MESSAGE_END))
			{
				removeGameTimer(RESURRECT_THRALL);
			}
		}

		if (config.showArceuusCooldown())
		{
			if (message.endsWith(SHADOW_VEIL_MESSAGE))
			{
				createGameTimer(SHADOW_VEIL_COOLDOWN);
			}
			else if (message.endsWith(DEATH_CHARGE_MESSAGE))
			{
				createGameTimer(DEATH_CHARGE_COOLDOWN);
			}
			else if (message.endsWith(WARD_OF_ARCEUUS_MESSAGE))
			{
				createGameTimer(WARD_OF_ARCEUUS_COOLDOWN);
			}
			else if (message.contains(RESURRECT_THRALL_MESSAGE_START) && message.endsWith(RESURRECT_THRALL_MESSAGE_END))
			{
				createGameTimer(RESURRECT_THRALL_COOLDOWN);
			}
		}

		if (message.equals(TZHAAR_DEFEATED_MESSAGE))
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

	private void checkTeleport(VarPlayer varPlayer)
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
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
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
		if (weapon == null ||
			(weapon.getId() != ItemID.STAFF_OF_THE_DEAD &&
				weapon.getId() != ItemID.TOXIC_STAFF_OF_THE_DEAD &&
				weapon.getId() != ItemID.STAFF_OF_LIGHT &&
				weapon.getId() != ItemID.TOXIC_STAFF_UNCHARGED))
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
