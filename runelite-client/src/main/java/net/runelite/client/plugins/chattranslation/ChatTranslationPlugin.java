package net.runelite.client.plugins.chattranslation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@PluginDescriptor(
		name = "Chat Translator",
		description = "Translates messages from one Language to another.",
		tags = {"translate", "language", "english", "spanish", "dutch", "french"},
		type = PluginType.UTILITY
)
public class ChatTranslationPlugin extends Plugin {

	public static final String TRANSLATE = "Translate";
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", "Kick");

	@Inject
	@Nullable
	private Client client;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatTranslationConfig config;

	@Provides
	ChatTranslationConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatTranslationConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (client != null)
		{
			menuManager.get().addPlayerMenuItem(TRANSLATE);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (client != null)
		{
			menuManager.get().removePlayerMenuItem(TRANSLATE);
		}
	}

	@Subscribe
	public void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(TRANSLATE))
		{
			//TODO: Translate selected message.
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());
		String option = event.getOption();

		if (groupId == WidgetInfo.CHATBOX.getGroupId())
		{
			boolean after;

			if (!AFTER_OPTIONS.contains(option))
			{
				return;
			}

			final MenuEntry lookup = new MenuEntry();
			lookup.setOption(TRANSLATE);
			lookup.setTarget(event.getTarget());
			lookup.setType(MenuAction.RUNELITE.getId());
			lookup.setParam0(event.getActionParam0());
			lookup.setParam1(event.getActionParam1());
			lookup.setIdentifier(event.getIdentifier());

			insertMenuEntry(lookup, client.getMenuEntries());
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		switch (chatMessage.getType())
		{
			case PUBLICCHAT:
			case MODCHAT:
				if (!config.publicChat())
				{
					return;
				}
				break;
			default:
				return;
		}

		String message = chatMessage.getMessage();

		Translator translator = new Translator();

		try {
			//Automatically check language of message and translate to selected language.
			String translation = translator.translate("auto", config.targetLanguage().toString(), message);

			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(translation);
			chatMessageManager.update(messageNode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		client.refreshChat();
	}

	private void insertMenuEntry(MenuEntry newEntry, MenuEntry[] entries)
	{
		MenuEntry[] newMenu = ObjectArrays.concat(entries, newEntry);
		int menuEntryCount = newMenu.length;
		ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
		client.setMenuEntries(newMenu);
	}

}
