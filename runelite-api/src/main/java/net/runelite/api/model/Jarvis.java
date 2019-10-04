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

import java.util.List;
import net.runelite.api.Point;
import net.runelite.api.geometry.SimplePolygon;

/**
 * Provides utility methods for computing the convex hull of a list of
 * <em>n</em> points.
 * <p>
 * The implementation uses the Jarvis march algorithm and runs in O(nh)
 * time in the worst case, where n is the number of points and h the
 * number of points on the convex hull.
 */
public class Jarvis
{
	/**
	 * Computes and returns the convex hull of the passed points.
	 * <p>
	 * The size of the list must be at least 3, otherwise this method will
	 * return null.
	 *
	 * @param points list of points
	 * @return list containing the points part of the convex hull
	 */
	@Deprecated
	public static List<Point> convexHull(List<Point> points)
	{
		int[] xs = new int[points.size()];
		int[] ys = new int[xs.length];
		for (int i = 0; i < xs.length; i++)
		{
			Point p = points.get(i);
			xs[i] = p.getX();
			ys[i] = p.getY();
		}

		SimplePolygon poly = convexHull(xs, ys);
		if (poly == null)
		{
			return null;
		}

		return poly.toRuneLitePointList();
	}

	/**
	 * Computes and returns the convex hull of the passed points.
	 * <p>
	 * The size of the list must be at least 3, otherwise this method will
	 * return null.
	 *
	 * @return a shape the points part of the convex hull
	 */
	public static SimplePolygon convexHull(int[] xs, int[] ys)
	{
		int length = xs.length;

		// remove any invalid entries
		{
			int i = 0, offset = 0;
			for (; i < length; i++)
			{
				if (xs[i] == Integer.MIN_VALUE)
				{
					offset++;
					i++;
					break;
				}
			}
			for (; i < length; i++)
			{
				if (xs[i] == Integer.MIN_VALUE)
				{
					offset++;
					continue;
				}
				xs[i - offset] = xs[i];
				ys[i - offset] = ys[i];
			}
			length -= offset;
		}

		if (length < 3)
		{
			return null;
		}

		// find the left most point
		int left = findLeftMost(xs, ys, length);

		// current point we are on
		int current = left;

		SimplePolygon out = new SimplePolygon(new int[16], new int[16], 0);

		do
		{
			int cx = xs[current];
			int cy = ys[current];
			out.pushRight(cx, cy);

			if (out.size() > length)
			{
				return null;
			}

			// the next point - all points are to the right of the
			// line between current and next
			int next = 0;
			int nx = xs[next];
			int ny = ys[next];

			for (int i = 1; i < length; i++)
			{
				long cp = crossProduct(cx, cy, xs[i], ys[i], nx, ny);
				if (cp > 0 || (cp == 0 && square(cx - xs[i]) + square(cy - ys[i]) > square(cx - nx) + square(cy - ny)))
				{
					next = i;
					nx = xs[next];
					ny = ys[next];
				}
			}

			current = next;
		}
		while (current != left);

		return out;
	}

	private static int square(int x)
	{
		return x * x;
	}

	private static int findLeftMost(int[] xs, int[] ys, int length)
	{
		int idx = 0;
		int x = xs[idx];
		int y = ys[idx];

		for (int i = 1; i < length; i++)
		{
			int ix = xs[i];
			if (ix < x || ix == x && ys[i] < y)
			{
				idx = i;
				x = xs[idx];
				y = ys[idx];
			}
		}

		return idx;
	}

	private static long crossProduct(int px, int py, int qx, int qy, int rx, int ry)
	{
		long val = (long) (qy - py) * (rx - qx)
			- (long) (qx - px) * (ry - qy);
		return val;
	}
}