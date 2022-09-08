package net.runelite.client.plugins.customswapper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;

@ConfigGroup("customSwapper")
public interface CustomSwapperConfig extends Config
{
    @ConfigSection(
            name = "Config",
            description = "",
            position = 0
    )
    String config = "Config";

    @ConfigItem(
            keyName = "swapBack",
            name = "Swap back to inventory",
            description = "Once finished with a swap, should it swap back to inventory?",
            section = config,
            position = 1
    )
    default boolean swapBack()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enablePrayCheck",
            name = "Active Prayer Check",
            description = "Enabling this will make it so you can't toggle prayers if they're on.",
            section = config,
            position = 2
    )
    default boolean enablePrayCheck()
    {
        return true;
    }

    @ConfigItem(
            keyName = "randLow",
            name = "Minimum MS Delay",
            description = "Dont set this too high.",
            section = config,
            position = 3
    )
    default int randLow()
    {
        return 70;
    }

    @ConfigItem(
            keyName = "randLower",
            name = "Maximum MS Delay",
            description = "Dont set this too high.",
            section = config,
            position = 4
    )
    default int randHigh()
    {
        return 80;
    }

    @ConfigSection(
            position = 1,
            name = "Main Config",
            description = ""
    )
    String mainConfig = "Main Config";

    @ConfigItem(
            keyName = "customSwapOne",
            name = "Swap Set: One",
            description = "",
            position = 1,
            section = mainConfig
    )
    default String customSwapOne()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapTwo",
            name = "Swap Set: Two",
            description = "",
            position = 2,
            section = mainConfig
    )
    default String customSwapTwo()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapThree",
            name = "Swap Set: Three",
            description = "",
            position = 3,
            section = mainConfig
    )
    default String customSwapThree()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapFour",
            name = "Swap Set: Four",
            description = "",
            position = 4,
            section = mainConfig
    )
    default String customSwapFour()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapFive",
            name = "Swap Set: Five",
            description = "",
            position = 5,
            section = mainConfig
    )
    default String customSwapFive()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapSix",
            name = "Swap Set: Six",
            description = "",
            position = 6,
            section = mainConfig
    )
    default String customSwapSix()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapSeven",
            name = "Swap Set: Seven",
            description = "",
            position = 7,
            section = mainConfig
    )
    default String customSwapSeven()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapEight",
            name = "Swap Set: Eight",
            description = "",
            position = 8,
            section = mainConfig
    )
    default String customSwapEight()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapNine",
            name = "Swap Set: Nine",
            description = "",
            position = 9,
            section = mainConfig
    )
    default String customSwapNine()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapTen",
            name = "Swap Set: Ten",
            description = "",
            position = 10,
            section = mainConfig
    )
    default String customSwapTen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapEleven",
            name = "Swap Set: Eleven",
            description = "",
            position = 11,
            section = mainConfig
    )
    default String customSwapEleven()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapTwelve",
            name = "Swap Set: Twelve",
            description = "",
            position = 12,
            section = mainConfig
    )
    default String customSwapTwelve()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapThirteen",
            name = "Swap Set: Thirteen",
            description = "",
            position = 13,
            section = mainConfig
    )
    default String customSwapThirteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapFourteen",
            name = "Swap Set: Fourteen",
            description = "",
            position = 14,
            section = mainConfig
    )
    default String customSwapFourteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapFifteen",
            name = "Swap Set: Fifteen",
            description = "",
            position = 15,
            section = mainConfig
    )
    default String customSwapFifteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapSixteen",
            name = "Swap Set: Sixteen",
            description = "",
            position = 16,
            section = mainConfig
    )
    default String customSwapSixteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapSeventeen",
            name = "Swap Set: Seventeen",
            description = "",
            position = 17,
            section = mainConfig
    )
    default String customSwapSeventeen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapEighteen",
            name = "Swap Set: Eighteen",
            description = "",
            position = 18,
            section = mainConfig
    )
    default String customSwapEighteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapNineteen",
            name = "Swap Set: Nineteen",
            description = "",
            position = 19,
            section = mainConfig
    )
    default String customSwapNineteen()
    {
        return "";
    }

    @ConfigItem(
            keyName = "customSwapTwenty",
            name = "Swap Set: Twenty",
            description = "",
            position = 20,
            section = mainConfig
    )
    default String customSwapTwenty()
    {
        return "";
    }

    @ConfigSection(
            position = 21,
            name = "Hotkeys",
            description = ""
    )
    String hotkeys = "Hotkeys";

    @ConfigItem(
            keyName = "customOne",
            name = "Execute One",
            description = "",
            position = 22,
            section = hotkeys
    )
    default Keybind customOne()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customTwo",
            name = "Execute Two",
            description = "",
            position = 23,
            section = hotkeys
    )
    default Keybind customTwo()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customThree",
            name = "Execute Three",
            description = "",
            position = 24,
            section = hotkeys
    )
    default Keybind customThree()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customFour",
            name = "Execute Four",
            description = "",
            position = 25,
            section = hotkeys
    )
    default Keybind customFour()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customFive",
            name = "Execute Five",
            description = "",
            position = 26,
            section = hotkeys
    )
    default Keybind customFive()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customSix",
            name = "Execute Six",
            description = "",
            position = 27,
            section = hotkeys
    )
    default Keybind customSix()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customSeven",
            name = "Execute Seven",
            description = "",
            position = 28,
            section = hotkeys
    )
    default Keybind customSeven()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customEight",
            name = "Execute Eight",
            description = "",
            position = 29,
            section = hotkeys
    )
    default Keybind customEight()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customNine",
            name = "Execute Nine",
            description = "",
            position = 30,
            section = hotkeys
    )
    default Keybind customNine()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customTen",
            name = "Execute Ten",
            description = "",
            position = 31,
            section = hotkeys
    )
    default Keybind customTen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customEleven",
            name = "Execute Eleven",
            description = "",
            position = 32,
            section = hotkeys
    )
    default Keybind customEleven()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customTwelve",
            name = "Execute Twelve",
            description = "",
            position = 33,
            section = hotkeys
    )
    default Keybind customTwelve()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customThirteen",
            name = "Execute Thirteen",
            description = "",
            position = 34,
            section = hotkeys
    )
    default Keybind customThirteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customFourteen",
            name = "Execute Fourteen",
            description = "",
            position = 35,
            section = hotkeys
    )
    default Keybind customFourteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customFifteen",
            name = "Execute Fifteen",
            description = "",
            position = 36,
            section = hotkeys
    )
    default Keybind customFifteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customSixteen",
            name = "Execute Sixteen",
            description = "",
            position = 37,
            section = hotkeys
    )
    default Keybind customSixteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customSeventeen",
            name = "Execute Seventeen",
            description = "",
            position = 38,
            section = hotkeys
    )
    default Keybind customSeventeen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customEighteen",
            name = "Execute Eighteen",
            description = "",
            position = 39,
            section = hotkeys
    )
    default Keybind customEighteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customNineteen",
            name = "Execute Nineteen",
            description = "",
            position = 40,
            section = hotkeys
    )
    default Keybind customNineteen()
    {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "customTwenty",
            name = "Execute Twenty",
            description = "",
            position = 41,
            section = hotkeys
    )
    default Keybind customTwenty()
    {
        return Keybind.NOT_SET;
    }
}