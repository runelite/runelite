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
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Point;

/**
 * A simple list of vertices that can be append or prepended to
 */
@AllArgsConstructor
@Getter
@Setter
public class SimplePolygon implements Shape
{
	private static final int GROW = 16;

	protected int[] x, y;
	protected int left, right;

	public SimplePolygon()
	{
		this(new int[32], new int[32], 16, 15);
	}

	public SimplePolygon(int[] x, int[] y, int length)
	{
		this(x, y, 0, length - 1);
	}

	public void pushLeft(int xCoord, int yCoord)
	{
		left--;
		if (left < 0)
		{
			expandLeft(GROW);
		}
		x[left] = xCoord;
		y[left] = yCoord;
	}

	public void popLeft()
	{
		left++;
	}

	protected void expandLeft(int grow)
	{
		int[] nx = new int[x.length + grow];
		System.arraycopy(x, 0, nx, grow, x.length);
		x = nx;
		int[] ny = new int[nx.length];
		System.arraycopy(y, 0, ny, grow, y.length);
		y = ny;
		left += grow;
		right += grow;
	}

	public void pushRight(int xCoord, int yCoord)
	{
		right++;
		if (right >= x.length)
		{
			expandRight(GROW);
		}
		x[right] = xCoord;
		y[right] = yCoord;
	}

	public void popRight()
	{
		right--;
	}

	protected void expandRight(int grow)
	{
		int[] nx = new int[x.length + grow];
		System.arraycopy(x, 0, nx, 0, x.length);
		x = nx;
		int[] ny = new int[nx.length];
		System.arraycopy(y, 0, ny, 0, y.length);
		y = ny;
	}

	public int getX(int index)
	{
		return x[left + index];
	}

	public int getY(int index)
	{
		return y[left + index];
	}

	public int size()
	{
		return right - left + 1;
	}

	public List<Point> toRuneLitePointList()
	{
		List<Point> out = new ArrayList<>(size());
		for (int i = left; i <= right; i++)
		{
			out.add(new Point(x[i], y[i]));
		}
		return out;
	}

	public void copyTo(int[] xDest, int[] yDest, int offset)
	{
		System.arraycopy(x, left, xDest, offset, size());
		System.arraycopy(y, left, yDest, offset, size());
	}

	public void appendTo(SimplePolygon other)
	{
		int size = size();
		if (size <= 0)
		{
			return;
		}
		other.expandRight(size);
		copyTo(other.x, other.y, other.right + 1);
		other.right += size;
	}

	public void reverse()
	{
		int half = size() / 2;
		for (int i = 0; i < half; i++)
		{
			int li = left + i;
			int ri = right - i;
			int tx = x[li];
			int ty = y[li];
			x[li] = x[ri];
			y[li] = y[ri];
			x[ri] = tx;
			y[ri] = ty;
		}
	}

	/**
	 * Clips the polygon with the passed convex polygon
	 */
	public void intersectWithConvex(SimplePolygon convex)
	{
		// Sutherland-Hodgman
		int[] tx = new int[size()];
		int[] ty = new int[tx.length];

		int cx1 = convex.x[convex.right];
		int cy1 = convex.y[convex.right];
		for (int ci = convex.left; ci <= convex.right; ci++)
		{
			if (size() < 3)
			{
				return;
			}

			int tRight = this.right;
			int tLeft = this.left;

			int[] tmpX = x;
			int[] tmpY = y;

			this.x = tx;
			this.y = ty;
			this.left = 0;
			this.right = -1;
			tx = tmpX;
			ty = tmpY;

			int cx2 = convex.x[ci];
			int cy2 = convex.y[ci];

			int tx1 = tx[tRight];
			int ty1 = ty[tRight];

			for (int ti = tLeft; ti <= tRight; ti++)
			{
				int tx2 = tx[ti];
				int ty2 = ty[ti];

				int p1 = (cx2 - cx1) * (ty1 - cy1) - (cy2 - cy1) * (tx1 - cx1);
				int p2 = (cx2 - cx1) * (ty2 - cy1) - (cy2 - cy1) * (tx2 - cx1);

				if (p1 < 0 && p2 < 0)
				{
					pushRight(tx2, ty2);
				}
				else if (p1 >= 0 != p2 >= 0)
				{
					long nota = cx1 * cy2 - cy1 * cx2;
					long clue = tx1 * ty2 - ty1 * tx2;
					long div = ((cx1 - cx2) * (ty1 - ty2) - (cy1 - cy2) * (tx1 - tx2));
					pushRight((int) ((nota * (tx1 - tx2) - (cx1 - cx2) * clue) / div),
						(int) ((nota * (ty1 - ty2) - (cy1 - cy2) * clue) / div));

					if (p1 >= 0)
					{
						pushRight(tx2, ty2);
					}
				}

				tx1 = tx2;
				ty1 = ty2;
			}

			cx1 = cx2;
			cy1 = cy2;
		}
	}

