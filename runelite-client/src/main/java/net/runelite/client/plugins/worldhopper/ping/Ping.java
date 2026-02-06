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
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Inet4Address;
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
	private static final int MAX_IPV4_HEADER_SIZE = 60;

	private static short seq;

	@Deprecated
	public static int ping(World world)
	{
		return ping(world, false);
	}

	public static int ping(World world, boolean useTcpPing)
	{
		InetAddress inetAddress;
		try
		{
			inetAddress = InetAddress.getByName(world.getAddress());
		}
		catch (UnknownHostException ex)
		{
			log.debug("error resolving host for world ping", ex);
			return -1;
		}

		if (!(inetAddress instanceof Inet4Address))
		{
			log.debug("Only ipv4 ping is supported");
			return -1;
		}

		try
		{
			switch (OSType.getOSType())
			{
				case Windows:
					int p = windowsPing(inetAddress);
					if (p == -1 && useTcpPing)
					{
						p = tcpPing(inetAddress);
					}
					return p;
				case MacOS:
				case Linux:
					try
					{
						return icmpPing(inetAddress, OSType.getOSType() == OSType.MacOS);
					}
					catch (IOException ex)
					{
						log.debug("error during icmp ping", ex);
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

	private static int icmpPing(InetAddress inetAddress, boolean includeIpHeader) throws IOException
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
			tv.write();

			if (libc.setsockopt(sock, libc.SOL_SOCKET, libc.SO_RCVTIMEO, tv.getPointer(), tv.size()) < 0)
			{
				throw new IOException("failed to set SO_RCVTIMEO");
			}

			if (libc.setsockopt(sock, libc.SOL_SOCKET, libc.SO_SNDTIMEO, tv.getPointer(), tv.size()) < 0)
			{
				throw new IOException("failed to set SO_SNDTIMEO");
			}

			short seqno = seq++;

			// struct icmphdr
			byte[] request = {
				8, // type 8 - ipv4 echo request
				0, // code
				0, 0, // checksum
				0, 0, // id - set by kernel on Linux. MacOS uses pid, however sending 0 appears to work fine.
				(byte) (((seqno >> 8) & 0xff)), (byte) (seqno & 0xff)
			};
			// append payload
			request = Bytes.concat(request, RUNELITE_PING);

			final short checksum = checksum(request);
			// on Linux the kernel automatically sets the checksum and ignores what we set,
			// however it is required on MacOS
			request[2] = (byte) ((checksum >> 8) & 0xff);
			request[3] = (byte) (checksum & 0xff);

			// struct sockaddr_in
			byte[] addr = {
				(byte) libc.AF_INET, 0, // sin_family
				0, 0, // sin_port
				address[0], address[1], address[2], address[3], // sin_addr.s_addr
				0, 0, 0, 0, 0, 0, 0, 0 // padding
			};

			// response size/buffer
			int size = 8 + RUNELITE_PING.length + // struct icmphdr + response
				(includeIpHeader ? MAX_IPV4_HEADER_SIZE : 0); // struct ip
			Memory response = new Memory(size);

			long start = System.nanoTime();
			if (libc.sendto(sock, request, request.length, 0, addr, addr.length) != request.length)
			{
				return -1;
			}

			while (true)
			{
				if ((System.nanoTime() - start) / 1_000_000 > TIMEOUT)
				{
					log.debug("timeout elapsed checking for echo reply");
					break;
				}

				int rlen = libc.recvfrom(sock, response, size, 0, null, null);
				long end = System.nanoTime();
				if (rlen <= 0)
				{
					log.debug("recvfrom() error: len {} errno {}", rlen, Native.getLastError());
					break;
				}

				int icmpHeaderOffset = 0;
				if (includeIpHeader)
				{
					int ihl = response.getByte(0) & 0xf;
					icmpHeaderOffset = ihl << 2; // to bytes
				}

				if (icmpHeaderOffset + 7 >= rlen)
				{
					log.warn("packet too short (received {} bytes but icmp header offset is {})", rlen, icmpHeaderOffset);
					continue;
				}

				if (response.getByte(icmpHeaderOffset) != 0) // ICMP type - echo reply
				{
					log.debug("non-echo reply");
					continue;
				}

				short seq = (short) (((response.getByte(icmpHeaderOffset + 6) & 0xff) << 8) | response.getByte(icmpHeaderOffset + 7) & 0xff);
				if (seqno != seq)
				{
					log.debug("sequence number mismatch ({} != {})", seqno, seq);
					continue;
				}

				return (int) ((end - start) / 1_000_000);
			}

			return -1;
		}
		finally
		{
			libc.close(sock);
		}
	}

	// IP checksum
	private static short checksum(byte[] data)
	{
		int a = 0;
		for (int i = 0; i < data.length - 1; i += 2)
		{
			a += ((data[i] & 0xff) << 8) | (data[i + 1] & 0xff);
		}

		if ((data.length & 1) != 0)
		{
			a += (data[data.length - 1] & 0xff) << 8;
		}

		a = (a >> 16 & 0xffff) + (a & 0xffff);
		return (short) (~a & 0xffff);
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

	public static TCP_INFO_v0 getTcpInfo(FileDescriptor fd)
	{
		if (OSType.getOSType() != OSType.Windows)
		{
			return null;
		}

		int handle;
		try
		{
			Field f = FileDescriptor.class.getDeclaredField("fd");
			f.setAccessible(true);
			handle = f.getInt(fd);
		}
		catch (NoSuchFieldException | IllegalAccessException ex)
		{
			log.debug(null, ex);
			return null;
		}

		IntByReference tcpInfoVersion = new IntByReference(0); // Version 0 of TCP_INFO
		TCP_INFO_v0 info = new TCP_INFO_v0();
		IntByReference bytesReturned = new IntByReference();

		Ws2_32 winsock = Ws2_32.INSTANCE;
		int rc;
		try
		{
			rc = winsock.WSAIoctl(
				new WinNT.HANDLE(Pointer.createConstant(handle)),
				Ws2_32.SIO_TCP_INFO,
				tcpInfoVersion.getPointer(), Integer.BYTES,
				info.getPointer(), info.size(),
				bytesReturned,
				Pointer.NULL,
				Pointer.NULL
			);
		}
		catch (UnsatisfiedLinkError ex)
		{
			// probably Windows 7
			log.debug("WSAIoctl()", ex);
			return null;
		}
		if (rc != 0)
		{
			log.debug("WSAIoctl(SIO_TCP_INFO) error"); // WSAGetLastError() seems to always be 0?
			return null;
		}

		info.read();
		return info;
	}
}
