/*
 * Copyright (c) 2026, RuneLite scene mirror prototype contributors
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
package net.runelite.client.plugins.gpu;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReference;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.ArgumentMatchers.any;

public class SceneMirrorPickingLifecycleTest
{
	@Before
	@After
	public void resetState()
	{
		SceneMirrorPicking.clear();
		SceneMirrorPicking.setDisplayTransformSupplier(AffineTransform::new);
	}

	@Test
	public void shutdownKeepsFrameStateUntilTheClientThreadStopsRendering() throws Exception
	{
		Client client = fixture();
		ClientThread thread = mock(ClientThread.class);
		AtomicReference<Runnable> queued = new AtomicReference<>();
		doAnswer(call ->
		{
			queued.set(call.getArgument(0));
			return null;
		}).when(thread).invoke(any(Runnable.class));
		GpuPlugin plugin = new GpuPlugin();
		Field clientField = GpuPlugin.class.getDeclaredField("client");
		clientField.setAccessible(true);
		clientField.set(plugin, client);
		Field threadField = GpuPlugin.class.getDeclaredField("clientThread");
		threadField.setAccessible(true);
		threadField.set(plugin, thread);
		SceneMirrorPicking.publish(client, standardFrame());
		plugin.shutDown();
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		// A frame already running when the EDT requested shutdown can still finish.
		SceneMirrorPicking.presentFrame(client, standardFrame());
		queued.get().run();
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		assertFalse(SceneMirrorPicking.isMirrored(client));
		verify(client).setInvertYaw(false);
	}

	@Test
	public void userYawPreferenceSurvivesMirrorToggleAndShutdown()
	{
		Client client = fixture();
		SceneMirrorPicking.setCameraYawPreference(client, true);
		verify(client).setInvertYaw(true);
		clearInvocations(client);
		SceneMirrorPicking.publish(client, standardFrame());
		verify(client).setInvertYaw(false);
		clearInvocations(client);
		SceneMirrorPicking.beginFrame(client, null);
		verify(client, never()).setInvertYaw(true);
		SceneMirrorPicking.presentFrame(client, null);
		verify(client).setInvertYaw(true);
		clearInvocations(client);
		SceneMirrorPicking.publish(client, standardFrame());
		SceneMirrorPicking.clear();
		verify(client).setInvertYaw(true);
	}

	@Test
	public void changingCameraConfigDuringMirrorKeepsCompensation()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		clearInvocations(client);
		SceneMirrorPicking.setCameraYawPreference(client, true);
		verify(client).setInvertYaw(false);
		SceneMirrorPicking.setCameraYawPreference(client, false);
		verify(client).setInvertYaw(true);
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
	}

	@Test
	public void mouseCameraYawChangesOnlyAfterTheMirroredFrameIsDisplayed()
	{
		Client client = fixture();
		SceneMirrorPicking.beginFrame(client, standardFrame());
		verify(client, never()).setInvertYaw(true);
		SceneMirrorPicking.presentFrame(client, standardFrame());
		verify(client).setInvertYaw(true);
		verify(client, never()).setInvertPitch(true);
		verify(client, never()).setInvertPitch(false);
	}

	@Test
	public void disablingTheMirrorRestoresNativeCameraYaw()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		SceneMirrorPicking.presentFrame(client, null);
		verify(client).setInvertYaw(false);
	}

	@Test
	public void shutdownRestoresNativeCameraYaw()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		SceneMirrorPicking.clear();
		verify(client).setInvertYaw(false);
	}

	@Test
	public void beginningFirstRenderChangesOnlyOutgoingCoordinates()
	{
		Client client = fixture();
		SceneMirrorPicking.beginFrame(client, standardFrame());
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertTrue(SceneMirrorPicking.isMirrored(client));
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void presentingFirstFrameChangesOnlyIncomingCoordinates()
	{
		Client client = fixture();
		SceneMirrorPicking.presentFrame(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		assertEquals(30, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertFalse(SceneMirrorPicking.isMirrored(client));
	}

	@Test
	public void newRenderKeepsInputFromPreviouslyPresentedFrame()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		SceneMirrorPicking.beginFrame(client, fractionalFrame());
		assertEquals(39, SceneMirrorPicking.mapWorldCanvasX(client, 80, 60));
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void presentationDoesNotReplaceTheActiveOutgoingTransform()
	{
		Client client = fixture();
		SceneMirrorPicking.beginFrame(client, standardFrame());
		SceneMirrorPicking.presentFrame(client, fractionalFrame());
		assertEquals(78, SceneMirrorPicking.mapSceneX(20, 30));
		assertEquals(40, SceneMirrorPicking.mapWorldCanvasX(client, 80, 60));
	}

	@Test
	public void togglingOffRendersNativeBeforeReplacingDisplayedInput()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		SceneMirrorPicking.beginFrame(client, null);
		assertEquals(30, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertFalse(SceneMirrorPicking.isMirrored(client));
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		SceneMirrorPicking.presentFrame(client, null);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void clearingDropsBothRenderAndPresentedSnapshots()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		SceneMirrorPicking.clear();
		assertEquals(30, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		assertFalse(SceneMirrorPicking.isMirrored(client));
	}

	@Test
	public void loginTransitionClearsBothMappingsBeforeUiOnlyFrames() throws Exception
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		GpuPlugin plugin = new GpuPlugin();
		Field enabled = GpuPlugin.class.getDeclaredField("sceneMirrorEnabled");
		enabled.setAccessible(true);
		enabled.setBoolean(plugin, true);
		Field valid = GpuPlugin.class.getDeclaredField("sceneFboValid");
		valid.setAccessible(true);
		valid.setBoolean(plugin, true);
		GameStateChanged event = new GameStateChanged();
		event.setGameState(GameState.LOGIN_SCREEN);
		// This real event handler uses no GL operations for LOGIN_SCREEN.
		plugin.onGameStateChanged(event);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		assertEquals(30, SceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertFalse(SceneMirrorPicking.isMirrored(client));
		assertFalse("UI-only frames must not remain behind the stale-scene guard", enabled.getBoolean(plugin));
		assertFalse("A login frame cannot reuse the previous scene framebuffer", valid.getBoolean(plugin));
	}

	@Test
	public void canvasResizeRejectsIncomingWithUnchangedLogicalViewport()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		when(client.getCanvasWidth()).thenReturn(301);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		when(client.getCanvasWidth()).thenReturn(300);
		when(client.getCanvasHeight()).thenReturn(201);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void changingStretchModeRejectsPresentedSnapshot()
	{
		Client client = fixture();
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		when(client.isStretchedEnabled()).thenReturn(true);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void mutableStretchedDimensionsCannotChangeCapturedEpoch()
	{
		Client client = fixture();
		Dimension dimensions = new Dimension(300, 200);
		when(client.isStretchedEnabled()).thenReturn(true);
		when(client.getStretchedDimensions()).thenReturn(dimensions);
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		dimensions.width = 301;
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		dimensions.width = 300;
		dimensions.height = 201;
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void changedDpiScaleRejectsIncomingWithUnchangedClientGeometry()
	{
		Client client = fixture();
		AffineTransform display = new AffineTransform();
		SceneMirrorPicking.setDisplayTransformSupplier(() -> display);
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		// Mutate the same transform to catch retaining a live object instead of its scale values.
		display.setToScale(1.25, 1);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		display.setToScale(1, 1.25);
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	private static SceneMirrorPicking.Frame standardFrame()
	{
		return new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, 1, 1, SceneMirrorViewport.capture(10, 100, 100, 80, 300, 200));
	}

	private static SceneMirrorPicking.Frame fractionalFrame()
	{
		return new SceneMirrorPicking.Frame(10, 20, 100, 80,
			11, 127, 1.25, 1.5, SceneMirrorViewport.capture(11, 150, 127, 120, 400, 300));
	}

	private static Client fixture()
	{
		Client client = mock(Client.class);
		when(client.getViewportXOffset()).thenReturn(10);
		when(client.getViewportYOffset()).thenReturn(20);
		when(client.getViewportWidth()).thenReturn(100);
		when(client.getViewportHeight()).thenReturn(80);
		when(client.getCanvasWidth()).thenReturn(300);
		when(client.getCanvasHeight()).thenReturn(200);
		when(client.isStretchedEnabled()).thenReturn(false);
		when(client.getStretchedDimensions()).thenReturn(new Dimension(300, 200));
		return client;
	}
}
