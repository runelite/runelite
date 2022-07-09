/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, Wynadorn <https://github.com/Wynadorn>
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
package net.runelite.client.plugins.camera;

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.SettingID;
import net.runelite.api.VarClientInt;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@PluginDescriptor(
	name = "Camera",
	description = "Expands zoom limit, provides vertical camera, and remaps mouse input keys",
	tags = {"zoom", "limit", "vertical", "click", "mouse"},
	enabledByDefault = false
)
public class CameraPlugin extends Plugin implements KeyListener, MouseListener
{
	private static final int DEFAULT_ZOOM_INCREMENT = 25;
	private static final int DEFAULT_OUTER_ZOOM_LIMIT = 128;
	static final int DEFAULT_INNER_ZOOM_LIMIT = 896;

	private EventQueue eventQueue;
	private boolean controlDown;
	// flags used to store the mousedown states
	private boolean extraMiddleClickDispatched;
	private boolean middleClickMutatedToRightClick;
	private MouseEvent latestRightClick;
	private int savedCameraYaw;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private CameraConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private TooltipManager tooltipManager;

	private Tooltip sliderTooltip;

	@Provides
	CameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CameraConfig.class);
	}

	@Override
	protected void startUp()
	{
		extraMiddleClickDispatched = false;
		middleClickMutatedToRightClick = false;
		eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		copyConfigs();
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
		clientThread.invoke(() ->
		{
			Widget sideSlider = client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK);
			if (sideSlider != null)
			{
				addZoomTooltip(sideSlider);
			}

			Widget settingsInit = client.getWidget(WidgetInfo.SETTINGS_INIT);
			if (settingsInit != null)
			{
				client.createScriptEvent(settingsInit.getOnLoadListener())
					.setSource(settingsInit)
					.run();
			}
		});
	}

	@Override
	protected void shutDown()
	{
		client.setCameraPitchRelaxerEnabled(false);
		client.setInvertYaw(false);
		client.setInvertPitch(false);
		keyManager.unregisterKeyListener(this);
		mouseManager.unregisterMouseListener(this);
		controlDown = false;

		clientThread.invoke(() ->
		{
			Widget sideSlider = client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK);
			if (sideSlider != null)
			{
				sideSlider.setOnMouseRepeatListener((Object[]) null);
			}

			Widget settingsInit = client.getWidget(WidgetInfo.SETTINGS_INIT);
			if (settingsInit != null)
			{
				client.createScriptEvent(settingsInit.getOnLoadListener())
					.setSource(settingsInit)
					.run();
			}
		});
	}

	void copyConfigs()
	{
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());
		client.setInvertYaw(config.invertYaw());
		client.setInvertPitch(config.invertPitch());
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (client.getIndexScripts().isOverlayOutdated())
		{
			// if any cache overlay fails to load then assume at least one of the zoom scripts is outdated
			// and prevent zoom extending entirely.
			return;
		}

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		if (!controlDown && "scrollWheelZoom".equals(event.getEventName()) && config.controlFunction() == ControlFunction.CONTROL_TO_ZOOM)
		{
			intStack[intStackSize - 1] = 1;
		}

		if ("innerZoomLimit".equals(event.getEventName()) && config.innerLimit())
		{
			intStack[intStackSize - 1] = CameraConfig.INNER_ZOOM_LIMIT;
			return;
		}

		if ("outerZoomLimit".equals(event.getEventName()))
		{
			int outerLimit = Ints.constrainToRange(config.outerLimit(), CameraConfig.OUTER_LIMIT_MIN, CameraConfig.OUTER_LIMIT_MAX);
			int outerZoomLimit = DEFAULT_OUTER_ZOOM_LIMIT - outerLimit;
			intStack[intStackSize - 1] = outerZoomLimit;
			return;
		}

		if ("scrollWheelZoomIncrement".equals(event.getEventName()) && config.zoomIncrement() != DEFAULT_ZOOM_INCREMENT)
		{
			intStack[intStackSize - 1] = config.zoomIncrement();
			return;
		}

		if ("lookPreservePitch".equals(event.getEventName()) && config.compassLookPreservePitch())
		{
			intStack[intStackSize - 1] = client.getCameraPitch();
			return;
		}

		if (config.innerLimit())
		{
			// This lets the options panel's slider have an exponential rate
			final double exponent = 2.d;
			switch (event.getEventName())
			{
				case "zoomLinToExp":
				{
					double range = intStack[intStackSize - 1];
					double value = intStack[intStackSize - 2];
					value = Math.pow(value / range, exponent) * range;
					intStack[intStackSize - 2] = (int) value;
					break;
				}
				case "zoomExpToLin":
				{
					double range = intStack[intStackSize - 1];
					double value = intStack[intStackSize - 2];
					value = Math.pow(value / range, 1.d / exponent) * range;
					intStack[intStackSize - 2] = (int) value;
					break;
				}
			}
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			controlDown = false;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged ev)
	{
		copyConfigs();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			controlDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			controlDown = false;

			if (config.controlFunction() == ControlFunction.CONTROL_TO_RESET)
			{
				final int zoomValue = Ints.constrainToRange(config.ctrlZoomValue(), CameraConfig.OUTER_LIMIT_MIN, CameraConfig.INNER_ZOOM_LIMIT);
				clientThread.invokeLater(() -> client.runScript(ScriptID.CAMERA_DO_ZOOM, zoomValue, zoomValue));
			}
		}
	}

	/**
	 * Checks if the menu has any options, because menu entries are built each
	 * tick and the MouseListener runs on the awt thread
	 */
	@Subscribe
	public void onClientTick(ClientTick event)
	{
		sliderTooltip = null;
	}

	@Subscribe
	private void onScriptPreFired(ScriptPreFired ev)
	{
		switch (ev.getScriptId())
		{
			case ScriptID.SETTINGS_SLIDER_CHOOSE_ONOP:
			{
				int arg = client.getIntStackSize() - 7;
				int[] is = client.getIntStack();

				if (is[arg] == SettingID.CAMERA_ZOOM)
				{
					addZoomTooltip(client.getScriptActiveWidget());
				}
				break;
			}
			case ScriptID.ZOOM_SLIDER_ONDRAG:
			case ScriptID.SETTINGS_ZOOM_SLIDER_ONDRAG:
				sliderTooltip = makeSliderTooltip();
				break;
		}
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded ev)
	{
		if (ev.getGroupId() == WidgetID.SETTINGS_SIDE_GROUP_ID)
		{
			addZoomTooltip(client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK));
		}
	}

	private void addZoomTooltip(Widget w)
	{
		w.setOnMouseRepeatListener((JavaScriptCallback) ev -> sliderTooltip = makeSliderTooltip());
	}

	private Tooltip makeSliderTooltip()
	{
		int value = client.getVarcIntValue(VarClientInt.CAMERA_ZOOM_RESIZABLE_VIEWPORT);
		int max = config.innerLimit() ? config.INNER_ZOOM_LIMIT : CameraPlugin.DEFAULT_INNER_ZOOM_LIMIT;
		return new Tooltip("Camera Zoom: " + value + " / " + max);
	}

	@Subscribe
	private void onBeforeRender(BeforeRender ev)
	{
		if (sliderTooltip != null)
		{
			tooltipManager.add(sliderTooltip);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case HOPPING:
				savedCameraYaw = client.getMapAngle();
				break;
			case LOGGED_IN:
				if (savedCameraYaw != 0 && config.preserveYaw())
				{
					client.setCameraYawTarget(savedCameraYaw);
				}
				savedCameraYaw = 0;
				break;
		}
	}

	/**
	 * The event that is triggered when a mouse button is pressed.
	 * If the middleClickMenu config is set, mutates the mouse event to a right click so that the right-click menu
	 * opens. If the mouse event is a right click, it is stored to a variable so that it is accessible on mouseDragged.
	 */
	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		// Mutate a right click event to a middle click event if middleClickMenu config is set.
		// Should be ignored if an extra middle click event has already been dispatched.
		if (SwingUtilities.isMiddleMouseButton((mouseEvent))
				&& config.middleClickMenu()
				&& !extraMiddleClickDispatched)
		{
			middleClickMutatedToRightClick = true;
			mouseEvent = sameMouseEventForDifferentButton(mouseEvent, MouseEvent.BUTTON3);
		}
		// Record the right click event so that it can be used later if the mouse is dragged.
		if (SwingUtilities.isRightMouseButton(mouseEvent))
		{
			latestRightClick = mouseEvent;
		}
		return mouseEvent;
	}

	/**
	 * If either the rightClickMovesCamera or the middleClickMenu configs are set, dispatches an extra middle click
	 * event when the mouse is dragged. This makes the camera rotate in both of these scenarios.
	 */
	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		boolean shouldDispatchMiddleClick = (
				(SwingUtilities.isRightMouseButton(mouseEvent) && config.rightClickMovesCamera())
				|| (SwingUtilities.isMiddleMouseButton((mouseEvent)) && config.middleClickMenu())
		);
		if (shouldDispatchMiddleClick && !extraMiddleClickDispatched)
		{
			extraMiddleClickDispatched = true;
			eventQueue.postEvent(sameMouseEventForDifferentButton(latestRightClick, MouseEvent.BUTTON2));
		}
		return mouseEvent;
	}

	/**
	 * Correct the MouseEvent to release the correct buttons.
	 */
	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		// If there was an extra middle click press, it should also be released.
		if (extraMiddleClickDispatched)
		{
			extraMiddleClickDispatched = false;
			eventQueue.postEvent(sameMouseEventForDifferentButton(mouseEvent, MouseEvent.BUTTON2));
		}
		// If the press event was mutated, the release event should also be mutated.
		if (middleClickMutatedToRightClick)
		{
			middleClickMutatedToRightClick = false;
			mouseEvent = sameMouseEventForDifferentButton(mouseEvent, MouseEvent.BUTTON3);
		}
		return mouseEvent;
	}

	/**
	 * Creates a new MouseEvent from an existing one for the given button.
	 */
	private MouseEvent sameMouseEventForDifferentButton(MouseEvent mouseEvent, int button)
	{
		return new MouseEvent(
				(java.awt.Component) mouseEvent.getSource(),
				mouseEvent.getID(),
				mouseEvent.getWhen(),
				mouseEvent.getModifiersEx(),
				mouseEvent.getX(),
				mouseEvent.getY(),
				mouseEvent.getClickCount(),
				mouseEvent.isPopupTrigger(),
				button);
	}

	/*
	 * These methods are unused but required to be present in a MouseListener implementation
	 */
	// region Unused MouseListener methods
	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseExited(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}
	// endregion
}
