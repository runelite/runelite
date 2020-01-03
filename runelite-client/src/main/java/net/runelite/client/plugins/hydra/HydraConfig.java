/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.hydra;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hydra")
public interface HydraConfig extends Config
{

	@ConfigItem(
		position = 1,
		keyName = "attackCounterOverlay",
		name = "Attack Counter Overlay",
		description = "Configures if an attack counter overlay is shown."
	)
	default boolean isAttackCounterOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "boldAttackCounterOverlay",
		name = "Bold Attack Counter",
		description = "Configures if the attack counter is <b>bold</b>.<br>Attack Counter Overlay must be enabled."
	)
	default boolean isBoldAttackCounterOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "prayerOverlay",
		name = "Prayer Overlay",
		description = "Configures if a prayer overlay is shown.<br>This overlay includes a mini attack counter."
	)
	default boolean isPrayerOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "poisonProjectileOverlay",
		name = "Poison Projectile Overlay",
		description = "Configures if a poison projectile overlay is shown."
	)
	default boolean isPoisonOverlay()
	{
		return true;
	}
}
