/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.chattranslate;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("chattranslate")
public interface ChatTranslateConfig extends Config
{

	@ConfigItem(
			position = 0,
			keyName = "howToSetUp",
			name = "*HOW TO SETUP*",
			description = "Open link for set up tutorial."
	)
	default String howToSetUp()
	{
		return "https://github.com/runelite/runelite/wiki/Chat-Translate";
	}

	@ConfigItem(
			position = 1,
			keyName = "translateJSONFile",
			name = "Google JSON Keyfile path",
			description = "API JSON keyfile path used to translate"
	)
	default String translateJSONFile()
	{
		return "";
	}

    @ConfigItem(
            position = 2,
            keyName = "translateToLang",
            name = "Translate To Language",
            description = "The language you want to read"
    )
    default ChatLanguageMode translateToLang()
    {
        return ChatLanguageMode.ENGLISH;
    }

    @ConfigItem(
            position = 3,
            keyName = "translateFromLang",
            name = "Translate From Language",
            description = "The language you don't understand"
    )
    default ChatLanguageMode translateFromLang()
    {
        return ChatLanguageMode.SPANISH;
    }

    @ConfigItem(
            position = 4,
            keyName = "translateFromUsers",
            name = "Translate From Users",
            description = "Translate private messages only from these people; ', ' separated."
    )
    default String translateFromUsers()
    {
        return "*";
    }

	@ConfigItem(
		position = 5,
		keyName = "translatePrivateMessages",
		name = "Translate Private Chat from ^",
		description = "Any private messages from the above players will be translated"
	)
	default boolean translatePrivateMessages()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "translateClanMessages",
		name = "Translate Clan Chat",
		description = "A message received in clan chat."
	)
	default boolean translateClanMessages()
	{
		return true;
	}

	@ConfigItem(
			position = 7,
			keyName = "translateExamineMessages",
			name = "Translate Examine messages",
			description = "Examine item, object, NPC translations."
	)
	default boolean translateExamineMessages()
	{
		return true;
	}

	@ConfigItem(
			position = 8,
			keyName = "translateGameMessages",
			name = "Translate Game messages",
			description = "Game setting changed or server message."
	)
	default boolean translateGameMessages()
	{
		return true;
	}

	@ConfigItem(
			position = 9,
			keyName = "translatePublicMessages",
			name = "Translate Public Chat*",
			description = "*Use with caution* Can quickly use your quota"
	)
	default boolean translatePublicMessages()
	{
		return false;
	}

	/*
	//TODO: Implement this
	@ConfigItem(
			position = 10,
			keyName = "translateNPCConversations",
			name = "Translate NPC Conversations*",
			description = "Translates options and dialog between your character and a NPC."
	)
	default boolean translateNPCConversations()
	{
		return false;
	}
	*/

	/*
    //TODO: Implement this
	@ConfigItem(
			position = 11,
			keyName = "enableTranslationCommands",
			name = "Enable Translation Commands",
			description = "Translate outgoing messages; Usage: !t<lang> <message> !tes Hello = Hola"
	)
	default boolean enableTranslationCommands()
	{
		return true;
	}
	*/
}
