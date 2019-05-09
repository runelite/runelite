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
 
package net.runelite.client.plugins.hideprayers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hideprayers")
public interface HidePrayersConfig extends Config
{
    @ConfigItem
	(
		position = 0,
		keyName = "pk prayers",
		name = "Hides none pk prayers",
		description = "Hides widget icons."
    )
    default boolean showPrayers() 
	{ 
		return false; 
	}
    
    @ConfigItem
	(
    	position = 1,
    	keyName = "eagle/mystic",
    	name = "Shows Eagle and Mystic Prayers",
    	description = "Hides widget icons."
    )
    default boolean showEagleMystic() 
	{ 
		return false;
	}

	@ConfigItem
	(
		position = 2,
		keyName = "ultstr",
		name = "Shows Ultimate Strength/Incredible Reflex/Steel Skin",
		description = "Hides widget icons."
	)
	default boolean showUltStrength() 
	{ 
		return false; 
	}
	
	@ConfigItem
	(
		position = 3,
		keyName = "preserve",
		name = "Shows Preserve",
		description = "unides widget icons."
	)
	default boolean showPreserve() 
	{ 
		return false; 
	}
	
	@ConfigItem
	(
		position = 4,
		keyName = "redemption",
		name = "Shows Redemption",
		description = "unides widget icons."
	)
	default boolean showRedemption() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 5,
		keyName = "rapidheal",
		name = "Shows Rapid Heal",
		description = "unides widget icons."
	)
	default boolean showRapidHeal() 
	{ 
		return false; 
	}
	
	@ConfigItem
	(
		position = 6,
		keyName = "rapidRestore",
		name = "Shows Rapid restore",
		description = "unides widget icons."
	)
	default boolean showRapidRestore() 
	{ 
		return false; 
		}
}