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

import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.task.Schedule;

@Singleton
@Slf4j
public class ClientSessionManager
{
	private final SessionClient sessionClient;
	private UUID sessionId;


	@Inject
	ClientSessionManager(EventBus eventBus)
	{
		this.sessionClient = new SessionClient();

		eventBus.subscribe(ClientShutdown.class, this, (e) ->
		{
			Future<Void> f = shutdown();
			if (f != null)
			{
				e.waitFor(f);
			}
			sessionId = null;
		});
	}

	void start()
	{
		sessionClient.openSession()
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.single())
			.doOnError(this::error)
			.subscribe(this::setUuid);
	}

	@Schedule(period = 10, unit = ChronoUnit.MINUTES, asynchronous = true)
	public void ping()
	{
		if (sessionId == null)
		{
			start();
			return;
		}

		sessionClient.pingSession(sessionId)
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.single())
			.doOnError(this::error)
			.subscribe();
	}

	private Future<Void> shutdown()
	{
		if (sessionId != null)
		{
			return sessionClient.delete(sessionId)
				.toFuture();

		}
		return null;
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