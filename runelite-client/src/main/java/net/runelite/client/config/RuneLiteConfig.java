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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import net.runelite.api.Constants;
import net.runelite.client.ui.ContainableFrame;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.util.OSType;

@ConfigGroup(RuneLiteConfig.GROUP_NAME)
public interface RuneLiteConfig extends Config
{
	String GROUP_NAME = "runelite";

	@ConfigSection(
		name = "Window settings",
		description = "Settings relating to the client's window and frame.",
		position = 0
	)
	String windowSettings = "windowSettings";

	@ConfigSection(
		name = "Notification settings",
		description = "Settings relating to notifications.",
		position = 1
	)
	String notificationSettings = "notificationSettings";

	@ConfigSection(
		name = "Overlay settings",
		description = "Settings relating to fonts.",
		position = 2
	)
	String overlaySettings = "overlaySettings";

	@ConfigItem(
		keyName = "gameSize",
		name = "Game size",
		description = "The game will resize to this resolution upon starting the client.",
		position = 10,
		section = windowSettings
	)
	default Dimension gameSize()
	{
		return Constants.GAME_FIXED_SIZE;
	}

	@ConfigItem(
		keyName = "automaticResizeType",
		name = "Resize type",
		description = "Choose how the window should resize when opening and closing panels.",
		position = 11,
		section = windowSettings
	)
	default ExpandResizeType automaticResizeType()
	{
		return ExpandResizeType.KEEP_GAME_SIZE;
	}

	@ConfigItem(
		keyName = "lockWindowSize",
		name = "Lock window size",
		description = "Determines if the window resizing is allowed or not.",
		position = 12,
		section = windowSettings
	)
	default boolean lockWindowSize()
	{
		return false;
	}

	@ConfigItem(
		keyName = "containInScreen2",
		name = "Contain in screen",
		description = "Makes the client move itself to stay within the screen when resizing.<br>Note: 'Always' only works on Windows and if custom chrome is enabled.",
		position = 13,
		section = windowSettings
	)
	default ContainableFrame.Mode containInScreen()
	{
		return ContainableFrame.Mode.RESIZING;
	}

	@ConfigItem(
		keyName = "rememberScreenBounds",
		name = "Remember client position",
		description = "Save the position and size of the client after exiting.",
		position = 14,
		section = windowSettings
	)
	default boolean rememberScreenBounds()
	{
		return true;
	}

	@ConfigItem(
		keyName = "uiEnableCustomChrome",
		name = "Enable custom window chrome",
		description = "Use RuneLite's custom window title and borders.",
		warning = "Please restart your client after changing this setting",
		position = 15,
		section = windowSettings
	)
	default boolean enableCustomChrome()
	{
		return OSType.getOSType() == OSType.Windows;
	}

