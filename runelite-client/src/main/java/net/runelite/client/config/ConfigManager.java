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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.http.api.config.ConfigClient;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.ConfigKey;
import net.runelite.http.api.config.Configuration;

@Singleton
@Slf4j
public class ConfigManager
{
	public static final String RUNELITE_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();
	public static final ConfigKey PROFILE_KEY = new ConfigKey("", "", RUNELITE_GROUP_NAME, "profile");
	public static final ConfigKey PROFILES_KEY = new ConfigKey("", "", RUNELITE_GROUP_NAME, "profiles");

	private static final String SETTINGS_FILE_NAME = "settings.properties";
	private static final String JSON_SETTINGS_FILE_NAME = "settings.json";
	private static final Splitter SPLITTER = Splitter.on(',').omitEmptyStrings().trimResults();
	private static final Joiner JOINER = Joiner.on(',').skipNulls();
	private static final Gson GSON = new GsonBuilder().enableComplexMapKeySerialization().disableHtmlEscaping().setPrettyPrinting().create();
	private static final ConfigKey MIGRATED_KEY = new ConfigKey("", "", RUNELITE_GROUP_NAME, "migrated");

	private final EventBus eventBus;
	private final ScheduledExecutorService executor;
	private final Client RLClient;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();
	private final ConcurrentMap<ConfigKey, String> settings = new ConcurrentHashMap<>();
	private final Set<String> accountSpecificGroups = new HashSet<>();

	private AccountSession session;
	private ConfigClient client;
	private File propertiesFile;
	private File settingsFile;

	private String username = "";
	private String profile = "";

	private boolean usernameChanged = false;

	@Getter
	private boolean showTagsWarning = false;

	@Inject
	public ConfigManager(final Client RLClient, final EventBus eventBus, final ScheduledExecutorService executor)
	{
		this.eventBus = eventBus;
		this.executor = executor;
		this.propertiesFile = getPropertiesFile();
		this.settingsFile = getSettingsFile();
		this.RLClient = RLClient;
	}

	@Subscribe
	public void onUsernameChanged(final UsernameChanged event)
	{
		final String username = RLClient.getUsername();
		if (this.username.equals(username))
		{
			return;
		}

		usernameChanged = true;
		this.username = username;
		loadAccountSpecificGroups();
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGING_IN)
		{
			if (usernameChanged)
			{
				usernameChanged = false;
				postConfigEvents(true);
			}
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
		this.settingsFile = getSettingsFile();

		load(); // load profile specific config
	}

	private File getSettingsFile()
	{
		// Sessions that aren't logged in have no username
		if (session == null || session.getUsername() == null)
		{
			return new File(RuneLite.RUNELITE_DIR, JSON_SETTINGS_FILE_NAME);
		}
		else
		{
			File profileDir = new File(RuneLite.PROFILES_DIR, session.getUsername().toLowerCase());
			return new File(profileDir, JSON_SETTINGS_FILE_NAME);
		}
	}

	// TODO: Remove later
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
		settings.clear();
		accountSpecificGroups.clear();

		for (ConfigEntry entry : configuration.getConfig())
		{
			migrateConfigEntry(entry);

			ConfigKey holder = new ConfigKey(entry.getProfile(), entry.getAccount(), entry.getGroupName(), entry.getKey());
			log.debug("Loading configuration value from client {}: {}", holder, entry.getValue());

			settings.put(holder, entry.getValue());
		}

		this.profile = getProfile();

		loadAccountSpecificGroups();
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
		settings.clear();
		accountSpecificGroups.clear();

