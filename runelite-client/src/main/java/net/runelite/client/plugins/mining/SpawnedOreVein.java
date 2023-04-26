package net.runelite.client.plugins.mining;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpawnedOreVein
{
	private final int x;
	private final int y;
	private long spawnTime; // spawn time of ore vein in milliseconds

	public void setSpawnTime(long spawnTime)
	{
		this.spawnTime = spawnTime;
	}
}
