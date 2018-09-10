/*
 * Copyright (c) 2017, Ron <https://github.com/raiyni>
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
package net.runelite.api.coords;

import java.awt.Rectangle;
import javax.annotation.Nonnull;
import lombok.Value;
import net.runelite.api.Line;
import net.runelite.api.Point;

/**
 * A line containing two world points.
 * <p>
 * WorldLines are immutable. Methods that modify the properties create a new
 * instance.
 */
@Value
@Nonnull
public class WorldLine
{
	/**
	 * start coordinate.
	 */
	private final WorldPoint start;

	/**
	 * end coordinate.
	 */
	private final WorldPoint end;


	public String toString()
	{
		return "WorldLine{" + "start=" + start.toString() + " - end=" + end.toString() + '}';
	}

	/**
	 * Offsets the start coordinate by the passed value.
	 *
	 * @param dx the x offset
	 * @param dy the y offset
	 * @param dz the plane offset
	 * @return new instance
	 */
	public WorldLine dstart(int dx, int dy, int dz)
	{
		return new WorldLine(new WorldPoint(dx, dy, dz), end);
	}

	/**
	 * Offsets the end coordinate by the passed value.
	 *
	 * @param dx the x offset
	 * @param dy the y offset
	 * @param dz the plane offset
	 * @return new instance
	 */
	public WorldLine dend(int dx, int dy, int dz)
	{
		return new WorldLine(start, new WorldPoint(dx, dy, dz));
	}

	/**
	 * Test and return line that intersects, or is in, rectangle
	 *
	 * @param xMin the minimum x value
	 * @param yMin the minimum y value
	 * @param xMax the maximum x value
	 * @param yMax the maximum y value
	 *
	 * @return new instance
	 */
	public WorldLine liangBarsky(int xMin, int yMin, int xMax, int yMax)
	{
		double u1 = 0, u2 = 1;
		int x0 = start.getX(), y0 = start.getY(), x1 = end.getX(), y1 = end.getY();
		int dx = x1 - x0, dy = y1 - y0;
		int p[] = {-dx, dx, -dy, dy};
		int q[] = {x0 - xMin, xMax - x0, y0 - yMin, yMax - y0};
		for (int i = 0; i < 4; i++)
		{
			if (p[i] == 0)
			{
				if (q[i] < 0)
				{
					return null;
				}
			}
			else
			{
				double u = (double) q[i] / p[i];
				if (p[i] < 0)
				{
					u1 = Math.max(u, u1);
				}
				else
				{
					u2 = Math.min(u, u2);
				}
			}
		}

		if (u1 > u2)
		{
			return null;
		}


		int nx0 = (int) (x0 + u1 * dx);
		int ny0 = (int) (y0 + u1 * dy);
		int nx1 = (int) (x0 + u2 * dx);
		int ny1 = (int) (y0 + u2 * dy);


		return new WorldLine(new WorldPoint(nx0, ny0, start.getPlane()), new WorldPoint(nx1, ny1, end.getPlane()));
	}

	/**
	 * Convert line from world space into map pixel space
	 *
	 * @param worldMapPosition the center of the map
	 * @param worldMapRect the map bounds
	 * @param pixelsPerTile the pixels per tile
	 *
	 * @return
	 */

	public Line toMapLine(Point worldMapPosition, Rectangle worldMapRect, float pixelsPerTile)
	{
		Point p1 = toPixels(start, worldMapPosition, worldMapRect, pixelsPerTile);
		Point p2 = toPixels(end, worldMapPosition, worldMapRect, pixelsPerTile);
		return new Line(p1, p2);
	}

	private Point toPixels(WorldPoint p, Point worldMapPosition, Rectangle worldMapRect, float pixelsPerTile)
	{
		int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
		int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

		int ry1 = worldMapPosition.getY() - heightInTiles / 2;

		int yTileOffset = (ry1 - p.getY() - 1) * -1;
		int xTileOffset = p.getX() + widthInTiles / 2 - worldMapPosition.getX();

		int xGraphDiff = (int) (xTileOffset * pixelsPerTile);
		int yGraphDiff = (int) (yTileOffset * pixelsPerTile);

		//Center on tile.
		yGraphDiff -= pixelsPerTile - Math.ceil(pixelsPerTile / 2);
		xGraphDiff += pixelsPerTile - Math.ceil(pixelsPerTile / 2);

		yGraphDiff = worldMapRect.height - yGraphDiff;
		yGraphDiff += (int) worldMapRect.getY();
		xGraphDiff += (int) worldMapRect.getX();

		return new Point(xGraphDiff, yGraphDiff);
	}
}
