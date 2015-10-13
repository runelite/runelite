package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataFile implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(DataFile.class);
	
	private static final int SECTOR_SIZE = 520;
	
	private final int datafileId;
	private final RandomAccessFile dat;
	private final byte[] readCachedBuffer = new byte[SECTOR_SIZE];
	
	public DataFile(int id, File file) throws FileNotFoundException
	{
		this.datafileId = id;
		dat = new RandomAccessFile(file, "rw");
	}
	
	@Override
	public void close() throws IOException
	{
		dat.close();
	}
	
	/**
	 * 
	 * @param archiveId
	 * @param sector sector to start reading at
	 * @param size expected size of file
	 * @return
	 * @throws IOException 
	 */
	public synchronized ByteBuffer read(int archiveId, int sector, int size) throws IOException
	{
		if (sector <= 0L || dat.length() / 520L < (long) sector)
		{
			logger.warn("bad read, dat length {}", dat.length());
			return null;
		}
		
		ByteBuffer buffer = ByteBuffer.allocate(size);
		
		for (int part = 0, readBytesCount = 0, nextSector;
			size > readBytesCount;
			sector = nextSector)
		{
			if (sector == 0)
			{
				return null;
			}

			dat.seek(SECTOR_SIZE * sector);
			
			int dataBlockSize = size - readBytesCount;
			byte headerSize;
			int currentIndex;
			int currentPart;
			int currentArchive;
			if (0xFFFF < archiveId)
			{
				headerSize = 10;
				if (dataBlockSize > 510)
				{
					dataBlockSize = 510;
				}

				int i = dat.read(this.readCachedBuffer, 0, headerSize + dataBlockSize);
				if (i != headerSize + dataBlockSize)
				{
					logger.warn("short read");
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
				if (dataBlockSize > 512)
				{
					dataBlockSize = 512;
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

			if (archiveId != currentArchive || currentPart != part || this.datafileId != currentIndex)
			{
				return null;
			}

			if (nextSector < 0 || dat.length() / 520L < (long) nextSector)
			{
				return null;
			}

			buffer.put(readCachedBuffer, headerSize, dataBlockSize);
			readBytesCount += dataBlockSize;

			++part;
		}

		return buffer;
	}
	
	/**
	 * 
	 * @param archiveId archive to write to
	 * @param data data to write
	 * @return the sector the data starts at
	 * @throws IOException 
	 */
	public synchronized int write(int archiveId, ByteBuffer data) throws IOException
	{
		int sector;
		int startSector;
		
		sector = (int) ((this.dat.length() + 519L) / 520L);
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
				nextSector = (int) ((dat.length() + 519L) / 520L);
				if (nextSector == 0)
				{
					++nextSector;
				}

				if (nextSector == sector)
				{
					++nextSector;
				}
			}

			if (data.remaining() <= 512)
			{
				nextSector = 0;
			}

			if (0xFFFF < archiveId)
			{
				this.readCachedBuffer[0] = (byte) (archiveId >> 24);
				this.readCachedBuffer[1] = (byte) (archiveId >> 16);
				this.readCachedBuffer[2] = (byte) (archiveId >> 8);
				this.readCachedBuffer[3] = (byte) archiveId;
				this.readCachedBuffer[4] = (byte) (part >> 8);
				this.readCachedBuffer[5] = (byte) part;
				this.readCachedBuffer[6] = (byte) (nextSector >> 16);
				this.readCachedBuffer[7] = (byte) (nextSector >> 8);
				this.readCachedBuffer[8] = (byte) nextSector;
				this.readCachedBuffer[9] = (byte) this.datafileId;
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
				this.readCachedBuffer[0] = (byte) (archiveId >> 8);
				this.readCachedBuffer[1] = (byte) archiveId;
				this.readCachedBuffer[2] = (byte) (part >> 8);
				this.readCachedBuffer[3] = (byte) part;
				this.readCachedBuffer[4] = (byte) (nextSector >> 16);
				this.readCachedBuffer[5] = (byte) (nextSector >> 8);
				this.readCachedBuffer[6] = (byte) nextSector;
				this.readCachedBuffer[7] = (byte) this.datafileId;
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
		
		return startSector;
	}
}
