package net.runelite.client.plugins.dpscounter;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class DpsMember
{
	private final String name;
	private Instant start = Instant.now();
	private Instant end;
	private int damage;

	void addDamage(int amount)
	{
		damage += amount;
	}

	float getDps()
	{
		Instant now = end == null ? Instant.now() : end;
		int diff = (int) (now.toEpochMilli() - start.toEpochMilli()) / 1000;
		if (diff == 0)
		{
			return 0;
		}

		return (float) damage / (float) diff;
	}

	void pause()
	{
		end = Instant.now();
	}

	boolean isPaused()
	{
		return end != null;
	}

	void unpause()
	{
		if (end == null)
		{
			return;
		}

		start = start.plus(Duration.between(end, Instant.now()));
		end = null;
	}
}
