package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSRunException
{
	@Import("throwable")
	Throwable getParent();
}
