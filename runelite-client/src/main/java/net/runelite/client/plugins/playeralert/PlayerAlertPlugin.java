package net.runelite.client.plugins.playeralert;

import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "Player Alert",
        description = "Alerts you when players show up!"
)

public class PlayerAlertPlugin extends Plugin {


    @Inject
    private Client client;

    @Inject
    private PlayerAlertConfig config;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Provides
    PlayerAlertConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PlayerAlertConfig.class);
    }


    @Subscribe
    public void onPlayerSpawned(PlayerSpawned playerSpawned)
    {
        Player spawned = playerSpawned.getPlayer();
        if(!config.alertClan()){
            if(spawned.isClanMember())
                return;
        }
        if(!config.alertFriends()){
            if(spawned.isFriend())
                return;
        }
        String smite;
        if(client.getVar(Varbits.IN_WILDERNESS) == 1){
            Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
            if (wildernessLevelWidget == null)
            {
                return;
            }
            if(client.getLocalPlayer() == spawned){
                return;
            }

            if (config.doArrow()){
                WorldPoint hint = new WorldPoint(spawned.getWorldLocation().getX(),spawned.getWorldLocation().getY(),spawned.getWorldLocation().getPlane());

                    client.setHintArrow(hint);
            }
            String wildernessLevelText = wildernessLevelWidget.getText();
            int wildyLevel = Integer.parseInt(wildernessLevelText.substring(7));
            int localLevel = client.getLocalPlayer().getCombatLevel();
            int upperLevel = localLevel + wildyLevel;
            int lowerLevel = localLevel - wildyLevel;
            int spawnedLevel = spawned.getCombatLevel();
            if(spawnedLevel <= upperLevel && spawnedLevel >= lowerLevel ){
                //send message that they can attack, some sort of alert

                int distance = client.getLocalPlayer().getLocalLocation().distanceTo(spawned.getLocalLocation());

                if(config.doBeep()){
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }

                String chatMessage = new ChatMessageBuilder()
                        .append(spawned.getName() + " ("+spawnedLevel+") - " + distance/128 + " tiles away! ")
                        .build();

                chatMessageManager.queue(QueuedMessage.builder()
                        .sender("Alert")
                        .name("Alert")
                        .type(ChatMessageType.PUBLIC_MOD)
                        .runeLiteFormattedMessage(chatMessage)
                        .build());

            }
            //System.out.println(spawned.getName() + " - Lvl:" + spawned.getCombatLevel() + "You're in :"+wildyLevel);
        }




    }
}
