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

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

public class CrowdsourcingDialogue
{
	private static final String USERNAME_TOKEN = "%USERNAME%";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private CrowdsourcingManager manager;


	private String sanitize(String dialogue)
	{
		String username = client.getLocalPlayer().getName();
		return dialogue.replaceAll(username, USERNAME_TOKEN);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.DIALOG_OPTION_GROUP_ID)
		{
			clientThread.invokeLater(this::handlePlayerDialogueOptions);
		} else if (event.getGroupId() == WidgetInfo.DIALOG_NPC_TEXT.getGroupId())
		{
			clientThread.invokeLater(this::handleNpcDialogue);
		} else if (event.getGroupId() == WidgetID.DIALOG_PLAYER_GROUP_ID)
		{
			clientThread.invokeLater(this::handlePlayerDialogue);
		}
	}

	private void handlePlayerDialogueOptions()
	{
		Widget playerDialogueOptionsWidget = client.getWidget(WidgetID.DIALOG_OPTION_GROUP_ID, 1);
		Widget[] dialogueOptions = playerDialogueOptionsWidget.getChildren();
		List<String> options = new ArrayList<>();
		for (Widget dialogueOption : dialogueOptions)
		{
			String text = dialogueOption.getText();
			if (!text.isEmpty())
			{
				options.add(sanitize(text));
			}
		}
		DialogueOptionsData data = new DialogueOptionsData(options.toArray(new String[0]));
		manager.storeEvent(data);
	}

	private void handleNpcDialogue()
	{
		Widget npcDialogueTextWidget = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		String npcDialogueText = npcDialogueTextWidget.getText();
		String npcName = client.getWidget(WidgetInfo.DIALOG_NPC_NAME).getText();
		NpcDialogueData data = new NpcDialogueData(sanitize(npcDialogueText), npcName);
		manager.storeEvent(data);
	}

	private void handlePlayerDialogue()
	{
		Widget playerDialogueTextWidget = client.getWidget(WidgetID.DIALOG_PLAYER_GROUP_ID, 4);
		String playerDialogueText = playerDialogueTextWidget.getText();
		PlayerDialogueData data = new PlayerDialogueData(sanitize(playerDialogueText));
		manager.storeEvent(data);
	}

}
