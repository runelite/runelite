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

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Point;

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
	 * The size of the list must be at least 4, otherwise this method will
	 * return null.
	 *
	 * @param points list of points
	 * @return list containing the points part of the convex hull
	 */
	public static List<Point> convexHull(List<Point> points)
	{
		if (points.size() < 3)
		{
			return null;
		}

		List<Point> ch = new ArrayList<>();

		// find the left most point
		Point left = findLeftMost(points);

		// current point we are on
		Point current = left;

		do
		{
			ch.add(current);
			assert ch.size() <= points.size() : "hull has more points than graph";
			if (ch.size() > points.size())
			{
				// Just to make sure we never somehow get stuck in this loop
				return null;
			}

			// the next point - all points are to the right of the
			// line between current and next
			Point next = null;

			for (Point p : points)
			{
				if (next == null)
				{
					next = p;
					continue;
				}

				long cp = crossProduct(current, p, next);
				if (cp > 0 || (cp == 0 && current.distanceTo(p) > current.distanceTo(next)))
				{
					next = p;
				}
			}

			// Points can be null if they are behind or very close to the camera.
			if (next == null)
			{
				return null;
			}

			current = next;
		}
		while (current != left);

		return ch;
	}

	private static Point findLeftMost(List<Point> points)
	{
		Point left = null;

		for (Point p : points)
		{
			if (left == null || p.getX() < left.getX())
			{
				left = p;
			}
			else if (p.getX() == left.getX() && p.getY() < left.getY())
			{
				left = p;
			}
		}

		return left;
	}

	private static long crossProduct(Point p, Point q, Point r)
	{
		long val = (long)(q.getY() - p.getY()) * (r.getX() - q.getX())
			- (long)(q.getX() - p.getX()) * (r.getY() - q.getY());
		return val;
	}
}
