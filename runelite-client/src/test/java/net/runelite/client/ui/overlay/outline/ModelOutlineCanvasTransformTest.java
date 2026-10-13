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
package net.runelite.client.ui.overlay.outline;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.runelite.api.CanvasTransform;
import net.runelite.api.Client;
import net.runelite.api.hooks.DrawCallbacks;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModelOutlineCanvasTransformTest
{
	@Test
	public void originalFrontFaceIsVisibleAndBackFaceIsCulled() throws Exception
	{
		assertFalse(culled(false, 10, 10, 10, 20, 20, 10));
		assertTrue(culled(false, 20, 10, 20, 20, 10, 10));
	}

	@Test
	public void reflectedFrontFaceStaysVisibleAndBackFaceStaysCulled() throws Exception
	{
		assertFalse(culled(true, 20, 10, 20, 20, 10, 10));
		assertTrue(culled(true, 10, 10, 10, 20, 20, 10));
	}

	@Test
	public void degenerateFaceIsCulledInBothOrientations() throws Exception
	{
		assertTrue(culled(false, 10, 10, 20, 20, 30, 30));
		assertTrue(culled(true, 30, 10, 20, 20, 10, 30));
	}

	private static boolean culled(boolean mirrored, int... points) throws Exception
	{
		Client client = mock(Client.class);
		DrawCallbacks renderer = mock(DrawCallbacks.class);
		when(client.getDrawCallbacks()).thenReturn(renderer);
		when(renderer.getCanvasTransform()).thenReturn(new CanvasTransform()
		{
			public int mapX(Client client, int x, int y)
			{
				return x;
			}

			public boolean isMirrored(Client client)
			{
				return mirrored;
			}
		});
		Constructor<ModelOutlineRenderer> constructor = ModelOutlineRenderer.class.getDeclaredConstructor(Client.class);
		constructor.setAccessible(true);
		ModelOutlineRenderer outline = constructor.newInstance(client);
		Method method = ModelOutlineRenderer.class.getDeclaredMethod("cullFace", int.class, int.class, int.class, int.class, int.class, int.class);
		method.setAccessible(true);
		return (boolean) method.invoke(outline, points[0], points[1], points[2], points[3], points[4], points[5]);
	}
}
