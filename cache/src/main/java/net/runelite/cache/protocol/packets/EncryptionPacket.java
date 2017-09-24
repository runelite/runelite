package net.runelite.cache.protocol.packets;

public class EncryptionPacket
{
	public static final int OPCODE = 4;

	private byte key;

	@Override
	public String toString()
	{
		return "EncryptionPacket{" + "key=" + key + '}';
	}

	public byte getKey()
	{
		return key;
	}

	public void setKey(byte key)
	{
		this.key = key;
	}
}
