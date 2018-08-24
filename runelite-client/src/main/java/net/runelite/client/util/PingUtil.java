/*
 * Copyright (c) 2018, Digbigpig <https://github.com/Digbigpig>
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
package net.runelite.client.util;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import net.runelite.client.plugins.worldhopper.ping.IPHlpAPI;
import net.runelite.client.plugins.worldhopper.ping.IcmpEchoReply;
import java.net.UnknownHostException;

public class PingUtil extends Thread
{
	public static Map<String, Integer> pingMap = new HashMap<>();

	public static int winPing(String worldAddress) throws UnknownHostException
	{
		int rtt;
		IPHlpAPI ipHlpAPI = IPHlpAPI.INSTANCE;
		long ptr = ipHlpAPI.IcmpCreateFile();
		InetAddress inetAddress = InetAddress.getByName(worldAddress);
		byte[] address = inetAddress.getAddress();
		String dataStr = "RuneLitePing";
		int dataLength = dataStr.length() + 1;
		Pointer data = new Memory(dataLength);
		data.setString(0L, dataStr);
		IcmpEchoReply icmpEchoReply = new IcmpEchoReply(new Memory(IcmpEchoReply.SIZE + dataLength));
		int packed = (address[0] & 0xff) | ((address[1] & 0xff) << 8) | ((address[2] & 0xff) << 16) | ((address[3] & 0xff) << 24);
		int ret = ipHlpAPI.IcmpSendEcho(ptr, packed, data, (short) (dataLength), 0L, icmpEchoReply, IcmpEchoReply.SIZE + dataLength, 10000);
		rtt = Math.toIntExact(icmpEchoReply.roundTripTime.longValue());
		ipHlpAPI.IcmpCloseHandle(ptr);

		return rtt;
	}
}
