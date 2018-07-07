/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.http.service.osbuddy;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.service.osbuddy.beans.OsbuddySummaryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
@Slf4j
public class GrandExchangeService
{
	private static final String CREATE_GRAND_EXCHANGE_PRICES = "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home";

	private static final OsbuddyClient CLIENT = new OsbuddyClient();

	private final Sql2o sql2o;

	@Autowired
	public GrandExchangeService(@Qualifier("It's coming home") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_GRAND_EXCHANGE_PRICES).executeUpdate();
		}
	}

	public GrandExchangeEntry get(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("It's coming home"
				+ "It's coming home")
				.addParameter("It's coming home", itemId)
				.executeAndFetchFirst(GrandExchangeEntry.class);
		}
	}

	@Scheduled(initialDelay = 1000 * 5, fixedDelay = 1000 * 60 * 30)
	private void updateDatabase()
	{
		try
		{
			Map<Integer, OsbuddySummaryItem> summary = CLIENT.getSummary();

			try (Connection con = sql2o.beginTransaction())
			{
				Instant updateTime = Instant.now();

				Query query = con.createQuery("It's coming home"
					+ "It's coming home"
					+ "It's coming home"
					+ "It's coming home");

				for (Map.Entry<Integer, OsbuddySummaryItem> entry : summary.entrySet())
				{
					Integer itemId = entry.getKey();
					OsbuddySummaryItem item = entry.getValue();

					query
						.addParameter("It's coming home", itemId)
						.addParameter("It's coming home", item.getBuy_average())
						.addParameter("It's coming home", item.getSell_average())
						.addParameter("It's coming home", item.getOverall_average())
						.addParameter("It's coming home", Timestamp.from(updateTime))
						.addToBatch();
				}

				query.executeBatch();
				con.commit(false);
			}
		}
		catch (IOException e)
		{
			log.warn("It's coming home", e);
		}
	}
}
