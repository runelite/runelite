/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client;

import io.reactivex.schedulers.Schedulers;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.task.Schedule;

@Singleton
@Slf4j
public class ClientSessionManager
{
	private final SessionClient sessionClient;
	private final ClientThread clientThread;
	private UUID sessionId;


	@Inject
	ClientSessionManager(ClientThread clientThread)
	{
		this.sessionClient = new SessionClient();
		this.clientThread = clientThread;
	}

	void start()
	{
		sessionClient.openSession()
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.from(clientThread))
			.subscribe(this::setUuid, this::error);
	}

	@Schedule(period = 10, unit = ChronoUnit.MINUTES, asynchronous = true)
	private void ping()
	{
		if (sessionId == null)
		{
			start();
			return;
		}

		sessionClient.pingSession(sessionId)
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.from(clientThread))
			.doOnError(this::error)
			.subscribe();
	}

	public void shutdown()
	{
		if (sessionId != null)
		{
			sessionClient.delete(sessionId)
				.subscribeOn(Schedulers.io())
				.observeOn(Schedulers.from(clientThread))
				.doOnError(this::error)
				.subscribe();

			sessionId = null;
		}
	}

	private void setUuid(UUID uuid)
	{
		this.sessionId = uuid;
		log.debug("Opened session {}.", sessionId);
	}

	private void error(Throwable error)
	{
		log.debug("Error in client session.");
		log.trace(null, error);
	}
}
