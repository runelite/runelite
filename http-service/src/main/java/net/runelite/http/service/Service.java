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

import com.google.inject.Guice;
import com.google.inject.Inject;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.service.account.AccountService;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.config.ConfigService;
import net.runelite.http.service.hiscore.HiscoreService;
import net.runelite.http.service.item.ItemService;
import net.runelite.http.service.updatecheck.UpdateCheckService;
import net.runelite.http.service.worlds.WorldsService;
import net.runelite.http.service.xtea.XteaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;
import static spark.Spark.*;

public class Service implements SparkApplication
{
	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	private final JsonTransformer transformer = new JsonTransformer();

	@Inject
	private AuthFilter authFilter;

	@Inject
	private AccountService accounts;

	@Inject
	private ConfigService config;

	@Inject
	private HiscoreService hiscores;

	@Inject
	private ItemService item;

	@Inject
	private UpdateCheckService updateCheck;

	@Inject
	private WorldsService worlds;

	@Inject
	private XteaService xtea;

	@Override
	public void init()
	{
		Guice.createInjector(new ServiceModule(this));
		setupRoutes();
	}

	public void setupRoutes()
	{
		xtea.init();
		accounts.init();
		config.init();
		item.init();

		get("/version", (request, response) -> RuneliteAPI.getVersion());
		get("/update-check", updateCheck::check, transformer);
		get("/hiscore", (request, response) -> hiscores.lookup(request.queryParams("username")), transformer);
		get("/worlds", (request, response) -> worlds.listWorlds(), transformer);
		post("/xtea", xtea::submit);
		get("/xtea/:rev", xtea::get, transformer);
		path("/account", () ->
		{
			get("/login", accounts::login, transformer);
			get("/callback", accounts::callback);

			before("/logout", authFilter);
			get("/logout", accounts::logout);

			before("/session-check", authFilter);
			get("/session-check", accounts::sessionCheck);
		});
		before("/config", authFilter);
		path("/config", () ->
		{
			// Just using before(authFilter); here doesn't work
			before("/*", authFilter);

			get("", config::get, transformer);
			put("/:key", config::setKey);
			delete("/:key", config::unsetKey);
		});
		path("/item", () ->
		{
			get("/:id", item::getItem, transformer);
			get("/:id/icon", item::getIcon);
			get("/:id/icon_large", item::getIconLarge);
		});

		exception(Exception.class, (exception, request, response) -> logger.warn(null, exception));
	}

}
