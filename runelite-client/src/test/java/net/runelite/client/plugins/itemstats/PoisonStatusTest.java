package net.runelite.client.plugins.itemstats;

import java.time.Instant;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PoisonStatusTest
{
	private final PoisonStatus poisonStatus = new PoisonStatus();

	@Test
	public void testVenomTooltip()
	{
		final Instant now = Instant.EPOCH;
		poisonStatus.update(1000000, now);

		assertEquals(
			"Next venom damage: <col=ff0000>6</col></br>Time until damage: 0:18",
			poisonStatus.createTooltip(now));
		assertEquals(
			"Next venom damage: <col=ff0000>6</col></br>Time until damage: 0:08",
			poisonStatus.createTooltip(now.plusSeconds(10)));
	}

	@Test
	public void testPoisonTooltip()
	{
		final Instant now = Instant.EPOCH;
		poisonStatus.update(25, now);

		assertEquals(
			"Next poison damage: <col=ff0000>5</col></br>Time until damage: 0:18",
			poisonStatus.createTooltip(now));
	}

	@Test
	public void testNextDamage()
	{
		assertEquals(1, PoisonStatus.nextDamage(1));
		assertEquals(1, PoisonStatus.nextDamage(5));
		assertEquals(2, PoisonStatus.nextDamage(6));
		assertEquals(6, PoisonStatus.nextDamage(1000000));
		assertEquals(8, PoisonStatus.nextDamage(1000001));
		assertEquals(20, PoisonStatus.nextDamage(1000007));
		assertEquals(20, PoisonStatus.nextDamage(1000100));
	}

	@Test
	public void testTooltipClearsWhenVenomIsCured()
	{
		poisonStatus.update(1000000, Instant.EPOCH);
		poisonStatus.update(0, Instant.EPOCH);

		assertNull(poisonStatus.createTooltip(Instant.EPOCH));
	}
}
