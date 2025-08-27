/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.callback;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.Player;
import net.runelite.api.Renderable;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.FakeXpDrop;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.api.worldmap.WorldMapRenderer;
import net.runelite.client.Notifier;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.TelemetryClient;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.DeferredEventBus;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.RSTimeUnit;

/**
 * This class contains field required for mixins and runelite hooks to work.
 * All remaining method hooks in this class are performance-critical or contain client-specific logic and so they
 * can't just be placed in mixins or sent through event bus.
 */
@Singleton
@Slf4j
public class Hooks implements Callbacks
{
	private static final long CHECK = RSTimeUnit.GAME_TICKS.getDuration().toNanos(); // ns - how often to run checks

	private static final GameTick GAME_TICK = new GameTick();
	private static final BeforeRender BEFORE_RENDER = new BeforeRender();

	private final Client client;
	private final OverlayRenderer renderer;
	private final EventBus eventBus;
	private final DeferredEventBus deferredEventBus;
	private final Scheduler scheduler;
	private final InfoBoxManager infoBoxManager;
	private final ChatMessageManager chatMessageManager;
	private final MouseManager mouseManager;
	private final KeyManager keyManager;
	private final ClientThread clientThread;
	private final DrawManager drawManager;
	private final Notifier notifier;
	private final ClientUI clientUi;
	@Nullable
	private final TelemetryClient telemetryClient;
	@Nullable
	private final RuntimeConfig runtimeConfig;
	private final boolean developerMode;

	private Dimension lastStretchedDimensions;
	private VolatileImage stretchedImage;
	private Graphics2D stretchedGraphics;

	private long lastCheck;
	private boolean shouldProcessGameTick;

	private static MainBufferProvider lastMainBufferProvider;
	private static Graphics2D lastGraphics;

	private long nextError;
	private boolean rateLimitedError;
	private int errorBackoff = 1;

	@FunctionalInterface
	public interface RenderableDrawListener
	{
		boolean draw(Renderable renderable, boolean ui);
	}

	private final List<RenderableDrawListener> renderableDrawListeners = new ArrayList<>();

	/**
	 * Get the Graphics2D for the MainBufferProvider image
	 * This caches the Graphics2D instance so it can be reused
	 * @param mainBufferProvider
	 * @return
	 */
	private static Graphics2D getGraphics(MainBufferProvider mainBufferProvider)
	{
		if (lastGraphics == null || lastMainBufferProvider != mainBufferProvider)
		{
			if (lastGraphics != null)
			{
				log.debug("Graphics reset!");
				lastGraphics.dispose();
			}

			lastMainBufferProvider = mainBufferProvider;
			lastGraphics = (Graphics2D) mainBufferProvider.getImage().getGraphics();
		}
		return lastGraphics;
	}

	@Inject
	private Hooks(
		Client client,
		OverlayRenderer renderer,
		EventBus eventBus,
		DeferredEventBus deferredEventBus,
		Scheduler scheduler,
		InfoBoxManager infoBoxManager,
		ChatMessageManager chatMessageManager,
		MouseManager mouseManager,
		KeyManager keyManager,
		ClientThread clientThread,
		DrawManager drawManager,
		Notifier notifier,
		ClientUI clientUi,
		@Nullable TelemetryClient telemetryClient,
		@Nullable RuntimeConfig runtimeConfig,
		@Named("developerMode") final boolean developerMode
	)
	{
		this.client = client;
		this.renderer = renderer;
		this.eventBus = eventBus;
		this.deferredEventBus = deferredEventBus;
		this.scheduler = scheduler;
		this.infoBoxManager = infoBoxManager;
		this.chatMessageManager = chatMessageManager;
		this.mouseManager = mouseManager;
		this.keyManager = keyManager;
		this.clientThread = clientThread;
		this.drawManager = drawManager;
		this.notifier = notifier;
		this.clientUi = clientUi;
		this.telemetryClient = telemetryClient;
		this.runtimeConfig = runtimeConfig;
		this.developerMode = developerMode;
		eventBus.register(this);
	}

	@Override
	public void post(Object event)
	{
		eventBus.post(event);
	}

	@Override
	public void postDeferred(Object event)
	{
		deferredEventBus.post(event);
	}

	@Override
	public void tick()
	{
		if (shouldProcessGameTick)
		{
			shouldProcessGameTick = false;

			deferredEventBus.replay();

			eventBus.post(GAME_TICK);

			int tick = client.getTickCount();
			client.setTickCount(tick + 1);
		}

		clientThread.invoke();

		long now = System.nanoTime();

		if (now - lastCheck < CHECK)
		{
			return;
		}

		lastCheck = now;

		try
		{
			// tick pending scheduled tasks
			scheduler.tick();

			// cull infoboxes
			infoBoxManager.cull();

			chatMessageManager.process();

			checkWorldMap();
		}
		catch (Exception ex)
		{
			log.error("error during main loop tasks", ex);
		}
	}

