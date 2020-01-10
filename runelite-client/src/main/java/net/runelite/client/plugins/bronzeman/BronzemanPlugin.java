package net.runelite.client.plugins.bronzeman;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.util.Text;
import static net.runelite.api.util.Text.sanitize;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

/**
 * @author Seth Davis
 * @Email <sethdavis321@gmail.com>
 * @Discord Reminisce#1707
 */
@PluginDescriptor(
	name = "Bronze Man Mode",
	description = "Restrict yourself as an Iron Meme with GE use for items you have unlocked.",
	tags = {"Bronze", "pve", "restrict", "game", "challenge", "bronzeman", "ironman"},
	type = PluginType.GAMEMODE,
	enabledByDefault = false
)
@Slf4j
public class BronzemanPlugin extends Plugin
{

	private static final String BACKUP_CHAT_COMMAND = "!backupunlocks";
	private static final String COUNT_CHAT_COMMAND = "!countunlocks";
	private static final String DELETE_CHAT_COMMAND = "!deleteunlocks";
	private static final String RESET_CHAT_COMMAND = "!resetunlocks";
	private static final String RESTORE_CHAT_COMMAND = "!restoreunlocks";

	private final BufferedImage UNLOCK_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "item_unlocked.png");

	@Inject
	ItemManager itemManager;
	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private BronzeManConfig config;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private BronzeManOverlay bronzemanOverlay;
	private List<Integer> unlockedItems;
	@Getter(AccessLevel.PACKAGE)
	private BufferedImage unlockImage = null;
	private boolean notifyImgUnlock;
	private boolean notifyChatUnlock;
	private boolean resetCommand;
	private boolean countCommand;
	private boolean backupCommand;
	private boolean deleteCommand;
	private boolean restoreCommand;
	private boolean hideTradeOption;

	/**
	 * Loads GrandExchange widgets for further manipulation of the interface
	 **/
	private Widget grandExchangeWindow;
	private Widget grandExchangeChatBox;

	@Provides
	BronzeManConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BronzeManConfig.class);
	}

	@Override
	protected void startUp()
	{
		/**
		 * Downloads the item-unlock png file to display unlocks
		 **/
		unlockImage = UNLOCK_IMAGE;

		unlockedItems = new ArrayList<>();
		overlayManager.add(bronzemanOverlay);
		updateConfig();
		loadPlayerUnlocks();
	}

	@Override
	protected void shutDown()
	{
		unlockedItems = null;
		overlayManager.remove(bronzemanOverlay);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getKey().equals("notifyImgUnlock"))
		{
			overlayManager.remove(bronzemanOverlay);
		}
		if (!event.getGroup().equals("bronzemanmode"))
		{
			return;
		}

		updateConfig();
	}

	/**
	 * Loads players unlocks on login
	 **/
	@Subscribe
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
	@Subscribe
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

	@Subscribe
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
	@Subscribe
	public void onClientTick(ClientTick e)
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
	private void queueItemUnlock(int itemId)
	{
		unlockedItems.add(itemId);
		savePlayerUnlocks();// Save after every item to fail-safe logging out
		if (this.notifyChatUnlock)
		{
			sendMessage("You have successfully unlocked item: " + itemManager.getItemDefinition(itemId).getName());
		}

		if (!this.notifyImgUnlock)
		{
			return;
		}
		bronzemanOverlay.addItemUnlock(itemId);

	}

	/**
	 * Unlocks default items like a bond to a newly made profile
	 **/
	private void unlockDefaultItems()
	{
		queueItemUnlock(ItemID.COINS_995);
		queueItemUnlock(ItemID.OLD_SCHOOL_BOND);
		queueItemUnlock(ItemID.PLATINUM_TOKEN);
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
	 * Loads a players unlocks everytime they login
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


	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		final String playerName;

		if (chatMessage.equals(ChatMessageType.PRIVATECHATOUT))
		{
			playerName = client.getLocalPlayer().getName();
		}
		else
		{
			playerName = sanitize(chatMessage.getName());
		}
		if (this.countCommand && chatMessage.getMessage().toLowerCase().equals(COUNT_CHAT_COMMAND))
		{
			sendMessage("You have successfully unlocked " + unlockedItems.size() + " items.");
		}
		if (this.resetCommand && chatMessage.getMessage().toLowerCase().equals(RESET_CHAT_COMMAND))
		{
			resetUnlocks();
		}
		if (this.backupCommand && chatMessage.getMessage().toLowerCase().equals(BACKUP_CHAT_COMMAND))
		{
			backupUnlocks();
		}
		if (this.deleteCommand && chatMessage.getMessage().toLowerCase().equals(DELETE_CHAT_COMMAND))
		{
			deleteUnlocks();
		}
		if (this.restoreCommand && chatMessage.getMessage().toLowerCase().equals(RESTORE_CHAT_COMMAND))
		{
			restoreUnlocks();
		}
	}

	private void backupUnlocks()
	{
		File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
		if (!playerFolder.exists())
		{
			return;
		}
		File playerFile = new File(playerFolder, "bronzeman-unlocks.txt");
		if (!playerFile.exists())
		{
			return;
		}

		Path originalPath = playerFile.toPath();
		try
		{
			Files.copy(originalPath, Paths.get(playerFile.getPath().replace(".txt", ".backup")),
				StandardCopyOption.REPLACE_EXISTING);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		sendMessage("Successfully backed up current unlock file!");
	}

	private void restoreUnlocks()
	{
		File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
		if (!playerFolder.exists())
		{
			return;
		}
		File playerFile = new File(playerFolder, "bronzeman-unlocks.backup");
		if (!playerFile.exists())
		{
			return;
		}

		Path originalPath = playerFile.toPath();
		try
		{
			Files.copy(originalPath, Paths.get(playerFile.getPath().replace(".backup", ".txt")),
				StandardCopyOption.REPLACE_EXISTING);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		sendMessage("Successfully restored current unlock file!");
	}

	private void resetUnlocks()
	{
		try
		{
			File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
			File playerFile = new File(playerFolder, "bronzeman-unlocks.txt");
			playerFile.delete();
			unlockedItems.clear();
			savePlayerUnlocks();
			unlockDefaultItems();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		sendMessage("Current Unlock file succesfully reset!");
	}

	private void deleteUnlocks()
	{
		backupUnlocks();
		try
		{
			File playerFolder = new File(RuneLite.PROFILES_DIR, client.getUsername());
			File playerFile = new File(playerFolder, "bronzeman-unlocks.txt");
			playerFile.delete();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		sendMessage("Current Unlock file succesfully deleted!");
	}

	@Subscribe
	private void onMenuOpened(MenuOpened event)
	{
		Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return;
		}

		List<MenuEntry> menu_entries = new ArrayList<>();

		for (MenuEntry entry : event.getMenuEntries())
		{
			String option = Text.removeTags(entry.getOption()).toLowerCase();

			if (option.contains("trade with") && this.hideTradeOption)
			{
				continue;
			}
			menu_entries.add(entry);
		}
		event.setMenuEntries(menu_entries.toArray(new MenuEntry[0]));
		event.setModified();
	}

	private void sendMessage(String text)
	{
		final ChatMessageBuilder message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(text);

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message.build())
			.build());
	}

	private void updateConfig()
	{
		this.notifyImgUnlock = config.notifyImgUnlock();
		this.resetCommand = config.resetCommand();
		this.countCommand = config.countCommand();
		this.backupCommand = config.backupCommand();
		this.notifyChatUnlock = config.notifyChatUnlock();
		this.deleteCommand = config.deleteCommand();
		this.restoreCommand = config.restoreCommand();
		this.hideTradeOption = config.hideTradeOption();
	}

}