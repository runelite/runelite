package net.runelite.client.game;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AgilityShortcutTest extends TestCase
{
	@Test
	public void testAgilityShortcutsSorted()
	{
		final AgilityShortcut[] sorted = Arrays.stream(AgilityShortcut.values())
			.sorted(Comparator.comparingInt(AgilityShortcut::getLevel).thenComparing(Enum::name))
			.collect(Collectors.toList())
			.toArray(AgilityShortcut[]::new);

		Assert.assertArrayEquals("Entries in AgilityShortcut must be sorted by level required first, then alphabetically", sorted, AgilityShortcut.values());
	}
}