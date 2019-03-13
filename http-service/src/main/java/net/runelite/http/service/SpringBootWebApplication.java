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

import ch.qos.logback.classic.LoggerContext;
import com.google.common.base.Strings;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.util.InstantConverter;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.quirks.NoQuirks;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@Slf4j
public class SpringBootWebApplication extends SpringBootServletInitializer
{
	@Bean
	protected ServletContextListener listener()
	{
		return new ServletContextListener()
		{
			@Override
			public void contextInitialized(ServletContextEvent sce)
			{
				log.info("RuneLite API started");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce)
			{
				// Destroy okhttp client
				OkHttpClient client = RuneLiteAPI.CLIENT;
				client.dispatcher().executorService().shutdown();
				client.connectionPool().evictAll();
				try
				{
					Cache cache = client.cache();
					if (cache != null)
					{
						cache.close();
					}
				}
				catch (IOException ex)
				{
					log.warn(null, ex);
				}

				log.info("RuneLite API stopped");
			}

		};
	}

	@ConfigurationProperties(prefix = "datasource.runelite")
	@Bean("dataSourceRuneLite")
	public DataSourceProperties dataSourceProperties()
	{
		return new DataSourceProperties();
	}

	@ConfigurationProperties(prefix = "datasource.runelite-cache")
	@Bean("dataSourceRuneLiteCache")
	public DataSourceProperties dataSourcePropertiesCache()
	{
		return new DataSourceProperties();
	}

	@ConfigurationProperties(prefix = "datasource.runelite-tracker")
	@Bean("dataSourceRuneLiteTracker")
	public DataSourceProperties dataSourcePropertiesTracker()
	{
		return new DataSourceProperties();
	}

	@Bean(value = "runelite", destroyMethod = "")
	public DataSource runeliteDataSource(@Qualifier("dataSourceRuneLite") DataSourceProperties dataSourceProperties)
	{
		return getDataSource(dataSourceProperties);
	}

	@Bean(value = "runelite-cache", destroyMethod = "")
	public DataSource runeliteCache2DataSource(@Qualifier("dataSourceRuneLiteCache") DataSourceProperties dataSourceProperties)
	{
		return getDataSource(dataSourceProperties);
	}

	@Bean(value = "runelite-tracker", destroyMethod = "")
	public DataSource runeliteTrackerDataSource(@Qualifier("dataSourceRuneLiteTracker") DataSourceProperties dataSourceProperties)
	{
		return getDataSource(dataSourceProperties);
	}

	@Bean("Runelite SQL2O")
	public Sql2o sql2o(@Qualifier("runelite") DataSource dataSource)
	{
		return createSql2oFromDataSource(dataSource);
	}

	@Bean("Runelite Cache SQL2O")
	public Sql2o cacheSql2o(@Qualifier("runelite-cache") DataSource dataSource)
	{
		return createSql2oFromDataSource(dataSource);
	}

	@Bean("Runelite XP Tracker SQL2O")
	public Sql2o trackerSql2o(@Qualifier("runelite-tracker") DataSource dataSource)
	{
		return createSql2oFromDataSource(dataSource);
	}

	private static DataSource getDataSource(DataSourceProperties dataSourceProperties)
	{
		if (!Strings.isNullOrEmpty(dataSourceProperties.getJndiName()))
		{
			// Use JNDI provided datasource, which is already configured with pooling
			JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
			return dataSourceLookup.getDataSource(dataSourceProperties.getJndiName());
		}
		else
		{
			return dataSourceProperties.initializeDataSourceBuilder().build();
		}
	}

	private static Sql2o createSql2oFromDataSource(final DataSource dataSource)
	{
		final Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o(dataSource, new NoQuirks(converters));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(SpringBootWebApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		super.onStartup(servletContext);
		ILoggerFactory loggerFactory = StaticLoggerBinder.getSingleton().getLoggerFactory();
		if (loggerFactory instanceof LoggerContext)
		{
			LoggerContext loggerContext = (LoggerContext) loggerFactory;
			loggerContext.setPackagingDataEnabled(false);
			log.debug("Disabling logback packaging data");
		}
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
