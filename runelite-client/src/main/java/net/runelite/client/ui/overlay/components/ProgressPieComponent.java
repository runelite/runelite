/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.ui.overlay.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import lombok.Setter;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.RenderableEntity;

@Setter
public class ProgressPieComponent implements RenderableEntity
{
	private int diameter = 25;
	private Color borderColor = Color.WHITE;
	private Color fill = Color.WHITE;
	private Stroke stroke = new BasicStroke(1);
	private double progress;
	private Point position;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		//Construct the arc
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setAngleStart(90);
		arc.setAngleExtent(progress * 360);
		arc.setFrame(position.getX() - diameter / 2, position.getY() - diameter / 2, diameter, diameter);

		//Draw the inside of the arc
		graphics.setColor(fill);
		graphics.fill(arc);

		//Draw the outlines of the arc
		graphics.setStroke(stroke);
		graphics.setColor(borderColor);
		graphics.drawOval(position.getX() - diameter / 2, position.getY() - diameter / 2, diameter, diameter);

		return new Dimension(diameter, diameter);
	}

	public void setBorder(Color border, int size)
	{
		this.borderColor = border;
		stroke = new BasicStroke(size);
	}
}
