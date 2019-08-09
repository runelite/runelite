/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.xtea;

import java.time.Instant;

public class XteaEntry
{
	private int region;
	private Instant time;
	private int rev;
	private int key1;
	private int key2;
	private int key3;
	private int key4;

	public int getRegion()
	{
		return region;
	}

	public void setRegion(int region)
	{
		this.region = region;
	}

	public Instant getTime()
	{
		return time;
	}

	public void setTime(Instant time)
	{
		this.time = time;
	}

	public int getRev()
	{
		return rev;
	}

	public void setRev(int rev)
	{
		this.rev = rev;
	}

	public int getKey1()
	{
		return key1;
	}

	public void setKey1(int key1)
	{
		this.key1 = key1;
	}

	public int getKey2()
	{
		return key2;
	}

	public void setKey2(int key2)
	{
		this.key2 = key2;
	}

	public int getKey3()
	{
		return key3;
	}

	public void setKey3(int key3)
	{
		this.key3 = key3;
	}

	public int getKey4()
	{
		return key4;
	}

	public void setKey4(int key4)
	{
		this.key4 = key4;
	}

}
