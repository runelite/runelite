package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Region
{
	@Import("objects")
	GameObject[] getObjects();

	@Import("tiles")
	Tile[][][] getTiles();
}
