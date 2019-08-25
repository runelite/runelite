package net.runelite.rs.api;

import net.runelite.api.TileItemPile;
import net.runelite.mapping.Import;

public interface RSTileItemPile extends TileItemPile
{
	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("tag")
	@Override
	long getHash();

	@Import("height")
	int getHeight();

	@Import("first")
	@Override
	RSEntity getBottom();

	@Import("second")
	@Override
	RSEntity getMiddle();

	@Import("third")
	@Override
	RSEntity getTop();

	void setPlane(int plane);
}
