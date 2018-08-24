package net.runelite.client.plugins.worldhopper.ping;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.Test;

public class PingTest
{
    @Test
    public void test() throws UnknownHostException
    {
        IPHlpAPI ipHlpAPI = IPHlpAPI.INSTANCE;
        long ptr = ipHlpAPI.IcmpCreateFile();
        System.out.println("ptr " + ptr);
        InetAddress inetAddress = InetAddress.getByName("104.131.36.154");
        byte[] address = inetAddress.getAddress();
        String dataStr = "RuneLitePing";
        int dataLength = dataStr.length()+1;
        Pointer data = new Memory(dataLength);
        data.setString(0L, dataStr);
        IcmpEchoReply icmpEchoReply = new IcmpEchoReply(new Memory(IcmpEchoReply.SIZE + dataLength));
        int packed = (address[0] & 0xff) | ((address[1] & 0xff)<<8) | ((address[2] & 0xff)<<16) | ((address[3] & 0xff)<<24);
        int ret = ipHlpAPI.IcmpSendEcho(ptr, packed, data, (short)(dataLength),0L, icmpEchoReply, IcmpEchoReply.SIZE + dataLength, 1000);
        System.out.println("RET " + ret);
        System.out.println("RTT " + icmpEchoReply.roundTripTime.longValue());
        ipHlpAPI.IcmpCloseHandle(ptr);
    }
}