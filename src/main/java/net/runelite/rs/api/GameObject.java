package net.runelite.rs.api;

public interface GameObject
{
	Renderable getRenderable();

	int getPlane();

	int getRelativeX();

	int getRelativeY();

	int getOffsetX();

	int getOffsetY();

	int getX();

	int getY();

	int getHeight();

	int getOrientation();

	int getHash();

	int getFlags();
}
