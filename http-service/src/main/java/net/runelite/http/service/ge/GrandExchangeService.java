/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.ge;

import java.util.Collection;
import net.runelite.http.api.ge.GrandExchangeTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
public class GrandExchangeService
{
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `ge_trades` (\n" +
		"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
		"  `user` int(11) NOT NULL,\n" +
		"  `action` enum('BUY','SELL') NOT NULL,\n" +
		"  `item` int(11) NOT NULL,\n" +
		"  `quantity` int(11) NOT NULL,\n" +
		"  `price` int(11) NOT NULL,\n" +
		"  `time` timestamp NOT NULL DEFAULT current_timestamp(),\n" +
		"  PRIMARY KEY (`id`),\n" +
		"  KEY `user_time` (`user`, `time`),\n" +
		"  KEY `time` (`time`),\n" +
		"  CONSTRAINT `ge_trades_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`)\n" +
		") ENGINE=InnoDB;";

	private final Sql2o sql2o;
	private final int historyDays;

	@Autowired
	public GrandExchangeService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		@Value("${runelite.ge.history}") int historyDays
	)
	{
		this.sql2o = sql2o;
		this.historyDays = historyDays;

		// Ensure necessary tables exist
		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_TABLE).executeUpdate();
		}
	}

	public void add(int userId, GrandExchangeTrade grandExchangeTrade)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("insert into ge_trades (user, action, item, quantity, price) values (:user," +
				" :action, :item, :quantity, :price)")
				.addParameter("user", userId)
				.addParameter("action", grandExchangeTrade.isBuy() ? "BUY" : "SELL")
				.addParameter("item", grandExchangeTrade.getItemId())
				.addParameter("quantity", grandExchangeTrade.getQuantity())
				.addParameter("price", grandExchangeTrade.getPrice())
				.executeUpdate();
		}
	}

	public Collection<TradeEntry> get(int userId, int limit, int offset)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select id, user, action, item, quantity, price, time from ge_trades where user = :user limit :limit offset :offset")
				.addParameter("user", userId)
				.addParameter("limit", limit)
				.addParameter("offset", offset)
				.executeAndFetch(TradeEntry.class);
		}
	}

	public void delete(int userId)
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from ge_trades where user = :user")
				.addParameter("user", userId)
				.executeUpdate();
		}
	}

	@Scheduled(fixedDelay = 60 * 60 * 1000)
	public void expire()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from ge_trades where time < current_timestamp - interval " + historyDays + " day")
				.executeUpdate();
		}
	}
}
