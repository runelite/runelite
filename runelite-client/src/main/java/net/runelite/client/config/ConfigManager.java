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
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.RuneLite;
import static net.runelite.client.RuneLite.PROFILES_DIR;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Groups;
import org.apache.commons.lang3.StringUtils;
import org.jgroups.Message;
import org.jgroups.util.Util;

@Singleton
@Slf4j
public class ConfigManager
{
	private static final String STANDARD_SETTINGS_FILE_NAME = "settings.properties";
	private static final File STANDARD_SETTINGS_FILE = new File(RuneLite.RUNELITE_DIR, STANDARD_SETTINGS_FILE_NAME);
	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();
	private final Map<String, String> pendingChanges = new HashMap<>();
	private final File settingsFileInput;
	private final Groups groups;

	@Inject
	EventBus eventBus;

	@Inject
	public ConfigManager(
		@Named("config") File config,
		ScheduledExecutorService scheduledExecutorService,
		Groups groups)
	{
		this.settingsFileInput = config;
		this.groups = groups;

		scheduledExecutorService.scheduleWithFixedDelay(this::sendConfig, 30, 30, TimeUnit.SECONDS);

		groups.getMessageObjectSubject()
			.subscribe(this::receive);
	}

	@SuppressWarnings("unchecked")
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
		if (type == long.class)
		{
			return Long.parseLong(str);
		}
		if (type == Color.class)
		{
			return ColorUtil.fromString(str);
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
		if (type == Keybind.class || type == ModifierlessKeybind.class)
		{
			String[] splitStr = str.split(":");
			int code = Integer.parseInt(splitStr[0]);
			int mods = Integer.parseInt(splitStr[1]);
			if (type == ModifierlessKeybind.class)
			{
				return new ModifierlessKeybind(code, mods);
			}
			return new Keybind(code, mods);
		}
		if (type == WorldPoint.class)
		{
			String[] splitStr = str.split(":");
			int x = Integer.parseInt(splitStr[0]);
			int y = Integer.parseInt(splitStr[1]);
			int plane = Integer.parseInt(splitStr[2]);
			return new WorldPoint(x, y, plane);
		}
		if (type == Duration.class)
		{
			return Duration.ofMillis(Long.parseLong(str));
		}
		if (type == int[].class)
		{
			if (str.contains(","))
			{
				return Arrays.stream(str.split(",")).mapToInt(Integer::valueOf).toArray();
			}
			return new int[]{Integer.parseInt(str)};
		}
		if (type == EnumSet.class)
		{
			try
			{
				String substring = str.substring(str.indexOf("{") + 1, str.length() - 1);
				String[] splitStr = substring.split(", ");
				Class<? extends Enum> enumClass = null;
				if (!str.contains("{"))
				{
					return null;
				}

				enumClass = findEnumClass(str, ExternalPluginManager.pluginClassLoaders);

				EnumSet enumSet = EnumSet.noneOf(enumClass);
				for (String s : splitStr)
				{
					try
					{
						enumSet.add(Enum.valueOf(enumClass, s.replace("[", "").replace("]", "")));
					}
					catch (IllegalArgumentException ignore)
					{
						return EnumSet.noneOf(enumClass);
					}
				}
				return enumSet;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return null;
			}

		}
		if (type == Map.class)
		{
			Map<String, String> output = new HashMap<>();
			str = str.substring(1, str.length() - 1);
			String[] splitStr = str.split(", ");
			for (String s : splitStr)
			{
				String[] keyVal = s.split("=");
				if (keyVal.length > 1)
				{
					output.put(keyVal[0], keyVal[1]);
				}
			}

			return output;
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
		if (object instanceof WorldPoint)
		{
			WorldPoint wp = (WorldPoint) object;
			return wp.getX() + ":" + wp.getY() + ":" + wp.getPlane();
		}
		if (object instanceof Duration)
		{
			return Long.toString(((Duration) object).toMillis());
		}
		if (object instanceof int[])
		{
			if (((int[]) object).length == 0)
			{
				return String.valueOf(object);
			}
			return StringUtils.join(object, ",");
		}
		if (object instanceof EnumSet)
		{
			if (((EnumSet) object).size() == 0)
			{
				return getElementType((EnumSet) object).getCanonicalName() + "{}";
			}

			return ((EnumSet) object).toArray()[0].getClass().getCanonicalName() + "{" + object.toString() + "}";
		}
		if (object instanceof Number)
		{
			return String.valueOf(object);
		}
		return object.toString();
	}

	public static <T extends Enum<T>> Class<T> getElementType(EnumSet<T> enumSet)
	{
		if (enumSet.isEmpty())
		{
			enumSet = EnumSet.complementOf(enumSet);
		}
		return enumSet.iterator().next().getDeclaringClass();
	}

	public static Class<? extends Enum> findEnumClass(String clasz, ArrayList<ClassLoader> classLoaders)
	{
		StringBuilder transformedString = new StringBuilder();
		for (ClassLoader cl : classLoaders)
		{
			try
			{
				String[] strings = clasz.substring(0, clasz.indexOf("{")).split("\\.");
				int i = 0;
				while (i != strings.length)
				{
					if (i == 0)
					{
						transformedString.append(strings[i]);
					}
					else if (i == strings.length - 1)
					{
						transformedString.append("$").append(strings[i]);
					}
					else
					{
						transformedString.append(".").append(strings[i]);
					}
					i++;
				}
				return (Class<? extends Enum>) cl.loadClass(transformedString.toString());
			}
			catch (Exception e2)
			{
				// Will likely fail a lot
			}
			try
			{
				return (Class<? extends Enum>) cl.loadClass(clasz.substring(0, clasz.indexOf("{")));
			}
			catch (Exception e)
			{
				// Will likely fail a lot
			}
			transformedString = new StringBuilder();
		}
		throw new RuntimeException("Failed to find Enum for " + clasz.substring(0, clasz.indexOf("{")));
	}

	public final void switchSession()
	{
		// Ensure existing config is saved
		load();
	}

	public void load()
	{
		loadFromFile();
	}

	private synchronized void syncPropertiesFromFile(File propertiesFile)
	{
		final Properties properties = new Properties();
		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		}
		catch (Exception e)
		{
			log.debug("Malformed properties, skipping update");
			return;
		}

		@SuppressWarnings("unchecked") final Map<String, String> copy = (Map) ImmutableMap.copyOf(this.properties);
		copy.forEach((groupAndKey, value) ->
		{
			if (!properties.containsKey(groupAndKey))
			{
				final String[] split = groupAndKey.split("\\.", 2);
				if (split.length != 2)
				{
					return;
				}

				final String groupName = split[0];
				final String key = split[1];
				unsetConfiguration(groupName, key);
			}
		});

		properties.forEach((objGroupAndKey, objValue) ->
		{
			final String groupAndKey = String.valueOf(objGroupAndKey);
			final String[] split = groupAndKey.split("\\.", 2);
			if (split.length != 2)
			{
				return;
			}

			final String groupName = split[0];
			final String key = split[1];
			final String value = String.valueOf(objValue);
			setConfiguration(groupName, key, value);
		});
	}

