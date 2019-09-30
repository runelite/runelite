package net.runelite.client.plugins.bronzeman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintWriter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Seth Davis
 * @Email <sethdavis321@gmail.com>
 * @Discord Reminisce#1707
 */
@PluginDescriptor(
	name = "Bronze Man Mode",
	description = "Restrict yourself as an Iron Meme with GE use for items you have unlocked.",
	tags = {"Bronze", "pve", "restrict", "game", "challenge", "bronzeman", "ironman"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Slf4j
public class BronzemanPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BronzeManOverlay bronzemanOverlay;

	private List<Integer> unlockedItems;

	@Getter
	private BufferedImage unlockImage = null;
	/**
	 * Loads GrandExchange widgets for further manipulation of the interface
	 **/
	private Widget grandExchangeWindow;
	private Widget grandExchangeChatBox;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();
		loadUnlockImage();
		unlockedItems = new ArrayList<>();
		overlayManager.add(bronzemanOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		unlockedItems = null;
		overlayManager.remove(bronzemanOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);

	}

	/**
	 * Loads players unlocks on login
	 **/
	public void onGameStateChanged(GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGED_IN)
		{
			loadPlayerUnlocks();
		}
	}

	/**
	 * Unlocks all new items that are currently not unlocked
	 **/
	public void onItemContainerChanged(ItemContainerChanged e)
	{
		for (Item i : e.getItemContainer().getItems())
		{
			if (i == null)
			{
				continue;
			}
			if (i.getId() <= 1)
			{
				continue;
			}
			if (i.getQuantity() <= 0)
			{
				continue;
			}
			if (!unlockedItems.contains(i.getId()))
			{
				queueItemUnlock(i.getId());
			}
		}
	}

	public void onWidgetLoaded(WidgetLoaded e)
	{
		switch (e.getGroupId())
		{
			case WidgetID.GRAND_EXCHANGE_GROUP_ID:
				grandExchangeWindow = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);
				break;
			case WidgetID.CHATBOX_GROUP_ID:
				grandExchangeWindow = null;
				grandExchangeChatBox = client.getWidget(WidgetInfo.CHATBOX);
				break;
		}
	}

	/**
	 * Handles greying out items in the GrandExchange
	 **/
	public void onGameTick(GameTick e)
	{
		if (grandExchangeWindow == null || grandExchangeChatBox == null || grandExchangeWindow.isHidden())
		{
			return;
		}
		if (client.getWidget(162, 53) == null)
		{
			return;
		}
		Widget[] children = client.getWidget(162, 53).getChildren();
		if (children == null)
		{
			return;
		}
		for (int i = 0; i < children.length; i += 3)
		{
			if (children[i] == null)
			{
				continue;
			}
			if (i + 2 > children.length - 1)
			{
				continue;
			}
			if (!unlockedItems.contains(children[i + 2].getItemId()))
			{
				children[i].setHidden(true);
				children[i + 1].setOpacity(70);
				children[i + 2].setOpacity(70);
			}
		}
	}

	/**
	 * Queues a new unlock to be properly displayed
	 **/
	public void queueItemUnlock(int itemId)
	{
		unlockedItems.add(itemId);
		bronzemanOverlay.addItemUnlock(itemId);
		savePlayerUnlocks();// Save after every item to fail-safe logging out
	}

	/**
	 * Unlocks default items like a bond to a newly made profile
	 **/
	private void unlockDefaultItems()
	{
		queueItemUnlock(ItemID.COINS_995);
		queueItemUnlock(ItemID.OLD_SCHOOL_BOND);
	}

	/**
	 * Saves players unlocks to a .txt file every time they unlock a new item
	 **/
	private void savePlayerUnlocks()
	{
		try
		{
			File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
			File playerFile = new File(playerFolder, "bronzeman-unlocks.txt");
			PrintWriter w = new PrintWriter(playerFile);
			for (int itemId : unlockedItems)
			{
				w.println(itemId);
			}
			w.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Loads a players unlcoks everytime they login
	 **/
	private void loadPlayerUnlocks()
	{
		unlockedItems.clear();
		try
		{
			File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
			if (!playerFolder.exists())
			{
				playerFolder.mkdirs();
			}
			File playerFile = new File(playerFolder, "bronzeman-unlocks.txt");
			if (!playerFile.exists())
			{
				playerFile.createNewFile();
				unlockDefaultItems();
			}
			else
			{
				BufferedReader r = new BufferedReader(new FileReader(playerFile));
				String l;
				while ((l = r.readLine()) != null)
				{
					unlockedItems.add(Integer.parseInt(l));
				}
				r.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Downloads the item-unlock png file to display unlocks
	 **/
	private void loadUnlockImage()
	{
		try
		{
			File imageFile = new File(RuneLite.RUNELITE_DIR, "item-unlocked.png");
			if (!imageFile.exists())
			{
				InputStream in = new URL("https://i.imgur.com/KWVNlsq.png").openStream();
				Files.copy(in, Paths.get(imageFile.getPath()));
			}
			unlockImage = ImageIO.read(imageFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