	@Override
	public void tickEnd()
	{
		clientThread.invokeTickEnd();
		eventBus.post(new PostClientTick());
	}

	@Override
	public void frame()
	{
		eventBus.post(BEFORE_RENDER);
	}

	/**
	 * When the world map opens it loads about ~100mb of data into memory, which
	 * represents about half of the total memory allocated by the client.
	 * This gets cached and never released, which causes GC pressure which can affect
	 * performance. This method reinitializes the world map cache, which allows the
	 * data to be garbage collected, and causes the map data from disk each time
	 * is it opened.
	 */
	private void checkWorldMap()
	{
		Widget widget = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);

		if (widget != null)
		{
			return;
		}

		WorldMap worldMap = client.getWorldMap();
		if (worldMap == null)
		{
			return;
		}

		WorldMapRenderer manager = worldMap.getWorldMapRenderer();
		if (manager != null && manager.isLoaded())
		{
			log.debug("World map was closed, reinitializing");
			worldMap.initializeWorldMap(worldMap.getWorldMapData());
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		return mouseManager.processMousePressed(mouseEvent);
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseReleased(mouseEvent);
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseClicked(mouseEvent);
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseEntered(mouseEvent);
	}

	@Override
	public MouseEvent mouseExited(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseExited(mouseEvent);
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseDragged(mouseEvent);
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		return mouseManager.processMouseMoved(mouseEvent);
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		return mouseManager.processMouseWheelMoved(event);
	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		keyManager.processKeyPressed(keyEvent);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		keyManager.processKeyReleased(keyEvent);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent)
	{
		keyManager.processKeyTyped(keyEvent);
	}

