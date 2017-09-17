package net.runelite.cache.protocol.packets;

public class HandshakeResponsePacket
{
	private HandshakeResponseType response;

	@Override
	public String toString()
	{
		return "HandshakeResponsePacket{" + "response=" + response + '}';
	}

	public HandshakeResponseType getResponse()
	{
		return response;
	}

	public void setResponse(HandshakeResponseType response)
	{
		this.response = response;
	}
}
