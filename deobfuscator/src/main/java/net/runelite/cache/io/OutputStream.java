/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache.io;

public final class OutputStream extends Stream
{
	public OutputStream(int capacity)
	{
		this.setBuffer(new byte[capacity]);
	}

	public OutputStream()
	{
		this.setBuffer(new byte[16]);
	}

	public OutputStream(byte[] buffer)
	{
		this.setBuffer(buffer);
		this.offset = buffer.length;
		this.length = buffer.length;
	}

	public OutputStream(int[] buffer)
	{
		this.setBuffer(new byte[buffer.length]);
		int[] var5 = buffer;
		int var4 = buffer.length;

		for (int var3 = 0; var3 < var4; ++var3)
		{
			int value = var5[var3];
			this.writeByte(value);
		}

	}

	public void checkCapacityPosition(int position)
	{
		if (position >= this.getBuffer().length)
		{
			byte[] newBuffer = new byte[position + 16];
			System.arraycopy(this.getBuffer(), 0, newBuffer, 0, this.getBuffer().length);
			this.setBuffer(newBuffer);
		}

	}

	public void skip(int length)
	{
		this.setOffset(this.getOffset() + length);
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public void writeBytes(byte[] b, int offset, int length)
	{
		this.checkCapacityPosition(this.getOffset() + length - offset);
		System.arraycopy(b, offset, this.getBuffer(), this.getOffset(), length);
		this.setOffset(this.getOffset() + (length - offset));
	}

	public void writeBytes(byte[] b)
	{
		byte offset = 0;
		int length = b.length;
		this.checkCapacityPosition(this.getOffset() + length - offset);
		System.arraycopy(b, offset, this.getBuffer(), this.getOffset(), length);
		this.setOffset(this.getOffset() + (length - offset));
	}

	public void writeByte(int i)
	{
		this.writeByte(i, this.offset++);
	}

	public void writeByte(int i, int position)
	{
		this.checkCapacityPosition(position);
		this.getBuffer()[position] = (byte) i;
	}

	public void writeBigSmart(int value)
	{
		if (value >= 65536)
		{
			this.writeByte(-1);
			this.writeInt(Integer.MAX_VALUE & value);
		}
		else
		{
			this.writeShort(value);
		}
	}

	public void writeShort(int i)
	{
		this.writeByte(i >> 8);
		this.writeByte(i);
	}

	public void writeInt(int i)
	{
		this.writeByte(i >> 24);
		this.writeByte(i >> 16);
		this.writeByte(i >> 8);
		this.writeByte(i);
	}

	public void setBuffer(byte[] buffer)
	{
		this.buffer = buffer;
	}

}
