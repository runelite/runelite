package net.runelite.client.plugins.inventorytagger;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.hiscore.HiscorePanel;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Inventory Item Tagging",
	enabledByDefault = true
)
public class InventoryTaggerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private InventoryTaggerPlugin plugin;

	@Inject
	private InventoryTaggerConfig config;

	@Inject
	private InventoryTaggerOverlay overlay;

	private InventoryTaggerPanel inventoryTaggerPanel;

	public Set<TaggedItems> taggedItems = new HashSet<>();

	@Provides
	InventoryTaggerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventoryTaggerConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Inject
	private PluginToolbar pluginToolbar;

	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		//testing
		TaggedItems tItem;

		tItem = new TaggedItems("Mele gier", new Color(255, 0, 0, 50));
		tItem.addItem(13239);
		tItem.addItem(19553);
		taggedItems.add(tItem);

		tItem = new TaggedItems("Range gier", new Color(0, 255, 0, 50));
		tItem.addItem(13237);
		tItem.addItem(12926);
		tItem.addItem(19547);
		taggedItems.add(tItem);

		tItem = new TaggedItems("Mage gier", new Color(0, 0, 255, 50));
		tItem.addItem(12899);
		tItem.addItem(13235);
		taggedItems.add(tItem);


		inventoryTaggerPanel = new InventoryTaggerPanel(this, client, plugin);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(HiscorePanel.class.getResourceAsStream("search.png"));
		}

		navButton = NavigationButton.builder()
				.name("Item Tagger")
				.icon(icon)
				.panel(inventoryTaggerPanel)
				.build();

		pluginToolbar.addNavigation(navButton);


	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}
}
