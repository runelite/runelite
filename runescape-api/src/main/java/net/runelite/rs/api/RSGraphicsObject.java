package net.runelite.rs.api;

import net.runelite.api.GraphicsObject;
import net.runelite.mapping.Import;

public interface RSGraphicsObject extends GraphicsObject, RSEntity
{
	@Import("id")
	@Override
	int getId();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("cycleStart")
	@Override
	int getStartCycle();

	@Import("plane")
	@Override
	int getLevel();

	@Import("height")
	@Override
	int getHeight();
}
