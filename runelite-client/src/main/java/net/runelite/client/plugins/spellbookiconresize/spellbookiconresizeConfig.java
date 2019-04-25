package net.runelite.client.plugins.spellbookiconresize;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spellbookfixer")
public interface spellbookiconresizeConfig extends Config
{
	@ConfigItem(position = 0, keyName = "shouldHideOthers", name = "Hide Others", description = "Toggle on to hide spells not useful for pking that cannot be filtered otherwise.")
	default boolean shouldHideOthers()
	{
		return true;
	}

	//ice blitz
	@ConfigItem(position = 1, keyName = "shouldModifyBloodBarrage", name = "Blood Barrage", description = "Toggle on to Blood Barrage modifications.")
	default boolean shouldModifyBloodBarrage() { return true; }
	@ConfigItem(position = 2, keyName = "getBloodPositionX", name = "Blood Barrage Pos X", description = "Modifies the X-axis position of Blood Barrage.")
	default int getBloodPositionX()
	{
		return 0;
	}
	@ConfigItem(position = 3, keyName = "getBloodPositionY", name = "Blood Barrage Pos Y", description = "Modifies the Y-axis position of Blood Barrage.")
	default int getBloodPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 4, keyName = "getBloodSize", name = "Blood Barrage Size", description = "Modifies the width of Blood Barrage.")
	default int getBloodSize() { return 100; }
	@ConfigItem(position = 6, keyName = "shouldHideBloodBarrage", name = "Hide Blood Barrage", description = "Enable this to hide blood barrage")
	default boolean shouldHideBloodBarrage()
	{
		return false;
	}
	//ice barrage
	@ConfigItem(position = 7, keyName = "shouldModifyIceBarrage", name = "Ice Barrage", description = "Toggle on to enable Ice Barrage modifications.")
	default boolean shouldModifyIceBarrage() { return true; }
	@ConfigItem(position = 8, keyName = "getBarragePositionX", name = "Ice Barrage Pos X", description = "Modifies the X-axis position of Ice Barrage.")
	default int getBarragePositionX()
	{
		return 0;
	}
	@ConfigItem(position = 9, keyName = "getBarragePositionY", name = "Ice Barrage Pos y", description = "Modifies the X-axis position of Ice Barrage.")
	default int getBarragePositionY()
	{
		return 75;
	}
	@ConfigItem(position = 10, keyName = "getBarrageSize", name = "Ice Barrage Size", description = "Modifies the width position of Ice Barrage.")
	default int getBarrageSize()
	{
		return 100;
	}
	@ConfigItem(position = 12, keyName = "shouldHideIceBarrage", name = "Hide Ice Barrage", description = "Enable this to hide Ice barrage")
	default boolean shouldHideIceBarrage()
	{
		return false;
	}

	@ConfigItem(position = 13, keyName = "shouldModifyIceBlitz", name = "Ice Blitz", description = "Toggle on to enable Ice Blitz modifications.")
	default boolean shouldModifyIceBlitz() { return true; }
	@ConfigItem(position = 14, keyName = "getBlitzPositionX", name = "Ice Blitz Pos X", description = "Modifies the X-axis position of Ice Blitz.")
	default int getBlitzPositionX() { return 0; }
	@ConfigItem(position = 15, keyName = "getBlitzPositionY", name = "Ice Blitz Pos y", description = "Modifies the X-axis position of Ice Blitz.")
	default int getBlitzPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 16, keyName = "getBlitzeSize", name = "Ice Blitz Size", description = "Modifies the width position of Ice Blitz.")
	default int getBlitzSize()
	{
		return 100;
	}
	@ConfigItem(position = 17, keyName = "shouldHideIceBlitz", name = "Hide Ice Blitz", description = "Enable this to hide Ice blitz")
	default boolean shouldHideIceBlitz()
	{
		return false;
	}

	@ConfigItem(position = 18, keyName = "shouldModifyBloodBlitz", name = "Blood Blitz", description = "Toggle on to enable Ice Blitz modifications.")
	default boolean shouldModifyBloodBlitz() { return true; }
	@ConfigItem(position = 19, keyName = "getBloodBlitzPositionX", name = "Blood Blitz Pos X", description = "Modifies the X-axis position of Blood Blitz.")
	default int getBloodBlitzPositionX() { return 0; }
	@ConfigItem(position = 20, keyName = "getBloodBlitzPositionY", name = "Blood Blitz Pos y", description = "Modifies the X-axis position of Blood Blitz.")
	default int getBloodBlitzPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 21, keyName = "getBloodBlitzSize", name = "Blood Blitz Size", description = "Modifies the width position of Blood Blitz.")
	default int getBloodBlitzSize()
	{
		return 100;
	}
	@ConfigItem(position = 22, keyName = "shouldHideBLoodBlitz", name = "Hide Blood Blitz", description = "Enable this to hide Blood blitz")
	default boolean shouldHideBloodBlitz()
	{
		return false;
	}


}