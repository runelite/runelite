package net.runelite.client.plugins.chattranslation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.MessageNode;
import static net.runelite.api.ScriptID.CHATBOX_INPUT;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Chat Translator",
	description = "Translates messages from one Language to another.",
	tags = {"translate", "language", "english", "spanish", "dutch", "french"},
	type = PluginType.UTILITY
)
@Singleton
@Slf4j
public class ChatTranslationPlugin extends Plugin implements KeyListener
{

	private static final String TRANSLATE = "Translate";

	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", "Kick");

	private final Set<String> playerNames = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatTranslationConfig config;

	@Inject
	private EventBus eventBus;

	private boolean translateOptionVisable;
	private boolean publicChat;
	private String getPlayerNames;
	private Languages publicTargetLanguage;
	private boolean playerChat;
	private Languages playerTargetLanguage;

	@Provides
	ChatTranslationConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatTranslationConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		if (client != null && this.translateOptionVisable)
		{
			menuManager.get().addPlayerMenuItem(TRANSLATE);
		}
		keyManager.registerKeyListener(this);

		playerNames.addAll(Text.fromCSV(config.getPlayerNames()));
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		if (client != null && this.translateOptionVisable)
		{
			menuManager.get().removePlayerMenuItem(TRANSLATE);
		}
		keyManager.unregisterKeyListener(this);

		playerNames.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(PlayerMenuOptionClicked.class, this, this::onPlayerMenuOptionClicked);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chattranslation"))
		{
			updateConfig();
			if (event.getKey().equals("playerNames"))
			{
				for (String names : Text.fromCSV(this.getPlayerNames))
				{
					if (!playerNames.contains(Text.toJagexName(names)))
					{
						playerNames.add(Text.toJagexName(names));
					}
				}
			}
		}
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!this.translateOptionVisable)
		{
			return;
		}

		int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());
		String option = event.getOption();

		if (groupId == WidgetInfo.CHATBOX.getGroupId())
		{
			if (!AFTER_OPTIONS.contains(option))
			{
				return;
			}

			final MenuEntry menuEntry = new MenuEntry();
			menuEntry.setOption(TRANSLATE);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.RUNELITE.getId());
			menuEntry.setParam0(event.getActionParam0());
			menuEntry.setParam1(event.getActionParam1());
			menuEntry.setIdentifier(event.getIdentifier());

			MenuEntry[] newMenu = ObjectArrays.concat(menuEntry, client.getMenuEntries());
			int menuEntryCount = newMenu.length;
			ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
			client.setMenuEntries(newMenu);
		}
	}

	private void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(TRANSLATE))
		{
			String name = Text.toJagexName(event.getMenuTarget());
			if (!playerNames.contains(name))
			{
				playerNames.add(name);
			}

			configManager.setConfiguration("chattranslation", "playerNames", Text.toCSV(playerNames));
			configManager.sendConfig();
		}
	}

	private void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		switch (chatMessage.getType())
		{
			case PUBLICCHAT:
			case MODCHAT:
			case FRIENDSCHAT:
				if (!this.publicChat)
				{
					return;
				}
				break;
			default:
				return;
		}

		for (String nameList : playerNames)
		{
			if (nameList.contains(Text.toJagexName(chatMessage.getName())))
			{
				String message = chatMessage.getMessage();

				Translator translator = new Translator();

				try
				{
					//Automatically check language of message and translate to selected language.
					String translation = translator.translate("auto", this.publicTargetLanguage.toString(), message);
					if (translation != null)
					{
						final MessageNode messageNode = chatMessage.getMessageNode();
						messageNode.setRuneLiteFormatMessage(translation);
						chatMessageManager.update(messageNode);
					}
				}
				catch (Exception e)
				{
					log.warn(e.toString());
				}

				client.refreshChat();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (!this.playerChat)
		{
			return;
		}

		Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);

		if (chatboxParent != null && chatboxParent.getOnKeyListener() != null && event.getKeyCode() == 0xA)
		{
			Translator translator = new Translator();
			String message = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);

			if (message.startsWith("/"))
			{
				try
				{
					client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, translator.translate("auto", config.playerTargetLanguage().toString(), message));
				}
				catch (Exception e)
				{
					log.warn("Translation error", e);
				}
				return;
			}

			event.consume();

			try
			{
				//Automatically check language of message and translate to selected language.
				String translation = translator.translate("auto", this.playerTargetLanguage.toString(), message);
				if (translation != null)
				{
					client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, translation);

					clientThread.invoke(() ->
						client.runScript(CHATBOX_INPUT, 0, translation));
				}
				client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
			}
			catch (Exception e)
			{
				log.warn(e.toString());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// Nothing.
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// Nothing.
	}

	private void updateConfig()
	{
		this.publicChat = config.publicChat();
		this.getPlayerNames = config.getPlayerNames();
		this.translateOptionVisable = config.translateOptionVisable();
		this.publicTargetLanguage = config.publicTargetLanguage();
		this.playerChat = config.playerChat();
		this.playerTargetLanguage = config.playerTargetLanguage();
	}
}
