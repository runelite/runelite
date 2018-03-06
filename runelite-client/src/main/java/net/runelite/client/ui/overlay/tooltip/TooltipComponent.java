/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
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
package net.runelite.client.ui.overlay.tooltip;

import net.runelite.api.Client;
import net.runelite.api.IndexedSprite;
import net.runelite.client.ui.overlay.RenderableEntity;

import java.awt.Point;

/**
 * An extension of RenderableEntity that adds some
 * useful methods for tooltips.
 */
public interface TooltipComponent extends RenderableEntity
{
	/**
	 * Sets the mod icons such that the tooltip may use them.
	 *
	 * @param modIcons An array of mod icons.
	 * @see Client#getModIcons() Gets the list of mod icons from the client.
	 */
	void setModIcons(IndexedSprite[] modIcons);

	/**
	 * Sets the position of the RenderableEntity to the given Point.
	 *
	 * @param position The desired position.
	 */
	void setPosition(Point position);

	/**
	 * Sets whether the component should anchor itself to the
	 * top left (default) or bottom right (tooltip).
	 *
	 * @param value True for bottom right.
	 */
	void setAnchorBottomRight(boolean value);
}
