package net.runelite.client.plugins.dagannothkings;

import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("dagannothkings")
public interface DKConfig extends Config
{
    // Sections

    @ConfigSection(
            position = 0,
            name = "Settings",
            description = ""
    )
    String settings = "settings";

    @ConfigSection(
            position = 1,
            name = "Font",
            description = ""
    )
    String FontSetting = "Font";

    // Settings

    @ConfigItem(
            position = 0,
            keyName = "showPrayerInfoboxOverlay",
            name = "Prayer infobox overlay",
            description = "Infobox overlay with prayer to activate.",
            section = settings
    )
    default boolean showPrayerInfoboxOverlay()
    {
        return false;
    }

    @ConfigItem(
            position = 1,
            keyName = "showPrayerWidgetOverlay",
            name = "Prayer widget overlay",
            description = "Overlay prayer widget with tick timer.",
            section = settings
    )
    default boolean showPrayerWidgetOverlay()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "showGuitarHeroOverlay",
            name = "Guitar hero overlay",
            description = "Render \"Guitar Hero\" style prayer overlay.",
            section = settings
    )
    default boolean showGuitarHeroOverlay()
    {
        return false;
    }

    @ConfigItem(
            position = 3,
            keyName = "showNpcTickCounter",
            name = "Show NPC tick counter",
            description = "Show tick counters on NPCs.",
            section = settings
    )
    default boolean showNpcTickCounter()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "ignoringNonAttacking",
            name = "Ignore non-attacking NPCs",
            description = "Ignore NPCs that are not attacking you.",
            section = "settings"
    )
    default boolean ignoringNonAttacking()
    {
        return false;
    }

    @ConfigItem(
            position = 5,
            keyName = "showNpcTileOutline",
            name = "Show NPC tile outlines",
            description = "Show tile outlines for NPCs.",
            section = settings
    )
    default boolean showNpcTileOutline()
    {
        return false;
    }

    // Font

    @ConfigItem(
            position = 0,
            keyName = "fontStyle",
            name = "Font style",
            description = "Plain | Bold | Italics",
            section = FontSetting
    )
    default FontStyle fontStyle()
    {
        return FontStyle.BOLD;
    }

    @Range(
            min = 14,
            max = 40
    )
    @ConfigItem(
            position = 1,
            keyName = "fontSize",
            name = "Font size",
            description = "Font size for timers.",
            section = FontSetting
    )
    default int fontSize()
    {
        return 20;
    }

    @ConfigItem(
            position = 2,
            keyName = "fontShadow",
            name = "Font shadow",
            description = "Add shadow to font.",
            section = FontSetting
    )
    default boolean fontShadow()
    {
        return false;
    }

    // Misc

    @ConfigItem(
            position = 99,
            keyName = "mirrorMode",
            name = "Enable mirror mode overlay",
            description = "Show overlay when mirror mode enabled."
    )
    default boolean mirrorMode()
    {
        return false;
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