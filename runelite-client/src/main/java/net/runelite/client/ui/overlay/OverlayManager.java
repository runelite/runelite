/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ProfileChanged;

/**
 * Manages state of all game overlays
 */
@Singleton
@Slf4j
public class OverlayManager
{
	public static final String OPTION_CONFIGURE = "Configure";

	private static final String OVERLAY_CONFIG_PREFERRED_LOCATION = "_preferredLocation";
	private static final String OVERLAY_CONFIG_PREFERRED_POSITION = "_preferredPosition";
	private static final String OVERLAY_CONFIG_ORIGIN = "_origin";
	private static final String OVERLAY_CONFIG_ORIGIN_X = "_originX";
	private static final String OVERLAY_CONFIG_ORIGIN_Y = "_originY";
	private static final String OVERLAY_CONFIG_PREFERRED_SIZE = "_preferredSize";
	private static final String RUNELITE_CONFIG_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();

	static final Comparator<Overlay> OVERLAY_COMPARATOR = (a, b) ->
	{
		final OverlayPosition aPos = MoreObjects.firstNonNull(a.getPreferredPosition(), a.getPosition());
		final OverlayPosition bPos = MoreObjects.firstNonNull(b.getPreferredPosition(), b.getPosition());

		if (aPos != bPos)
		{
			// This is so non-dynamic overlays render after dynamic
			// overlays, which are generally in the scene
			return aPos.compareTo(bPos);
		}

		// For dynamic overlays, higher priority means to
		// draw *later* so it is on top.
		// For non-dynamic overlays, higher priority means
		// draw *earlier* so that they are closer to their
		// defined position.
		return aPos == OverlayPosition.DYNAMIC || aPos == OverlayPosition.DETACHED
			? Float.compare(a.getPriority(), b.getPriority())
			: Float.compare(b.getPriority(), a.getPriority());
	};

	/**
	 * Insertion-order sorted set of overlays
	 * All access to this must be guarded by a lock on this OverlayManager
	 */
	@Getter(AccessLevel.PACKAGE)
	private final List<Overlay> overlays = new ArrayList<>();
	@Getter
	@Setter
	private Collection<WidgetItem> widgetItems = Collections.emptyList();

	/**
	 * Valid keys are:
	 * OverlayLayer ABOVE_SCENE, UNDER_WIDGETS, and ALWAYS_ON_TOP
	 * A component id that is a layer
	 * An interface id << 16 | 0xffff
	 */
	private ArrayListMultimap<Object, Overlay> overlayMap = ArrayListMultimap.create();

	private final ConfigManager configManager;
	private final RuneLiteConfig runeLiteConfig;
	private final Client client;
	private final ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager(
		final ConfigManager configManager,
		final RuneLiteConfig runeLiteConfig,
		final Client client,
		final ChatMessageManager chatMessageManager
	)
	{
		this.configManager = configManager;
		this.runeLiteConfig = runeLiteConfig;
		this.client = client;
		this.chatMessageManager = chatMessageManager;
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		if (!RuneLiteConfig.GROUP_NAME.equals(event.getGroup()) || !"overlayBackgroundColor".equals(event.getKey()))
		{
			return;
		}

		overlays.forEach(this::updateOverlayConfig);
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged event)
	{
		synchronized (this)
		{
			overlays.forEach((o) ->
			{
				loadOverlay(o);
				o.revalidate();
			});
		}
		rebuildOverlayLayers();
	}

	/**
	 * Gets all of the overlays on a layer sorted by priority and position
	 *
	 * @param layer the layer
	 * @return An immutable list of all of the overlays on that layer
	 */
	Collection<Overlay> getLayer(OverlayLayer layer)
	{
		return Collections.unmodifiableCollection(overlayMap.get(layer));
	}

	Collection<Overlay> getForInterface(int interfaceId)
	{
		return Collections.unmodifiableCollection(overlayMap.get(interfaceId << 16 | 0xffff));
	}

	Collection<Overlay> getForLayer(int layerId)
	{
		return Collections.unmodifiableCollection(overlayMap.get(layerId));
	}

