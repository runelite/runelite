package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface GameObject
{
	@Import("renderable")
	Renderable getRenderable();

	@Import("plane")
	int getPlane();

	@Import("relativeX")
	int getRelativeX();

	@Import("relativeY")
	int getRelativeY();

	@Import("offsetX")
	int getOffsetX();

	@Import("offsetY")
	int getOffsetY();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("height")
	int getHeight();

	@Import("orientation")
	int getOrientation();

	@Import("hash")
	int getHash();

	@Import("flags")
	int getFlags();
}
