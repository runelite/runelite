package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Objects;
import net.runelite.cache.fs.io.InputStream;
import net.runelite.cache.fs.io.OutputStream;
import net.runelite.cache.fs.util.BZip2Decompressor;
import net.runelite.cache.fs.util.GZip;
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

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 71 * hash + Objects.hashCode(this.file);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final DataFile other = (DataFile) obj;
		if (!Objects.equals(this.file, other.file))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param indexId
	 * @param archiveId
	 * @param sector sector to start reading at
	 * @param size expected size of file
	 * @return
	 * @throws IOException 
	 */
	public synchronized DataFileReadResult read(int indexId, int archiveId, int sector, int size) throws IOException
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
				return null;
			}

			if (nextSector < 0 || dat.length() / SECTOR_SIZE < (long) nextSector)
			{
				return null;
			}

			buffer.put(readCachedBuffer, headerSize, dataBlockSize);
			readBytesCount += dataBlockSize;

			++part;
		}

		buffer.flip();
				
		//XTEA decrypt here?
		
		return this.decompress(buffer.array());
	}
	
	/**
	 * 
	 * @param indexId
	 * @param archiveId archive to write to
	 * @param data data to write
	 * @return the sector the data starts at
	 * @throws IOException 
	 */
	public synchronized DataFileWriteResult write(int indexId, int archiveId, ByteBuffer data, int compression, int revision) throws IOException
	{
		int sector;
		int startSector;
		
		data = ByteBuffer.wrap(this.compress(data.array(), compression, revision));
		int dataLen = data.remaining();
		
		//XTEA encrypt here?
		
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
		res.compressedLength = dataLen;
		return res;
	}
	
	private DataFileReadResult decompress(byte[] b)
	{
		InputStream stream = new InputStream(b);
		
		int compression = stream.readUnsignedByte();
		int compressedLength = stream.readInt();
		if (compressedLength < 0 || compressedLength > 1000000)
			throw new RuntimeException("Invalid data");
		
		byte[] data;
		int revision;
		switch (compression)
		{
			case 0:
				data = new byte[compressedLength];
				revision = this.checkRevision(stream, compressedLength);
				stream.readBytes(data, 0, compressedLength);
				break;
			case 1:
			{
				int length = stream.readInt();
				data = new byte[length];
				revision = this.checkRevision(stream, compressedLength);
				BZipDecompressor.decompress(data, b, compressedLength, 9);
				break;
			}
			default:
			{
				int length = stream.readInt();
				data = new byte[length];
				revision = this.checkRevision(stream, compressedLength);
				GZip.decompress(stream, data);
			}
		}
		
		DataFileReadResult res = new DataFileReadResult();
		res.data = data;
		res.revision = revision;
		return res;
	}
	
	private byte[] compress(byte[] data, int compression, int revision)
	{
		OutputStream stream = new OutputStream();
		stream.writeByte(compression);
		byte[] compressedData;
		switch (compression)
		{
			case 0:
				compressedData = data;
				stream.writeInt(data.length);
				break;
			case 1:
				compressedData = (byte[]) null;
				break;
			default:
				compressedData = GZip.compress(data);
				stream.writeInt(compressedData.length);
				stream.writeInt(data.length);
		}

		stream.writeBytes(compressedData);
		stream.writeShort(revision);
		
		byte[] compressed = new byte[stream.getOffset()];
		stream.setOffset(0);
		stream.getBytes(compressed, 0, compressed.length);
		return compressed;
	}
	
	private int checkRevision(InputStream stream, int compressedLength)
	{
		int offset = stream.getOffset();
		int revision;
		if (stream.getLength() - (compressedLength + stream.getOffset()) >= 2)
		{
			stream.setOffset(stream.getLength() - 2);
			revision = stream.readUnsignedShort();
			stream.setOffset(offset);
		}
		else
		{
			revision = -1;
		}
		return revision;
	}
}
