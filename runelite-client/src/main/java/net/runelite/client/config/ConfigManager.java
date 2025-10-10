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
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.WorldChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ConfigSync;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.RunnableExceptionLogger;
import net.runelite.http.api.config.ConfigPatch;
import net.runelite.http.api.config.ConfigPatchResult;
import net.runelite.http.api.config.Configuration;
import net.runelite.http.api.config.Profile;

@Singleton
@Slf4j
public class ConfigManager
{
	public static final String RSPROFILE_GROUP = "rsprofile";
	public static final String RSPROFILE_DISPLAY_NAME = "displayName";
	public static final String RSPROFILE_TYPE = "type";

	private static final String RSPROFILE_ACCOUNT_HASH = "accountHash";

	private static final long RSPROFILE_ID = -1L;
	private static final String RSPROFILE_NAME = "$rsprofile";

	private static final int KEY_SPLITTER_GROUP = 0;
	private static final int KEY_SPLITTER_PROFILE = 1;
	private static final int KEY_SPLITTER_KEY = 2;

	@Nullable
	private final String configProfileName;
	private final ScheduledExecutorService executor;
	private final EventBus eventBus;
	private final Client client;
	private final Gson gson;
	@Nonnull
	private final ConfigClient configClient;
	private final ProfileManager profileManager;
	private final SessionManager sessionManager;

	private final ConfigInvocationHandler handler = new ConfigInvocationHandler(this);

	@Getter
	private ConfigProfile profile;
	private ConfigProfile rsProfile;
	private ConfigData configProfile;
	private ConfigData rsProfileConfigProfile;

	// null => we need to make a new profile
	@Nullable
	private String rsProfileKey;

	private final Map<Type, Serializer<?>> serializers = Collections.synchronizedMap(new WeakHashMap<>());

	@Inject
	private ConfigManager(
		@Nullable @Named("profile") String profile,
		ScheduledExecutorService scheduledExecutorService,
		EventBus eventBus,
		Client client,
		Gson gson,
		@Nonnull ConfigClient configClient,
		ProfileManager profileManager,
		SessionManager sessionManager
	)
	{
		this.configProfileName = profile;
		this.executor = scheduledExecutorService;
		this.eventBus = eventBus;
		this.client = client;
		this.gson = gson;
		this.configClient = configClient;
		this.profileManager = profileManager;
		this.sessionManager = sessionManager;

		scheduledExecutorService.scheduleWithFixedDelay(RunnableExceptionLogger.wrap(this::sendConfig), 30 + (int) (5 * 60 * Math.random()), 5 * 60, TimeUnit.SECONDS);
	}

	public void switchProfile(ConfigProfile newProfile)
	{
		if (newProfile.getId() == profile.getId())
		{
			log.warn("switching to already-active profile!");
			return;
		}

		// Ensure existing config is saved
		sendConfig();

		log.info("Switching profile to: {} ({})", newProfile.getName(), newProfile.getId());

		// sync the latest config revision from the server
		if (sessionManager.getAccountSession() != null && newProfile.isSync())
		{
			try (ProfileManager.Lock lock = profileManager.lock())
			{
				ConfigProfile profile = lock.findProfile(newProfile.getId());
				if (profile == null)
				{
					log.warn("lost profile while switching!");
					return;
				}

				List<Profile> profiles = configClient.profiles();
				if (profiles != null)
				{
					syncRemote(lock, profile, profiles);
				}
			}
			catch (IOException ex)
			{
				log.error("error fetching remote profile", ex);
			}
		}

		ConfigData newData = new ConfigData(ProfileManager.profileConfigFile(newProfile));
		Set<String> allKeys = new HashSet<>(newData.keySet());

		ConfigData oldData;
		synchronized (this)
		{
			handler.invalidate();
			oldData = configProfile;
			profile = newProfile;
			configProfile = newData;
		}

		allKeys.addAll(oldData.keySet());

		for (String wholeKey : allKeys)
		{
			String[] split = splitKey(wholeKey);
			if (split == null)
			{
				continue;
			}

			String groupName = split[KEY_SPLITTER_GROUP];
			String profile = split[KEY_SPLITTER_PROFILE];
			String key = split[KEY_SPLITTER_KEY];
			String oldValue = oldData.getProperty(wholeKey);
			String newValue = newData.getProperty(wholeKey);

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
		}

		eventBus.post(new ProfileChanged());
	}

