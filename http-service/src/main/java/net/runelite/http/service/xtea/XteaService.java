/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.xtea;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.cache.IndexType;
import net.runelite.cache.fs.Container;
import net.runelite.cache.util.Djb2;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;
import net.runelite.http.service.cache.CacheService;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.util.exception.InternalServerErrorException;
import net.runelite.http.service.util.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@RestController
@RequestMapping("/xtea")
public class XteaService
{
	private static final Logger logger = LoggerFactory.getLogger(XteaService.class);

	private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS `xtea` (\n"
		+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
		+ "  `region` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
		+ "  `rev` int(11) NOT NULL,\n"
		+ "  `key1` int(11) NOT NULL,\n"
		+ "  `key2` int(11) NOT NULL,\n"
		+ "  `key3` int(11) NOT NULL,\n"
		+ "  `key4` int(11) NOT NULL,\n"
		+ "  PRIMARY KEY (`id`),\n"
		+ "  KEY `region` (`region`,`time`)\n"
		+ ") ENGINE=InnoDB";

	private final Sql2o sql2o;
	private final CacheService cacheService;

	@Autowired
	public XteaService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		CacheService cacheService
	)
	{
		this.sql2o = sql2o;
		this.cacheService = cacheService;

		try (Connection con = sql2o.beginTransaction())
		{
			con.createQuery(CREATE_SQL)
				.executeUpdate();
		}
	}

	private XteaEntry findLatestXtea(Connection con, int region)
	{
		return con.createQuery("select region, time, key1, key2, key3, key4 from xtea "
			+ "where region = :region "
			+ "order by time desc "
			+ "limit 1")
			.addParameter("region", region)
			.executeAndFetchFirst(XteaEntry.class);
	}

	@RequestMapping(method = POST)
	public void submit(@RequestBody XteaRequest xteaRequest)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			CacheEntry cache = cacheService.findMostRecent();

			if (cache == null)
			{
				throw new InternalServerErrorException("No most recent cache");
			}

			Query query = con.createQuery("insert into xtea (region, rev, key1, key2, key3, key4) "
				+ "values (:region, :rev, :key1, :key2, :key3, :key4)");

			for (XteaKey key : xteaRequest.getKeys())
			{
				int region = key.getRegion();
				int[] keys = key.getKeys();

				XteaEntry xteaEntry = findLatestXtea(con, region);

				if (keys.length != 4)
				{
					throw new IllegalArgumentException("Key length must be 4");
				}

				// already have these?
				if (xteaEntry != null
					&& xteaEntry.getKey1() == keys[0]
					&& xteaEntry.getKey2() == keys[1]
					&& xteaEntry.getKey3() == keys[2]
					&& xteaEntry.getKey4() == keys[3])
				{
					continue;
				}

				if (!checkKeys(cache, region, keys))
				{
					continue;
				}

				query.addParameter("region", region)
					.addParameter("rev", xteaRequest.getRevision())
					.addParameter("key1", keys[0])
					.addParameter("key2", keys[1])
					.addParameter("key3", keys[2])
					.addParameter("key4", keys[3])
					.addToBatch();
			}

			query.executeBatch();
			con.commit(false);
		}
	}

	@RequestMapping
	public List<XteaKey> get()
	{
		try (Connection con = sql2o.open())
		{
			List<XteaEntry> entries = con.createQuery(
				"select t1.region, t1.time, t2.rev, t2.key1, t2.key2, t2.key3, t2.key4 from " +
					"(select region,max(time) as time from xtea group by region) t1 " +
					"join xtea t2 on t1.region = t2.region and t1.time = t2.time")
				.executeAndFetch(XteaEntry.class);

			return entries.stream()
				.map(XteaService::entryToKey)
				.collect(Collectors.toList());
		}
	}

	@RequestMapping("/{region}")
	public XteaKey getRegion(@PathVariable int region)
	{
		XteaEntry entry;

		try (Connection con = sql2o.open())
		{
			entry = con.createQuery("select region, time, rev, key1, key2, key3, key4 from xtea "
				+ "where region = :region order by time desc limit 1")
				.addParameter("region", region)
				.executeAndFetchFirst(XteaEntry.class);
		}

		if (entry == null)
		{
			throw new NotFoundException();
		}

		return entryToKey(entry);
	}

	private boolean checkKeys(CacheEntry cache, int regionId, int[] keys)
	{
		int x = regionId >>> 8;
		int y = regionId & 0xFF;

		String archiveName = new StringBuilder()
			.append('l')
			.append(x)
			.append('_')
			.append(y)
			.toString();
		int archiveNameHash = Djb2.hash(archiveName);

		ArchiveEntry archiveEntry = cacheService.findArchiveForTypeAndName(cache, IndexType.MAPS, archiveNameHash);
		if (archiveEntry == null)
		{
			throw new InternalServerErrorException("Unable to find archive for region");
		}

		byte[] data = cacheService.getArchive(archiveEntry);
		if (data == null)
		{
			throw new InternalServerErrorException("Unable to get archive data");
		}

		try
		{
			Container.decompress(data, keys);
			return true;
		}
		catch (IOException ex)
		{
			return false;
		}
	}

	private static XteaKey entryToKey(XteaEntry xe)
	{
		XteaKey xteaKey = new XteaKey();
		xteaKey.setRegion(xe.getRegion());
		xteaKey.setKeys(new int[]
		{
			xe.getKey1(),
			xe.getKey2(),
			xe.getKey3(),
			xe.getKey4()
		});
		return xteaKey;
	}
}
