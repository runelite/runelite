package net.runelite.cache.protocol.packets;

public class HandshakePacket
{
	private HandshakeType type;
	private int revision;

	@Override
	public String toString()
	{
		return "HandshakePacket{" + "type=" + type + ", revision=" + revision + '}';
	}

	public HandshakeType getType()
	{
		return type;
	}

	public void setType(HandshakeType type)
	{
		this.type = type;
	}

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}
}
