package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Node
{
	@Import("next")
	Node getNext();

	@Import("hash")
	long getHash();

	@Import("previous")
	Node getPrevious();
}