	/**
	 * Add overlay.
	 *
	 * @param overlay the overlay
	 * @return true if overlay was added
	 */
	public synchronized boolean add(final Overlay overlay)
	{
		if (overlays.contains(overlay))
		{
			return false;
		}

		// Add is always true
		overlays.add(overlay);
		loadOverlay(overlay);
		updateOverlayConfig(overlay);

		// WidgetItemOverlays have a reference to the overlay manager in order to get the WidgetItems
		// for each frame.
		if (overlay instanceof WidgetItemOverlay)
		{
			((WidgetItemOverlay) overlay).setOverlayManager(this);
		}

		rebuildOverlayLayers();
		return true;
	}

	/**
	 * Remove overlay.
	 *
	 * @param overlay the overlay
	 * @return true if overlay was removed
	 */
	public synchronized boolean remove(final Overlay overlay)
	{
		final boolean remove = overlays.remove(overlay);

		if (remove)
		{
			rebuildOverlayLayers();
		}

		return remove;
	}

	/**
	 * Remove if overlay matches filter
	 *
	 * @param filter the filter
	 * @return true if any overlay was removed
	 */
	public synchronized boolean removeIf(Predicate<Overlay> filter)
	{
		final boolean removeIf = overlays.removeIf(filter);

		if (removeIf)
		{
			rebuildOverlayLayers();
		}

		return removeIf;
	}

	/**
	 * Returns whether an overlay exists which matches the given predicate.
	 *
	 * @param filter Filter predicate function
	 * @return {@code true} if any overlays match the given filter, {@code false} otherwise
	 */
	public synchronized boolean anyMatch(Predicate<Overlay> filter)
	{
		return overlays.stream().anyMatch(filter);
	}

	/**
	 * Clear all overlays
	 */
	public synchronized void clear()
	{
		overlays.clear();
		rebuildOverlayLayers();
	}

	/**
	 * Save overlay data
	 *
	 * @param overlay overlay to save
	 */
	public synchronized void saveOverlay(final Overlay overlay)
	{
		log.debug("Saving overlay {} origin: {} x: {} y: {}", overlay.getName(), overlay.getOrigin(), overlay.getOriginX(), overlay.getOriginY());

		saveOverlayPosition(overlay);
		saveOverlaySize(overlay);
		saveOverlayLocation(overlay);
		rebuildOverlayLayers();
	}

	/**
	 * Resets stored overlay position data
	 *
	 * @param overlay overlay to reset
	 */
	public synchronized void resetOverlay(final Overlay overlay)
	{
		overlay.setPreferredPosition(null);
		overlay.setPreferredSize(null);
		overlay.setPreferredLocation(null);
		overlay.setOrigin(OverlayOrigin.AUTO);
		overlay.setOriginX(OverlayOriginX.LEFT);
		overlay.setOriginY(OverlayOriginY.TOP);
		saveOverlay(overlay);
		overlay.revalidate();
	}

	synchronized void rebuildOverlayLayers()
	{
		ArrayListMultimap<Object, Overlay> overlayMap = ArrayListMultimap.create();
		for (final Overlay overlay : overlays)
		{
			OverlayLayer layer = overlay.getLayer();

			if (overlay.getPreferredLocation() != null && overlay.getPreferredPosition() == null)
			{
				// When UNDER_WIDGET overlays are in preferred locations, move to
				// ABOVE_WIDGETS so that it can draw over interfaces
				if (layer == OverlayLayer.UNDER_WIDGETS && !(overlay instanceof WidgetOverlay))
				{
					layer = OverlayLayer.ABOVE_WIDGETS;
				}
			}

			switch (layer)
			{
				case ABOVE_SCENE:
				case UNDER_WIDGETS:
				case ALWAYS_ON_TOP:
					overlayMap.put(layer, overlay);
					break;
				case ABOVE_WIDGETS:
					// draw after each of the top level interfaces
					overlayMap.put(InterfaceID.TOPLEVEL << 16 | 0xffff, overlay);
					overlayMap.put(InterfaceID.TOPLEVEL_OSRS_STRETCH << 16 | 0xffff, overlay);
					overlayMap.put(InterfaceID.TOPLEVEL_PRE_EOC << 16 | 0xffff, overlay);
					break;
			}

			for (int drawHook : overlay.getDrawHooks())
			{
				overlayMap.put(drawHook, overlay);
			}
		}

		for (Object key : overlayMap.keys())
		{
			overlayMap.get(key).sort(OVERLAY_COMPARATOR);
		}

		this.overlayMap = overlayMap;
	}

