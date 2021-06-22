/*
 * Copyright (c) 2019, Weird Gloop <admin@weirdgloop.org>
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

package net.runelite.client.plugins.crowdsourcing.dialogue;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

public class CrowdsourcingDialogue
{
	private static final String USERNAME_TOKEN = "%USERNAME%";

	@Inject
	private Client client;

	@Inject
	private CrowdsourcingManager manager;

	private boolean inDialogue = false;
	private String lastNpcDialogueText = null;
	private String lastPlayerDialogueText = null;
	private Widget[] dialogueOptions;

	private String sanitize(String dialogue)
	{
		String username = client.getLocalPlayer().getName();
		return dialogue.replaceAll(username, USERNAME_TOKEN);
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget npcDialogueTextWidget = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		Widget playerDialogueTextWidget = client.getWidget(WidgetInfo.DIALOG_PLAYER_TEXT);
		Widget playerDialogueOptionsWidget = client.getWidget(WidgetInfo.DIALOG_OPTION_OPTIONS);

		// If we were not in a conversation, but now one of these widgets is not null, we have started a conversation.
		// Else if we were in a conversation, but now there is no widget, we have left the conversation.
		if (!inDialogue && (npcDialogueTextWidget != null || playerDialogueTextWidget != null || playerDialogueOptionsWidget != null))
		{
			inDialogue = true;
			manager.storeEvent(new StartEndData(true));
		}
		else if (inDialogue && npcDialogueTextWidget == null && playerDialogueTextWidget == null
			&& playerDialogueOptionsWidget == null)
		{
			inDialogue = false;
			manager.storeEvent(new StartEndData(false));
		}

		if (npcDialogueTextWidget != null && !npcDialogueTextWidget.getText().equals(lastNpcDialogueText))
		{
			lastNpcDialogueText = npcDialogueTextWidget.getText();
			String npcName = client.getWidget(WidgetInfo.DIALOG_NPC_NAME).getText();
			NpcDialogueData data = new NpcDialogueData(sanitize(lastNpcDialogueText), npcName);
			manager.storeEvent(data);
		}

		if (playerDialogueTextWidget != null && !playerDialogueTextWidget.getText().equals(lastPlayerDialogueText))
		{
			lastPlayerDialogueText = playerDialogueTextWidget.getText();
			PlayerDialogueData data = new PlayerDialogueData(sanitize(lastPlayerDialogueText));
			manager.storeEvent(data);
		}

		if (playerDialogueOptionsWidget != null && playerDialogueOptionsWidget.getChildren() != dialogueOptions)
		{
			dialogueOptions = playerDialogueOptionsWidget.getChildren();
			String[] optionsText = new String[dialogueOptions.length];
			for (int i = 0; i < dialogueOptions.length; i++)
			{
				optionsText[i] = sanitize(dialogueOptions[i].getText());
			}
			DialogueOptionsData data = new DialogueOptionsData(optionsText);
			manager.storeEvent(data);
		}
	}
}
