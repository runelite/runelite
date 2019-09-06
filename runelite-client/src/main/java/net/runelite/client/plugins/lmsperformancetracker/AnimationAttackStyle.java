package net.runelite.client.plugins.lmsperformancetracker;

import lombok.Getter;
import net.runelite.api.HeadIcon;
import org.apache.commons.lang3.ArrayUtils;

import static net.runelite.api.AnimationID.*;

public enum AnimationAttackStyle
{
	// None: Common non-attack animations seen during combat. This enum value says they aren't attacking.
	// It doesn't have to be populated, but it may as well be with common non-attack animations, to skip
	// checking all the attack animations in most cases.
	None(null,
		IDLE,
		CONSUMING,
		COMBAT_SHIELD_BLOCK,
		COMBAT_DEFENDER_BLOCK
	),
	// Melee attack animations
	Melee(HeadIcon.MELEE,
		MELEE_DAGGER_SLASH,
		MELEE_SPEAR_STAB,
		MELEE_SWORD_STAB,
		MELEE_SCIM_SLASH,
		MELEE_RUNE_BATTLEAXE_SLASH,
		MELEE_RUNE_BATTLEAXE_CRUSH,
		MELEE_RUNE_2H_CRUSH,
		MELEE_RUNE_2H_SLASH,
		MELEE_ANCIENT_STAFF_CRUSH,
		MELEE_STAFF_CRUSH,
		MELEE_PUNCH,
		MELEE_KICK,
		MELEE_STAFF_STAB,
		MELEE_STAFF_SLASH,
		MELEE_DRAGON_DAGGER_SPEC,
		MELEE_DRAGON_WARHAMMER_SPEC,
		MELEE_ABYSSAL_WHIP,
		MELEE_GRANITE_MAUL,
		MELEE_GRANITE_MAUL_SPEC,
		MELEE_DHAROKS_GREATAXE_CRUSH,
		MELEE_DHAROKS_GREATAXE_SLASH,
		MELEE_LEAF_BLADED_BATTLEAXE_CRUSH,
		MELEE_BARRELCHEST_ANCHOR_CRUSH,
		MELEE_LEAF_BLADED_BATTLEAXE_SLASH,
		MELEE_GODSWORD_SLASH,
		MELEE_GODSWORD_CRUSH,
		MELEE_DRAGON_CLAWS_SPEC,
		MELEE_ELDER_MAUL,
		MELEE_BANDOS_GODSWORD_SPEC,
		MELEE_ARMADYL_GODSWORD_SPEC,
		MELEE_GHAZI_RAPIER_STAB
	),

	// Magic attack/casting animations
	Magic(HeadIcon.MAGIC,
		MAGIC_STANDARD_BIND,
		MAGIC_STANDARD_STRIKE_BOLT_BLAST,
		MAGIC_STANDARD_BIND_STAFF,
		MAGIC_STANDARD_STRIKE_BOLT_BLAST_STAFF,
		MAGIC_STANDARD_WAVE_STAFF,
		MAGIC_STANDARD_SURGE_STAFF,
		MAGIC_ANCIENT_SINGLE_TARGET,
		MAGIC_ANCIENT_MULTI_TARGET
	),
	// Ranged attack animations
	Ranged(HeadIcon.RANGED,
		RANGED_SHORTBOW,
		RANGED_RUNE_KNIFE_PVP,
		RANGED_MAGIC_SHORTBOW_SPEC,
		RANGED_CROSSBOW_PVP,
		RANGED_BLOWPIPE,
		RANGED_DARTS,
		RANGED_HEAVY_BALLISTA,
		RANGED_DRAGON_THROWNAXE_SPEC,
		RANGED_RUNE_CROSSBOW,
		RANGED_LIGHT_BALLISTA,
		RANGED_RUNE_KNIFE,
		RANGED_DRAGON_KNIFE,
		RANGED_DRAGON_KNIFE_POISONED
	);

	@Getter
	private final HeadIcon protection;
	private final int[] animationIds;

	AnimationAttackStyle(HeadIcon protection, int... animationIds)
	{
		this.protection = protection;
		this.animationIds = animationIds;
	}

	// Returns the AnimationAttackStyle for a given animationId
	public static AnimationAttackStyle styleForAnimation(int animationId)
	{
		// check for common non-attack animationIds before checking known attack ones,
		// since it is more likely that they aren't attacking, so avoid starting by
		// checking large arrays of attack animationIds.
		if (ArrayUtils.contains(None.animationIds, animationId))
		{
			return None;
		}
		else if (ArrayUtils.contains(Melee.animationIds, animationId))
		{
			return Melee;
		}
		else if (ArrayUtils.contains(Magic.animationIds, animationId))
		{
			return Magic;
		}
		else if (ArrayUtils.contains(Ranged.animationIds, animationId))
		{
			return Ranged;
		}
		return None;
	}
}
