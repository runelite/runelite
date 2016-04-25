package net.runelite.cache.fs;

import java.util.Objects;

public class IndexEntry
{
	private final IndexFile indexFile;
	private final int id, sector, length;

	public IndexEntry(IndexFile indexFile, int id, int sector, int length)
	{
		this.indexFile = indexFile;
		this.id = id;
		this.sector = sector;
		this.length = length;
	}

	public IndexFile getIndexFile()
	{
		return indexFile;
	}

	public int getId()
	{
		return id;
	}

	public int getSector()
	{
		return sector;
	}

	public int getLength()
	{
		return length;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 19 * hash + Objects.hashCode(this.indexFile);
		hash = 19 * hash + this.id;
		hash = 19 * hash + this.sector;
		hash = 19 * hash + this.length;
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
		final IndexEntry other = (IndexEntry) obj;
		if (!Objects.equals(this.indexFile, other.indexFile))
		{
			return false;
		}
		if (this.id != other.id)
		{
			return false;
		}
		if (this.sector != other.sector)
		{
			return false;
		}
		if (this.length != other.length)
		{
			return false;
		}
		return true;
	}
}
