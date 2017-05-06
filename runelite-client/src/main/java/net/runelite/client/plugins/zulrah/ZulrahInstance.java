/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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

import java.util.Objects;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;

/*
    Original code: https://github.com/LoveLeAnon/OSLoader
 */
public class ZulrahInstance
{
	private static final int ZULRAH_RANGE = NpcID.ZULRAH;
	private static final int ZULRAH_MELEE = NpcID.ZULRAH_2;
	private static final int ZULRAH_MAGIC = NpcID.ZULRAH_3;

	private final ZulrahLocation loc;
	//private int id;
	private ZulrahType type;
	private final boolean jad;
	private StandLocation standLoc;

	public ZulrahInstance(ZulrahLocation loc, ZulrahType type, boolean jad, StandLocation standLoc)
	{
		this.loc = loc;
		this.type = type;
		this.jad = jad;
		this.standLoc = standLoc;
	}

	ZulrahInstance(NPC npc, Point start)
	{
		Point t = npc.getLocalLocation();
		t = Perspective.localToWorld(RuneLite.getClient(), t);
		int dx = start.getX() - t.getX();
		int dy = start.getY() - t.getY();

		if (dx == -10 && dy == 2)
		{
			this.loc = ZulrahLocation.EAST;
		}
		else if (dx == 10 && dy == 2)
		{
			this.loc = ZulrahLocation.WEST;
		}
		else if (dx == 0 && dy == 11)
		{
			this.loc = ZulrahLocation.SOUTH;
		}
		else if (dx == 0 && dy == 0)
		{
			this.loc = ZulrahLocation.NORTH;
		}
		else
		{
			this.loc = null;
			System.out.printf("dx: %d dy: %d", dx, dy);
		}

		int id = npc.getId();
		switch (id)
		{
			case ZULRAH_RANGE:
				type = ZulrahType.RANGE;
				break;
			case ZULRAH_MELEE:
				type = ZulrahType.MELEE;
				break;
			case ZULRAH_MAGIC:
				type = ZulrahType.MAGIC;
				break;
		}

		jad = false;
	}

	@Override
	public String toString()
	{
		return "ZulrahInstance{" + "loc=" + loc + ", type=" + type + '}';
	}

	public Point getZulrahLoc(Point startLoc)
	{
		// NORTH doesn't need changing because it is the start
		switch (loc)
		{
			case SOUTH:
				return new Point(startLoc.getX(), startLoc.getY() - 11);
			case EAST:
				return new Point(startLoc.getX() + 10, startLoc.getY() - 2);
			case WEST:
				return new Point(startLoc.getX() - 10, startLoc.getY() - 2);
		}
		return startLoc;
	}

	public Point getStandLoc(Point startLoc)
	{
		switch (standLoc)
		{
			case WEST:
				return new Point(startLoc.getX() - 5, startLoc.getY() - 2);
			case EAST:
				return new Point(startLoc.getX() + 5, startLoc.getY() - 2);
			case SOUTH:
				return new Point(startLoc.getX(), startLoc.getY() - 6);
			case TOP_EAST:
				return new Point(startLoc.getX() + 6, startLoc.getY() + 2);
			case TOP_WEST:
				return new Point(startLoc.getX() - 4, startLoc.getY() + 3);
			case PILLAR_WEST_INSIDE:
				return new Point(startLoc.getX() - 3, startLoc.getY() - 5);
			case PILLAR_WEST_OUTSIDE:
				return new Point(startLoc.getX() - 4, startLoc.getY() - 3);
			case PILLAR_EAST_INSIDE:
				return new Point(startLoc.getX() + 3, startLoc.getY() - 5);
			case PILLAR_EAST_OUTSIDE:
				return new Point(startLoc.getX() + 4, startLoc.getY() - 3);
		}
		return startLoc;
	}

	public ZulrahLocation getLoc()
	{
		return loc;
	}

	public ZulrahType getType()
	{
		return type;
	}

	public boolean isJad()
	{
		return jad;
	}

	public StandLocation getStandLoc()
	{
		return standLoc;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 17 * hash + Objects.hashCode(this.loc);
		hash = 17 * hash + Objects.hashCode(this.type);
		hash = 17 * hash + (this.jad ? 1 : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ZulrahInstance other = (ZulrahInstance) obj;
		if (this.jad != other.jad)
		{
			return false;
		}
		if (this.loc != other.loc)
		{
			return false;
		}
		if (this.type != other.type)
		{
			return false;
		}
		return true;
	}


}
