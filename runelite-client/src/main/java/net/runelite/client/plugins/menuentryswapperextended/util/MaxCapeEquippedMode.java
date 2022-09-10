package net.runelite.client.plugins.menuentryswapperextended.util;

public enum MaxCapeEquippedMode
{
	OFF("None"),
	TELE_TO_POH("Tele to POH"),
	CRAFTING_GUILD("Crafting Guild"),
	FISHING_TELEPORTS("Fishing Tele"),
	WARRIORS_GUILD("Warriors' Guild"),
	POH_PORTRALS("POH Portals"),
	OTHER_TELEPORTS("Other Teleports"),
	SPELLBOOK("Spellbook"),
	FEATURES("Features");

	private final String name;

	MaxCapeEquippedMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}

