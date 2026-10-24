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

import net.runelite.client.game.SceneMirrorViewport;
import static org.lwjgl.opengl.GL33C.*;

/** GPU scene composition pass, shared by GpuPlugin and the opt-in native GL test. */
final class SceneMirrorBlit
{
	private SceneMirrorBlit()
	{
	}

	static void draw(int sourceFramebuffer, int destinationFramebuffer, int resolveFramebuffer, int width, int height, SceneMirrorViewport mirror)
	{
		boolean reflect = mirror != null && mirror.framebufferWidth == width && mirror.framebufferHeight == height
			&& resolveFramebuffer > 0 && resolveFramebuffer != sourceFramebuffer && resolveFramebuffer != destinationFramebuffer;
		glBindFramebuffer(GL_READ_FRAMEBUFFER, sourceFramebuffer);
		if (reflect)
		{
			// Resolve without reversing first. A combined reversed MSAA resolve produced
			// incorrect offset-viewport pixels on the native regression test device.
			glBindFramebuffer(GL_DRAW_FRAMEBUFFER, resolveFramebuffer);
			glBlitFramebuffer(0, 0, width, height, 0, 0, width, height, GL_COLOR_BUFFER_BIT, GL_NEAREST);
			glBindFramebuffer(GL_READ_FRAMEBUFFER, resolveFramebuffer);
		}
		glBindFramebuffer(GL_DRAW_FRAMEBUFFER, destinationFramebuffer);
		glBlitFramebuffer(0, 0, width, height, 0, 0, width, height, GL_COLOR_BUFFER_BIT, GL_NEAREST);
		if (reflect)
		{
			glBlitFramebuffer(mirror.sourceX0, mirror.y0, mirror.sourceX1, mirror.y1,
				mirror.destinationX0, mirror.y0, mirror.destinationX1, mirror.y1,
				GL_COLOR_BUFFER_BIT, GL_NEAREST);
		}
		glBindFramebuffer(GL_READ_FRAMEBUFFER, destinationFramebuffer);
	}
}
