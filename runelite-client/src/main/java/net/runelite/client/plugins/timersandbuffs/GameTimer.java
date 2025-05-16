/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timersandbuffs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.SpriteID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.SpotanimID;
import static net.runelite.client.util.RSTimeUnit.GAME_TICKS;

@Getter(AccessLevel.PACKAGE)
enum GameTimer
{
	STAMINA(ItemID._4DOSESTAMINA, GameTimerImageType.ITEM, "Stamina", false),
	ANTIFIRE(ItemID._4DOSE1ANTIDRAGON, GameTimerImageType.ITEM, "Antifire", false),
	OVERLOAD(ItemID.NZONE4DOSEOVERLOADPOTION, GameTimerImageType.ITEM, "Overload", false),
	CANNON(ItemID.TWPART3, GameTimerImageType.ITEM, "Cannon", 25, ChronoUnit.MINUTES),
	CANNON_REPAIR(ItemID.MCANNONTOOLKIT, GameTimerImageType.ITEM, "Broken Cannon", 10, ChronoUnit.MINUTES),
	MAGICIMBUE(SpriteID.SPELL_MAGIC_IMBUE, GameTimerImageType.SPRITE, "Magic imbue", false),
	SUPERANTIFIRE(ItemID._4DOSE3ANTIDRAGON, GameTimerImageType.ITEM, "Super antifire", false),
	BIND(SpriteID.SPELL_BIND, GameTimerImageType.SPRITE, "Bind", SpotanimID.BIND_IMPACT, 8, GAME_TICKS, true),
	SNARE(SpriteID.SPELL_SNARE, GameTimerImageType.SPRITE, "Snare", SpotanimID.SNARE_IMPACT, 16, GAME_TICKS, true),
	ENTANGLE(SpriteID.SPELL_ENTANGLE, GameTimerImageType.SPRITE, "Entangle", SpotanimID.ENTANGLE_IMPACT, 24, GAME_TICKS, true),
	ICERUSH(SpriteID.SPELL_ICE_RUSH, GameTimerImageType.SPRITE, "Ice rush", SpotanimID.ICE_RUSH_IMPACT, 8, GAME_TICKS, true),
	ICEBURST(SpriteID.SPELL_ICE_BURST, GameTimerImageType.SPRITE, "Ice burst", SpotanimID.ICE_BLITZ_IMPACT, 16, GAME_TICKS, true),
	ICEBLITZ(SpriteID.SPELL_ICE_BLITZ, GameTimerImageType.SPRITE, "Ice blitz", SpotanimID.ICE_BURST_IMPACT, 24, GAME_TICKS, true),
	ICEBARRAGE(SpriteID.SPELL_ICE_BARRAGE, GameTimerImageType.SPRITE, "Ice barrage", SpotanimID.ICE_BARRAGE_IMPACT, 32, GAME_TICKS, true),
	IMBUEDHEART(ItemID.IMBUED_HEART, GameTimerImageType.ITEM, "Imbued/Saturated heart", false),
	VENGEANCE(SpriteID.SPELL_VENGEANCE, GameTimerImageType.SPRITE, "Vengeance", 30, ChronoUnit.SECONDS),
	HEAL_GROUP(SpriteID.SPELL_HEAL_GROUP, GameTimerImageType.SPRITE, "Heal Group", 150, GAME_TICKS),
	OVERLOAD_RAID(ItemID.RAIDS_VIAL_OVERLOAD_STRONG_4, GameTimerImageType.ITEM, "Overload", false),
	PRAYER_ENHANCE(ItemID.RAIDS_VIAL_PRAYER_WEAK_4, GameTimerImageType.ITEM, "Prayer enhance", 290, ChronoUnit.SECONDS, true),
	GOD_WARS_ALTAR(SpriteID.SKILL_PRAYER, GameTimerImageType.SPRITE, "God wars altar", false),
	SCURRIUS_FOOD_PILE(ItemID.CHEESE, GameTimerImageType.ITEM, "Scurrius food pile", false),
	CHARGE(SpriteID.SPELL_CHARGE, GameTimerImageType.SPRITE, "Charge", false),
	STAFF_OF_THE_DEAD(ItemID.SOTD, GameTimerImageType.ITEM, "Staff of the Dead", 1, ChronoUnit.MINUTES),
	ABYSSAL_SIRE_STUN(ItemID.ABYSSALSIRE_PET, GameTimerImageType.ITEM, "Abyssal Sire Stun", 46, GAME_TICKS, true),
	HOME_TELEPORT(SpriteID.SPELL_LUMBRIDGE_HOME_TELEPORT, GameTimerImageType.SPRITE, "Home Teleport", 30, ChronoUnit.MINUTES),
	MINIGAME_TELEPORT(SpriteID.TAB_QUESTS_RED_MINIGAMES, GameTimerImageType.SPRITE, "Minigame Teleport", 20, ChronoUnit.MINUTES),
	DRAGON_FIRE_SHIELD(ItemID.DRAGONFIRE_SHIELD, GameTimerImageType.ITEM, "Dragonfire Shield Special", false),
	DIVINE_SUPER_ATTACK(ItemID._4DOSEDIVINEATTACK, GameTimerImageType.ITEM, "Divine Super Attack", false),
	DIVINE_SUPER_STRENGTH(ItemID._4DOSEDIVINESTRENGTH, GameTimerImageType.ITEM, "Divine Super Strength", false),
	DIVINE_SUPER_DEFENCE(ItemID._4DOSEDIVINEDEFENCE, GameTimerImageType.ITEM, "Divine Super Defence", false),
	DIVINE_SUPER_COMBAT(ItemID._4DOSEDIVINECOMBAT, GameTimerImageType.ITEM, "Divine Super Combat", false),
	DIVINE_RANGING(ItemID._4DOSEDIVINERANGE, GameTimerImageType.ITEM, "Divine Ranging", false),
	DIVINE_MAGIC(ItemID._4DOSEDIVINEMAGIC, GameTimerImageType.ITEM, "Divine Magic", false),
	DIVINE_BASTION(ItemID._4DOSEDIVINEBASTION, GameTimerImageType.ITEM, "Divine Bastion", false),
	DIVINE_BATTLEMAGE(ItemID._4DOSEDIVINEBATTLEMAGE, GameTimerImageType.ITEM, "Divine Battlemage", false),
	MOONLIGHT_POTION(ItemID._4DOSEMOONLIGHTPOTION, GameTimerImageType.ITEM, "Moonlight potion", false),
	ANTIPOISON(ItemID._4DOSEANTIPOISON, GameTimerImageType.ITEM, "Antipoison", false),
	ANTIVENOM(ItemID.ANTIVENOM4, GameTimerImageType.ITEM, "Anti-venom", false),
	TELEBLOCK(SpriteID.SPELL_TELE_BLOCK, GameTimerImageType.SPRITE, "Teleblock", false),
	SHADOW_VEIL(SpriteID.SPELL_SHADOW_VEIL, GameTimerImageType.SPRITE, "Shadow veil", true),
	RESURRECT_THRALL(SpriteID.SPELL_RESURRECT_SUPERIOR_SKELETON, GameTimerImageType.SPRITE, "Resurrect thrall", false),
	WARD_OF_ARCEUUS(SpriteID.SPELL_WARD_OF_ARCEUUS, GameTimerImageType.SPRITE, "Ward of Arceuus", true),
	DEATH_CHARGE(SpriteID.SPELL_DEATH_CHARGE, GameTimerImageType.SPRITE, "Death charge", 60, ChronoUnit.SECONDS, false),
	MARK_OF_DARKNESS(SpriteID.SPELL_MARK_OF_DARKNESS, GameTimerImageType.SPRITE, "Mark of Darkness", true),
	SHADOW_VEIL_COOLDOWN(SpriteID.SPELL_SHADOW_VEIL_DISABLED, GameTimerImageType.SPRITE, "Shadow veil cooldown", 30, ChronoUnit.SECONDS),
	RESURRECT_THRALL_COOLDOWN(SpriteID.SPELL_RESURRECT_SUPERIOR_SKELETON_DISABLED, GameTimerImageType.SPRITE, "Resurrect thrall cooldown", 17, GAME_TICKS),
	WARD_OF_ARCEUUS_COOLDOWN(SpriteID.SPELL_WARD_OF_ARCEUUS_DISABLED, GameTimerImageType.SPRITE, "Ward of Arceuus cooldown", 30, ChronoUnit.SECONDS),
	DEATH_CHARGE_COOLDOWN(SpriteID.SPELL_DEATH_CHARGE_DISABLED, GameTimerImageType.SPRITE, "Death charge cooldown", 60, ChronoUnit.SECONDS),
	CORRUPTION_COOLDOWN(SpriteID.SPELL_GREATER_CORRUPTION_DISABLED, GameTimerImageType.SPRITE, "Corruption cooldown", 30, ChronoUnit.SECONDS),
	MARK_OF_DARKNESS_COOLDOWN(SpriteID.SPELL_MARK_OF_DARKNESS_DISABLED, GameTimerImageType.SPRITE, "Mark of Darkness cooldown", true),
	PICKPOCKET_STUN(SpriteID.SKILL_THIEVING, GameTimerImageType.SPRITE, "Stunned", true),
	FARMERS_AFFINITY(ItemID.GRAIN, GameTimerImageType.ITEM, "Farmer's Affinity", false),
	SMELLING_SALTS(ItemID.TOA_SUPPLY_STATS_2, GameTimerImageType.ITEM, "Smelling salts", false),
	MENAPHITE_REMEDY(ItemID._4DOSESTATRENEWAL, GameTimerImageType.ITEM, "Menaphite remedy", false),
	LIQUID_ADRENALINE(ItemID.TOA_SUPPLY_ENERGY_2, GameTimerImageType.ITEM, "Liquid adrenaline", 150, ChronoUnit.SECONDS, false),
	SILK_DRESSING(ItemID.TOA_SUPPLY_HEAL_OVERTIME_2, GameTimerImageType.ITEM, "Silk dressing", 100, GAME_TICKS, true),
	BLESSED_CRYSTAL_SCARAB(ItemID.TOA_SUPPLY_PRAYER_OVERTIME_2, GameTimerImageType.ITEM, "Blessed crystal scarab", 40, GAME_TICKS, true),
	SPELLBOOK_SWAP(SpriteID.SPELL_SPELLBOOK_SWAP, GameTimerImageType.SPRITE, "Spellbook Reset", 120, ChronoUnit.SECONDS, false),
	SMOULDERING_HEART(ItemID.SMOULDERING_HEART, GameTimerImageType.ITEM, "Smouldering heart", false),
	SMOULDERING_GLAND(ItemID.SMOULDERING_GLAND, GameTimerImageType.ITEM, "Smouldering gland", false),
	GOADING(ItemID._4DOSEGOADING, GameTimerImageType.ITEM, "Goading potion", false),
	PRAYER_REGENERATION(ItemID._4DOSE1PRAYER_REGENERATION, GameTimerImageType.ITEM, "Prayer regeneration", false),
	SURGE_POTION(ItemID._4DOSESURGE, GameTimerImageType.ITEM, "Surge potion", false),
	;

	@Nullable
	private final Duration duration;
	@Nullable
	private final Integer graphicId;
	private final String description;
	private final boolean removedOnDeath;
	private final int imageId;
	private final GameTimerImageType imageType;

	GameTimer(int imageId, GameTimerImageType idType, String description, Integer graphicId, long time, TemporalUnit unit, boolean removedOnDeath)
	{
		this.description = description;
		this.graphicId = graphicId;
		this.duration = Duration.of(time, unit);
		this.imageId = imageId;
		this.imageType = idType;
		this.removedOnDeath = removedOnDeath;
	}

	GameTimer(int imageId, GameTimerImageType idType, String description, long time, TemporalUnit unit, boolean removeOnDeath)
	{
		this(imageId, idType, description, null, time, unit, removeOnDeath);
	}

	GameTimer(int imageId, GameTimerImageType idType, String description, long time, TemporalUnit unit)
	{
		this(imageId, idType, description, null, time, unit, false);
	}

	GameTimer(int imageId, GameTimerImageType idType, String description, boolean removedOnDeath)
	{
		this.duration = null;
		this.graphicId = null;
		this.description = description;
		this.removedOnDeath = removedOnDeath;
		this.imageId = imageId;
		this.imageType = idType;
	}
}
