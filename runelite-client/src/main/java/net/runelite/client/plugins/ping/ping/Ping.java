package net.runelite.client.plugins.ping.ping;

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
		try
		{
			switch (OSType.getOSType())
			{
				case Windows:
					return windowsPing(world);
				default:
					return tcpPing(world);
			}
		}
		catch (IOException ex)
		{
			log.warn("error pinging", ex);
			return -1;
		}
	}

	private static int windowsPing(World world) throws UnknownHostException
	{
		IPHlpAPI ipHlpAPI = IPHlpAPI.INSTANCE;
		Pointer ptr = ipHlpAPI.IcmpCreateFile();
		InetAddress inetAddress = InetAddress.getByName(world.getAddress());
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

	private static int tcpPing(World world) throws IOException
	{
		try (Socket socket = new Socket())
		{
			socket.setSoTimeout(TIMEOUT);
			InetAddress inetAddress = InetAddress.getByName(world.getAddress());
			long start = System.nanoTime();
			socket.connect(new InetSocketAddress(inetAddress, PORT));
			long end = System.nanoTime();
			return (int) ((end - start) / 1000000L);
		}
	}
}