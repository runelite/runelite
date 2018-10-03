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
import com.google.common.eventbus.Subscribe;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.http.api.config.ConfigClient;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;

@Singleton
@Slf4j
public class ConfigManager
{
	private static final String SETTINGS_FILE_NAME = "settings.properties";
	private final EventBus eventBus;
	private final ScheduledExecutorService executor;
	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();
	private final List<String> accountSpecificGroups = new ArrayList<>();

	private AccountSession session;
	private ConfigClient client;
	private File propertiesFile;
	private String username;

	@Inject
	private ConfigManager(final EventBus eventBus, final ScheduledExecutorService executor)
	{
		this.eventBus = eventBus;
		this.executor = executor;
	}

	@Subscribe
	public void onUsernameChanged(final UsernameChanged event)
	{
		this.username = event.getUsername();
		postConfigEvents(true); // post updates about config if any
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

	private void postConfigEvents(boolean usernameOnly)
	{
		try
		{
			Map<String, String> copy = (Map) ImmutableMap.copyOf(properties);
			copy.forEach((groupAndKey, value) ->
			{
				final String[] split = groupAndKey.split("\\.", 2);
				if (split.length != 2)
				{
					log.debug("Properties key malformed!: {}", groupAndKey);
					return;
				}

				final String groupName = split[0];
				String key = split[1];
				boolean isUsername = false;

				// Do not propagate events for incorrect username
				if (!Strings.isNullOrEmpty(username) && accountSpecificGroups.contains(groupName))
				{
					final String[] keySplit = key.split("^" + Pattern.quote(username) + "\\.", 2);
					if (keySplit.length == 2)
					{
						key = keySplit[1];
						isUsername = true;
					}
				}

				if (usernameOnly && !isUsername)
				{
					return;
				}

				final ConfigChanged configChanged = new ConfigChanged();
				configChanged.setGroup(groupName);
				configChanged.setKey(key);
				configChanged.setOldValue(null);
				configChanged.setNewValue(value);
				log.debug("Posting config change event {}", configChanged);
				eventBus.post(configChanged);
			});
		}
		catch (Exception ex)
		{
			log.warn("Error posting config events", ex);
		}
	}

	public void load()
	{
		propertiesFile = getPropertiesFile();

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
			log.debug("Unable to load configuration from client, using saved configuration from disk", ex);
			loadFromFile();
			return;
		}

		if (configuration.getConfig().isEmpty())
		{
			log.debug("No configuration from client, using saved configuration on disk");
			loadFromFile();
			return;
		}

		properties.clear();

		for (ConfigEntry entry : configuration.getConfig())
		{
			log.debug("Loading configuration value from client {}: {}", entry.getKey(), entry.getValue());
			properties.setProperty(entry.getKey(), entry.getValue());
		}

		postConfigEvents(false);

		try
		{
			saveToFile();
			log.debug("Updated configuration on disk with the latest version");
		}
		catch (IOException ex)
		{
			log.warn("Unable to update configuration on disk", ex);
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
			log.debug("Unable to load settings - no such file");
			return;
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings", ex);
			return;
		}

		postConfigEvents(false);
	}

	private synchronized void saveToFile() throws IOException
	{
		propertiesFile.getParentFile().mkdirs();

		try (FileOutputStream out = new FileOutputStream(propertiesFile))
		{
			properties.store(out, "RuneLite configuration");
		}
	}

	public <T> T getConfig(Class<T> clazz)
	{
		if (!Modifier.isPublic(clazz.getModifiers()))
		{
			throw new RuntimeException("Non-public configuration classes can't have default methods invoked");
		}

		T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]
		{
			clazz
		}, handler);

		return t;
	}

	private String getConfigGroup(final String group)
	{
		if (!Strings.isNullOrEmpty(username) && accountSpecificGroups.contains(group))
		{
			return group + "." + username;
		}

		return group;
	}

	public String getConfiguration(String groupName, String key)
	{
		final String origGroupName = groupName;
		groupName = getConfigGroup(groupName);
		final String value = properties.getProperty(groupName + "." + key);
		return Strings.isNullOrEmpty(value) ? properties.getProperty(origGroupName + "." + key) : value;
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
				log.warn("Unable to unmarshal {}.{} ", groupName, key, e);
			}
		}
		return null;
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		final String origGroupName = groupName;
		groupName = getConfigGroup(groupName);
		log.debug("Setting configuration value for {}.{} to {}", groupName, key, value);

		String oldValue = (String) properties.setProperty(groupName + "." + key, value);

		if (client != null)
		{
			client.set(groupName + "." + key, value);
		}

		Runnable task = () ->
		{
			try
			{
				saveToFile();
			}
			catch (IOException ex)
			{
				log.warn("unable to save configuration file", ex);
			}
		};
		executor.execute(task);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(origGroupName);
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
		final String origGroupName = groupName;
		groupName = getConfigGroup(groupName);
		log.debug("Unsetting configuration value for {}.{}", groupName, key);

		String oldValue = (String) properties.remove(groupName + "." + key);

		if (client != null)
		{
			client.unset(groupName + "." + key);
		}

		Runnable task = () ->
		{
			try
			{
				saveToFile();
			}
			catch (IOException ex)
			{
				log.warn("unable to save configuration file", ex);
			}
		};
		executor.execute(task);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(origGroupName);
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

		if (group.accountSpecific())
		{
			accountSpecificGroups.add(group.value());
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

			log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);

			setConfiguration(group.value(), item.keyName(), valueString);
		}
	}

	static Object stringToObject(String str, Class<?> type)
	{
		if (type == boolean.class || type == Boolean.class)
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
			String[] splitStr = str.split("x");
			int width = Integer.parseInt(splitStr[0]);
			int height = Integer.parseInt(splitStr[1]);
			return new Dimension(width, height);
		}
		if (type == Point.class)
		{
			String[] splitStr = str.split(":");
			int width = Integer.parseInt(splitStr[0]);
			int height = Integer.parseInt(splitStr[1]);
			return new Point(width, height);
		}
		if (type == Rectangle.class)
		{
			String[] splitStr = str.split(":");
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
			String[] splitStr = str.split(":");
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
			return d.width + "x" + d.height;
		}
		if (object instanceof Point)
		{
			Point p = (Point) object;
			return p.x + ":" + p.y;
		}
		if (object instanceof Rectangle)
		{
			Rectangle r = (Rectangle) object;
			return r.x + ":" + r.y + ":" + r.width + ":" + r.height;
		}
		if (object instanceof Instant)
		{
			return ((Instant) object).toString();
		}
		if (object instanceof Keybind)
		{
			Keybind k = (Keybind) object;
			return k.getKeyCode() + ":" + k.getModifiers();
		}
		return object.toString();
	}
}