	@Override
	public Rectangle getBounds()
	{
		int
			minX = Integer.MAX_VALUE,
			minY = Integer.MAX_VALUE,
			maxX = Integer.MIN_VALUE,
			maxY = Integer.MIN_VALUE;

		for (int i = left; i <= right; i++)
		{
			final int xs = x[i];
			final int ys = y[i];

			if (xs < minX)
			{
				minX = xs;
			}
			if (xs > maxX)
			{
				maxX = xs;
			}
			if (ys < minY)
			{
				minY = ys;
			}
			if (ys > maxY)
			{
				maxY = ys;
			}
		}

		return new Rectangle(minX, minY, maxX - minX, maxY - minY);
	}

	@Override
	public Rectangle2D getBounds2D()
	{
		Rectangle b = getBounds();
		return new Rectangle2D.Float(b.x, b.y, b.width, b.height);
	}

	@Override
	public boolean contains(double cx, double cy)
	{
		if (size() < 3)
		{
			return false;
		}

		return (crossings(cx, cy, false) & 1) != 0;
	}

	private int crossings(double cx, double cy, boolean swap)
	{
		int collisions = 0;

		int[] x = this.x;
		int[] y = this.y;
		if (swap)
		{
			y = this.x;
			x = this.y;
		}

		for (int x0 = x[right], y0 = y[right], x1, y1, i = left; i <= right; i++, x0 = x1, y0 = y1)
		{
			x1 = x[i];
			y1 = y[i];

			if (y0 == y1)
			{
				continue;
			}

			double dy0 = y0, dy1 = y1;

			if (cy <= dy0 == cy <= dy1)
			{
				continue;
			}

			double dx0 = x0, dx1 = x1;

			boolean left = cx < dx0;
			if (left == cx < dx1)
			{
				if (!left)
				{
					collisions++;
				}
				continue;
			}

			if ((dx1 - dx0) * (cy - dy0) - (cx - dx0) * (dy1 - dy0) > 0 == dy0 > dy1)
			{
				collisions++;
			}
		}
		return collisions;
	}

	@Override
	public boolean contains(Point2D p)
	{
		return contains(p.getX(), p.getY());
	}

	@Override
	public boolean intersects(double x0, double y0, double w, double h)
	{
		// this is horribly inefficient, but I don't think it will be called anywhere

		double x1 = x0 + w;
		double y1 = y0 + h;

		return crossings(x0, y0, false) != crossings(x1, y0, false) // top
			|| crossings(x0, y1, false) != crossings(x1, y1, false) // bottom
			|| crossings(x0, y0, true) != crossings(x0, y1, true) // left
			|| crossings(x1, y0, true) != crossings(x1, y1, true); // right

	}

	@Override
	public boolean intersects(Rectangle2D r)
	{
		return intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}

	@Override
	public boolean contains(double x, double y, double w, double h)
	{
		if (!getBounds().contains(x, y, w, h))
		{
			return false;
		}

		return !intersects(x, y, w, h);
	}

	@Override
	public boolean contains(Rectangle2D r)
	{
		return contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}


	@Override
	public PathIterator getPathIterator(AffineTransform at)
	{
		if (at == null)
		{
			return new SimpleIterator();
		}
		return new TransformIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness)
	{
		return getPathIterator(at);
	}

	private class SimpleIterator implements PathIterator
	{
		private int i = -1;

		@Override
		public int getWindingRule()
		{
			return WIND_EVEN_ODD;
		}

		@Override
		public boolean isDone()
		{
			return size() == 0 || i > right;
		}

		@Override
		public void next()
		{
			if (i == -1)
			{
				i = left;
			}
			else
			{
				i++;
			}
		}

		@Override
		public int currentSegment(float[] coords)
		{
			if (i == -1)
			{
				coords[0] = x[right];
				coords[1] = y[right];
				return SEG_MOVETO;
			}

			coords[0] = x[i];
			coords[1] = y[i];
			return SEG_LINETO;
		}

		@Override
		public int currentSegment(double[] coords)
		{
			if (i == -1)
			{
				coords[0] = x[right];
				coords[1] = y[right];
				return SEG_MOVETO;
			}

			coords[0] = x[i];
			coords[1] = y[i];
			return SEG_LINETO;
		}
	}

	private class TransformIterator extends SimpleIterator
	{
		private final AffineTransform transform;

		TransformIterator(AffineTransform transform)
		{
			this.transform = transform;
		}

		@Override
		public int currentSegment(float[] coords)
		{
			int v = super.currentSegment(coords);
			transform.transform(coords, 0, coords, 0, 2);
			return v;
		}

		@Override
		public int currentSegment(double[] coords)
		{
			int v = super.currentSegment(coords);
			transform.transform(coords, 0, coords, 0, 2);
			return v;
		}
	}
}
