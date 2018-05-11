/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

package net.runelite.client.plugins.screenmarkers;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class ScreenMarker
{
	@Getter(AccessLevel.PACKAGE)
	private int positionX;

	@Getter(AccessLevel.PACKAGE)
	private int positionY;

	@Getter(AccessLevel.PACKAGE)
	private int width;

	@Getter(AccessLevel.PACKAGE)
	private int height;

	@Getter(AccessLevel.PACKAGE)
	private BasicStroke stroke;
	private int thickness;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Color color;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean isVisible;

	ScreenMarker(int x, int y, int width, int height, int stroke, Color color)
	{
		this.setPosition(x, y);
		this.setSize(width, height);
		this.setStrokeSize(stroke);
		this.color = color;
		this.isVisible = false;
	}

	void setStrokeSize(int thickness)
	{
		this.stroke = new BasicStroke(thickness);
		this.thickness = thickness;
	}

	void setSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	void setPosition(int x, int y)
	{
		this.positionX = x;
		this.positionY = y;
	}

	ScreenMarker duplicateMarker()
	{
		return new ScreenMarker(this.positionX, this.positionY, this.width, this.height, this.thickness, this.color);
	}

	@Override
	public String toString()
	{
		return String.format("%d,%d,%d,%d,%d,%d", this.positionX, this.positionY, this.width, this.height, this.thickness, this.color.getRGB());
	}

	static ScreenMarker fromString(String input)
	{
		String[] parts = input.split(",");
		if (parts.length != 6)
			return null;

		return new ScreenMarker(
			Integer.parseInt(parts[0]),
			Integer.parseInt(parts[1]),
			Integer.parseInt(parts[2]),
			Integer.parseInt(parts[3]),
			Integer.parseInt(parts[4]),
			new Color(Integer.parseInt(parts[5]))
		);
	}
}
