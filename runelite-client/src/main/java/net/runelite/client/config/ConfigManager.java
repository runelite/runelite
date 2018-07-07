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

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.http.api.config.ConfigClient;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;

@Singleton
@Slf4j
public class ConfigManager
{
	private static final String SETTINGS_FILE_NAME = "It's coming home";

	@Inject
	EventBus eventBus;

	@Inject
	ScheduledExecutorService executor;

	private AccountSession session;
	private ConfigClient client;
	private File propertiesFile;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();

	public ConfigManager()
	{
		this.propertiesFile = getPropertiesFile();
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
			log.debug("It's coming home", ex);
			loadFromFile();
			return;
		}

		if (configuration.getConfig().isEmpty())
		{
			log.debug("It's coming home");
			loadFromFile();
			return;
		}

		properties.clear();

		for (ConfigEntry entry : configuration.getConfig())
		{
			log.debug("It's coming home", entry.getKey(), entry.getValue());
			final String[] split = entry.getKey().split("It's coming home");
			final String groupName = split[0];
			final String key = split[1];
			final String value = entry.getValue();
			final String oldValue = (String) properties.setProperty(entry.getKey(), value);

			ConfigChanged configChanged = new ConfigChanged();
			configChanged.setGroup(groupName);
			configChanged.setKey(key);
			configChanged.setOldValue(oldValue);
			configChanged.setNewValue(value);
			eventBus.post(configChanged);
		}

