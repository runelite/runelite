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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
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
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.WorldChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.config.ConfigClient;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;
import okhttp3.OkHttpClient;

@Singleton
@Slf4j
public class ConfigManager
{
	public static final String RSPROFILE_GROUP = "rsprofile";

	private static final String RSPROFILE_DISPLAY_NAME = "displayName";
	private static final String RSPROFILE_TYPE = "type";
	private static final String RSPROFILE_LOGIN_HASH = "loginHash";
	private static final String RSPROFILE_LOGIN_SALT = "loginSalt";

	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	@VisibleForTesting
	static final Pattern KEY_SPLITTER = Pattern.compile("([^.]+)\\.(?:(" + RSPROFILE_GROUP + "\\.[^.]+)\\.)?(.*)");
	private static final int KEY_SPLITTER_GROUP = 1;
	private static final int KEY_SPLITTER_PROFILE = 2;
	private static final int KEY_SPLITTER_KEY = 3;

	private final File settingsFileInput;
	private final EventBus eventBus;
	private final OkHttpClient okHttpClient;

	private AccountSession session;
	private ConfigClient configClient;
	private File propertiesFile;

	@Nullable
	private final Client client;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Properties properties = new Properties();
	private final Map<String, String> pendingChanges = new HashMap<>();

	// null => we need to make a new profile
	@Nullable
	private String rsProfileKey;

	@Inject
	public ConfigManager(
		@Named("config") File config,
		ScheduledExecutorService scheduledExecutorService,
		EventBus eventBus,
		OkHttpClient okHttpClient,
		@Nullable Client client)
	{
		this.settingsFileInput = config;
		this.eventBus = eventBus;
		this.okHttpClient = okHttpClient;
		this.client = client;
		this.propertiesFile = getPropertiesFile();

		scheduledExecutorService.scheduleWithFixedDelay(this::sendConfig, 30, 30, TimeUnit.SECONDS);
	}

	public final void switchSession(AccountSession session)
	{
		// Ensure existing config is saved
		sendConfig();

		if (session == null)
		{
			this.session = null;
			this.configClient = null;
		}
		else
		{
			this.session = session;
			this.configClient = new ConfigClient(okHttpClient, session.getUuid());
		}

		this.propertiesFile = getPropertiesFile();

		load(); // load profile specific config
	}

	private File getLocalPropertiesFile()
	{
		return settingsFileInput;
	}

	private File getPropertiesFile()
	{
		// Sessions that aren't logged in have no username
		if (session == null || session.getUsername() == null)
		{
			return getLocalPropertiesFile();
		}
		else
		{
			File profileDir = new File(RuneLite.PROFILES_DIR, session.getUsername().toLowerCase());
			return new File(profileDir, RuneLite.DEFAULT_CONFIG_FILE.getName());
		}
	}

	public void load()
	{
		if (configClient == null)
		{
			loadFromFile();
			return;
		}

		Configuration configuration;

		try
		{
			configuration = configClient.get();
		}
		catch (IOException ex)
		{
			log.debug("Unable to load configuration from client, using saved configuration from disk", ex);
			loadFromFile();
			return;
		}

		if (configuration.getConfig() == null || configuration.getConfig().isEmpty())
		{
			log.debug("No configuration from client, using saved configuration on disk");
			loadFromFile();
			return;
		}

		handler.invalidate();
		properties.clear();

		for (ConfigEntry entry : configuration.getConfig())
		{
			log.debug("Loading configuration value from client {}: {}", entry.getKey(), entry.getValue());

			Matcher matcher = KEY_SPLITTER.matcher(entry.getKey());
			if (!matcher.find())
			{
				continue;
			}

			final String groupName = matcher.group(KEY_SPLITTER_GROUP);
			final String profile = matcher.group(KEY_SPLITTER_PROFILE);
			final String key = matcher.group(KEY_SPLITTER_KEY);
			final String value = entry.getValue();
			final String oldValue = (String) properties.setProperty(entry.getKey(), value);

			ConfigChanged configChanged = new ConfigChanged();
			configChanged.setGroup(groupName);
			configChanged.setProfile(profile);
			configChanged.setKey(key);
			configChanged.setOldValue(oldValue);
			configChanged.setNewValue(value);
			eventBus.post(configChanged);
		}

		migrateConfig();

		try
		{
			saveToFile(propertiesFile);

			log.debug("Updated configuration on disk with the latest version");
		}
		catch (IOException ex)
		{
			log.warn("Unable to update configuration on disk", ex);
		}
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

		final Map<String, String> copy = (Map) ImmutableMap.copyOf(this.properties);
		copy.forEach((wholeKey, value) ->
		{
			if (!properties.containsKey(wholeKey))
			{
				Matcher matcher = KEY_SPLITTER.matcher(wholeKey);
				if (!matcher.find())
				{
					return;
				}

				String groupName = matcher.group(KEY_SPLITTER_GROUP);
				String profile = matcher.group(KEY_SPLITTER_PROFILE);
				String key = matcher.group(KEY_SPLITTER_KEY);
				unsetConfiguration(groupName, profile, key);
			}
		});

		properties.forEach((wholeKey, objValue) ->
		{
			Matcher matcher = KEY_SPLITTER.matcher((String) wholeKey);
			if (!matcher.find())
			{
				return;
			}

			String groupName = matcher.group(KEY_SPLITTER_GROUP);
			String profile = matcher.group(KEY_SPLITTER_PROFILE);
			String key = matcher.group(KEY_SPLITTER_KEY);
			String value = String.valueOf(objValue);
			setConfiguration(groupName, profile, key, value);
		});

		migrateConfig();
	}