	public void importLocal()
	{
		log.info("Nothing changed, don't worry!");
	}

	private synchronized void loadFromFile()
	{
		handler.invalidate();
		properties.clear();

		try (FileInputStream in = new FileInputStream(settingsFileInput))
		{
			properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException ex)
		{
			log.debug("Unable to load settings - no such file, syncing from standard settings");
			syncLastModified();
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings", ex);
		}

		try
		{
			@SuppressWarnings("unchecked") Map<String, String> copy = (Map) ImmutableMap.copyOf(properties);
			copy.forEach((groupAndKey, value) ->
			{
				final String[] split = groupAndKey.split("\\.", 2);
				if (split.length != 2)
				{
					log.debug("Properties key malformed!: {}", groupAndKey);
					properties.remove(groupAndKey);
					return;
				}

				final String groupName = split[0];
				final String key = split[1];

				ConfigChanged configChanged = new ConfigChanged();
				configChanged.setGroup(groupName);
				configChanged.setKey(key);
				configChanged.setOldValue(null);
				configChanged.setNewValue(value);

				eventBus.post(ConfigChanged.class, configChanged);
			});
		}
		catch (Exception ex)
		{
			log.warn("Error posting config events", ex);
		}
	}

	private void saveToFile() throws IOException
	{
		settingsFileInput.getParentFile().mkdirs();

		File tempFile = new File(RuneLite.RUNELITE_DIR, RuneLite.DEFAULT_CONFIG_FILE.getName() + ".tmp");

		try (FileOutputStream out = new FileOutputStream(tempFile))
		{
			out.getChannel().lock();
			properties.store(new OutputStreamWriter(out, StandardCharsets.UTF_8), "RuneLite configuration");
			// FileOutputStream.close() closes the associated channel, which frees the lock
		}

		try
		{
			Files.move(tempFile.toPath(), settingsFileInput.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
		}
		catch (AtomicMoveNotSupportedException ex)
		{
			log.debug("atomic move not supported", ex);
			Files.move(tempFile.toPath(), settingsFileInput.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getConfig(Class<T> clazz)
	{
		if (!Modifier.isPublic(clazz.getModifiers()))
		{
			throw new RuntimeException("Non-public configuration classes can't have default methods invoked");
		}

		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]
			{
				clazz
			}, handler);
	}

	public List<String> getConfigurationKeys(String prefix)
	{
		return properties.keySet().stream().filter(v -> ((String) v).startsWith(prefix)).map(String.class::cast).collect(Collectors.toList());
	}

	public String getConfiguration(String groupName, String key)
	{
		return properties.getProperty(groupName + "." + key);
	}

	@SuppressWarnings("unchecked")
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

	public void setConfiguration(String groupName, String key, Object value)
	{
		setConfiguration(groupName, key, objectToString(value));
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		setConfiguration(groupName, key, value, null);
	}

	public void setConfiguration(String groupName, String key, String value, String origin)
	{
		String oldValue = (String) properties.setProperty(groupName + "." + key, value);

		if (Objects.equals(oldValue, value))
		{
			return;
		}

		log.debug("Setting configuration value for {}.{} to {}", groupName, key, value);
		handler.invalidate();

		synchronized (pendingChanges)
		{
			pendingChanges.put(groupName + "." + key, value);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);
		configChanged.setOrigin(origin == null ? RuneLite.uuid : origin);
		configChanged.setPath(settingsFileInput.getAbsolutePath());

		eventBus.post(ConfigChanged.class, configChanged);

		if (origin == null)
		{
			broadcast(configChanged);
		}
	}

	public void unsetConfiguration(String groupName, String key)
	{
		unsetConfiguration(groupName, key, null);
	}

	public void unsetConfiguration(String groupName, String key, String origin)
	{
		String oldValue = (String) properties.remove(groupName + "." + key);

		if (oldValue == null)
		{
			return;
		}

		log.debug("Unsetting configuration value for {}.{}", groupName, key);
		handler.invalidate();

		synchronized (pendingChanges)
		{
			pendingChanges.put(groupName + "." + key, null);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setOrigin(origin == null ? RuneLite.uuid : origin);
		configChanged.setPath(settingsFileInput.getAbsolutePath());

		eventBus.post(ConfigChanged.class, configChanged);

		if (origin == null)
		{
			broadcast(configChanged);
		}
	}

	public ConfigDescriptor getConfigDescriptor(Object configurationProxy)
	{
		Class<?> inter = configurationProxy.getClass().getInterfaces()[0];
		ConfigGroup group = inter.getAnnotation(ConfigGroup.class);

		if (group == null)
		{
			throw new IllegalArgumentException("Not a config group");
		}

		final List<ConfigSection> sections = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0 && m.isAnnotationPresent(ConfigSection.class) && m.getReturnType() == boolean.class)
			.map(m -> m.getDeclaredAnnotation(ConfigSection.class))
			.sorted((a, b) -> ComparisonChain.start()
				.compare(a.position(), b.position())
				.compare(a.name(), b.name())
				.result())
			.collect(Collectors.toList());

		final List<ConfigTitleSection> titleSections = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0 && m.isAnnotationPresent(ConfigTitleSection.class))
			.map(m -> m.getDeclaredAnnotation(ConfigTitleSection.class))
			.sorted((a, b) -> ComparisonChain.start()
				.compare(a.position(), b.position())
				.compare(a.name(), b.name())
				.result())
			.collect(Collectors.toList());

		final List<ConfigItemDescriptor> items = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0 && m.isAnnotationPresent(ConfigItem.class))
			.map(m -> new ConfigItemDescriptor(
				m.getDeclaredAnnotation(ConfigItem.class),
				m.getReturnType(),
				m.getDeclaredAnnotation(Range.class),
				m.getDeclaredAnnotation(Alpha.class),
				m.getDeclaredAnnotation(Units.class)
			))
			.sorted((a, b) -> ComparisonChain.start()
				.compare(a.getItem().position(), b.getItem().position())
				.compare(a.getItem().name(), b.getItem().name())
				.result())
			.collect(Collectors.toList());

		return new ConfigDescriptor(group, sections, titleSections, items);
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
				// This checks if it is set and is also unmarshallable to the correct type; so
				// we will overwrite invalid config values with the default
				Object current = getConfiguration(group.value(), item.keyName(), method.getReturnType());
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
			// null and the empty string are treated identically in sendConfig and treated as an unset
			// If a config value defaults to "" and the current value is null, it will cause an extra
			// unset to be sent, so treat them as equal
			if (Objects.equals(current, valueString) || (Strings.isNullOrEmpty(current) && Strings.isNullOrEmpty(valueString)))
			{
				continue; // already set to the default value
			}

			log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);

