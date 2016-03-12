package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Tile
{
	@Import("objects")
	GameObject[] getObjects();

	@Import("itemLayer")
	ItemLayer getItemLayer();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("plane")
	int getPlane();
}