	public String getRSProfileKey()
	{
		return rsProfileKey;
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession session = sessionManager.getAccountSession();
		configClient.setUuid(session.getUuid());

		try
		{
			List<Profile> profiles = configClient.profiles();
			if (profiles != null)
			{
				mergeRemoteProfiles(profiles);
			}
		}
		catch (IOException e)
		{
			log.error("error syncing remote profiles", e);
		}

		// special case for $rsprofile since it acts as an automatically-synced profile that is always merged
		// instead of overwritten. After a login send a PATCH for the offline $rsprofile to merge it with the
		// remote $rsprofile so that when $rsprofile is synced later it doesn't overwrite and lose the local
		// $rsprofile settings.
		ConfigPatch patch = buildConfigPatch(rsProfile.getName(), rsProfileConfigProfile.get());
		configClient.patch(patch, rsProfile.getId());
		log.debug("patched remote {}", RSPROFILE_NAME);
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		configClient.setUuid(null);

		// remove the remote profiles
		try (ProfileManager.Lock lock = profileManager.lock())
		{
			profile = updateProfile(lock, profile);
			rsProfile = updateProfile(lock, rsProfile);

			lock.getProfiles().removeIf(p -> p != profile && !p.isInternal() && p.isSync());

			if (profile.isSync())
			{
				log.info("Active remote profile '{}' lost due to session close, converting to a local profile.", profile.getName());
				profile.setSync(false);
				profile.setRev(-1L);
			}

			lock.dirty();
		}
	}

	public void toggleSync(ConfigProfile profile, boolean sync)
	{
		log.debug("Setting sync for {}: {}", profile.getName(), sync);

		// flush pending config changes first in the event the profile being
		// synced is the active profile.
		sendConfig();

		try (ProfileManager.Lock lock = profileManager.lock())
		{
			profile = lock.findProfile(profile.getId());
			if (profile == null || profile.isSync() == sync)
			{
				return;
			}

			profile.setSync(sync);
			lock.dirty();

			if (sync)
			{
				// sync the entire profile from disk
				File from = ProfileManager.profileConfigFile(profile);
				ConfigData data = new ConfigData(from);
				ConfigPatch patch = buildConfigPatch(profile.getName(), data.get());
				configClient.patch(patch, profile.getId());
			}
			else
			{
				configClient.delete(profile.getId());
			}
		}
	}

	public void renameProfile(ConfigProfile profile, String name)
	{
		if (profile.isSync() && sessionManager.getAccountSession() != null)
		{
			configClient.rename(profile.getId(), name);
		}
	}

	private void migrate()
	{
		try (ProfileManager.Lock lock = profileManager.lock())
		{
			List<ConfigProfile> profiles = lock.getProfiles();
			File configFile = new File(RuneLite.RUNELITE_DIR, "settings.properties");
			if (profiles.isEmpty() && configFile.exists())
			{
				String targetProfileName = "default";

				log.info("Performing migration of config from {} to profile '{}'", configFile.getName(), targetProfileName);

				ConfigProfile targetProfile = lock.createProfile(targetProfileName);
				profiles.forEach(p -> p.setActive(false));
				targetProfile.setActive(true);

				if (rsProfile == null)
				{
					rsProfile = lock.findProfile(RSPROFILE_NAME);
					if (rsProfile == null)
					{
						rsProfile = lock.createProfile(RSPROFILE_NAME, RSPROFILE_ID);
					}
					rsProfile.setSync(true);
				}

				if (rsProfileConfigProfile == null)
				{
					rsProfileConfigProfile = new ConfigData(ProfileManager.profileConfigFile(rsProfile));
				}

				importAndMigrate(lock, configFile, targetProfile);
			}
		}
	}

