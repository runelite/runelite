package net.runelite.client.plugins.chattranslation;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.MessageNode;
import static net.runelite.api.ScriptID.CHATBOX_INPUT;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
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
import net.runelite.api.util.Text;

@PluginDescriptor(
	name = "Chat Translator",
	description = "Translates messages from one Language to another.",
	tags = {"translate", "language", "english", "spanish", "dutch", "french", "welsh", "german"},
	type = PluginType.UTILITY
)
@Singleton
@Slf4j
public class ChatTranslationPlugin extends Plugin implements KeyListener
{
	private static final Object PUBLIC = new Object();
	private static final Object OPTION = new Object();
	private static final String TRANSLATE = "Translate";

	// TODO: Find out if "Remove friend" is correct here, aka if clan tab should have the Translate option
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", "Kick");

	private final Translator translator = new Translator();
	private final Set<String> playerNames = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MenuManager menuManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatTranslationConfig config;

	@Inject
	private EventBus eventBus;

	@Provides
	ChatTranslationConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatTranslationConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		translator.setInLang(config.publicTargetLanguage());
		translator.setOutLang(config.playerTargetLanguage());

		if (config.playerChat())
		{
			keyManager.registerKeyListener(this);
		}

		if (config.publicChat())
		{
			eventBus.subscribe(ChatMessage.class, PUBLIC, this::onChatMessage);
		}

		if (config.translateOptionVisible())
		{
			menuManager.addPlayerMenuItem(TRANSLATE);
			eventBus.subscribe(MenuOpened.class, OPTION, this::onMenuOpened);
			eventBus.subscribe(MenuOptionClicked.class, OPTION, this::onMenuOptionClicked);
		}

		for (String name : Text.fromCSV(config.playerNames().toLowerCase()))
		{
			playerNames.add(Text.toJagexName(name));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		eventBus.unregister(OPTION);
		eventBus.unregister(PUBLIC);
		menuManager.removePlayerMenuItem(TRANSLATE);
		keyManager.unregisterKeyListener(this);
		playerNames.clear();
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("chattranslation"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "translateOptionVisible":
				if (config.translateOptionVisible())
				{
					menuManager.addPlayerMenuItem(TRANSLATE);
					eventBus.subscribe(MenuOpened.class, TRANSLATE, this::onMenuOpened);
					eventBus.subscribe(MenuOptionClicked.class, TRANSLATE, this::onMenuOptionClicked);
				}
				else
				{
					menuManager.removePlayerMenuItem(TRANSLATE);
					eventBus.unregister(TRANSLATE);
				}
				break;
			case "publicChat":
				if (config.publicChat())
				{
					eventBus.subscribe(ChatMessage.class, PUBLIC, this::onChatMessage);
				}
				else
				{
					eventBus.unregister(PUBLIC);
				}
				break;
			case "playerNames":
				playerNames.clear();
				for (String names : Text.fromCSV(config.playerNames().toLowerCase()))
				{
					playerNames.add(Text.toJagexName(names));
				}
				break;
			case "publicTargetLanguage":
				translator.setInLang(config.publicTargetLanguage());
				break;
			case "playerChat":
				if (config.playerChat())
				{
					keyManager.registerKeyListener(this);
				}
				else
				{
					keyManager.unregisterKeyListener(this);
				}
				break;
			case "playerTargetLanguage":
				translator.setOutLang(config.playerTargetLanguage());
				break;
		}
	}

	private void onMenuOpened(MenuOpened event)
	{
		MenuEntry[] entries = event.getMenuEntries();

		for (int i = 0; i < event.getMenuEntries().length; i++)
		{
			if (!AFTER_OPTIONS.contains(entries[i].getOption()))
			{
				continue;
			}

			MenuEntry[] newEntries = new MenuEntry[entries.length + 1];

			System.arraycopy(entries, 0, newEntries, 0, i + 1);
			System.arraycopy(entries, i, newEntries, i + 1, entries.length - i);

			newEntries[i] = newEntries[i].clone();
			newEntries[i].setOption(TRANSLATE);
			newEntries[i].setOpcode(MenuOpcode.RUNELITE.getId());

			event.setMenuEntries(newEntries);
			event.setModified();

			return;
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getOpcode() != MenuOpcode.RUNELITE.getId() ||
			!event.getOption().equals(TRANSLATE))
		{
			return;
		}

		String name =
			Text.toJagexName(
				Text.removeTags(event.getTarget(), true)
					.toLowerCase()
			);

		playerNames.add(name);

		config.playerNames(Text.toCSV(playerNames));
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
				break;
			default:
				return;
		}

		if (!playerNames.contains(Text.toJagexName(Text.removeTags(chatMessage.getName().toLowerCase()))))
		{
			return;
		}

		final String message = chatMessage.getMessage();

		try
		{
			final String translation = translator.translateIncoming(message);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(translation);
			chatMessageManager.update(messageNode);
		}
		catch (IOException e)
		{
			log.warn("Error translating message", e);
		}

		client.refreshChat();
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);

		if (chatboxParent == null || chatboxParent.getOnKeyListener() == null || event.getKeyCode() != 0xA)
		{
			return;
		}

		final String message = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);
		final String translated;

		try
		{
			translated = translator.translateOutgoing(message);
		}
		catch (IOException e)
		{
			log.warn("Error translating message", e);
			return;
		}

		if (message.startsWith("/"))
		{
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, translated.startsWith("/") ? translated : "/" + translated);
			return;
		}

		event.consume();

		client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, translated);

		clientThread.invoke(() -> client.runScript(CHATBOX_INPUT, 0, translated));

		client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
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
}