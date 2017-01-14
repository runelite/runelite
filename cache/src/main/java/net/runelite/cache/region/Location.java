/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.cache.region;

import java.util.Objects;

public class Location
{
	private final int id;
	private final int type;
	private final int orientation;
	private final Position position;

	public Location(int id, int type, int orientation, Position position)
	{
		this.id = id;
		this.type = type;
		this.orientation = orientation;
		this.position = position;
	}

	@Override
	public String toString()
	{
		return "GamwObject{" + "id=" + id + ", type=" + type + ", orientation=" + orientation + ", position=" + position + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 83 * hash + this.id;
		hash = 83 * hash + this.type;
		hash = 83 * hash + this.orientation;
		hash = 83 * hash + Objects.hashCode(this.position);
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
		final Location other = (Location) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.type != other.type)
		{
			return false;
		}
		if (this.orientation != other.orientation)
		{
			return false;
		}
		if (!Objects.equals(this.position, other.position))
		{
			return false;
		}
		return true;
	}

	public int getId()
	{
		return id;
	}

	public int getType()
	{
		return type;
	}

	public int getOrientation()
	{
		return orientation;
	}

	public Position getPosition()
	{
		return position;
	}
}
