/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class DeduplicationFilter extends TurboFilter
{
	private static final Marker deduplicateMarker = MarkerFactory.getMarker("DEDUPLICATE");
	private static final int CACHE_SIZE = 8;
	private static final int DUPLICATE_LOG_COUNT = 1000;

	@RequiredArgsConstructor
	@EqualsAndHashCode(exclude = {"count"})
	private static class LogException
	{
		private final String message;
		private final StackTraceElement[] stackTraceElements;
		private volatile int count;
	}

	private final Deque<LogException> cache = new ConcurrentLinkedDeque<>();

	@Override
	public void stop()
	{
		cache.clear();
		super.stop();
	}

	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String s, Object[] objects, Throwable throwable)
	{
		if (marker != deduplicateMarker || logger.isDebugEnabled() || throwable == null)
		{
			return FilterReply.NEUTRAL;
		}

		LogException logException = new LogException(s, throwable.getStackTrace());
		for (LogException e : cache)
		{
			if (logException.equals(e))
			{
				// this iinc is not atomic, but doesn't matter in practice
				if (++e.count % DUPLICATE_LOG_COUNT == 0)
				{
					logger.warn("following log message logged " + DUPLICATE_LOG_COUNT + " times!");
					return FilterReply.NEUTRAL;
				}
				return FilterReply.DENY;
			}
		}

		synchronized (cache)
		{
			if (cache.size() >= CACHE_SIZE)
			{
				cache.pop();
			}
			cache.push(logException);
		}

		return FilterReply.NEUTRAL;
	}
}
