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
package net.runelite.client.plugins.worldhopper.ping;

import com.google.common.base.Charsets;
import com.google.common.primitives.Bytes;
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
	private static final byte[] RUNELITE_PING = "RuneLitePing".getBytes(Charsets.UTF_8);
	private static final int TIMEOUT = 2000; // ms
	private static final int PORT = 43594;

	private static short seq;

	public static int ping(World world)
	{
		InetAddress inetAddress;
		try
		{
			inetAddress = InetAddress.getByName(world.getAddress());
		}
		catch (UnknownHostException ex)
		{
			log.warn("error resolving host for world ping", ex);
			return -1;
		}

		try
		{
			switch (OSType.getOSType())
			{
				case Windows:
					return windowsPing(inetAddress);
				case Linux:
					try
					{
						return linuxPing(inetAddress);
					}
					catch (Exception ex)
					{
						return tcpPing(inetAddress);
					}
				default:
					return tcpPing(inetAddress);
			}
		}
		catch (IOException ex)
		{
			log.warn("error pinging", ex);
			return -1;
		}
	}

	private static int windowsPing(InetAddress inetAddress)
	{
		IPHlpAPI ipHlpAPI = IPHlpAPI.INSTANCE;
		Pointer ptr = ipHlpAPI.IcmpCreateFile();
		try
		{
			byte[] address = inetAddress.getAddress();
			Memory data = new Memory(RUNELITE_PING.length);
			data.write(0, RUNELITE_PING, 0, RUNELITE_PING.length);
			IcmpEchoReply icmpEchoReply = new IcmpEchoReply(new Memory(IcmpEchoReply.SIZE + data.size()));
			assert icmpEchoReply.size() == IcmpEchoReply.SIZE;
			int packed = (address[0] & 0xff) | ((address[1] & 0xff) << 8) | ((address[2] & 0xff) << 16) | ((address[3] & 0xff) << 24);
			int ret = ipHlpAPI.IcmpSendEcho(ptr, packed, data, (short) data.size(), Pointer.NULL, icmpEchoReply, IcmpEchoReply.SIZE + (int) data.size(), TIMEOUT);
			if (ret != 1)
			{
				return -1;
			}

			return Math.toIntExact(icmpEchoReply.roundTripTime.longValue());
		}
		finally
		{
			ipHlpAPI.IcmpCloseHandle(ptr);
		}
	}

	private static int linuxPing(InetAddress inetAddress) throws IOException
	{
		RLLibC libc = RLLibC.INSTANCE;
		byte[] address = inetAddress.getAddress();

		int sock = libc.socket(libc.AF_INET, libc.SOCK_DGRAM, libc.IPPROTO_ICMP);
		if (sock < 0)
		{
			throw new IOException("failed to open ICMP socket");
		}

		try
		{
			Timeval tv = new Timeval();
			tv.tv_sec = TIMEOUT / 1000;
			if (libc.setsockopt(sock, libc.SOL_SOCKET, libc.SO_RCVTIMEO, tv.getPointer(), tv.size()) < 0)
			{
				throw new IOException("failed to set SO_RCVTIMEO");
			}

			short seqno = seq++;

			// struct icmphdr
			byte[] request = {
				8, // type 8 - ipv4 echo request
				0, // code
				0, 0, // checksum (set by kernel)
				0, 0, // id (set by kernel)
				(byte) (((seqno >> 8) & 0xff)), (byte) (seqno & 0xff)
			};
			// append payload
			request = Bytes.concat(request, RUNELITE_PING);
			// struct sockaddr_in
			byte[] addr = {
				(byte) libc.AF_INET, 0, // sin_family
				0, 0, // sin_port
				address[0], address[1], address[2], address[3], // sin_addr.s_addr
				0, 0, 0, 0, 0, 0, 0, 0 // padding
			};

			long start = System.nanoTime();
			if (libc.sendto(sock, request, request.length, 0, addr, addr.length) != request.length)
			{
				return -1;
			}

			int size = 8 + RUNELITE_PING.length; // struct icmphdr + response
			Memory response = new Memory(size);
			if (libc.recvfrom(sock, response, size, 0, null, null) != size)
			{
				return -1;
			}
			long end = System.nanoTime();

			short seq = (short) (((response.getByte(6) & 0xff) << 8) | response.getByte(7) & 0xff);
			if (seqno != seq)
			{
				log.warn("sequence number mismatch ({} != {})", seqno, seq);
				return -1;
			}

			return (int) ((end - start) / 1_000_000);
		}
		finally
		{
			libc.close(sock);
		}
	}

	private static int tcpPing(InetAddress inetAddress) throws IOException
	{
		try (Socket socket = new Socket())
		{
			socket.setSoTimeout(TIMEOUT);
			long start = System.nanoTime();
			socket.connect(new InetSocketAddress(inetAddress, PORT));
			long end = System.nanoTime();
			return (int) ((end - start) / 1000000L);
		}
	}
}
