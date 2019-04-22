package net.runelite.client.plugins.equipmentinspector;


import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.Player;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.kit.KitType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

@PluginDescriptor(
        name = "Equipment Inspector",
        enabledByDefault = false,
        type = PluginType.PVP
)

@Slf4j

public class EquipmentInspectorPlugin extends Plugin {

    private static final String INSPECT_EQUIPMENT = "Gear";
    private static final String KICK_OPTION = "Kick";

    @Inject
    @Nullable
    private Client client;

    @Inject
    private ItemManager itemManager;

    @Inject
    private EquipmentInspectorConfig config;

    @Inject
    private ChatMessageManager chatMessageManager;
    @Inject
    private MenuManager menuManager;

    @Inject
    private ScheduledExecutorService executor;

    @Inject
    private ClientToolbar pluginToolbar;
    private NavigationButton navButton;
    private EquipmentInspectorPanel equipmentInspectorPanel;
    private int TotalPrice = 0;
    private int Prot1 = 0;
    private int Prot2 = 0;
    private int Prot3 = 0;
    private int Prot4 = 0;

    @Provides
    EquipmentInspectorConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EquipmentInspectorConfig.class);
    }

    @Override
    protected void startUp() throws Exception {

        equipmentInspectorPanel = injector.getInstance(EquipmentInspectorPanel.class);
        if (client != null) {
            menuManager.addPlayerMenuItem(INSPECT_EQUIPMENT);
        }

        //synchronized (ImageIO.class)
        //{
        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(this.getClass(), "normal.png");
        //}

        navButton = NavigationButton.builder()
                .tooltip("Equipment Inspector")
                .icon(icon)
                .priority(5)
                .panel(equipmentInspectorPanel)
                .build();


        pluginToolbar.addNavigation(navButton);

    }

    @Override
    protected void shutDown() throws Exception {

        menuManager.removePlayerMenuItem(INSPECT_EQUIPMENT);
    }

    @Subscribe
    public void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event) {
        if (event.getMenuOption().equals(INSPECT_EQUIPMENT)) {


            executor.execute(() ->
            {
                try {
                    SwingUtilities.invokeAndWait(() ->
                    {
                        if (!navButton.isSelected()) {
                            navButton.getOnSelect().run();
                        }
                    });
                } catch (InterruptedException | InvocationTargetException e) {

                    throw new RuntimeException(e);

                }
                String playerName = Text.removeTags(event.getMenuTarget());
                // The player menu uses a non-breaking space in the player name, we need to replace this to compare
                // against the playerName in the player cache.
                String finalPlayerName = playerName.replace('\u00A0', ' ');
                System.out.println(finalPlayerName);
                List<Player> players = client.getPlayers();
                Optional<Player> targetPlayer = players.stream()
                        .filter(Objects::nonNull)
                        .filter(p -> p.getName().equals(finalPlayerName)).findFirst();

                if (targetPlayer.isPresent()) {
                    TotalPrice = 0;
                    Prot1 = 0;
                    Prot2 = 0;
                    Prot3 = 0;
                    Prot4 = 0;
                    Player p = targetPlayer.get();
                    Map<KitType, ItemComposition> playerEquipment = new HashMap<>();

                    for (KitType kitType : KitType.values()) {
                        int itemId = p.getPlayerComposition().getEquipmentId(kitType);
                        if (itemId != -1) {
                            ItemComposition itemComposition = client.getItemDefinition(itemId);
                            playerEquipment.put(kitType, itemComposition);
                            int ItemPrice = itemManager.getItemPrice(itemId);
                            TotalPrice += ItemPrice;
                            if (ItemPrice > Prot1) {
                                Prot4 = Prot3;
                                Prot3 = Prot2;
                                Prot2 = Prot1;

                                Prot1 = ItemPrice;
                            } else if (ItemPrice > Prot2) {
                                Prot4 = Prot3;
                                Prot3 = Prot2;
                                Prot2 = ItemPrice;
                            } else if (ItemPrice > Prot3) {
                                Prot4 = Prot3;
                                Prot3 = ItemPrice;
                            } else if (ItemPrice > Prot4) {
                                Prot4 = ItemPrice;
                            }
                        }
                    }
                    int IgnoredItems = config.protecteditems();
                    if (IgnoredItems != 0 && IgnoredItems != 1 && IgnoredItems != 2 && IgnoredItems != 3) {
                        IgnoredItems = 4;

                    }
                    if (config.ShowValue()) {
                        switch (IgnoredItems) {
                            case 1:
                                TotalPrice = TotalPrice - Prot1;
                                break;
                            case 2:
                                TotalPrice = TotalPrice - Prot1;
                                TotalPrice = TotalPrice - Prot2;

                                break;
                            case 3:
                                TotalPrice = TotalPrice - Prot1;
                                TotalPrice = TotalPrice - Prot2;
                                TotalPrice = TotalPrice - Prot3;
                                break;
                            case 4:
                                TotalPrice = TotalPrice - Prot1;
                                TotalPrice = TotalPrice - Prot2;
                                TotalPrice = TotalPrice - Prot3;
                                TotalPrice = TotalPrice - Prot4;
                                break;
                        }
                        String StringPrice = "";
                        if (!config.ExactValue()) {
                            TotalPrice = TotalPrice / 1000;
                            StringPrice = NumberFormat.getIntegerInstance().format(TotalPrice);
                            StringPrice = StringPrice + 'K';
                        }
                        if (config.ExactValue()) {
                            StringPrice = NumberFormat.getIntegerInstance().format(TotalPrice);
                        }
                        chatMessageManager.queue(QueuedMessage.builder()
                                .type(ChatMessageType.FRIENDSCHATNOTIFICATION)
                                .runeLiteFormattedMessage(new ChatMessageBuilder()
                                        .append(ChatColorType.HIGHLIGHT)
                                        .append("Risked Value: ")
                                        .append(ChatColorType.NORMAL)
                                        .append(StringPrice)
                                        .build())
                                .build());
                    }
                    equipmentInspectorPanel.update(playerEquipment, playerName);

                }
            });
        }
    }
}
