/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
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

package net.runelite.client.plugins.zcox;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Cox")

public interface CoxConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "Muttadile",
		name = "Muttadile Marker",
		description = ""
	)
	default boolean Muttadile()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "Tekton",
		name = "Tekton Marker",
		description = ""
	)
	default boolean Tekton()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "Guardians",
		name = "Guardians timing",
		description = ""
	)
	default boolean Guardians()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "OlmSpec",
		name = "Olm Next Spec",
		description = ""
	)
	default boolean OlmSpec()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "OlmTick",
		name = "Olm Tick Counter",
		description = ""
	)
	default boolean OlmTick()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "OlmCrystals",
		name = "Olm AoE Indicator",
		description = ""
	)
	default boolean OlmCrystals()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "LargeCrystals",
		name = "Mark Large AoE Crystals rather then small ones",
		description = ""
	)
	default boolean LargeCrystals()
	{
		return true;
	}

}
