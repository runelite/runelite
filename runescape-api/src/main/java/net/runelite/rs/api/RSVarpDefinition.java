package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSVarpDefinition extends RSDualNode
{
	@Import("type")
	int getType();
}
