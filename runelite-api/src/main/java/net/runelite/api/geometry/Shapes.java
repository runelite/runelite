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
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Shapes<T extends Shape> implements Shape
{
	public Shapes(T ...shape)
	{
		this(Arrays.asList(shape));
	}

	@Getter
	private final List<T> shapes;

	@Override
	public Rectangle getBounds()
	{
		int
			minX = Integer.MAX_VALUE,
			minY = Integer.MAX_VALUE,
			maxX = Integer.MIN_VALUE,
			maxY = Integer.MIN_VALUE;

		for (Shape shape : shapes)
		{
			Rectangle bounds = shape.getBounds();
			minX = Math.min(bounds.x, minX);
			minY = Math.min(bounds.y, minY);
			maxX = Math.max(bounds.x + bounds.width, maxX);
			maxY = Math.max(bounds.y + bounds.height, maxY);
		}

		return new Rectangle(minX, minY, maxX - minX, maxY - minY);
	}

	@Override
	public Rectangle2D getBounds2D()
	{
		double
			minX = Double.MAX_VALUE,
			minY = Double.MAX_VALUE,
			maxX = Double.MIN_VALUE,
			maxY = Double.MIN_VALUE;

		for (Shape shape : shapes)
		{
			Rectangle2D bounds = shape.getBounds2D();
			minX = Math.min(bounds.getX(), minX);
			minY = Math.min(bounds.getY(), minY);
			maxX = Math.max(bounds.getMaxX(), maxX);
			maxY = Math.max(bounds.getMaxY(), maxY);
		}

		return new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
	}

	@Override
	public boolean contains(double x, double y)
	{
		return shapes.stream().anyMatch(s -> s.contains(x, y));
	}

	@Override
	public boolean contains(Point2D p)
	{
		return shapes.stream().anyMatch(s -> s.contains(p));
	}

	@Override
	public boolean intersects(double x, double y, double w, double h)
	{
		return shapes.stream().anyMatch(s -> s.intersects(x, y, w, h));
	}

	@Override
	public boolean intersects(Rectangle2D r)
	{
		return shapes.stream().anyMatch(s -> s.intersects(r));
	}

	@Override
	public boolean contains(double x, double y, double w, double h)
	{
		return shapes.stream().anyMatch(s -> s.contains(x, y, w, h));
	}

	@Override
	public boolean contains(Rectangle2D r)
	{
		return shapes.stream().anyMatch(s -> s.contains(r));
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at)
	{
		return new ShapeIterator(shapes.stream()
			.map(s -> s.getPathIterator(at))
			.iterator());
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness)
	{
		return new ShapeIterator(shapes.stream()
			.map(s -> s.getPathIterator(at, flatness))
			.iterator());
	}

	private static class ShapeIterator implements PathIterator
	{
		private final Iterator<PathIterator> iter;
		private PathIterator current = null;
		private final int windingRule;

		ShapeIterator(Iterator<PathIterator> iter)
		{
			this.iter = iter;
			if (iter.hasNext())
			{
				current = iter.next();
				windingRule = current.getWindingRule();
				checkDone();
			}
			else
			{
				windingRule = 0;
			}
		}

		@Override
		public int getWindingRule()
		{
			return windingRule;
		}

		@Override
		public boolean isDone()
		{
			return current == null;
		}

		@Override
		public void next()
		{
			current.next();
			checkDone();
		}

		private void checkDone()
		{
			for (; current != null && current.isDone(); )
			{
				if (iter.hasNext())
				{
					current = iter.next();
					assert windingRule == current.getWindingRule();
				}
				else
				{
					current = null;
				}
			}
		}

		@Override
		public int currentSegment(float[] coords)
		{
			return current.currentSegment(coords);
		}

		@Override
		public int currentSegment(double[] coords)
		{
			return current.currentSegment(coords);
		}
	}
}