	public void importAndMigrate(ProfileManager.Lock lock, File from, ConfigProfile targetProfile)
	{
		ConfigData migratingData = new ConfigData(from);
		ConfigData configData = new ConfigData(ProfileManager.profileConfigFile(targetProfile));

		log.debug("Importing profile from {}", from);

		Set<String> rsProfileKeys = new HashSet<>();
		List<Map.Entry<String, String>> rsProfileEntries = new ArrayList<>();

		int keys = 0;
		for (Map.Entry<String, String> entry : migratingData.get().entrySet())
		{
			String[] split = splitKey(entry.getKey());
			if (split == null)
			{
				continue;
			}

			String profile = split[KEY_SPLITTER_PROFILE];

			if (profile != null)
			{
				rsProfileKeys.add(profile);
				rsProfileEntries.add(entry);
			}
			else
			{
				configData.setProperty(entry.getKey(), entry.getValue());
				++keys;
			}
		}

		if (rsProfileKeys.size() > 0)
		{
			Map<String, String> oldToNewRSProfile = new HashMap<>();
			List<RuneScapeProfile> existingProfiles = getRSProfiles();
			for (String oldKey : rsProfileKeys)
			{
				try
				{
					String strHash = migratingData.getProperty(getWholeKey(RSPROFILE_GROUP, oldKey, RSPROFILE_ACCOUNT_HASH));
					String strType = migratingData.getProperty(getWholeKey(RSPROFILE_GROUP, oldKey, RSPROFILE_TYPE));
					if (!Strings.isNullOrEmpty(strHash) && !Strings.isNullOrEmpty(strType))
					{
						long accHash = Long.parseLong(strHash);
						RuneScapeProfileType type = RuneScapeProfileType.valueOf(strType);

						RuneScapeProfile newProfile = findRSProfile(existingProfiles, accHash, type, null, true);
						if (newProfile != null)
						{
							existingProfiles.add(newProfile);
							oldToNewRSProfile.put(oldKey, newProfile.getKey());
							log.info("importing rsprofile \"{}\" as \"{}\"", oldKey, newProfile.getKey());
							continue;
						}
					}
					log.info("not importing rsprofile key \"{}\" (hash={} type={})", oldKey, strHash, strType);
				}
				catch (IllegalArgumentException e)
				{
					log.info("failed to unmarshal imported rsprofile data for key \"{}\"", oldKey, e);
				}
			}

			for (Map.Entry<String, String> entry : rsProfileEntries)
			{
				String[] split = splitKey(entry.getKey());
				assert split != null;
				String profile = split[KEY_SPLITTER_PROFILE];
				profile = oldToNewRSProfile.get(profile);
				if (profile != null && getConfiguration(split[KEY_SPLITTER_GROUP], profile, split[KEY_SPLITTER_KEY]) == null)
				{
					setConfiguration(split[KEY_SPLITTER_GROUP], profile, split[KEY_SPLITTER_KEY], entry.getValue());
				}
			}
		}

		configData.patch(configData.swapChanges());

		rsProfile = updateProfile(lock, rsProfile);
		saveConfiguration(lock, rsProfile, rsProfileConfigProfile);

		log.info("Finished importing {} keys", keys);
	}

	private static void removeDuplicateProfiles(ProfileManager.Lock lock)
	{
		var seen = new HashMap<Long, ConfigProfile>();
		for (var it = lock.getProfiles().iterator(); it.hasNext(); )
		{
			var profile = it.next();
			if (seen.containsKey(profile.getId()))
			{
				var existing = seen.get(profile.getId());
				log.warn("Duplicate profiles detected: {} and {}. Removing the latter.",
					existing, profile);
				it.remove();
				lock.dirty();
				continue;
			}

			seen.put(profile.getId(), profile);
		}
	}

	private static void fixRsProfileName(ProfileManager.Lock lock)
	{
		var rsProfile = lock.findProfile(RSPROFILE_ID);
		if (rsProfile != null && !rsProfile.getName().equals(RSPROFILE_NAME))
		{
			log.warn("renaming {} to {}", rsProfile, RSPROFILE_NAME);
			rsProfile.setName(RSPROFILE_NAME);
			lock.dirty();
		}
	}

