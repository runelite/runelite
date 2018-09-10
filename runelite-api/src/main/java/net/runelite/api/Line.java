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
package net.runelite.api;


import java.awt.Rectangle;
import javax.annotation.Nonnull;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * A line with two-dimensional coordinates on the canvas.
 */
@Value
@EqualsAndHashCode
@Nonnull
public class Line
{
	private Point start;
	private Point end;

	@Override
	public String toString()
	{
		return "Line{" + "start=" + start.toString() + " - end=" + end.toString() + '}';
	}

	/**
	 * Get clickbox with given start and end with 10px padding
	 *
	 * @return Rectangle
	 */
	public Rectangle getScreenRectangle()
	{
		int x, y, width, height;

		if (start.getX() > end.getX())
		{
			x = end.getX();
			width = start.getX() - x;
		}
		else
		{
			x = start.getX();
			width = end.getX() - x;
		}

		if (start.getY() > end.getY())
		{
			y = end.getY();
			height = start.getY() - y;
		}
		else
		{
			y = start.getY();
			height = end.getY() - y;
		}

		if (height == 0)
		{
			height = 12;
			y -= 6;
		}

		if (width == 0)
		{
			width = 12;
			x -= 6;
		}

		return new Rectangle(x, y, width, height);
	}
}
