package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface CacheableNode
{
	@Import("next")
	CacheableNode getNext();

	@Import("previous")
	CacheableNode getPrevious();
}
