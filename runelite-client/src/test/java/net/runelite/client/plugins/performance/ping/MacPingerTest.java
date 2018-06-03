package net.runelite.client.plugins.performance.ping;

import org.junit.Assert;
import org.junit.Test;

public class MacPingerTest
{
	@Test
	public void parse()
	{
		RuntimeCommandPinger pinger = new MacPinger();
		Assert.assertEquals(-1, pinger.parsePingFromLine("PING google.com (172.217.5.14): 56 data bytes"));
		Assert.assertEquals(48, pinger.parsePingFromLine("64 bytes from 172.217.5.14: icmp_seq=0 ttl=49 time=32.760 ms"));
		Assert.assertEquals(-1, pinger.parsePingFromLine("3 packets transmitted, 3 packets received, 0.0% packet loss"));
	}
}
