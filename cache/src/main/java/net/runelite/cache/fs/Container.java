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
package net.runelite.cache.fs;

import static com.google.common.primitives.Bytes.concat;
import com.google.common.primitives.Ints;
import java.io.IOException;
import net.runelite.cache.fs.jagex.CompressionType;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;
import net.runelite.cache.util.BZip2;
import net.runelite.cache.util.Crc32;
import net.runelite.cache.util.GZip;
import net.runelite.cache.util.Xtea;

public class Container
{
	public byte[] data;
	public int compression; // compression
	public int revision;
	public int crc; // crc of compressed data

	public Container(int compression, int revision)
	{
		this.compression = compression;
		this.revision = revision;
	}

	public void compress(byte[] data, int[] keys) throws IOException
	{
		OutputStream stream = new OutputStream();

		byte[] compressedData;
		int length;
		switch (compression)
		{
			case CompressionType.NONE:
				compressedData = data;
				length = compressedData.length;
				break;
			case CompressionType.BZ2:
				compressedData = concat(Ints.toByteArray(data.length), BZip2.compress(data));
				length = compressedData.length - 4;
				break;
			case CompressionType.GZ:
				compressedData = concat(Ints.toByteArray(data.length), GZip.compress(data));
				length = compressedData.length - 4;
				break;
			default:
				throw new RuntimeException("Unknown compression type");
		}

		compressedData = encrypt(compressedData, compressedData.length, keys);

		stream.writeByte(compression);
		stream.writeInt(length);

		stream.writeBytes(compressedData);
		if (revision != -1)
		{
			stream.writeShort(revision);
		}

		this.data = stream.flip();

		Crc32 crc32 = new Crc32();
		crc32.update(this.data, 0, this.data.length - (revision != -1 ? 2 : 0));
		this.crc = crc32.getHash();
	}

	public static Container decompress(byte[] b, int[] keys) throws IOException
	{
		InputStream stream = new InputStream(b);

		int compression = stream.readUnsignedByte();
		int compressedLength = stream.readInt();
		if (compressedLength < 0)
		{
			throw new RuntimeException("Invalid data");
		}

		Crc32 crc32 = new Crc32();
		crc32.update(b, 0, 5); // compression + length

		byte[] data;
		int revision = -1;
		switch (compression)
		{
			case CompressionType.NONE:
			{
				byte[] encryptedData = new byte[compressedLength];
				stream.readBytes(encryptedData, 0, compressedLength);

				crc32.update(encryptedData, 0, compressedLength);
				byte[] decryptedData = decrypt(encryptedData, encryptedData.length, keys);

				if (stream.remaining() >= 2)
				{
					revision = stream.readUnsignedShort();
					assert revision != -1;
				}

				data = decryptedData;

				break;
			}
			case CompressionType.BZ2:
			{
				byte[] encryptedData = new byte[compressedLength + 4];
				stream.readBytes(encryptedData);

				crc32.update(encryptedData, 0, encryptedData.length);
				byte[] decryptedData = decrypt(encryptedData, encryptedData.length, keys);

				if (stream.remaining() >= 2)
				{
					revision = stream.readUnsignedShort();
					assert revision != -1;
				}

				stream = new InputStream(decryptedData);

				int decompressedLength = stream.readInt();
				data = BZip2.decompress(stream.getRemaining(), compressedLength);
				assert data.length == decompressedLength;

				break;
			}
			case CompressionType.GZ:
			{
				byte[] encryptedData = new byte[compressedLength + 4];
				stream.readBytes(encryptedData);

				crc32.update(encryptedData, 0, encryptedData.length);
				byte[] decryptedData = decrypt(encryptedData, encryptedData.length, keys);

				if (stream.remaining() >= 2)
				{
					revision = stream.readUnsignedShort();
					assert revision != -1;
				}

				stream = new InputStream(decryptedData);

				int decompressedLength = stream.readInt();
				data = GZip.decompress(stream.getRemaining(), compressedLength);
				assert data.length == decompressedLength;

				break;
			}
			default:
				throw new RuntimeException("Unknown decompression type");
		}

		Container container = new Container(compression, revision);
		container.data = data;
		container.crc = crc32.getHash();
		return container;
	}

	private static byte[] decrypt(byte[] data, int length, int[] keys)
	{
		if (keys == null)
		{
			return data;
		}

		Xtea xtea = new Xtea(keys);
		return xtea.decrypt(data, length);
	}

	private static byte[] encrypt(byte[] data, int length, int[] keys)
	{
		if (keys == null)
		{
			return data;
		}

		Xtea xtea = new Xtea(keys);
		return xtea.encrypt(data, length);
	}
}
