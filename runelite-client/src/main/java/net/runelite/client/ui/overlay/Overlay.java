/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

@Getter
@Setter
public abstract class Overlay implements LayoutableRenderableEntity
{
	@Nullable
	private final Plugin plugin;
	private Point preferredLocation;
	private Dimension preferredSize;
	private OverlayPosition preferredPosition;
	private Rectangle bounds = new Rectangle();
	private OverlayPosition position = OverlayPosition.TOP_LEFT;
	private OverlayPriority priority = OverlayPriority.NONE;
	private OverlayLayer layer = OverlayLayer.UNDER_WIDGETS;
	private final List<Integer> drawHooks = new ArrayList<>();
	private final List<OverlayMenuEntry> menuEntries = new ArrayList<>();
	private boolean resizable;
	private int minimumSize = 32;
	private boolean resettable = true;

	/**
	 * Whether this overlay can be dragged onto other overlays &amp; have
	 * other overlays dragged onto it.
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean dragTargetable;

	protected Overlay()
	{
		plugin = null;
	}

	protected Overlay(Plugin plugin)
	{
		this.plugin = plugin;
	}

	/**
	 * Overlay name, used for saving the overlay, needs to be unique
	 *
	 * @return overlay name
	 */
	public String getName()
	{
		return this.getClass().getSimpleName();
	}

	protected void drawAfterInterface(int interfaceId)
	{
		drawHooks.add(interfaceId << 16 | 0xffff);
	}

	protected void drawAfterLayer(WidgetInfo layer)
	{
		drawHooks.add(layer.getId());
	}

	public void onMouseOver()
	{
	}

	/**
	 * Called when an overlay is dragged onto this, if dragTargetable is true.
	 * Return true to consume the mouse event and prevent the other
	 * overlay from being moved
	 *
	 * @param other the overlay being dragged
	 * @return
	 */
	public boolean onDrag(Overlay other)
	{
		return false;
	}

	/**
	 * Get the parent bounds for overlay dragging. The overlay will
	 * not be allowed to be moved outside of the parent bounds.
	 * @return
	 */
	@Nullable
	public Rectangle getParentBounds()
	{
		return null;
	}
}
