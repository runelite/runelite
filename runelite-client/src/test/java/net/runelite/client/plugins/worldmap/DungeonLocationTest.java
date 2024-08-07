package net.runelite.client.plugins.worldmap;

import java.util.stream.Stream;
import junit.framework.TestCase;
import static org.apache.commons.lang3.ArrayUtils.isSorted;
import org.junit.Test;

public class DungeonLocationTest extends TestCase
{
	@Test
	public void testDungeonLocationsAlphabetized()
	{
		assertTrue("Entries in Dungeon Locations must be sorted alphabetically.", isSorted(Stream.of(FairyRingLocation.values()).map(FairyRingLocation::name).toArray(String[]::new)));
	}

	public void testUniqueWorldPoints()
	{
		assertEquals("Entries in Dungeon Locations must have unique world points", Stream.of(MinigameLocation.values()).map(MinigameLocation::getLocation).distinct().count(), MinigameLocation.values().length);
	}
}