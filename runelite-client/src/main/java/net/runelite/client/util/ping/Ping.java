/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util.ping;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;
import net.runelite.http.api.worlds.World;

@Slf4j
public class Ping
{
	private static final String RUNELITE_PING = "RuneLitePing";

	private static final int TIMEOUT = 2000;
	private static final int PORT = 43594;

	public static int ping(World world)
	{
		return ping(world.getAddress());
	}

	public static int ping(String address)
	{
		try
		{
			if (OSType.getOSType() == OSType.Windows)
			{
				return windowsPing(address);
			}
			return tcpPing(address);
		}
		catch (IOException ex)
		{
			log.warn("error pinging", ex);
			return -1;
		}
	}

	private static int windowsPing(String worldAddress) throws UnknownHostException
	{
		IPHlpAPI ipHlpAPI = IPHlpAPI.INSTANCE;
		Pointer ptr = ipHlpAPI.IcmpCreateFile();
		InetAddress inetAddress = InetAddress.getByName(worldAddress);
		byte[] address = inetAddress.getAddress();
		String dataStr = RUNELITE_PING;
		int dataLength = dataStr.length() + 1;
		Pointer data = new Memory(dataLength);
		data.setString(0L, dataStr);
		IcmpEchoReply icmpEchoReply = new IcmpEchoReply(new Memory(IcmpEchoReply.SIZE + dataLength));
		assert icmpEchoReply.size() == IcmpEchoReply.SIZE;
		int packed = (address[0] & 0xff) | ((address[1] & 0xff) << 8) | ((address[2] & 0xff) << 16) | ((address[3] & 0xff) << 24);
		int ret = ipHlpAPI.IcmpSendEcho(ptr, packed, data, (short) (dataLength), Pointer.NULL, icmpEchoReply, IcmpEchoReply.SIZE + dataLength, TIMEOUT);
		if (ret != 1)
		{
			ipHlpAPI.IcmpCloseHandle(ptr);
			return -1;
		}

		int rtt = Math.toIntExact(icmpEchoReply.roundTripTime.longValue());
		ipHlpAPI.IcmpCloseHandle(ptr);

		return rtt;
	}

	private static int tcpPing(String worldAddress) throws IOException
	{
		try (Socket socket = new Socket())
		{
			socket.setSoTimeout(TIMEOUT);
			InetAddress inetAddress = InetAddress.getByName(worldAddress);
			long start = System.nanoTime();
			socket.connect(new InetSocketAddress(inetAddress, PORT));
			long end = System.nanoTime();
			return (int) ((end - start) / 1000000L);
		}
	}
}