	@Override
	public void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y)
	{
		if (graphics == null)
		{
			return;
		}

		final Graphics2D graphics2d = getGraphics(mainBufferProvider);

		try
		{
			renderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP);
		}
		catch (Exception ex)
		{
			log.error("Error during overlay rendering", ex);
		}

		notifier.processFlash(graphics2d);

		// Draw clientUI overlays
		clientUi.paintOverlays(graphics2d);

		if (client.isGpu())
		{
			// processDrawComplete gets called on GPU by the gpu plugin at the end of its
			// drawing cycle, which is later on.
			return;
		}

		// Stretch the game image if the user has that enabled
		Image image = mainBufferProvider.getImage();
		final Image finalImage;
		if (client.isStretchedEnabled())
		{
			GraphicsConfiguration gc = clientUi.getGraphicsConfiguration();
			Dimension stretchedDimensions = client.getStretchedDimensions();

			int status = -1;
			if (!stretchedDimensions.equals(lastStretchedDimensions)
				|| stretchedImage == null
				|| (status = stretchedImage.validate(gc)) != VolatileImage.IMAGE_OK)
			{
				log.debug("Volatile image non-OK status: {}", status);

				// if IMAGE_INCOMPATIBLE the image and g2d need to be rebuilt, otherwise
				// if IMAGE_RESTORED only the g2d needs to be rebuilt

				if (stretchedGraphics != null)
				{
					stretchedGraphics.dispose();
				}

				if (!stretchedDimensions.equals(lastStretchedDimensions)
					|| stretchedImage == null
					|| status == VolatileImage.IMAGE_INCOMPATIBLE)
				{
					if (stretchedImage != null)
					{
						// VolatileImage javadocs says this proactively releases the resources used by the VolatileImage
						stretchedImage.flush();
					}

					stretchedImage = gc.createCompatibleVolatileImage(stretchedDimensions.width, stretchedDimensions.height);
					lastStretchedDimensions = stretchedDimensions;
				}

				stretchedGraphics = (Graphics2D) stretchedImage.getGraphics();
			}

			stretchedGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				client.isStretchedFast()
					? RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
					: RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			stretchedGraphics.drawImage(image, 0, 0, stretchedDimensions.width, stretchedDimensions.height, null);

			finalImage = stretchedImage;
		}
		else
		{
			if (stretchedImage != null)
			{
				log.debug("Releasing stretched volatile image");

				stretchedGraphics.dispose();
				stretchedImage.flush();

				stretchedGraphics = null;
				stretchedImage = null;
				lastStretchedDimensions = null;
			}

			finalImage = image;
		}

		// Draw the image onto the game canvas
		graphics.drawImage(finalImage, 0, 0, client.getCanvas());

		// finalImage is backed by the client buffer which will change soon. make a copy
		// so that callbacks can safely use it later from threads.
		drawManager.processDrawComplete(() -> screenshot(finalImage));
	}

	private Image screenshot(Image src)
	{
		// scale source image to the size of the client ui
		final AffineTransform transform = clientUi.getGraphicsConfiguration().getDefaultTransform();
		int swidth = src.getWidth(null);
		int sheight = src.getHeight(null);
		int twidth = (int) (swidth * transform.getScaleX() + .5);
		int theight = (int) (sheight * transform.getScaleY() + .5);
		BufferedImage image = new BufferedImage(twidth, theight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setTransform(transform);
		graphics.drawImage(src, 0, 0, swidth, sheight, null);
		graphics.dispose();
		return image;
	}

	@Override
	public void drawScene()
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		Graphics2D graphics2d = getGraphics(bufferProvider);

		try
		{
			renderer.renderOverlayLayer(graphics2d, OverlayLayer.ABOVE_SCENE);
		}
		catch (Exception ex)
		{
			log.error("Error during overlay rendering", ex);
		}
	}

	@Override
	public void drawAboveOverheads()
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		Graphics2D graphics2d = getGraphics(bufferProvider);

		try
		{
			renderer.renderOverlayLayer(graphics2d, OverlayLayer.UNDER_WIDGETS);
		}
		catch (Exception ex)
		{
			log.error("Error during overlay rendering", ex);
		}
	}

	@Override
	public void serverTick()
	{
		shouldProcessGameTick = true;
	}

	@Override
	public void drawInterface(int interfaceId, List<WidgetItem> widgetItems)
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		Graphics2D graphics2d = getGraphics(bufferProvider);

		try
		{
			renderer.renderAfterInterface(graphics2d, interfaceId, widgetItems);
		}
		catch (Exception ex)
		{
			log.error("Error during overlay rendering", ex);
		}
	}

	@Override
	public void drawLayer(Widget layer, List<WidgetItem> widgetItems)
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		Graphics2D graphics2d = getGraphics(bufferProvider);

		try
		{
			renderer.renderAfterLayer(graphics2d, layer, widgetItems);
		}
		catch (Exception ex)
		{
			log.error("Error during overlay rendering", ex);
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (!scriptCallbackEvent.getEventName().equals("fakeXpDrop"))
		{
			return;
		}

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();

		final int statId = intStack[intStackSize - 2];
		final int xp = intStack[intStackSize - 1];

		Skill skill = Skill.values()[statId];
		FakeXpDrop fakeXpDrop = new FakeXpDrop(
			skill,
			xp
		);
		eventBus.post(fakeXpDrop);
	}

	public void registerRenderableDrawListener(RenderableDrawListener listener)
	{
		renderableDrawListeners.add(listener);
	}

	public void unregisterRenderableDrawListener(RenderableDrawListener listener)
	{
		renderableDrawListeners.remove(listener);
	}

	@Override
	public boolean draw(Renderable renderable, boolean drawingUi)
	{
		try
		{
			for (RenderableDrawListener renderableDrawListener : renderableDrawListeners)
			{
				if (!renderableDrawListener.draw(renderable, drawingUi))
				{
					return false;
				}
			}
		}
		catch (Exception ex)
		{
			log.error("exception from renderable draw listener", ex);
		}
		return true;
	}

	@Override
	public void error(String message, Throwable reason)
	{
		if (telemetryClient == null)
		{
			return;
		}

		long now = System.currentTimeMillis();
		if (now > nextError)
		{
			var sw = new StringWriter();
			sw.append(message);

			if (reason != null)
			{
				sw.append(" - ").append(reason.toString()).append('\n');
				try (var pw = new PrintWriter(sw))
				{
					reason.printStackTrace(pw);
				}
			}

			String coord = "unk";
			if (client.getClientThread() == Thread.currentThread())
			{
				Player player = client.getLocalPlayer();
				if (player != null)
				{
					WorldPoint p = WorldPoint.fromLocalInstance(client, player.getLocalLocation());
					coord = String.format("%d_%d_%d_%d_%d", p.getPlane(), p.getX() / 64, p.getY() / 64, p.getX() & 63, p.getY() & 63);
				}
			}

			telemetryClient.submitError(
				"client error",
				sw.toString(),
				Collections.singletonMap("coord", coord));

			if (rateLimitedError)
			{
				errorBackoff++;
				rateLimitedError = false;
			}
			else
			{
				errorBackoff = 1;
			}

			nextError = now + (10_000L * errorBackoff);
		}
		else
		{
			rateLimitedError = true;
		}
	}

	@Override
	public void openUrl(String url)
	{
		LinkBrowser.browse(url);
	}

	@Override
	public boolean isRuneLiteClientOutdated()
	{
		if (runtimeConfig == null || developerMode)
		{
			return false;
		}

		Set<String> outdatedClientVersions = runtimeConfig.getOutdatedClientVersions();
		if (outdatedClientVersions == null)
		{
			return false;
		}

		return outdatedClientVersions.contains(RuneLiteProperties.getVersion());
	}
}
