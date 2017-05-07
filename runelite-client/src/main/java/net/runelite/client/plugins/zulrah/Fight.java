/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.time.Instant;
import net.runelite.api.Point;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;

public class Fight
{
	private final Point startLocationWorld;
	private final Instant startTime = Instant.now();
	private ZulrahPattern pattern;
	private int stage;
	private ZulrahInstance zulrah;

	public Fight(Point startLocationWorld)
	{
		this.startLocationWorld = startLocationWorld;
	}

	public Point getStartLocationWorld()
	{
		return startLocationWorld;
	}

	public Instant getStartTime()
	{
		return startTime;
	}

	public ZulrahPattern getPattern()
	{
		return pattern;
	}

	public void setPattern(ZulrahPattern pattern)
	{
		this.pattern = pattern;
	}

	public ZulrahInstance getZulrah()
	{
		return zulrah;
	}

	public void setZulrah(ZulrahInstance zulrah)
	{
		this.zulrah = zulrah;
	}

	public int getStage()
	{
		return stage;
	}

	public void nextStage()
	{
		++stage;
	}

	public void reset()
	{
		pattern = null;
		stage = 0;
	}
}
