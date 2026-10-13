/*
 * Copyright (c) 2026, ScapeRune contributors
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
package net.runelite.client.ui;

import net.runelite.api.Client;
import net.runelite.api.hooks.DrawCallbacks;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SceneMirrorTest
{
	@Test
	public void unavailableNativeHooksCannotEnableMirroring()
	{
		Client client = mock(Client.class);
		DrawCallbacks renderer = mock(DrawCallbacks.class);
		when(client.getDrawCallbacks()).thenReturn(renderer);
		when(renderer.supportsSceneMirroring()).thenReturn(true);
		SceneMirror mirror = new SceneMirror(client);
		mirror.setEnabled(true);
		assertFalse(mirror.isAvailable());
		assertFalse(mirror.isEnabled());
	}

	@Test
	public void requestSurvivesRendererSwitchButUnsupportedRendererStaysNormal()
	{
		Client client = mock(Client.class);
		DrawCallbacks supported = mock(DrawCallbacks.class);
		DrawCallbacks unsupported = mock(DrawCallbacks.class);
		when(client.isSceneMirroringSupported()).thenReturn(true);
		when(supported.supportsSceneMirroring()).thenReturn(true);
		when(client.getDrawCallbacks()).thenReturn(supported);
		SceneMirror mirror = new SceneMirror(client);
		assertFalse(mirror.isEnabled());
		assertTrue(mirror.isAvailable());
		mirror.setEnabled(true);
		assertTrue(mirror.isEnabled());
		when(client.getDrawCallbacks()).thenReturn(unsupported);
		assertFalse(mirror.isAvailable());
		assertFalse(mirror.isEnabled());
		when(client.getDrawCallbacks()).thenReturn(null);
		assertFalse(mirror.isEnabled());
		when(client.getDrawCallbacks()).thenReturn(supported);
		assertTrue(mirror.isEnabled());
		mirror.setEnabled(false);
		assertFalse(mirror.isEnabled());
		verify(client, never()).setInvertYaw(anyBoolean());
		verify(client, never()).setInvertPitch(anyBoolean());
	}
}