	public Future<Void> importLocal()
	{
		if (session == null)
		{
			// No session, no import
			return null;
		}

		final File file = new File(propertiesFile.getParent(), propertiesFile.getName() + "." + TIME_FORMAT.format(new Date()));

		try
		{
			saveToFile(file);
		}
		catch (IOException e)
		{
			log.warn("Backup failed, skipping import", e);
			return null;
		}

		syncPropertiesFromFile(getLocalPropertiesFile());

		return sendConfig();
	}

	private synchronized void loadFromFile()
	{
		handler.invalidate();
		properties.clear();

		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException ex)
		{
			log.debug("Unable to load settings - no such file");
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings", ex);
		}

		try
		{
			Map<String, String> copy = (Map) ImmutableMap.copyOf(properties);
			copy.forEach((wholeKey, value) ->
			{
				Matcher matcher = KEY_SPLITTER.matcher(wholeKey);
				if (!matcher.find())
				{
					log.debug("Properties key malformed!: {}", wholeKey);
					properties.remove(wholeKey);
					return;
				}

				String groupName = matcher.group(KEY_SPLITTER_GROUP);
				String profile = matcher.group(KEY_SPLITTER_PROFILE);
				String key = matcher.group(KEY_SPLITTER_KEY);

				ConfigChanged configChanged = new ConfigChanged();
				configChanged.setGroup(groupName);
				configChanged.setProfile(profile);
				configChanged.setKey(key);
				configChanged.setOldValue(null);
				configChanged.setNewValue(value);
				eventBus.post(configChanged);
			});
		}
		catch (Exception ex)
		{
			log.warn("Error posting config events", ex);
		}

