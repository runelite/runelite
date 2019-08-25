package net.runelite.rs.api;

import net.runelite.api.DecorativeObject;
import net.runelite.mapping.Import;

public interface RSWallDecoration extends DecorativeObject
{
	@Import("tag")
	@Override
	long getHash();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("xOffset")
	int getXOffset();

	@Import("yOffset")
	int getYOffset();

	@Import("orientation2")
	int getOrientation();

	@Import("entity1")
	@Override
	RSEntity getEntity1();

	@Import("entity2")
	@Override
	RSEntity getEntity2();

	void setPlane(int plane);
}
