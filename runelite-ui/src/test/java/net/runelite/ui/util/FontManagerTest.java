package net.runelite.ui.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class FontManagerTest
{
	@Test
	public void getDefaultFont()
	{
		assertNotNull(FontManager.getDefaultFont());
	}

	@Test
	public void getSmallFont()
	{
		assertNotNull(FontManager.getSmallFont());
	}

}
