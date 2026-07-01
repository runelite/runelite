/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.util;

import com.sun.jna.Memory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import static net.runelite.cache.util.LibBZip2.BZ_FINISH_OK;
import static net.runelite.cache.util.LibBZip2.BZ_OK;
import static net.runelite.cache.util.LibBZip2.BZ_STREAM_END;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

public class BZip2
{
	private static final boolean USE_NATIVE_BZIP2 = "true".equalsIgnoreCase(System.getProperty("runelite.useNativeBzip"));

	private static final byte[] BZIP_HEADER = new byte[]
	{
		'B', 'Z', // magic
		'h',      // 'h' for Bzip2 ('H'uffman coding)
		'1'       // block size
	};

	public static byte[] compress(byte[] bytes) throws IOException
	{
		return USE_NATIVE_BZIP2 ? compressLibBZip2(bytes) : compressApache(bytes);
	}

	public static byte[] compressApache(byte[] bytes) throws IOException
	{
		InputStream is = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try (OutputStream os = new BZip2CompressorOutputStream(bout, 1))
		{
			is.transferTo(os);
		}

		byte[] out = bout.toByteArray();

		assert BZIP_HEADER[0] == out[0];
		assert BZIP_HEADER[1] == out[1];
		assert BZIP_HEADER[2] == out[2];
		assert BZIP_HEADER[3] == out[3];

		return Arrays.copyOfRange(out, BZIP_HEADER.length, out.length); // remove header..
	}

	// byte-for-byte compatibility with Jagex's compression
	public static byte[] compressLibBZip2(byte[] data) throws IOException
	{
		LibBZip2 libBZip2 = LibBZip2.INSTANCE;

		BzStream stream = new BzStream();
		stream.next_in = new Memory(data.length);
		stream.avail_in = data.length;
		stream.next_in.write(0, data, 0, data.length);

		int outsz = 65536;
		Memory out = new Memory(outsz);
		stream.next_out = out;
		stream.avail_out = outsz;

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		if (libBZip2.BZ2_bzCompressInit(stream, 1, 0, 0) != BZ_OK)
		{
			throw new IOException("BZ2_bzCompressInit() error");
		}
		try
		{
			int offset = BZIP_HEADER.length;
			int i;
			do
			{
				i = libBZip2.BZ2_bzCompress(stream, LibBZip2.BZ_FINISH);
				if (i == BZ_FINISH_OK || i == BZ_STREAM_END)
				{
					int wrote = outsz - stream.avail_out;
					buffer.write(out.getByteArray(offset, wrote - offset));
					offset = 0;
					stream.next_out = out;
					stream.avail_out = outsz;
				}
				else
				{
					throw new IOException("BZ2_bzCompress() error");
				}
			} while (i != BZ_STREAM_END);
		}
		finally
		{
			if (libBZip2.BZ2_bzCompressEnd(stream) != BZ_OK)
			{
				throw new IOException("BZ2_bzCompressEnd() error");
			}
		}

		return buffer.toByteArray();
	}

	public static byte[] decompress(byte[] bytes, int len) throws IOException
	{
		byte[] data = new byte[len + BZIP_HEADER.length];

		// add header
		System.arraycopy(BZIP_HEADER, 0, data, 0, BZIP_HEADER.length);
		System.arraycopy(bytes, 0, data, BZIP_HEADER.length, len);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try (InputStream is = new BZip2CompressorInputStream(new ByteArrayInputStream(data)))
		{
			is.transferTo(os);
		}

		return os.toByteArray();
	}
}
