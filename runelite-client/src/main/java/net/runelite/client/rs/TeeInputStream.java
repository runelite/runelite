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
package net.runelite.client.rs;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.Getter;
import lombok.Setter;

class TeeInputStream extends FilterInputStream
{
	@Getter
	@Setter
	private OutputStream out;

	TeeInputStream(InputStream in)
	{
		super(in);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException
	{
		int thisRead = super.read(b, off, len);

		if (thisRead > 0)
		{
			out.write(b, off, thisRead);
		}

		return thisRead;
	}

	@Override
	public int read() throws IOException
	{
		int val = super.read();
		if (val != -1)
		{
			out.write(val);
		}
		return val;
	}

	@Override
	public long skip(long n) throws IOException
	{
		byte[] buf = new byte[(int) Math.min(n, 0x4000)];
		long total = 0;
		while (n > 0)
		{
			int read = (int) Math.min(n, buf.length);

			read = read(buf, 0, read);
			if (read == -1)
			{
				break;
			}

			total += read;
			n -= read;
		}
		return total;
	}

	@Override
	public boolean markSupported()
	{
		return false;
	}
}
