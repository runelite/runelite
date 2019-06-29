package net.runelite.rs.api;

import net.runelite.api.DynamicObject;
import net.runelite.api.Renderable;
import net.runelite.mapping.Import;

public interface RSDynamicObject extends RSEntity, DynamicObject, Renderable
{
	@Import("id")
	int getId();

	@Import("frame")
	int getAnimFrame();

	@Import("frame")
	void setAnimFrame(int frame);

	@Import("cycleStart")
	int getAnimCycleCount();
}
