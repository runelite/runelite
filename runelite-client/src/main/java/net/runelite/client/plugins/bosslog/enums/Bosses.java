package net.runelite.client.plugins.bosslog.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.client.plugins.bosslog.BossLogConfig;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum Bosses
{
	ZULRAH("Zulrah", new int[]{ItemID.TANZANITE_FANG, ItemID.MAGIC_FANG, ItemID.SERPENTINE_VISAGE,
			ItemID.UNCUT_ONYX, ItemID.TANZANITE_MUTAGEN, ItemID.MAGMA_MUTAGEN, ItemID.JAR_OF_SWAMP},
			new int[]{NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044},
			Tab.ZULRAH),

	VORKATH("Vorkath", new int[]{ItemID.SKELETAL_VISAGE, ItemID.DRACONIC_VISAGE, ItemID.DRAGONBONE_NECKLACE},
			new int[]{NpcID.VORKATH, NpcID.VORKATH_8058, NpcID.VORKATH_8060, NpcID.VORKATH_8061},
			Tab.VORKATH),

	COX("Chambers of Xeric", new int[]{ItemID.TWISTED_BOW, ItemID.KODAI_INSIGNIA, ItemID.ELDER_MAUL,
			ItemID.DRAGON_CLAWS, ItemID.ANCESTRAL_HAT, ItemID.ANCESTRAL_ROBE_TOP, ItemID.ANCESTRAL_ROBE_BOTTOM,
			ItemID.DINHS_BULWARK, ItemID.DRAGON_HUNTER_CROSSBOW, ItemID.TWISTED_BUCKLER, ItemID.DRAGON_THROWNAXE,
			ItemID.DRAGON_HARPOON, ItemID.DRAGON_SWORD, ItemID.ARCANE_PRAYER_SCROLL,
			ItemID.DEXTEROUS_PRAYER_SCROLL},
			new int[]{},
			Tab.COX),

	TOB("Theatre of Blood", new int[]{ ItemID.SCYTHE_OF_VITUR_UNCHARGED, ItemID.GHRAZI_RAPIER,
			ItemID.SANGUINESTI_STAFF_UNCHARGED, ItemID.AVERNIC_DEFENDER_HILT, ItemID.JUSTICIAR_FACEGUARD,
			ItemID.JUSTICIAR_CHESTGUARD, ItemID.JUSTICIAR_LEGGUARDS},
			new int[]{},
			Tab.TOB),

	BANDOS("Bandos", new int[]{ItemID.BANDOS_CHESTPLATE, ItemID.BANDOS_TASSETS, ItemID.BANDOS_BOOTS,
			ItemID.BANDOS_HILT},
			new int[]{NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494},
		Tab.BANDOS),

	ZAMORAK("Zamorak", new int[]{ItemID.ZAMORAKIAN_SPEAR, ItemID.ZAMORAK_HILT, ItemID.STAFF_OF_THE_DEAD,
			ItemID.STEAM_BATTLESTAFF},
			new int[]{NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495},
			Tab.ZAMORAK),

	SARADOMIN("Saradomin", new int[]{ItemID.SARADOMIN_SWORD, ItemID.SARADOMIN_HILT, ItemID.ARMADYL_CROSSBOW,
			ItemID.SARADOMINS_LIGHT},
			new int[]{NpcID.COMMANDER_ZILYANA, NpcID.COMMANDER_ZILYANA_6493},
			Tab.SARADOMIN),

	ARMADYL("Armadyl", new int[]{ItemID.ARMADYL_HELMET, ItemID.ARMADYL_CHESTPLATE, ItemID.ARMADYL_CHAINSKIRT,
			ItemID.ARMADYL_HILT},
			new int[]{NpcID.KREEARRA, NpcID.KREEARRA_6492},
			Tab.ARMADYL),

	CORP("Corporeal Beast", new int[]{ItemID.ELYSIAN_SIGIL, ItemID.ARCANE_SIGIL, ItemID.SPECTRAL_SIGIL,
			ItemID.HOLY_ELIXIR, ItemID.SPIRIT_SHIELD},
			new int[]{NpcID.CORPOREAL_BEAST},
			Tab.CORP),

	CERBERUS("Cerberus", new int[]{ItemID.PRIMORDIAL_CRYSTAL, ItemID.ETERNAL_CRYSTAL, ItemID.PEGASIAN_CRYSTAL,
		ItemID.SMOULDERING_STONE, ItemID.JAR_OF_SOULS},
		new int[]{NpcID.CERBERUS, NpcID.CERBERUS_5863, NpcID.CERBERUS_5866},
		Tab.CERBERUS),

	ABYSSAL_SIRE("Abyssal Sire", new int[]{ItemID.UNSIRED, ItemID.JAR_OF_MIASMA},
		new int[]{NpcID.ABYSSAL_SIRE, NpcID.ABYSSAL_SIRE_5887, NpcID.ABYSSAL_SIRE_5888, NpcID.ABYSSAL_SIRE_5889,
		NpcID.ABYSSAL_SIRE_5890, NpcID.ABYSSAL_SIRE_5891},
		Tab.ABYSSAL_SIRE),

	KRAKEN("Kraken", new int[]{ItemID.TRIDENT_OF_THE_SEAS_FULL, ItemID.KRAKEN_TENTACLE, ItemID.JAR_OF_DIRT},
			new int[]{NpcID.KRAKEN, NpcID.KRAKEN_6640, NpcID.KRAKEN_6656},
			Tab.KRAKEN),

	GRO_GUAR("Grotesque Guardians", new int[]{ItemID.BLACK_TOURMALINE_CORE, ItemID.GRANITE_GLOVES,
			ItemID.GRANITE_RING, ItemID.GRANITE_HAMMER, ItemID.JAR_OF_STONE},
			new int[]{NpcID.DUSK, NpcID.DAWN},
			Tab.GRO_GUAR),

	THERM_SMOKE_DEVIL("Therm. Smoke Devil",
			new int[]{ItemID.OCCULT_NECKLACE, ItemID.SMOKE_BATTLESTAFF, ItemID.DRAGON_CHAINBODY},
			new int[]{NpcID.THERMONUCLEAR_SMOKE_DEVIL},
			Tab.THERM_SMOKE_DEVIL),

	DAGANNOTH_KINGS("Dagannoth Kings", new int[]{ItemID.BERSERKER_RING, ItemID.ARCHERS_RING, ItemID.SEERS_RING,
			ItemID.WARRIOR_RING, ItemID.SEERCULL, ItemID.MUD_BATTLESTAFF, ItemID.DRAGON_AXE},
			new int[]{NpcID.DAGANNOTH_PRIME, NpcID.DAGANNOTH_REX, NpcID.DAGANNOTH_SUPREME},
			Tab.DAGANNOTH_KINGS),

	KALPHITE_QUEEN("Kalphite Queen", new int[]{ItemID.DRAGON_CHAINBODY, ItemID.DRAGON_2H_SWORD, ItemID.KQ_HEAD,
			ItemID.JAR_OF_SAND},
			new int[]{NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_QUEEN_965},
			Tab.KALPHITE_QUEEN),

	CALLISTO("Callisto", new int[]{ItemID.TYRANNICAL_RING},
			new int[]{NpcID.CALLISTO, NpcID.CALLISTO_6609},
			Tab.CALLISTO),

	VETION("Vet'ion", new int[]{ItemID.RING_OF_THE_GODS},
			new int[]{NpcID.VETION},
			Tab.VETION),

	VENENATIS("Venenatis", new int[]{ItemID.TREASONOUS_RING},
			new int[]{NpcID.VENENATIS},
			Tab.VENENATIS),

	SCORPIA("Scorpia", new int[]{ItemID.MALEDICTION_SHARD_3, ItemID.ODIUM_SHARD_3},
			new int[]{NpcID.SCORPIA},
			Tab.SCORPIA),

	CRAZY_ARCHAEOLOGIST("Crazy Arch.", new int[]{ItemID.MALEDICTION_SHARD_2, ItemID.ODIUM_SHARD_2},
			new int[]{NpcID.CRAZY_ARCHAEOLOGIST},
			Tab.CRAZY_ARCHAEOLOGIST),

	CHAOS_FANATIC("Chaos Fanatic", new int[]{ItemID.MALEDICTION_SHARD_1, ItemID.ODIUM_SHARD_1},
		new int[]{NpcID.CHAOS_FANATIC},
		Tab.CHAOS_FANATIC),

	SKOTIZO("Skotizo", new int[]{ItemID.ONYX, ItemID.DARK_CLAW},
			new int[]{NpcID.SKOTIZO},
			Tab.SKOTIZO),

	SHAMAN("Shaman", new int[]{ItemID.DRAGON_WARHAMMER},
			new int[]{NpcID.LIZARDMAN_SHAMAN, NpcID.LIZARDMAN_SHAMAN_6767, NpcID.LIZARDMAN_SHAMAN_7573,
					NpcID.LIZARDMAN_SHAMAN_7574, NpcID.LIZARDMAN_SHAMAN_7744, NpcID.LIZARDMAN_SHAMAN_7745},
			Tab.SHAMAN);

	private final String name;
	private final int[] uniques;
	private final int[] ids;
	private final Tab tab;

	public static List<Bosses> getTracked(BossLogConfig config)
	{
		List<Bosses> tracked = new ArrayList<>();
		if (config.trackSire()) tracked.add(Bosses.ABYSSAL_SIRE);
		if (config.trackArmadyl()) tracked.add(Bosses.ARMADYL);
		if (config.trackBandos()) tracked.add(Bosses.BANDOS);
		if (config.trackCerberus()) tracked.add(Bosses.CERBERUS);
		if (config.trackChaosFanatic()) tracked.add(Bosses.CHAOS_FANATIC);
		if (config.trackCrazyArch()) tracked.add(Bosses.CRAZY_ARCHAEOLOGIST);
		if (config.trackCorp()) tracked.add(Bosses.CORP);
		if (config.trackCOX()) tracked.add(Bosses.COX);
		if (config.trackDks()) tracked.add(Bosses.DAGANNOTH_KINGS);
		if (config.trackGroguar()) tracked.add(Bosses.GRO_GUAR);
		if (config.trackKQ()) tracked.add(Bosses.KALPHITE_QUEEN);
		if (config.trackKraken()) tracked.add(Bosses.KRAKEN);
		if (config.trackSaradomin()) tracked.add(Bosses.SARADOMIN);
		if (config.trackScorpia()) tracked.add(Bosses.SCORPIA);
		if (config.trackShaman()) tracked.add(Bosses.SHAMAN);
		if (config.trackSkotizo()) tracked.add(Bosses.SKOTIZO);
		if (config.trackThermo()) tracked.add(Bosses.THERM_SMOKE_DEVIL);
		if (config.trackTOB()) tracked.add(Bosses.TOB);
		if (config.trackVenenatis()) tracked.add(Bosses.VENENATIS);
		if (config.trackVetion()) tracked.add(Bosses.VETION);
		if (config.trackVorkath()) tracked.add(Bosses.VORKATH);
		if (config.trackZamorak()) tracked.add(Bosses.ZAMORAK);
		if (config.trackZulrah()) tracked.add(Bosses.ZULRAH);
		return tracked;
	}
}
