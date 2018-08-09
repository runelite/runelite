package net.runelite.client.plugins.runecraftingtracker;

import java.time.Instant;

public class RunecraftingTrackerSession
{
	private Instant lastRuneCraft;

	public void setLastRuneCraft()
	{
		lastRuneCraft = Instant.now();
	}

	public Instant getLastRuneCraft()
	{
		return lastRuneCraft;
	}

}
