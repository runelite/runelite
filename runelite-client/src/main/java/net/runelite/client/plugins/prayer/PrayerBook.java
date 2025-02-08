package net.runelite.client.plugins.prayer;

import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Prayer;

class PrayerBook
{
	@Setter(AccessLevel.PACKAGE)
	public boolean deadeyeUnlocked = false;

	@Setter(AccessLevel.PACKAGE)
	public boolean mysticVigourUnlocked = false;

	public PrayerType prayerTypeForPrayer(Prayer prayer)
	{
		switch (prayer)
			{
			case THICK_SKIN:
				return PrayerType.THICK_SKIN;
			case BURST_OF_STRENGTH:
				return PrayerType.BURST_OF_STRENGTH;
			case CLARITY_OF_THOUGHT:
				return PrayerType.CLARITY_OF_THOUGHT;
			case SHARP_EYE:
				return PrayerType.SHARP_EYE;
			case MYSTIC_WILL:
				return PrayerType.MYSTIC_WILL;
			case ROCK_SKIN:
				return PrayerType.ROCK_SKIN;
			case SUPERHUMAN_STRENGTH:
				return PrayerType.SUPERHUMAN_STRENGTH;
			case IMPROVED_REFLEXES:
				return PrayerType.IMPROVED_REFLEXES;
			case RAPID_RESTORE:
				return PrayerType.RAPID_RESTORE;
			case RAPID_HEAL:
				return PrayerType.RAPID_HEAL;
			case PROTECT_ITEM:
				return PrayerType.PROTECT_ITEM;
			case HAWK_EYE:
				return PrayerType.HAWK_EYE;
			case MYSTIC_LORE:
				return PrayerType.MYSTIC_LORE;
			case STEEL_SKIN:
				return PrayerType.STEEL_SKIN;
			case ULTIMATE_STRENGTH:
				return PrayerType.ULTIMATE_STRENGTH;
			case INCREDIBLE_REFLEXES:
				return PrayerType.INCREDIBLE_REFLEXES;
			case PROTECT_FROM_MAGIC:
				return PrayerType.PROTECT_FROM_MAGIC;
			case PROTECT_FROM_MISSILES:
				return PrayerType.PROTECT_FROM_MISSILES;
			case PROTECT_FROM_MELEE:
				return PrayerType.PROTECT_FROM_MELEE;
			case EAGLE_EYE:
				if (deadeyeUnlocked)
					{
						return PrayerType.DEADEYE;
					}
				else
					{
						return PrayerType.EAGLE_EYE;
					}
			case MYSTIC_MIGHT:
				if (mysticVigourUnlocked)
					{
						return PrayerType.MYSTIC_VIGOUR;
					}
				else
					{
						return PrayerType.MYSTIC_MIGHT;
					}
			case RETRIBUTION:
				return PrayerType.RETRIBUTION;
			case REDEMPTION:
				return PrayerType.REDEMPTION;
			case SMITE:
				return PrayerType.SMITE;
			case CHIVALRY:
				return PrayerType.CHIVALRY;
			case PIETY:
				return PrayerType.PIETY;
			case PRESERVE:
				return PrayerType.PRESERVE;
			case RIGOUR:
				return PrayerType.RIGOUR;
			case AUGURY:
				return PrayerType.AUGURY;
			case RP_REJUVENATION:
				return PrayerType.RP_REJUVENATION;
			case RP_ANCIENT_STRENGTH:
				return PrayerType.RP_ANCIENT_STRENGTH;
			case RP_ANCIENT_SIGHT:
				return PrayerType.RP_ANCIENT_SIGHT;
			case RP_ANCIENT_WILL:
				return PrayerType.RP_ANCIENT_WILL;
			case RP_PROTECT_ITEM:
				return PrayerType.RP_PROTECT_ITEM;
			case RP_RUINOUS_GRACE:
				return PrayerType.RP_RUINOUS_GRACE;
			case RP_DAMPEN_MAGIC:
				return PrayerType.RP_DAMPEN_MAGIC;
			case RP_DAMPEN_RANGED:
				return PrayerType.RP_DAMPEN_RANGED;
			case RP_DAMPEN_MELEE:
				return PrayerType.RP_DAMPEN_MELEE;
			case RP_TRINITAS:
				return PrayerType.RP_TRINITAS;
			case RP_BERSERKER:
				return PrayerType.RP_BERSERKER;
			case RP_PURGE:
				return PrayerType.RP_PURGE;
			case RP_METABOLISE:
				return PrayerType.RP_METABOLISE;
			case RP_REBUKE:
				return PrayerType.RP_REBUKE;
			case RP_VINDICATION:
				return PrayerType.RP_VINDICATION;
			case RP_DECIMATE:
				return PrayerType.RP_DECIMATE;
			case RP_ANNIHILATE:
				return PrayerType.RP_ANNIHILATE;
			case RP_VAPORISE:
				return PrayerType.RP_VAPORISE;
			case RP_FUMUS_VOW:
				return PrayerType.RP_FUMUS_VOW;
			case RP_UMBRAS_VOW:
				return PrayerType.RP_UMBRAS_VOW;
			case RP_CRUORS_VOW:
				return PrayerType.RP_CRUORS_VOW;
			case RP_GLACIES_VOW:
				return PrayerType.RP_GLACIES_VOW;
			case RP_WRATH:
				return PrayerType.RP_WRATH;
			case RP_INTENSIFY:
				return PrayerType.RP_INTENSIFY;
			}
		throw new IllegalArgumentException();
	}
}
