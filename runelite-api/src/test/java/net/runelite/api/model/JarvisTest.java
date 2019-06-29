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

import java.util.Arrays;
import java.util.List;
import net.runelite.api.Point;
import org.junit.Assert;
import org.junit.Test;

public class JarvisTest
{
	@Test
	public void test()
	{
		Point[] points =
		{
			new Point(0, 3),
			new Point(1, 1),
			new Point(2, 2),
			new Point(4, 4),
			new Point(0, 0),
			new Point(1, 2),
			new Point(3, 1),
			new Point(3, 3)
		};

		List<Point> result = Jarvis.convexHull(Arrays.asList(points));
		Assert.assertEquals(4, result.size());
		Assert.assertEquals(new Point(0, 0), result.get(0));
		Assert.assertEquals(new Point(0, 3), result.get(1));
		Assert.assertEquals(new Point(4, 4), result.get(2));
		Assert.assertEquals(new Point(3, 1), result.get(3));
	}

	@Test
	public void test2()
	{
		Point[] points =
		{
			new Point(0, 3),
			new Point(4, 2),
			new Point(3, 5),
			new Point(5, 3),
			new Point(3, 0),
			new Point(1, 1),
			new Point(1, 2),
			new Point(2, 2)
		};

		List<Point> result = Jarvis.convexHull(Arrays.asList(points));
		Assert.assertEquals(5, result.size());
		Assert.assertEquals(new Point(0, 3), result.get(0));
		Assert.assertEquals(new Point(3, 5), result.get(1));
		Assert.assertEquals(new Point(5, 3), result.get(2));
		Assert.assertEquals(new Point(3, 0), result.get(3));
		Assert.assertEquals(new Point(1, 1), result.get(4));
	}

	@Test
	public void testCollinear()
	{
		Point[] points = new Point[]
		{
			new Point(604, 76),
			new Point(609, 81),
			new Point(606, 78),
			new Point(602, 74),
			new Point(610, 74),
			new Point(609, 77),
			new Point(602, 72),
			new Point(606, 77),
			new Point(611, 77),
			new Point(607, 72),
			new Point(616, 74),
			new Point(611, 70),
			new Point(611, 71),
			new Point(610, 73),
			new Point(614, 82),
			new Point(615, 79),
			new Point(615, 77),
			new Point(615, 76),
			new Point(634, 71),
			new Point(604, 76)
		};
		Jarvis.convexHull(Arrays.asList(points));
	}
}
