package net.runelite.cache.fs;

import java.util.Arrays;

public class File
{
	private Archive archive;
	private int fileId;
	private int nameHash;
	private byte[] contents;

	public File(Archive archive, int fileId)
	{
		this.archive = archive;
		this.fileId = fileId;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 97 * hash + this.fileId;
		hash = 97 * hash + this.nameHash;
		hash = 97 * hash + Arrays.hashCode(this.contents);
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
		final File other = (File) obj;
		if (this.fileId != other.fileId)
		{
			return false;
		}
		if (this.nameHash != other.nameHash)
		{
			return false;
		}
		if (!Arrays.equals(this.contents, other.contents))
		{
			return false;
		}
		return true;
	}

	public Archive getArchive()
	{
		return archive;
	}

	public int getFileId()
	{
		return fileId;
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

	public byte[] getContents()
	{
		return contents;
	}

	public void setContents(byte[] contents)
	{
		this.contents = contents;
	}
	
	public int getSize()
	{
		return contents.length;
	}
}
