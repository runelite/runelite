/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import lombok.Data;

@Data
public class ScreenMarker
{
	private transient Stroke stroke;
	private transient ScreenMarkerOverlay overlay;
	private transient ScreenMarkerRenderable renderable;
	private Rectangle bounds;
	private String name;
	private int borderThickness;
	private Color color;
	private Color fill;
	private boolean visible;

	public ScreenMarker(Rectangle bounds, String name, int borderThickness, Color color, Color fill, boolean visible)
	{
		this.bounds = bounds;
		this.name = name;
		this.borderThickness = borderThickness;
		this.color = color;
		this.fill = fill;
		this.visible = visible;

		overlay = new ScreenMarkerOverlay(this);
		overlay.setPreferredLocation(bounds.getLocation());

		renderable = new ScreenMarkerRenderable(this);
		renderable.setPreferredSize(bounds.getSize());

		stroke = new BasicStroke(borderThickness);
	}

	public void setBorderThickness(int borderThickness)
	{
		this.borderThickness = borderThickness;
		stroke = new BasicStroke(borderThickness);
	}

	public void setLocation(Point location)
	{
		bounds.setLocation(location);
	}

	public void setSize(Dimension size)
	{
		bounds.setSize(size);
	}
}
