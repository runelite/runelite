/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.data;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

public class EventOccurrenceCollection
{
	@Getter
	private String eventName;

	@Getter
	private int count;

	@Getter
	@Setter
	private long value;

	@Getter
	@Setter
	private Instant firstOccurrence;

	@Getter
	@Setter
	private Instant lastOccurrence;

	public EventOccurrenceCollection(String eventName)
	{
		this.eventName = eventName;
		this.count = 0;
		this.value = 0;
	}

	public void addOccurrence(Instant instant)
	{
		count++;

		if (firstOccurrence == null || firstOccurrence.compareTo(instant) > 0)
		{
			firstOccurrence = instant;
		}
		if (lastOccurrence == null || lastOccurrence.compareTo(instant) < 0)
		{
			lastOccurrence = instant;
		}
	}
}