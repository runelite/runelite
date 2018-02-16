/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.attackindicator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "attackIndicator",
	name = "Attack Indicators",
	description = "Configuration for the attack indicator plugin"
)
public interface AttackIndicatorConfig extends Config
{
	@ConfigItem(
		keyName = "warnForDefensive",
		name = "Warn for defensive",
		description = "Configures whether or not users are warned for selecting a defensive combat option",
		position = 2
	)
	default boolean warnForDefensive()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warnForAttack",
		name = "Warn for attack",
		description = "Configures whether or not users are warned for selecting an attack combat option",
		position = 3
	)
	default boolean warnForAttack()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warnForStrength",
		name = "Warn for strength",
		description = "Configures whether or not users are warned for selecting a strength combat option",
		position = 4
	)
	default boolean warnForStrength()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warnForRanged",
		name = "Warn for ranged",
		description = "Configures whether or not users are warned for selecting a ranged combat option",
		position = 5
	)
	default boolean warnForRanged()
	{
		return false;
	}

	@ConfigItem(
		keyName = "warnForMagic",
		name = "Warn for magic",
		description = "Configures whether or not users are warned for selecting a magic combat option",
		position = 6
	)
	default boolean warnForMagic()
	{
		return false;
	}

	@ConfigItem(
		keyName = "removeWarnedStyles",
		name = "Remove warned styles",
		description = "Configures whether or not warned styles are removed from the combat options tab",
		position = 7
	)
	default boolean removeWarnedStyles()
	{
		return false;
	}
}