		try
		{
			Type type = new TypeToken<HashMap<ConfigKey, String>>()
			{
			}.getType();

			byte[] bytes = Files.toByteArray(settingsFile);
			final Map<ConfigKey, String> map = GSON.fromJson(new String(bytes), type);
			if (map != null)
			{
				settings.putAll(map);
			}
		}
		catch (FileNotFoundException ex)
		{
			log.debug("Unable to load settings.json - no such file");
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings.json", ex);
		}

		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(new InputStreamReader(in, Charset.forName("UTF-8")));
		}
		catch (FileNotFoundException ex)
		{
			log.debug("Unable to load settings - no such file");
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings", ex);
		}

		showTagsWarning = getConfiguration(MIGRATED_KEY) == null;
		migrateLocalProperties();
		this.profile = getProfile();
		loadAccountSpecificGroups();
		postConfigEvents(false);
	}


	// TODO: Remove later
	private static List<Pattern> MIGRATE_PATTERNS = ImmutableList.of(
		Pattern.compile("^(timetracking)\\.(.+)\\.(birdhouse\\.[0-9]+)$"),
		Pattern.compile("^(timetracking)\\.(.+)\\.([0-9]+\\.[0-9]+)$"),
		Pattern.compile("^(timetracking)\\.(.+)\\.(autoweed)$"),
		Pattern.compile("^(killcount)\\.(.+)\\.([^.]+)$"),
		Pattern.compile("^([^.]+)\\.(.+)$"));

	// TODO: Remove later
	private void migrateConfigEntry(ConfigEntry entry)
	{
		if (!Strings.isNullOrEmpty(entry.getGroupName()))
		{
			return;
		}

		String key = entry.getKey();

		ConfigKey newKey = migrateProperty(key);

		if (newKey == null)
		{
			return;
		}

		entry.setAccount(newKey.getAccount());
		entry.setKey(newKey.getKey());
		entry.setGroupName(newKey.getGroupName());

		log.debug("Migrating {} to {}", key, newKey);

		if (client != null)
		{
			client.unset(new ConfigKey("", "", "", key));
			client.set(newKey, entry.getValue());
		}
	}

	// TODO: Remove later
	private void migrateLocalProperties()
	{
		String migrated = settings.get(MIGRATED_KEY);
		if (!Strings.isNullOrEmpty(migrated))
		{
			return;
		}

		try
		{
			Map<String, String> copy = (Map) ImmutableMap.copyOf(properties);
			copy.forEach((groupAndKey, value) ->
			{
				ConfigKey newKey = migrateProperty(groupAndKey);

				if (newKey == null)
				{
					return;
				}

				settings.put(newKey, value);
				log.debug("Migrating {} to {}", groupAndKey, newKey);
			});

			settings.put(MIGRATED_KEY, "true");
			saveToFile();
		}
		catch (Exception e)
		{
			log.error("Problem migrating local properties {}", e);
		}
	}

	// TODO: Remove later
	private ConfigKey migrateProperty(String groupAndKey)
	{
		Matcher matcher = MIGRATE_PATTERNS.stream()
			.map(pattern -> pattern.matcher(groupAndKey))
			.filter(Matcher::matches)
			.findFirst()
			.orElse(null);

		if (matcher == null)
		{
			return null;
		}

		String newKey = matcher.group(2);
		String group = matcher.group(1);
		String username = "";

		if (matcher.groupCount() == 3)
		{
			username = matcher.group(2);
			newKey = matcher.group(3);
		}

		return new ConfigKey("", username, group, newKey);
	}

	private void loadAccountSpecificGroups()
	{
		accountSpecificGroups.clear();
		settings.forEach((configKey, value) ->
		{
			if (!configKey.getKey().equals("accountSpecific") || !configKey.getProfile().equals(this.profile))
			{
				return;
			}

			accountSpecificGroups.add(configKey.getGroupName());
		});
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

	public boolean isAccountSpecific(String plugin)
	{
		return accountSpecificGroups.contains(plugin);
	}

	private String getAccountStr(String plugin)
	{
		if (isAccountSpecific(plugin))
		{
			return username;
		}

		return "";
	}

	public String getProfile()
	{
		String profile = settings.get(PROFILE_KEY);
		return profile == null ? "" : profile;
	}

	public List<String> getProfiles()
	{
		String s = settings.get(PROFILES_KEY);
		if (s == null)
		{
			s = "";
		}

		return SPLITTER.splitToList(s);
	}

	public void setProfile(String profile)
	{
		if (profile != null)
		{
			this.profile = profile;
			loadAccountSpecificGroups();
			setConfiguration(PROFILE_KEY, profile);
			postConfigEvents(false);
		}
	}

	public void addProfile(String profile)
	{
		Set<String> profiles = Sets.newHashSet(getProfiles());
		if (profiles.add(profile))
		{
			setConfiguration(PROFILES_KEY, JOINER.join(profiles));
		}
	}

	public void removeProfile(String profile)
	{
		if (Strings.isNullOrEmpty(profile))
		{
			return;
		}

		Set<String> profiles = Sets.newHashSet(getProfiles());
		profiles.remove(profile);

		List<ConfigKey> keys = getConfigurationKeys(c -> profile.equals(c.getProfile()));
		keys.forEach(settings::remove);

		if (client != null)
		{
			client.unsetProfile(profile);
		}

		if (profiles.size() == 0)
		{
			unsetConfiguration(PROFILES_KEY);
		}
		else
		{
			setConfiguration(PROFILES_KEY, JOINER.join(profiles));
		}
	}


	public String getUsernameKey(final String groupName, final String key)
	{
		return getConfiguration(new ConfigKey("", this.username, groupName, key));
	}

	public void setUsernameKey(final String groupName, final String key, Object value)
	{
		setConfiguration(new ConfigKey("", this.username, groupName, key), objectToString(value));
	}

	private ConfigKey getConfigKey(String groupName, String key)
	{
		return new ConfigKey(getProfile(), getAccountStr(groupName), groupName, key);
	}

	public List<ConfigKey> getConfigurationKeys(Predicate<ConfigKey> fn)
	{
		return settings.keySet().stream().filter(fn).collect(Collectors.toList());
	}

	public String getConfiguration(final ConfigKey configKey)
	{
		return settings.get(configKey);
	}

	public String getConfiguration(String groupName, String key)
	{
		ConfigKey holder = getConfigKey(groupName, key);
		String value = settings.get(holder);
		if (!Strings.isNullOrEmpty(value))
		{
			return value;
		}

		holder.setProfile("");
		return settings.get(holder);
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
		setConfiguration(getConfigKey(groupName, key), value);
	}

	public void setConfiguration(String groupName, String key, Object value)
	{
		setConfiguration(groupName, key, objectToString(value));
	}

	public void setConfiguration(final ConfigKey configKey, String value)
	{
		log.debug("Setting configuration value for {} to {}", configKey, value);

		String oldValue = settings.put(configKey, value);

		if (Objects.equals(oldValue, value))
		{
			return;
		}

		if (client != null)
		{
			client.set(configKey, value);
		}

		saveFile();

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(configKey.getGroupName());
		configChanged.setKey(configKey.getKey());
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);

		eventBus.post(configChanged);
	}

	public void unsetConfiguration(String groupName, String key)
	{
		unsetConfiguration(getConfigKey(groupName, key));
	}

	public void unsetConfiguration(final ConfigKey configKey)
	{
		log.debug("Unsetting configuration value for {}", configKey);

		String oldValue = settings.remove(configKey);

		if (oldValue == null)
		{
			return;
		}

		if (client != null)
		{
			client.unset(configKey);
		}

		saveFile();

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(configKey.getGroupName());
		configChanged.setKey(configKey.getKey());
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

		final List<ConfigItemDescriptor> items = Arrays.stream(inter.getMethods())
			.filter(m -> m.getParameterCount() == 0)
			.map(m -> new ConfigItemDescriptor(
				m.getDeclaredAnnotation(ConfigItem.class),
				m.getReturnType(),
				m.getDeclaredAnnotation(Range.class)
			))
			.sorted((a, b) -> ComparisonChain.start()
				.compare(a.getItem().position(), b.getItem().position())
				.compare(a.getItem().name(), b.getItem().name())
				.result())
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

			log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);

			setConfiguration(group.value(), item.keyName(), valueString);
		}
	}

	private void saveFile()
	{
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
	}

	private synchronized void saveToFile() throws IOException
	{
		settingsFile.getParentFile().mkdirs();

		try (FileOutputStream out = new FileOutputStream(settingsFile))
		{
			final FileLock lock = out.getChannel().lock();

			try
			{
				out.write(GSON.toJson(settings).getBytes());
			}
			finally
			{
				lock.release();
			}
		}
	}

	private void postConfigEvents(boolean usernameOnly)
	{
		if (usernameOnly && Strings.isNullOrEmpty(this.username))
		{
			return;
		}

		settings.forEach((configKey, value) ->
		{
			if (!configKey.getProfile().equals(this.profile) ||
				(usernameOnly && !configKey.getAccount().equals(this.username) && !Strings.isNullOrEmpty(this.profile)))
			{
				return;
			}

			final ConfigChanged configChanged = new ConfigChanged();
			configChanged.setGroup(configKey.getGroupName());
			configChanged.setKey(configKey.getKey());
			configChanged.setOldValue(null);
			configChanged.setNewValue(value);
			eventBus.post(configChanged);
		});
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
