/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
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
package net.runelite.client.plugins.reordersidebar;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup(ReorderSidebarConfig.CONFIG_GROUP)
public interface ReorderSidebarConfig extends Config
{
	String CONFIG_GROUP = "reorderSidebar";

	@ConfigItem(
		keyName = "dragRequiresHotkey",
		name = "Require hotkey to drag",
		description = "Only allow dragging while holding the configured hotkey",
		position = 0
	)
	default boolean dragRequiresHotkey()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dragHotkey",
		name = "Drag hotkey",
		description = "Hotkey to hold for dragging (when enabled)",
		position = 1
	)
	default Keybind dragHotkey()
	{
		return Keybind.SHIFT;
	}

	@ConfigItem(
		keyName = "useCustomTabOrder",
		name = "Use custom order",
		description = "Use custom sidebar order instead of default",
		position = 2
	)
	default boolean useCustomTabOrder()
	{
		return true;
	}

	@ConfigItem(
		keyName = "reorderSidebarPositionEnabled",
		name = "",
		description = "Used to tell ClientUI when this plugin is enabled. Prevents checks for useCustomTabOrder() returning true when the plugin is disabled.",
		hidden = true
	)
	default boolean reorderSidebarPositionEnabled()
	{
		return false;
	}
}
