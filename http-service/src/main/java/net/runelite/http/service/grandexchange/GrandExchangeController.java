package net.runelite.http.service.grandexchange;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import net.runelite.http.service.grandexchange.osbuddy.GuidePriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grand-exchange")
public class GrandExchangeController
{
	private static final Logger logger = LoggerFactory.getLogger(GrandExchangeController.class);

	private static final int CACHE_MAX_SIZE = 2048;

	private static final int CACHE_EXPIRY_MINUTES = 2;

	private static final int RSBUDDY_DB_CACHE_MILLIS = 1000 * 60 * 5;

	private final GrandExchangeService grandExchangeService;

	private final Cache<Integer, GrandExchangeEntry> cache;

	@Autowired
	public GrandExchangeController(GrandExchangeService grandExchangeService)
	{
		this.grandExchangeService = grandExchangeService;
		this.cache = CacheBuilder.newBuilder()
			.maximumSize(CACHE_MAX_SIZE)
			.expireAfterWrite(CACHE_EXPIRY_MINUTES, TimeUnit.MINUTES)
			.build();
	}

	@RequestMapping
	public GrandExchangeEntry get(@RequestParam("itemId") int itemId) throws ExecutionException
	{
		return this.cache.get(itemId, () ->
		{
			GrandExchangeEntry entry = grandExchangeService.get(itemId);

			if (entry == null)
			{
				GuidePriceResponse guidePrice = grandExchangeService.lookupItem(itemId);
				entry = grandExchangeService.insert(itemId, guidePrice);
			}
			else
			{
				long timeSinceUpdate = Duration.between(entry.getLastUpdate(), Instant.now()).toMillis();
				if (timeSinceUpdate >= RSBUDDY_DB_CACHE_MILLIS)
				{
					GuidePriceResponse guidePrice = grandExchangeService.lookupItem(itemId);
					entry = grandExchangeService.update(itemId, guidePrice);
				}
			}

			return entry;
		});
	}
}