	public void load()
	{
		AccountSession session = sessionManager.getAccountSession();
		List<Profile> remoteProfiles = Collections.emptyList();
		if (session != null)
		{
			configClient.setUuid(session.getUuid());
			try
			{
				List<Profile> profiles = configClient.profiles();
				if (profiles != null)
				{
					remoteProfiles = profiles;
					mergeRemoteProfiles(remoteProfiles);
				}
			}
			catch (IOException ex)
			{
				log.error("error loading remote profiles", ex);
			}
		}

		migrate();

		try (ProfileManager.Lock lock = profileManager.lock())
		{
			removeDuplicateProfiles(lock);
			fixRsProfileName(lock);

			ConfigProfile profile = null, rsProfile = null;

			for (ConfigProfile p : lock.getProfiles())
			{
				if (p.isInternal())
				{
					log.debug("Profile '{}' (sync: {}, active: {}, id: {}, internal)", p.getName(), p.isSync(), p.getId(), p.isActive());

					if (p.getName().equals(RSPROFILE_NAME))
					{
						rsProfile = p;
					}

					continue;
				}

				log.info("Profile '{}' (sync: {}, active: {}, id: {})", p.getName(), p.isSync(), p.isActive(), p.getId());
			}

			if (rsProfile == null)
			{
				rsProfile = lock.createProfile(RSPROFILE_NAME, RSPROFILE_ID);
			}
			rsProfile.setSync(true);

			// synced rsprofile need to be fetched if outdated
			syncRemote(lock, rsProfile, remoteProfiles);

			this.rsProfile = rsProfile;
			rsProfileConfigProfile = new ConfigData(ProfileManager.profileConfigFile(rsProfile));

			final String launcherDisplayName = client.getLauncherDisplayName();
			// --profile
			if (configProfileName != null)
			{
				profile = lock.findProfile(p -> !p.isInternal() && configProfileName.equals(p.getName()));
			}
			else
			{
				// select a config profile associated with the display name from the jagex launcher, if available
				if (launcherDisplayName != null)
				{
					profile = lock.findProfile(p ->
					{
						if (p.isInternal())
						{
							return false;
						}

						final List<String> defaultRsProfilesForProfile = p.getDefaultForRsProfiles();
						if (defaultRsProfilesForProfile == null)
						{
							return false;
						}

						// Calling getConfiguration before a profile has been loaded is usually invalid. Because
						// rsProfile is loaded above before this is run and we are only attempting to load rsProfile
						// keys, it is safe to be called.
						for (final String defaultRsProfile : defaultRsProfilesForProfile)
						{
							final RuneScapeProfileType rsProfileType = getConfiguration(RSPROFILE_GROUP, defaultRsProfile, RSPROFILE_TYPE, RuneScapeProfileType.class);
							if (rsProfileType != RuneScapeProfileType.STANDARD)
							{
								continue;
							}

							final String profileDisplayName = getConfiguration(RSPROFILE_GROUP, defaultRsProfile, RSPROFILE_DISPLAY_NAME);
							if (launcherDisplayName.equals(profileDisplayName))
							{
								return true;
							}
						}

						return false;
					});
				}
				if (profile == null)
				{
					profile = lock.findProfile(p -> !p.isInternal() && p.isActive());
				}
				if (profile == null)
				{
					profile = lock.findProfile(p -> !p.isInternal());
				}
			}

			if (profile != null)
			{
				log.info("Using profile: {} ({})", profile.getName(), profile.getId());
			}
			else
			{
				profile = lock.createProfile(configProfileName != null ? configProfileName : "default");
				if (configProfileName == null)
				{
					// if creating the initial default profile
					lock.getProfiles().forEach(p -> p.setActive(false));
					profile.setActive(true);
				}

				log.info("Creating profile: {} ({})", profile.getName(), profile.getId());
			}

			// synced profile need to be fetched if outdated
			syncRemote(lock, profile, remoteProfiles);

			this.profile = profile;
			configProfile = new ConfigData(ProfileManager.profileConfigFile(profile));
		}

		eventBus.post(new ProfileChanged());
	}