	void computeOverlayOrigins(Overlay overlay, int x, int y, int w, int h)
	{
		Dimension canvasDimensions = client.getRealDimensions();

		// rough heuristic to determine overlay origins based on position
		OverlayOriginX originX = OverlayOriginX.LEFT;
		if (x + w / 2 > canvasDimensions.width * .55f)
		{
			originX = OverlayOriginX.RIGHT;
		}
		else if (x + w / 2 >= canvasDimensions.width * .45f)
		{
			originX = OverlayOriginX.CENTER;
		}

		OverlayOriginY originY = OverlayOriginY.TOP;
		if (y + h / 2 > canvasDimensions.height * .55f)
		{
			originY = OverlayOriginY.BOTTOM;
		}
		else if (y + h / 2 > canvasDimensions.height * .45f)
		{
			originY = OverlayOriginY.CENTER;
		}

		overlay.setOriginX(originX);
		overlay.setOriginY(originY);
	}

	private void loadOverlay(final Overlay overlay)
	{
		final Point location = loadOverlayLocation(overlay);
		final Dimension size = loadOverlaySize(overlay);
		final OverlayPosition position = loadOverlayPosition(overlay);

		if (overlay.isMovable())
		{
			OverlayOrigin originMode = loadOverlayOrigin(overlay);
			OverlayOriginX originX = loadOverlayOriginX(overlay);
			OverlayOriginY originY = loadOverlayOriginY(overlay);

			if (location != null && originMode != null && originX != null && originY != null)
			{
				overlay.setOrigin(originMode);
				overlay.setOriginX(originX);
				overlay.setOriginY(originY);
			}
			else
			{
				overlay.setOrigin(OverlayOrigin.AUTO);
				overlay.setOriginX(OverlayOriginX.LEFT);
				overlay.setOriginY(OverlayOriginY.TOP);
			}

			overlay.setPreferredLocation(location);
		}
		else if (location != null)
		{
			log.info("Resetting preferred location of non-movable overlay {} (class {})", overlay.getName(), overlay.getClass().getName());
			overlay.setPreferredLocation(null);
			overlay.setOrigin(OverlayOrigin.AUTO);
			overlay.setOriginX(OverlayOriginX.LEFT);
			overlay.setOriginY(OverlayOriginY.TOP);
			saveOverlayLocation(overlay);
		}

		overlay.setPreferredSize(size);

		if (overlay.isSnappable())
		{
			overlay.setPreferredPosition(position);
		}
		else if (position != null)
		{
			log.info("Resetting preferred position of non-snappable overlay {} (class {})", overlay.getName(), overlay.getClass().getName());
			overlay.setPreferredPosition(null);
			saveOverlayPosition(overlay);
		}
	}

	private void updateOverlayConfig(final Overlay overlay)
	{
		if (overlay instanceof OverlayPanel)
		{
			// Update preferred color for overlay panels based on configuration
			((OverlayPanel) overlay).setPreferredColor(runeLiteConfig.overlayBackgroundColor());
		}
	}

	private void convertOriginToAbsolute(Point p, OverlayOriginX originX, OverlayOriginY originY, Point out)
	{
		Dimension d = client.getRealDimensions();
		int ax = p.x;
		if (originX == OverlayOriginX.RIGHT)
		{
			ax = d.width + p.x;
		}
		else if (originX == OverlayOriginX.CENTER)
		{
			ax = d.width / 2 + p.x;
		}

		int ay = p.y;
		if (originY == OverlayOriginY.BOTTOM)
		{
			ay = d.height + p.y;
		}
		else if (originY == OverlayOriginY.CENTER)
		{
			ay = d.height / 2 + p.y;
		}

		out.setLocation(ax, ay);
	}

