package net.runelite.client.game;

import java.util.Comparator;
import junit.framework.TestCase;
import static org.apache.commons.lang3.ArrayUtils.isSorted;
import org.junit.Test;

public class AgilityShortcutTest extends TestCase
{
	@Test
	public void testAgilityShortcutsSorted()
	{
		assertTrue("Entries in agility shortcuts must be sorted by level required first, then alphabetically.",
		isSorted(AgilityShortcut.values(), Comparator.comparingInt(AgilityShortcut::getLevel).thenComparing(Enum::name)));
	}
}