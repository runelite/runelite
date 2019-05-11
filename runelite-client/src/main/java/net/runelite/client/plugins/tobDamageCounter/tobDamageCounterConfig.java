/*
 * Copyright (c) 2019, Bryan Chau(RSN:Laura Brehm) <https://github.com/akarhi>
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
package net.runelite.client.plugins.tobDamageCounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tobDamageCounter")
public interface tobDamageCounterConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "tobEncouragement",
		name = "Encouragement Message",
		description = "You will get a message after ths boss dies, either good or bad."
	)
	default boolean tobEncouragement()
	{   return true;    }

	@ConfigItem(
		position = 2,
		keyName = "tobDamageTaken",
		name = "Damage Taken Message",
		description = "You will get a damage taken statistic after you died or lived."
	)
	default boolean tobDamageTaken()
	{   return true;    }

	@ConfigItem(
		position = 5,
		keyName = "tobParty",
		name = "Party Members",
		description = "The number of party members(including you) are in your group effects the ToB Bosses HP."
	)//default value will be 4, since its the most common to do in a group
	default int tobParty()
	{   return 4;   }
}
