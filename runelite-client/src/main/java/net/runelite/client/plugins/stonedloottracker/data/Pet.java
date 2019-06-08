package net.runelite.client.plugins.stonedloottracker.data;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum Pet
{
	// GWD Pets
	PET_GENERAL_GRAARDOR(ItemID.PET_GENERAL_GRAARDOR, "General graador"),
	PET_KREEARRA(ItemID.PET_KREEARRA, "Kree'arra"),
	PET_KRIL_TSUTSAROTH(ItemID.PET_KRIL_TSUTSAROTH, "K'ril tsutsaroth"),
	PET_ZILYANA(ItemID.PET_ZILYANA, "Commander zilyana"),
	// Wildy Pets
	CALLISTO_CUB(ItemID.CALLISTO_CUB, "Callisto"),
	PET_CHAOS_ELEMENTAL(ItemID.PET_CHAOS_ELEMENTAL, "Chaos Elemental", "Chaos Fanatic"),
	SCORPIAS_OFFSPRING(ItemID.SCORPIAS_OFFSPRING, "Scorpia"),
	VENENATIS_SPIDERLING(ItemID.VENENATIS_SPIDERLING, "Venenatis"),
	VETION_JR(ItemID.VETION_JR, "Vet'ion"),
	// KBD isn't really in wildy but meh
	PRINCE_BLACK_DRAGON(ItemID.PRINCE_BLACK_DRAGON, "King Black Dragon"),
	// Slayer Pets
	ABYSSAL_ORPHAN(ItemID.ABYSSAL_ORPHAN, "Abyssal Sire"),
	HELLPUPPY(ItemID.HELLPUPPY, "Cerberus"),
	NOON(ItemID.NOON, "Noon", "Dusk"),
	PET_KRAKEN(ItemID.PET_KRAKEN, "Kraken"),
	PET_SMOKE_DEVIL(ItemID.PET_SMOKE_DEVIL, "Thermonuclear Smoke Devil"),
	SKOTOS(ItemID.SKOTOS, "Skotizo"),
	// Other Bosses
	BABY_MOLE(ItemID.BABY_MOLE, "Giant Mole"),
	KALPHITE_PRINCESS(ItemID.KALPHITE_PRINCESS, "Kalphite Queen"),
	OLMLET(ItemID.OLMLET, "Chambers of Xeric"),
	LIL_ZIK(ItemID.LIL_ZIK, "Theatre of Blood"),
	PET_DARK_CORE(ItemID.PET_DARK_CORE, "Corporeal Beast"),
	PET_SNAKELING(ItemID.PET_SNAKELING, "Zulrah"),
	PET_DAGANNOTH_REX(ItemID.PET_DAGANNOTH_REX, "Dagannoth Rex"),
	PET_DAGANNOTH_PRIME(ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Prime"),
	PET_DAGANNOTH_SUPREME(ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Supreme"),
	VORKI(ItemID.VORKI, "Vorkath"),
	BLOODHOUND(ItemID.BLOODHOUND, "Clue Scroll Master"),
	HERBI(ItemID.HERBI, "Herbiboar");

	private final int petID;
	private final String[] bossNames;
	private static final Map<String, Pet> byBossName = buildBossMap();

	Pet(int id, String... bossNames)
	{
		this.petID = id;
		this.bossNames = bossNames;
	}

	public static Pet getByBossName(String name)
	{
		return byBossName.get(name.toUpperCase());
	}

	private static Map<String, Pet> buildBossMap()
	{
		Map<String, Pet> byName = new HashMap<>();
		for (Pet pet : values())
		{
			String[] droppingBosses = pet.getBossNames();
			for (String bossName : droppingBosses)
			{
				byName.put(bossName.toUpperCase(), pet);
			}
		}
		return byName;
	}
}