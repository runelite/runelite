package net.runelite.client.plugins.shootingstars;

import java.util.Arrays;
import java.util.List;

public enum StarRegion
{
	ASGARNIA("Asgarnia"),
	CRANDOR_KARAMJA("Crandor or Karamja", "Karamja"),
	FELDIP_HILLS("Feldip Hills or on the Isle of Souls", "Feldip Hills"),
	FOSSIL_ISLAND("Fossil Island or on Mos Le'Harmless", "Fossil Island"),
	FREMENNIK_LANDS("Fremennik Lands or on Lunar Isle", "Fremennik Lands"),
	GREAT_KOUREND("Great Kourend"),
	KANDARIN("Kandarin"),
	KEBOS_LOWLANDS("Kebos Lowlands"),
	KHARIDIAN_DESERT("Kharidian Desert"),
	MISTHALIN("Misthalin"),
	MORYTANIA("Morytania"),
	PISCATORIS_GNOME_STRONGHOLD("Piscatoris or the Gnome Stronghold"),
	TIRANNWN("Tirannwn"),
	WILDERNESS("Wilderness");

	private final String name;
	private final String shortName;
	private final List<StarCrashSite> crashSites;

	StarRegion(String name, StarCrashSite... crashSites)
	{
		this(name, name, crashSites);
	}

	StarRegion(String name, String shortName, StarCrashSite... crashSites)
	{
		this.name = name;
		this.shortName = shortName;
		this.crashSites = Arrays.asList(crashSites);
	}
}
