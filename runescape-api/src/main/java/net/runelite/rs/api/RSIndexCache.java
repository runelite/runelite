package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSIndexCache extends RSAbstractIndexCache
{
	@Import("index")
	int getIndex();
}
