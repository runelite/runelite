/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
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
package net.runelite.client.plugins.antidrag;

import net.runelite.api.Constants;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(AntiDragPlugin.CONFIG_GROUP)
public interface AntiDragConfig extends Config
{
	@ConfigItem(
		keyName = "dragDelay",
		name = "Drag delay",
		description = "Configures the inventory drag delay in client ticks (20ms).",
		position = 1
	)
	default int dragDelay()
	{
		return Constants.GAME_TICK_LENGTH / Constants.CLIENT_TICK_LENGTH; // one game tick
	}

	@ConfigItem(
		keyName = "onShiftOnly",
		name = "On shift only",
		description = "Configures whether to only adjust the delay while holding shift.",
		position = 2
	)
	default boolean onShiftOnly()
	{
		return true;
	}

	@ConfigItem(
		keyName = "disableOnCtrl",
		name = "Disable on control pressed",
		description = "Configures whether to ignore the delay while holding control.",
		position = 3
	)
	default boolean disableOnCtrl()
	{
		return false;
	}
}
