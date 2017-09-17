package net.runelite.cache.protocol.packets;

public class ArchiveRequestPacket
{
	private boolean priority;
	private int index;
	private int archive;

	@Override
	public String toString()
	{
		return "ArchiveRequestPacket{" + "priority=" + priority + ", index=" + index + ", archive=" + archive + '}';
	}

	public boolean isPriority()
	{
		return priority;
	}

	public void setPriority(boolean priority)
	{
		this.priority = priority;
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
}
