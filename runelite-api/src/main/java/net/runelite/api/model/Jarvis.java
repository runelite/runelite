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
 * Implementation of the Jarvis march algorithm
 * https://en.wikipedia.org/wiki/Gift_wrapping_algorithm
 * @author adam
 */
public class Jarvis
{
	/**
	 * compute the convex hull of a given set of points
	 *
	 * @param points
	 * @return
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

				int cp = crossProduct(current, p, next);
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

			assert ch.size() <= points.size() : "hull has more points than graph";
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

	private static int crossProduct(Point p, Point q, Point r)
	{
		int val = (q.getY() - p.getY()) * (r.getX() - q.getX())
			- (q.getX() - p.getX()) * (r.getY() - q.getY());
		return val;
	}
}
