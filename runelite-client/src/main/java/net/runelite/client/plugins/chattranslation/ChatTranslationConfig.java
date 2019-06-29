package net.runelite.client.plugins.chattranslation;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("chattranslation")
public interface ChatTranslationConfig extends Config
{

	@ConfigItem(
			keyName = "publicChat",
			name = "Translate All Public Chat?",
			description = "Would you like to Translate Public Chat?",
			position = 0
	)
	default boolean publicChat() { return false; }

	@ConfigItem(
			keyName = "targetLanguage",
			name = "Target Language",
			description = "Language to translate messages too.",
			position = 2,
			hidden = true,
			unhide = "publicChat"
	)
	default Languages targetLanguage()
	{
		return Languages.ENGLISH;
	}

}
