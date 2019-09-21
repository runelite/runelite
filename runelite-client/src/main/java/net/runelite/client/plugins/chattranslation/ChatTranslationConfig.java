package net.runelite.client.plugins.chattranslation;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("chattranslation")
public interface ChatTranslationConfig extends Config
{
	@ConfigTitleSection(
		keyName = "chatTranslation",
		name = "Chat Translation",
		description = "",
		position = 0
	)
	default Title chatTranslation()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "translateOptionVisable",
		name = "Show 'Translate' menu option",
		description = "Adds 'Translate' to the right-click menu in the Chatbox.",
		position = 1,
		titleSection = "chatTranslation"
	)
	default boolean translateOptionVisable()
	{
		return true;
	}

	@ConfigItem(
		keyName = "publicChat",
		name = "Translate incoming Messages",
		description = "Would you like to Translate Chat?",
		position = 2,
		titleSection = "chatTranslation",
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
		position = 3,
		titleSection = "chatTranslation",
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
		position = 4,
		titleSection = "chatTranslation",
		hidden = true,
		unhide = "publicChat"
	)
	default Languages publicTargetLanguage()
	{
		return Languages.ENGLISH;
	}

	@ConfigTitleSection(
		keyName = "playerMessageTranslation",
		name = "Player Message Translation",
		description = "",
		position = 5
	)
	default Title playerMessageTranslation()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "playerChat",
		name = "Translate outgoing Messages",
		description = "Would you like to Translate your Messages?",
		position = 6,
		titleSection = "playerMessageTranslation"
	)
	default boolean playerChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "playerTargetLanguage",
		name = "Target Language",
		description = "Language to translate messages to.",
		position = 7,
		titleSection = "playerMessageTranslation",
		hidden = true,
		unhide = "playerChat"
	)
	default Languages playerTargetLanguage()
	{
		return Languages.SPANISH;
	}

}
