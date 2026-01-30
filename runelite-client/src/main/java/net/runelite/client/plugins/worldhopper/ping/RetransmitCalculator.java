/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;

@Slf4j
public class RetransmitCalculator
{
	private static final int SAMPLES = 16;

	private int index;
	private long connectionTime;
	private final long[] bytesOut = new long[SAMPLES];
	private final long[] bytesRetrans = new long[SAMPLES];
	private int loss;

	public void record(FileDescriptor fd)
	{
		if (OSType.getOSType() != OSType.Windows)
		{
			return;
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
			return;
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
			return;
		}
		if (rc != 0)
		{
			log.debug("WSAIoctl(SIO_TCP_INFO) error"); // WSAGetLastError() seems to always be 0?
			return;
		}

		info.read();

		int nextIndex = index++ & (SAMPLES - 1);

		long connectionTime = info.ConnectionTimeMs.longValue();
		long out = info.BytesOut.longValue();
		long rt = info.BytesRetrans.longValue();

		log.trace("rtt: {}us bytes out: {} retrans: {}", info.RttUs.longValue(), out, rt);

		if (connectionTime < this.connectionTime)
		{
			Arrays.fill(bytesOut, 0L);
			Arrays.fill(bytesRetrans, 0L);
		}

		this.connectionTime = connectionTime;
		bytesOut[nextIndex] = out;
		bytesRetrans[nextIndex] = rt;

		loss = computeRetransmitPercent();
	}

	private int computeRetransmitPercent()
	{
		int startIndex = (index - 1) & (SAMPLES - 1);
		int endIndex = index & (SAMPLES - 1);

		long deltaOut = bytesOut[startIndex] - bytesOut[endIndex];
		long deltaRt = bytesRetrans[startIndex] - bytesRetrans[endIndex];

		if (deltaOut == 0)
		{
			return 0;
		}

		return (int) (deltaRt * 100L / deltaOut);
	}

	public int getRetransmitPercent()
	{
		return loss;
	}
}
