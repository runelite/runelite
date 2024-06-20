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
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

@Slf4j
public class CrowdsourcingDialogue
{
	private static final String USERNAME_TOKEN = "%USERNAME%";
	private static final String NON_BREAKING_SPACE = " ";

	@Inject
	private Client client;

	@Inject
	private CrowdsourcingManager manager;

	private boolean inDialogue = false;
	private String lastDialogueText = null;
	private int lastItemId1 = -1;
	private int lastItemId2 = -1;
	private Widget[] dialogueOptions;

	private String sanitize(String dialogue)
	{
		String username = client.getLocalPlayer().getName();

		if (username == null)
		{
			log.debug("Received null player name.  Skipping dialogue sanitization and returning null instead.");
			return null;
		}

		return dialogue.replaceAll(NON_BREAKING_SPACE, " ").replaceAll(username, USERNAME_TOKEN);
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget npcDialogueTextWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
		Widget playerDialogueTextWidget = client.getWidget(ComponentID.DIALOG_PLAYER_TEXT);
		Widget playerDialogueOptionsWidget = client.getWidget(ComponentID.DIALOG_OPTION_OPTIONS);
		Widget spriteWidget = client.getWidget(ComponentID.DIALOG_SPRITE_SPRITE);
		Widget spriteTextWidget = client.getWidget(ComponentID.DIALOG_SPRITE_TEXT);
		Widget doubleSpriteTextWidget = client.getWidget(ComponentID.DIALOG_DOUBLE_SPRITE_TEXT);
		Widget doubleSprite1Widget = client.getWidget(ComponentID.DIALOG_DOUBLE_SPRITE_SPRITE1);
		Widget doubleSprite2Widget = client.getWidget(ComponentID.DIALOG_DOUBLE_SPRITE_SPRITE2);

		// If we were not in a conversation, but now one of these widgets is not null, we have started a conversation.
		// Else if we were in a conversation, but now there is no widget, we have left the conversation.
		if (!inDialogue && (npcDialogueTextWidget != null || playerDialogueTextWidget != null || playerDialogueOptionsWidget != null || spriteTextWidget != null || doubleSpriteTextWidget != null))
		{
			inDialogue = true;
			manager.storeEvent(new StartEndData(true));
		}
		else if (inDialogue && npcDialogueTextWidget == null && playerDialogueTextWidget == null && playerDialogueOptionsWidget == null && spriteTextWidget == null && doubleSpriteTextWidget == null)
		{
			inDialogue = false;
			manager.storeEvent(new StartEndData(false));
			lastDialogueText = null;
		}

		if (npcDialogueTextWidget != null && !npcDialogueTextWidget.getText().equals(lastDialogueText))
		{
			lastDialogueText = npcDialogueTextWidget.getText();
			String npcName = client.getWidget(ComponentID.DIALOG_NPC_NAME).getText();
			String sanitizedLastDialogueText = sanitize(lastDialogueText);
			if (sanitizedLastDialogueText != null)
			{
				NpcDialogueData data = new NpcDialogueData(sanitizedLastDialogueText, npcName);
				manager.storeEvent(data);
			}
		}

		if (playerDialogueTextWidget != null && !playerDialogueTextWidget.getText().equals(lastDialogueText))
		{
			lastDialogueText = playerDialogueTextWidget.getText();
			String sanitizedLastDialogueText = sanitize(lastDialogueText);
			if (sanitizedLastDialogueText != null)
			{
				PlayerDialogueData data = new PlayerDialogueData(sanitizedLastDialogueText);
				manager.storeEvent(data);
			}
		}

		if (playerDialogueOptionsWidget != null && playerDialogueOptionsWidget.getChildren() != dialogueOptions)
		{
			lastDialogueText = null;
			dialogueOptions = playerDialogueOptionsWidget.getChildren();
			ArrayList<String> optionsText = new ArrayList<>();
			for (Widget dialogueOption : dialogueOptions)
			{
				String sanitizedDialogueOptionText = sanitize(dialogueOption.getText());
				if (sanitizedDialogueOptionText != null)
				{
					optionsText.add(sanitizedDialogueOptionText);
				}
			}
			DialogueOptionsData data = new DialogueOptionsData(optionsText.toArray(String[]::new));
			manager.storeEvent(data);
		}

		if (spriteWidget != null && spriteTextWidget != null && (!spriteTextWidget.getText().equals(lastDialogueText) || spriteWidget.getItemId() != lastItemId1))
		{
			lastItemId1 = spriteWidget.getItemId();
			lastDialogueText = spriteTextWidget.getText();
			String sanitizedLastDialogueText = sanitize(lastDialogueText);
			if (sanitizedLastDialogueText != null)
			{
				SpriteTextData data = new SpriteTextData(sanitizedLastDialogueText, lastItemId1);
				manager.storeEvent(data);
			}
		}

		if (doubleSprite1Widget != null && doubleSpriteTextWidget != null && (!doubleSpriteTextWidget.getText().equals(lastDialogueText) || doubleSprite1Widget.getItemId() != lastItemId1 || doubleSprite2Widget.getItemId() != lastItemId2))
		{
			lastItemId1 = doubleSprite1Widget.getItemId();
			lastItemId2 = doubleSprite2Widget.getItemId();
			lastDialogueText = doubleSpriteTextWidget.getText();
			String sanitizedLastDialogueText = sanitize(lastDialogueText);
			if (sanitizedLastDialogueText != null)
			{
				DoubleSpriteTextData data = new DoubleSpriteTextData(sanitizedLastDialogueText, lastItemId1, lastItemId2);
				manager.storeEvent(data);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.DIALOG && chatMessage.getType() != ChatMessageType.MESBOX)
		{
			return;
		}
		String sanitizedChatMessageText = sanitize(chatMessage.getMessage());
		if (sanitizedChatMessageText == null)
		{
			return;
		}
		ChatMessageData data = new ChatMessageData(sanitizedChatMessageText, chatMessage.getType());
		manager.storeEvent(data);
	}
}
