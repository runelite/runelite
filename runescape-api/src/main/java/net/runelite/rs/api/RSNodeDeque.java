package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSNodeDeque
{
	@Import("current")
	RSNode getCurrent();

	@Import("sentinel")
	RSNode getHead();

	@Import("last")
	RSNode last();

	@Import("previous")
	RSNode previous();

	@Import("addFirst")
	void addFirst(RSNode val);
}
