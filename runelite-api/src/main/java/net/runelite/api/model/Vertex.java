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
package net.runelite.api.model;

import net.runelite.api.Perspective;

public class Vertex
{
	private final int x;
	private final int y;
	private final int z;

	public Vertex(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString()
	{
		return "Vertex{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 67 * hash + this.x;
		hash = 67 * hash + this.y;
		hash = 67 * hash + this.z;
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Vertex other = (Vertex) obj;
		if (this.x != other.x)
		{
			return false;
		}
		if (this.y != other.y)
		{
			return false;
		}
		if (this.z != other.z)
		{
			return false;
		}
		return true;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getZ()
	{
		return z;
	}

	/**
	 * Rotate the vertex by the given orientation
	 * @param orientation
	 * @return the newly rotated vertex
	 */
	public Vertex rotate(int orientation)
	{
		int sin = Perspective.SINE[orientation];
		int cos = Perspective.COSINE[orientation];

		return new Vertex(
			x * cos + z * sin >> 16,
			y,
			z * cos - x * sin >> 16
		);
	}
}
