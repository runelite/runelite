package net.runelite.cache.protocol.packets;

public enum HandshakeType
{
	ON_DEMAND(15);

	private final byte value;

	private HandshakeType(int value)
	{
		this.value = (byte) value;
	}

	public byte getValue()
	{
		return value;
	}

	public static HandshakeType of(byte value)
	{
		for (HandshakeType type : values())
		{
			if (type.value == value)
			{
				return type;
			}
		}
		return null;
	}
}
