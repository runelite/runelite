/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.zulrah.phase;

import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;

public class ZulrahPhase
{
	private final ZulrahLocation zulrahLocation;
	private final ZulrahType type;
	private final boolean jad;
	private final StandLocation standLocation;
	private final Prayer prayer;

	public ZulrahPhase(ZulrahLocation zulrahLocation, ZulrahType type, boolean jad, StandLocation standLocation, Prayer prayer)
	{
		this.zulrahLocation = zulrahLocation;
		this.type = type;
		this.jad = jad;
		this.standLocation = standLocation;
		this.prayer = prayer;
	}

	public static ZulrahPhase valueOf(NPC zulrah, Point start)
	{
		ZulrahLocation zulrahLocation = ZulrahLocation.valueOf(start, zulrah.getWorldLocation());
		ZulrahType zulrahType = ZulrahType.valueOf(zulrah.getId());
		if (zulrahLocation == null || zulrahType == null)
		{
			return null;
		}
		StandLocation standLocation = zulrahType == ZulrahType.MAGIC ? StandLocation.PILLAR_WEST_OUTSIDE : StandLocation.TOP_EAST;
		Prayer prayer = zulrahType == ZulrahType.MAGIC ? Prayer.PROTECT_FROM_MAGIC : null;
		return new ZulrahPhase(zulrahLocation, zulrahType, false, standLocation, prayer);
	}

	@Override
	public String toString()
	{
		return "ZulrahPhase{" +
				"zulrahLocation=" + zulrahLocation +
				", type=" + type +
				", jad=" + jad +
				", standLocation=" + standLocation +
				", prayer=" + prayer +
				'}';
	}

	// world location
	public Point getZulrahTile(Point startTile)
	{
		// NORTH doesn't need changing because it is the start
		switch (zulrahLocation)
		{
			case SOUTH:
				return new Point(startTile.getX(), startTile.getY() - 11);
			case EAST:
				return new Point(startTile.getX() + 10, startTile.getY() - 2);
			case WEST:
				return new Point(startTile.getX() - 10, startTile.getY() - 2);
		}
		return startTile;
	}

	// world location
	public Point getStandTile(Point startTile)
	{
		switch (standLocation)
		{
			case WEST:
				return new Point(startTile.getX() - 5, startTile.getY());
			case EAST:
				return new Point(startTile.getX() + 5, startTile.getY() - 2);
			case SOUTH:
				return new Point(startTile.getX(), startTile.getY() - 6);
			case SOUTH_WEST:
				return new Point(startTile.getX() - 4, startTile.getY() - 4);
			case SOUTH_EAST:
				return new Point(startTile.getX() + 2, startTile.getY() - 6);
			case TOP_EAST:
				return new Point(startTile.getX() + 6, startTile.getY() + 2);
			case TOP_WEST:
				return new Point(startTile.getX() - 4, startTile.getY() + 3);
			case PILLAR_WEST_INSIDE:
				return new Point(startTile.getX() - 4, startTile.getY() - 3);
			case PILLAR_WEST_OUTSIDE:
				return new Point(startTile.getX() - 5, startTile.getY() - 3);
			case PILLAR_EAST_INSIDE:
				return new Point(startTile.getX() + 4, startTile.getY() - 3);
			case PILLAR_EAST_OUTSIDE:
				return new Point(startTile.getX() + 4, startTile.getY() - 4);
		}
		return startTile;
	}

	public ZulrahLocation getZulrahLocation()
	{
		return zulrahLocation;
	}

	public ZulrahType getType()
	{
		return type;
	}

	public boolean isJad()
	{
		return jad;
	}

	public StandLocation getStandLocation()
	{
		return standLocation;
	}

	public Prayer getPrayer()
	{
		return prayer;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		ZulrahPhase other = (ZulrahPhase) obj;
		return this.jad == other.jad && this.zulrahLocation == other.zulrahLocation && this.type == other.type;
	}
}
