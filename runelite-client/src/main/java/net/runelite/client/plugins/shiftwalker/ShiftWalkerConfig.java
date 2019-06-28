/*
 * Copyright (c) 2018, Plinko60
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
package net.runelite.client.plugins.shiftwalker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("shiftwalkhere")
public interface ShiftWalkerConfig extends Config
{
	@ConfigItem(
		keyName = "shiftWalk",
		name = "Shift to Walk",
		description = "For when you want Walk here as a priority"
	)
	default boolean shiftWalk()
	{
		return false;
	}
	
	@ConfigItem(
		keyName = "shiftLoot",
		name = "Shift to Loot",
		description = "For when people stand on your loot"
	)
	default boolean shiftLoot()
	{
		return false;
	}
/*

	@ConfigItem(
		keyName = "shiftWalkEverything",
		name = "Walk Under Everything",
		description = "Enable this option when you do not want to interact with anything while Shift is pressed. " +
			"If Walk Here is an option it will be the action taken."
	)
	default boolean shiftWalkEverything()
	{
		return true;
	}

	@ConfigItem(
		keyName = "shiftWalkBoxTraps",
		name = "Walk Under Box Traps",
		description = "Press \"Shift\" to be able to walk under instead of picking up a Box Trap."
	)
	default boolean shiftWalkBoxTraps()
	{
		return true;
	}

	@ConfigItem(
		keyName = "shiftWalkAttackOption",
		name = "Walk Under Attack Options",
		description = "Press \"Shift\" to be able to walk instead of attacking. Make sure Left Click Attack is on."
	)
	default boolean shiftWalkAttackOption()
	{
		return true;
	}
*/

}
