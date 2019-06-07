package rs.api;

import api.Renderable;
import net.runelite.mapping.Import;

public interface RSDynamicObject extends RSEntity, Renderable
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
