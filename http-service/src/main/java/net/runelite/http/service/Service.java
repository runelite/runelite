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
package net.runelite.http.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.service.hiscore.HiscoreService;
import net.runelite.http.service.worlds.WorldsService;
import net.runelite.http.service.xtea.XteaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;
import static spark.Spark.*;

public class Service implements SparkApplication
{
	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	private DataSource dataSource;

	private final JsonTransformer transformer = new JsonTransformer();

	private HiscoreService hiscores = new HiscoreService();
	private WorldsService worlds = new WorldsService();
	private XteaService xtea = new XteaService(this);

	@Override
	public void init()
	{
		loadDatasource();

		xtea.init();

		get("/version", (request, response) -> RuneliteAPI.getVersion());
		get("/hiscore", (request, response) -> hiscores.lookup(request.queryParams("username")), transformer);
		get("/worlds", (request, response) -> worlds.listWorlds(), transformer);
		post("/xtea", xtea::submit);
		get("/xtea/:rev", xtea::get, transformer);

		exception(Exception.class, (exception, request, response) -> logger.warn(null, exception));
	}

	private void loadDatasource()
	{
		try
		{
			// It is difficult to inject things into Spark
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			dataSource = (DataSource) envCtx.lookup("jdbc/runelite");
		}
		catch (NamingException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public HiscoreService getHiscores()
	{
		return hiscores;
	}

	public void setHiscores(HiscoreService hiscores)
	{
		this.hiscores = hiscores;
	}

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

}
