/*
 * Copyright (c) 2026, MoonBoi9001 <https://github.com/MoonBoi9001>
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
package net.runelite.client.plugins.minimap;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.MagnificationGesture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MinimapPluginTest
{
	@Inject
	MinimapPlugin minimapPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	MinimapConfig minimapConfig;

	@Mock
	@Bind
	ClientThread clientThread;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	Widget minimap;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		lenient().when(client.getWidget(InterfaceID.ToplevelPreEoc.MINIMAP)).thenReturn(minimap);
		lenient().when(minimap.getBounds()).thenReturn(new Rectangle(1107, 8, 152, 152));
		lenient().when(client.isMinimapZoom()).thenReturn(true);
		lenient().when(client.getMinimapZoom()).thenReturn(4d);
		lenient().when(client.getMouseCanvasPosition()).thenReturn(new Point(1171, 117));
	}

	@Test
	public void testPinchOverMinimapZooms()
	{
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(0.25));
		verify(client).setMinimapZoom(eq(5d, 1e-9));
	}

	@Test
	public void testPinchStaysWithinScrollWheelLimits()
	{
		lenient().when(client.getMinimapZoom()).thenReturn(7d);
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(0.5));
		verify(client).setMinimapZoom(eq(8d, 1e-9));

		lenient().when(client.getMinimapZoom()).thenReturn(2.5d);
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(-0.5));
		verify(client).setMinimapZoom(eq(2d, 1e-9));
	}

	@Test
	public void testPinchAwayFromMinimapIsIgnored()
	{
		lenient().when(client.getMouseCanvasPosition()).thenReturn(new Point(600, 400));
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(0.25));
		verify(client, never()).setMinimapZoom(anyDouble());
	}

	@Test
	public void testPinchOverHiddenMinimapIsIgnored()
	{
		lenient().when(minimap.isHidden()).thenReturn(true);
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(0.25));
		verify(client, never()).setMinimapZoom(anyDouble());
	}

	@Test
	public void testPinchIgnoredWhenMinimapZoomIsOff()
	{
		lenient().when(client.isMinimapZoom()).thenReturn(false);
		minimapPlugin.onMagnificationGesture(new MagnificationGesture(0.25));
		verify(client, never()).setMinimapZoom(anyDouble());
	}
}
