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

import com.google.common.base.MoreObjects;
import com.google.common.eventbus.Subscribe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltip.TooltipOverlay;

@Singleton
@Slf4j
public class OverlayRenderer
{
	private static final int BORDER_LEFT_RESIZABLE = 5;
	private static final int BORDER_TOP_RESIZABLE = 20;
	private static final int FRAME_OFFSET = 4;
	private static final int BORDER_LEFT_FIXED = BORDER_LEFT_RESIZABLE + FRAME_OFFSET;
	private static final int BORDER_TOP_FIXED = BORDER_TOP_RESIZABLE + FRAME_OFFSET;
	private static final int BORDER_RIGHT = 2;
	private static final int BORDER_BOTTOM = 2;
	private static final int PADDING = 2;

	@Inject
	PluginManager pluginManager;

	@Inject
	Provider<Client> clientProvider;

	@Inject
	InfoBoxOverlay infoBoxOverlay;

	@Inject
	TooltipOverlay tooltipOverlay;

	private final List<Overlay> overlays = new CopyOnWriteArrayList<>();
	private BufferedImage surface;
	private Graphics2D surfaceGraphics;

	private ConcurrentLinkedQueue<Consumer<BufferedImage>> screenshotRequests = new ConcurrentLinkedQueue<>();

