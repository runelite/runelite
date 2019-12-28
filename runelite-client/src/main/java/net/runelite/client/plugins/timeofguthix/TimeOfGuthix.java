package net.runelite.client.plugins.timeofguthix;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.chat.ChatClient;

import javax.inject.Inject;
import java.io.IOException;

@Slf4j
@PluginDescriptor(
        name = "Time of Guthix",
        description = "Shows time left in the Tears of Guthix minigame"
)
public class TimeOfGuthix extends Plugin {


    @Inject
    private ChatClient chatClient = new ChatClient();

    @Inject
    private TimeOfGuthixTimer timeOfGuthixTimer;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    public TimeOfGuthixOverlay timeOfGuthixOverlay;

    @Override
    public void startUp() {
        overlayManager.add(timeOfGuthixOverlay);
        timeOfGuthixTimer = new TimeOfGuthixTimer();
    }

    @Override
    public void shutDown() {
        overlayManager.remove(timeOfGuthixOverlay);
        timeOfGuthixTimer = null;
    }

    int getQp() {
        try {
            int qp = client.getVar(VarPlayer.QUEST_POINTS);
            chatClient.submitQp(client.getLocalPlayer().getName(), qp);
            return chatClient.getQp(client.getLocalPlayer().getName());
        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }



}