	private void mergeRemoteProfiles(List<Profile> remoteProfiles)
	{
		try (ProfileManager.Lock lock = profileManager.lock())
		{
			boolean migrating = lock.getProfiles().isEmpty();

			outer:
			for (Profile remoteProfile : remoteProfiles)
			{
				for (ConfigProfile profile : lock.getProfiles())
				{
					if (profile.getId() == remoteProfile.getId())
					{
						log.debug("Found local profile {} for remote {}", profile, remoteProfile);
						profile.setName(MoreObjects.firstNonNull(remoteProfile.getName(), ""));
						profile.setSync(true);
						lock.dirty();
						continue outer;
					}
				}

				log.debug("Creating local profile for remote {}", remoteProfile);
				ConfigProfile profile = lock.createProfile(MoreObjects.firstNonNull(remoteProfile.getName(), ""), remoteProfile.getId());
				profile.setSync(true);

				if (migrating && remoteProfile.getId() == 0L)
				{
					log.info("Using remote profile {} as the active profile", profile.getName());
					profile.setActive(true);
				}
			}

			outer2:
			for (ConfigProfile localProfile : lock.getProfiles())
			{
				for (Profile remoteProfile : remoteProfiles)
				{
					if (localProfile.getId() == remoteProfile.getId())
					{
						continue outer2;
					}
				}

				log.debug("Found local profile {}", localProfile);

				if (!localProfile.isSync() || localProfile.isInternal())
				{
					continue;
				}

				log.warn("Lost remote profile for '{}'", localProfile.getName());
				// convert the profile to a non-synced profile
				localProfile.setSync(false);
				localProfile.setRev(-1);
				lock.dirty();
			}
		}
	}

	private void syncRemote(ProfileManager.Lock lock, ConfigProfile profile, List<Profile> remoteProfiles)
	{
		if (!profile.isSync())
		{
			return;
		}

		long id = profile.getId();
		Profile remoteProfile = remoteProfiles.stream()
			.filter(p -> p.getId() == id)
			.findFirst()
			.orElse(null);

		if (remoteProfile == null)
		{
			// $rsprofile is normally synced, even when logged out
			if (!profile.isInternal())
			{
				log.warn("synced profile {} has no remote!", profile);
			}
			return;
		}

		if (profile.getRev() == remoteProfile.getRev())
		{
			log.info("Profile '{}' is up to date", profile.getName());
		}
		else
		{
			log.info("Loading remote configuration for profile '{}'", profile.getName());

			try
			{
				Configuration remoteConfiguration = configClient.get(profile.getId());
				if (remoteConfiguration == null || remoteConfiguration.getConfig() == null || remoteConfiguration.getConfig().isEmpty())
				{
					log.debug("no remote configuration for {}", profile);
					return;
				}

				File configFile = ProfileManager.profileConfigFile(profile);
				// remote configuration replaces local
				configFile.delete();

				ConfigData configData = new ConfigData(configFile);
				configData.putAll(remoteConfiguration.getConfig());
				configData.patch(configData.swapChanges());

				log.debug("synced remote profile {} rev {} to disk", profile, remoteConfiguration.getRev());
				profile.setRev(remoteConfiguration.getRev());
				lock.dirty();
			}
			catch (IOException ex)
			{
				log.error("unable to load remote configuration for {}", profile, ex);
			}
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
		return configProfile.keySet().stream()
			.filter(k -> k.startsWith(prefix))
			.collect(Collectors.toList());
	}

	public List<String> getRSProfileConfigurationKeys(String group, String profile, String keyPrefix)
	{
		if (profile == null)
		{
			return Collections.emptyList();
		}

		assert profile.startsWith(RSPROFILE_GROUP);

		String prefix = group + "." + profile + "." + keyPrefix;
		return rsProfileConfigProfile.keySet().stream()
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

	// region get configuration
	private String getConfiguration(ConfigData configData, String groupName, String rsProfile, String key)
	{
		return configData.getProperty(getWholeKey(groupName, rsProfile, key));
	}

	public String getConfiguration(String groupName, String key)
	{
		return getConfiguration(configProfile, groupName, null, key);
	}

	public String getRSProfileConfiguration(String groupName, String key)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return null;
		}

		return getConfiguration(rsProfileConfigProfile, groupName, rsProfileKey, key);
	}

