package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndexFile implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(IndexFile.class);
	private static final int INDEX_ENTRY_LEN = 6;
	
	private final Store store;
	private final int indexFileId;
	private final File file;
	private final RandomAccessFile idx;
	private final byte[] buffer = new byte[6];
	
	public IndexFile(Store store, int indexFileId, File file) throws FileNotFoundException
	{
		this.store = store;
		this.indexFileId = indexFileId;
		this.file = file;
		this.idx = new RandomAccessFile(file, "rw");
	}
	
	@Override
	public void close() throws IOException
	{
		idx.close();
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 41 * hash + Objects.hashCode(this.file);
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
		final IndexFile other = (IndexFile) obj;
		if (!Objects.equals(this.file, other.file))
		{
			return false;
		}
		return true;
	}

	public Store getStore()
	{
		return store;
	}

	public int getIndexFileId()
	{
		return indexFileId;
	}
	
	public synchronized void write(IndexEntry entry) throws IOException
	{
		idx.seek(entry.getId() * INDEX_ENTRY_LEN);
		
		buffer[0] = (byte) (entry.getLength() >> 16);
		buffer[1] = (byte) (entry.getLength() >> 8);
		buffer[2] = (byte) entry.getLength();
		
		buffer[3] = (byte) (entry.getSector() >> 16);
		buffer[4] = (byte) (entry.getSector() >> 8);
		buffer[5] = (byte) entry.getSector();
		
		idx.write(buffer);
	}
	
	public synchronized IndexEntry read(int id) throws IOException
	{
		idx.seek(id * INDEX_ENTRY_LEN);
		int i = idx.read(buffer);
		if (i != INDEX_ENTRY_LEN)
		{
			logger.warn("short read for id {}: {}", id, i);
			return null;
		}
		
		int length = ((buffer[0] & 0xFF) << 16) | ((buffer[1] & 0xFF) << 8) | (buffer[2] & 0xFF);
		int sector = ((buffer[3] & 0xFF) << 16) | ((buffer[4] & 0xFF) << 8) | (buffer[5] & 0xFF);
		
		if (length <= 0 || sector <= 0)
		{
			logger.debug("invalid length or sector {}/{}", length, sector);
			return null;
		}
		
		return new IndexEntry(this, id, sector, length);
	}
	
	public synchronized int getIndexCount() throws IOException
	{
		return (int)(idx.length() / INDEX_ENTRY_LEN);
	}
}
