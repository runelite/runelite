/*
 * Copyright (c) 2018, Nachtmerrie <https://github.com/Nachtmerrie>
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
package net.runelite.client.plugins.kittentracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "kittenConfig",
		name = "kitten",
		description = "Configuration for the kitten plugin"
)

public interface KittenConfig extends Config
{
	@ConfigItem(
			keyName = "kittenInfoBox",
			name = "Display kitten info box",
			description = "Displays a countdown for your kitten to grow into a cat",
			position = 1
	)
	default boolean kittenInfoBox()
	{
		return true;
	}

	@ConfigItem(
			keyName = "catInfoBox",
			name = "Display cat info box",
			description = "Displays a countdown for your cat to grow into a overgrown cat",
			position = 2
	)
	default boolean catInfoBox()
	{
		return true;
	}

	@ConfigItem(
			keyName = "kittenHungryBox",
			name = "Display kitten hunger",
			description = "Displays a countdown until your kitten leaves you for being underfed",
			position = 3
	)
	default boolean kittenHungryBox()
	{
		return true;
	}

	@ConfigItem(
			keyName = "kittenAttentionBox",
			name = "Display kitten attention",
			description = "Displays a countdown until your kitten leaves you for being neglectful",
			position = 4
	)
	default boolean kittenAttentionBox()
	{
		return true;
	}

	@ConfigItem(
			keyName = "kittenNotifications",
			name = "Display kitten notifications",
			description = "Displays a notification when your kitten is hungry or requires attention",
			position = 5
	)
	default boolean kittenNotifications()
	{
		return true;
	}

	@ConfigItem(
			keyName = "secondsAlive",
			name = "",
			description = "",
			hidden = true
	)
	default int secondsAlive()
	{
		return -1;
	}

	@ConfigItem(
			keyName = "secondsAlive",
			name = "",
			description = ""
	)
	void secondsAlive(int seconds);

	@ConfigItem(
			keyName = "secondsHungry",
			name = "",
			description = "",
			hidden = true
	)
	default int secondsHungry()
	{
		return -1;
	}

	@ConfigItem(
			keyName = "secondsHungry",
			name = "",
			description = ""
	)
	void secondsHungry(int seconds);

	@ConfigItem(
			keyName = "secondsNeglected",
			name = "",
			description = "",
			hidden = true
	)
	default int secondsNeglected()
	{
		return -1;
	}

	@ConfigItem(
			keyName = "secondsNeglected",
			name = "",
			description = ""
	)
	void secondsNeglected(int seconds);

	@ConfigItem(
			keyName = "felineId",
			name = "",
			description = "",
			hidden = true
	)
	default int felineId()
	{
		return -1;
	}

	@ConfigItem(
			keyName = "felineId",
			name = "",
			description = ""
	)
	void felineId(int id);



}
