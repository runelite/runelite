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

import java.util.Objects;

public class Triangle
{
	private final Vertex a;
	private final Vertex b;
	private final Vertex c;

	public Triangle(Vertex a, Vertex b, Vertex c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString()
	{
		return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 13 * hash + Objects.hashCode(this.a);
		hash = 13 * hash + Objects.hashCode(this.b);
		hash = 13 * hash + Objects.hashCode(this.c);
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
		final Triangle other = (Triangle) obj;
		if (!Objects.equals(this.a, other.a))
		{
			return false;
		}
		if (!Objects.equals(this.b, other.b))
		{
			return false;
		}
		if (!Objects.equals(this.c, other.c))
		{
			return false;
		}
		return true;
	}

	public Vertex getA()
	{
		return a;
	}

	public Vertex getB()
	{
		return b;
	}

	public Vertex getC()
	{
		return c;
	}
}
