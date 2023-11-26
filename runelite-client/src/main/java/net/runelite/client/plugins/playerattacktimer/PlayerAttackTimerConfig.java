  package net.runelite.client.plugins.playerattacktimer;
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

  @ConfigGroup("playerattacktimer")
  public interface PlayerAttackTimerConfig extends Config
  {
    @ConfigSection(
        name = "Settings",
        description = "",
        position = 0
    )
    String settings = "Settings";

    @ConfigSection(
        name = "Font Settings",
        description = "",
        position = 1
    )
    String fontSettings = "Font Settings";

    //------------------------------------------------------------//
    // Settings
    //------------------------------------------------------------//

    @ConfigItem(
        name = "Debug animation ids",
        description = "Show your player's current animation ID."
            + "<br>Animation IDs can be viewed by wielding a weapon and attacking an NPC.",
        position = 0,
        keyName = "debugAnimationIds",
        section = settings
    )
    default boolean debugAnimationIds()
    {
      return false;
    }

    @ConfigItem(
        name = "Custom animations (one per line)",
        description = "Syntax AnimationID:TickDelay"
            + "<br>e.g. Abyssal whip would be 1658:4"
            + "<br>optionally include one of (r, a, p, e, m, c, h) to draw prayer helpers."
            + "<br> supported prayers: Rigour, Augury, Piety, Eagle Eye, Mystic Might, Chivalry, Hawk Eye"
            + "<br>e.g. Abyssal whip with piety would be 1658:4:p"
            + "<br>Animation Ids can be obtained by enabling the above debug setting."
            + "<br>Weapon tick delays can be found on the wiki.",
        position = 1,
        keyName = "customAnimations",
        section = settings
    )
    default String customAnimations()
    {
      return "";
    }

    //------------------------------------------------------------//
    // Font Settings
    //------------------------------------------------------------//

    @ConfigItem(
        name = "Font style",
        description = "Font style can be bold, plain, or italicized.",
        position = 0,
        keyName = "fontStyle",
        section = fontSettings
    )
    default FontStyle fontStyle()
    {
      return FontStyle.BOLD;
    }

    @ConfigItem(
        name = "Font shadow",
        description = "Toggle font shadow.",
        position = 1,
        keyName = "fontShadow",
        section = fontSettings
    )
    default boolean fontShadow()
    {
      return true;
    }

    @Range(
        min = 12,
        max = 64
    )
    @ConfigItem(
        name = "Font size",
        description = "Adjust font size.",
        position = 2,
        keyName = "fontSize",
        section = fontSettings
    )
    default int fontSize()
    {
      return 20;
    }

    @Alpha
    @ConfigItem(
        name = "Font color",
        description = "Adjust font color.",
        position = 3,
        keyName = "fontColor",
        section = fontSettings
    )
    default Color fontColor()
    {
      return new Color(255, 0, 0, 255);
    }

    @Range(
        min = -100,
        max = 100
    )
    @ConfigItem(
        name = "Font zOffset",
        description = "Adjust the Z coordinate offset.",
        position = 4,
        keyName = "fontZOffset",
        section = fontSettings
    )
    default int fontZOffset()
    {
      return 0;
    }

    //------------------------------------------------------------//
    // Constants
    //------------------------------------------------------------//

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