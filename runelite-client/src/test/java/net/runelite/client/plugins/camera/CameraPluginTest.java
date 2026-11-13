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
import java.awt.Rectangle;
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
import net.runelite.api.gameval.VarClientID;
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

	private void setUpZoom(int zoom)
	{
		varcs.put(VarClientID.CAMERA_ZOOM_SMALL, zoom);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG, zoom);
		lenient().when(cameraConfig.pinchToZoom()).thenReturn(true);
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

	private void pinch()
	{
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(0.1));
	}

	@Test
	public void testPinchOverSceneZooms()
	{
		setUpZoom(512);
		hover(MenuAction.WALK, widgetUnderCursor(false));

		pinch();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 547, 547);
	}

	@Test
	public void testPinchWhileSailingZooms()
	{
		setUpZoom(512);
		hover(MenuAction.SET_HEADING);

		pinch();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 547, 547);
	}

	@Test
	public void testPinchOverInterfaceIsIgnored()
	{
		// Over the bank, inventory or minimap the menu has no option for the scene
		setUpZoom(512);
		hover(MenuAction.CC_OP);

		pinch();
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchOverScrollBlockingInterfaceIsIgnored()
	{
		// The chatbox lets clicks reach the scene but keeps scrolls for itself
		setUpZoom(512);
		hover(MenuAction.WALK, widgetUnderCursor(true));

		pinch();
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchOverScrollBlockingChildIsIgnored()
	{
		setUpZoom(512);
		Widget staticParent = widgetUnderCursor(false);
		Widget dynamicParent = widgetUnderCursor(false);
		Widget nestedParent = widgetUnderCursor(false);
		Widget[] child = {widgetUnderCursor(true)};
		when(staticParent.getStaticChildren()).thenReturn(child);
		when(dynamicParent.getDynamicChildren()).thenReturn(child);
		when(nestedParent.getNestedChildren()).thenReturn(child);

		for (Widget parent : new Widget[]{staticParent, dynamicParent, nestedParent})
		{
			hover(MenuAction.WALK, parent);
			pinch();
		}
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchPastScrollBlockingInterfaceZooms()
	{
		// An interface only keeps scrolls for itself while it is shown and under the cursor
		setUpZoom(512);
		Widget hidden = widgetUnderCursor(true);
		when(hidden.isSelfHidden()).thenReturn(true);
		Widget elsewhere = widgetUnderCursor(true);
		when(elsewhere.getBounds()).thenReturn(new Rectangle(300, 300, 100, 100));
		hover(MenuAction.WALK, hidden, elsewhere);

		pinch();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 547, 547);
	}

	@Test
	public void testPinchZoomFollowsScale()
	{
		// The scene is drawn twice as large for every 256 added to either zoom value
		setUpZoom(512);
		varcs.put(VarClientID.CAMERA_ZOOM_BIG, 600);

		cameraPlugin.pinchZoom(2);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 768, 856);

		cameraPlugin.pinchZoom(0.5);
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 512, 600);
	}

	@Test
	public void testPinchZoomKeepsFractionsBetweenEvents()
	{
		setUpZoom(512);

		// Each step alone is under 1 zoom value, so without carrying the fraction the zoom would never move
		for (int i = 0; i < 10; ++i)
		{
			cameraPlugin.pinchZoom(1.001);
		}

		assertEquals(515, (int) varcs.get(VarClientID.CAMERA_ZOOM_BIG));
	}

	@Test
	public void testPinchWithImpossibleScaleIsIgnored()
	{
		setUpZoom(512);
		hover(MenuAction.WALK);

		// A magnification of -1 would shrink the scene to nothing, and neither scale has a usable logarithm
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(-1));
		cameraPlugin.onMagnificationGesture(new MagnificationGesture(Double.POSITIVE_INFINITY));
		verify(client, never()).runScript(any(Object[].class));

		pinch();
		verify(client).runScript(ScriptID.CAMERA_DO_ZOOM, 547, 547);
	}

	@Test
	public void testPinchWhileLoggedOutIsIgnored()
	{
		setUpZoom(512);
		hover(MenuAction.WALK);
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

		pinch();
		verify(client, never()).runScript(any(Object[].class));
	}

	@Test
	public void testPinchesWhileOptionOffAreDropped()
	{
		setUpZoom(512);
		hover(MenuAction.WALK);
		when(cameraConfig.pinchToZoom()).thenReturn(false);

		pinch();
		verify(client, never()).runScript(any(Object[].class));
		// The option is checked before the interfaces under the cursor are searched
		verify(client, never()).getWidgetRoots();
	}
}
