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
import java.util.Arrays;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptCallbackEvent;
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

@PluginDescriptor(
	name = "Camera",
	description = "Expands zoom limit, provides vertical camera, and remaps mouse input keys",
	tags = {"zoom", "limit", "vertical", "click", "mouse"},
	enabledByDefault = false
)
public class CameraPlugin extends Plugin implements KeyListener, MouseListener
{
	private static final int DEFAULT_ZOOM_INCREMENT = 25;
	private static final String LOOK_NORTH = "Look North";
	private static final String LOOK_SOUTH = "Look South";
	private static final String LOOK_EAST = "Look East";
	private static final String LOOK_WEST = "Look West";

	private boolean controlDown;
	// flags used to store the mousedown states
	private boolean rightClick;
	private boolean middleClick;
	/**
	 * Whether or not the current menu has any non-ignored menu entries
	 */
	private boolean menuHasEntries;
	
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

	@Provides
	CameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CameraConfig.class);
	}

	@Override
	protected void startUp()
	{
		rightClick = false;
		middleClick = false;
		menuHasEntries = false;
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
	}

	@Override
	protected void shutDown()
	{
		client.setCameraPitchRelaxerEnabled(false);
		keyManager.unregisterKeyListener(this);
		mouseManager.unregisterMouseListener(this);
		controlDown = false;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		if (menuEntryAdded.getType() == MenuAction.WIDGET_DEFAULT.getId() && menuEntryAdded.getOption().equals(LOOK_NORTH) && config.compassLook())
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			int len = menuEntries.length;
			MenuEntry north = menuEntries[len - 1];

			menuEntries = Arrays.copyOf(menuEntries, len + 3);

			// The handling for these entries is done in ToplevelCompassOp.rs2asm
			menuEntries[--len] = createCameraLookEntry(menuEntryAdded, 4, LOOK_WEST);
			menuEntries[++len] = createCameraLookEntry(menuEntryAdded, 3, LOOK_EAST);
			menuEntries[++len] = createCameraLookEntry(menuEntryAdded, 2, LOOK_SOUTH);
			menuEntries[++len] = north;

			client.setMenuEntries(menuEntries);
		}
	}

	private MenuEntry createCameraLookEntry(MenuEntryAdded lookNorth, int identifier, String option)
	{
		MenuEntry m = new MenuEntry();
		m.setOption(option);
		m.setTarget(lookNorth.getTarget());
		m.setIdentifier(identifier);
		m.setType(MenuAction.WIDGET_DEFAULT.getId());
		m.setParam0(lookNorth.getActionParam0());
		m.setParam1(lookNorth.getActionParam1());
		return m;
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
			int outerZoomLimit = 128 - outerLimit;
			intStack[intStackSize - 1] = outerZoomLimit;
			return;
		}

		if ("scrollWheelZoomIncrement".equals(event.getEventName()) && config.zoomIncrement() != DEFAULT_ZOOM_INCREMENT)
		{
			intStack[intStackSize - 1] = config.zoomIncrement();
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
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());
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
	 * Checks if the menu has any non-ignored entries
	 */
	private boolean hasMenuEntries(MenuEntry[] menuEntries)
	{
		for (MenuEntry menuEntry : menuEntries)
		{
			MenuAction action = MenuAction.of(menuEntry.getType());
			switch (action)
			{
				case CANCEL:
				case WALK:
					break;
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
				case EXAMINE_ITEM_GROUND:
				case EXAMINE_ITEM:
				case EXAMINE_ITEM_BANK_EQ:
					if (config.ignoreExamine())
					{
						break;
					}
				default:
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the menu has any options, because menu entries are built each
	 * tick and the MouseListener runs on the awt thread
	 */
	@Subscribe
	public void onClientTick(ClientTick event)
	{
		menuHasEntries = hasMenuEntries(client.getMenuEntries());
	}

	/**
	 * The event that is triggered when a mouse button is pressed
	 * In this method the right click is changed to a middle-click to enable rotating the camera
	 * <p>
	 * This method also provides the config option to enable the middle-mouse button to always open the right click menu
	 */
	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (SwingUtilities.isRightMouseButton(mouseEvent) && config.rightClickMovesCamera())
		{
			boolean oneButton = client.getVar(VarPlayer.MOUSE_BUTTONS) == 1;
			// Only move the camera if there is nothing at the menu, or if
			// in one-button mode. In one-button mode, left and right click always do the same thing,
			// so always treat it as the menu is empty
			if (!menuHasEntries || oneButton)
			{
				// Set the rightClick flag to true so we can release the button in mouseReleased() later
				rightClick = true;
				// Change the mousePressed() MouseEvent to the middle mouse button
				mouseEvent = new MouseEvent((java.awt.Component) mouseEvent.getSource(),
					mouseEvent.getID(),
					mouseEvent.getWhen(),
					mouseEvent.getModifiersEx(),
					mouseEvent.getX(),
					mouseEvent.getY(),
					mouseEvent.getClickCount(),
					mouseEvent.isPopupTrigger(),
					MouseEvent.BUTTON2);
			}
		}
		else if (SwingUtilities.isMiddleMouseButton((mouseEvent)) && config.middleClickMenu())
		{
			// Set the middleClick flag to true so we can release it later in mouseReleased()
			middleClick = true;
			// Chance the middle mouse button MouseEvent to a right-click
			mouseEvent = new MouseEvent((java.awt.Component) mouseEvent.getSource(),
				mouseEvent.getID(),
				mouseEvent.getWhen(),
				mouseEvent.getModifiersEx(),
				mouseEvent.getX(),
				mouseEvent.getY(),
				mouseEvent.getClickCount(),
				mouseEvent.isPopupTrigger(),
				MouseEvent.BUTTON3);
		}
		return mouseEvent;
	}

	/**
	 * Correct the MouseEvent to release the correct button
	 */
	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		if (rightClick)
		{
			rightClick = false;
			// Change the MouseEvent to button 2 so the middle mouse button will be released
			mouseEvent = new MouseEvent((java.awt.Component) mouseEvent.getSource(),
				mouseEvent.getID(),
				mouseEvent.getWhen(),
				mouseEvent.getModifiersEx(),
				mouseEvent.getX(),
				mouseEvent.getY(),
				mouseEvent.getClickCount(),
				mouseEvent.isPopupTrigger(),
				MouseEvent.BUTTON2);

		}
		if (middleClick)
		{
			middleClick = false;
			// Change the MouseEvent ot button 3 so the right mouse button will be released
			mouseEvent = new MouseEvent((java.awt.Component) mouseEvent.getSource(),
				mouseEvent.getID(),
				mouseEvent.getWhen(),
				mouseEvent.getModifiersEx(),
				mouseEvent.getX(),
				mouseEvent.getY(),
				mouseEvent.getClickCount(),
				mouseEvent.isPopupTrigger(),
				MouseEvent.BUTTON3);
		}
		return mouseEvent;
	}

	/*
	 * These methods are unused but required to be present in a MouseListener implementation
	 */
	// region Unused MouseListener methods
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
