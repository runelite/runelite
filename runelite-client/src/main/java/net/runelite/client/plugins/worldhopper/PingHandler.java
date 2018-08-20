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
package net.runelite.client.plugins.worldhopper;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;
import net.runelite.client.util.PingUtil;

@Slf4j
class Ping implements Runnable
{
	private WorldTableRow row;

	Ping (WorldTableRow r)
	{
		row = r;
	}

	public void run()
	{
		String address = row.getWorld().getAddress();

		try
		{
			switch (OSType.getOSType())
			{
				case Windows:
					int p = PingUtil.winPing(address);
					PingUtil.pingMap.put(address, p);
					row.setPing(PingUtil.pingMap.get(address));
					break;

				case MacOS:
					row.setPing(0);
					break;

				case Linux:
					row.setPing(0);
					break;
			}
		}
		catch (UnknownHostException exception)
		{
			log.warn("UnknownHost Exception, Unable to update ping to " + address);
		}
	}
}

public class PingHandler
{
	static private final Integer MAX_T = 10;
	static private ArrayList<Runnable> queue = new ArrayList<>();

	public static void main (ArrayList<WorldTableRow> args)
	{
		for (WorldTableRow arg : args)
		{
			Runnable r = new Ping(arg);
			queue.add(r);
		}

		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

		for (int i = 0; i < queue.size(); i++)
		{
			pool.execute(queue.get(i));
		}

		queue = new ArrayList<>();
		pool.shutdown();
	}
}

