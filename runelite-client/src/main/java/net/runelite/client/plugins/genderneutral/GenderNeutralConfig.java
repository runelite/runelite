/*
 * Copyright (c) 2023, Ace <https://github.com/ace-english>
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

package net.runelite.client.plugins.genderneutral;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import net.runelite.client.config.ConfigSection;

@ConfigGroup("genderneutral")
public interface GenderNeutralConfig extends Config
{
	@ConfigItem(
			keyName = "replaceNpcDialog",
			name = "Replace NPC dialogue",
			position = 0,
			description = "replace for quests and NPC dialogue"
	)
	default boolean replaceNpcDialog()
	{
		return true;
	}

	/*
	@ConfigItem(
			keyName = "replaceChatbox",
			name = "Replace chatbox text",
			position = 1,
			description = "replace chatbox text for npcs and players"
	)
	default boolean replaceChatbox()
	{
		return true;
	}

	@ConfigItem(
			keyName = "replaceOverheadText",
			name = "Replace overhead text",
			position = 2,
			description = "replace overhead texts for NPCs and players"
	)
	default boolean replaceOverheadText()
	{
		return true;
	}
	*/

	@ConfigSection(
			name = "Replacement strings",
			position = 4,
			description = "Set specific replacements for chosen words/phrases. Leave blank to not replace"
	)
	String replacementsSection = "replacementsSection";


	@ConfigItem(
			keyName = "honorific",
			name = "Honorifics",
			position = 0,
			description = "Sir/Ma'am/Milady, etc",
			section = replacementsSection
	)
	default String honorific()
	{
		return "Comrade";
	}

	@ConfigItem(
			keyName = "man",
			name = "Man/Woman",
			position = 1,
			description = "Man/Woman",
			section = replacementsSection
	)
	default String man()
	{
		return "Person";
	}

	@ConfigItem(
		keyName = "his",
		name = "His/Her",
			position = 2,
		description = "possesive pronoun replacement",
		section = replacementsSection
	)
	default String his()
	{
		return "Their";
	}

	@ConfigItem(
		keyName = "him",
		name = "Him/Her",
			position = 3,
		description = "object pronoun replacement",
		section = replacementsSection
	)
	default String him()
	{
		return "Them";
	}

	@ConfigItem(
		keyName = "he",
		name = "He/She",
			position = 4,
		description = "subject pronoun replacement",
		section = replacementsSection
	)
	default String he()
	{
		return "They";
	}

	@ConfigItem(
			keyName = "diminutive",
			name = "Boy/Gal",
			position = 5,
			description = "mostly for Sir Tiffy",
			section = replacementsSection
	)
	default String diminutive()
	{
		return "Kiddo";
	}

	@ConfigItem(
			keyName = "lad",
			name = "Lad/Lass",
			position = 6,
			description = "mostly for Sir Tiffy",
			section = replacementsSection
	)
	default String lad()
	{
		return "Lay";
	}


}
