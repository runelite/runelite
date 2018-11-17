package net.runelite.client.plugins._joller;

import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;

import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.*;
import sun.reflect.generics.tree.Tree;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;

@PluginDescriptor(
        name = "Leet plugs",
        description = "Serious unfair advantage",
        tags = {"pk"},
        enabledByDefault = false
)
//@PluginDependency(XpTrackerPlugin.class)
@Slf4j

public class JollerPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private Notifier notifier;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private JollerOverlay overlay;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameTick(GameTick tick) {

    }

    @Subscribe
    public void onChatMessage(ChatMessage event) {
        if (event.getMessage().contains("Lol")) {
//            panelComponent.getChildren().clear();
//            panelComponent.getChildren().add(TitleComponent.builder()
//                    .text("Whats so funny?")
//                    .color(Color.GREEN)
//                    .build());
            overlay.setText("Lol");
        }
    }

    private void sendNotification(SetMessage message)
    {
        String name = Text.removeTags(message.getName());
        String sender = message.getSender();
        StringBuilder stringBuilder = new StringBuilder();

        if (!Strings.isNullOrEmpty(sender))
        {
            stringBuilder.append('[').append(sender).append("] ");
        }
        if (!Strings.isNullOrEmpty(name))
        {
            stringBuilder.append(name).append(": ");
        }
        stringBuilder.append(message.getValue());

        String notification = stringBuilder.toString();
        notifier.notify(notification);
    }


}
