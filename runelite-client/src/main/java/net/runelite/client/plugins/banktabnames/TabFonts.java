package net.runelite.client.plugins.banktabnames;

public enum TabFonts
{
	PLAIN_11("PLAIN_11", 494),
	PLAIN_12("PLAIN_12", 495),
	BOLD_12("BOLD_12", 496),
	QUILL_8("QUILL_8", 497),
	QUILL_MEDIUM("QUILL_MEDIUM", 645), // Almost too big, Leaving in for now.
	//  QUILL_CAPS_LARGE("QUILL_CAPS_LARGE", 646),	// WAY too big!
//	FAIRY_SMALL("FAIRY_SMALL", 647),	// Wingdings basically, Uppercase Characters work.
//	FAIRY_LARGE("FAIRY_LARGE", 648),	// Wingdings basically, Single Uppercase Characters work.
	BARBARIAN("BARBARIAN", 764),
	SUROK("SUROK", 819),
	VERDANA_11("VERDANA_11", 1442),
	VERDANA_11_BOLD("VERDANA_11_BOLD", 1443),
	TAHOMA_11("TAHOMA_11", 1444),
	VERDANA_13("VERDANA_13", 1445),
	VERDANA_13_BOLD("VERDANA_13_BOLD", 1446),
	VERDANA_15("VERDANA_15", 1447),
	;

	private final String tabFontName;
	public int tabFontId;

	TabFonts(String tabFontName)
	{
		this.tabFontName = tabFontName;
		this.tabFontId = 0;
	}

	TabFonts(String tabFontName, int tabFontId)
	{
		this.tabFontName = tabFontName;
		this.tabFontId = tabFontId;
	}
}
