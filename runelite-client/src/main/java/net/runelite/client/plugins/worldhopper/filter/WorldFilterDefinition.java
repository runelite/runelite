/*
 * Copyright (c) 2019, Royce Mathews <mathewsr23@gmail.com>
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

package net.runelite.client.plugins.worldhopper.filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import net.runelite.http.api.worlds.WorldType;
import static net.runelite.http.api.worlds.WorldType.*;

public class WorldFilterDefinition
{

	private boolean hideF2P;
	private Collection<WorldType> hiddenTypes;

	WorldFilterDefinition()
	{
		hiddenTypes = new HashSet<>();
	}

	WorldFilterDefinition hideF2P(boolean aHidden)
	{
		hideF2P = aHidden;
		return this;
	}

	WorldFilterDefinition hideP2P(boolean aHidden)
	{
		if (aHidden)
		{
			hiddenTypes.add(MEMBERS);
		}
		return this;
	}

	WorldFilterDefinition hideSkillWorld(boolean aHidden)
	{
		if (aHidden)
		{
			hiddenTypes.add(SKILL_TOTAL);
		}
		return this;
	}

	WorldFilterDefinition hidePvP(boolean aHidden)
	{
		if (aHidden)
		{
			hiddenTypes.addAll(Arrays.asList(PVP, PVP_HIGH_RISK, BOUNTY, LAST_MAN_STANDING));
		}
		return this;
	}

	WorldFilterDefinition hideDeadman(boolean aHidden)
	{
		if (aHidden)
		{
			hiddenTypes.addAll(Arrays.asList(DEADMAN, SEASONAL_DEADMAN, DEADMAN_TOURNAMENT));
		}
		return this;
	}

	WorldFilterDefinition hideUnrestricted(boolean aHidden)
	{
		if (aHidden)
		{
			hiddenTypes.add(TOURNAMENT);
		}
		return this;
	}

	boolean shouldHideF2P()
	{
		return hideF2P;
	}

	Collection<WorldType> getHiddenTypes()
	{
		return hiddenTypes;
	}
}
