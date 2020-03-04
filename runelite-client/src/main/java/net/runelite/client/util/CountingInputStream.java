/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntConsumer;

public class CountingInputStream extends FilterInputStream
{
	private final IntConsumer changed;

	public CountingInputStream(InputStream in, IntConsumer changed)
	{
		super(in);
		this.changed = changed;
	}

	private int read = 0;

	@Override
	public int read(byte[] b, int off, int len) throws IOException
	{
		int thisRead = super.read(b, off, len);
		if (thisRead > 0)
		{
			this.read += thisRead;
		}
		changed.accept(this.read);
		return thisRead;
	}

	@Override
	public int read() throws IOException
	{
		int val = super.read();
		if (val != -1)
		{
			this.read++;
		}
		return val;
	}

	@Override
	public long skip(long n) throws IOException
	{
		long thisRead = in.skip(n);
		this.read += thisRead;
		changed.accept(this.read);
		return thisRead;
	}

	@Override
	public boolean markSupported()
	{
		return false;
	}
}
