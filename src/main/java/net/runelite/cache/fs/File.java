package net.runelite.cache.fs;

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
}
