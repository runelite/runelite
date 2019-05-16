package net.runelite.client.plugins.ping.ping;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

interface IPHlpAPI extends Library
{
	IPHlpAPI INSTANCE = Native.loadLibrary("IPHlpAPI", IPHlpAPI.class);

	Pointer IcmpCreateFile();

	boolean IcmpCloseHandle(Pointer handle);

	int IcmpSendEcho(Pointer IcmpHandle, int DestinationAddress, Pointer RequestData, short RequestSize, Pointer RequestOptions, IcmpEchoReply ReplyBuffer, int ReplySize, int Timeout);
}