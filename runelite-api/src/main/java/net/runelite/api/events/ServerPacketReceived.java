package net.runelite.api.events;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.packet.PacketSent;
import net.runelite.api.packets.PacketBuffer;
import net.runelite.api.packets.ServerPacket;

import java.util.Arrays;

@Getter
@Setter
public class ServerPacketReceived
{
	private ServerPacket serverPacket;
	private boolean consumed;
	private PacketBuffer packetBuffer;
	private int length;

	public String hexDump()
	{
		byte[] payload = Arrays.copyOfRange(packetBuffer.getPayload(), 0, length);

		return "\n" + PacketSent.hexDump(
				payload,
				0,
				payload.length
		);
	}
}
