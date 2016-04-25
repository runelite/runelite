package net.runelite.cache.fs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.io.InputStream;

public class Archive
{
	private Index index; // member of this index
	private int archiveId;
	private int nameHash;
	private byte[] whirlpool;
	private int crc;
	private int revision;
	private List<File> files = new ArrayList<>();
	
	public Archive(Index index, int id)
	{
		this.index = index;
		this.archiveId = id;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 47 * hash + this.archiveId;
		hash = 47 * hash + this.nameHash;
		hash = 47 * hash + Arrays.hashCode(this.whirlpool);
		hash = 47 * hash + this.crc;
		hash = 47 * hash + this.revision;
		hash = 47 * hash + Objects.hashCode(this.files);
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
		final Archive other = (Archive) obj;
		if (this.archiveId != other.archiveId)
		{
			return false;
		}
		if (this.nameHash != other.nameHash)
		{
			return false;
		}
		if (this.whirlpool != null && other.whirlpool != null && !Arrays.equals(this.whirlpool, other.whirlpool))
		{
			return false;
		}
		if (this.crc != other.crc)
		{
			return false;
		}
		if (this.revision != other.revision)
		{
			return false;
		}
		if (!Objects.equals(this.files, other.files))
		{
			return false;
		}
		return true;
	}
	
	public File addFile(int id)
	{
		File file = new File(this, id);
		this.files.add(file);
		return file;
	}
	
	public void load(InputStream stream, int numberOfFiles, int protocol)
	{
		int archive = 0;
		
		for (int i = 0; i < numberOfFiles; ++i)
		{
			int fileId = archive += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();

			File file = new File(this, fileId);
			this.files.add(file);
		}
	}
	
	public void loadNames(InputStream stream, int numberOfFiles)
	{
		for (int i = 0; i < numberOfFiles; ++i)
		{
			File file = this.files.get(i);
			int name = stream.readInt();
			file.setNameHash(name);
		}
	}

	public int getArchiveId()
	{
		return archiveId;
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

	public byte[] getWhirlpool()
	{
		return whirlpool;
	}

	public void setWhirlpool(byte[] whirlpool)
	{
		this.whirlpool = whirlpool;
	}

	public int getCrc()
	{
		return crc;
	}

	public void setCrc(int crc)
	{
		this.crc = crc;
	}

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}

	public List<File> getFiles()
	{
		return files;
	}
}