	@Subscribe
	public void onResizableChanged(ResizeableChanged event)
	{
		updateSurface();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		final Client client = clientProvider.get();

		if (client == null)
		{
			return;
		}

		if (event.getGameState().equals(GameState.LOGIN_SCREEN) || event.getGameState().equals(GameState.LOGGED_IN))
		{
			refreshPlugins();
			updateSurface();
		}
	}

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		refreshPlugins();
	}

	private void refreshPlugins()
	{
		overlays.clear();
		overlays.addAll(Stream
			.concat(
				pluginManager.getPlugins()
					.stream()
					.filter(plugin -> pluginManager.isPluginEnabled(plugin))
					.flatMap(plugin -> plugin.getOverlays().stream()),
				Stream.of(infoBoxOverlay, tooltipOverlay))
			.filter(Objects::nonNull)
			.collect(Collectors.toList()));
		sortOverlays(overlays);
	}

	static void sortOverlays(List<Overlay> overlays)
	{
		overlays.sort((a, b) ->
		{
			if (a.getPosition() != b.getPosition())
			{
				// This is so non-dynamic overlays render after dynamic
				// overlays, which are generally in the scene
				return a.getPosition().compareTo(b.getPosition());
			}

			// For dynamic overlays, higher priority means to
			// draw *later* so it is on top.
			// For non-dynamic overlays, higher priority means
			// draw *first* so that they are closer to their
			// defined position.
			return a.getPosition() == OverlayPosition.DYNAMIC
				? a.getPriority().compareTo(b.getPriority())
				: b.getPriority().compareTo(a.getPriority());
		});
	}

	private void updateSurface()
	{
		final Client client = clientProvider.get();

		if (client == null)
		{
			return;
		}

		final Dimension size = client.getCanvas().getSize();
		final BufferedImage temp = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D subGraphics = temp.createGraphics();
		subGraphics.setBackground(new Color(0, 0, 0, 0));
		OverlayUtil.setGraphicProperties(subGraphics);

		surface = temp;

		if (surfaceGraphics != null)
		{
			surfaceGraphics.dispose();
		}

		surfaceGraphics = subGraphics;
	}

	public void render(Graphics2D graphics, OverlayLayer layer)
	{
		final Client client = clientProvider.get();

		if (client == null || surface == null || overlays.isEmpty())
		{
			return;
		}

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return;
		}

		final boolean isResizeable = client.isResized();
		final Widget viewport = client.getViewportWidget();
		final Rectangle bounds = viewport != null
			? new Rectangle(viewport.getBounds())
			: new Rectangle(0, 0, surface.getWidth(), surface.getHeight());

		final Widget chatbox = client.getWidget(WidgetInfo.CHATBOX_MESSAGES);
		final Rectangle chatboxBounds = chatbox != null
			? chatbox.getBounds() : new Rectangle(0, bounds.height, 519, 165);

		OverlayUtil.setGraphicProperties(graphics);
		final Point topLeftPoint = new Point();
		topLeftPoint.move(
			isResizeable ? BORDER_LEFT_RESIZABLE : BORDER_LEFT_FIXED,
			isResizeable ? BORDER_TOP_RESIZABLE : BORDER_TOP_FIXED);
		final Point topRightPoint = new Point();
		topRightPoint.move(bounds.x + bounds.width - BORDER_RIGHT, BORDER_TOP_FIXED);
		final Point bottomLeftPoint = new Point();
		bottomLeftPoint.move(isResizeable ? BORDER_LEFT_RESIZABLE : BORDER_LEFT_FIXED, bounds.y + bounds.height - BORDER_BOTTOM);
		final Point bottomRightPoint = new Point();
		bottomRightPoint.move(bounds.x + bounds.width - BORDER_RIGHT, bounds.y + bounds.height - BORDER_BOTTOM);
		final Point rightChatboxPoint = new Point();
		rightChatboxPoint.move(bounds.x + chatboxBounds.width - BORDER_RIGHT, bounds.y + bounds.height - BORDER_BOTTOM);

		//check to see if Chatbox is minimized
		if (chatbox != null && isResizeable && chatbox.isHidden())
		{
			rightChatboxPoint.y += chatboxBounds.height;
			bottomLeftPoint.y += chatboxBounds.height;
		}

		for (Overlay overlay : overlays)
		{
			if (overlay.getLayer() != layer)
			{
				continue;
			}

			OverlayPosition overlayPosition = overlay.getPosition();
			if (overlayPosition == OverlayPosition.ABOVE_CHATBOX_RIGHT && !client.isResized())
			{
				// On fixed mode, ABOVE_CHATBOX_RIGHT is in the same location as
				// BOTTOM_RIGHT. Just use BOTTOM_RIGHT to prevent overlays from
				// drawing over each other.
				overlayPosition = OverlayPosition.BOTTOM_RIGHT;
			}
			final Point subPosition = new Point();
			switch (overlayPosition)
			{
				case BOTTOM_LEFT:
					subPosition.setLocation(bottomLeftPoint);
					break;
				case BOTTOM_RIGHT:
					subPosition.setLocation(bottomRightPoint);
					break;
				case TOP_LEFT:
					subPosition.setLocation(topLeftPoint);
					break;
				case TOP_RIGHT:
					subPosition.setLocation(topRightPoint);
					break;
				case ABOVE_CHATBOX_RIGHT:
					subPosition.setLocation(rightChatboxPoint);
					break;
			}

			if (overlayPosition == OverlayPosition.DYNAMIC || overlayPosition == OverlayPosition.TOOLTIP)
			{
				safeRender(overlay, graphics, new Point());
			}
			else
			{
				final Dimension dimension = MoreObjects.firstNonNull(safeRender(overlay, surfaceGraphics, subPosition), new Dimension());
				if (dimension.width == 0 && dimension.height == 0)
				{
					continue;
				}

				final BufferedImage clippedImage = surface.getSubimage(0, 0, dimension.width, dimension.height);

				switch (overlayPosition)
				{
					case BOTTOM_LEFT:
						bottomLeftPoint.x += dimension.width + (dimension.width == 0 ? 0 : PADDING);
						break;
					case BOTTOM_RIGHT:
						bottomRightPoint.x -= dimension.width + (dimension.width == 0 ? 0 : PADDING);
						break;
					case TOP_LEFT:
						topLeftPoint.y += dimension.height + (dimension.height == 0 ? 0 : PADDING);
						break;
					case TOP_RIGHT:
						topRightPoint.y += dimension.height + (dimension.height == 0 ? 0 : PADDING);
						break;
					case ABOVE_CHATBOX_RIGHT:
						rightChatboxPoint.y -= dimension.height + (dimension.height == 0 ? 0 : PADDING);
						break;
				}

				final Point transformed = OverlayUtil.transformPosition(overlayPosition, dimension);
				graphics.drawImage(clippedImage, subPosition.x + transformed.x, subPosition.y + transformed.y, null);
				surfaceGraphics.clearRect(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());
			}
		}
	}

	private Dimension safeRender(RenderableEntity entity, Graphics2D graphics, Point point)
	{
		final Graphics2D subGraphics = (Graphics2D) graphics.create();
		final Dimension dimension = entity.render(subGraphics, point);
		subGraphics.dispose();
		return dimension;
	}

	public void provideScreenshot(BufferedImage image)
	{
		Consumer<BufferedImage> consumer;
		while ((consumer = screenshotRequests.poll()) != null)
		{
			try
			{
				consumer.accept(image);
			}
			catch (Exception ex)
			{
				log.warn("error in screenshot callback", ex);
			}
		}
	}

	public void requestScreenshot(Consumer<BufferedImage> consumer)
	{
		screenshotRequests.add(consumer);
	}
}
