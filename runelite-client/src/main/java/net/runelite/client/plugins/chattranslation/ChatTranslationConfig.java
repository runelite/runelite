package net.runelite.client.plugins.chattranslation;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("chattranslation")
public interface ChatTranslationConfig extends Config
{

	@ConfigItem(
		keyName = "translateOptionVisable",
		name = "Show 'Translate' menu option",
		description = "Adds 'Translate' to the right-click menu in the Chatbox.",
		position = 0,
		group = "Chat Translation"
	)
	default boolean translateOptionVisable()
	{
		return true;
	}

	@ConfigItem(
		keyName = "publicChat",
		name = "Translate incoming Messages",
		description = "Would you like to Translate Chat?",
		position = 1,
		group = "Chat Translation",
		hidden = true,
		unhide = "translateOptionVisable"
	)
	default boolean publicChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "playerNames",
		name = "Translated Player list:",
		description = "Players you add to this list will be Translated in chat.",
		position = 2,
		group = "Chat Translation",
		hidden = true,
		unhide = "translateOptionVisable"
	)
	default String getPlayerNames()
	{
		return "";
	}

	@ConfigItem(
		keyName = "publicTargetLanguage",
		name = "Target Language",
		description = "Language to translate messages to.",
		position = 2,
		group = "Chat Translation",
		hidden = true,
		unhide = "publicChat"
	)
	default Languages publicTargetLanguage()
	{
		return Languages.ENGLISH;
	}

	@ConfigItem(
		keyName = "playerChat",
		name = "Translate outgoing Messages",
		description = "Would you like to Translate your Messages?",
		position = 3,
		group = "Player Message Translation"
	)
	default boolean playerChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "playerTargetLanguage",
		name = "Target Language",
		description = "Language to translate messages to.",
		position = 4,
		group = "Player Message Translation",
		hidden = true,
		unhide = "playerChat"
	)
	default Languages playerTargetLanguage()
	{
		return Languages.SPANISH;
	}

}
