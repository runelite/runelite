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

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.runelite.http.service.account.AccountService;
import net.runelite.http.service.account.AuthFilter;
import net.runelite.http.service.config.ConfigService;
import net.runelite.http.service.hiscore.HiscoreService;
import net.runelite.http.service.updatecheck.UpdateCheckService;
import net.runelite.http.service.worlds.WorldsService;
import net.runelite.http.service.xtea.XteaService;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.quirks.NoQuirks;

public class ServiceModule extends AbstractModule
{
	private final Service service;

	public ServiceModule(Service service)
	{
		this.service = service;
	}

	private Context getContext() throws NamingException
	{
		Context initCtx = new InitialContext();
		return (Context) initCtx.lookup("java:comp/env");
	}

	@Provides
	@Named("Runelite JDBC")
	DataSource provideDataSource()
	{
		try
		{
			return (DataSource) getContext().lookup("jdbc/runelite");
		}
		catch (NamingException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	@Provides
	@Named("Runelite SQL2O")
	Sql2o provideSql2o(@Named("Runelite JDBC") DataSource datasource)
	{
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o(datasource, new NoQuirks(converters));
	}

	@Provides
	@Named("OAuth Client ID")
	String provideOAuthClientID()
	{
		try
		{
			return (String) getContext().lookup("runelite-oauth-client-id");
		}
		catch (NamingException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	@Provides
	@Named("OAuth Client Secret")
	String provideOAuthClientSecret()
	{
		try
		{
			return (String) getContext().lookup("runelite-oauth-client-secret");
		}
		catch (NamingException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void configure()
	{
		bind(Service.class).toInstance(service);

		bind(AuthFilter.class);

		bind(AccountService.class);
		bind(ConfigService.class);
		bind(HiscoreService.class);
		bind(UpdateCheckService.class);
		bind(WorldsService.class);
		bind(XteaService.class);
	}
}
