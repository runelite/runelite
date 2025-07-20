/*
 * Copyright (c) 2020 Abex
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
package net.runelite.client.events;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Value
@Slf4j
public class ClientShutdown
{
	private Queue<Future<?>> tasks = new ConcurrentLinkedQueue<>();

	public void waitFor(Future<?> future)
	{
		tasks.add(future);
	}

	public void waitForAllConsumers(Duration totalTimeout)
	{
		long deadline = System.nanoTime() + totalTimeout.toNanos();
		for (Future<?> task; (task = tasks.poll()) != null; )
		{
			long timeout = deadline - System.nanoTime();
			if (timeout < 0)
			{
				log.warn("Timed out waiting for task completion");
				return;
			}

			try
			{
				task.get(timeout, TimeUnit.NANOSECONDS);
			}
			catch (ThreadDeath d)
			{
				throw d;
			}
			catch (Throwable t)
			{
				log.warn("Error during shutdown: ", t);
			}
		}
	}
}
