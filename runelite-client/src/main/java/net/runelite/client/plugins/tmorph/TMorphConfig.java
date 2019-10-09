/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.tmorph;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("TMorph")
public interface TMorphConfig extends Config
{
	@ConfigTitleSection(
		keyName = "swaps",
		name = "Morphers",
		description = "",
		position = 1
	)
	default Title swaps()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "mageSwap",
		name = "Swap Set 1",
		description = "<html><center>Proper Format is id,id:Slot" +
			"<br>For example: 6570,21295:Cape" +
			"<br>Valid Slots: Helmet, Cape, Amulet, Weapon, Torso, Shield, Legs, Head, Hands, Boots, Jaw, Ring, Ammo</center></html>",
		titleSection = "swaps",
		position = 1,
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String set1()
	{
		return "";
	}

	@ConfigItem(
		keyName = "rangeSwap",
		name = "Swap Set 2",
		description = "<html><center>Proper Format is id,id:Slot" +
			"<br>For example: 6570,21295:Cape" +
			"<br>Valid Slots: Helmet, Cape, Amulet, Weapon, Torso, Shield, Legs, Head, Hands, Boots, Jaw, Ring, Ammo</center></html>",
		titleSection = "swaps",
		position = 2,
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String set2()
	{
		return "";
	}

	@ConfigItem(
		keyName = "meleeSwap",
		name = "Swap Set 3",
		description = "<html><center>Proper Format is id,id:Slot" +
			"<br>For example: 6570,21295:Cape" +
			"<br>Valid Slots: Helmet, Cape, Amulet, Weapon, Torso, Shield, Legs, Head, Hands, Boots, Jaw, Ring, Ammo</center></html>",
		titleSection = "swaps",
		position = 3,
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String set3()
	{
		return "";
	}

	//////////////////Experimental Functions

	@ConfigSection(
		position = 4,
		keyName = "experimentalSection",
		name = "Experimental Functions",
		description = ""
	)
	default boolean experimentalSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "experimentalFunctions",
		name = "Experimental Functions",
		description = "May bug out in unintended ways.",
		section = "experimentalSection",
		position = 0
	)
	default boolean experimentalFunctions()
	{
		return false;
	}

	@ConfigItem(
		keyName = "globalAnimSwap",
		name = "Global Animation Swap",
		description = "DO NOT USE WITH ANIMATION SWAP BELOW",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 1
	)
	default int globalAnimSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationSwap",
		name = "Animation Swap",
		description = "ID",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 2
	)
	default int animationSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationTarget",
		name = "Animation Target",
		description = "ID",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 3
	)
	default int animationTarget()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "globalGraphicSwap",
		name = "Global Graphic Swap",
		description = "DO NOT USE WITH GRAPHIC SWAP BELOW",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 4
	)
	default int globalGraphicSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "graphicSwap",
		name = "Graphic Swap",
		description = "ID",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 5
	)
	default int graphicSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "graphicTarget",
		name = "Graphic Target",
		description = "ID",
		section = "experimentalSection",
		hidden = true,
		unhide = "experimentalFunctions",
		position = 6
	)
	default int graphicTarget()
	{
		return 0;
	}

	@ConfigTitleSection(
		keyName = "copy",
		name = "<html><center>If you would like to copy your equipped" +
			"<br>gear, type \"::tmorph copy\" in chat." +
			"<br>This will copy your gear to your" +
			"<br>clipboard for easy copy paste.</center></html>",
		description = "",
		position = 50
	)
	default Title copy()
	{
		return new Title();
	}
}
