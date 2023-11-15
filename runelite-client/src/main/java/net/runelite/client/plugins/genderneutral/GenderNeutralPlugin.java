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

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.List;

import static java.util.Collections.replaceAll;

@Slf4j

@PluginDescriptor(
		name = "Gender Neutral",
		description = "Replaces gendered text refering to the player with custom input alternatives. Useful for nonbinary people or for roleplaying",
		tags = {"replacer","dialogue","dialog","nonbinary"},
		loadWhenOutdated = true,
		enabledByDefault = false
)
public class GenderNeutralPlugin extends Plugin
{
	private String[] honorifics = {"Lady", "Dame", "Sir", "Ma'am", "Madam", "Milady", "Milord", "Sirrah"};
	private String[] nouns = {"Man", "Woman"};
	private String[] possessivePronouns = {"His","Her"};
	private String[] objectPronouns = {"He","She"};
	private String[] subjectPronouns = {"Him","Her"};
	private String[] diminutive = {"Boy","Gal"};
	private String[] lad = {"Lad","Lass"};
	@Inject
	private Client client;

	@Inject
	private GenderNeutralConfig config;

	/*
	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Hello, " + config.honorific(), null);
		}
	}
	*/

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);

		if(config.replaceNpcDialog()) {
			if (npcDialog != null) {
				if(!config.honorific().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), honorifics, config.honorific()));
				if(!config.man().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), nouns, config.man()));
				if(!config.his().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), possessivePronouns, config.his()));
				if(!config.him().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), objectPronouns, config.him()));
				if(!config.he().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), subjectPronouns, config.he()));
				if(!config.diminutive().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), diminutive, config.diminutive()));
				if(!config.lad().equals(""))
					((Widget) npcDialog).setText(replaceAll(npcDialog.getText(), lad, config.lad()));
			}
		}

	}

	private String replaceAll(String line, String[] queries, String replacement)
	{
		int i=0;
		for (String query : queries) {
			line=line.replaceAll(query, replacement);
			//case-sensitive
			line=line.replaceAll(query.toLowerCase(), replacement.toLowerCase());
		}
		return line;

	}

	@Provides
	GenderNeutralConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GenderNeutralConfig.class);
	}
}
