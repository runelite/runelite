/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.mousehighlight;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("mousehighlight")
public interface MouseHighlightConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "mainTooltip",
		name = "Main Tooltips",
		description = "Whether or not tooltips are shown on things other than interfaces or the chatbox"
	)
	default boolean mainTooltip()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "uiTooltip",
		name = "Interface Tooltips",
		description = "Whether or not tooltips are shown on interfaces"
	)
	default boolean uiTooltip()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "chatboxTooltip",
		name = "Chatbox Tooltips",
		description = "Whether or not tooltips are shown over the chatbox"
	)
	default boolean chatboxTooltip()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "hideSpells",
		name = "Spellbook",
		description = "Hides vanilla client tooltips in the spellbook"
	)
	default boolean shouldHideSpells()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "hideCombat",
		name = "Combat",
		description = "Hides vanilla client tooltips in the combat menu"
	)
	default boolean shouldHideCombat()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "rightclickoptionTooltip",
		name = "Right Click Option Tooltips",
		description = "Whether or not tooltips are shown for options that right-click only."
	)
	default boolean isRightClickTooltipEnabled()
	{
		return true;
	}
}
