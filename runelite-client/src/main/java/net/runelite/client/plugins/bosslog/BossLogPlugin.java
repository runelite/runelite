package net.runelite.client.plugins.bosslog;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CanvasSizeChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SessionOpen;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
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
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PluginDescriptor(
		name = "Boss Log",
		description = "Tracks loot from bosses",
		tags = {"drops", "boss", "tracker", "log"},
		enabledByDefault = false
)
@Slf4j
public class BossLogPlugin extends Plugin
{
	private boolean active = false;
	private static final int THEATRE_OF_BLOOD_REGION = 12867;

	private BossLogPanel panel;
	private NavigationButton navButton;

	final public List<Boss> bosses = new ArrayList<>();

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
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN && !active)
		{
			updatePlugin();
		}
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN && active)
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
						b.addItem(new BossLogItem(e.getId(), e.getQuantity(), itemComposition.getName(), price));
					}
					b.addKC();
					save(b.getBoss());
					return;
				}
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{ //handle TOB & COX
		ItemContainer ic;
		switch (event.getGroupId())
		{
			case (WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID):
				ic = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
				for (Boss boss : bosses)
				{
					if (boss.getBoss() == Bosses.COX)
					{
						for (Item e : ic.getItems())
						{
							final ItemComposition itemComposition = itemManager.getItemComposition(e.getId());
							final int price = itemManager.getItemPrice(e.getId());
							boss.addItem(new BossLogItem(e.getId(), e.getQuantity(),
									itemComposition.getName(), price));
						}
						boss.addKC();
						save(boss.getBoss());
					}
				}
				break;
			case (WidgetID.THEATRE_OF_BLOOD_GROUP_ID):
				int region = WorldPoint.fromLocalInstance(client,
						client.getLocalPlayer().getLocalLocation()).getRegionID();
				if (region != THEATRE_OF_BLOOD_REGION)
				{
					return;
				}
				ic = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
				for (Boss boss : bosses)
				{
					if (boss.getBoss() == Bosses.TOB)
					{
						for (Item e : ic.getItems())
						{
							final ItemComposition itemComposition = itemManager.getItemComposition(e.getId());
							final int price = itemManager.getItemPrice(e.getId());
							boss.addItem(new BossLogItem(e.getId(), e.getQuantity(),
									itemComposition.getName(), price));
						}
						boss.addKC();
						save(boss.getBoss());
					}
				}
				break;
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
		if (client.getGameState() == GameState.LOGGED_IN) updatePlugin();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("bosslog") && active)
		{
			if (event.getNewValue().equals("true") || event.getNewValue().equals("false"))
			{
				updatePlugin();
			}
		}
	}

	public void save(Bosses boss)
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
		for (Bosses b : Bosses.getTracked(config))
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
