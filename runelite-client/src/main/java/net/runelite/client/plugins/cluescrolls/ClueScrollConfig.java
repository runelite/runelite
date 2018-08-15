/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.cluescrolls;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("cluescroll")
public interface ClueScrollConfig extends Config
{
	@ConfigItem(
		keyName = "displayHintArrows",
		name = "Display hint arrows",
		description = "Configures whether or not to display hint arrows for clues",
		position = 1
	)
	default boolean displayHintArrows()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clueTitle",
		name = "Display clue title",
		description = "Configures whether or not to display clue title section",
		position = 2
	)
	default boolean displayTitle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clueHintText",
		name = "Display clue hint text",
		description = "Configures whether or not to display clue hint text in some sections",
		position = 3
	)
	default boolean displayHintText()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clueText",
		name = "Display clue text",
		description = "Configures whether or not to display clue text section",
		position = 4
	)
	default boolean displayClue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clueNpc",
		name = "Display clue NPC",
		description = "Configures whether or not to display clue NPC section",
		position = 5
	)
	default boolean displayNpc()
	{
		return true;
	}

	@ConfigItem(
		keyName = "clueArea",
		name = "Display clue area",
		description = "Configures whether or not to display clue area section",
		position = 6
	)
	default boolean displayArea()
	{
		return true;
	}

}
