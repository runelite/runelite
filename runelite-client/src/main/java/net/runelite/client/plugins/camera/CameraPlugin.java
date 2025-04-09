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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.SettingID;
import net.runelite.api.VarClientInt;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
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
		rightClick = false;
		middleClick = false;
		menuHasEntries = false;
		copyConfigs();
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
		clientThread.invoke(() ->
		{
			Widget sideSlider = client.getWidget(InterfaceID.SettingsSide.ZOOM_SLIDER);
			if (sideSlider != null)
			{
				addZoomTooltip(sideSlider);
			}

			Widget settingsInit = client.getWidget(InterfaceID.Settings.UNIVERSE);
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
		client.setCameraMouseButtonMask(0);
		client.setCameraSpeed(1f);
		client.setCameraPitchRelaxerEnabled(false);
		client.setInvertYaw(false);
		client.setInvertPitch(false);
		client.setCameraShakeDisabled(false);
		keyManager.unregisterKeyListener(this);
		mouseManager.unregisterMouseListener(this);
		controlDown = false;

		clientThread.invoke(() ->
		{
			Widget sideSlider = client.getWidget(InterfaceID.SettingsSide.ZOOM_SLIDER);
			if (sideSlider != null)
			{
				sideSlider.setOnMouseRepeatListener((Object[]) null);
			}

			Widget settingsInit = client.getWidget(InterfaceID.Settings.UNIVERSE);
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
		// rightClickMenuBlocksCamera=true works because mousePressed() does *not* remap rmb->mmb when the menu has object menus.
		// The camera click mask is mmb, so no camera movement happens.
		//
		// rightClickMenuBlocksCamera=false works because the camera click mask is set to 2 or 4. Clicking on objects does *not*
		// remap rmb->mmb, so the rmb click both opens the menu and moves the camera. Clicking on nothing *does* remap rmb->mmb
		// which moves the camera, but won't open a Walk-here only menu.
		// If rightClickMovesCamera=false, we use a mask of 0 which gives us the default behaviour. There's no need to consider
		// rightClickMenuBlocksCamera if rmb isn't used to move the camera to begin with.
		client.setCameraMouseButtonMask((config.rightClickMovesCamera() && !config.rightClickMenuBlocksCamera()) ? ((1 << MouseEvent.BUTTON2) | (1 << 4 /* button 4 */)) : 0);
		client.setCameraSpeed((float) config.cameraSpeed());
		client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch());
		client.setInvertYaw(config.invertYaw());
		client.setInvertPitch(config.invertPitch());
		client.setCameraShakeDisabled(config.disableCameraShake());
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
		if (ev.getGroup().equals("zoom"))
		{
			copyConfigs();
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
	@VisibleForTesting
	boolean hasMenuEntries(MenuEntry[] menuEntries)
	{
		for (MenuEntry menuEntry : menuEntries)
		{
			MenuAction action = menuEntry.getType();
			switch (action)
			{
				case CANCEL:
				case WALK:
					break;
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
				case EXAMINE_ITEM_GROUND:
				case EXAMINE_ITEM:
				case CC_OP_LOW_PRIORITY:
					if (config.rightClickExamine())
					{
						return true;
					}
					break;
				case GAME_OBJECT_FIRST_OPTION:
				case GAME_OBJECT_SECOND_OPTION:
				case GAME_OBJECT_THIRD_OPTION:
				case GAME_OBJECT_FOURTH_OPTION:
				case GAME_OBJECT_FIFTH_OPTION:
				case NPC_FIRST_OPTION:
				case NPC_SECOND_OPTION:
				case NPC_THIRD_OPTION:
				case NPC_FOURTH_OPTION:
				case NPC_FIFTH_OPTION:
				case GROUND_ITEM_FIRST_OPTION:
				case GROUND_ITEM_SECOND_OPTION:
				case GROUND_ITEM_THIRD_OPTION:
				case GROUND_ITEM_FOURTH_OPTION:
				case GROUND_ITEM_FIFTH_OPTION:
				case PLAYER_FIRST_OPTION:
				case PLAYER_SECOND_OPTION:
				case PLAYER_THIRD_OPTION:
				case PLAYER_FOURTH_OPTION:
				case PLAYER_FIFTH_OPTION:
				case PLAYER_SIXTH_OPTION:
				case PLAYER_SEVENTH_OPTION:
				case PLAYER_EIGHTH_OPTION:
					if (config.rightClickObjects())
					{
						return true;
					}
					break;
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
		sliderTooltip = null;
	}

	@Subscribe
	private void onScriptPreFired(ScriptPreFired ev)
	{
		switch (ev.getScriptId())
		{
			case ScriptID.SETTINGS_SLIDER_CHOOSE_ONOP:
			{
				int arg = client.getIntStackSize() - 11;
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
		if (ev.getGroupId() == InterfaceID.SETTINGS_SIDE)
		{
			addZoomTooltip(client.getWidget(InterfaceID.SettingsSide.ZOOM_SLIDER));
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
			boolean oneButton = client.getVarpValue(VarPlayerID.OPTION_MOUSE) == 1;
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
