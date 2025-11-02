/*
 * Copyright (c) 2024, Private Server Multiboxing
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
package net.runelite.client.plugins.privateserver;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@ConfigGroup(PrivateServerPlugin.CONFIG_GROUP)
public interface PrivateServerConfig extends Config
{
	@ConfigSection(
		name = "General Settings",
		description = "General multiboxing settings for private server",
		position = 0
	)
	String generalSection = "general";

	@ConfigSection(
		name = "Hotkeys",
		description = "Configure hotkeys for multiboxing actions",
		position = 1
	)
	String hotkeysSection = "hotkeys";

	@ConfigSection(
		name = "Features",
		description = "Enable or disable specific multiboxing features",
		position = 2
	)
	String featuresSection = "features";

	@ConfigItem(
		keyName = "enableMultiboxing",
		name = "Enable Multiboxing",
		description = "Enables multiboxing features for private server",
		position = 0,
		section = generalSection
	)
	default boolean enableMultiboxing()
	{
		return true;
	}

	@ConfigItem(
		keyName = "allowMultipleClients",
		name = "Allow Multiple Clients",
		description = "Allows running multiple RuneLite clients simultaneously",
		position = 1,
		section = generalSection
	)
	default boolean allowMultipleClients()
	{
		return true;
	}

	@ConfigItem(
		keyName = "syncActions",
		name = "Synchronize Actions",
		description = "Attempts to synchronize certain actions across clients when possible",
		position = 2,
		section = generalSection
	)
	default boolean syncActions()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showMultiboxOverlay",
		name = "Show Multibox Overlay",
		description = "Displays an overlay indicating multiboxing is active",
		position = 3,
		section = generalSection
	)
	default boolean showMultiboxOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "quickPrayerSync",
		name = "Quick Prayer Sync",
		description = "Enables hotkey for synchronized prayer activation",
		position = 0,
		section = featuresSection
	)
	default boolean quickPrayerSync()
	{
		return true;
	}

	@ConfigItem(
		keyName = "quickSpecSync",
		name = "Quick Spec Sync",
		description = "Enables hotkey for synchronized special attack",
		position = 1,
		section = featuresSection
	)
	default boolean quickSpecSync()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clickSync",
		name = "Click Synchronization",
		description = "Synchronizes mouse clicks when enabled (toggle with hotkey)",
		position = 2,
		section = featuresSection
	)
	default boolean clickSync()
	{
		return false;
	}

	@ConfigItem(
		keyName = "actionDelay",
		name = "Action Delay (ms)",
		description = "Delay between synchronized actions in milliseconds",
		position = 3,
		section = featuresSection
	)
	default int actionDelay()
	{
		return 50;
	}

	@ConfigItem(
		keyName = "toggleMultiboxHotkey",
		name = "Toggle Multiboxing",
		description = "Hotkey to toggle multiboxing features on/off",
		position = 0,
		section = hotkeysSection
	)
	default Keybind toggleMultiboxHotkey()
	{
		return new Keybind(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "syncPrayerHotkey",
		name = "Sync Prayer",
		description = "Hotkey to activate quick prayers synchronously",
		position = 1,
		section = hotkeysSection
	)
	default Keybind syncPrayerHotkey()
	{
		return new Keybind(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "syncSpecHotkey",
		name = "Sync Special Attack",
		description = "Hotkey to activate special attack synchronously",
		position = 2,
		section = hotkeysSection
	)
	default Keybind syncSpecHotkey()
	{
		return new Keybind(KeyEvent.VK_F2, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "toggleClickSyncHotkey",
		name = "Toggle Click Sync",
		description = "Hotkey to toggle click synchronization",
		position = 3,
		section = hotkeysSection
	)
	default Keybind toggleClickSyncHotkey()
	{
		return new Keybind(KeyEvent.VK_F3, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "followLeaderHotkey",
		name = "Follow Leader",
		description = "Hotkey to make other clients follow the leader",
		position = 4,
		section = hotkeysSection
	)
	default Keybind followLeaderHotkey()
	{
		return new Keybind(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK);
	}
}
