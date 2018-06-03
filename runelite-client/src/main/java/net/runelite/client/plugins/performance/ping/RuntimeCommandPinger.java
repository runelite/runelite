/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.performance.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

/**
 * Executes a ping command and reads STDOUT of the command, using regex to find the answer.
 * This also awaits for command results in another thread to ensure maximum execution time of 5 seconds
 */
@Slf4j
public abstract class RuntimeCommandPinger implements Pinger
{
	abstract String[] formatCommand(String address);

	/**
	 * @param line
	 * @return -1 if the line does not have a time in ms
	 */
	abstract int parsePingFromLine(String line);
	private final Runtime runtime;
	private ExecutorService executor;

	RuntimeCommandPinger()
	{
		runtime = Runtime.getRuntime();
	}

	@Override
	public void startup()
	{
		executor = Executors.newSingleThreadExecutor();
	}

	@Override
	public void shutdown()
	{
		executor.shutdownNow();
	}

	@Override
	public int ping(String address)
	{
		final String[] command = formatCommand(address);
		try
		{
			final Process process = runtime.exec(command);
			Future<Integer> result = executor.submit(() ->
			{
				try (InputStream commandOutput = process.getInputStream())
				{
					final InputStreamReader commandOutputReader = new InputStreamReader(commandOutput);
					final BufferedReader bufferedCommandOutput = new BufferedReader(commandOutputReader);
					while (true)
					{
						final String line = bufferedCommandOutput.readLine();
						if (line == null)
						{
							break;
						}
						final int parsedPing = parsePingFromLine(line);

						if (parsedPing >= 0)
						{
							return parsedPing;
						}
					}
				}
				return -1;
			});

			int pingResult = -1;

			try
			{
				pingResult = result.get(5, TimeUnit.SECONDS);
			}
			catch (ExecutionException e)
			{
				log.error("Ping execution exception", e);
			}
			catch (TimeoutException | InterruptedException e)
			{
				// Guess we don't have a result
				log.info("Ping result did not come within the expected time");
			}

			if (process.isAlive())
			{
				process.destroy();
			}
			return pingResult;
		}
		catch (IOException e)
		{
			log.warn("Runtime ping failed", e);
			return -1;
		}
	}
}
