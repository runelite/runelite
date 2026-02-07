/*
 * Copyright (c) 2026 Abex
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
import java.util.List;

public class MacOSTCPConnectionInfo extends Structure implements TCPInfo
{
	public byte state;
	public byte snd_wscale;
	public byte rcv_wscale;
	public byte pad1;
	public int options;
	public int flags;
	public int rto;
	public int maxseg;
	public int snd_ssthresh;
	public int snd_cwnd;
	public int snd_wnd;
	public int snd_sbbytes;
	public int rcv_wnd;
	public int rttcur;
	public int srtt;
	public int rttvar;
	public int tfo;
	public long txpackets;
	public long txbytes;
	public long txretransmitbytes;
	public long rxpackets;
	public long rxbytes;
	public long rxoutoforderbytes;
	public long txretransmitpackets;

	@Override
	protected List<String> getFieldOrder()
	{
		return List.of(
			"state",
			"snd_wscale",
			"rcv_wscale",
			"pad1",
			"options",
			"flags",
			"rto",
			"maxseg",
			"snd_ssthresh",
			"snd_cwnd",
			"snd_wnd",
			"snd_sbbytes",
			"rcv_wnd",
			"rttcur",
			"srtt",
			"rttvar",
			"tfo",
			"txpackets",
			"txbytes",
			"txretransmitbytes",
			"rxpackets",
			"rxbytes",
			"rxoutoforderbytes",
			"txretransmitpackets"
		);
	}

	@Override
	public long getRTT()
	{
		return srtt * 1000L;
	}

	@Override
	public long getRetransmitted()
	{
		return txretransmitpackets;
	}

	@Override
	public long getTransmitted()
	{
		return txpackets;
	}
}
