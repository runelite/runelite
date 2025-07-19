/*
 * Copyright (c) 2020 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.dpscounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("dpscounter")
public interface DpsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "showDamage",
		name = "Show damage",
		description = "Show total damage instead of DPS."
	)
	default boolean showDamage()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "autopause",
		name = "Auto pause",
		description = "Pause the DPS tracker when a boss dies."
	)
	default boolean autopause()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "autoreset",
		name = "Auto reset",
		description = "Reset the DPS tracker when a boss dies."
	)
	default boolean autoreset()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "bossDamage",
		name = "Only boss damage",
		description = "Only count damage done to the boss, and not to other NPCs."
	)
	default boolean bossDamage()
	{
		return false;
	}
}
