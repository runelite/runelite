/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.transformers.buffer;

import java.io.UnsupportedEncodingException;

/**
 * Methods injected into runescape-client's Buffer
 *
 * @author Adam
 */
public class RuneliteBuffer
{
	// so that it compiles
	private int offset;
	private byte[] payload;
	private int runeliteLengthOffset;

	public int getOffset()
	{
		return offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public byte[] getPayload()
	{
		return payload;
	}

	public void setPayload(byte[] payload)
	{
		this.payload = payload;
	}

	public int getRuneliteLengthOffset()
	{
		return runeliteLengthOffset;
	}

	public void setRuneliteLengthOffset(int runeliteLengthOffset)
	{
		this.runeliteLengthOffset = runeliteLengthOffset;
	}

	public byte runeliteReadByte()
	{
		offset += 1;
		return payload[offset - 1];
	}

	public short runeliteReadShort()
	{
		offset += 2;
		return (short) (((payload[offset - 2] & 0xFF) << 8)
			| (payload[offset - 1] & 0xFF));
	}

	public int runeliteReadInt()
	{
		offset += 4;
		return ((payload[offset - 4] & 0xFF) << 24)
			| ((payload[offset - 3] & 0xFF) << 16)
			| ((payload[offset - 2] & 0xFF) << 8)
			| (payload[offset - 1] & 0xFF);
	}

	public long runeliteReadLong()
	{
		offset += 8;
		return ((payload[offset - 8] & 0xFFL) << 56)
			| ((payload[offset - 7] & 0xFFL) << 48)
			| ((payload[offset - 6] & 0xFFL) << 40)
			| ((payload[offset - 5] & 0xFFL) << 32)
			| ((payload[offset - 4] & 0xFFL) << 24)
			| ((payload[offset - 3] & 0xFFL) << 16)
			| ((payload[offset - 2] & 0xFFL) << 8)
			| (payload[offset - 1] & 0xFFL);
	}

	public String runeliteReadString()
	{
		int length = runeliteReadShort();
		if (length < 0)
		{
			throw new RuntimeException("length < 0");
		}

		offset += length;
		try
		{
			return new String(payload, offset - length, length, "UTF-8");
		}
		catch (UnsupportedEncodingException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public void runeliteWriteByte(byte b)
	{
		payload[offset++] = b;
	}

	public void runeliteWriteShort(short s)
	{
		payload[offset++] = (byte) (s >> 8);
		payload[offset++] = (byte) s;
	}

	public void runeliteWriteInt(int i)
	{
		payload[offset++] = (byte) (i >> 24);
		payload[offset++] = (byte) (i >> 16);
		payload[offset++] = (byte) (i >> 8);
		payload[offset++] = (byte) i;
	}

	public void runeliteWriteLong(long l)
	{
		payload[offset++] = (byte) (l >> 56);
		payload[offset++] = (byte) (l >> 48);
		payload[offset++] = (byte) (l >> 40);
		payload[offset++] = (byte) (l >> 32);
		payload[offset++] = (byte) (l >> 24);
		payload[offset++] = (byte) (l >> 16);
		payload[offset++] = (byte) (l >> 8);
		payload[offset++] = (byte) l;
	}

	public void runeliteWriteString(String s)
	{
		byte[] bytes;

		try
		{
			bytes = s.getBytes("UTF-8");
		}
		catch (UnsupportedEncodingException ex)
		{
			throw new RuntimeException(ex);
		}

		runeliteWriteShort((short) bytes.length);
		for (byte b : bytes)
		{
			payload[offset++] = b;
		}
	}

	public void runeliteInitPacket()
	{
		runeliteLengthOffset = offset;
		runeliteWriteShort((short) 0); // flush() relies on default length of 0
	}

	public void runeliteFinishPacket()
	{
		if (runeliteLengthOffset > 0)
		{
			int length = offset - runeliteLengthOffset - 2;
			if (length < 0)
			{
				// on flush() it sets offset = 0
				// but runeliteLengthOffset remains >0
				return;
			}
			payload[runeliteLengthOffset++] = (byte) (length >> 8);
			payload[runeliteLengthOffset++] = (byte) length;
			runeliteLengthOffset = 0;
		}
	}
}
