package net.runelite.client.plugins.customclientresizing;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.customclientresizing.ui.CustomClientResizingPluginPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ContainableFrame;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Custom Client Resizing",
	description = "Resize the window to saved profiles",
	tags = {"resize", "window", "position", "layout", "manage"},
	type = PluginType.MISCELLANEOUS,
	enabledByDefault = false
)
public class CustomClientResizingPlugin extends Plugin
{
	public static final String CONFIG_GROUP = "customclientresizing";
	private static final String CONFIG_KEY = "customclientresizingprofiles";
	private static final String PLUGIN_NAME = "Custom Client Resizing";
	private static final String ICON_FILE = "panel_icon.png";

	@Getter
	private final List<CustomClientResizingProfile> customclientresizingProfiles = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private CustomClientResizingConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientUI clientUi;

	private CustomClientResizingPluginPanel pluginPanel;
	private NavigationButton navigationButton;
	private NavigationButton titleBarButton;

	@Provides
	CustomClientResizingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CustomClientResizingConfig.class);
	}

	@Override
	protected void startUp()
	{
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(customclientresizingProfiles::add);

		pluginPanel = injector.getInstance(CustomClientResizingPluginPanel.class);
		pluginPanel.rebuild();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), ICON_FILE);

		navigationButton = NavigationButton.builder()
			.tooltip(PLUGIN_NAME)
			.icon(icon)
			.priority(1)
			.panel(pluginPanel)
			.build();

		titleBarButton = NavigationButton.builder()
			.tab(false)
			.tooltip("Set resize profile")
			.icon(icon)
			.onClick(() ->
			{
				ContainableFrame frame = clientUi.getFrame();


				CustomClientResizingProfile active = customclientresizingProfiles.stream().filter(CustomClientResizingProfile::isVisible).findFirst().orElse(null);
				if (active == null)
				{
					return;
				}
				Rectangle bounds = new Rectangle(
					active.getPosition().width, active.getPosition().height,
					active.getSize().width, active.getSize().height
				);
				if (!clientUi.isSidebarOpen())
				{
					bounds.width -= clientUi.getPluginToolbar().getWidth();
				}
				if (clientUi.getPluginPanel() == null)
				{
					bounds.width -= pluginPanel.getWrappedPanel().getPreferredSize().width;
				}
				frame.setBounds(bounds);
				frame.revalidateMinimumSize();
			})
			.build();

		clientToolbar.addNavigation(titleBarButton);
		clientToolbar.addNavigation(navigationButton);
	}

	@Override
	protected void shutDown()
	{
		customclientresizingProfiles.clear();
		clientToolbar.removeNavigation(navigationButton);
		clientToolbar.removeNavigation(titleBarButton);

		pluginPanel = null;
		navigationButton = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (customclientresizingProfiles.isEmpty() && event.getGroup().equals(CONFIG_GROUP) && event.getKey().equals(CONFIG_KEY))
		{
			loadConfig(event.getNewValue()).forEach(customclientresizingProfiles::add);
		}


	}

	public void updateConfig()
	{
		if (customclientresizingProfiles.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY);
			return;
		}

		final Gson gson = new Gson();
		final String json = gson
			.toJson(customclientresizingProfiles);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	private Stream<CustomClientResizingProfile> loadConfig(String json)
	{
		if (Strings.isNullOrEmpty(json))
		{
			return Stream.empty();
		}

		final Gson gson = new Gson();
		final List<CustomClientResizingProfile> customclientresizingProfileData = gson.fromJson(json, new TypeToken<ArrayList<CustomClientResizingProfile>>()
		{
		}.getType());

		return customclientresizingProfileData.stream();
	}

	public void addProfile()
	{
		ContainableFrame frame = clientUi.getFrame();
		CustomClientResizingProfile profile = new CustomClientResizingProfile(
			Instant.now().toEpochMilli(),
			"Profile " + (customclientresizingProfiles.size() + 1),
			new Dimension(frame.getX(), frame.getY()),
			new Dimension(frame.getWidth(), frame.getHeight()),
			false
		);

		customclientresizingProfiles.add(profile);
		pluginPanel.updateProfiles();
		updateConfig();
	}

	public void deleteProfile(final CustomClientResizingProfile profile)
	{
		customclientresizingProfiles.remove(profile);
		pluginPanel.updateProfiles();
		updateConfig();
	}

	public void disableProfiles()
	{
		customclientresizingProfiles.forEach(e -> e.setVisible(false));
		pluginPanel.updateProfiles();
	}
}
