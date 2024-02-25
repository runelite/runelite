package net.runelite.client.plugins.wiki.dps;

import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Spell
{

	// ancient spells
	ICE_BARRAGE(46, "Ice Barrage"),
	BLOOD_BARRAGE(45, "Blood Barrage"),
	SHADOW_BARRAGE(44, "Shadow Barrage"),
	SMOKE_BARRAGE(43, "Smoke Barrage"),
	ICE_BLITZ(42, "Ice Blitz"),
	BLOOD_BLITZ(41, "Blood Blitz"),
	SHADOW_BLITZ(40, "Shadow Blitz"),
	SMOKE_BLITZ(39, "Smoke Blitz"),
	ICE_BURST(38, "Ice Burst"),
	BLOOD_BURST(37, "Blood Burst"),
	SHADOW_BURST(36, "Shadow Burst"),
	SMOKE_BURST(35, "Smoke Burst"),
	ICE_RUSH(34, "Ice Rush"),
	BLOOD_RUSH(33, "Blood Rush"),
	SHADOW_RUSH(32, "Shadow Rush"),
	SMOKE_RUSH(31, "Smoke Rush"),

	// standard spells
	FIRE_SURGE(51, "Fire Surge"),
	EARTH_SURGE(50, "Earth Surge"),
	WATER_SURGE(49, "Water Surge"),
	WIND_SURGE(48, "Wind Surge"),
	FIRE_WAVE(16, "Fire Wave"),
	EARTH_WAVE(15, "Earth Wave"),
	WATER_WAVE(14, "Water Wave"),
	WIND_WAVE(13, "Wind Wave"),
	FIRE_BLAST(12, "Fire Blast"),
	EARTH_BLAST(11, "Earth Blast"),
	WATER_BLAST(10, "Water Blast"),
	WIND_BLAST(9, "Wind Blast"),
	FIRE_BOLT(8, "Fire Bolt"),
	EARTH_BOLT(7, "Earth Bolt"),
	WATER_BOLT(6, "Water Bolt"),
	WIND_BOLT(5, "Wind Bolt"),
	FIRE_STRIKE(4, "Fire Strike"),
	EARTH_STRIKE(3, "Earth Strike"),
	WATER_STRIKE(2, "Water Strike"),
	WIND_STRIKE(1, "Wind Strike"),

	// standard but not autocast without special staff
	FLAMES_OF_ZAMORAK(20, "Flames of Zamorak"),
	CLAWS_OF_GUTHIX(-1, "Claws of Guthix"),
	SARADOMIN_STRIKE(-1, "Saradomin Strike"),
	CRUMBLE_UNDEAD(17, "Crumble Undead"),
	IBAN_BLAST(47, "Iban Blast"),
	MAGIC_DART(18, "Magic Dart"),

	// arceuus
	INFERIOR_DEMONBANE(53, "Inferior Demonbane"),
	SUPERIOR_DEMONBANE(54, "Superior Demonbane"),
	DARK_DEMONBANE(55, "Dark Demonbane"),
	GHOSTLY_GRASP(56, "Ghostly Grasp"),
	SKELETAL_GRASP(57, "Skeletal Grasp"),
	UNDEAD_GRASP(58, "Undead Grasp"),
	;

	private final int varbValue;

	private final String name;

	@Nullable
	static Spell fromVarb(int spellVarb)
	{
		for (Spell spell : values())
		{
			if (spell.varbValue == spellVarb)
			{
				return spell;
			}
		}

		return null;
	}

}
