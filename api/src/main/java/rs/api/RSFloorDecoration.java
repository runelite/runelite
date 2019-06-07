package rs.api;

import api.GroundObject;
import net.runelite.mapping.Import;

public interface RSFloorDecoration extends GroundObject
{
	@Import("tag")
	@Override
	long getHash();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("entity")
	@Override
	RSEntity getRenderable();

	void setPlane(int plane);
}
