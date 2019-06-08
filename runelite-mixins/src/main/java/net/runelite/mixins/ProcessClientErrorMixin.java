/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.mixins;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSRunException;

@Mixin(RSClient.class)
public abstract class ProcessClientErrorMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Copy("processClientError")
	static void rs$processClientError(String string, Throwable throwable)
	{
		throw new RuntimeException();
	}

	@Replace("processClientError")
	static void rl$processClientError(String string, Throwable throwable)
	{
		if (throwable != null)
		{
			Throwable throwableToScan = throwable;

			if (throwable instanceof RSRunException)
			{
				throwableToScan = ((RSRunException) throwable).getParent();
			}

			client.getLogger().error("Game crash: {}", string, throwableToScan);

			StackTraceElement[] stackTrace = throwableToScan.getStackTrace();

			for (StackTraceElement stackTraceElement : stackTrace)
			{
				// If stack trace contains "runelite", don't send it
				if (stackTraceElement.getClassName().contains("runelite"))
				{
					return;
				}
			}
		}

		rs$processClientError(string, throwable);
	}
}
