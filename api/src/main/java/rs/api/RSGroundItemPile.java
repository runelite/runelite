package rs.api;

import api.ItemLayer;
import net.runelite.mapping.Import;

public interface RSGroundItemPile extends ItemLayer
{
	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("tag")
	@Override
	long getHash();

	@Import("height")
	int getHeight();

	@Import("third")
	@Override
	RSEntity getBottom();

	@Import("second")
	@Override
	RSEntity getMiddle();

	@Import("first")
	@Override
	RSEntity getTop();

	void setPlane(int plane);
}
