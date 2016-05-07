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

package net.runelite.cache.fs.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import net.runelite.cache.io.Stream;

public class GZip {
	private static final Inflater inflaterInstance = new Inflater(true);

//	public static final byte[] compress(byte[] data)
//	{
//		ByteArrayOutputStream compressedBytes = new ByteArrayOutputStream();
//
//		try
//		{
//			GZIPOutputStream e = new GZIPOutputStream(compressedBytes);
//			e.write(data);
//			e.finish();
//			e.close();
//			return compressedBytes.toByteArray();
//		}
//		catch (IOException var3)
//		{
//			var3.printStackTrace();
//			return null;
//		}
//	}

	public static final void decompress(Stream stream, byte[] data)
	{
		Inflater var2 = inflaterInstance;
		synchronized (inflaterInstance)
		{
			if (stream.getBuffer()[stream.getOffset()] == 31 && stream.getBuffer()[stream.getOffset() + 1] == -117)
			{
				try
				{
					inflaterInstance.setInput(stream.getBuffer(), stream.getOffset() + 10, -stream.getOffset() - 18 + stream.getBuffer().length);
					inflaterInstance.inflate(data);
				}
				catch (Exception var4)
				{
					inflaterInstance.reset();
					data = (byte[]) null;
				}

				inflaterInstance.reset();
			}
			else
			{
				data = (byte[]) null;
			}
		}
	}
}
