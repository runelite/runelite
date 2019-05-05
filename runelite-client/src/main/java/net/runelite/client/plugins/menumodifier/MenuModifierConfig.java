/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.menumodifier;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("menumodifier")
public interface MenuModifierConfig extends Config
{
    @ConfigItem(position = 0, keyName = "hideCancel", name = "Hide Cancel", description = "Hides the 'cancel' option from the right click menu")
    default boolean hideCancel() { return true; }

    @ConfigItem(position = 1, keyName = "hideExamine", name = "Hide Examine", description = "Hides the 'examine' option from the right click menu")
    default boolean hideExamine() { return true; }

    @ConfigItem(position = 2, keyName = "hideTradeWith", name = "Hide Trade With", description = "Hides the 'trade with' option from the right click menu")
    default boolean hideTradeWith() { return true; }

    @ConfigItem(position = 3, keyName = "hideReport", name = "Hide Report", description = "Hides the 'report' option from the right click menu")
    default boolean hideReport() { return true; }

    @ConfigItem(position = 4, keyName = "hideLookup", name = "Hide Lookup", description = "Hides the 'lookup' option from the right click menu")
    default boolean hideLookup() { return true; }

	@ConfigItem(position = 4, keyName = "hideNet", name = "Hide Net", description = "Hides the 'net' option from the right click menu")
	default boolean hideNet() { return true; }

	@ConfigItem(position = 4, keyName = "hideBait", name = "Hide Bait", description = "Hides the 'Bait' option from the right click menu")
	default boolean hideBait() { return true; }
}
