package net.runelite.client.plugins.resize;

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
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.resize.ui.ResizePluginPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ContainableFrame;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
		name = "Resize",
		description = "Resize the window to saved profiles",
		tags = {"resize", "window", "position", "layout", "manage"}
)
public class ResizePlugin extends Plugin
{
	public static final String CONFIG_GROUP = "resize";
	private static final String CONFIG_KEY = "profiles";
	private static final String PLUGIN_NAME = "Resize";
	private static final String ICON_FILE = "panel_icon.png";

	@Getter
	private final List<ResizeProfile> resizeProfiles = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private ResizeConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientUI clientUi;

	private ResizePluginPanel pluginPanel;
	private NavigationButton navigationButton;
	private NavigationButton titleBarButton;

	@Provides
	ResizeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ResizeConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(resizeProfiles::add);

		pluginPanel = injector.getInstance(ResizePluginPanel.class);
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


					ResizeProfile active = resizeProfiles.stream().filter(ResizeProfile::isVisible).findFirst().orElse(null);
					if (active == null) return;
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
	protected void shutDown() throws Exception
	{
		resizeProfiles.clear();
		clientToolbar.removeNavigation(navigationButton);

		pluginPanel = null;
		navigationButton = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (resizeProfiles.isEmpty() && event.getGroup().equals(CONFIG_GROUP) && event.getKey().equals(CONFIG_KEY))
		{
			loadConfig(event.getNewValue()).forEach(resizeProfiles::add);
		}


	}

	public void updateConfig()
	{
		if (resizeProfiles.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY);
			return;
		}

		final Gson gson = new Gson();
		final String json = gson
				.toJson(resizeProfiles);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	private Stream<ResizeProfile> loadConfig(String json)
	{
		if (Strings.isNullOrEmpty(json))
		{
			return Stream.empty();
		}

		final Gson gson = new Gson();
		final List<ResizeProfile> resizeProfileData = gson.fromJson(json, new TypeToken<ArrayList<ResizeProfile>>()
		{
		}.getType());

		return resizeProfileData.stream();
	}

	public void addProfile()
	{
		ContainableFrame frame = clientUi.getFrame();
		ResizeProfile profile = new ResizeProfile(
				Instant.now().toEpochMilli(),
				"Profile " + (resizeProfiles.size() + 1),
				new Dimension(frame.getX(), frame.getY()),
				new Dimension(frame.getWidth(), frame.getHeight()),
				false
		);

		resizeProfiles.add(profile);
		pluginPanel.updateProfiles();
		updateConfig();
	}

	public void deleteProfile(final ResizeProfile profile)
	{
		resizeProfiles.remove(profile);
		pluginPanel.updateProfiles();
		updateConfig();
	}

	public void disableProfiles()
	{
		resizeProfiles.forEach(e -> e.setVisible(false));
		pluginPanel.updateProfiles();
	}
}
