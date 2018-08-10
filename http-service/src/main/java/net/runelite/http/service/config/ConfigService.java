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
package net.runelite.http.service.config;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.account.beans.SessionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

@RestController
@RequestMapping("/config")
public class ConfigService
{
	private static final String CREATE_CONFIG = "CREATE TABLE IF NOT EXISTS `config` (\n"
		+ "  `user` int(11) NOT NULL,\n"
		+ "  `key` tinytext NOT NULL,\n"
		+ "  `value` text NOT NULL,\n"
		+ "  UNIQUE KEY `user_key` (`user`,`key`(64))\n"
		+ ") ENGINE=InnoDB;";

	private static final String CONFIG_FK = "ALTER TABLE `config`\n"
		+ "  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

	private final Sql2o sql2o;
	private final AuthFilter auth;

	@Autowired
	public ConfigService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		AuthFilter auth
	)
	{
		this.sql2o = sql2o;
		this.auth = auth;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_CONFIG)
				.executeUpdate();

			try
			{
				con.createQuery(CONFIG_FK)
					.executeUpdate();
			}
			catch (Sql2oException ex)
			{
				// Ignore, happens when index already exists
			}
		}
	}

	@RequestMapping
	public Configuration get(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SessionEntry session = auth.handle(request, response);

		if (session == null)
		{
			return null;
		}

		List<ConfigEntry> config;

		try (Connection con = sql2o.open())
		{
			config = con.createQuery("select `key`, value from config where user = :user")
				.addParameter("user", session.getUser())
				.executeAndFetch(ConfigEntry.class);
		}

		return new Configuration(config);
	}

	@RequestMapping(path = "/{key:.+}", method = PUT)
	public void setKey(
		HttpServletRequest request,
		HttpServletResponse response,
		@PathVariable String key,
		@RequestBody(required = false) String value
	) throws IOException
	{
		SessionEntry session = auth.handle(request, response);

		if (session == null)
		{
			return;
		}

		try (Connection con = sql2o.open())
		{
			con.createQuery("insert into config (user, `key`, value) values (:user, :key, :value) on duplicate key update `key` = :key, value = :value")
				.addParameter("user", session.getUser())
				.addParameter("key", key)
				.addParameter("value", value != null ? value : "")
				.executeUpdate();
		}
	}

	@RequestMapping(path = "/{key:.+}", method = DELETE)
	public void unsetKey(
		HttpServletRequest request,
		HttpServletResponse response,
		@PathVariable String key
	) throws IOException
	{
		SessionEntry session = auth.handle(request, response);

		if (session == null)
		{
			return;
		}

		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from config where user = :user and `key` = :key")
				.addParameter("user", session.getUser())
				.addParameter("key", key)
				.executeUpdate();
		}
	}
}
