/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.plugins.spellbook;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spellbook")
public interface SpellbookConfig extends Config
{
	@ConfigItem(
		keyName = "enableMobile",
		name = "Mobile spellbook",
		description = "Show the mobile spellbook with filtered spells enabled",
		position = 1
	)
	default boolean enableMobile()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dragSpells",
		name = "Change spell location",
		description = "Add menu entry to spellbook which toggles moving spells by dragging. Only works with spells filtered",
		position = 2
	)
	default boolean dragSpells()
	{
		return true;
	}

	@ConfigItem(
		keyName = "scroll",
		name = "Scrollwheel resizing",
		description = "Resize spells by scrolling your scrollwheel over them, reset with scrollwheel click",
		position = 3
	)
	default boolean scroll()
	{
		return true;
	}

	@ConfigItem(
		keyName = "size",
		name = "Spell size",
		description = "Size (in px) of spells. Normal mobile size is 40px, use common sense for this setting",
		position = 4
	)
	default int size()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "filter",
		name = "Unfiltered spells",
		description = "Spells you don't want to filter, seperated by a comma. <br> \"'s can be used in front and behind spells (eg: '\"c' matches all spells starting with a c"
	)                                                                         //  ^ JAJAJJAJAJAJAJA BRAZIL
	default String filter()
	{
		return "";
	}

	@ConfigItem(
		keyName = "canDrag",
		name = "",
		description = "",
		hidden = true
	)
	default boolean canDrag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "canDrag",
		name = "",
		description = "",
		hidden = true
	)
	void canDrag(boolean canDrag);

	// Next 4 methods have to be here, or the reset configuration
	// button won't reset em like it should.

	@ConfigItem(
		keyName = "standard",
		name = "",
		description = "",
		hidden = true
	)
	default String standard()
	{
		return "";
	}

	@ConfigItem(
		keyName = "ancient",
		name = "",
		description = "",
		hidden = true
	)
	default String ancient()
	{
		return "";
	}

	@ConfigItem(
		keyName = "lunar",
		name = "",
		description = "",
		hidden = true
	)
	default String lunar()
	{
		return "";
	}

	@ConfigItem(
		keyName = "arceuus",
		name = "",
		description = "",
		hidden = true
	)
	default String arceuus()
	{
		return "";
	}
}
