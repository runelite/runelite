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
package net.runelite.client.plugins.timers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GraphicID;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;
import static net.runelite.client.util.RSTimeUnit.GAME_TICKS;

@Getter(AccessLevel.PACKAGE)
enum GameTimer
{
	STAMINA(ItemID.STAMINA_POTION4, GameTimerImageType.ITEM, "Stamina", false),
	ANTIFIRE(ItemID.ANTIFIRE_POTION4, GameTimerImageType.ITEM, "Antifire", false),
	OVERLOAD(ItemID.OVERLOAD_4, GameTimerImageType.ITEM, "Overload", false),
	CANNON(ItemID.CANNON_BARRELS, GameTimerImageType.ITEM, "Cannon", 25, ChronoUnit.MINUTES),
	CANNON_REPAIR(ItemID.TOOLKIT, GameTimerImageType.ITEM, "Broken Cannon", 10, ChronoUnit.MINUTES),
	MAGICIMBUE(SpriteID.SPELL_MAGIC_IMBUE, GameTimerImageType.SPRITE, "Magic imbue", false),
	SUPERANTIFIRE(ItemID.SUPER_ANTIFIRE_POTION4, GameTimerImageType.ITEM, "Super antifire", false),
	BIND(SpriteID.SPELL_BIND, GameTimerImageType.SPRITE, "Bind", GraphicID.BIND, 8, GAME_TICKS, true),
	SNARE(SpriteID.SPELL_SNARE, GameTimerImageType.SPRITE, "Snare", GraphicID.SNARE, 16, GAME_TICKS, true),
	ENTANGLE(SpriteID.SPELL_ENTANGLE, GameTimerImageType.SPRITE, "Entangle", GraphicID.ENTANGLE, 24, GAME_TICKS, true),
	ICERUSH(SpriteID.SPELL_ICE_RUSH, GameTimerImageType.SPRITE, "Ice rush", GraphicID.ICE_RUSH, 8, GAME_TICKS, true),
	ICEBURST(SpriteID.SPELL_ICE_BURST, GameTimerImageType.SPRITE, "Ice burst", GraphicID.ICE_BURST, 16, GAME_TICKS, true),
	ICEBLITZ(SpriteID.SPELL_ICE_BLITZ, GameTimerImageType.SPRITE, "Ice blitz", GraphicID.ICE_BLITZ, 24, GAME_TICKS, true),
	ICEBARRAGE(SpriteID.SPELL_ICE_BARRAGE, GameTimerImageType.SPRITE, "Ice barrage", GraphicID.ICE_BARRAGE, 32, GAME_TICKS, true),
	IMBUEDHEART(ItemID.IMBUED_HEART, GameTimerImageType.ITEM, "Imbued/Saturated heart", false),
	VENGEANCE(SpriteID.SPELL_VENGEANCE, GameTimerImageType.SPRITE, "Vengeance", 30, ChronoUnit.SECONDS),
	HEAL_GROUP(SpriteID.SPELL_HEAL_GROUP, GameTimerImageType.SPRITE, "Heal Group", 150, GAME_TICKS),
	EXSUPERANTIFIRE(ItemID.EXTENDED_SUPER_ANTIFIRE4, GameTimerImageType.ITEM, "Extended Super AntiFire", 6, ChronoUnit.MINUTES),
	OVERLOAD_RAID(ItemID.OVERLOAD_4_20996, GameTimerImageType.ITEM, "Overload", false),
	PRAYER_ENHANCE(ItemID.PRAYER_ENHANCE_4, GameTimerImageType.ITEM, "Prayer enhance", 290, ChronoUnit.SECONDS, true),
	GOD_WARS_ALTAR(SpriteID.SKILL_PRAYER, GameTimerImageType.SPRITE, "God wars altar", 10, ChronoUnit.MINUTES),
	CHARGE(SpriteID.SPELL_CHARGE, GameTimerImageType.SPRITE, "Charge", false),
	STAFF_OF_THE_DEAD(ItemID.STAFF_OF_THE_DEAD, GameTimerImageType.ITEM, "Staff of the Dead", 1, ChronoUnit.MINUTES),
	ABYSSAL_SIRE_STUN(ItemID.ABYSSAL_ORPHAN, GameTimerImageType.ITEM, "Abyssal Sire Stun", 30, ChronoUnit.SECONDS, true),
	HOME_TELEPORT(SpriteID.SPELL_LUMBRIDGE_HOME_TELEPORT, GameTimerImageType.SPRITE, "Home Teleport", 30, ChronoUnit.MINUTES),
	MINIGAME_TELEPORT(SpriteID.TAB_QUESTS_RED_MINIGAMES, GameTimerImageType.SPRITE, "Minigame Teleport", 20, ChronoUnit.MINUTES),
	DRAGON_FIRE_SHIELD(ItemID.DRAGONFIRE_SHIELD, GameTimerImageType.ITEM, "Dragonfire Shield Special", 115, ChronoUnit.SECONDS),
	DIVINE_SUPER_ATTACK(ItemID.DIVINE_SUPER_ATTACK_POTION4, GameTimerImageType.ITEM, "Divine Super Attack", false),
	DIVINE_SUPER_STRENGTH(ItemID.DIVINE_SUPER_STRENGTH_POTION4, GameTimerImageType.ITEM, "Divine Super Strength", false),
	DIVINE_SUPER_DEFENCE(ItemID.DIVINE_SUPER_DEFENCE_POTION4, GameTimerImageType.ITEM, "Divine Super Defence", false),
	DIVINE_SUPER_COMBAT(ItemID.DIVINE_SUPER_COMBAT_POTION4, GameTimerImageType.ITEM, "Divine Super Combat", false),
	DIVINE_RANGING(ItemID.DIVINE_RANGING_POTION4, GameTimerImageType.ITEM, "Divine Ranging", false),
	DIVINE_MAGIC(ItemID.DIVINE_MAGIC_POTION4, GameTimerImageType.ITEM, "Divine Magic", false),
	DIVINE_BASTION(ItemID.DIVINE_BASTION_POTION4, GameTimerImageType.ITEM, "Divine Bastion", false),
	DIVINE_BATTLEMAGE(ItemID.DIVINE_BATTLEMAGE_POTION4, GameTimerImageType.ITEM, "Divine Battlemage", false),
	ANTIPOISON(ItemID.ANTIPOISON4, GameTimerImageType.ITEM, "Antipoison", false),
	ANTIVENOM(ItemID.ANTIVENOM4, GameTimerImageType.ITEM, "Anti-venom", false),
	TELEBLOCK(SpriteID.SPELL_TELE_BLOCK, GameTimerImageType.SPRITE, "Teleblock", false),
	SHADOW_VEIL(SpriteID.SPELL_SHADOW_VEIL, GameTimerImageType.SPRITE, "Shadow veil", true),
	RESURRECT_THRALL(SpriteID.SPELL_RESURRECT_SUPERIOR_SKELETON, GameTimerImageType.SPRITE, "Resurrect thrall", false),
	WARD_OF_ARCEUUS(SpriteID.SPELL_WARD_OF_ARCEUUS, GameTimerImageType.SPRITE, "Ward of Arceuus", true),
	DEATH_CHARGE(SpriteID.SPELL_DEATH_CHARGE, GameTimerImageType.SPRITE, "Death charge", false),
	SHADOW_VEIL_COOLDOWN(SpriteID.SPELL_SHADOW_VEIL_DISABLED, GameTimerImageType.SPRITE, "Shadow veil cooldown", 30, ChronoUnit.SECONDS),
	RESURRECT_THRALL_COOLDOWN(SpriteID.SPELL_RESURRECT_SUPERIOR_SKELETON_DISABLED, GameTimerImageType.SPRITE, "Resurrect thrall cooldown", 17, GAME_TICKS),
	WARD_OF_ARCEUUS_COOLDOWN(SpriteID.SPELL_WARD_OF_ARCEUUS_DISABLED, GameTimerImageType.SPRITE, "Ward of Arceuus cooldown", 30, ChronoUnit.SECONDS),
	DEATH_CHARGE_COOLDOWN(SpriteID.SPELL_DEATH_CHARGE_DISABLED, GameTimerImageType.SPRITE, "Death charge cooldown", 60, ChronoUnit.SECONDS),
	CORRUPTION_COOLDOWN(SpriteID.SPELL_GREATER_CORRUPTION_DISABLED, GameTimerImageType.SPRITE, "Corruption cooldown", 30, ChronoUnit.SECONDS),
	PICKPOCKET_STUN(SpriteID.SKILL_THIEVING, GameTimerImageType.SPRITE, "Stunned", true),
	FARMERS_AFFINITY(ItemID.GRAIN, GameTimerImageType.ITEM, "Farmer's Affinity", false),
	SMELLING_SALTS(ItemID.SMELLING_SALTS_2, GameTimerImageType.ITEM, "Smelling salts", true),
	MENAPHITE_REMEDY(ItemID.MENAPHITE_REMEDY4, GameTimerImageType.ITEM, "Menaphite remedy", true),
	LIQUID_ADRENALINE(ItemID.LIQUID_ADRENALINE_2, GameTimerImageType.ITEM, "Liquid adrenaline", 150, ChronoUnit.SECONDS, false),
	SILK_DRESSING(ItemID.SILK_DRESSING_2, GameTimerImageType.ITEM, "Silk dressing", 100, GAME_TICKS, true),
	BLESSED_CRYSTAL_SCARAB(ItemID.BLESSED_CRYSTAL_SCARAB_2, GameTimerImageType.ITEM, "Blessed crystal scarab", 40, GAME_TICKS, true),
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
