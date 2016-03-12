package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface ItemLayer
{
	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("hash")
	int getHash();

	@Import("flags")
	int getFlags();

	@Import("height")
	int getHeight();

	@Import("bottom")
	Renderable getBottom();

	@Import("middle")
	Renderable getMiddle();

	@Import("top")
	Renderable getTop();
}