		migrateConfig();
	}

	private void saveToFile(final File propertiesFile) throws IOException
	{
		File parent = propertiesFile.getParentFile();

		parent.mkdirs();

		File tempFile = new File(parent, RuneLite.DEFAULT_CONFIG_FILE.getName() + ".tmp");

		try (FileOutputStream out = new FileOutputStream(tempFile))
		{
			out.getChannel().lock();
			properties.store(new OutputStreamWriter(out, StandardCharsets.UTF_8), "RuneLite configuration");
			// FileOutputStream.close() closes the associated channel, which frees the lock
		}

		try
		{
			Files.move(tempFile.toPath(), propertiesFile.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
		}
		catch (AtomicMoveNotSupportedException ex)
		{
			log.debug("atomic move not supported", ex);
			Files.move(tempFile.toPath(), propertiesFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public <T extends Config> T getConfig(Class<T> clazz)
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

	public List<String> getConfigurationKeys(String prefix)
	{
		return properties.keySet().stream().filter(v -> ((String) v).startsWith(prefix)).map(String.class::cast).collect(Collectors.toList());
	}

	public static String getWholeKey(String groupName, String profile, String key)
	{
		if (profile == null)
		{
			return groupName + "." + key;
		}
		else
		{
			return groupName + "." + profile + "." + key;
		}
	}

	public String getConfiguration(String groupName, String key)
	{
		return getConfiguration(groupName, null, key);
	}

	public String getRSProfileConfiguration(String groupName, String key)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return null;
		}

		return getConfiguration(groupName, rsProfileKey, key);
	}

	public String getConfiguration(String groupName, String profile, String key)
	{
		return properties.getProperty(getWholeKey(groupName, profile, key));
	}

	public <T> T getConfiguration(String groupName, String key, Class<T> clazz)
	{
		return getConfiguration(groupName, null, key, clazz);
	}

	public <T> T getRSProfileConfiguration(String groupName, String key, Class<T> clazz)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return null;
		}

		return getConfiguration(groupName, rsProfileKey, key, clazz);
	}

	public <T> T getConfiguration(String groupName, String profile, String key, Class<T> clazz)
	{
		String value = getConfiguration(groupName, profile, key);
		if (!Strings.isNullOrEmpty(value))
		{
			try
			{
				return (T) stringToObject(value, clazz);
			}
			catch (Exception e)
			{
				log.warn("Unable to unmarshal {} ", getWholeKey(groupName, profile, key), e);
			}
		}
		return null;
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		setConfiguration(groupName, null, key, value);
	}

	public void setConfiguration(String groupName, String profile, String key, String value)
	{
		assert !key.startsWith(RSPROFILE_GROUP + ".");
		String wholeKey = getWholeKey(groupName, profile, key);
		String oldValue = (String) properties.setProperty(wholeKey, value);

		if (Objects.equals(oldValue, value))
		{
			return;
		}

		log.debug("Setting configuration value for {} to {}", wholeKey, value);
		handler.invalidate();

		synchronized (pendingChanges)
		{
			pendingChanges.put(wholeKey, value);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setProfile(profile);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);

		eventBus.post(configChanged);
	}

	public void setConfiguration(String groupName, String profile, String key, Object value)
	{
		setConfiguration(groupName, profile, key, objectToString(value));
	}

	public void setConfiguration(String groupName, String key, Object value)
	{
		setConfiguration(groupName, null, key, value);
	}

	public void setRSProfileConfiguration(String groupName, String key, Object value)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			if (client == null)
			{
				log.warn("trying to use profile without injected client");
				return;
			}

			String displayName = null;
			Player p = client.getLocalPlayer();
			if (p == null)
			{
				log.warn("trying to create profile without display name");
			}
			else
			{
				displayName = p.getName();
			}

			String username = client.getUsername();
			if (Strings.isNullOrEmpty(username))
			{
				log.warn("trying to create profile without a set username");
				return;
			}

			RuneScapeProfile prof = findRSProfile(getRSProfiles(), username, RuneScapeProfileType.getCurrent(client), displayName, true);
			rsProfileKey = prof.getKey();
			this.rsProfileKey = rsProfileKey;
		}
		setConfiguration(groupName, rsProfileKey, key, value);
	}

	public void unsetConfiguration(String groupName, String key)
	{
		unsetConfiguration(groupName, null, key);
	}

	public void unsetConfiguration(String groupName, String profile, String key)
	{
		assert !key.startsWith(RSPROFILE_GROUP + ".");
		String wholeKey = getWholeKey(groupName, profile, key);
		String oldValue = (String) properties.remove(wholeKey);

		if (oldValue == null)
		{
			return;
		}

		log.debug("Unsetting configuration value for {}", wholeKey);
		handler.invalidate();

		synchronized (pendingChanges)
		{
			pendingChanges.put(wholeKey, null);
		}

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);

		eventBus.post(configChanged);
	}

	public void unsetRSProfileConfiguration(String groupName, String key)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return;
		}

		unsetConfiguration(groupName, rsProfileKey, key);
	}

	public ConfigDescriptor getConfigDescriptor(Config configurationProxy)
	{
		Class<?> inter = configurationProxy.getClass().getInterfaces()[0];
		ConfigGroup group = inter.getAnnotation(ConfigGroup.class);

		if (group == null)
		{
			throw new IllegalArgumentException("Not a config group");
		}

		final List<ConfigSectionDescriptor> sections = Arrays.stream(inter.getDeclaredFields())
			.filter(m -> m.isAnnotationPresent(ConfigSection.class) && m.getType() == String.class)
			.map(m ->
			{
				try
				{
					return new ConfigSectionDescriptor(
						String.valueOf(m.get(inter)),
						m.getDeclaredAnnotation(ConfigSection.class)
					);
				}
				catch (IllegalAccessException e)
				{
					log.warn("Unable to load section {}::{}", inter.getSimpleName(), m.getName());
					return null;
				}
			})
			.filter(Objects::nonNull)
			.sorted((a, b) -> ComparisonChain.start()
				.compare(a.getSection().position(), b.getSection().position())
				.compare(a.getSection().name(), b.getSection().name())
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

		return new ConfigDescriptor(group, sections, items);
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
		if (type == byte[].class)
		{
			return Base64.getUrlDecoder().decode(str);
		}
		return str;
	}

	@Nullable
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
		if (object instanceof byte[])
		{
			return Base64.getUrlEncoder().encodeToString((byte[]) object);
		}
		return object == null ? null : object.toString();
	}

	@Subscribe(priority = 100)
	private void onClientShutdown(ClientShutdown e)
	{
		Future<Void> f = sendConfig();
		if (f != null)
		{
			e.waitFor(f);
		}
	}

	@Nullable
	private CompletableFuture<Void> sendConfig()
	{
		CompletableFuture<Void> future = null;
		synchronized (pendingChanges)
		{
			if (pendingChanges.isEmpty())
			{
				return null;
			}

			if (configClient != null)
			{
				Configuration patch = new Configuration(pendingChanges.entrySet().stream()
					.map(e -> new ConfigEntry(e.getKey(), e.getValue()))
					.collect(Collectors.toList()));

				future = configClient.patch(patch);
			}

			pendingChanges.clear();
		}

		try
		{
			saveToFile(propertiesFile);
		}
		catch (IOException ex)
		{
			log.warn("unable to save configuration file", ex);
		}

		return future;
	}

	public List<RuneScapeProfile> getRSProfiles()
	{
		String prefix = RSPROFILE_GROUP + "." + RSPROFILE_GROUP + ".";
		Set<String> profileKeys = new HashSet<>();
		for (Object oKey : properties.keySet())
		{
			String key = (String) oKey;
			if (!key.startsWith(prefix))
			{
				continue;
			}

			Matcher m = KEY_SPLITTER.matcher(key);
			if (!m.find())
			{
				continue;
			}

			profileKeys.add(m.group(KEY_SPLITTER_PROFILE));
		}

		return profileKeys.stream()
			.map(key ->
			{
				RuneScapeProfile prof = new RuneScapeProfile(
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_DISPLAY_NAME),
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_TYPE, RuneScapeProfileType.class),
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_LOGIN_HASH, byte[].class),
					key
				);

				return prof;
			})
			.collect(Collectors.toList());
	}

	private synchronized RuneScapeProfile findRSProfile(List<RuneScapeProfile> profiles, String username, RuneScapeProfileType type, String displayName, boolean create)
	{
		byte[] salt = getConfiguration(RSPROFILE_GROUP, RSPROFILE_LOGIN_SALT, byte[].class);
		if (salt == null)
		{
			salt = new byte[15];
			new SecureRandom()
				.nextBytes(salt);
			setConfiguration(RSPROFILE_GROUP, RSPROFILE_LOGIN_SALT, salt);
		}

		Hasher h = Hashing.sha512().newHasher();
		h.putBytes(salt);
		h.putString(username.toLowerCase(Locale.US), StandardCharsets.UTF_8);
		byte[] loginHash = h.hash().asBytes();

		Set<RuneScapeProfile> matches = profiles.stream()
			.filter(p -> Arrays.equals(p.getLoginHash(), loginHash) && p.getType() == type)
			.collect(Collectors.toSet());

		if (matches.size() > 1)
		{
			log.warn("multiple matching profiles");
		}

		if (matches.size() >= 1)
		{
			return matches.iterator().next();
		}

		if (!create)
		{
			return null;
		}

		// generate the new key deterministically so if you "create" the same profile on 2 different clients it doesn't duplicate
		Set<String> keys = profiles.stream().map(RuneScapeProfile::getKey).collect(Collectors.toSet());
		byte[] key = Arrays.copyOf(loginHash, 6);
		key[0] += type.ordinal();
		for (int i = 0; i < 0xFF; i++, key[1]++)
		{
			String keyStr = RSPROFILE_GROUP + "." + Base64.getUrlEncoder().encodeToString(key);
			if (!keys.contains(keyStr))
			{
				log.info("creating new profile {} for user {}", key, username);

				setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_LOGIN_HASH, loginHash);
				setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_TYPE, type);
				if (displayName != null)
				{
					setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_DISPLAY_NAME, displayName);
				}
				return new RuneScapeProfile(displayName, type, loginHash, keyStr);
			}
		}
		throw new RuntimeException("too many rs profiles");
	}

	private void updateRSProfile()
	{
		if (client == null)
		{
			return;
		}

		List<RuneScapeProfile> profiles = getRSProfiles();
		RuneScapeProfile prof = findRSProfile(profiles, client.getUsername(), RuneScapeProfileType.getCurrent(client), null, false);

		String key = prof == null ? null : prof.getKey();
		if (Objects.equals(key, rsProfileKey))
		{
			return;
		}
		rsProfileKey = key;

		eventBus.post(new RuneScapeProfileChanged());
	}

	@Subscribe
	private void onUsernameChanged(UsernameChanged ev)
	{
		updateRSProfile();
	}

	@Subscribe
	private void onWorldChanged(WorldChanged ev)
	{
		updateRSProfile();
	}

	@Subscribe
	private void onPlayerChanged(PlayerChanged ev)
	{
		if (ev.getPlayer() == client.getLocalPlayer())
		{
			String name = ev.getPlayer().getName();
			setRSProfileConfiguration(RSPROFILE_GROUP, RSPROFILE_DISPLAY_NAME, name);
		}
	}

	private synchronized void migrateConfig()
	{
		String migrationKey = "profileMigrationDone";
		if (getConfiguration("runelite", migrationKey) != null)
		{
			return;
		}

		Map<String, String> profiles = new HashMap<>();

		AtomicInteger changes = new AtomicInteger();
		List<Predicate<String>> migrators = new ArrayList<>();
		for (String[] tpl : new String[][]
			{
				{"(grandexchange)\\.buylimit_(%)\\.(#)", "$1.buylimit.$3"},
				{"(timetracking)\\.(%)\\.(autoweed|contract)", "$1.$3"},
				{"(timetracking)\\.(%)\\.(#\\.#)", "$1.$3"},
				{"(timetracking)\\.(%)\\.(birdhouse)\\.(#)", "$1.$3.$4"},
				{"(killcount|personalbest)\\.(%)\\.([^.]+)", "$1.$3"},
				{"(geoffer)\\.(%)\\.(#)", "$1.$3"},
			})
		{
			String replace = tpl[1];
			String pat = ("^" + tpl[0] + "$")
				.replace("#", "-?[0-9]+")
				.replace("(%)", "(?<login>.*)");
			Pattern p = Pattern.compile(pat);

			migrators.add(oldkey ->
			{
				Matcher m = p.matcher(oldkey);
				if (!m.find())
				{
					return false;
				}

				String newKey = m.replaceFirst(replace);
				String username = m.group("login").toLowerCase(Locale.US);

				if (username.startsWith(RSPROFILE_GROUP + "."))
				{
					return false;
				}

				String profKey = profiles.computeIfAbsent(username, u ->
					findRSProfile(getRSProfiles(), u, RuneScapeProfileType.STANDARD, u, true).getKey());

				Matcher oldKeyM = KEY_SPLITTER.matcher(oldkey);
				if (!oldKeyM.find())
				{
					log.warn("skipping migration of invalid key \"{}\"", oldkey);
					return false;
				}
				if (oldKeyM.group(KEY_SPLITTER_PROFILE) != null)
				{
					log.debug("skipping migrated key \"{}\"", oldkey);
					return false;
				}

				Matcher newKeyM = KEY_SPLITTER.matcher(newKey);
				if (!newKeyM.find() || newKeyM.group(KEY_SPLITTER_PROFILE) != null)
				{
					log.warn("migration produced a bad key: \"{}\" -> \"{}\"", oldkey, newKey);
					return false;
				}

				if (changes.getAndAdd(1) <= 0)
				{
					File file = new File(propertiesFile.getParent(), propertiesFile.getName() + "." + TIME_FORMAT.format(new Date()));
					log.info("backing up pre-migration config to {}", file);
					try
					{
						saveToFile(file);
					}
					catch (IOException e)
					{
						log.error("Backup failed", e);
						throw new RuntimeException(e);
					}
				}

				String oldGroup = oldKeyM.group(KEY_SPLITTER_GROUP);
				String oldKeyPart = oldKeyM.group(KEY_SPLITTER_KEY);
				String value = getConfiguration(oldGroup, oldKeyPart);
				setConfiguration(newKeyM.group(KEY_SPLITTER_GROUP), profKey, newKeyM.group(KEY_SPLITTER_KEY), value);
				unsetConfiguration(oldGroup, oldKeyPart);
				return true;
			});
		}

		Set<String> keys = (Set<String>) ImmutableSet.copyOf((Set) properties.keySet());
		keys:
		for (String key : keys)
		{
			for (Predicate<String> mig : migrators)
			{
				if (mig.test(key))
				{
					continue keys;
				}
			}
		}

		if (changes.get() > 0)
		{
			log.info("migrated {} config keys", changes);
		}
		setConfiguration("runelite", migrationKey, 1);
	}
}
