package net.runelite.client.plugins.bosslog;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.CanvasSizeChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bosslog.enums.Bosses;
import net.runelite.client.plugins.bosslog.enums.Tab;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PluginDescriptor(
		name = "Boss Log",
		description = "Tracks loot from bosses",
		tags = {"drops", "boss", "tracker", "log"},
		enabledByDefault = true //TODO false in final build
)
@Slf4j
public class BossLogPlugin extends Plugin
{
	private boolean active = false;

	private BossLogPanel panel;
	private NavigationButton navButton;

	public List<Boss> bosses = new ArrayList<>();

	@Inject
	private BossLogConfig config;

	@Provides
	BossLogConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BossLogConfig.class);
	}

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ClientToolbar clientToolbar;

	private BossLogConfigHandler bossLogConfigHandler;

	@Override
	protected void startUp() throws Exception
	{
		//init plugin panel
		panel = new BossLogPanel(this, itemManager, client);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
				.tooltip("Boss Log")
				.icon(icon)
				.priority(8)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			updatePlugin();
		}
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			active = false;
			SwingUtilities.invokeLater(() -> panel.clear());
		}
	}

	@Subscribe
	public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();

		for (Boss b : bosses)
		{
			for (int id : b.getBoss().getIds())
			{
				if (id == npc.getId())
				{
					for (ItemStack e : items)
					{
						final ItemComposition itemComposition = itemManager.getItemComposition(e.getId());
						final int price = itemManager.getItemPrice(e.getId());
						b.addItem(new Item(e.getId(), e.getQuantity(), itemComposition.getName(), price));
					}
					b.addKC();
					save(b.getBoss());
					return;
				}
			}
		}
	}

	@Subscribe
	public void onCanvasSizeChanged(CanvasSizeChanged event)
	{ //resize UI to client size
		if (client.getGameState() == GameState.LOGGED_IN) SwingUtilities.invokeLater(() -> panel.update());
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{ // update drops
		updatePlugin();
	}

	private void save(Bosses boss)
	{ //save log data to config
		SwingUtilities.invokeLater(() -> panel.update());

		for (Boss b : bosses)
		{
			if (b.getBoss() == boss)
			{
				bossLogConfigHandler.write(b);
				return;
			}
		}
	}

	private void updatePlugin()
	{
		bossLogConfigHandler = new BossLogConfigHandler(config, client);
		bosses.clear();

		//init bosses
		for (Bosses b : Bosses.class.getEnumConstants())
		{
			bosses.add(bossLogConfigHandler.read(b));
		}

		SwingUtilities.invokeLater(() ->
		{
			panel.init();
			panel.update();
			panel.switchTab(Tab.OVERVIEW);
		});

		active = true;
	}
}