			setConfiguration(group.value(), item.keyName(), valueString);
		}
	}

	/**
	 * Initialize the configuration from the default settings, for an external Plugin
	 *
	 * @param proxy
	 */
	public void setDefaultConfiguration(Object proxy, boolean override, Plugin plugin)
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
				// This checks if it is set and is also unmarshallable to the correct type; so
				// we will overwrite invalid config values with the default
				Object current = getConfiguration(group.value(), item.keyName(), method.getReturnType());
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
			// null and the empty string are treated identically in sendConfig and treated as an unset
			// If a config value defaults to "" and the current value is null, it will cause an extra
			// unset to be sent, so treat them as equal
			if (Objects.equals(current, valueString) || (Strings.isNullOrEmpty(current) && Strings.isNullOrEmpty(valueString)))
			{
				continue; // already set to the default value
			}

			log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);

			setConfiguration(group.value(), item.keyName(), valueString);
		}
	}

	public void sendConfig()
	{
		boolean changed;
		synchronized (pendingChanges)
		{
			changed = !pendingChanges.isEmpty();
			pendingChanges.clear();
		}

		if (changed)
		{
			try
			{
				saveToFile();
			}
			catch (IOException ex)
			{
				log.warn("unable to save configuration file", ex);
			}
		}
	}

	private void syncLastModified()
	{
		File newestFile;

		newestFile = STANDARD_SETTINGS_FILE;

		File[] profileDirFiles = PROFILES_DIR.listFiles();

		if (profileDirFiles != null)
		{
			for (File profileDir : profileDirFiles)
			{
				if (!profileDir.isDirectory())
				{
					continue;
				}

				File[] settingsFiles = profileDir.listFiles();

				if (settingsFiles == null)
				{
					continue;
				}

				for (File settings : settingsFiles)
				{
					if (!settings.getName().equals(STANDARD_SETTINGS_FILE_NAME) ||
						settings.lastModified() < newestFile.lastModified())
					{
						continue;
					}

					newestFile = settings;
				}
			}
		}

		syncPropertiesFromFile(newestFile);
	}

	private void broadcast(ConfigChanged configChanged)
	{
		groups.sendConfig(null, configChanged);
	}

	public void receive(Message message)
	{
		if (message.getObject() instanceof String)
		{
			return;
		}

		try
		{
			ConfigChanged configChanged = Util.objectFromByteBuffer(message.getBuffer());

			if (!configChanged.getPath().equals(settingsFileInput.getAbsolutePath()))
			{
				return;
			}

			if (configChanged.getNewValue() == null)
			{
				unsetConfiguration(configChanged.getGroup(), configChanged.getKey(), configChanged.getOrigin());
			}
			else
			{
				setConfiguration(configChanged.getGroup(), configChanged.getKey(), configChanged.getNewValue(), configChanged.getOrigin());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}