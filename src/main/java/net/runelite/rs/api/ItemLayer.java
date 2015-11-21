package net.runelite.rs.api;

public interface ItemLayer
{
	int getX();

	int getY();

	int getHash();

	int getFlags();

	int getHeight();

	Renderable getBottom();

	Renderable getMiddle();

	Renderable getTop();
}
