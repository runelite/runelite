package net.runelite.client.plugins.itemstats.potions;

import java.time.Duration;
import net.runelite.api.gameval.ItemID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PotionDurationTest
{
	@Test
	public void testAraxyteVenomSac()
	{
		final PotionDuration potionDuration = PotionDuration.get(ItemID.ARAXYTE_VENOM_SACK);
		final PotionDuration.PotionDurationRange[] ranges = potionDuration.getDurationRanges();

		assertEquals(2, ranges.length);
		assertEquals("Anti-venom", ranges[0].getPotionName());
		assertEquals(Duration.ZERO, ranges[0].getLowestDuration());
		assertEquals(Duration.ofSeconds(18), ranges[0].getHighestDuration());
		assertEquals("Anti-poison", ranges[1].getPotionName());
		assertEquals(Duration.ofSeconds(702), ranges[1].getLowestDuration());
		assertEquals(Duration.ofSeconds(702), ranges[1].getHighestDuration());
	}

	@Test
	public void testVenomProtectionDurations()
	{
		assertRanges(PotionDuration.get(ItemID.ANTIDOTE__4),
			Duration.ofSeconds(18), Duration.ofSeconds(36), Duration.ofMinutes(12));
		assertRanges(PotionDuration.get(ItemID.ANTIVENOM4),
			Duration.ofSeconds(36), Duration.ofSeconds(54), Duration.ofMinutes(12));
		assertRanges(PotionDuration.get(ItemID.ANTIVENOM_4),
			Duration.ofSeconds(216), Duration.ofSeconds(216), Duration.ofMinutes(15));
		assertRanges(PotionDuration.get(ItemID.EXTENDED_ANTIVENOM_4),
			Duration.ofSeconds(378), Duration.ofSeconds(378), Duration.ofSeconds(1062));
	}

	@Test
	public void testPoisonRemedies()
	{
		assertTrue(PotionDuration.get(ItemID._4DOSEANTIPOISON).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID._4DOSE2ANTIPOISON).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.SANFEW_SALVE_4_DOSE).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.ANTIDOTE_4).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.ANTIDOTE__4).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.ARAXYTE_VENOM_SACK).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.ANTIVENOM4).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.ANTIVENOM_4).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.EXTENDED_ANTIVENOM_4).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.BRUTAL_1DOSEANTIPOISON).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.BRUTAL_1DOSE2ANTIPOISON).isPoisonRemedy());
		assertTrue(PotionDuration.get(ItemID.BRUTAL_ANTIDOTE_1).isPoisonRemedy());
		assertFalse(PotionDuration.get(ItemID._4DOSE1ANTIDRAGON).isPoisonRemedy());
	}

	private static void assertRanges(PotionDuration potionDuration, Duration lowestVenom,
		Duration highestVenom, Duration poison)
	{
		final PotionDuration.PotionDurationRange[] ranges = potionDuration.getDurationRanges();

		assertEquals("Anti-venom", ranges[0].getPotionName());
		assertEquals(lowestVenom, ranges[0].getLowestDuration());
		assertEquals(highestVenom, ranges[0].getHighestDuration());
		assertEquals("Anti-poison", ranges[1].getPotionName());
		assertEquals(poison, ranges[1].getLowestDuration());
		assertEquals(poison, ranges[1].getHighestDuration());
	}
}
