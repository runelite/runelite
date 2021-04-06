/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.regenmeter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("regenmeter")
public interface RegenMeterConfig extends Config
{
	@ConfigItem(
		keyName = "showHitpoints",
		name = "Show hitpoints regen",
		description = "Show a ring around the hitpoints orb")
	default boolean showHitpoints()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSpecial",
		name = "Show Spec. Attack regen",
		description = "Show a ring around the Special Attack orb")
	default boolean showSpecial()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWhenNoChange",
		name = "Show at full hitpoints",
		description = "Always show the hitpoints regen orb, even if there will be no stat change")
	default boolean showWhenNoChange()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notifyBeforeHpRegenDuration",
		name = "Hitpoint Notification",
		description = "Notify approximately when your next hitpoint is about to regen. A value of 0 will disable notification."
	)
	@Units(Units.SECONDS)
	default int getNotifyBeforeHpRegenSeconds()
	{
		return 0;
	}
}
