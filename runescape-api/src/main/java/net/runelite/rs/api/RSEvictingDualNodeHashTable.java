package net.runelite.rs.api;

import net.runelite.api.NodeCache;
import net.runelite.mapping.Import;

public interface RSEvictingDualNodeHashTable extends NodeCache
{
	@Import("get")
	RSDualNode get(long id);

	@Import("clear")
	@Override
	void reset();

	@Import("capacity")
	@Override
	void setCapacity(int capacity);

	@Import("remainingCapacity")
	@Override
	void setRemainingCapacity(int remainingCapacity);
}
