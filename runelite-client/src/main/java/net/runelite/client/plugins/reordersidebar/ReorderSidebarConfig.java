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
import net.runelite.client.config.ConfigSection;

@ConfigGroup(ReorderSidebarPlugin.CONFIG_GROUP)
public interface ReorderSidebarConfig extends Config
{
	@ConfigSection(
		name = "Drag Settings",
		description = "Settings for dragging sidebar icons",
		position = 0
	)
	String dragSection = "dragSettings";

	@ConfigItem(
		keyName = "dragOnShiftOnly",
		name = "Drag on shift only",
		description = "Only allow dragging sidebar icons while holding the Shift key.",
		section = dragSection,
		position = 0
	)
	default boolean dragOnShiftOnly()
	{
		return false;
	}

	@ConfigItem(
		keyName = "resetIconOrder",
		name = "Reset icon order",
		description = "Toggle this to reset the sidebar icon order to the default priority-based order.",
		position = 1
	)
	default boolean resetIconOrder()
	{
		return false;
	}
}


