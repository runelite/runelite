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
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
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
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.WorldChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ConfigSync;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.config.ConfigPatch;

@Singleton
@Slf4j
public class ConfigManager
{
	public static final String RSPROFILE_GROUP = "rsprofile";

	private static final String RSPROFILE_DISPLAY_NAME = "displayName";
	private static final String RSPROFILE_TYPE = "type";
	private static final String RSPROFILE_LOGIN_HASH = "loginHash";
	private static final String RSPROFILE_LOGIN_SALT = "loginSalt";
	private static final String RSPROFILE_ACCOUNT_HASH = "accountHash";

	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	private static final int KEY_SPLITTER_GROUP = 0;
	private static final int KEY_SPLITTER_PROFILE = 1;
	private static final int KEY_SPLITTER_KEY = 2;

	private final File settingsFileInput;
	private final EventBus eventBus;
	private final Gson gson;
	@Nonnull
	private final ConfigClient configClient;

	private AccountSession session;
	private File propertiesFile;

	@Nullable
	private final Client client;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);
	private final Map<String, String> pendingChanges = new HashMap<>();

	private Properties properties = new Properties();

	// null => we need to make a new profile
	@Nullable
	private String rsProfileKey;

	@Inject
	public ConfigManager(
		@Named("config") File config,
		ScheduledExecutorService scheduledExecutorService,
		EventBus eventBus,
		@Nullable Client client,
		Gson gson,
		ConfigClient configClient)
	{
		this.settingsFileInput = config;
		this.eventBus = eventBus;
		this.client = client;
		this.propertiesFile = getPropertiesFile();
		this.gson = gson;
		this.configClient = configClient;

		scheduledExecutorService.scheduleWithFixedDelay(this::sendConfig, 30, 5 * 60, TimeUnit.SECONDS);
	}

	public String getRSProfileKey()
	{
		return rsProfileKey;
	}

	public final void switchSession(AccountSession session)
	{
		// Ensure existing config is saved
		sendConfig();

		if (session == null)
		{
			this.session = null;
			configClient.setUuid(null);
		}
		else
		{
			this.session = session;
			configClient.setUuid(session.getUuid());
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
		if (session == null)
		{
			loadFromFile();
			return;
		}

		Map<String, String> configuration;

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

		if (configuration == null || configuration.isEmpty())
		{
			log.debug("No configuration from client, using saved configuration on disk");
			loadFromFile();
			return;
		}

		Properties newProperties = new Properties();
		newProperties.putAll(configuration);

		log.debug("Loading in config from server");
		swapProperties(newProperties, false);

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

	private void swapProperties(Properties newProperties, boolean saveToServer)
	{
		Set<Object> allKeys = new HashSet<>(newProperties.keySet());

		Properties oldProperties;
		synchronized (this)
		{
			handler.invalidate();
			oldProperties = properties;
			this.properties = newProperties;
		}

		updateRSProfile();

		allKeys.addAll(oldProperties.keySet());

		for (Object wholeKey : allKeys)
		{
			String[] split = splitKey((String) wholeKey);
			if (split == null)
			{
				continue;
			}

			String groupName = split[KEY_SPLITTER_GROUP];
			String profile = split[KEY_SPLITTER_PROFILE];
			String key = split[KEY_SPLITTER_KEY];
			String oldValue = (String) oldProperties.get(wholeKey);
			String newValue = (String) newProperties.get(wholeKey);

			if (Objects.equals(oldValue, newValue))
			{
				continue;
			}

			log.debug("Loading configuration value {}: {}", wholeKey, newValue);

			ConfigChanged configChanged = new ConfigChanged();
			configChanged.setGroup(groupName);
			configChanged.setProfile(profile);
			configChanged.setKey(key);
			configChanged.setOldValue(oldValue);
			configChanged.setNewValue(newValue);
			eventBus.post(configChanged);

			if (saveToServer)
			{
				synchronized (pendingChanges)
				{
					pendingChanges.put((String) wholeKey, newValue);
				}
			}
		}
	}

	private void syncPropertiesFromFile(File propertiesFile)
	{
		final Properties properties = new Properties();
		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		}
		catch (Exception e)
		{
			log.warn("Malformed properties, skipping update");
			return;
		}

		log.debug("Syncing properties from {}", propertiesFile);
		swapProperties(properties, true);
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

		log.info("Importing local settings");

		syncPropertiesFromFile(getLocalPropertiesFile());

		return sendConfig();
	}

	private synchronized void loadFromFile()
	{
		Properties newProperties = new Properties();
		try (FileInputStream in = new FileInputStream(propertiesFile))
		{
			newProperties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException ex)
		{
			log.debug("Unable to load settings - no such file");
		}
		catch (IllegalArgumentException | IOException ex)
		{
			log.warn("Unable to load settings", ex);
		}

		log.debug("Loading in config from disk");
		swapProperties(newProperties, false);
	}

	private void saveToFile(final File propertiesFile) throws IOException
	{
		File parent = propertiesFile.getParentFile();

		parent.mkdirs();

		File tempFile = File.createTempFile("runelite", null, parent);

		try (FileOutputStream out = new FileOutputStream(tempFile);
			FileChannel channel = out.getChannel();
			OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8))
		{
			channel.lock();
			properties.store(writer, "RuneLite configuration");
			channel.force(true);
			// FileChannel.close() frees the lock
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

	public synchronized List<String> getConfigurationKeys(String prefix)
	{
		return properties.keySet().stream()
			.map(String.class::cast)
			.filter(k -> k.startsWith(prefix))
			.collect(Collectors.toList());
	}

	public synchronized List<String> getRSProfileConfigurationKeys(String group, String profile, String keyPrefix)
	{
		if (profile == null)
		{
			return Collections.emptyList();
		}

		assert profile.startsWith(RSPROFILE_GROUP);

		String prefix = group + "." + profile + "." + keyPrefix;
		return properties.keySet().stream()
			.map(String.class::cast)
			.filter(k -> k.startsWith(prefix))
			.map(k -> splitKey(k)[KEY_SPLITTER_KEY])
			.collect(Collectors.toList());
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

	public <T> T getConfiguration(String groupName, String key, Type clazz)
	{
		return getConfiguration(groupName, null, key, clazz);
	}

	public <T> T getRSProfileConfiguration(String groupName, String key, Type clazz)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return null;
		}

		return getConfiguration(groupName, rsProfileKey, key, clazz);
	}

	public <T> T getConfiguration(String groupName, String profile, String key, Type type)
	{
		String value = getConfiguration(groupName, profile, key);
		if (!Strings.isNullOrEmpty(value))
		{
			try
			{
				return (T) stringToObject(value, type);
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

	public void setConfiguration(String groupName, String profile, String key, @NonNull String value)
	{
		if (Strings.isNullOrEmpty(groupName) || Strings.isNullOrEmpty(key) || key.indexOf(':') != -1)
		{
			throw new IllegalArgumentException();
		}

		assert !key.startsWith(RSPROFILE_GROUP + ".");
		String wholeKey = getWholeKey(groupName, profile, key);
		String oldValue;
		synchronized (this)
		{
			oldValue = (String) properties.setProperty(wholeKey, value);
		}

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

	public <T> void setConfiguration(String groupName, String profile, String key, T value)
	{
		setConfiguration(groupName, profile, key, objectToString(value));
	}

	public <T> void setConfiguration(String groupName, String key, T value)
	{
		setConfiguration(groupName, null, key, value);
	}

	public <T> void setRSProfileConfiguration(String groupName, String key, T value)
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

			RuneScapeProfile prof = findRSProfile(getRSProfiles(), RuneScapeProfileType.getCurrent(client), displayName, true);
			if (prof == null)
			{
				log.warn("trying to create a profile while not logged in");
				return;
			}

			rsProfileKey = prof.getKey();
			this.rsProfileKey = rsProfileKey;

			log.debug("RS profile changed to {}", rsProfileKey);
			eventBus.post(new RuneScapeProfileChanged());
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
		String oldValue;
		synchronized (this)
		{
			oldValue = (String) properties.remove(wholeKey);
		}

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
		configChanged.setProfile(profile);
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
				m.getGenericReturnType(),
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
				Object current = getConfiguration(group.value(), item.keyName(), method.getGenericReturnType());
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

	Object stringToObject(String str, Type type)
	{
		if (type == boolean.class || type == Boolean.class)
		{
			return Boolean.parseBoolean(str);
		}
		if (type == int.class || type == Integer.class)
		{
			return Integer.parseInt(str);
		}
		if (type == long.class || type == Long.class)
		{
			return Long.parseLong(str);
		}
		if (type == double.class || type == Double.class)
		{
			return Double.parseDouble(str);
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
		if (type instanceof Class && ((Class<?>) type).isEnum())
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
		if (type instanceof ParameterizedType)
		{
			ParameterizedType parameterizedType = (ParameterizedType) type;
			if (parameterizedType.getRawType() == Set.class)
			{
				return gson.fromJson(str, parameterizedType);
			}
		}
		return str;
	}

	@Nullable
	String objectToString(Object object)
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
		if (object instanceof Set)
		{
			return gson.toJson(object, Set.class);
		}
		return object == null ? null : object.toString();
	}

	@Subscribe(
		// run after plugins, in the event they save config on shutdown
		priority = -100
	)
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
		eventBus.post(new ConfigSync());

		CompletableFuture<Void> future = null;
		synchronized (pendingChanges)
		{
			if (pendingChanges.isEmpty())
			{
				return null;
			}

			if (session != null)
			{
				ConfigPatch patch = new ConfigPatch();
				for (Map.Entry<String, String> entry : pendingChanges.entrySet())
				{
					final String key = entry.getKey(), value = entry.getValue();
					if (value == null)
					{
						patch.getUnset().add(key);
					}
					else
					{
						patch.getEdit().put(key, value);
					}
				}

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
		synchronized (this)
		{
			for (Object oKey : properties.keySet())
			{
				String key = (String) oKey;
				if (!key.startsWith(prefix))
				{
					continue;
				}

				String[] split = splitKey(key);
				if (split == null)
				{
					continue;
				}

				profileKeys.add(split[KEY_SPLITTER_PROFILE]);
			}
		}

		return profileKeys.stream()
			.map(key ->
			{
				Long accid = getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_ACCOUNT_HASH, long.class);
				RuneScapeProfile prof = new RuneScapeProfile(
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_DISPLAY_NAME),
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_TYPE, RuneScapeProfileType.class),
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_LOGIN_HASH, byte[].class),
					accid == null ? RuneScapeProfile.ACCOUNT_HASH_INVALID : accid,
					key
				);

				return prof;
			})
			.collect(Collectors.toList());
	}

	private synchronized RuneScapeProfile findRSProfile(List<RuneScapeProfile> profiles, RuneScapeProfileType type, String displayName, boolean create)
	{
		String username = client.getUsername();
		long accountHash = client.getAccountHash();

		if (accountHash == RuneScapeProfile.ACCOUNT_HASH_INVALID && username == null)
		{
			return null;
		}

		final byte[] loginHash;
		byte[] salt = null;
		if (username != null)
		{
			salt = getConfiguration(RSPROFILE_GROUP, RSPROFILE_LOGIN_SALT, byte[].class);
			if (salt == null)
			{
				salt = new byte[15];
				new SecureRandom()
					.nextBytes(salt);
				log.info("creating new salt as there is no existing one {}", Base64.getUrlEncoder().encodeToString(salt));
				setConfiguration(RSPROFILE_GROUP, RSPROFILE_LOGIN_SALT, salt);
			}

			Hasher h = Hashing.sha512().newHasher();
			h.putBytes(salt);
			h.putString(username.toLowerCase(Locale.US), StandardCharsets.UTF_8);
			loginHash = h.hash().asBytes();
		}
		else
		{
			loginHash = null;
		}

		Set<RuneScapeProfile> matches = Collections.emptySet();
		if (accountHash != RuneScapeProfile.ACCOUNT_HASH_INVALID)
		{
			matches = profiles.stream()
				.filter(p -> p.getType() == type && accountHash == p.getAccountHash())
				.collect(Collectors.toSet());
		}

		if (matches.isEmpty() && loginHash != null)
		{
			matches = profiles.stream()
				.filter(p -> p.getType() == type && Arrays.equals(loginHash, p.getLoginHash()))
				.collect(Collectors.toSet());
		}

		if (matches.size() > 1)
		{
			log.warn("multiple matching profiles");
		}

		if (matches.size() >= 1)
		{
			RuneScapeProfile profile = matches.iterator().next();
			if (profile.getAccountHash() == RuneScapeProfile.ACCOUNT_HASH_INVALID && accountHash != RuneScapeProfile.ACCOUNT_HASH_INVALID)
			{
				int upgrades = 0;
				for (RuneScapeProfile p : profiles)
				{
					if (p.getAccountHash() == RuneScapeProfile.ACCOUNT_HASH_INVALID && Arrays.equals(p.getLoginHash(), loginHash))
					{
						setConfiguration(RSPROFILE_GROUP, p.getKey(), RSPROFILE_ACCOUNT_HASH, accountHash);
						upgrades++;
					}
				}
				log.info("Attaching account id to {} profiles", upgrades);
			}
			return profile;
		}

		if (!create)
		{
			return null;
		}

		// generate the new key deterministically so if you "create" the same profile on 2 different clients it doesn't duplicate
		Set<String> keys = profiles.stream().map(RuneScapeProfile::getKey).collect(Collectors.toSet());
		byte[] key = accountHash == RuneScapeProfile.ACCOUNT_HASH_INVALID
			? Arrays.copyOf(loginHash, 6)
			: new byte[]
			{
				(byte) accountHash,
				(byte) (accountHash >> 8),
				(byte) (accountHash >> 16),
				(byte) (accountHash >> 24),
				(byte) (accountHash >> 32),
				(byte) (accountHash >> 40),
			};
		key[0] += type.ordinal();
		for (int i = 0; i < 0xFF; i++, key[1]++)
		{
			String keyStr = RSPROFILE_GROUP + "." + Base64.getUrlEncoder().encodeToString(key);
			if (!keys.contains(keyStr))
			{
				log.info("creating new profile {} for username {} account hash {} ({}) salt {}",
					keyStr, username, accountHash, type,
					salt == null ? "null" : Base64.getUrlEncoder().encodeToString(salt));

				if (loginHash != null)
				{
					setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_LOGIN_HASH, loginHash);
				}
				if (accountHash != RuneScapeProfile.ACCOUNT_HASH_INVALID)
				{
					setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_ACCOUNT_HASH, accountHash);
				}
				setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_TYPE, type);
				if (displayName != null)
				{
					setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_DISPLAY_NAME, displayName);
				}
				return new RuneScapeProfile(displayName, type, loginHash, accountHash, keyStr);
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
		RuneScapeProfile prof = findRSProfile(profiles, RuneScapeProfileType.getCurrent(client), null, false);

		String key = prof == null ? null : prof.getKey();
		if (Objects.equals(key, rsProfileKey))
		{
			return;
		}
		rsProfileKey = key;

		log.debug("RS profile changed to {}", key);
		eventBus.post(new RuneScapeProfileChanged());
	}

	@Subscribe
	private void onUsernameChanged(UsernameChanged ev)
	{
		updateRSProfile();
	}

	@Subscribe
	private void onAccountHashChanged(AccountHashChanged ev)
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

	/**
	 * Split a config key into (group, profile, key)
	 *
	 * @param key in form group.(rsprofile.profile.)?key
	 * @return an array of {group, profile, key}
	 */
	@VisibleForTesting
	@Nullable
	static String[] splitKey(String key)
	{
		int i = key.indexOf('.');
		if (i == -1)
		{
			// all keys must have a group and key
			return null;
		}

		String group = key.substring(0, i);
		String profile = null;
		key = key.substring(i + 1);
		if (key.startsWith(RSPROFILE_GROUP + "."))
		{
			i = key.indexOf('.', RSPROFILE_GROUP.length() + 2); // skip . after RSPROFILE_GROUP
			profile = key.substring(0, i);
			key = key.substring(i + 1);
		}
		return new String[]{group, profile, key};
	}
}
