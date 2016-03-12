package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Deque
{
	@Import("current")
	Node getCurrent();

	@Import("head")
	Node getHead();
}
