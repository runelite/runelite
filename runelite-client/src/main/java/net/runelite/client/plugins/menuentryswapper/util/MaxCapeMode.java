package net.runelite.client.plugins.menuentryswapper.util;

public enum MaxCapeMode
{
	WARRIORS_GUILD("Warriors' Guild"),
	FISHING_TELEPORT("Fishing Teleport"),
	CRAFTING_GUILD("Crafting Guild"),
	TELE_TO_POH("Tele to POH"),
	POH_PORTALS("POH Portals"),
	OTHER_TELEPORTS("Other Teleports"),
	SPELLBOOK("Spellbook"),
	FEATURES("Features");

	private final String name;

	MaxCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
