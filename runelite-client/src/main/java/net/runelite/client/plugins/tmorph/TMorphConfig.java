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
import net.runelite.client.config.Stub;

@ConfigGroup("TMorph")
public interface TMorphConfig extends Config
{
	@ConfigItem(
		keyName = "swaps",
		name = "Morphers",
		description = "",
		position = 0
	)
	default Stub swaps()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "mageSwap",
		name = "Swap Set 1",
		description = "<html><center>Proper Format is id,id:Slot" +
			"<br>For example: 6570,21295:Cape" +
			"<br>Valid Slots: Helmet, Cape, Amulet, Weapon, Torso, Shield, Legs, Head, Hands, Boots, Jaw, Ring, Ammo</center></html>",
		parent = "swaps",
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
		name = "Swap Set 3",
		description = "<html><center>Proper Format is id,id:Slot" +
			"<br>For example: 6570,21295:Cape" +
			"<br>Valid Slots: Helmet, Cape, Amulet, Weapon, Torso, Shield, Legs, Head, Hands, Boots, Jaw, Ring, Ammo</center></html>",
		parent = "swaps",
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
		parent = "swaps",
		position = 3,
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String set3()
	{
		return "";
	}

	@ConfigItem(
		keyName = "experimentalFunctions",
		name = "Experimental Functions",
		description = "May bug out in unintended ways.",
		parent = "swaps",
		position = 4
	)
	default boolean experimentalFunctions()
	{
		return false;
	}

	//////////////////Experimental Functions

	@ConfigItem(
		keyName = "globalAnimSwap",
		name = "Global Animation Swap",
		description = "DO NOT USE WITH ANIMATION SWAP BELOW",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int globalAnimSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationSwap",
		name = "Animation Swap",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int animationSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationTarget",
		name = "Animation Target",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int animationTarget()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "globalGraphicSwap",
		name = "Global Graphic Swap",
		description = "DO NOT USE WITH GRAPHIC SWAP BELOW",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int globalGraphicSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "graphicSwap",
		name = "Graphic Swap",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int graphicSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "graphicTarget",
		name = "Graphic Target",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int graphicTarget()
	{
		return 0;
	}
}
