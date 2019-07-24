package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSBuffer extends RSNode
{
	@Import("array")
	byte[] getPayload();

	@Import("offset")
	int getOffset();
}