package net.runelite.cache.protocol.packets;

public class ArchiveResponsePacket
{
	private int index;
	private int archive;
	private byte[] data;

	@Override
	public String toString()
	{
		return "ArchiveResponsePacket{" + "index=" + index + ", archive=" + archive + ", data=" + data + '}';
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getArchive()
	{
		return archive;
	}

	public void setArchive(int archive)
	{
		this.archive = archive;
	}

	public byte[] getData()
	{
		return data;
	}

	public void setData(byte[] data)
	{
		this.data = data;
	}
}
