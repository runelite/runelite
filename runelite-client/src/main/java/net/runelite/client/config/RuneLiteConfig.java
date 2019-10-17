/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.config;

import java.awt.Dimension;
import net.runelite.api.Constants;
import net.runelite.client.ui.ContainableFrame;

@ConfigGroup("runelite")
public interface RuneLiteConfig extends Config
{
	@ConfigTitleSection(
		keyName = "uiTitle",
		name = "User interface",
		description = "",
		position = 1
	)
	default Title uiTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "gameSize",
		name = "Game size",
		description = "The game will resize to this resolution upon starting the client",
		position = 2,
		titleSection = "uiTitle"
	)
	default Dimension gameSize()
	{
		return Constants.GAME_FIXED_SIZE;
	}

	@ConfigItem(
		keyName = "automaticResizeType",
		name = "Resize type",
		description = "Choose how the window should resize when opening and closing panels",
		position = 3,
		titleSection = "uiTitle"
	)
	default ExpandResizeType automaticResizeType()
	{
		return ExpandResizeType.KEEP_GAME_SIZE;
	}

	@ConfigItem(
		keyName = "lockWindowSize",
		name = "Lock window size",
		description = "Determines if the window resizing is allowed or not",
		position = 4,
		titleSection = "uiTitle"
	)
	default boolean lockWindowSize()
	{
		return false;
	}

	@ConfigItem(
		keyName = "containInScreen2",
		name = "Contain in screen",
		description = "Makes the client stay contained in the screen when attempted to move out of it.<br>Note: 'Always' only works if custom chrome is enabled.",
		position = 5,
		titleSection = "uiTitle"
	)
	default ContainableFrame.Mode containInScreen()
	{
		return ContainableFrame.Mode.RESIZING;
	}


	@ConfigItem(
		keyName = "uiEnableCustomChrome",
		name = "Enable custom window chrome",
		description = "Use Runelite's custom window title and borders.",
		warning = "Please restart your client after changing this setting",
		position = 6,
		titleSection = "uiTitle"
	)
	default boolean enableCustomChrome()
	{
		return true;
	}

	@ConfigItem(
		keyName = "usernameInTitle",
		name = "Show display name in title",
		description = "Toggles displaying of local player's display name in client title",
		position = 7,
		titleSection = "uiTitle"
	)
	default boolean usernameInTitle()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "miscTitle",
		name = "Miscellaneous",
		description = "",
		position = 8
	)
	default Title miscTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "rememberScreenBounds",
		name = "Remember client position",
		description = "Save the position and size of the client after exiting",
		position = 9,
		titleSection = "miscTitle"
	)
	default boolean rememberScreenBounds()
	{
		return true;
	}

	@ConfigItem(
		keyName = "gameAlwaysOnTop",
		name = "Enable client always on top",
		description = "The game will always be on the top of the screen",
		position = 10,
		titleSection = "miscTitle"
	)
	default boolean gameAlwaysOnTop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warningOnExit",
		name = "Display warning on exit",
		description = "Toggles a warning popup when trying to exit the client",
		position = 11,
		titleSection = "miscTitle"
	)
	default WarningOnExit warningOnExit()
	{
		return WarningOnExit.LOGGED_IN;
	}

	@Range(max = 100, min = 0)
	@ConfigItem(
		keyName = "volume",
		name = "Runelite Volume",
		description = "Sets the volume of custom Runelite sounds (not the client sounds)",
		position = 12,
		titleSection = "miscTitle"
	)
	default int volume()
	{
		return 100;
	}

	@ConfigTitleSection(
		keyName = "notificationsTitle",
		name = "Notifications",
		description = "",
		position = 13
	)
	default Title notificationsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "notificationTray",
		name = "Enable tray notifications",
		description = "Enables tray notifications",
		position = 14,
		titleSection = "notificationsTitle"
	)
	default boolean enableTrayNotifications()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationRequestFocus",
		name = "Request focus on notification",
		description = "Toggles window focus request",
		position = 15,
		titleSection = "notificationsTitle"
	)
	default boolean requestFocusOnNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationSound",
		name = "Enable sound on notifications",
		description = "Enables the playing of a beep sound when notifications are displayed",
		position = 16,
		titleSection = "notificationsTitle"
	)
	default boolean enableNotificationSound()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationGameMessage",
		name = "Enable game message notifications",
		description = "Puts a notification message in the chatbox",
		position = 17,
		titleSection = "notificationsTitle"
	)
	default boolean enableGameMessageNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notificationFlash",
		name = "Enable flash notification",
		description = "Flashes the game frame as a notification",
		position = 18,
		titleSection = "notificationsTitle"
	)
	default FlashNotification flashNotification()
	{
		return FlashNotification.DISABLED;
	}

	@ConfigItem(
		keyName = "notificationFocused",
		name = "Send notifications when focused",
		description = "Toggles all notifications for when the client is focused",
		position = 19,
		titleSection = "notificationsTitle"
	)
	default boolean sendNotificationsWhenFocused()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "fontTitle",
		name = "Font",
		description = "",
		position = 20
	)
	default Title fontTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "fontType",
		name = "Dynamic Overlay Font",
		description = "Configures what font type is used for in-game overlays such as player name, ground items, etc.",
		position = 21,
		titleSection = "fontTitle"
	)
	default FontType fontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "tooltipFontType",
		name = "Tooltip Font",
		description = "Configures what font type is used for in-game tooltips such as food stats, NPC names, etc.",
		position = 22,
		titleSection = "fontTitle"
	)
	default FontType tooltipFontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "interfaceFontType",
		name = "Interface Overlay Font",
		description = "Configures what font type is used for in-game interface overlays such as panels, opponent info, clue scrolls etc.",
		position = 23,
		titleSection = "fontTitle"
	)
	default FontType interfaceFontType()
	{
		return FontType.REGULAR;
	}

	@ConfigTitleSection(
		keyName = "overlayTitle",
		name = "Overlays",
		description = "",
		position = 24
	)
	default Title overlayTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "menuEntryShift",
		name = "Require Shift for overlay menu",
		description = "Overlay right-click menu will require shift to be added",
		position = 25,
		titleSection = "overlayTitle"
	)
	default boolean menuEntryShift()
	{
		return true;
	}

	@ConfigItem(
		keyName = "infoBoxVertical",
		name = "Display infoboxes vertically",
		description = "Toggles the infoboxes to display vertically",
		position = 26,
		titleSection = "infoboxTitle"
	)
	default boolean infoBoxVertical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "infoBoxWrap",
		name = "Infobox wrap count",
		description = "Configures the amount of infoboxes shown before wrapping",
		position = 27,
		titleSection = "infoboxTitle"
	)
	default int infoBoxWrap()
	{
		return 4;
	}

	@ConfigItem(
		keyName = "infoBoxSize",
		name = "Infobox size (px)",
		description = "Configures the size of each infobox in pixels",
		position = 28,
		titleSection = "infoboxTitle"
	)
	default int infoBoxSize()
	{
		return 35;
	}

}
