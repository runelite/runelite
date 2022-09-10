package net.runelite.api.packets;

public interface PacketWriter
{
	void queuePacket(PacketBufferNode packet);

	IsaacCipher getIsaacCipher();

	ServerPacket getServerPacket();

	PacketBuffer getPacketBuffer();
}
