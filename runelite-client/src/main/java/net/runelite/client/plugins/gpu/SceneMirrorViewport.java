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

/** Immutable framebuffer blit bounds; does not modify client input. */
final class SceneMirrorViewport
{
	final int sourceX0, sourceX1, y0, y1, destinationX0, destinationX1;
	final int framebufferWidth, framebufferHeight;

	private SceneMirrorViewport(int sourceX0, int sourceX1, int x0, int x1, int y0, int y1, int framebufferWidth, int framebufferHeight)
	{
		this.sourceX0 = sourceX0;
		this.sourceX1 = sourceX1;
		this.destinationX0 = x0;
		this.destinationX1 = x1;
		this.y0 = y0;
		this.y1 = y1;
		this.framebufferWidth = framebufferWidth;
		this.framebufferHeight = framebufferHeight;
	}

	static SceneMirrorViewport capture(int x, int y, int width, int height, int framebufferWidth, int framebufferHeight)
	{
		if (width <= 0 || height <= 0 || framebufferWidth <= 0 || framebufferHeight <= 0)
		{
			return null;
		}

		// Clip both sides of a reflected pair, preserving the original viewport axis.
		// Merely reflecting the clipped rectangle moves that axis with asymmetric padding.
		long axis = 2L * x + width;
		long left = Math.max(Math.max(0L, x), axis - framebufferWidth);
		long right = Math.min(Math.min((long) framebufferWidth, (long) x + width), axis);
		long bottom = Math.max(0L, y);
		long top = Math.min((long) framebufferHeight, (long) y + height);
		if (left >= right || bottom >= top)
		{
			return null;
		}

		return new SceneMirrorViewport((int) (axis - left), (int) (axis - right),
			(int) left, (int) right, (int) bottom, (int) top, framebufferWidth, framebufferHeight);
	}
}