	void computeAbsolutePosition(Overlay overlay, Point out)
	{
		OverlayOrigin origin = overlay.getOrigin();
		if (origin != OverlayOrigin.AUTO && origin != OverlayOrigin.MANUAL)
		{
			Widget w = origin.getWidget(client);
			int wx, wy;
			if (w != null)
			{
				var wp = w.getCanvasLocation();
				wx = wp.getX();
				wy = wp.getY();
				origin.coord.setLocation(wx, wy);
			}
			else
			{
				wx = origin.coord.x;
				wy = origin.coord.y;
			}

			var op = overlay.getPreferredLocation();
			out.setLocation(wx + op.x, wy + op.y);
		}
		else
		{
			convertOriginToAbsolute(overlay.getPreferredLocation(), overlay.getOriginX(), overlay.getOriginY(), out);
		}
	}

	private Point convertAbsoluteToOrigin(Point p, OverlayOriginX originX, OverlayOriginY originY)
	{
		Dimension d = client.getRealDimensions();
		int ox = p.x;
		if (originX == OverlayOriginX.RIGHT)
		{
			ox = p.x - d.width;
		}
		else if (originX == OverlayOriginX.CENTER)
		{
			ox = p.x - d.width / 2;
		}

		int oy = p.y;
		if (originY == OverlayOriginY.BOTTOM)
		{
			oy = p.y - d.height;
		}
		else if (originY == OverlayOriginY.CENTER)
		{
			oy = p.y - d.height / 2;
		}

		return new Point(ox, oy);
	}

	Point computeOriginPosition(Point absPosition, OverlayOrigin origin, OverlayOriginX originX, OverlayOriginY originY)
	{
		if (origin != OverlayOrigin.AUTO && origin != OverlayOrigin.MANUAL)
		{
			Widget w = origin.getWidget(client);
			int wx, wy;
			if (w != null)
			{
				var wp = w.getCanvasLocation();
				wx = wp.getX();
				wy = wp.getY();
			}
			else
			{
				wx = origin.coord.x;
				wy = origin.coord.y;
			}
			return new Point(absPosition.x - wx, absPosition.y - wy);
		}
		else
		{
			return convertAbsoluteToOrigin(absPosition, originX, originY);
		}
	}

