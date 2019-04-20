package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("freezetimers")
public interface FreezeTimersConfig extends Config
{

    @ConfigItem(
            position = 0,
            keyName = "freezeenable",
            name = "Enable PvP freeze timers",
            description = "Configures whether or not to show freeze timers."
    )
    default boolean EnableFreezeTimers()
    {
        return false;
    }

    @ConfigItem(
            position = 1,
            keyName = "tilehighlight",
            name = "Frozen opponent tile highlighting",
            description = "Configures whether or not to highlight tiles frozen opponents are standing on."
    )
    default boolean drawTiles()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "timercolor",
            name = "Freeze Timer Color",
            description = "Color of freeze timer"
    )
    default Color FreezeTimerColor()
    {
        return new Color(0, 184, 212);
    }

    @ConfigItem(
            position = 3,
            keyName = "spellIcon",
            name = "Show spell icon",
            description = "Shows the spell icon for the freeze spell affecting the target"
    )
    default boolean spellIcon()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "refreezeTimer",
            name = "Refreeze Timer",
            description = "Show a timer that counts up until the target can be refrozen"
    )
    default boolean refreezeTimer()
    {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "refreezeTimerColor",
            name = "Refreeze color",
            description = "The color for the timer that counts until the target can be refrozen"
    )
    default Color RefreezeTimerColor()
    {
        return Color.red;
    }
	
	@ConfigItem(position = 6, keyName = "tbtimer", name = "Tele Block Timer", description = "Enables tele block timer")
	default boolean TBTimer() { 
		return true; 
	}
	
	@ConfigItem(position = 7, keyName = "timerpos", name = "Freeze Timer Position", description = "Position of freeze timer")
	default int FreezeTimerPos() {
		return 80; 
	}
}