	@Range(
		min = 10,
		max = 100
	)
	@ConfigItem(
		keyName = "uiWindowOpacity",
		name = "Window opacity",
		description = "Set the windows opacity.",
		position = 16,
		section = windowSettings
	)
	default int windowOpacity()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "gameAlwaysOnTop",
		name = "Always on top",
		description = "The game will always be on the top of the screen.",
		position = 17,
		section = windowSettings
	)
	default boolean gameAlwaysOnTop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warningOnExit",
		name = "Exit warning",
		description = "Shows a warning popup when trying to exit the client.",
		position = 18,
		section = windowSettings
	)
	default WarningOnExit warningOnExit()
	{
		return WarningOnExit.LOGGED_IN;
	}

	@ConfigItem(
		keyName = "usernameInTitle",
		name = "Show display name in title",
		description = "Toggles displaying of local player's display name in client title.",
		position = 19,
		section = windowSettings
	)
	default boolean usernameInTitle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trayIcon",
		name = "Enable tray icon",
		description = "Enables icon in system tray.",
		warning = "Disabling this may limit your ability to receive tray notifications.\nPlease restart your client after changing this setting.",
		position = 20,
		section = notificationSettings
	)
	default boolean enableTrayIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationTray",
		name = "Enable tray notifications",
		description = "Enables tray notifications.",
		position = 21,
		section = notificationSettings
	)
	default boolean enableTrayNotifications()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationRequestFocus",
		name = "Request focus",
		description = "Configures the window focus request type on notification.",
		position = 22,
		section = notificationSettings
	)
	default RequestFocusType notificationRequestFocus()
	{
		return RequestFocusType.OFF;
	}

	@ConfigItem(
		keyName = "notificationSound",
		name = "Notification sound",
		description = "Enables the playing of a beep sound when notifications are displayed.",
		position = 23,
		section = notificationSettings
	)
	default NotificationSound notificationSound()
	{
		return NotificationSound.NATIVE;
	}

	@Range(
		min = 0,
		max = 100
	)
	@ConfigItem(
		keyName = "notificationVolume",
		name = "Notification volume",
		description = "Configures the volume of custom notifications (does not control native volume).",
		position = 24,
		section = notificationSettings
	)
	@Units(Units.PERCENT)
	default int notificationVolume()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "notificationTimeout",
		name = "Notification timeout",
		description = "How long notification will be shown in milliseconds. A value of 0 will make it use the system configuration. (Linux only)",
		position = 25,
		section = notificationSettings
	)
	@Units(Units.MILLISECONDS)
	default int notificationTimeout()
	{
		return 10000;
	}

	@ConfigItem(
		keyName = "notificationGameMessage",
		name = "Game message notifications",
		description = "Adds a notification message to the chatbox.",
		position = 26,
		section = notificationSettings
	)
	default boolean enableGameMessageNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "flashNotification",
		name = "Flash",
		description = "Flashes the game frame as a notification.",
		position = 27,
		section = notificationSettings
	)
	default FlashNotification flashNotification()
	{
		return FlashNotification.DISABLED;
	}

	@ConfigItem(
		keyName = "notificationFocused",
		name = "Send notifications when focused",
		description = "Send notifications even when the client is focused.",
		position = 28,
		section = notificationSettings
	)
	default boolean sendNotificationsWhenFocused()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "notificationFlashColor",
		name = "Notification flash",
		description = "The color of the notification flashes.",
		position = 29,
		section = notificationSettings
	)
	default Color notificationFlashColor()
	{
		return new Color(255, 0, 0, 70);
	}

	@ConfigItem(
		keyName = "fontType",
		name = "Dynamic overlay font",
		description = "Configures what font type is used for in-game overlays such as player name, ground items, etc.",
		position = 30,
		section = overlaySettings
	)
	default FontType fontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "tooltipFontType",
		name = "Tooltip font",
		description = "Configures what font type is used for in-game tooltips such as food stats, NPC names, etc.",
		position = 31,
		section = overlaySettings
	)
	default FontType tooltipFontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "interfaceFontType",
		name = "Interface font",
		description = "Configures what font type is used for in-game interface overlays such as panels, opponent info, clue scrolls etc.",
		position = 32,
		section = overlaySettings
	)
	default FontType interfaceFontType()
	{
		return FontType.REGULAR;
	}

	@ConfigItem(
		keyName = "infoboxFontType",
		name = "Infobox font",
		description = "Configures what font type is used for infoboxes.",
		position = 33,
		section = overlaySettings
	)
	default FontType infoboxFontType()
	{
		return FontType.REGULAR;
	}

	@ConfigItem(
		keyName = "tooltipPosition",
		name = "Tooltip position",
		description = "Configures whether to show the tooltip above or under the cursor.",
		position = 35,
		section = overlaySettings
	)
	default TooltipPositionType tooltipPosition()
	{
		return TooltipPositionType.UNDER_CURSOR;
	}

	@ConfigItem(
		keyName = "infoBoxVertical",
		name = "Display infoboxes vertically",
		description = "Toggles the infoboxes to display vertically.",
		position = 40,
		section = overlaySettings,
		hidden = true
	)
	default boolean infoBoxVertical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "infoBoxSize",
		name = "Infobox size",
		description = "Configures the size of each infobox in pixels.",
		position = 42,
		section = overlaySettings
	)
	@Units(Units.PIXELS)
	default int infoBoxSize()
	{
		return 35;
	}

	@ConfigItem(
		keyName = "infoBoxTextOutline",
		name = "Outline infobox text",
		description = "Draw a full outline instead of a simple shadow for infobox text.",
		position = 43,
		section = overlaySettings
	)
	default boolean infoBoxTextOutline()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "overlayBackgroundColor",
		name = "Overlay color",
		description = "Configures the background color of infoboxes and overlays.",
		position = 44,
		section = overlaySettings
	)
	default Color overlayBackgroundColor()
	{
		return ComponentConstants.STANDARD_BACKGROUND_COLOR;
	}

	@ConfigItem(
		keyName = "sidebarToggleKey",
		name = "Sidebar toggle key",
		description = "The key that will toggle the sidebar (accepts modifiers).",
		position = 45,
		section = windowSettings
	)
	default Keybind sidebarToggleKey()
	{
		return new Keybind(KeyEvent.VK_F11, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "panelToggleKey",
		name = "Plugin panel toggle key",
		description = "The key that will toggle the current or last opened plugin panel (accepts modifiers).",
		position = 46,
		section = windowSettings
	)
	default Keybind panelToggleKey()
	{
		return new Keybind(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "blockExtraMouseButtons",
		name = "Block extra mouse buttons",
		description = "Blocks extra mouse buttons (4 and above).",
		position = 50
	)
	default boolean blockExtraMouseButtons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "useWikiItemPrices",
		name = "Use actively traded price",
		description = "Use actively traded prices, sourced from the RuneScape wiki, for item prices.",
		position = 51
	)
	default boolean useWikiItemPrices()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dragHotkey",
		name = "Drag hotkey",
		description = "Configures the hotkey used to drag UI elements around.",
		position = 52
	)
	default Keybind dragHotkey()
	{
		return Keybind.ALT;
	}
}
