/*
 * Copyright (c) 2025, Car_role
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
package net.runelite.client.ui.overlay;

import java.awt.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a custom UI anchor on the game canvas.
 * Overlays can be assigned to anchors for custom positioning and layout.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverlayAnchor
{
	private int id;
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private OverlayAnchorConstraint constraint = OverlayAnchorConstraint.TOP_LEFT;
	private OverlayAnchorAlignment alignment = OverlayAnchorAlignment.CENTER;
	private OverlayAnchorStacking stacking = OverlayAnchorStacking.VERTICAL;

	public OverlayAnchor(int id, String name, int x, int y, int width, int height)
	{
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.constraint = OverlayAnchorConstraint.TOP_LEFT;
		this.alignment = OverlayAnchorAlignment.CENTER;
		this.stacking = OverlayAnchorStacking.VERTICAL;
	}

	/**
	 * Get the bounds of this anchor as an AWT Rectangle.
	 * @return the bounds rectangle
	 */
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, width, height);
	}
}
