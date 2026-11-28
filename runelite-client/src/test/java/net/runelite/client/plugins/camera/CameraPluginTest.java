/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.MagnificationGesture;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CameraPluginTest
{
	@Inject
	CameraPlugin cameraPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	CameraConfig cameraConfig;

	@Mock
	@Bind
	MouseManager mouseManager;

	@Mock
	@Bind
	KeyManager keyManager;

	@Mock
	@Bind
	ClientThread clientThread;

	private final Map<Integer, Integer> varcs = new HashMap<>();

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testHasMenuEntries()
	{
		/*
			                    right click examine?    right click object?      move camera
			  has object op     Y                       Y                        N
			                    Y                       N                        N
			                    N                       Y                        N
			                    N                       N                        Y

			 has examine op     Y                       Y                        N
			                    Y                       N                        N
			                    N                       Y                        Y
			                    N                       N                        Y
		 */
		test(true, true, true, true, false);
		test(true, true, true, false, false);
		test(true, true, false, true, false);
		test(true, true, false, false, true);

		test(false, true, true, true, false);
		test(false, true, true, false, false);
		test(false, true, false, true, true);
		test(false, true, false, false, true);
	}

	private void test(boolean hasOp, boolean hasExamine, boolean rightClickExamine, boolean rightClickObject, boolean movesCamera)
	{
		assert !(hasOp && !hasExamine);
		List<MenuEntry> menus = new ArrayList<>();
		if (hasOp)
		{
			MenuEntry entry = mock(MenuEntry.class);
			when(entry.getType()).thenReturn(MenuAction.GAME_OBJECT_FIRST_OPTION);
			menus.add(entry);
		}
		if (hasExamine)
		{
			MenuEntry entry = mock(MenuEntry.class);
			when(entry.getType()).thenReturn(MenuAction.EXAMINE_OBJECT);
			menus.add(entry);
		}
		when(cameraConfig.rightClickObjects()).thenReturn(rightClickObject);
		when(cameraConfig.rightClickExamine()).thenReturn(rightClickExamine);
		assertEquals(!movesCamera, cameraPlugin.hasMenuEntries(menus.toArray(new MenuEntry[0])));
	}

	private void setUpZoom(int zoom, int min, int max)
	{
		varcs.put(VarClientID.CAMERA_ZOOM_SMALL, zoom);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG, zoom);
		varcs.put(VarClientID.CAMERA_ZOOM_SMALL_MIN, min);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG_MIN, min);
		varcs.put(VarClientID.CAMERA_ZOOM_SMALL_MAX, max);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG_MAX, max);
		lenient().when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		lenient().when(client.getVarcIntValue(anyInt())).thenAnswer(inv -> varcs.getOrDefault(inv.<Integer>getArgument(0), 0));
		// CAMERA_DO_ZOOM sets both zoom values, as the game script does
		lenient().doAnswer(inv ->
		{
			varcs.put(VarClientID.CAMERA_ZOOM_SMALL, inv.<Integer>getArgument(1));
			varcs.put(VarClientID.CAMERA_ZOOM_BIG, inv.<Integer>getArgument(2));
			return null;
		}).when(client).runScript(any(Object[].class));
	}

	/**
	 * Puts the cursor over the 3D scene, where the menu offers the given scene option, under the given widgets.
	 */
	private void hover(MenuAction sceneOption, Widget... widgets)
	{
		MenuEntry entry = mock(MenuEntry.class);
		lenient().when(entry.getType()).thenReturn(sceneOption);
		lenient().when(client.getMenuEntries()).thenReturn(new MenuEntry[]{entry});
		lenient().when(client.getMouseCanvasPosition()).thenReturn(new Point(100, 100));
		lenient().when(client.getWidgetRoots()).thenReturn(widgets);
	}

	private Widget widgetUnderCursor(boolean noScrollThrough)
	{
		Widget widget = mock(Widget.class);
		lenient().when(widget.getBounds()).thenReturn(new Rectangle(50, 50, 100, 100));
		lenient().when(widget.getNoScrollThrough()).thenReturn(noScrollThrough);
		return widget;
	}

	private void pinchOneTick()
	{
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
		cameraPlugin.onClientTick(new ClientTick());
	}

	@Test
	public void testPinchOverSceneZooms()
	{
		setUpZoom(512, 128, 896);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
		hover(MenuAction.WALK, widgetUnderCursor(false));

		pinchOneTick();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 563, 563);
	}

	@Test
	public void testPinchWhileSailingZooms()
	{
		setUpZoom(512, 128, 896);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
		hover(MenuAction.SET_HEADING);

		pinchOneTick();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 563, 563);
	}

	@Test
	public void testPinchOverInterfaceIsIgnored()
	{
		// Over the bank, inventory or minimap the menu has no option for the scene
		setUpZoom(512, 128, 896);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
		hover(MenuAction.CC_OP);

		pinchOneTick();
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchOverScrollBlockingInterfaceIsIgnored()
	{
		// The chatbox lets clicks reach the scene but keeps scrolls for itself
		setUpZoom(512, 128, 896);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
		hover(MenuAction.WALK, widgetUnderCursor(true));

		pinchOneTick();
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchZoomScalesWithMagnification()
	{
		setUpZoom(512, 128, 896);

		cameraPlugin.pinchZoom(1.1);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 563, 563);

		cameraPlugin.pinchZoom(0.5);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 282, 282);
	}

	@Test
	public void testPinchZoomKeepsFractionsBetweenEvents()
	{
		setUpZoom(512, 128, 896);

		// Each step alone rounds back to 512, so without carrying the fraction the zoom would never move
		for (int i = 0; i < 10; ++i)
		{
			cameraPlugin.pinchZoom(1.0005);
		}

		assertEquals(515, (int) varcs.get(VarClientID.CAMERA_ZOOM_BIG));
	}

	@Test
	public void testPinchZoomRestartsAfterOtherZoomChanges()
	{
		setUpZoom(512, 128, 896);
		cameraPlugin.pinchZoom(1.0005);

		// The scroll wheel or zoom slider moves the camera between pinches
		varcs.put(VarClientID.CAMERA_ZOOM_SMALL, 600);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG, 600);

		cameraPlugin.pinchZoom(1.1);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 660, 660);
	}

	@Test
	public void testPinchZoomStaysWithinLimits()
	{
		setUpZoom(512, 128, 896);

		cameraPlugin.pinchZoom(11);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 896, 896);

		cameraPlugin.pinchZoom(0.01);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 128, 128);
	}

	@Test
	public void testPinchZoomAtOrBelowZero()
	{
		// Expanding the outer limit can allow zoom values at or below 0, where scaling alone would stall
		setUpZoom(0, -272, 896);

		cameraPlugin.pinchZoom(1.1);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 13, 13);

		varcs.put(VarClientID.CAMERA_ZOOM_SMALL, -100);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG, -100);
		cameraPlugin.pinchZoom(1.1);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, -87, -87);

		cameraPlugin.pinchZoom(0.5);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, -151, -151);
	}

	@Test
	public void testPinchZoomInvalidLimits()
	{
		// Lowering the outer limit far enough can push the minimum above the maximum
		setUpZoom(512, 900, 896);

		cameraPlugin.pinchZoom(1.1);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 900, 900);
	}

	@Test
	public void testPinchZoomBlockedWhenZoomClamped()
	{
		setUpZoom(512, 128, 896);
		when(client.getVarbitValue(VarbitID.FOV_CLAMP)).thenReturn(1);

		cameraPlugin.pinchZoom(1.1);
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchZoomBlockedWhenLoggedOut()
	{
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

		cameraPlugin.pinchZoom(1.1);
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchesApplyOncePerTick()
	{
		setUpZoom(512, 128, 896);
		hover(MenuAction.WALK);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);

		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
		cameraPlugin.onClientTick(new ClientTick());
		// 512 * 1.1 * 1.1 = 619.52
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 620, 620);

		cameraPlugin.onClientTick(new ClientTick());
		verify(client, times(1)).runScript(any(Object[].class));
	}

	@Test
	public void testPinchesWhileOptionOffAreDropped()
	{
		setUpZoom(512, 128, 896);
		hover(MenuAction.WALK);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(false);

		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
		cameraPlugin.onClientTick(new ClientTick());

		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
		cameraPlugin.onClientTick(new ClientTick());
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testStartUpDropsEarlierPinches()
	{
		setUpZoom(512, 128, 896);
		hover(MenuAction.WALK);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);

		// A pinch that arrived after the plugin last stopped
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
		cameraPlugin.startUp();
		cameraPlugin.onClientTick(new ClientTick());
		verify(client, never()).runScript(any(Object[].class));
	}

	/**
	 * A 2-finger trackpad scroll as Java on macOS reports it, where a sideways scroll carries the shift flag.
	 */
	private static MouseWheelEvent swipe(boolean sideways, double amount)
	{
		return new MouseWheelEvent(new Canvas(), MouseEvent.MOUSE_WHEEL, 0, sideways ? InputEvent.SHIFT_DOWN_MASK : 0,
			100, 100, 100, 100, 0, false, MouseWheelEvent.WHEEL_UNIT_SCROLL, 1, 0, amount);
	}

	// Camera targets the swipe tests read back, as the client would keep them
	private final int[] yawTarget = {1000};
	private final int[] pitchTarget = {2000};

	private void setUpSwipe(MenuAction sceneOption)
	{
		lenient().when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		lenient().when(cameraConfig.swipeToRotate()).thenReturn(true);
		lenient().when(cameraConfig.swipeToTilt()).thenReturn(true);
		lenient().when(client.getCameraYawTarget()).thenAnswer(inv -> yawTarget[0]);
		lenient().when(client.getCameraPitchTarget()).thenAnswer(inv -> pitchTarget[0]);
		lenient().doAnswer(inv -> yawTarget[0] = inv.getArgument(0)).when(client).setCameraYawTarget(anyInt());
		lenient().doAnswer(inv -> pitchTarget[0] = inv.getArgument(0)).when(client).setCameraPitchTarget(anyInt());
		lenient().doAnswer(inv ->
		{
			inv.<Runnable>getArgument(0).run();
			return null;
		}).when(clientThread).invokeLater(any(Runnable.class));
		cameraPlugin.macOS = true;
		hover(sceneOption);
	}

	/**
	 * Runs enough client ticks for a swipe to finish moving the camera.
	 */
	private void settle()
	{
		for (int i = 0; i < 30; i++)
		{
			cameraPlugin.onClientTick(new ClientTick());
		}
	}

	@Test
	public void testSidewaysSwipeOverSceneRotatesCamera()
	{
		setUpSwipe(MenuAction.WALK);

		MouseWheelEvent event = swipe(true, -1);
		cameraPlugin.mouseWheelMoved(event);
		settle();

		assertEquals(800, yawTarget[0]);
		verify(client, never()).setCameraPitchTarget(anyInt());
		// Otherwise the game also takes the swipe as an up or down scroll and zooms
		assertTrue(event.isConsumed());
	}

	@Test
	public void testUpDownSwipeOverSceneTiltsCamera()
	{
		setUpSwipe(MenuAction.WALK);

		MouseWheelEvent event = swipe(false, 1);
		cameraPlugin.mouseWheelMoved(event);
		settle();

		assertEquals(1880, pitchTarget[0]);
		verify(client, never()).setCameraYawTarget(anyInt());
		// Left for the game, so it still scrolls interfaces, and its zoom over the scene is stopped separately
		assertFalse(event.isConsumed());
	}

	@Test
	public void testSwipeSpreadsOverTicks()
	{
		setUpSwipe(MenuAction.WALK);

		// Moving the whole swipe in 1 tick makes the camera jump whenever trackpad events bunch up
		cameraPlugin.mouseWheelMoved(swipe(true, -1));
		cameraPlugin.onClientTick(new ClientTick());
		assertTrue(yawTarget[0] < 1000 && yawTarget[0] > 800);

		settle();
		assertEquals(800, yawTarget[0]);
	}

	@Test
	public void testSwipeOverInterfaceIsIgnored()
	{
		setUpSwipe(MenuAction.CC_OP);

		MouseWheelEvent sideways = swipe(true, -1);
		cameraPlugin.mouseWheelMoved(sideways);
		MouseWheelEvent upDown = swipe(false, 1);
		cameraPlugin.mouseWheelMoved(upDown);
		settle();

		verify(client, never()).setCameraYawTarget(anyInt());
		verify(client, never()).setCameraPitchTarget(anyInt());
		// A sideways swipe would otherwise scroll the interface up or down
		assertTrue(sideways.isConsumed());
		assertFalse(upDown.isConsumed());
	}

	@Test
	public void testSwipesWhileOptionsOffPassThrough()
	{
		setUpSwipe(MenuAction.WALK);
		lenient().when(cameraConfig.swipeToRotate()).thenReturn(false);
		lenient().when(cameraConfig.swipeToTilt()).thenReturn(false);

		MouseWheelEvent sideways = swipe(true, -1);
		cameraPlugin.mouseWheelMoved(sideways);
		cameraPlugin.mouseWheelMoved(swipe(false, 1));
		settle();

		verify(client, never()).setCameraYawTarget(anyInt());
		verify(client, never()).setCameraPitchTarget(anyInt());
		assertFalse(sideways.isConsumed());
	}

	@Test
	public void testSidewaysSwipeWhileLoggedOutPassesThrough()
	{
		setUpSwipe(MenuAction.WALK);
		lenient().when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

		MouseWheelEvent event = swipe(true, -1);
		cameraPlugin.mouseWheelMoved(event);

		assertFalse(event.isConsumed());
	}

	@Test
	public void testSwipesAddUpAndKeepFractionsBetweenTicks()
	{
		setUpSwipe(MenuAction.WALK);

		cameraPlugin.mouseWheelMoved(swipe(true, -0.5));
		cameraPlugin.mouseWheelMoved(swipe(true, -0.5));
		settle();
		assertEquals(800, yawTarget[0]);

		// Each of these moves the camera less than 1 angle unit, so without carrying the fraction it would never move
		cameraPlugin.mouseWheelMoved(swipe(true, 0.003));
		settle();
		assertEquals(800, yawTarget[0]);

		cameraPlugin.mouseWheelMoved(swipe(true, 0.003));
		settle();
		assertEquals(801, yawTarget[0]);
	}

	@Test
	public void testYawWrapsAfterFullTurn()
	{
		setUpSwipe(MenuAction.WALK);
		yawTarget[0] = 16380;

		cameraPlugin.mouseWheelMoved(swipe(true, 0.1));
		settle();

		assertEquals(16, yawTarget[0]);
	}

	@Test
	public void testInvertSettingsReverseSwipes()
	{
		setUpSwipe(MenuAction.WALK);
		lenient().when(cameraConfig.invertYaw()).thenReturn(true);
		lenient().when(cameraConfig.invertPitch()).thenReturn(true);

		cameraPlugin.mouseWheelMoved(swipe(true, -1));
		cameraPlugin.mouseWheelMoved(swipe(false, 1));
		settle();

		assertEquals(1200, yawTarget[0]);
		assertEquals(2120, pitchTarget[0]);
	}

	@Test
	public void testShiftScrollOffMacPassesThrough()
	{
		setUpSwipe(MenuAction.WALK);
		cameraPlugin.macOS = false;

		// Only Java on macOS turns a sideways swipe into a shift scroll; elsewhere it is a real shift scroll
		MouseWheelEvent event = swipe(true, -1);
		cameraPlugin.mouseWheelMoved(event);
		settle();

		verify(client, never()).setCameraYawTarget(anyInt());
		assertFalse(event.isConsumed());
	}

	@Test
	public void testControlScrollStillZoomsWithControlToZoom()
	{
		setUpSwipe(MenuAction.WALK);
		lenient().when(cameraConfig.controlFunction()).thenReturn(ControlFunction.CONTROL_TO_ZOOM);
		final int[] intStack = {0};
		lenient().when(client.getIntStack()).thenReturn(intStack);
		lenient().when(client.getIntStackSize()).thenReturn(1);
		ScriptCallbackEvent zoom = new ScriptCallbackEvent();
		zoom.setEventName("scrollWheelZoom");
		cameraPlugin.keyPressed(new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_CONTROL, KeyEvent.CHAR_UNDEFINED));

		cameraPlugin.onScriptCallbackEvent(zoom);
		cameraPlugin.mouseWheelMoved(swipe(false, 1));
		settle();

		assertEquals(0, intStack[0]);
		verify(client, never()).setCameraPitchTarget(anyInt());
	}

	@Test
	public void testTurningSwipeOffStopsGlide()
	{
		setUpSwipe(MenuAction.WALK);

		cameraPlugin.mouseWheelMoved(swipe(true, -1));
		cameraPlugin.mouseWheelMoved(swipe(false, 1));
		cameraPlugin.onClientTick(new ClientTick());
		final int yaw = yawTarget[0];
		final int pitch = pitchTarget[0];
		lenient().when(cameraConfig.swipeToRotate()).thenReturn(false);
		lenient().when(cameraConfig.swipeToTilt()).thenReturn(false);
		settle();

		assertEquals(yaw, yawTarget[0]);
		assertEquals(pitch, pitchTarget[0]);
	}

	@Test
	public void testSwipeToTiltStopsScrollZoom()
	{
		final int[] intStack = {0};
		lenient().when(client.getIntStack()).thenReturn(intStack);
		lenient().when(client.getIntStackSize()).thenReturn(1);
		ScriptCallbackEvent event = new ScriptCallbackEvent();
		event.setEventName("scrollWheelZoom");

		cameraPlugin.onScriptCallbackEvent(event);
		assertEquals(0, intStack[0]);

		// 1 tells the game's scroll zoom script to stop
		lenient().when(cameraConfig.swipeToTilt()).thenReturn(true);
		cameraPlugin.onScriptCallbackEvent(event);
		assertEquals(1, intStack[0]);
	}

	@Test
	public void testStartUpDropsEarlierSwipes()
	{
		setUpSwipe(MenuAction.WALK);

		// Swipes that arrived after the plugin last stopped
		cameraPlugin.mouseWheelMoved(swipe(true, -1));
		cameraPlugin.mouseWheelMoved(swipe(false, 1));
		cameraPlugin.startUp();
		cameraPlugin.onClientTick(new ClientTick());

		verify(client, never()).setCameraYawTarget(anyInt());
		verify(client, never()).setCameraPitchTarget(anyInt());
	}
}
