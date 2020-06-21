package net.runelite.client.plugins.banktabnames;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("BankTabNames")
public interface BankTabNamesConfig extends Config
{

	@ConfigSection(
		name = "Bank Tab 0",
		description = "Settings for the first Bank tab",
		position = 0
	)
	String bankTabSection0 = "bankTabSection0";

	@ConfigSection(
		name = "Bank Tab 1",
		description = "Settings for Bank tab 1",
		position = 1
	)
	String bankTabSection1 = "bankTabSection";

	@ConfigSection(
		name = "Bank Tab 2",
		description = "Settings for Bank tab 2",
		position = 2
	)
	String bankTabSection2 = "bankTabSection2";

	@ConfigSection(
		name = "Bank Tab 3",
		description = "Settings for Bank tab 3",
		position = 3
	)
	String bankTabSection3 = "bankTabSection3";

	@ConfigSection(
		name = "Bank Tab 4",
		description = "Settings for Bank tab 4",
		position = 4
	)
	String bankTabSection4 = "bankTabSection4";

	@ConfigSection(
		name = "Bank Tab 5",
		description = "Settings for Bank tab 5",
		position = 5
	)
	String bankTabSection5 = "bankTabSection5";

	@ConfigSection(
		name = "Bank Tab 6",
		description = "Settings for Bank tab 6",
		position = 6
	)
	String bankTabSection6 = "bankTabSection6";

	@ConfigSection(
		name = "Bank Tab 7",
		description = "Settings for Bank tab 7",
		position = 7
	)
	String bankTabSection7 = "bankTabSection7";

	@ConfigSection(
		name = "Bank Tab 8",
		description = "Settings for Bank tab 8",
		position = 8
	)
	String bankTabSection8 = "bankTabSection8";

	@ConfigSection(
		name = "Bank Tab 9",
		description = "Settings for Bank tab 9",
		position = 9
	)
	String bankTabSection9 = "bankTabSection9";


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "disableMainTabName",
		name = "Keep Tab 0 Icon",
		description = "Keeps the Infinity Symbol for the Primary tab.",
		position = 10,
		section = bankTabSection0
	)
	default boolean disableMainTabName()
	{
		return false;
	}

	@ConfigItem(
		keyName = "bankFont0",
		name = "Font",
		description = "Select a font for each tab.",
		position = 10,
		section = bankTabSection0
	)
	default TabFonts bankFont0()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor0",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 11,
		section = bankTabSection0
	)
	default Color bankFontColor0()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab0Name",
		name = "Bank Tab 0",
		description = "The name of your bank tab.",
		position = 12,
		section = bankTabSection0
	)
	default String tab0Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont1",
		name = "Font",
		description = "Select a font for each tab.",
		position = 10,
		section = bankTabSection1
	)
	default TabFonts bankFont1()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor1",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 11,
		section = bankTabSection1
	)
	default Color bankFontColor1()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab1Name",
		name = "Bank Tab 1",
		description = "The name of your bank tab.",
		position = 12,
		section = bankTabSection1
	)
	default String tab1Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont2",
		name = "Font",
		description = "Select a font for each tab.",
		position = 13,
		section = bankTabSection2
	)
	default TabFonts bankFont2()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor2",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 14,
		section = bankTabSection2
	)
	default Color bankFontColor2()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab2Name",
		name = "Bank Tab 2",
		description = "The name of your bank tab.",
		position = 15,
		section = bankTabSection2
	)
	default String tab2Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont3",
		name = "Font",
		description = "Select a font for each tab.",
		position = 16,
		section = bankTabSection3
	)
	default TabFonts bankFont3()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor3",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 17,
		section = bankTabSection3
	)
	default Color bankFontColor3()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab3Name",
		name = "Bank Tab 3",
		description = "The name of your bank tab.",
		position = 18,
		section = bankTabSection3
	)
	default String tab3Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont4",
		name = "Font",
		description = "Select a font for each tab.",
		position = 19,
		section = bankTabSection4
	)
	default TabFonts bankFont4()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor4",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 20,
		section = bankTabSection4
	)
	default Color bankFontColor4()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab4Name",
		name = "Bank Tab 4",
		description = "The name of your bank tab.",
		position = 21,
		section = bankTabSection4
	)
	default String tab4Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont5",
		name = "Font",
		description = "Select a font for each tab.",
		position = 22,
		section = bankTabSection5
	)
	default TabFonts bankFont5()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor5",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 23,
		section = bankTabSection5
	)
	default Color bankFontColor5()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab5Name",
		name = "Bank Tab 5",
		description = "The name of your bank tab.",
		position = 24,
		section = bankTabSection5
	)
	default String tab5Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont6",
		name = "Font",
		description = "Select a font for each tab.",
		position = 25,
		section = bankTabSection6
	)
	default TabFonts bankFont6()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor6",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 26,
		section = bankTabSection6
	)
	default Color bankFontColor6()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab6Name",
		name = "Bank Tab 6",
		description = "The name of your bank tab.",
		position = 27,
		section = bankTabSection6
	)
	default String tab6Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont7",
		name = "Font",
		description = "Select a font for each tab.",
		position = 28,
		section = bankTabSection7
	)
	default TabFonts bankFont7()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor7",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 29,
		section = bankTabSection7
	)
	default Color bankFontColor7()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab7Name",
		name = "Bank Tab 7",
		description = "The name of your bank tab.",
		position = 30,
		section = bankTabSection7
	)
	default String tab7Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont8",
		name = "Font",
		description = "Select a font for each tab.",
		position = 31,
		section = bankTabSection8
	)
	default TabFonts bankFont8()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor8",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 32,
		section = bankTabSection8
	)
	default Color bankFontColor8()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab8Name",
		name = "Bank Tab 8",
		description = "The name of your bank tab.",
		position = 33,
		section = bankTabSection8
	)
	default String tab8Name()
	{
		return "";
	}


	// ---- BANK TAB DIVIDER ---- \\
	@ConfigItem(
		keyName = "bankFont9",
		name = "Font",
		description = "Select a font for each tab.",
		position = 34,
		section = bankTabSection9
	)
	default TabFonts bankFont9()
	{
		return TabFonts.QUILL_8;
	}

	@ConfigItem(
		keyName = "bankTextColor9",
		name = "Text color",
		description = "Colors the text of your Bank Tab Names",
		position = 35,
		section = bankTabSection9
	)
	default Color bankFontColor9()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "tab9Name",
		name = "Bank Tab 9",
		description = "The name of your bank tab.",
		position = 36,
		section = bankTabSection9
	)
	default String tab9Name()
	{
		return "";
	}
}
