package net.runelite.client.plugins.slayerarea;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.slayerarea.ui.SlayerAreaPluginPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
		name = "Slayer Areas",
		description = "Save slayer monster region locations.",
		tags = {"slayer", "region", "panel"}
)
public class SlayerAreaPlugin extends Plugin
{

	static final String PLUGIN_NAME = "Slayer Areas";
	static final String CONFIG_GROUP = "slayerarea";
	static final String CONFIG_KEY = "slayerarea";
	static final String ICON_FILE = "panel_icon.png";

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private SlayerAreaConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SlayerAreaOverlay slayerAreaOverlay;

	private SlayerAreaPluginPanel pluginPanel;
	private NavigationButton navigationButton;
	private SlayerAreaMapIcons slayerAreaMapIcons;

	@Provides
	SlayerAreaConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerAreaConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		SlayerAreas.readAreas();
		SlayerAreas.backup("StartupAMDbak");
		setConfig();

		pluginPanel = injector.getInstance(SlayerAreaPluginPanel.class);
		pluginPanel.rebuild();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), ICON_FILE);

		navigationButton = NavigationButton.builder()
				.tooltip(PLUGIN_NAME)
				.icon(icon)
				.priority(5)
				.panel(pluginPanel)
				.build();

		clientToolbar.addNavigation(navigationButton);

		overlayManager.add(slayerAreaOverlay);
		slayerAreaMapIcons = new SlayerAreaMapIcons(client, config, worldMapPointManager, itemManager, clientThread);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navigationButton);
		overlayManager.remove(slayerAreaOverlay);
		slayerAreaMapIcons.stop();

		pluginPanel = null;
		navigationButton = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		slayerAreaMapIcons.gameStateChanged(event);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_KEY))
		{
			return;
		}

		setConfig();
		slayerAreaMapIcons.configChanged(event);
	}

	private void setConfig()
	{
		SlayerAreas.configLockedShader = config.useLockedShader();
		SlayerAreas.configLockedMap = config.drawLockedMap();
		SlayerAreas.configRegionId = config.drawRegionId();

	}
}
