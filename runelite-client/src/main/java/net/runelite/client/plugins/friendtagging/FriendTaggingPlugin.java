package net.runelite.client.plugins.friendtagging;

import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.inject.Inject;
import lombok.NonNull;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Nameable;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.RemovedFriend;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
    name="Friend Tagging", 
    description="Tag people on your friends list."
    )

public class FriendTaggingPlugin extends Plugin 
{
    private static final Logger log = LoggerFactory.getLogger(FriendTaggingPlugin.class);
    public static ConcurrentHashMap<String, String> taggedFriends = new ConcurrentHashMap();
    private static final String CONFIG_GROUP = "friendtagging";
    private static final int CHARACTER_LIMIT = 30;
    private static final String KEY_PREFIX = "tag_";
    private static final String ADD_TAG = "Add Tag";
    private static final String DELETE_TAG = "Delete Tag";
    @Inject
    private Client client;
    @Inject
    private ConfigManager configManager;
    @Inject
    private ChatboxPanelManager chatboxPanelManager;

    @Override
    protected void startUp() throws Exception {
        this.loadFriendTags();
    }

    @Override
    protected void shutDown() throws Exception {
        super.shutDown();
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event) {
        int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());
        if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() && event.getOption().equals("Message")) {
            String friendName = Text.removeTags(event.getTarget());
            MenuEntry entry = new MenuEntry();
            entry.setOption(friendName == null || this.getTag(friendName) == null ? ADD_TAG : DELETE_TAG);
            entry.setType(MenuAction.RUNELITE.getId());
            entry.setTarget(event.getTarget());
            entry.setParam0(event.getActionParam0());
            entry.setParam1(event.getActionParam1());
            MenuEntry[] menuEntries = ObjectArrays.concat(this.client.getMenuEntries(), entry);
            this.client.setMenuEntries(menuEntries);
        }
    }

    @Subscribe
    public void onRemovedFriend(RemovedFriend event) {
        String displayName = event.getName().trim().toLowerCase();
        this.deleteTag(displayName);
    }

    @Subscribe
    public void onNameableNameChanged(NameableNameChanged event) {
        Friend friend;
        Nameable nameable = event.getNameable();
        if (nameable instanceof Friend && (friend = (Friend)nameable).getName() != null && friend.getPrevName() != null) {
            this.migrateFriendTag(friend.getName(), friend.getPrevName());
        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        if (WidgetInfo.TO_GROUP(event.getWidgetId()) == WidgetInfo.FRIENDS_LIST.getGroupId()) {
            if (Strings.isNullOrEmpty(event.getMenuTarget())) {
                return;
            }
            String sanitizedTarget = Text.removeTags(event.getMenuTarget());
            if (event.getMenuOption().equals(ADD_TAG)) {
                event.consume();
                ChatboxTextInput chatboxTextInput = this.chatboxPanelManager.openTextInput("Enter the tag").value("").onDone(content -> {
                    if (content == null) {
                        return;
                    }
                    content = Text.removeTags(content).trim();
                    this.setTag(sanitizedTarget, (String)content);
                }).build();
            }
            if (event.getMenuOption().equals(DELETE_TAG)) {
                event.consume();
                this.client.getLogger().info(sanitizedTarget);
                taggedFriends.forEach((k, v) -> this.client.getLogger().info(k + ": ", v));
                this.deleteTag(sanitizedTarget);
            }
        }
    }

    @NonNull
    private String getTag(String name) {
        name = name.trim().toLowerCase();
        String keyName = KEY_PREFIX + name;
        return taggedFriends.get(keyName);
    }

    private void setTag(String name, String tag) {
        this.client.getLogger().info("SETTING " + name + ": " + tag);
        name = name.trim().toLowerCase();
        String keyName = KEY_PREFIX + name;
        if (tag.length() <= 30) {
            taggedFriends.put(keyName, tag);
            this.configManager.setConfiguration(CONFIG_GROUP, keyName, tag);
        }
    }

    private void deleteTag(String name) {
        name = name.trim().toLowerCase();
        String keyName = KEY_PREFIX + name;
        this.configManager.unsetConfiguration(CONFIG_GROUP, keyName);
        taggedFriends.remove(keyName);
    }

    private void loadFriendTags() {
        String prefix = "friendtagging.tag_";
        for (String key : this.configManager.getConfigurationKeys(prefix)) {
            String result = this.configManager.getConfiguration(CONFIG_GROUP, key = key.replace("friendtagging.", ""));
            if (!Objects.nonNull(result) || result.equals("")) continue;
            taggedFriends.put(key, this.configManager.getConfiguration(CONFIG_GROUP, key));
        }
    }

    private void migrateFriendTag(String currentDisplayName, String prevDisplayName) {
        String prevTag;
        String currentTag = this.getTag(currentDisplayName);
        if (currentTag == null && (prevTag = this.getTag(prevDisplayName)) != null) {
            this.setTag(prevDisplayName, "");
            this.setTag(currentDisplayName, prevTag);
        }
    }
}

