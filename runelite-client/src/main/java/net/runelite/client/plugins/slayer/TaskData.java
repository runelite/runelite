package net.runelite.client.plugins.slayer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskData
{
	private long elapsedTime;
	private int elapsedKills;
	private int elapsedXp;
	private int amount, initialAmount, lastCertainAmount;
	private String taskLocation;
	private String taskName;
	private boolean paused;

	public void tick(long delta)
	{
		if (!paused)
		{
			elapsedTime += delta;
		}
	}
}