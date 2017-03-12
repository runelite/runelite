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

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import net.runelite.cache.util.BZip2;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;
import net.runelite.cache.util.Crc32;
import net.runelite.cache.util.GZip;
import net.runelite.cache.util.Whirlpool;
import net.runelite.cache.util.Xtea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataFile implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(DataFile.class);
	
	private static final int SECTOR_SIZE = 520;
	
	private final Store store;
	private final File file;
	private final RandomAccessFile dat;
	private final byte[] readCachedBuffer = new byte[SECTOR_SIZE];
	
	public DataFile(Store store, File file) throws FileNotFoundException
	{
		this.file = file;
		this.store = store;
		dat = new RandomAccessFile(file, "rw");
	}
	
	@Override
	public void close() throws IOException
	{
		dat.close();
	}
	
	public void clear() throws IOException
	{
		dat.setLength(0L);
	}

	/**
	 * 
	 * @param indexId expected index of archive of contents being read
	 * @param archiveId expected archive of contents being read
	 * @param sector sector to start reading at
	 * @param size size of file
	 * @return
	 * @throws IOException 
	 */
	public synchronized byte[] read(int indexId, int archiveId, int sector, int size) throws IOException
	{
		if (sector <= 0L || dat.length() / SECTOR_SIZE < (long) sector)
		{
			logger.warn("bad read, dat length {}, requested sector {}", dat.length(), sector);
			return null;
		}
		
		ByteBuffer buffer = ByteBuffer.allocate(size);
		
		for (int part = 0, readBytesCount = 0, nextSector;
			size > readBytesCount;
			sector = nextSector)
		{
			if (sector == 0)
			{
				logger.warn("Unexpected end of file");
				return null;
			}

			dat.seek(SECTOR_SIZE * sector);
			
			int dataBlockSize = size - readBytesCount;
			byte headerSize;
			int currentIndex;
			int currentPart;
			int currentArchive;
			if (archiveId > 0xFFFF)
			{
				headerSize = 10;
				if (dataBlockSize > SECTOR_SIZE - headerSize)
				{
					dataBlockSize = SECTOR_SIZE - headerSize;
				}

				int i = dat.read(this.readCachedBuffer, 0, headerSize + dataBlockSize);
				if (i != headerSize + dataBlockSize)
				{
					logger.warn("Short read when reading file data for {}/{}", indexId, archiveId);
					return null;
				}
				
				currentArchive = ((this.readCachedBuffer[1] & 255) << 16) + ((this.readCachedBuffer[0] & 255) << 24) + (('\uff00' & this.readCachedBuffer[2] << 8) - -(this.readCachedBuffer[3] & 255));
				currentPart = ((this.readCachedBuffer[4] & 255) << 8) + (255 & this.readCachedBuffer[5]);
				nextSector = (this.readCachedBuffer[8] & 255) + ('\uff00' & this.readCachedBuffer[7] << 8) + ((255 & this.readCachedBuffer[6]) << 16);
				currentIndex = this.readCachedBuffer[9] & 255;
			}
			else
			{
				headerSize = 8;
				if (dataBlockSize > SECTOR_SIZE - headerSize)
				{
					dataBlockSize = SECTOR_SIZE - headerSize;
				}

				int i = dat.read(this.readCachedBuffer, 0, headerSize + dataBlockSize);
				if (i != headerSize + dataBlockSize)
				{
					logger.warn("short read");
					return null;
				}
				
				currentArchive = (255 & this.readCachedBuffer[1]) + ('\uff00' & this.readCachedBuffer[0] << 8);
				currentPart = ((this.readCachedBuffer[2] & 255) << 8) + (255 & this.readCachedBuffer[3]);
				nextSector = (this.readCachedBuffer[6] & 255) + ('\uff00' & this.readCachedBuffer[5] << 8) + ((255 & this.readCachedBuffer[4]) << 16);
				currentIndex = this.readCachedBuffer[7] & 255;
			}

			if (archiveId != currentArchive || currentPart != part || indexId != currentIndex)
			{
				logger.warn("data mismatch {} != {}, {} != {}, {} != {}",
					archiveId, currentArchive,
					part, currentPart,
					indexId, currentIndex);
				return null;
			}

			if (nextSector < 0 || dat.length() / SECTOR_SIZE < (long) nextSector)
			{
				logger.warn("Invalid next sector");
				return null;
			}

			buffer.put(readCachedBuffer, headerSize, dataBlockSize);
			readBytesCount += dataBlockSize;

			++part;
		}

		buffer.flip();
		return buffer.array();
	}
	
	public synchronized DataFileWriteResult write(int indexId, int archiveId, byte[] compressedData, int revision) throws IOException
	{
		int sector;
		int startSector;

		ByteBuffer data = ByteBuffer.wrap(compressedData);
		
		sector = (int) ((dat.length() + (long) (SECTOR_SIZE - 1)) / (long) SECTOR_SIZE);
		if (sector == 0)
		{
			sector = 1;
		}
		startSector = sector;

		for (int part = 0; data.hasRemaining(); ++part)
		{
			int nextSector = 0;
			int dataToWrite;

			if (nextSector == 0)
			{
				nextSector = (int) ((dat.length() + (long) (SECTOR_SIZE - 1)) / (long) SECTOR_SIZE);
				if (nextSector == 0)
				{
					++nextSector;
				}

				if (nextSector == sector)
				{
					++nextSector;
				}
			}


			if (0xFFFF < archiveId)
			{
				if (data.remaining() <= 510)
				{
					nextSector = 0;
				}
			
				this.readCachedBuffer[0] = (byte) (archiveId >> 24);
				this.readCachedBuffer[1] = (byte) (archiveId >> 16);
				this.readCachedBuffer[2] = (byte) (archiveId >> 8);
				this.readCachedBuffer[3] = (byte) archiveId;
				this.readCachedBuffer[4] = (byte) (part >> 8);
				this.readCachedBuffer[5] = (byte) part;
				this.readCachedBuffer[6] = (byte) (nextSector >> 16);
				this.readCachedBuffer[7] = (byte) (nextSector >> 8);
				this.readCachedBuffer[8] = (byte) nextSector;
				this.readCachedBuffer[9] = (byte) indexId;
				dat.seek(SECTOR_SIZE * sector);
				dat.write(this.readCachedBuffer, 0, 10);
				
				dataToWrite = data.remaining();
				if (dataToWrite > 510)
				{
					dataToWrite = 510;
				}
			}
			else
			{
				if (data.remaining() <= 512)
				{
					nextSector = 0;
				}
			
				this.readCachedBuffer[0] = (byte) (archiveId >> 8);
				this.readCachedBuffer[1] = (byte) archiveId;
				this.readCachedBuffer[2] = (byte) (part >> 8);
				this.readCachedBuffer[3] = (byte) part;
				this.readCachedBuffer[4] = (byte) (nextSector >> 16);
				this.readCachedBuffer[5] = (byte) (nextSector >> 8);
				this.readCachedBuffer[6] = (byte) nextSector;
				this.readCachedBuffer[7] = (byte) indexId;
				dat.seek(SECTOR_SIZE * sector);
				dat.write(this.readCachedBuffer, 0, 8);
				
				dataToWrite = data.remaining();
				if (dataToWrite > 512)
				{
					dataToWrite = 512;
				}
			}

			data.get(readCachedBuffer, 0, dataToWrite);
			dat.write(readCachedBuffer, 0, dataToWrite);
			sector = nextSector;
		}
		
		DataFileWriteResult res = new DataFileWriteResult();
		res.sector = startSector;
		res.compressedLength = compressedData.length;

		int length = revision != -1 ? compressedData.length - 2 : compressedData.length;
		Crc32 crc32 = new Crc32();
		crc32.update(compressedData, 0, length);
		res.crc = crc32.getHash();

		res.whirlpool = Whirlpool.getHash(compressedData, length);
		return res;
	}
	
	public static DataFileReadResult decompress(byte[] b, int[] keys) throws IOException
	{
		InputStream stream = new InputStream(b);
		
		int compression = stream.readUnsignedByte();
		int compressedLength = stream.readInt();
		if (compressedLength < 0 || compressedLength > 1000000)
			throw new RuntimeException("Invalid data");

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

				if (data == null)
				{
					return null;
				}

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

				if (data == null)
				{
					return null;
				}

				assert data.length == decompressedLength;
				
				break;
			}
			default:
				throw new RuntimeException("Unknown decompression type");
		}
		
		DataFileReadResult res = new DataFileReadResult();
		res.data = data;
		res.revision = revision;
		int length = revision != -1 ? b.length - 2 : b.length;
		res.crc = crc32.getHash();
		res.whirlpool = Whirlpool.getHash(b, length);
		res.compression = compression;
		return res;
	}
	
	public static byte[] compress(byte[] data, int compression, int revision, int[] keys) throws IOException
	{
		OutputStream stream = new OutputStream();
		stream.writeByte(compression);
		byte[] compressedData;
		switch (compression)
		{
			case CompressionType.NONE:
				compressedData = data;
				compressedData = encrypt(compressedData, compressedData.length, keys);
				stream.writeInt(data.length);
				break;
			case CompressionType.BZ2:
				compressedData = BZip2.compress(data);
				compressedData = encrypt(compressedData, compressedData.length, keys);

				stream.writeInt(compressedData.length);
				stream.writeInt(data.length);
				break;
			case CompressionType.GZ:
				compressedData = GZip.compress(data);
				compressedData = encrypt(compressedData, compressedData.length, keys);
				
				stream.writeInt(compressedData.length);
				stream.writeInt(data.length);
				break;
			default:
				throw new RuntimeException("Unknown compression type");
		}

		stream.writeBytes(compressedData);
		if (revision != -1)
			stream.writeShort(revision);

		return stream.flip();
	}

	private static byte[] decrypt(byte[] data, int length, int[] keys)
	{
		if (keys == null)
			return data;

		try
		{
			Xtea xtea = new Xtea(keys);
			return xtea.decrypt(data, length);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex)
		{
			logger.warn("unable to xtea decrypt", ex);
			return null;
		}
	}

	private static byte[] encrypt(byte[] data, int length, int[] keys)
	{
		if (keys == null)
			return data;

		try
		{
			Xtea xtea = new Xtea(keys);
			return xtea.encrypt(data, length);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex)
		{
			logger.warn("unable to xtea encrypt", ex);
			return null;
		}
	}
}
