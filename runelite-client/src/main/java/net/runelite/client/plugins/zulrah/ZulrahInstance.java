/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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

package net.runelite.client.plugins.zulrah;

import javax.annotation.Nullable;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.plugins.zulrah.phase.StandLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;

public class ZulrahInstance
{
	private static final ZulrahPhase NO_PATTERN_MAGIC_PHASE = new ZulrahPhase(
		ZulrahLocation.NORTH,
		ZulrahType.MAGIC,
		false,
		StandLocation.PILLAR_WEST_OUTSIDE,
		Prayer.PROTECT_FROM_MAGIC
	);
	private static final ZulrahPhase NO_PATTERN_RANGE_PHASE = new ZulrahPhase(
		ZulrahLocation.NORTH,
		ZulrahType.RANGE,
		false,
		StandLocation.TOP_EAST,
		Prayer.PROTECT_FROM_MISSILES
	);
	private static final ZulrahPhase PATTERN_A_OR_B_RANGE_PHASE = new ZulrahPhase(
		ZulrahLocation.NORTH,
		ZulrahType.RANGE,
		false,
		StandLocation.PILLAR_WEST_OUTSIDE,
		Prayer.PROTECT_FROM_MISSILES
	);

	private final LocalPoint startLocation;
	private ZulrahPattern pattern;
	private int stage;
	private ZulrahPhase phase;

	ZulrahInstance(final NPC zulrah)
	{
		this.startLocation = zulrah.getLocalLocation();
	}

	public LocalPoint getStartLocation()
	{
		return startLocation;
	}

	public ZulrahPattern getPattern()
	{
		return pattern;
	}

	public void setPattern(ZulrahPattern pattern)
	{
		this.pattern = pattern;
	}

	int getStage()
	{
		return stage;
	}

	void nextStage()
	{
		++stage;
	}

	public void reset()
	{
		pattern = null;
		stage = 0;
	}

	@Nullable
	public ZulrahPhase getPhase()
	{
		ZulrahPhase patternPhase = null;
		if (pattern != null)
		{
			patternPhase = pattern.get(stage);
		}
		return patternPhase != null ? patternPhase : phase;
	}

	public void setPhase(ZulrahPhase phase)
	{
		this.phase = phase;
	}

	@Nullable
	public ZulrahPhase getNextPhase()
	{
		if (pattern != null)
		{
			return pattern.get(stage + 1);
		}
		else if (phase != null)
		{
			ZulrahType type = phase.getType();
			StandLocation standLocation = phase.getStandLocation();
			if (type == ZulrahType.MELEE)
			{
				return standLocation == StandLocation.TOP_EAST ? NO_PATTERN_MAGIC_PHASE : NO_PATTERN_RANGE_PHASE;
			}
			if (type == ZulrahType.MAGIC)
			{
				return standLocation == StandLocation.TOP_EAST ? NO_PATTERN_RANGE_PHASE : PATTERN_A_OR_B_RANGE_PHASE;
			}
		}
		return null;
	}
}