	public String getConfiguration(String groupName, String profile, String key)
	{
		if (profile != null)
		{
			return getConfiguration(rsProfileConfigProfile, groupName, profile, key);
		}
		else
		{
			return getConfiguration(configProfile, groupName, null, key);
		}
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
	// endregion

	// region set configuration
	private void setConfiguration(ConfigData configData, String groupName, String profile, String key, @NonNull String value)
	{
		if (Strings.isNullOrEmpty(groupName) || Strings.isNullOrEmpty(key) || key.indexOf(':') != -1 || key.startsWith("$"))
		{
			throw new IllegalArgumentException();
		}

		assert !key.startsWith(RSPROFILE_GROUP + ".");
		String wholeKey = getWholeKey(groupName, profile, key);
		String oldValue = configData.setProperty(wholeKey, value);

		if (Objects.equals(oldValue, value))
		{
			return;
		}

		log.debug("Setting configuration value for {} to {}", wholeKey, value);
		handler.invalidate();

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setProfile(profile);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);
		configChanged.setNewValue(value);

		eventBus.post(configChanged);
	}

	public void setConfiguration(String groupName, String profile, String key, @NonNull String value)
	{
		if (profile != null)
		{
			setConfiguration(rsProfileConfigProfile, groupName, profile, key, value);
		}
		else
		{
			setConfiguration(configProfile, groupName, null, key, value);
		}
	}

