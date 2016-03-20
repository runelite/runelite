package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface MessageNode
{
	@Import("type")
	int getType();

	@Import("sender")
	String getSender();

	@Import("value")
	String getValue();
}
