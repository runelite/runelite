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

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;
import java.util.List;

public class TCP_INFO_v0 extends Structure
{
	public WinDef.ULONG State;
	public WinDef.ULONG Mss;
	public WinDef.ULONGLONG ConnectionTimeMs;
	public WinDef.BOOL TimestampsEnabled;
	public WinDef.ULONG RttUs;
	public WinDef.ULONG MinRttUs;
	public WinDef.ULONG BytesInFlight;
	public WinDef.ULONG Cwnd;
	public WinDef.ULONG SndWnd;
	public WinDef.ULONG RcvWnd;
	public WinDef.ULONG RcvBuf;
	public WinDef.ULONGLONG BytesOut;
	public WinDef.ULONGLONG BytesIn;
	public WinDef.ULONG BytesReordered;
	public WinDef.ULONG BytesRetrans;
	public WinDef.ULONG FastRetrans;
	public WinDef.ULONG DupAcksIn;
	public WinDef.ULONG TimeoutEpisodes;
	public WinDef.UCHAR SynRetrans;

	@Override
	protected List<String> getFieldOrder()
	{
		return List.of(
			"State",
			"Mss",
			"ConnectionTimeMs",
			"TimestampsEnabled",
			"RttUs",
			"MinRttUs",
			"BytesInFlight",
			"Cwnd",
			"SndWnd",
			"RcvWnd",
			"RcvBuf",
			"BytesOut",
			"BytesIn",
			"BytesReordered",
			"BytesRetrans",
			"FastRetrans",
			"DupAcksIn",
			"TimeoutEpisodes",
			"SynRetrans"
		);
	}
}
