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

package net.runelite.client.plugins.coxhelper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("Cox")

public interface CoxConfig extends Config
{
	@ConfigItem(
		keyName = "muttadileStub",
		name = "Muttadile",
		description = "",
		position = 1
	)
	default Stub muttadileStub()
	{
		return new Stub();
	}
	@ConfigItem(
		position = 2,
		keyName = "Muttadile",
		name = "Muttadile Marker",
		description = "",
		parent = "muttadileStub"
	)
	default boolean Muttadile()
	{
		return true;
	}

	@ConfigItem(
		keyName = "tektonStub",
		name = "Tekton",
		description = "",
		position = 3
	)
	default Stub tektonStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 4,
		keyName = "Tekton",
		name = "Tekton Marker",
		description = "",
		parent = "tektonStub"
	)
	default boolean Tekton()
	{
		return true;
	}

	@ConfigItem(
		keyName = "guardiansStub",
		name = "Guardians",
		description = "",
		position = 5
	)
	default Stub guardiansStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 6,
		keyName = "Guardians",
		name = "Guardians timing",
		description = "",
		parent = "guardiansStub"
	)
	default boolean Guardians()
	{
		return true;
	}

	@ConfigItem(
		keyName = "olmStub",
		name = "Olm",
		description = "",
		position = 7
	)
	default Stub olmStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 8,
		keyName = "prayAgainstOlm",
		name = "Olm Show Prayer",
		description = "Shows what prayer to use during olm.",
		parent = "olmStub"
	)
	default boolean prayAgainstOlm()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "timers",
		name = "Olm Show Burn/Acid Timers",
		description = "Shows tick timers for burns/acids.",
		parent = "olmStub"
	)
	default boolean timers()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "tpOverlay",
		name = "Olm Show Teleport Overlays",
		description = "Shows Overlays for targeted teleports.",
		parent = "olmStub"
	)
	default boolean tpOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "OlmTick",
		name = "Olm Tick Counter",
		description = "Show Tick Counter on Olm",
		parent = "olmStub"
	)
	default boolean OlmTick()
	{
		return true;
	}

}
