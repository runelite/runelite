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
import net.runelite.api.Prayer;

import java.awt.Color;
import java.awt.Point;

public class ZulrahPhase
{
	private static final Color RANGE_COLOR = new Color(150, 255, 0, 100);
	private static final Color MAGIC_COLOR = new Color(20, 170, 200, 100);
	private static final Color MELEE_COLOR = new Color(180, 50, 20, 100);
	private static final Color JAD_COLOR = new Color(255, 115, 0, 100);

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
				return new Point(startTile.x, startTile.y - 11);
			case EAST:
				return new Point(startTile.x + 10, startTile.y - 2);
			case WEST:
				return new Point(startTile.x - 10, startTile.y - 2);
		}
		return startTile;
	}

	// world location
	public Point getStandTile(Point startTile)
	{
		switch (standLocation)
		{
			case WEST:
				return new Point(startTile.x - 5, startTile.y);
			case EAST:
				return new Point(startTile.x + 5, startTile.y - 2);
			case SOUTH:
				return new Point(startTile.x, startTile.y - 6);
			case SOUTH_WEST:
				return new Point(startTile.x - 4, startTile.y - 4);
			case SOUTH_EAST:
				return new Point(startTile.x + 2, startTile.y - 6);
			case TOP_EAST:
				return new Point(startTile.x + 6, startTile.y + 2);
			case TOP_WEST:
				return new Point(startTile.x - 4, startTile.y + 3);
			case PILLAR_WEST_INSIDE:
				return new Point(startTile.x - 4, startTile.y - 3);
			case PILLAR_WEST_OUTSIDE:
				return new Point(startTile.x - 5, startTile.y - 3);
			case PILLAR_EAST_INSIDE:
				return new Point(startTile.x + 4, startTile.y - 3);
			case PILLAR_EAST_OUTSIDE:
				return new Point(startTile.x + 4, startTile.y - 4);
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

	public Color getColor()
	{
		if (jad)
		{
			return JAD_COLOR;
		}
		else
		{
			switch (type)
			{
				case RANGE:
					return RANGE_COLOR;
				case MAGIC:
					return MAGIC_COLOR;
				case MELEE:
					return MELEE_COLOR;
			}
		}
		return RANGE_COLOR;
	}
}
