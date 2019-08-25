package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSArchive extends RSAbstractArchive
{
	@Import("index")
	int getIndex();
}
