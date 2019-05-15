/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Raiever <https://github.com/Raieverr>
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

package net.runelite.client.plugins.hideprayers.INDIVIDUAL;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hideprayersINDIVIDUAL")
public interface HidePrayersINDIVIDUALConfig extends Config
{
	@ConfigItem
	(
		position = 0,
		keyName = "pk prayers",
		name = "Hide Prayers",
		description = "Hide/Show Prayers."
	)
	default boolean showINDIVIDUALPrayers() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 1,
		keyName = "thickskin",
		name = "Hide Thick Skin",
		description = "Hide/Show Thick Skin"
	)
	default boolean HideTHICK_SKIN()
	{ 
		return false; 
	}	

	@ConfigItem
	(
		position = 2,
		keyName = "burstofstrength",
		name = "Hide Burst of Strength",
		description = "Hide/Show Burst of Strength"
	)
	default boolean HideBURST_OF_STRENGTH()
	{ 
		return false; 
	}	

	@ConfigItem
	(
		position = 3,
		keyName = "clarityofthought",
		name = "Hide Clarity of Thought",
		description = "Hide/Show Clarity of Thought"
	)
	default boolean HideCLARITY_OF_THOUGHT()
	{ 
		return false; 
	}		
	
	@ConfigItem
	(
		position = 4,
		keyName = "sharpeye",
		name = "Hide Sharp Eye",
		description = "Hide/Show Sharp Eye"
	)
	default boolean HideSHARP_EYE()
	{ 
		return false; 
	}	
	
	@ConfigItem
	(
		position = 5,
		keyName = "mysticwill",
		name = "Hide Mystic Will",
		description = "Hide/Show Mystic Will"
	)
	default boolean HideMYSTIC_WILL()
	{ 
		return false; 
	}	
	
	@ConfigItem
	(
		position = 6,
		keyName = "rockskin",
		name = "Hide Rock Skin",
		description = "Hide/Show Rock Skin"
	)
	default boolean HideROCK_SKIN()
	{ 
		return false; 
	}	
	
	@ConfigItem
	(
		position = 7,
		keyName = "superhumanstrength",
		name = "Hide Super Human Strength",
		description = "Hide/Show Super Human Strength"
	)
	default boolean HideSUPERHUMAN_STRENGTH()
	{ 
		return false; 
	}	
	
	@ConfigItem
	(
		position = 8,
		keyName = "improvedreflexes",
		name = "Hide Improved_Reflexes",
		description = "Hide/Show Improved_Reflexes"
	)
	default boolean HideIMPROVED_REFLEXES()
	{ 
		return false; 
	}		
				
	@ConfigItem
	(
		position = 9,
		keyName = "rapidrestore",
		name = "Hide Rapid Restore",
		description = "Hide/Show Rapid Restore"
	)
	default boolean HideRapidRestore()
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 10,
		keyName = "rapidheal",
		name = "Hide Rapid Heal",
		description = "Hide/Show Rapid Heal"
	)
	default boolean HideRapidHeal() 
	{ 
		return false; 
	}
	@ConfigItem
	(
		position = 11,
		keyName = "protectitem",
		name = "Hide Protect Item",
		description = "Hide/Show Protect Item"
	)
	default boolean HideProtectItem() 
	{ 
		return false; 
	}
	
	@ConfigItem
	(
		position = 12,
		keyName = "hawkeye",
		name = "Hide Hawk Eye",
		description = "Hide/Show Hawk Eye"
	)
	default boolean HideHAWK_EYE() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 13,
		keyName = "mysticlore",
		name = "Hide Mystic Lore",
		description = "Hide/Show Mystic Lore"
	)
	default boolean HideMYSTIC_LORE()
	{ 
		return false; 
	}
	

	@ConfigItem
	(
		position = 14,
		keyName = "steelskin",
		name = "Hide Steel Skin",
		description = "Hide/Show Steel skin"
	)
	default boolean HideSteelSkin() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 15,
		keyName = "ultimatestrength",
		name = "Hide Ultimate Strength",
		description = "Hide/Show Ultimate strength"
	)
	default boolean HideUltimateStrength() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 16,
		keyName = "incrediblereflex",
		name = "Hide Incredible Reflex",
		description = "Hide/Show Incredible Reflex"
	)
	default boolean HideIncredibleReflex() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 17,
		keyName = "PTFMagic",
		name = "Hide Protect From Magic",
		description = "Hide/Show Protect From Magic"
	)
	default boolean HidePTFMagic() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 18,
		keyName = "PTFRange",
		name = "Hide Protect From Range",
		description = "Hide/Show Protect from Range"
	)
	default boolean HidePTFRange() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 19,
		keyName = "PTFMelee",
		name = "Hide Protect From Melee",
		description = "Hide/Show Protect From Melee"
	)
	default boolean HidePTFMelee() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 20,
		keyName = "eagle",
		name = "Hide Eagle Eye",
		description = "Hide/Show Eagle Eye"
	)
	default boolean HideEagle() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 19,
		keyName = "mystic",
		name = "Hide Mystic Might",
		description = "Hide/Show Mystic Might"
	)
	default boolean HideMystic() 
	{ 
		return false; 
	}
	
	@ConfigItem
	(
		position = 21,
		keyName = "Retribution",
		name = "Hide Retribution",
		description = "Hide/Show Retribution"
	)
	default boolean HideRETRIBUTION() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 22,
		keyName = "redemption",
		name = "Hide Redemption",
		description = "Hide/Show Redemption"
	)
	default boolean HideRedemption() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 23,
		keyName = "smite",
		name = "Hide Smite",
		description = "Hide/Show Smite"
	)
	default boolean HideSmite() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 24,
		keyName = "preserve",
		name = "Hide Preserve",
		description = "Hide/Show Preserve"
	)
	default boolean HidePreserve() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 25,
		keyName = "Chivalry",
		name = "Hide Chivalry",
		description = "Hide/Show Chivalry"
	)
	default boolean HideChivalry() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 26,
		keyName = "Piety",
		name = "Hide Piety",
		description = "Hide/Show Piety"
	)
	default boolean HidePiety() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 27,
		keyName = "Rigour",
		name = "Hide Rigour",
		description = "Hide/Show Rigour"
	)
	default boolean HideRigour() 
	{ 
		return false; 
	}

	@ConfigItem
	(
		position = 28,
		keyName = "Augury",
		name = "Hide Augury",
		description = "Hide/Show Augury"
	)
	default boolean HideAugury() 
	{
		return false;
	}
}