	private void saveOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		if (overlay.getPreferredLocation() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredLocation());
			configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME,
				overlay.getName() + OVERLAY_CONFIG_ORIGIN,
				overlay.getOrigin());
			configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME,
				overlay.getName() + OVERLAY_CONFIG_ORIGIN_X,
				overlay.getOriginX());
			configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME,
				overlay.getName() + OVERLAY_CONFIG_ORIGIN_Y,
				overlay.getOriginY());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
			configManager.unsetConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN);
			configManager.unsetConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN_X);
			configManager.unsetConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN_Y);
		}
	}

	private void saveOverlaySize(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		if (overlay.getPreferredSize() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredSize());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
		}
	}

	private void saveOverlayPosition(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		if (overlay.getPreferredPosition() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredPosition());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
		}
	}

	private Point loadOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, Point.class);
	}

	private Dimension loadOverlaySize(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, Dimension.class);
	}

	private OverlayPosition loadOverlayPosition(final Overlay overlay)
	{
		final String locationKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, locationKey, OverlayPosition.class);
	}

	private OverlayOrigin loadOverlayOrigin(final Overlay overlay)
	{
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN, OverlayOrigin.class);
	}

	private OverlayOriginX loadOverlayOriginX(final Overlay overlay)
	{
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN_X, OverlayOriginX.class);
	}

	private OverlayOriginY loadOverlayOriginY(final Overlay overlay)
	{
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, overlay.getName() + OVERLAY_CONFIG_ORIGIN_Y, OverlayOriginY.class);
	}

	void addOriginMenu(Overlay overlay)
	{
		Menu menu = client.getMenu();
		Menu sub = menu.createMenuEntry(1)
			.setType(MenuAction.RUNELITE_OVERLAY)
			.setOption("Overlay Origin")
			.createSubMenu();
		String[] opts = {"Top left", "Top center", "Top right", "Bottom left", "Bottom center", "Bottom right"};
		OverlayOriginX[] originX = {
			OverlayOriginX.LEFT, OverlayOriginX.CENTER, OverlayOriginX.RIGHT,
			OverlayOriginX.LEFT, OverlayOriginX.CENTER, OverlayOriginX.RIGHT
		};
		OverlayOriginY[] originY = {
			OverlayOriginY.TOP, OverlayOriginY.TOP, OverlayOriginY.TOP,
			OverlayOriginY.BOTTOM, OverlayOriginY.BOTTOM, OverlayOriginY.BOTTOM
		};
		int off = 0;
		for (int i = 0; i < opts.length; ++i)
		{
			OverlayOriginX ox = originX[i];
			OverlayOriginY oy = originY[i];
			sub.createMenuEntry(-1 - off++)
				.setType(MenuAction.RUNELITE_OVERLAY)
				.setOption(opts[i])
				.onClick(e ->
				{
					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage("This overlay will now be automatically repositioned relative to the " +
							oy.name().toLowerCase() + " " + ox.name().toLowerCase() + " of the screen when the client is resized.")
						.build());

					Point p = overlay.getBounds().getLocation();
					p = computeOriginPosition(p, OverlayOrigin.MANUAL, ox, oy);
					overlay.setPreferredLocation(p);
					overlay.setPreferredPosition(null);

					overlay.setOrigin(OverlayOrigin.MANUAL);
					overlay.setOriginX(ox);
					overlay.setOriginY(oy);
					saveOverlay(overlay);
				});
		}
		opts = new String[]{"Sidepanel", "Chatbox", "Minimap"};
		OverlayOrigin[] origins = {OverlayOrigin.SIDEPANEL, OverlayOrigin.CHATBOX, OverlayOrigin.MINIMAP};
		for (int i = 0; i < opts.length; ++i)
		{
			OverlayOrigin origin = origins[i];
			sub.createMenuEntry(-1 - off++)
				.setType(MenuAction.RUNELITE_OVERLAY)
				.setOption(opts[i])
				.onClick(e ->
				{
					if (cycleCheck(overlay, origin))
					{
						chatMessageManager.queue(QueuedMessage.builder()
							.type(ChatMessageType.CONSOLE)
							.runeLiteFormattedMessage("The origin of " + origin.name().toLowerCase() + " is already linked to this overlay, either directly, or indirectly through multiple other overlays. " +
								"Introducing a circular dependency is not permitted.")
							.build());
						return;
					}

					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage("This overlay will now be automatically repositioned relative to the " +
							origin.name().toLowerCase() + ".")
						.build());

					Point p = overlay.getBounds().getLocation();
					p = computeOriginPosition(p, origin, null, null);
					overlay.setPreferredLocation(p);
					overlay.setPreferredPosition(null);

					overlay.setOrigin(origin);
					saveOverlay(overlay);
				});
		}
	}

	private synchronized boolean cycleCheck(Overlay curOverlay, OverlayOrigin newOrigin)
	{
		MutableGraph<Widget> g = GraphBuilder
			.directed()
			.allowsSelfLoops(true)
			.build();
		for (Overlay overlay : overlays)
		{
			if (overlay instanceof WidgetOverlay)
			{
				OverlayOrigin origin = overlay == curOverlay ? newOrigin : overlay.getOrigin();
				Widget overlayWidget = client.getWidget(((WidgetOverlay) overlay).componentId);
				Widget originWidget = origin.getWidget(client);
				if (overlayWidget != null && originWidget != null)
				{
					g.putEdge(overlayWidget, originWidget);
				}
			}
		}
		return Graphs.hasCycle(g);
	}

}