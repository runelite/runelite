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

import com.google.common.base.Preconditions;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
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

	/**
	 * Whether this overlay can be moved with alt
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean movable = true;

	/**
	 * Whether this overlay can be moved to a snap corner
	 * and have its preferredPosition changed
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean snappable = true;

	protected Overlay()
	{
		plugin = null;
	}

	protected Overlay(@Nullable Plugin plugin)
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

	/**
	 * Configure to draw this overlay after the given interface is drawn. Except
	 * in rare circumstances, you probably also want to {@link #setLayer(OverlayLayer)} to
	 * {@link OverlayLayer#MANUAL} to avoid the overlay being drawn a 2nd time during the
	 * default {@link OverlayLayer#UNDER_WIDGETS} pass.
	 * @param interfaceId The interface id
	 * @see net.runelite.api.widgets.WidgetID
	 */
	protected void drawAfterInterface(int interfaceId)
	{
		drawHooks.add(interfaceId << 16 | 0xffff);
	}

	/**
	 * Configure to draw this overlay after the given layer is drawn. Except
	 * in rare circumstances, you probably also want to {@link #setLayer(OverlayLayer)} to
	 * {@link OverlayLayer#MANUAL} to avoid the overlay being drawn a 2nd time during the
	 * default {@link OverlayLayer#UNDER_WIDGETS} pass.
	 *
	 * The layer must be a widget of {@link net.runelite.api.widgets.WidgetType} {@link net.runelite.api.widgets.WidgetType#LAYER}
	 * @param groupId The widget group id
	 * @param childId The widget child id
	 * @see net.runelite.api.widgets.WidgetID
	 */
	protected void drawAfterLayer(int groupId, int childId)
	{
		Preconditions.checkArgument(groupId >= 0 && groupId <= 0xffff, "groupId outside of valid range");
		Preconditions.checkArgument(childId >= 0 && childId <= 0xffff, "childId outside of valid range");
		drawHooks.add(groupId << 16 | childId);
	}

	/**
	 * Configure to draw this overlay after the given layer is drawn. Except
	 * in rare circumstances, you probably also want to {@link #setLayer(OverlayLayer)} to
	 * {@link OverlayLayer#MANUAL} to avoid the overlay being drawn a 2nd time during the
	 * default {@link OverlayLayer#UNDER_WIDGETS} pass.
	 *
	 * The layer must be a widget of {@link net.runelite.api.widgets.WidgetType} {@link net.runelite.api.widgets.WidgetType#LAYER}
	 * @param layer The layer
	 * @see WidgetInfo
	 */
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

	public void revalidate()
	{
	}

	public void setPosition(OverlayPosition position)
	{
		this.position = position;

		switch (position)
		{
			case TOOLTIP:
			case DYNAMIC:
				movable = false;
				snappable = false;
				break;
			case DETACHED:
				movable = true;
				snappable = false;
				break;
			default:
				movable = true;
				snappable = true;
		}
	}

	public OverlayMenuEntry addMenuEntry(MenuAction action, String option, String target)
	{
		return addMenuEntry(action, option, target, null);
	}

	public OverlayMenuEntry addMenuEntry(MenuAction action, String option, String target, Consumer<MenuEntry> callback)
	{
		OverlayMenuEntry menuEntry = new OverlayMenuEntry(action, option, target);
		menuEntry.callback = callback;
		menuEntries.add(menuEntry);
		return menuEntry;
	}

	public void removeMenuEntry(MenuAction action, String option, String target)
	{
		menuEntries.remove(new OverlayMenuEntry(action, option, target));
	}
}
