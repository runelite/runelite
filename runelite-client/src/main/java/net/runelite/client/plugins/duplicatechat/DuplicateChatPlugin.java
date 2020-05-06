/*
 * Copyright (c) 2018, Magic fTail
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package net.runelite.client.plugins.duplicatechat;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@PluginDescriptor(
        name = "Duplicate Chat Filter",
        description = "Collapse duplicate game chats into a single message",
        enabledByDefault = false
)
@Slf4j
public class DuplicateChatPlugin extends Plugin
{

    private static final String COUNT_FORMAT = " (%d)";
    private Multiset<String> chatCounts;
    private Map<String, Integer> chatIndex;

    @Inject
    private Client client;

    @Inject
    private DuplicateChatConfig config;

    @Provides
    DuplicateChatConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(DuplicateChatConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        chatIndex = new HashMap<>();
        chatCounts = HashMultiset.create();
        client.refreshChat();
    }

    @Override
    protected void shutDown() throws Exception
    {
        client.refreshChat();
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage) {
        if (chatCounts.elementSet().size() > config.getMaxTrackedChats()) {
            cleanupChatTrackers();
        }
        if (shouldProcessMessageType(chatMessage.getType())){
            chatCounts.add(chatMessage.getName() + chatMessage.getMessage());
        }
        refreshChatIndex();
    }

    private void refreshChatIndex() {
        client.getMessages().forEach(messageNode ->{
            String fullMessage = messageNode.getName() + messageNode.getValue();
            Integer currentSetIndex = chatIndex.get(fullMessage);
            if (currentSetIndex == null ||
                    currentSetIndex < messageNode.getId()) {
                chatIndex.put(fullMessage, messageNode.getId());
            }
        });
    }

    @Subscribe
    public void onScriptCallbackEvent(ScriptCallbackEvent event)
    {
        if (!"chatFilterCheck".equals(event.getEventName()))
        {
            return;
        }

        int[] intStack = client.getIntStack();
        int intStackSize = client.getIntStackSize();
        int messageType = intStack[intStackSize - 2];
        int messageId = intStack[intStackSize - 1];

        ChatMessageType chatMessageType = ChatMessageType.of(messageType);

        // Only process game messages for duplicates
        if (!shouldProcessMessageType(chatMessageType)) {
            return;
        }
        String[] stringStack = client.getStringStack();
        int stringStackSize = client.getStringStackSize();
        String message = stringStack[stringStackSize - 1];
        MessageNode messageNode = client.getMessages().get(messageId);
        String fullMessage = messageNode.getName() + message;

        if (chatIndex.containsKey(fullMessage) &&
                chatIndex.get(fullMessage) != messageId ||
                shouldBlockPlayerChat(fullMessage, chatMessageType))
        {
            // Block the message
            intStack[intStackSize - 3] = 0;
        }
        else
        {
            // Replace the message
            String messageWithCount = addCountToGameMessage(message, chatCounts.count(fullMessage));
            stringStack[stringStackSize - 1] = messageWithCount;
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!"duplicatechat".equals(event.getGroup()))
        {
            return;
        }
        client.refreshChat();
    }

    private String addCountToGameMessage(String gameMessage, int count) {
        if (count > 1){
            return gameMessage +
                    ColorUtil.wrapWithColorTag(String.format(COUNT_FORMAT, count), config.getChatCountColor());
        } else {
            return gameMessage;
        }
    }

    private void cleanupChatTrackers() {
        log.info("Cleaning up chat counts. Current size: {}", chatCounts.elementSet().size());
        chatCounts.removeIf(message -> chatCounts.count(message) <= 1);
        log.info("After clearing messages with count == 1: {}", chatCounts.elementSet().size());
        if (chatCounts.elementSet().size() > config.getMaxTrackedChats()) {
            chatCounts.clear();
        }
        chatIndex.clear();
    }

    private boolean shouldBlockPlayerChat(String fullMessage, ChatMessageType chatMessageType) {
        return chatMessageType == ChatMessageType.PUBLICCHAT &&
                config.getMaxRepeatedPublicChats() > 1 &&
                chatCounts.count(fullMessage) > config.getMaxRepeatedPublicChats();
    }

    private boolean shouldProcessMessageType(ChatMessageType chatMessageType) {
        switch (chatMessageType){
            case ENGINE:
            case GAMEMESSAGE:
            case NPC_EXAMINE:
            case OBJECT_EXAMINE:
            case SPAM:
                return true;
            case PUBLICCHAT:
                return config.consolidatePlayerChat();
            default:
                return false;
        }
    }
}
