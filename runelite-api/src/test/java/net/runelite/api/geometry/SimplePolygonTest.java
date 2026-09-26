/*
 * Copyright (c) 2019 Abex
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
package net.runelite.api.geometry;

import java.awt.Rectangle;
import java.awt.geom.Area;
import org.junit.Assert;
import org.junit.Test;

public class SimplePolygonTest
{
	@Test
	public void growsInBothDirections()
	{
		SimplePolygon polygon = new SimplePolygon();
		for (int i = 0; i < 2000; i++)
		{
			polygon.pushRight(i, i * 2);
			polygon.pushLeft(-i - 1, (-i - 1) * 2);
		}
		Assert.assertEquals(4000, polygon.size());
		for (int i = 0; i < polygon.size(); i++)
		{
			Assert.assertEquals(i - 2000, polygon.getX(i));
			Assert.assertEquals((i - 2000) * 2, polygon.getY(i));
		}
	}

	@Test
	public void growsFromEmptyArrays()
	{
		SimplePolygon polygon = new SimplePolygon(new int[0], new int[0], 0);
		polygon.pushRight(1, 2);
		polygon.pushLeft(3, 4);
		Assert.assertEquals(2, polygon.size());
		Assert.assertEquals(3, polygon.getX(0));
		Assert.assertEquals(4, polygon.getY(0));
		Assert.assertEquals(1, polygon.getX(1));
		Assert.assertEquals(2, polygon.getY(1));
	}

	@Test
	public void appendsOnlyActiveVertices()
	{
		SimplePolygon source = new SimplePolygon(new int[]{0, 1, 2, 3}, new int[]{0, 2, 4, 6}, 4);
		source.popLeft();
		source.popRight();
		SimplePolygon destination = new SimplePolygon();
		destination.pushLeft(-1, -2);
		for (int i = 0; i < 1000; i++)
		{
			source.appendTo(destination);
		}
		Assert.assertEquals(2001, destination.size());
		Assert.assertEquals(-1, destination.getX(0));
		Assert.assertEquals(-2, destination.getY(0));
		for (int i = 1; i < destination.size(); i++)
		{
			Assert.assertEquals(2 - i % 2, destination.getX(i));
			Assert.assertEquals((2 - i % 2) * 2, destination.getY(i));
		}
		Assert.assertEquals(2, source.size());
		Assert.assertEquals(1, source.getX(0));
		Assert.assertEquals(2, source.getX(1));
	}

	@Test
	public void appendsToSelf()
	{
		SimplePolygon polygon = new SimplePolygon(new int[]{1, 2, 3}, new int[]{2, 4, 6}, 3);
		for (int iteration = 0; iteration < 5; iteration++)
		{
			polygon.appendTo(polygon);
		}
		Assert.assertEquals(96, polygon.size());
		for (int i = 0; i < polygon.size(); i++)
		{
			Assert.assertEquals(i % 3 + 1, polygon.getX(i));
			Assert.assertEquals((i % 3 + 1) * 2, polygon.getY(i));
		}
	}

	@Test
	public void appendingSharedArraysPreservesSource()
	{
		int[] x = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
		int[] y = new int[]{0, 2, 4, 6, 8, 10, 12, 14};
		SimplePolygon source = new SimplePolygon(x, y, 2, 3);
		SimplePolygon destination = new SimplePolygon(x, y, 0, 2);
		source.appendTo(destination);
		Assert.assertEquals(2, source.getX(0));
		Assert.assertEquals(3, source.getX(1));
		Assert.assertEquals(4, source.getY(0));
		Assert.assertEquals(6, source.getY(1));
		Assert.assertEquals(5, destination.size());
		Assert.assertEquals(2, destination.getX(3));
		Assert.assertEquals(3, destination.getX(4));
	}

	@Test
	public void clippingAfterGrowth()
	{
		SimplePolygon polygon = new SimplePolygon();
		for (int i = 0; i < 100; i++)
		{
			polygon.pushRight(0, i);
		}
		for (int i = 0; i < 100; i++)
		{
			polygon.pushRight(i, 100);
		}
		for (int i = 100; i > 0; i--)
		{
			polygon.pushRight(100, i);
		}
		for (int i = 100; i > 0; i--)
		{
			polygon.pushRight(i, 0);
		}
		SimplePolygon clip = new SimplePolygon(new int[]{20, 20, 80, 80}, new int[]{20, 80, 80, 20}, 4);
		polygon.intersectWithConvex(clip);
		Area difference = new Area(new Rectangle(20, 20, 60, 60));
		difference.exclusiveOr(new Area(polygon));
		Assert.assertTrue(difference.isEmpty());
	}
}
