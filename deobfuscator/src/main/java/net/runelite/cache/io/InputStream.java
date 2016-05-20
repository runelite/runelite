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

public final class InputStream extends Stream
{
	private static final char[] CHARACTERS = new char[]
	{
		'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026',
		'\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039',
		'\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018',
		'\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014',
		'\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000',
		'\u017e', '\u0178'
	};

	public InputStream(int capacity)
	{
		this.buffer = new byte[capacity];
	}

	public InputStream(byte[] buffer)
	{
		this.buffer = buffer;
		this.length = buffer.length;
	}

	public void checkCapacity(int length)
	{
		if (this.offset + length >= this.buffer.length)
		{
			byte[] newBuffer = new byte[(this.offset + length) * 2];
			System.arraycopy(this.buffer, 0, newBuffer, 0, this.buffer.length);
			this.buffer = newBuffer;
		}

	}

	public int read24BitInt()
	{
		return (this.readUnsignedByte() << 16) + (this.readUnsignedByte() << 8) + this.readUnsignedByte();
	}

	public void skip(int length)
	{
		this.offset += length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public int getRemaining()
	{
		return this.offset < this.length ? this.length - this.offset : 0;
	}

	public int readByte()
	{
		return this.getRemaining() > 0 ? this.buffer[this.offset++] : 0;
	}

	public void readBytes(byte[] buffer, int off, int len)
	{
		for (int k = off; k < len + off; ++k)
		{
			buffer[k] = (byte) this.readByte();
		}

	}

	public void readBytes(byte[] buffer)
	{
		this.readBytes(buffer, 0, buffer.length);
	}

	public int readUnsignedByte()
	{
		return this.readByte() & 255;
	}

	public int readUnsignedShort()
	{
		return (this.readUnsignedByte() << 8) + this.readUnsignedByte();
	}

	public int readInt()
	{
		return (this.readUnsignedByte() << 24) + (this.readUnsignedByte() << 16) + (this.readUnsignedByte() << 8) + this.readUnsignedByte();
	}

	public int readBigSmart()
	{
		return this.buffer[this.offset] >= 0 ? this.readUnsignedShort() : Integer.MAX_VALUE & this.readInt();
	}

	public String readString()
	{
		int startIdx = this.getOffset();

		while (this.readByte() != 0)
		{
			;
		}

		int length = this.getOffset() - startIdx - 1;
		return length == 0 ? "" : readString(this.getBuffer(), startIdx, length);
	}

	private static String readString(byte[] buffer, int startIdx, int length)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; ++i)
		{
			int ch = buffer[startIdx + i] & 255;
			if (ch != 0)
			{
				if (ch >= 128 && ch < 160)
				{
					char var7 = CHARACTERS[ch - 128];
					if (0 == var7)
					{
						var7 = 63;
					}

					ch = var7;
				}

				sb.append((char) ch);
			}
		}

		return sb.toString();
	}
}
