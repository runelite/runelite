package net.runelite.rs.api;

public interface Tile
{
	GameObject[] getObjects();

	ItemLayer getItemLayer();

	int getX();

	int getY();

	int getPlane();
}
