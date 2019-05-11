package net.runelite.client.plugins.dpscounter;

import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class DpsMember
{
	private final String name;
	private Instant start = Instant.now();
	private int damage;

	void addDamage(int amount)
	{
		damage += amount;
	}

	int getDps()
	{
		int diff = (int) (Instant.now().toEpochMilli() - start.toEpochMilli()) / 1000;
		if (diff == 0) return 0;
		return damage / diff;
	}
}
