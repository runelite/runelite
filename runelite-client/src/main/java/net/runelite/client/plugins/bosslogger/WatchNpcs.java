package net.runelite.client.plugins.bosslogger;

import lombok.Getter;
import net.runelite.api.NpcID;
import java.util.HashMap;
import java.util.Map;

public enum WatchNpcs
{
	ZULRAH("Zulrah", NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044),
	VORKATH("Vorkath", NpcID.VORKATH, NpcID.VORKATH_8058, NpcID.VORKATH_8059, NpcID.VORKATH_8060, NpcID.VORKATH_8061),

	// God wars dungeon & Minions TODO: Figure out how to allow Minion toggle
	/*
	ARMADYL("Armadyl", NpcID.KREEARRA, NpcID.KREEARRA_6492, NpcID.WINGMAN_SKREE, NpcID.FLOCKLEADER_GEERIN, NpcID.FLIGHT_KILISA),
	BANDOS("Bandos", NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494, NpcID.SERGEANT_STRONGSTACK, NpcID.SERGEANT_STEELWILL, NpcID.SERGEANT_GRIMSPIKE),
	SARADOMIN("Saradomin", NpcID.COMMANDER_ZILYANA, NpcID.COMMANDER_ZILYANA_6493, NpcID.STARLIGHT, NpcID.GROWLER, NpcID.BREE),
	ZAMMY("Zammy", NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495, NpcID.BALFRUG_KREEYATH, NpcID.TSTANON_KARLAK, NpcID.ZAKLN_GRITCH),
	*/

	// God wars dungeon bosses
	ARMADYL("Armadyl", NpcID.KREEARRA, NpcID.KREEARRA_6492),
	BANDOS("Bandos", NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494),
	SARADOMIN("Saradomin", NpcID.COMMANDER_ZILYANA, NpcID.COMMANDER_ZILYANA_6493),
	ZAMMY("Zammy", NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495),

	// Wildy Bosses
	VETION("Vet'ion", NpcID.VETION_REBORN),
	VENENATIS("Venenatis", NpcID.VENENATIS, NpcID.VENENATIS_6610),
	CALLISTO("Callisto", NpcID.CALLISTO, NpcID.CALLISTO_6609),
	CHAOS_ELEMENTAL("Chaos Elemental", NpcID.CHAOS_ELEMENTAL, NpcID.CHAOS_ELEMENTAL_6505),
	// Wildy Demi-Bosses
	SCORPIA("Scorpia", NpcID.SCORPIA),
	CHAOS_FANATIC("Chaos Fanatic", NpcID.CHAOS_FANATIC),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", NpcID.CRAZY_ARCHAEOLOGIST),
	// Wildy Other
	KING_BLACK_DRAGON("King Black Dragon", NpcID.KING_BLACK_DRAGON, NpcID.KING_BLACK_DRAGON_2642, NpcID.KING_BLACK_DRAGON_6502),

	// Slayer Bosses
	KALPHITE_QUEEN("Kalphite Queen", NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_QUEEN_963, NpcID.KALPHITE_QUEEN_965, NpcID.KALPHITE_QUEEN_4303, NpcID.KALPHITE_QUEEN_4304, NpcID.KALPHITE_QUEEN_6500, NpcID.KALPHITE_QUEEN_6501),
	SKOTIZO("Skotizo", NpcID.SKOTIZO),
	GROTESQUE_GUARDIANS("Grotesque Guardians", NpcID.DUSK, NpcID.DUSK_7851, NpcID.DUSK_7854, NpcID.DUSK_7855, NpcID.DUSK_7882, NpcID.DUSK_7883, NpcID.DUSK_7886, NpcID.DUSK_7887, NpcID.DUSK_7888, NpcID.DUSK_7889),
	ABYSSAL_SIRE("Abyssal Sire", NpcID.ABYSSAL_SIRE, NpcID.ABYSSAL_SIRE_5887, NpcID.ABYSSAL_SIRE_5888, NpcID.ABYSSAL_SIRE_5889, NpcID.ABYSSAL_SIRE_5890, NpcID.ABYSSAL_SIRE_5891, NpcID.ABYSSAL_SIRE_5908),
	KRAKEN("Kraken", NpcID.KRAKEN_6640, NpcID.KRAKEN_6656),
	CERBERUS("Cerberus", NpcID.CERBERUS, NpcID.CERBERUS_5863, NpcID.CERBERUS_5866),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", NpcID.THERMONUCLEAR_SMOKE_DEVIL),

	// Other Bosses
	GIANT_MOLE("Giant Mole", NpcID.GIANT_MOLE, NpcID.GIANT_MOLE_6499),
	CORPOREAL_BEAST("Corporeal Beast", NpcID.CORPOREAL_BEAST),
	// Dagannoth Kings
	DAGANNOTH_REX("Dagannoth Rex", NpcID.DAGANNOTH_REX, NpcID.DAGANNOTH_REX_6498),
	DAGANNOTH_PRIME("Dagannoth Prime", NpcID.DAGANNOTH_PRIME, NpcID.DAGANNOTH_PRIME_6497),
	DAGANNOTH_SUPREME("Dagannoth Supreme", NpcID.DAGANNOTH_SUPREME, NpcID.DAGANNOTH_SUPREME_6496);

	@Getter
	private final String name;
	@Getter
	private final int[] npcIds;

	WatchNpcs(String name, int... npcIds)
	{
		this.name = name;
		this.npcIds = npcIds;
	}

	private static final Map<String, WatchNpcs> byName = buildMap();

	public static WatchNpcs getByName(String name)
	{
		return byName.get(name.toUpperCase());
	}

	private static Map<String, WatchNpcs> buildMap()
	{
		Map<String, WatchNpcs> map = new HashMap<>();
		for (WatchNpcs npcs : values())
		{
			map.put(npcs.getName().toUpperCase(), npcs);
		}

		return map;
	}

	private static final Map<Integer, WatchNpcs> byNpcId = buildNpcMap();

	public static WatchNpcs getByNpcId(int id)
	{
		return byNpcId.get(id);
	}

	private static Map<Integer, WatchNpcs> buildNpcMap()
	{
		Map<Integer, WatchNpcs> map = new HashMap<>();
		for (WatchNpcs npcs : values())
		{
			for (int id : npcs.getNpcIds())
			{
				map.put(id, npcs);
			}
		}

		return map;
	}
}
