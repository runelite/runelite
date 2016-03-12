package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Ignore
{
	@Import("name")
	String getName();

	@Import("prevousName")
	String getPreviousName();
}
