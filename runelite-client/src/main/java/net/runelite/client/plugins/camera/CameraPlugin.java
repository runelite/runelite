/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Camera",
	description = "Expand zoom limit and/or enable vertical camera",
	tags = {"limit", "vertical", "detached"},
	enabledByDefault = false
)
public class CameraPlugin extends Plugin implements KeyListener, MouseListener
{
	/**
	 * The largest (most zoomed in) value that can be used without the client crashing.
	 *
	 * Larger values trigger an overflow in the engine's fov to scale code.
	 */
	private static final int INNER_ZOOM_LIMIT = 1004;

	private static final WidgetMenuOption TOGGLE_FREE_CAMERA_OPTION = new WidgetMenuOption(
		"Toggle", "Free Camera", WidgetInfo.WORLD_MAP_OPTION);

	private boolean controlDown;
	private boolean oculusManualEnable;

	@Inject
	private Client client;

	@Inject
	private CameraConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private MouseManager mouseManager;

	@Provides
	CameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CameraConfig.class);
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

		if ("scrollWheelZoom".equals(event.getEventName()) && config.requireControlDown() && !controlDown)
		{
			intStack[intStackSize - 1] = 1;
		}

		if ("innerZoomLimit".equals(event.getEventName()) && config.innerLimit())
		{
			intStack[intStackSize - 1] = INNER_ZOOM_LIMIT;
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

	@Override
	protected void startUp()
	{
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);

		if (config.freeRoamCamera())
		{
			menuManager.addManagedCustomMenu(TOGGLE_FREE_CAMERA_OPTION);
		}
	}

	@Override
	protected void shutDown()
	{
		client.setCameraPitchRelaxerEnabled(false);
		keyManager.unregisterKeyListener(this);
		mouseManager.unregisterMouseListener(this);
		menuManager.removeManagedCustomMenu(TOGGLE_FREE_CAMERA_OPTION);
		controlDown = false;
		setOculusEnabled(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());

		if (config.freeRoamCamera())
		{
			menuManager.addManagedCustomMenu(TOGGLE_FREE_CAMERA_OPTION);
		}
		else
		{
			menuManager.removeManagedCustomMenu(TOGGLE_FREE_CAMERA_OPTION);
		}
	}

	@Subscribe
	public void onWidgetMenuOptionClicked(final WidgetMenuOptionClicked event)
	{
		if (event.getWidget() != WidgetInfo.WORLD_MAP_OPTION)
		{
			return;
		}

		if (event.getMenuOption().equals(TOGGLE_FREE_CAMERA_OPTION.getMenuOption()) &&
			event.getMenuTarget().equals(TOGGLE_FREE_CAMERA_OPTION.getMenuTarget()))
		{
			// Invert orb enabled state for free roam camera
			setOculusEnabled(!isOculusEnabled());
		}
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
		}
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (config.freeRoamCamera()
			&& isOculusEnabled()
			&& oculusManualEnable
			&& (SwingUtilities.isLeftMouseButton(mouseEvent) || SwingUtilities.isRightMouseButton(mouseEvent)))
		{
			setOculusEnabled(false);
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
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

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	private boolean isOculusEnabled()
	{
		return client.getOculusOrbState() == 1;
	}

	private void setOculusEnabled(boolean enabled)
	{
		client.setOculusOrbNormalSpeed(enabled ? 36 : 12);
		client.setOculusOrbState(enabled ? 1 : 0);
		oculusManualEnable = enabled;
	}
}
