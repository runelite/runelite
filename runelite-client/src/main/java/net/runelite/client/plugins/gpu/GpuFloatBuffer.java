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
import java.nio.FloatBuffer;

class GpuFloatBuffer
{
	private FloatBuffer buffer = allocateDirect(65536);

	void put(float texture, float u, float v, float pad)
	{
		buffer.put(texture).put(u).put(v).put(pad);
	}

	void flip()
	{
		buffer.flip();
	}

	void clear()
	{
		buffer.clear();
	}

	void ensureCapacity(int size)
	{
		int capacity = buffer.capacity();
		final int position = buffer.position();
		if ((capacity - position) < size)
		{
			do
			{
				capacity *= 2;
			}
			while ((capacity - position) < size);

			FloatBuffer newB = allocateDirect(capacity);
			buffer.flip();
			newB.put(buffer);
			buffer = newB;
		}
	}

	FloatBuffer getBuffer()
	{
		return buffer;
	}

	static FloatBuffer allocateDirect(int size)
	{
		return ByteBuffer.allocateDirect(size * Float.BYTES)
			.order(ByteOrder.nativeOrder())
			.asFloatBuffer();
	}
}
