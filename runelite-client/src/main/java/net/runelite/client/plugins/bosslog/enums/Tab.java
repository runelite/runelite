package net.runelite.client.plugins.bosslog.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Tab
{
	OVERVIEW("Overview", 0),
	ZULRAH("Zulrah", ItemID.PET_SNAKELING),
	VORKATH("Vorkath", ItemID.VORKI),
	COX("Chambers of Xeric", ItemID.OLMLET),
	TOB("Theatre of Blood", ItemID.LIL_ZIK),
	BANDOS("General Graardor", ItemID.PET_GENERAL_GRAARDOR),
	ZAMORAK("K'ril Tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH),
	SARADOMIN("Commander Zilyana", ItemID.PET_ZILYANA),
	ARMADYL("Kree'arra", ItemID.PET_KREEARRA),
	CORP("Corporeal Beast", ItemID.PET_CORPOREAL_CRITTER),
	CERBERUS("Cerberus", ItemID.HELLPUPPY),
	ABYSSAL_SIRE("Abyssal Sire", ItemID.ABYSSAL_ORPHAN),
	KRAKEN("Kraken", ItemID.PET_KRAKEN),
	GRO_GUAR("Grotesque Guardians", ItemID.NOON),
	THERM_SMOKE_DEVIL("Thermonuclear Smoke Devil", ItemID.PET_SMOKE_DEVIL),
	DAGANNOTH_KINGS("Dagannoth Kings", ItemID.PET_DAGANNOTH_REX),
	KALPHITE_QUEEN("Kalphite Queen", ItemID.KALPHITE_PRINCESS),
	CALLISTO("Callisto", ItemID.CALLISTO_CUB),
	VETION("Vet'ion", ItemID.VETION_JR),
	VENENATIS("Venenatis", ItemID.VENENATIS_SPIDERLING),
	SCORPIA("Scorpia", ItemID.SCORPIAS_OFFSPRING),
	CRAZY_ARCHAEOLOGIST("Crazy Arch.", ItemID.FEDORA),
	CHAOS_FANATIC("Chaos Fanatic", ItemID.ANCIENT_STAFF),
	SKOTIZO("Skotizo", ItemID.SKOTOS),
	SHAMAN("Lizardmen Shaman", ItemID.DRAGON_WARHAMMER);

	private final String name;
	private final int itemID;
}
