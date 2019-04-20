package net.runelite.client.plugins.spellbookfixer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spellbookfixer")
public interface SpellbookFixerConfig extends Config
{
    @ConfigItem(position = 0, keyName = "shouldHideOthers", name = "Hide Others", description = "Toggle on to hide spells not useful for pking that cannot be filtered otherwise.")
    default boolean shouldHideOthers()
    {
        return false;
    }

    //ice blitz
    @ConfigItem(position = 1, keyName = "shouldModifyIceBlitz", name = "Ice Blitz", description = "Toggle on to enable Ice Blitz modifications.")
    default boolean shouldModifyIceBlitz() { return false; }
    @ConfigItem(position = 2, keyName = "getBlitzPositionX", name = "Ice Blitz Pos X", description = "Modifies the X-axis position of Ice Blitz.")
    default int getBlitzPositionX()
    {
        return 0;
    }
    @ConfigItem(position = 3, keyName = "getBlitzPositionY", name = "Ice Blitz Pos Y", description = "Modifies the Y-axis position of Ice Blitz.")
    default int getBlitzPositionY()
    {
        return 118;
    }
    @ConfigItem(position = 4, keyName = "getBlitzSize", name = "Ice Blitz Size", description = "Modifies the width of Ice Blitz.")
    default int getBlitzSize()
    {
        return 80;
    }

    //ice barrage
    @ConfigItem(position = 5, keyName = "shouldModifyIceBarrage", name = "Ice Barrage", description = "Toggle on to enable Ice Barrage modifications.")
    default boolean shouldModifyIceBarrage() { return false; }
    @ConfigItem(position = 6, keyName = "getBarragePositionX", name = "Ice Barrage Pos X", description = "Modifies the X-axis position of Ice Barrage.")
    default int getBarragePositionX()
    {
        return 0;
    }
    @ConfigItem(position = 7, keyName = "getBarragePositionY", name = "Ice Barrage Pos X", description = "Modifies the X-axis position of Ice Barrage.")
    default int getBarragePositionY()
    {
        return 0;
    }
    @ConfigItem(position = 8, keyName = "getBarrageSize", name = "Ice Barrage Size", description = "Modifies the width position of Ice Barrage.")
    default int getBarrageSize()
    {
        return 80;
    }

    //vengeance
    @ConfigItem(position = 9, keyName = "shouldModifyVengeance", name = "Vengeance", description = "Toggle on to enable Vengeance modifications.")
    default boolean shouldModifyVengeance() { return false; }
    @ConfigItem(position = 10, keyName = "getVengeancePositionX", name = "Vengeance Pos X", description = "Modifies the X-axis position of Vengeance.")
    default int getVengeancePositionX()
    {
        return 0;
    }
    @ConfigItem(position = 11, keyName = "getVengeancePositionY", name = "Vengeance Pos X", description = "Modifies the X-axis position of Vengeance.")
    default int getVengeancePositionY()
    {
        return 0;
    }
    @ConfigItem(position = 12, keyName = "getVengeanceSize", name = "Vengeance Size", description = "Modifies the width position of Vengeance.")
    default int getVengeanceSize()
    {
        return 80;
    }

    //teleblock
    @ConfigItem(position = 13, keyName = "shouldModifyTeleBlock", name = "TeleBlock", description = "Toggle on to enable TeleBlock modifications.")
    default boolean shouldModifyTeleBlock() { return false; }
    @ConfigItem(position = 14, keyName = "getTeleBlockPositionX", name = "TeleBlock Pos X", description = "Modifies the X-axis position of TeleBlock.")
    default int getTeleBlockPositionX()
    {
        return 0;
    }
    @ConfigItem(position = 15, keyName = "getTeleBlockPositionY", name = "TeleBlock Pos X", description = "Modifies the X-axis position of TeleBlock.")
    default int getTeleBlockPositionY()
    {
        return 0;
    }
    @ConfigItem(position = 16, keyName = "getTeleBlockSize", name = "TeleBlock Size", description = "Modifies the width position of TeleBlock.")
    default int getTeleBlockSize()
    {
        return 80;
    }

    //entangle
    @ConfigItem(position = 17, keyName = "shouldModifyEntangle", name = "Entangle", description = "Toggle on to enable Entangle modifications.")
    default boolean shouldModifyEntangle() { return false; }
    @ConfigItem(position = 18, keyName = "getEntanglePositionX", name = "Entangle Pos X", description = "Modifies the X-axis position of Entangle.")
    default int getEntanglePositionX()
    {
        return 0;
    }
    @ConfigItem(position = 19, keyName = "getEntanglePositionY", name = "Entangle Pos X", description = "Modifies the X-axis position of Entangle.")
    default int getEntanglePositionY()
    {
        return 118;
    }
    @ConfigItem(position = 20, keyName = "getEntangleSize", name = "Entangle Size", description = "Modifies the width position of Entangle.")
    default int getEntangleSize()
    {
        return 80;
    }
}
