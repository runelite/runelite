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
package net.runelite.http.service.session;

import java.time.Instant;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController
{
	private final SessionService sessionService;

	@Autowired
	public SessionController(SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	private void createSession(HttpServletRequest request, UUID uuid)
	{
		String addr = request.getRemoteAddr();
		Instant now = Instant.now();
		SessionEntry sessionEntry = new SessionEntry();
		sessionEntry.setUuid(uuid);
		sessionEntry.setIp(addr);
		sessionEntry.setStart(now);
		sessionEntry.setLast(now);
		sessionService.createSession(sessionEntry);
	}

	@RequestMapping
	public UUID get(HttpServletRequest request)
	{
		UUID uuid = UUID.randomUUID();
		createSession(request, uuid);
		return uuid;
	}

	@RequestMapping("/ping")
	public ResponseEntity ping(HttpServletRequest request, @RequestParam("session") UUID uuid)
	{
		int updated = sessionService.updateLast(uuid);
		if (updated == 0)
		{
			// create the session anyway
			createSession(request, uuid);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity delete(@RequestParam("session") UUID uuid)
	{
		int deleted = sessionService.deleteSession(uuid);
		if (deleted == 0)
		{
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().build();
	}

	@RequestMapping("/count")
	public int count()
	{
		return sessionService.getCount();
	}
}