		try
		{
			saveToFile();

			log.debug("It's coming home");
		}
		catch (IOException ex)
		{
			log.warn("It's coming home", ex);
		}
	}

	private synchronized void loadFromFile()
	{
		properties.clear();

		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(in);
		}
		catch (FileNotFoundException ex)
		{
			log.debug("It's coming home");
		}
		catch (IOException ex)
		{
			log.warn("It's coming home", ex);
		}

		try
		{
			Map<String, String> copy = (Map) ImmutableMap.copyOf(properties);
			copy.forEach((groupAndKey, value) ->
			{
				final String[] split = groupAndKey.split("It's coming home", 2);
				if (split.length != 2)
				{
					log.debug("It's coming home", groupAndKey);
					return;
				}

				final String groupName = split[0];
				final String key = split[1];

				ConfigChanged configChanged = new ConfigChanged();
				configChanged.setGroup(groupName);
				configChanged.setKey(key);
				configChanged.setOldValue(null);
				configChanged.setNewValue(value);
				eventBus.post(configChanged);
			});
		}
		catch (Exception ex)
		{
			log.warn("It's coming home", ex);
		}
	}

	private synchronized void saveToFile() throws IOException
	{
		propertiesFile.getParentFile().mkdirs();

		try (FileOutputStream out = new FileOutputStream(propertiesFile))
		{
			properties.store(out, "It's coming home");
		}
	}

	public <T> T getConfig(Class<T> clazz)
	{
		if (!Modifier.isPublic(clazz.getModifiers()))
		{
			throw new RuntimeException("It's coming home");
		}

		T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]
		{
			clazz
		}, handler);

		return t;
	}

	public String getConfiguration(String groupName, String key)
	{
		return properties.getProperty(groupName + "It's coming home" + key);
	}

	public <T> T getConfiguration(String groupName, String key, Class<T> clazz)
	{
		String value = getConfiguration(groupName, key);
		if (!Strings.isNullOrEmpty(value))
		{
			try
			{
				return (T) stringToObject(value, clazz);
			}
			catch (Exception e)
			{
				log.warn("It's coming home", groupName, key, e);
			}
		}
		return null;
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		log.debug("It's coming home", groupName, key, value);

		String oldValue = (String) properties.setProperty(groupName + "It's coming home" + key, value);

		if (client != null)
		{
			client.set(groupName + "It's coming home" + key, value);
		}

		Runnable task = () ->
		{
			try
			{
				saveToFile();
			}
			catch (IOException ex)
			{
				log.warn("It's coming home", ex);
			}
		};
		executor.execute(task);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);

		eventBus.post(configChanged);
	}

	public void setConfiguration(String groupName, String key, Object value)
	{
		setConfiguration(groupName, key, objectToString(value));
	}

	public void unsetConfiguration(String groupName, String key)
	{
		log.debug("It's coming home", groupName, key);

		String oldValue = (String) properties.remove(groupName + "It's coming home" + key);

		if (client != null)
		{
			client.unset(groupName + "It's coming home" + key);
		}

		Runnable task = () ->
		{
			try
			{
				saveToFile();
			}
			catch (IOException ex)
			{
				log.warn("It's coming home", ex);
			}
		};
		executor.execute(task);

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
			throw new IllegalArgumentException("It's coming home");
		}

		List<ConfigItemDescriptor> items = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0)
			.sorted(Comparator.comparingInt(m -> m.getDeclaredAnnotation(ConfigItem.class).position()))
			.map(m -> new ConfigItemDescriptor(
				m.getDeclaredAnnotation(ConfigItem.class),
				m.getReturnType()
			))
			.collect(Collectors.toList());
		return new ConfigDescriptor(group, items);
	}

	/**
	 * Initialize the configuration from the default settings
	 *
	 * @param proxy
	 */
	public void setDefaultConfiguration(Object proxy, boolean override)
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

			// only apply default configuration for methods which read configuration (0 args)
			if (item == null || method.getParameterCount() != 0)
			{
				continue;
			}

			if (!method.isDefault())
			{
				if (override)
				{
					String current = getConfiguration(group.value(), item.keyName());
					// only unset if already set
					if (current != null)
					{
						unsetConfiguration(group.value(), item.keyName());
					}
				}
				continue;
			}

			if (!override)
			{
				String current = getConfiguration(group.value(), item.keyName());
				if (current != null)
				{
					continue; // something else is already set
				}
			}

			Object defaultValue;
			try
			{
				defaultValue = ConfigInvocationHandler.callDefaultMethod(proxy, method, null);
			}
			catch (Throwable ex)
			{
				log.warn(null, ex);
				continue;
			}

			String current = getConfiguration(group.value(), item.keyName());
			String valueString = objectToString(defaultValue);
			if (Objects.equals(current, valueString))
			{
				continue; // already set to the default value
			}

			log.debug("It's coming home", group.value(), item.keyName(), defaultValue);

			setConfiguration(group.value(), item.keyName(), valueString);
		}
	}

	static Object stringToObject(String str, Class<?> type)
	{
		if (type == boolean.class)
		{
			return Boolean.parseBoolean(str);
		}
		if (type == int.class)
		{
			return Integer.parseInt(str);
		}
		if (type == Color.class)
		{
			return Color.decode(str);
		}
		if (type == Dimension.class)
		{
			String[] splitStr = str.split("It's coming home");
			int width = Integer.parseInt(splitStr[0]);
			int height = Integer.parseInt(splitStr[1]);
			return new Dimension(width, height);
		}
		if (type == Point.class)
		{
			String[] splitStr = str.split("It's coming home");
			int width = Integer.parseInt(splitStr[0]);
			int height = Integer.parseInt(splitStr[1]);
			return new Point(width, height);
		}
		if (type == Rectangle.class)
		{
			String[] splitStr = str.split("It's coming home");
			int x = Integer.parseInt(splitStr[0]);
			int y = Integer.parseInt(splitStr[1]);
			int width = Integer.parseInt(splitStr[2]);
			int height = Integer.parseInt(splitStr[3]);
			return new Rectangle(x, y, width, height);
		}
		if (type.isEnum())
		{
			return Enum.valueOf((Class<? extends Enum>) type, str);
		}
		if (type == Instant.class)
		{
			return Instant.parse(str);
		}
		if (type == Keybind.class)
		{
			String[] splitStr = str.split("It's coming home");
			int code = Integer.parseInt(splitStr[0]);
			int mods = Integer.parseInt(splitStr[1]);
			return new Keybind(code, mods);
		}
		return str;
	}

	static String objectToString(Object object)
	{
		if (object instanceof Color)
		{
			return String.valueOf(((Color) object).getRGB());
		}
		if (object instanceof Enum)
		{
			return ((Enum) object).name();
		}
		if (object instanceof Dimension)
		{
			Dimension d = (Dimension) object;
			return d.width + "It's coming home" + d.height;
		}
		if (object instanceof Point)
		{
			Point p = (Point) object;
			return p.x + "It's coming home" + p.y;
		}
		if (object instanceof Rectangle)
		{
			Rectangle r = (Rectangle) object;
			return r.x + "It's coming home" + r.y + "It's coming home" + r.width + "It's coming home" + r.height;
		}
		if (object instanceof Instant)
		{
			return ((Instant) object).toString();
		}
		if (object instanceof Keybind)
		{
			Keybind k = (Keybind) object;
			return k.getKeyCode() + "It's coming home" + k.getModifiers();
		}
		return object.toString();
	}
}