	public void setConfiguration(String groupName, String key, String value)
	{
		setConfiguration(configProfile, groupName, null, key, value);
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

			RuneScapeProfile prof = findRSProfile(getRSProfiles(), client.getAccountHash(), RuneScapeProfileType.getCurrent(client), displayName, true);
			if (prof == null)
			{
				log.warn("trying to create a profile while not logged in");
				return;
			}

			rsProfileKey = prof.getKey();
			String previousProfile = this.rsProfileKey;
			this.rsProfileKey = rsProfileKey;

			log.debug("RS profile changed to {}", rsProfileKey);
			eventBus.post(new RuneScapeProfileChanged(previousProfile, rsProfileKey));
		}
		setConfiguration(groupName, rsProfileKey, key, value);
	}
	// endregion

	// region unset configuration
	private void unsetConfiguration(ConfigData configData, String groupName, String profile, String key)
	{
		assert !key.startsWith(RSPROFILE_GROUP + ".");
		String wholeKey = getWholeKey(groupName, profile, key);
		String oldValue = configData.unset(wholeKey);

		if (oldValue == null)
		{
			return;
		}

		log.debug("Unsetting configuration value for {}", wholeKey);
		handler.invalidate();

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(groupName);
		configChanged.setProfile(profile);
		configChanged.setKey(key);
		configChanged.setOldValue(oldValue);

		eventBus.post(configChanged);
	}

	public void unsetConfiguration(String groupName, String profile, String key)
	{
		if (profile != null)
		{
			unsetConfiguration(rsProfileConfigProfile, groupName, profile, key);
		}
		else
		{
			unsetConfiguration(configProfile, groupName, null, key);
		}
	}

	public void unsetConfiguration(String groupName, String key)
	{
		unsetConfiguration(configProfile, groupName, null, key);
	}

	public void unsetRSProfileConfiguration(String groupName, String key)
	{
		String rsProfileKey = this.rsProfileKey;
		if (rsProfileKey == null)
		{
			return;
		}

		unsetConfiguration(rsProfileConfigProfile, groupName, rsProfileKey, key);
	}
	// endregion

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
	 * @param proxy proxy instance implementing {@link Config}
	 */
	public <T extends Config> void setDefaultConfiguration(T proxy, boolean override)
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

			if (Strings.isNullOrEmpty(valueString))
			{
				unsetConfiguration(group.value(), item.keyName());
			}
			else
			{
				setConfiguration(group.value(), item.keyName(), valueString);
			}
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
		if (type instanceof Class)
		{
			Class<?> clazz = (Class<?>) type;
			ConfigSerializer configSerializer = clazz.getAnnotation(ConfigSerializer.class);
			if (configSerializer != null)
			{
				Class<? extends Serializer<?>> serializerClass = configSerializer.value();
				Serializer<?> serializer = serializers.get(type);
				if (serializer == null)
				{
					// Guice holds references to all jitted types.
					// To allow class unloading, use a temporary child injector
					// and use it to get the instance, and cache it a weak map.
					serializer = RuneLite.getInjector()
						.createChildInjector()
						.getInstance(serializerClass);
					serializers.put(type, serializer);
				}
				return serializer.deserialize(str);
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
		if (object != null)
		{
			ConfigSerializer configSerializer = object.getClass().getAnnotation(ConfigSerializer.class);
			if (configSerializer != null)
			{
				Class<? extends Serializer<?>> serializerClass = configSerializer.value();
				Serializer serializer = serializers.get(serializerClass);
				if (serializer == null)
				{
					serializer = RuneLite.getInjector()
						.createChildInjector()
						.getInstance(serializerClass);
					serializers.put(serializerClass, serializer);
				}
				return serializer.serialize(object);
			}
		}
		return object == null ? null : object.toString();
	}

	@Subscribe(
		// run after plugins, in the event they save config on shutdown
		priority = -100
	)
	private void onClientShutdown(ClientShutdown e)
	{
		sendConfig();
	}

	public void sendConfig()
	{
		eventBus.post(new ConfigSync());

		try (ProfileManager.Lock lock = profileManager.lock())
		{
			// since we hold references to profiles outside of the lock, they are stale.
			// fetch the latest version.
			profile = updateProfile(lock, profile);
			rsProfile = updateProfile(lock, rsProfile);

			saveConfiguration(lock, profile, configProfile);
			saveConfiguration(lock, rsProfile, rsProfileConfigProfile);
		}
	}

	private static ConfigProfile updateProfile(ProfileManager.Lock lock, ConfigProfile profile)
	{
		ConfigProfile p = lock.findProfile(profile.getId());
		if (p == null)
		{
			log.warn("Lost active profile {}!", profile.getName());

			// We just recreate it, with the same id, so that the ConfigData stays valid
			p = lock.createProfile(profile.getName(), profile.getId());
			p.setActive(profile.isActive());
		}
		else if (profile.getRev() != p.getRev())
		{
			// I think this is okay because while the in memory config on this client will be outdated,
			// the version on disk and also the remote version will still be consistent
			log.debug("Profile {} changed on disk", p.getName());
		}
		return p;
	}

	private void saveConfiguration(ProfileManager.Lock lock, ConfigProfile profile, ConfigData data)
	{
		Map<String, String> patch = data.swapChanges();

		if (patch.isEmpty())
		{
			return;
		}

		log.debug("Saving profile {} (patch size: {})", profile.getName(), patch.size());

		if (profile.isSync() && sessionManager.getAccountSession() != null)
		{
			try
			{
				ConfigPatchResult patchResult = configClient.patch(buildConfigPatch(profile.isInternal() ? profile.getName() : null, patch), profile.getId()).get();
				if (patchResult == null)
				{
					profile.setRev(-1L);
				}
				else
				{
					long oldRev = patchResult.getRev() - 1;
					long newRev = patchResult.getRev();

					if (oldRev == profile.getRev())
					{
						profile.setRev(newRev);
						log.debug("incremental patch applied {} -> {}", oldRev, newRev);
					}
					else
					{
						// version on disk now mismatches the remote config. Set rev as -1 to force a reload
						// on next start.
						log.debug("rev mismatch {} != {}, invalidating", oldRev, newRev);
						profile.setRev(-1L);
					}
				}
				lock.dirty();
			}
			catch (ExecutionException | InterruptedException e)
			{
				profile.setRev(-1L);
				lock.dirty();
				log.error("error applying incremental patch", e);
			}
		}

		data.patch(patch);
	}

	private static ConfigPatch buildConfigPatch(@Nullable String profileName, Map<String, String> patchChanges)
	{
		ConfigPatch patch = new ConfigPatch();
		// Note profileName is only used for internal profiles and on initial sync, to prevent
		// clients fighting over profile names.
		patch.setProfileName(profileName);
		for (Map.Entry<String, String> entry : patchChanges.entrySet())
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
		return patch;
	}

	public List<RuneScapeProfile> getRSProfiles()
	{
		String prefix = RSPROFILE_GROUP + "." + RSPROFILE_GROUP + ".";
		Set<String> profileKeys = new HashSet<>();
		for (String key : rsProfileConfigProfile.keySet())
		{
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

		return profileKeys.stream()
			.map(key ->
			{
				Long accid = getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_ACCOUNT_HASH, long.class);
				RuneScapeProfile prof = new RuneScapeProfile(
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_DISPLAY_NAME),
					getConfiguration(RSPROFILE_GROUP, key, RSPROFILE_TYPE, RuneScapeProfileType.class),
					accid == null ? RuneScapeProfile.ACCOUNT_HASH_INVALID : accid,
					key
				);

				return prof;
			})
			.sorted(Comparator.comparing(RuneScapeProfile::getKey))
			.collect(Collectors.toCollection(ArrayList::new));
	}

	private synchronized RuneScapeProfile findRSProfile(List<RuneScapeProfile> profiles, long accountHash, RuneScapeProfileType type, String displayName, boolean create)
	{
		if (accountHash == RuneScapeProfile.ACCOUNT_HASH_INVALID)
		{
			return null;
		}

		List<RuneScapeProfile> matches = profiles.stream()
			.filter(p -> p.getType() == type && accountHash == p.getAccountHash())
			.collect(Collectors.toList());

		if (matches.size() > 1)
		{
			log.warn("multiple matching profiles, choosing {}, ignoring {}", matches.get(0), matches.subList(1, matches.size()));
		}

		if (matches.size() >= 1)
		{
			return matches.get(0);
		}

		if (!create)
		{
			return null;
		}

		// generate the new key deterministically so if you "create" the same profile on 2 different clients it doesn't duplicate
		Set<String> keys = profiles.stream().map(RuneScapeProfile::getKey).collect(Collectors.toSet());
		byte[] key = {
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
				log.info("creating new profile {} for account hash {} ({})", keyStr, accountHash, type);

				setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_ACCOUNT_HASH, accountHash);
				setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_TYPE, type);
				if (displayName != null)
				{
					setConfiguration(RSPROFILE_GROUP, keyStr, RSPROFILE_DISPLAY_NAME, displayName);
				}
				return new RuneScapeProfile(displayName, type, accountHash, keyStr);
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
		RuneScapeProfile prof = findRSProfile(profiles, client.getAccountHash(), RuneScapeProfileType.getCurrent(client), null, false);

		String key = prof == null ? null : prof.getKey();
		if (Objects.equals(key, rsProfileKey))
		{
			return;
		}
		String previousProfile = rsProfileKey;
		rsProfileKey = key;

		log.debug("RS profile changed to {}", key);
		eventBus.post(new RuneScapeProfileChanged(previousProfile, key));
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

	@Subscribe
	private void onRuneScapeProfileChanged(RuneScapeProfileChanged ev)
	{
		try (ProfileManager.Lock lock = profileManager.lock())
		{
			for (final ConfigProfile profile : lock.getProfiles())
			{
				final List<String> get = profile.getDefaultForRsProfiles();
				if (get != null && get.contains(rsProfileKey))
				{
					// change active profile
					lock.getProfiles().forEach(p -> p.setActive(false));
					profile.setActive(true);
					lock.dirty();

					log.debug("Switching to default profile {} for rsprofile {}", profile.getName(), rsProfileKey);
					executor.submit(() -> switchProfile(profile));
					break;
				}
			}
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
