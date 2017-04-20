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

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import spark.Request;
import spark.Response;

public class XteaService
{
	private static final Logger logger = LoggerFactory.getLogger(XteaService.class);

	private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS `xtea` (\n"
		+ "  `rev` int(11) NOT NULL,\n"
		+ "  `region` int(11) NOT NULL,\n"
		+ "  `key1` int(11) NOT NULL,\n"
		+ "  `key2` int(11) NOT NULL,\n"
		+ "  `key3` int(11) NOT NULL,\n"
		+ "  `key4` int(11) NOT NULL,\n"
		+ "  PRIMARY KEY (`rev`,`region`,`key1`,`key2`,`key3`,`key4`)\n"
		+ ") ENGINE=InnoDB;";

	
	private final DataSource datasource;
	private final Gson gson = new Gson();

	@Inject
	public XteaService(@Named("Runelite JDBC") DataSource datasource)
	{
		this.datasource = datasource;
	}

	public void init()
	{
		Sql2o sql2o = new Sql2o(datasource);

		try (Connection con = sql2o.beginTransaction())
		{
			con.createQuery(CREATE_SQL)
				.executeUpdate();
		}
	}

	public Object submit(Request request, Response response)
	{
		XteaRequest xteaRequest = gson.fromJson(request.body(), XteaRequest.class);

		Sql2o sql2o = new Sql2o(datasource);

		try (Connection con = sql2o.beginTransaction())
		{
			Query query = con.createQuery("insert ignore into xtea (rev, region, key1, key2, key3, key4) values (:rev, :region, :key1, :key2, :key3, :key4)");

			for (XteaKey key : xteaRequest.getKeys())
			{
				query.addParameter("rev", xteaRequest.getRevision())
					.addParameter("region", key.getRegion())
					.addParameter("key1", key.getKeys()[0])
					.addParameter("key2", key.getKeys()[1])
					.addParameter("key3", key.getKeys()[2])
					.addParameter("key4", key.getKeys()[3])
					.addToBatch();
			}

			query.executeBatch();
			con.commit();
		}

		return "";
	}

	public List<XteaKey> get(Request request, Response response)
	{
		String revStr = request.params("rev");
		int revision = Integer.parseInt(revStr);

		Sql2o sql2o = new Sql2o(datasource);

		try (Connection con = sql2o.open())
		{
			List<XteaEntry> entries = con.createQuery("select * from xtea where rev = :rev")
				.addParameter("rev", revision)
				.executeAndFetch(XteaEntry.class);

			response.type("application/json");

			return entries.stream()
				.map(XteaService::entryToKey)
				.collect(Collectors.toList());
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
