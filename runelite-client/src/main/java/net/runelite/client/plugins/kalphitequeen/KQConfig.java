package net.runelite.client.plugins.kalphitequeen;

import java.awt.Color;
import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup("kalphitequeen")
public interface KQConfig extends Config
{
    // Sections

    @ConfigSection(
            name = "Tick counters",
            description = "Tick counter settings.",
            position = 0
    )
    String tickCounterSection = "tickCounterSection";

    @ConfigSection(
            name = "TilesSection",
            description = "Tile settings.",
            position = 1
    )
    String TilesSection = "TilesSection";

    @ConfigSection(
            name = "MiscellaneousSection",
            description = "Miscellaneous settings.",
            position = 2
    )
    String MiscellaneousSection = "MiscellaneousSection";

    // Tick Counter Section

    @ConfigItem(
            name = "Show KQ tick counter",
            description = "Show tick counter on KQ.",
            position = 0,
            keyName = "kqTickCounter",
            section = tickCounterSection
    )
    default boolean kqTickCounter()
    {
        return false;
    }

    @Range(
            min = 12,
            max = 64
    )
    @ConfigItem(
            name = "Font size",
            description = "Adjust the font size of the KQ tick counter.",
            position = 1,
            keyName = "kqFontSize",
            section = tickCounterSection
    )
    @Units(Units.PIXELS)
    default int kqFontSize()
    {
        return 22;
    }

    @ConfigItem(
            name = "Font style",
            description = "Bold/Italics/Plain",
            position = 2,
            keyName = "kqFontStyle",
            section = "tickCounterSection",
            hidden = false
    )
    default FontStyle kqFontStyle()
    {
        return FontStyle.BOLD;
    }

    @Alpha
    @ConfigItem(
            name = "Font color",
            description = "Color of the kq counter font.",
            position = 3,
            keyName = "kqFontColor",
            section = "tickCounterSection",
            hidden = false
    )
    default Color kqFontColor()
    {
        return Color.CYAN;
    }

    // Tile Section

    @ConfigItem(
            name = "Show KQ tile outline",
            description = "Show tile outline for the KQ.",
            position = 0,
            keyName = "kqTileOutline",
            section = TilesSection
    )
    default boolean kqTileOutline()
    {
        return false;
    }

    @Range(
            min = 1,
            max = 4
    )
    @ConfigItem(
            name = "Tile outline width",
            description = "Change the width of the KQ's tile outline.",
            position = 1,
            keyName = "kqTileOutlineWidth",
            section = "TilesSection",
            hidden = false
    )
    @Units(Units.PIXELS)
    default int kqTileOutlineWidth()
    {
        return 1;
    }

    @Alpha
    @ConfigItem(
            name = "Tile outline color",
            description = "Color to outline the tile of the KQ.",
            position = 2,
            keyName = "kqTileOutlineColor",
            section = TilesSection,
            hidden = false
    )
    default Color kqTileOutlineColor()
    {
        return Color.BLACK;
    }

    // Misc Section

    @ConfigItem(
            name = "Flash on Vengeance",
            description = "Flash notification when you can vengeance.",
            position = 0,
            keyName = "flashVeng",
            section = MiscellaneousSection
    )
    default boolean flashVeng()
    {
        return false;
    }

    @Range(
            min = 10,
            max = 50
    )
    @ConfigItem(
            name = "Flash duration",
            description = "Change the duration of the flash.",
            position = 1,
            keyName = "flashVengDuration",
            section = MiscellaneousSection,
            hidden = false
    )
    default int flashVengDuration()
    {
        return 25;
    }

    @Alpha
    @ConfigItem(
            name = "Flash color",
            description = "Color of the flash notification.",
            position = 2,
            keyName = "flashVengColor",
            section = MiscellaneousSection,
            hidden = false
    )
    default Color flashVengColor()
    {
        return new Color(255, 255, 255, 70);
    }


    @Getter
    @AllArgsConstructor
    enum FontStyle
    {
        BOLD("Bold", Font.BOLD),
        ITALIC("Italic", Font.ITALIC),
        PLAIN("Plain", Font.PLAIN);

        private final String name;
        private final int font;

        @Override
        public String toString()
        {
            return name;
        }
    }
}