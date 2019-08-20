package net.runelite.rs.api;

import net.runelite.api.WallObject;
import net.runelite.mapping.Import;

public interface RSBoundaryObject extends WallObject
{
	@Import("tag")
	@Override
	long getHash();

	@Import("x")
	@Override
	int getX();

	@Import("y")
	@Override
	int getY();

	@Import("orientationA")
	@Override
	int getOrientationA();

	@Import("orientationB")
	@Override
	int getOrientationB();

	@Import("entity1")
	@Override
	RSEntity getEntity1();

	@Import("entity2")
	@Override
	RSEntity getEntity2();

	@Import("flags")
	@Override
	int getConfig();

	void setPlane(int plane);
}
