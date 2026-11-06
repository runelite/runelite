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

import java.awt.Canvas;
import java.awt.Frame;
import java.nio.ByteBuffer;
import javax.swing.SwingUtilities;
import net.runelite.client.game.SceneMirrorViewport;
import net.runelite.rlawt.AWTContext;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;
import static org.junit.Assert.*;
import static org.lwjgl.opengl.GL33C.*;

/** Explicit opt-in native pixel test. Never starts the game client or shows a window. */
public class SceneMirrorBlitGLTest
{
	private static Frame peer;
	private static AWTContext context;
	private static final int WIDTH = 12;
	private static final int HEIGHT = 8;

	@BeforeClass
	public static void initialize() throws Exception
	{
		Assume.assumeTrue("Native GL test is explicitly opt-in", Boolean.getBoolean("runelite.mirror.gltest"));
		Assume.assumeTrue("This hidden peer test targets Windows", System.getProperty("os.name").startsWith("Windows"));
		Canvas canvas = new Canvas();
		SwingUtilities.invokeAndWait(() ->
		{
			peer = new Frame();
			peer.add(canvas);
			peer.setSize(64, 64);
			peer.addNotify();
			peer.validate();
		});
		assertFalse("Native peer must remain hidden", peer.isVisible());
		AWTContext.loadNatives();
		context = new AWTContext(canvas);
		context.configurePixelFormat(0, 0, 0);
		context.createGLContext();
		GL.createCapabilities();
		assertTrue("OpenGL 3.3 required", GL.getCapabilities().OpenGL33);
		System.out.println("MIRROR GL renderer: " + glGetString(GL_RENDERER));
		System.out.println("MIRROR GL version: " + glGetString(GL_VERSION));
	}

	@AfterClass
	public static void destroy() throws Exception
	{
		try
		{
			if (context != null)
			{
				context.destroy();
			}
		}
		finally
		{
			if (peer != null)
			{
				SwingUtilities.invokeAndWait(peer::dispose);
			}
		}
	}

	@Test
	public void readsActualMirroredPixelsAndPreservesOutsideViewport()
	{
		verify(SceneMirrorViewport.capture(2, 1, 5, 5, WIDTH, HEIGHT), 0, true);
	}

	@Test
	public void disabledAndMismatchedSnapshotsRemainUnmirrored()
	{
		verify(null, 0, false);
		verify(SceneMirrorViewport.capture(2, 1, 5, 5, 24, HEIGHT), 0, false);
		verify(null, 2, false);
	}

	@Test
	public void resolvesActualMultisampledViewportWithoutScaling()
	{
		assertTrue("At least 2 samples required", glGetInteger(GL_MAX_SAMPLES) >= 2);
		verify(SceneMirrorViewport.capture(2, 1, 5, 5, WIDTH, HEIGHT), 2, true);
	}

	private void verify(SceneMirrorViewport mirror, int samples, boolean reflected)
	{
		int source = glGenFramebuffers();
		int destination = glGenFramebuffers();
		int resolve = glGenFramebuffers();
		int sourceBuffer = glGenRenderbuffers();
		int destinationBuffer = glGenRenderbuffers();
		int resolveBuffer = glGenRenderbuffers();
		ByteBuffer pixels = MemoryUtil.memAlloc(WIDTH * HEIGHT * 4);
		try
		{
			attach(source, sourceBuffer, samples);
			glEnable(GL_SCISSOR_TEST);
			for (int x = 0; x < WIDTH; x++)
			{
				for (int y = 0; y < HEIGHT; y++)
				{
					glScissor(x, y, 1, 1);
					glClearColor((20 + 10 * x) / 255f, (40 + 10 * y) / 255f, 60 / 255f, 1f);
					glClear(GL_COLOR_BUFFER_BIT);
				}
			}
			glDisable(GL_SCISSOR_TEST);
			attach(destination, destinationBuffer, 0);
			attach(resolve, resolveBuffer, 0);
			SceneMirrorBlit.draw(source, destination, resolve, WIDTH, HEIGHT, mirror);
			assertEquals("Real GL pass must complete without error", GL_NO_ERROR, glGetError());
			glReadPixels(0, 0, WIDTH, HEIGHT, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
			StringBuilder row = new StringBuilder();
			for (int x = 0; x < WIDTH; x++)
			{
				row.append(pixels.get((WIDTH + x) * 4) & 255).append(' ');
			}
			System.out.println("MIRROR pixels samples=" + samples + " reflected=" + reflected + " y=1: " + row);
			for (int y = 0; y < HEIGHT; y++)
			{
				for (int x = 0; x < WIDTH; x++)
				{
					int originalX = reflected && x >= 2 && x < 7 && y >= 1 && y < 6 ? 8 - x : x;
					assertEquals("Pixel x=" + x + " y=" + y + " samples=" + samples,
						20 + 10 * originalX, pixels.get((y * WIDTH + x) * 4) & 255);
					assertEquals("Vertical orientation must remain unchanged", 40 + 10 * y,
						pixels.get((y * WIDTH + x) * 4 + 1) & 255);
					assertEquals(60, pixels.get((y * WIDTH + x) * 4 + 2) & 255);
					assertEquals(255, pixels.get((y * WIDTH + x) * 4 + 3) & 255);
				}
			}
			assertFalse("No visible window allowed", peer.isVisible());
		}
		finally
		{
			MemoryUtil.memFree(pixels);
			glBindFramebuffer(GL_FRAMEBUFFER, 0);
			glDeleteFramebuffers(source);
			glDeleteFramebuffers(destination);
			glDeleteFramebuffers(resolve);
			glDeleteRenderbuffers(sourceBuffer);
			glDeleteRenderbuffers(destinationBuffer);
			glDeleteRenderbuffers(resolveBuffer);
		}
	}

	private void attach(int framebuffer, int renderbuffer, int samples)
	{
		glBindFramebuffer(GL_FRAMEBUFFER, framebuffer);
		glBindRenderbuffer(GL_RENDERBUFFER, renderbuffer);
		glRenderbufferStorageMultisample(GL_RENDERBUFFER, samples, GL_RGBA8, WIDTH, HEIGHT);
		glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_RENDERBUFFER, renderbuffer);
		assertEquals(GL_FRAMEBUFFER_COMPLETE, glCheckFramebufferStatus(GL_FRAMEBUFFER));
	}
}
