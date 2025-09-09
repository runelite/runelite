/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.woodcutting;

import java.time.Duration;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

class WoodcuttingSession
{
	private final Instant start = Instant.now();
	@Getter(AccessLevel.PACKAGE)
	private Instant lastChopping;
	@Getter(AccessLevel.PACKAGE)
	private int logsCut;
	@Getter(AccessLevel.PACKAGE)
	private int logsPerHr;
	@Getter(AccessLevel.PACKAGE)
	private int bark;
	@Getter(AccessLevel.PACKAGE)
	private int barkPerHr;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean active = true;

	void setLastChopping()
	{
		lastChopping = Instant.now();
		setActive(true);
	}

	void incrementLogsCut()
	{
		++logsCut;

		Duration elapsed = Duration.between(start, Instant.now());
		long elapsedMs = elapsed.toMillis();
		if (logsCut >= 3 && elapsedMs > 0)
		{
			logsPerHr = (int) ((double) logsCut * Duration.ofHours(1).toMillis() / elapsedMs);
		}
	}

	void incrementBark(int num)
	{
		bark += num;

		Duration elapsed = Duration.between(start, Instant.now());
		long elapsedMs = elapsed.toMillis();
		if (elapsedMs > 0)
		{
			barkPerHr = (int) ((double) bark * Duration.ofHours(1).toMillis() / elapsedMs);
		}
	}
}
