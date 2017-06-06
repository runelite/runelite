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
package net.runelite.client.config;

import com.google.common.eventbus.EventBus;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.events.ConfigChanged;
import net.runelite.http.api.config.ConfigClient;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigManager
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);

	private static final String SETTINGS_FILE_NAME = "settings.properties";

	private final EventBus eventBus;
	private AccountSession session;
	private ConfigClient client;
	private File propertiesFile;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();

	private final List<Object> configProxies = new ArrayList<>();

	public ConfigManager(EventBus eventBus)
	{
		this.eventBus = eventBus;
		this.propertiesFile = getPropertiesFile();
	}

	public ConfigManager(EventBus eventBus, AccountSession session)
	{
		this.eventBus = eventBus;
		switchSession(session);
	}

	public Collection<Object> getConfigProxies()
	{
		return Collections.unmodifiableCollection(configProxies);
	}

	public void loadDefault()
	{
		for (Object config : configProxies)
		{
			setDefaultConfiguration(config);
		}
	}

	public final void switchSession(AccountSession session)
	{
		if (session == null)
		{
			this.session = null;
			this.client = null;
		}
		else
		{
			this.session = session;
			this.client = new ConfigClient(session.getUuid());
		}

		this.propertiesFile = getPropertiesFile();

		load(); // load profile specific config
		loadDefault(); // set defaults over anything not set
	}

	private File getPropertiesFile()
	{
		// Sessions that aren't logged in have no username
		if (session == null || session.getUsername() == null)
		{
			return new File(RuneLite.RUNELITE_DIR, SETTINGS_FILE_NAME);
		}
		else
		{
			File profileDir = new File(RuneLite.PROFILES_DIR, session.getUsername().toLowerCase());
			return new File(profileDir, SETTINGS_FILE_NAME);
		}
	}

	public void load()
	{
		if (client == null)
		{
			loadFromFile();
			return;
		}

		Configuration configuration;

		try
		{
			configuration = client.get();
		}
		catch (IOException ex)
		{
			logger.debug("Unable to load configuration from client, using saved configuration from disk", ex);
			loadFromFile();
			return;
		}

		if (configuration.getConfig().isEmpty())
		{
			logger.debug("No configuration from client, using saved configuration on disk");
			loadFromFile();
			return;
		}

		properties.clear();

		for (ConfigEntry entry : configuration.getConfig())
		{
			logger.debug("Loading configuration value from client {}: {}", entry.getKey(), entry.getValue());

			properties.setProperty(entry.getKey(), entry.getValue());
		}

		try
		{
			saveToFile();

			logger.debug("Updated configuration on disk with the latest version");
		}
		catch (IOException ex)
		{
			logger.warn("Unable to update configuration on disk", ex);
		}
	}

	private void loadFromFile()
	{
		properties.clear();

		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(in);
		}
		catch (FileNotFoundException ex)
		{
			logger.debug("Unable to load settings - no such file");
		}
		catch (IOException ex)
		{
			logger.warn("Unable to load settings", ex);
		}
	}

	private void saveToFile() throws IOException
	{
		propertiesFile.getParentFile().mkdirs();

		try (FileOutputStream out = new FileOutputStream(propertiesFile))
		{
			properties.store(out, "Runelite configuration");
		}
	}

	public <T> T getConfig(Class<T> clazz)
	{
		if (!Modifier.isPublic(clazz.getModifiers()))
		{
			throw new RuntimeException("Non-public configuration classes can't have default methods invoked");
		}

		T t = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]
		{
			clazz
		}, handler);

		configProxies.add(t);

		return t;
	}

	public String getConfiguration(String groupName, String key)
	{
		return properties.getProperty(groupName + "." + key);
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		logger.debug("Setting configuration value for {}.{} to {}", groupName, key, value);

		String oldValue = (String) properties.setProperty(groupName + "." + key, value);

		if (client != null)
		{
			try
			{
				client.set(groupName + "." + key, value);
			}
			catch (IOException ex)
			{
				logger.warn("unable to set configuration item", ex);
			}
		}

		try
		{
			saveToFile();
		}
		catch (IOException ex)
		{
			logger.warn("unable to save configuration file", ex);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);

		eventBus.post(configChanged);
	}

	public void unsetConfiguration(String groupName, String key)
	{
		logger.debug("Unsetting configuration value for {}.{}", groupName, key);

		String oldValue = (String) properties.remove(groupName + "." + key);

		if (client != null)
		{
			try
			{
				client.unset(groupName + "." + key);
			}
			catch (IOException ex)
			{
				logger.warn("unable to set configuration item", ex);
			}
		}

		try
		{
			saveToFile();
		}
		catch (IOException ex)
		{
			logger.warn("unable to save configuration file", ex);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);

		eventBus.post(configChanged);
	}

	public ConfigDescriptor getConfigDescriptor(Object configurationProxy)
	{
		Class<?> inter = configurationProxy.getClass().getInterfaces()[0];
		ConfigGroup group = inter.getAnnotation(ConfigGroup.class);

		if (group == null)
		{
			throw new IllegalArgumentException("Not a config group");
		}

		List<ConfigItemDescriptor> items = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0)
			.map(m -> new ConfigItemDescriptor(
			m.getDeclaredAnnotation(ConfigItem.class),
			m.getReturnType()
		))
			.collect(Collectors.toList());
		return new ConfigDescriptor(group, items);
	}

	private void setDefaultConfiguration(Object proxy)
	{
		Class<?> clazz = proxy.getClass().getInterfaces()[0];
		ConfigGroup group = clazz.getAnnotation(ConfigGroup.class);

		if (group == null)
		{
			return;
		}

		for (Method method : clazz.getDeclaredMethods())
		{
			ConfigItem item = method.getAnnotation(ConfigItem.class);

			if (item == null || !method.isDefault())
			{
				continue;
			}

			String current = getConfiguration(group.keyName(), item.keyName());
			if (current != null)
			{
				continue; // something else is already set
			}

			Object defaultValue;
			try
			{
				defaultValue = ConfigInvocationHandler.callDefaultMethod(proxy, method, null);
			}
			catch (Throwable ex)
			{
				logger.warn(null, ex);
				continue;
			}

			logger.debug("Setting default configuration value for {}.{} to {}", group.keyName(), item.keyName(), defaultValue);
			setConfiguration(group.keyName(), item.keyName(), defaultValue.toString());
		}
	}

	static Object stringToObject(String str, Class<?> type)
	{
		if (type == boolean.class)
		{
			return Boolean.parseBoolean(str);
		}
		return str;
	}
}
