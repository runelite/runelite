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

import com.google.gson.Gson;
import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.ge.GrandExchangeTrade;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.account.beans.SessionEntry;
import net.runelite.http.service.util.redis.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/ge")
public class GrandExchangeController
{
	private static final Gson GSON = RuneLiteAPI.GSON;

	private final GrandExchangeService grandExchangeService;
	private final AuthFilter authFilter;
	private final RedisPool redisPool;

	@Autowired
	public GrandExchangeController(GrandExchangeService grandExchangeService, AuthFilter authFilter, RedisPool redisPool)
	{
		this.grandExchangeService = grandExchangeService;
		this.authFilter = authFilter;
		this.redisPool = redisPool;
	}

	@PostMapping
	public void submit(HttpServletRequest request, HttpServletResponse response, @RequestBody GrandExchangeTrade grandExchangeTrade) throws IOException
	{
		SessionEntry session = null;
		if (request.getHeader(RuneLiteAPI.RUNELITE_AUTH) != null)
		{
			session = authFilter.handle(request, response);
			if (session == null)
			{
				// error is set here on the response, so we shouldn't continue
				return;
			}
		}
		Integer userId = session == null ? null : session.getUser();

		// We don't keep track of pending trades in the web UI, so only add cancelled or completed trades
		if (userId != null &&
			grandExchangeTrade.getQty() > 0 &&
			(grandExchangeTrade.isCancel() || grandExchangeTrade.getQty() == grandExchangeTrade.getTotal()))
		{
			grandExchangeService.add(userId, grandExchangeTrade);
		}

		Trade trade = new Trade();
		trade.setBuy(grandExchangeTrade.isBuy());
		trade.setCancel(grandExchangeTrade.isCancel());
		trade.setLogin(grandExchangeTrade.isLogin());
		trade.setItemId(grandExchangeTrade.getItemId());
		trade.setQty(grandExchangeTrade.getQty());
		trade.setDqty(grandExchangeTrade.getDqty());
		trade.setTotal(grandExchangeTrade.getTotal());
		trade.setSpent(grandExchangeTrade.getDspent());
		trade.setOffer(grandExchangeTrade.getOffer());
		trade.setSlot(grandExchangeTrade.getSlot());
		trade.setTime((int) (System.currentTimeMillis() / 1000L));
		trade.setMachineId(request.getHeader(RuneLiteAPI.RUNELITE_MACHINEID));
		trade.setUserId(userId);
		trade.setIp(request.getHeader("X-Forwarded-For"));
		trade.setUa(request.getHeader("User-Agent"));
		trade.setWorldType(grandExchangeTrade.getWorldType());
		trade.setSeq(grandExchangeTrade.getSeq());
		Instant resetTime = grandExchangeTrade.getResetTime();
		trade.setResetTime(resetTime == null ? 0L : resetTime.getEpochSecond());

		String json = GSON.toJson(trade);
		try (Jedis jedis = redisPool.getResource())
		{
			jedis.publish("ge", json);
		}
	}

	@GetMapping
	public Collection<GrandExchangeTradeHistory> get(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(required = false, defaultValue = "1024") int limit,
		@RequestParam(required = false, defaultValue = "0") int offset) throws IOException
	{
		SessionEntry session = authFilter.handle(request, response);

		if (session == null)
		{
			return null;
		}

		return grandExchangeService.get(session.getUser(), limit, offset).stream()
			.map(GrandExchangeController::convert)
			.collect(Collectors.toList());
	}

	private static GrandExchangeTradeHistory convert(TradeEntry tradeEntry)
	{
		GrandExchangeTradeHistory grandExchangeTrade = new GrandExchangeTradeHistory();
		grandExchangeTrade.setBuy(tradeEntry.getAction() == TradeAction.BUY);
		grandExchangeTrade.setItemId(tradeEntry.getItem());
		grandExchangeTrade.setQuantity(tradeEntry.getQuantity());
		grandExchangeTrade.setPrice(tradeEntry.getPrice());
		grandExchangeTrade.setTime(tradeEntry.getTime());
		return grandExchangeTrade;
	}

	@DeleteMapping
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SessionEntry session = authFilter.handle(request, response);

		if (session == null)
		{
			return;
		}

		grandExchangeService.delete(session.getUser());
	}
}
