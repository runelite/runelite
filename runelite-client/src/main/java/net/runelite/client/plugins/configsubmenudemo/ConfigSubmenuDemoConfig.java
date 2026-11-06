/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.configsubmenudemo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

/**
 * Config interface for the ConfigSubmenu PoC demo plugin.
 * <p>
 * Demonstrates all three kinds of top-level groupings:
 * <ol>
 *   <li>A plain boolean at the top level</li>
 *   <li>A classic {@code @ConfigSection} (inline collapsible group)</li>
 *   <li>A boolean {@code @ConfigItem} with {@link net.runelite.client.config.ConfigItem#opensSubmenu()} that opens a dedicated sub-panel</li>
 * </ol>
 */
@ConfigGroup("configsubmenudemo")
public interface ConfigSubmenuDemoConfig extends Config
{
	// ---- Top-level item (no section / submenu) --------------------------------

	@ConfigItem(
		keyName = "topLevelEnabled",
		name = "Top-level toggle",
		description = "A plain top-level boolean — not inside any section or submenu.",
		position = 0
	)
	default boolean topLevelEnabled()
	{
		return true;
	}

	// ---- Classic inline section -----------------------------------------------

	@ConfigSection(
		name = "Classic Section",
		description = "A regular inline section — unchanged behaviour.",
		position = 1
	)
	String classicSection = "classicSection";

	@ConfigItem(
		keyName = "optionA",
		name = "Option A",
		description = "First item in the classic section.",
		section = "classicSection",
		position = 0
	)
	default boolean optionA()
	{
		return true;
	}

	@ConfigItem(
		keyName = "optionB",
		name = "Option B",
		description = "Second item in the classic section.",
		section = "classicSection",
		position = 1
	)
	default boolean optionB()
	{
		return false;
	}

	// ---- Submenu (opens a dedicated sub-panel) --------------------------------
	// The boolean opener doubles as a feature toggle: while it's off, the proxy
	// reports zero values for every item in the sub-panel.

	@ConfigSection(
		name = "Subpanel Toggle",
		description = "Grouped toggle for closely related settings.",
		position = 2
	)
	String displayOptions = "displayOptions";

	@ConfigItem(
		keyName = "displayOptionsEnabled",
		name = "Subpanel Toggle",
		description = "Grouped toggle for closely related settings.",
		position = 2,
		opensSubmenu = "displayOptions"
	)
	default boolean displayOptionsEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "optionC",
		name = "Option C",
		description = "First item in the submenu.",
		section = "displayOptions",
		submenuPosition = 0
	)
	default boolean optionC()
	{
		return true;
	}

	@ConfigItem(
		keyName = "optionD",
		name = "Option D",
		description = "Second item in the submenu.",
		section = "displayOptions",
		submenuPosition = 1
	)
	default boolean optionD()
	{
		return true;
	}

	@ConfigItem(
		keyName = "optionE",
		name = "Option E",
		description = "Third item in the submenu.",
		section = "displayOptions",
		submenuPosition = 2
	)
	default boolean optionE()
	{
		return false;
	}

	@ConfigItem(
		keyName = "optionF",
		name = "Option F",
		description = "Fourth item in the submenu.",
		section = "displayOptions",
		submenuPosition = 3
	)
	default boolean optionF()
	{
		return false;
	}
}
