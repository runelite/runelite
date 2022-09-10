package net.runelite.api.packets;

public interface PacketBufferNode
{
	PacketBuffer getPacketBuffer();

	ClientPacket getClientPacket();

	void send();
}
