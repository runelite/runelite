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
import net.runelite.api.annotations.Component;
import net.runelite.api.annotations.Interface;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

@Getter
@Setter
public abstract class Overlay implements LayoutableRenderableEntity
{
	public static final float PRIORITY_LOW = 0f;
	public static final float PRIORITY_DEFAULT = 0.25f;
	public static final float PRIORITY_MED = 0.5f;
	public static final float PRIORITY_HIGH = 0.75f;
	public static final float PRIORITY_HIGHEST = 1f;

	@Nullable
	private final Plugin plugin;
	private Point preferredLocation;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private OverlayOrigin origin = OverlayOrigin.AUTO;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private OverlayOriginX originX = OverlayOriginX.LEFT;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private OverlayOriginY originY = OverlayOriginY.TOP;
	private Dimension preferredSize;
	private OverlayPosition preferredPosition;
	private Rectangle bounds = new Rectangle();
	private OverlayPosition position = OverlayPosition.TOP_LEFT;
	/**
	 * The overlay priority, which determines the order the overlay renders in relative
	 * to other overlays.
	 */
	private float priority = PRIORITY_DEFAULT;
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

	/**
	 * When stretched mode is on, whether this overlay draws into the native
	 * (display-resolution) buffer. Builtin overlays default to true. Hub and
	 * sideloaded plugin overlays default to false and must opt in.
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean preferNativeResolution = true;

	/**
	 * DYNAMIC overlays that should follow Fixed overlay size / aspect ratio like infoboxes
	 * (e.g. FPS and ping counters), instead of world-overlay scaling. Applies the panel content
	 * scale to the whole Graphics2D, so positions are in content space.
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean preferPanelContentScale;

	/**
	 * World-anchored DYNAMIC overlays whose glyphs and images should follow Fixed overlay size /
	 * aspect ratio (e.g. player names, ground item text) without moving canvas positions. Text is
	 * scaled locally around each draw; polygons stay at full stretch.
	 */
	@Setter(AccessLevel.PROTECTED)
	private boolean preferPanelGlyphScale;

	protected Overlay()
	{
		plugin = null;
	}

	protected Overlay(@Nullable Plugin plugin)
	{
		this.plugin = plugin;
		if (plugin != null && !isBuiltinPlugin(plugin))
		{
			preferNativeResolution = false;
		}
	}

	/**
	 * Builtin plugins share the client classloader; hub/sideload plugins use a separate loader.
	 */
	private static boolean isBuiltinPlugin(Plugin plugin)
	{
		return plugin.getClass().getClassLoader() == Plugin.class.getClassLoader();
	}

	public void setPriority(float priority)
	{
		this.priority = priority;
	}

	public void setPriority(OverlayPriority overlayPriority)
	{
		switch (overlayPriority)
		{
			case LOW:
				priority = PRIORITY_LOW;
				break;
			case NONE:
				priority = PRIORITY_DEFAULT;
				break;
			case MED:
				priority = PRIORITY_MED;
				break;
			case HIGH:
				priority = PRIORITY_HIGH;
				break;
			case HIGHEST:
				priority = PRIORITY_HIGHEST;
				break;
		}
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
	protected void drawAfterInterface(@Interface int interfaceId)
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
	@Deprecated
	protected void drawAfterLayer(WidgetInfo layer)
	{
		drawHooks.add(layer.getId());
	}

	/**
	 * Configure to draw this overlay after the given layer is drawn. Except
	 * in rare circumstances, you probably also want to {@link #setLayer(OverlayLayer)} to
	 * {@link OverlayLayer#MANUAL} to avoid the overlay being drawn a 2nd time during the
	 * default {@link OverlayLayer#UNDER_WIDGETS} pass.
	 *
	 * The layer must be a widget of {@link net.runelite.api.widgets.WidgetType} {@link net.runelite.api.widgets.WidgetType#LAYER}
	 * @param component The layer
	 * @see WidgetInfo
	 */
	protected void drawAfterLayer(@Component int component)
	{
		drawHooks.add(component);
	}

	void onDrag()
	{
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

	void reset()
	{
		setPreferredPosition(null);
		setPreferredSize(null);
		setPreferredLocation(null);
		setOrigin(OverlayOrigin.AUTO);
		setOriginX(OverlayOriginX.LEFT);
		setOriginY(OverlayOriginY.TOP);
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
