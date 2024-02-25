package net.runelite.client.plugins.wiki.dps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// https://oldschool.runescape.wiki/w/Module:CombatStyles
@RequiredArgsConstructor
@Getter
enum WeaponCategory
{

	TWO_HANDED_SWORD(10, Arrays.asList(
		new PlayerCombatStyle(0, "Chop", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Slash", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Smash", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "slash", "Defensive")
	)),
	AXE(1, Arrays.asList(
		new PlayerCombatStyle(0, "Chop", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Hack", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Smash", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "slash", "Defensive")
	)),
	BANNER(24, Arrays.asList(
		new PlayerCombatStyle(0, "Lunge", "stab", "Accurate"),
		new PlayerCombatStyle(1, "Swipe", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Pound", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "stab", "Defensive")
	)),
	BLADED_STAFF(21, Arrays.asList(
		new PlayerCombatStyle(0, "Jab", "stab", "Accurate"),
		new PlayerCombatStyle(1, "Swipe", "slash", "Aggressive"),
		new PlayerCombatStyle(3, "Fend", "crush", "Defensive"),
		new PlayerCombatStyle(4, "Spell", "magic", "Autocast")
	)),
	BLUDGEON(26, Arrays.asList(
		new PlayerCombatStyle(0, "Pound", "crush", "Aggressive"),
		new PlayerCombatStyle(1, "Pummel", "crush", "Aggressive"),
		new PlayerCombatStyle(2, "Smash", "crush", "Aggressive")
	)),
	BLUNT(2, Arrays.asList(
		new PlayerCombatStyle(0, "Pound", "crush", "Accurate"),
		new PlayerCombatStyle(1, "Pummel", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "crush", "Defensive")
	)),
	BOW(3, Arrays.asList(
		new PlayerCombatStyle(0, "Accurate", "ranged", "Accurate"),
		new PlayerCombatStyle(1, "Rapid", "ranged", "Rapid"),
		new PlayerCombatStyle(3, "Longrange", "ranged", "Longrange")
	)),
	BULWARK(27, Collections.singletonList(
		new PlayerCombatStyle(0, "Pummel", "crush", "Accurate")
	)),
	CHINCHOMPAS(7, Arrays.asList(
		new PlayerCombatStyle(0, "Short fuse", "ranged", "Accurate"),
		new PlayerCombatStyle(1, "Medium fuse", "ranged", "Rapid"),
		new PlayerCombatStyle(3, "Long fuse", "ranged", "Longrange")
	)),
	CLAW(4, Arrays.asList(
		new PlayerCombatStyle(0, "Chop", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Slash", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Lunge", "stab", "Controlled"),
		new PlayerCombatStyle(3, "Block", "slash", "Defensive")
	)),
	CROSSBOW(5, Arrays.asList(
		new PlayerCombatStyle(0, "Accurate", "ranged", "Accurate"),
		new PlayerCombatStyle(1, "Rapid", "ranged", "Rapid"),
		new PlayerCombatStyle(3, "Longrange", "ranged", "Longrange")
	)),
	PARTISAN(29, Arrays.asList(
		new PlayerCombatStyle(0, "Stab", "stab", "Accurate"),
		new PlayerCombatStyle(0, "Lunge", "stab", "Aggressive"),
		new PlayerCombatStyle(0, "Pound", "crush", "Aggressive"),
		new PlayerCombatStyle(0, "Block", "stab", "Accurate")
	)),
	PICKAXE(11, Arrays.asList(
		new PlayerCombatStyle(0, "Spike", "stab", "Accurate"),
		new PlayerCombatStyle(1, "Impale", "stab", "Aggressive"),
		new PlayerCombatStyle(2, "Smash", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "stab", "Defensive")
	)),
	POLEARM(12, Arrays.asList(
		new PlayerCombatStyle(0, "Jab", "stab", "Controlled"),
		new PlayerCombatStyle(1, "Swipe", "slash", "Aggressive"),
		new PlayerCombatStyle(3, "Fend", "stab", "Defensive")
	)),
	POLESTAFF(13, Arrays.asList(
		new PlayerCombatStyle(0, "Bash", "crush", "Accurate"),
		new PlayerCombatStyle(1, "Pound", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "crush", "Defensive")
	)),
	POWERED_STAFF(23, Arrays.asList(
		new PlayerCombatStyle(0, "Accurate", "magic", "Accurate"),
		new PlayerCombatStyle(1, "Accurate", "magic", "Accurate"),
		new PlayerCombatStyle(3, "Longrange", "magic", "Longrange")
	)),
	SALAMANDER(6, Arrays.asList(
		new PlayerCombatStyle(0, "Scorch", "slash", "Aggressive"),
		new PlayerCombatStyle(1, "Flare", "ranged", "Accurate"),
		new PlayerCombatStyle(2, "Blaze", "magic", "Defensive")
	)),
	SCYTHE(14, Arrays.asList(
		new PlayerCombatStyle(0, "Reap", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Chop", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Jab", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "slash", "Defensive")
	)),
	SLASH_SWORD(9, Arrays.asList(
		new PlayerCombatStyle(0, "Chop", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Slash", "slash", "Aggressive"),
		new PlayerCombatStyle(2, "Lunge", "stab", "Controlled"),
		new PlayerCombatStyle(3, "Block", "slash", "Defensive")
	)),
	SPEAR(15, Arrays.asList(
		new PlayerCombatStyle(0, "Lunge", "stab", "Controlled"),
		new PlayerCombatStyle(1, "Swipe", "slash", "Controlled"),
		new PlayerCombatStyle(2, "Pound", "crush", "Controlled"),
		new PlayerCombatStyle(3, "Block", "stab", "Defensive")
	)),
	SPIKED(16, Arrays.asList(
		new PlayerCombatStyle(0, "Pound", "crush", "Accurate"),
		new PlayerCombatStyle(1, "Pummel", "crush", "Aggressive"),
		new PlayerCombatStyle(2, "Spike", "stab", "Controlled"),
		new PlayerCombatStyle(3, "Block", "crush", "Defensive")
	)),
	STAB_SWORD(17, Arrays.asList(
		new PlayerCombatStyle(0, "Stab", "stab", "Accurate"),
		new PlayerCombatStyle(1, "Lunge", "stab", "Aggressive"),
		new PlayerCombatStyle(2, "Slash", "slash", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "stab", "Defensive")
	)),
	STAFF(18, Arrays.asList(
		new PlayerCombatStyle(0, "Bash", "crush", "Accurate"),
		new PlayerCombatStyle(1, "Pound", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Focus", "crush", "Defensive"),
		new PlayerCombatStyle(4, "Spell", "magic", "Autocast")
	)),
	THROWN(19, Arrays.asList(
		new PlayerCombatStyle(0, "Accurate", "ranged", "Accurate"),
		new PlayerCombatStyle(1, "Rapid", "ranged", "Rapid"),
		new PlayerCombatStyle(3, "Longrange", "ranged", "Longrange")
	)),
	UNARMED(0, Arrays.asList(
		new PlayerCombatStyle(0, "Punch", "crush", "Accurate"),
		new PlayerCombatStyle(1, "Kick", "crush", "Aggressive"),
		new PlayerCombatStyle(3, "Block", "crush", "Defensive")
	)),
	WHIP(20, Arrays.asList(
		new PlayerCombatStyle(0, "Flick", "slash", "Accurate"),
		new PlayerCombatStyle(1, "Lash", "slash", "Controlled"),
		new PlayerCombatStyle(3, "Deflect", "slash", "Defensive")
	)),
	;

	private final int varbValue;
	private final List<PlayerCombatStyle> playerCombatStyles;

	@Nullable
	PlayerCombatStyle styleFromVarp(int styleVarp)
	{
		for (PlayerCombatStyle style : this.playerCombatStyles)
		{
			if (style.getVarpValue() == styleVarp)
			{
				return style;
			}
		}

		return null;
	}

	@Nullable
	static WeaponCategory fromVarb(int categoryVarb)
	{
		for (WeaponCategory cat : values())
		{
			if (cat.varbValue == categoryVarb)
			{
				return cat;
			}
		}

		return null;
	}

}
