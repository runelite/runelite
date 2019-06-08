package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSIterableNodeDeque
{
	@Import("sentinel")
	RSNode getCurrent();
}
