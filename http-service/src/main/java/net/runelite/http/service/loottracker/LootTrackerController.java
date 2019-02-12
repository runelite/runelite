/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.http.service.loottracker;

import com.google.api.client.http.HttpStatusCodes;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loottracker")
public class LootTrackerController
{
	@Autowired
	private LootTrackerService service;

	@Autowired
	private AuthFilter auth;

	@RequestMapping(method = RequestMethod.POST)
	public void storeLootRecord(HttpServletRequest request, HttpServletResponse response, @RequestBody LootRecord record) throws IOException
	{
		SessionEntry e = auth.handle(request, response);
		if (e == null)
		{
			response.setStatus(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
			return;
		}

		service.store(record, e.getUser());
		response.setStatus(HttpStatusCodes.STATUS_CODE_OK);
	}

	@RequestMapping
	public Collection<LootRecord> getLootRecords(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "count", defaultValue = "1024") int count, @RequestParam(value = "start", defaultValue = "0") int start) throws IOException
	{
		SessionEntry e = auth.handle(request, response);
		if (e == null)
		{
			response.setStatus(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
			return null;
		}

		return service.get(e.getUser(), count, start);
	}

	@DeleteMapping
	public void deleteLoot(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(required = false) String eventId) throws IOException
	{
		SessionEntry e = auth.handle(request, response);
		if (e == null)
		{
			response.setStatus(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED);
			return;
		}

		service.delete(e.getUser(), eventId);
	}
}