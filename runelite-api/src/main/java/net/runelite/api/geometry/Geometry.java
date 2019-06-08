/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Geometry
{
	/**
	 * Find the point where two lines intersect.
	 *
	 * @param x1 X coordinate of the first endpoint of the first line.
	 * @param y1 Y coordinate of the first endpoint of the first line.
	 * @param x2 X coordinate of the second endpoint of the first line.
	 * @param y2 Y coordinate of the second endpoint of the first line.
	 * @param x3 X coordinate of the first endpoint of the second line.
	 * @param y3 Y coordinate of the first endpoint of the second line.
	 * @param x4 X coordinate of the second endpoint of the second line.
	 * @param y4 Y coordinate of the second endpoint of the second line.
	 * @return The intersection point of the lines, or null if the lines don't intersect.
	 */
	public static Point2D.Float lineIntersectionPoint(
		float x1, float y1, float x2, float y2,
		float x3, float y3, float x4, float y4)
	{
		// https://stackoverflow.com/a/1968345

		float p1x = x2 - x1;
		float p1y = y2 - y1;
		float p2x = x4 - x3;
		float p2y = y4 - y3;

		float s = (-p1y * (x1 - x3) + p1x * (y1 - y3)) / (-p2x * p1y + p1x * p2y);
		float t = ( p2x * (y1 - y3) - p2y * (x1 - x3)) / (-p2x * p1y + p1x * p2y);

		if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
		{
			float x = x1 + (t * p1x);
			float y = y1 + (t * p1y);
			return new Point2D.Float(x, y);
		}

		// No intersection
		return null;
	}

	/**
	 * Find the intersection points between a Shape and a line.
	 *
	 * @param shape The shape.
	 * @param x1 X coordinate of the first endpoint of the line.
	 * @param y1 Y coordinate of the first endpoint of the line.
	 * @param x2 X coordinate of the second endpoint of the line.
	 * @param y2 Y coordinate of the second endpoint of the line.
	 * @return A list with the intersection points.
	 */
	public static List<Point2D.Float> intersectionPoints(Shape shape, float x1, float y1, float x2, float y2)
	{
		List<Point2D.Float> intersections = new LinkedList<>();

		PathIterator it = shape.getPathIterator(new AffineTransform());
		float[] coords = new float[2];
		float[] prevCoords = new float[2];
		float[] start = new float[2];
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				start[0] = coords[0];
				start[1] = coords[1];
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_LINETO)
			{
				Point2D.Float intersection = lineIntersectionPoint(
					prevCoords[0], prevCoords[1], coords[0], coords[1], x1, y1, x2, y2);
				if (intersection != null)
				{
					intersections.add(intersection);
				}
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_CLOSE)
			{
				Point2D.Float intersection = lineIntersectionPoint(
					coords[0], coords[1], start[0], start[1], x1, y1, x2, y2);
				if (intersection != null)
				{
					intersections.add(intersection);
				}
			}
			it.next();
		}

		return intersections;
	}

	/**
	 * Transforms the points in a path according to a method.
	 *
	 * @param it The iterator of the path to change the points on.
	 * @param method The method to use to transform the points. Takes a float[2] array with x and y coordinates as parameter.
	 * @return The transformed path.
	 */
	public static GeneralPath transformPath(PathIterator it, Consumer<float[]> method)
	{
		GeneralPath path = new GeneralPath();
		float[] coords = new float[2];
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				method.accept(coords);
				path.moveTo(coords[0], coords[1]);
			}
			else if (type == PathIterator.SEG_LINETO)
			{
				method.accept(coords);
				path.lineTo(coords[0], coords[1]);
			}
			else if (type == PathIterator.SEG_CLOSE)
			{
				path.closePath();
			}
			it.next();
		}

		return path;
	}

	/**
	 * Transforms the points in a path according to a method.
	 *
	 * @param path The path to change the points on.
	 * @param method The method to use to transform the points. Takes a float[2] array with x and y coordinates as parameter.
	 * @return The transformed path.
	 */
	public static GeneralPath transformPath(GeneralPath path, Consumer<float[]> method)
	{
		return transformPath(path.getPathIterator(new AffineTransform()), method);
	}

	/**
	 * Splits a line into smaller segments and appends the segments to a path.
	 *
	 * @param path The path to append lines to.
	 * @param segmentLength The desired length to use for the segmented lines.
	 * @param x1 X coordinate of the first endpoint of the line.
	 * @param y1 Y coordinate of the first endpoint of the line.
	 * @param x2 X coordinate of the second endpoint of the line.
	 * @param y2 Y coordinate of the second endpoint of the line.
	 */
	private static void appendSegmentLines(GeneralPath path, float segmentLength,
		float x1, float y1, float x2, float y2)
	{
		float x = x1;
		float y = y1;
		float angle = (float)Math.atan2(y2 - y1, x2 - x1);
		float dx = (float)Math.cos(angle) * segmentLength;
		float dy = (float)Math.sin(angle) * segmentLength;
		float length = (float)Math.hypot(x2 - x1, y2 - y1);
		int steps = (int)((length - 1e-4) / segmentLength);
		for (int i = 0; i < steps; i++)
		{
			x += dx;
			y += dy;
			path.lineTo(x, y);
		}
	}

	/**
	 * Splits a path into smaller segments.
	 * For example, calling this on a path with a line of length 6, with desired
	 * segment length of 2, would split the path into 3 consecutive lines of length 2.
	 *
	 * @param it The iterator of the path to modify.
	 * @param segmentLength The desired length to use for the segments.
	 * @return The modified path.
	 */
	public static GeneralPath splitIntoSegments(PathIterator it, float segmentLength)
	{
		GeneralPath newPath = new GeneralPath();
		float[] prevCoords = new float[2];
		float[] coords = new float[2];
		float[] startCoords = new float[2];
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				startCoords[0] = coords[0];
				startCoords[1] = coords[1];
				newPath.moveTo(coords[0], coords[1]);
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_LINETO)
			{
				appendSegmentLines(newPath, segmentLength, prevCoords[0], prevCoords[1], coords[0], coords[1]);
				newPath.lineTo(coords[0], coords[1]);
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_CLOSE)
			{
				appendSegmentLines(newPath, segmentLength, coords[0], coords[1], startCoords[0], startCoords[1]);
				newPath.closePath();
			}
			it.next();
		}

		return newPath;
	}

	/**
	 * Splits a path into smaller segments.
	 * For example, calling this on a path with a line of length 6, with desired
	 * segment length of 2, would split the path into 3 consecutive lines of length 2.
	 *
	 * @param path The path to modify.
	 * @param segmentLength The desired length to use for the segments.
	 * @return The modified path.
	 */
	public static GeneralPath splitIntoSegments(GeneralPath path, float segmentLength)
	{
		return splitIntoSegments(path.getPathIterator(new AffineTransform()), segmentLength);
	}

	/**
	 * Removes lines from a path according to a method.
	 *
	 * @param it The iterator of the path to filter.
	 * @param method The method to use to decide which lines to remove. Takes two float[2] arrays with x and y coordinates of the endpoints of the line. Lines for which the predicate returns false are removed.
	 * @return The filtered path.
	 */
	public static GeneralPath filterPath(PathIterator it, BiPredicate<float[], float[]> method)
	{
		GeneralPath newPath = new GeneralPath();
		float[] prevCoords = new float[2];
		float[] coords = new float[2];
		float[] start = new float[2];
		boolean shouldMoveNext = false;
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				start[0] = coords[0];
				start[1] = coords[1];
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
				shouldMoveNext = true;
			}
			else if (type == PathIterator.SEG_LINETO)
			{
				if (method.test(prevCoords, coords))
				{
					if (shouldMoveNext)
					{
						newPath.moveTo(prevCoords[0], prevCoords[1]);
						shouldMoveNext = false;
					}
					newPath.lineTo(coords[0], coords[1]);
				}
				else
				{
					shouldMoveNext = true;
				}
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_CLOSE)
			{
				if (shouldMoveNext)
				{
					newPath.moveTo(prevCoords[0], prevCoords[1]);
				}
				if (method.test(prevCoords, start))
				{
					newPath.lineTo(start[0], start[1]);
				}
				shouldMoveNext = false;
			}
			it.next();
		}

		return newPath;
	}

	/**
	 * Removes lines from a path according to a method.
	 *
	 * @param path The path to filter.
	 * @param method The method to use to decide which lines to remove. Takes two float[2] arrays with x and y coordinates of the endpoints of the line. Lines for which the predicate returns false are removed.
	 * @return The filtered path.
	 */
	public static GeneralPath filterPath(GeneralPath path, BiPredicate<float[], float[]> method)
	{
		return filterPath(path.getPathIterator(new AffineTransform()), method);
	}

	/**
	 * Removes lines from a path that lie outside the clipping area and cuts
	 * lines intersecting with the clipping area so the resulting lines
	 * lie within the clipping area.
	 *
	 * @param it The iterator of the path to clip.
	 * @param shape The clipping area to clip with.
	 * @return The clipped path.
	 */
	public static GeneralPath clipPath(PathIterator it, Shape shape)
	{
		GeneralPath newPath = new GeneralPath();
		float[] prevCoords = new float[2];
		float[] coords = new float[2];
		float[] start = new float[2];
		float[] nextMove = new float[2];
		boolean shouldMove = false;
		boolean wasInside = false;
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				start[0] = coords[0];
				start[1] = coords[1];
				wasInside = shape.contains(coords[0], coords[1]);
				if (wasInside)
				{
					nextMove[0] = coords[0];
					nextMove[1] = coords[1];
					shouldMove = true;
				}
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			else if (type == PathIterator.SEG_LINETO || type == PathIterator.SEG_CLOSE)
			{
				if (type == PathIterator.SEG_CLOSE)
				{
					coords[0] = start[0];
					coords[1] = start[1];
				}

				List<Point2D.Float> intersections = intersectionPoints(shape, prevCoords[0], prevCoords[1], coords[0], coords[1]);
				intersections.sort((a, b) ->
				{
					double diff = a.distance(prevCoords[0], prevCoords[1]) - b.distance(prevCoords[0], prevCoords[1]);
					if (diff < 0)
					{
						return -1;
					}
					if (diff > 0)
					{
						return 1;
					}
					return 0;
				});

				for (Point2D.Float intersection : intersections)
				{
					if (wasInside)
					{
						if (shouldMove)
						{
							newPath.moveTo(nextMove[0], nextMove[1]);
							shouldMove = false;
						}
						newPath.lineTo(intersection.getX(), intersection.getY());
					}
					else
					{
						nextMove[0] = intersection.x;
						nextMove[1] = intersection.y;
						shouldMove = true;
					}
					wasInside = !wasInside;
					prevCoords[0] = intersection.x;
					prevCoords[1] = intersection.y;
				}

				wasInside = shape.contains(coords[0], coords[1]);
				if (wasInside)
				{
					if (shouldMove)
					{
						newPath.moveTo(nextMove[0], nextMove[1]);
						shouldMove = false;
					}
					newPath.lineTo(coords[0], coords[1]);
				}
				else
				{
					nextMove[0] = coords[0];
					nextMove[1] = coords[1];
					shouldMove = true;
				}

				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
			}
			it.next();
		}
		return newPath;
	}

	/**
	 * Removes lines from a path that lie outside the clipping area and cuts
	 * lines intersecting with the clipping area so the resulting lines
	 * lie within the clipping area.
	 *
	 * @param path The path to clip.
	 * @param shape The clipping area to clip with.
	 * @return The clipped path.
	 */
	public static GeneralPath clipPath(GeneralPath path, Shape shape)
	{
		return clipPath(path.getPathIterator(new AffineTransform()), shape);
	}
}
