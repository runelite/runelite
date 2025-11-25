/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

class GpuIntBuffer
{
	private final IntBuffer buffer;

	GpuIntBuffer(IntBuffer ib)
	{
		buffer = ib;
	}

	void put22224(int x, int y, int z, int w)
	{
		buffer.put(((y & 0xffff) << 16) | (x & 0xffff));
		buffer.put(z & 0xffff);
		buffer.put(w);
	}

	void put2222(int x, int y, int z, int w)
	{
		buffer.put(((y & 0xffff) << 16) | (x & 0xffff));
		buffer.put(((w & 0xffff) << 16) | (z & 0xffff));
	}

	void flip()
	{
		buffer.flip();
	}

	void clear()
	{
		buffer.clear();
	}

	IntBuffer getBuffer()
	{
		return buffer;
	}

	static IntBuffer allocateDirect(int size)
	{
		return ByteBuffer.allocateDirect(size * Integer.BYTES)
			.order(ByteOrder.nativeOrder())
			.asIntBuffer();
	}
}
