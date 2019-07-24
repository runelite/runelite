package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSHealthBarUpdate
{
	@Import("health")
	int getHealthRatio();

	@Import("health2") // not sure about that one but it isn't used and I am sure about the other one
	int getHealth();
}
