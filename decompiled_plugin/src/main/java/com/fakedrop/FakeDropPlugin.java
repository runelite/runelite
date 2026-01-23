package com.fakedrop;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.WidgetModalMode;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ColorUtil;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@PluginDescriptor(
        name = "Fake Drop",
        description = "Simulate boss kills, drops, and pet drops with realistic messages",
        tags = {"fake", "drop", "boss", "pet", "simulator"}
)
public class FakeDropPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private FakeDropConfig config;

    @Inject
    private KeyManager keyManager;
    
    @Inject
    private ConfigManager configManager;
    
    private static final String CONFIG_GROUP = "fakedrop";
    private static final String KC_KEY = "killCount";
    private static final String IS_PET_KEY = "isPet";
    private static final double VALUE_RANDOMIZATION_FACTOR = 0.05; // ±5%

    @Provides
    FakeDropConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(FakeDropConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        keyManager.registerKeyListener(toggle);
        keyManager.registerKeyListener(quickSwitch);
    }

    @Override
    protected void shutDown() throws Exception
    {
        keyManager.unregisterKeyListener(toggle);
        keyManager.unregisterKeyListener(quickSwitch);
    }

    private final HotkeyListener toggle = new HotkeyListener(() -> config.toggle())
    {
        @Override
        public void hotkeyPressed()
        {
            toggle();
        }
    };
    
    private final HotkeyListener quickSwitch = new HotkeyListener(() -> config.quickSwitchMode())
    {
        @Override
        public void hotkeyPressed()
        {
            quickSwitchMode();
        }
    };

    public void toggle()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        // Handle pet drops - completely different flow
        if (config.isPet())
        {
            // Only show the pet message
            String petMsg = "<col=ff0000>You have a funny feeling like you're being followed.</col>";
            sendMsg(petMsg);
        }
        else
        {
            // Auto-increment kill count if enabled
            int currentKC = config.killCount();
            if (config.autoIncrementKC())
            {
                int newKC = currentKC + 1;
                configManager.setConfiguration(CONFIG_GROUP, KC_KEY, newKC);
                currentKC = newKC;
            }
            
            // Regular boss kill messages
            String killCountMsg = "Your " + config.bossName() +
                    " kill count is: <col=ff0000>" +
                    formatNumber(currentKC) +
                    "</col>.";
            sendMsg(killCountMsg);

            if (config.timed())
            {
                String timeMsg = "Fight duration: <col=ff0000>" +
                        config.killTime() +
                        "</col>. Personal best: <col=ff0000>" +
                        config.personalBest() +
                        "</col>";
                sendMsg(timeMsg);
            }

            // Calculate drop value with optional randomization
            int dropValue = config.dropValue();
            if (config.randomizeValue() && !config.untradeable())
            {
                int randomization = (int) (dropValue * VALUE_RANDOMIZATION_FACTOR);
                int adjustment = (int) (Math.random() * (2 * randomization + 1)) - randomization;
                dropValue += adjustment;
            }
            
            // Regular drop message
            String dropMsg;
            if (config.untradeable())
            {
                dropMsg = "<col=ef1020>Untradeable drop: " +
                        config.dropName() +
                        "</col>";
            }
            else
            {
                dropMsg = "<col=ef1020>Valuable drop: " +
                        config.dropName() +
                        " (" +
                        formatNumber(dropValue) +
                        " coins)</col>";
            }
            sendMsg(dropMsg);
        }

        // Send collection log messages if enabled
        if (config.collectionLog())
        {
            String itemName;
            if (config.isPet())
            {
                FakeDropConfig.Pet pet = config.selectedPet();
                itemName = pet == FakeDropConfig.Pet.CUSTOM ? config.customPetName() : pet.getPetName();
            }
            else
            {
                itemName = config.dropName();
            }
            
            sendMsg("New item added to your collection log: <col=ef1020>" + 
                    itemName + "</col>");
            
            // Show collection log popup if enabled
            if (config.showCollectionLogPopup())
            {
                showCollectionLogPopup();
            }
        }

        // Announce to clan chat if enabled
        if (config.announceToClan())
        {
            announceToClanChat();
        }
    }

    private void announceToClanChat()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }
        
        String playerName = client.getLocalPlayer() != null ? 
                client.getLocalPlayer().getName() : "Player";

        // Get current time for timestamp
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String timestamp = timeFormat.format(new Date());

        // Build the clan announcement message
        StringBuilder announcement = new StringBuilder();
        
        // Add timestamp
        announcement.append("[")
                .append(timestamp)
                .append("] ");
        
        // Add clan name with color
        String clanNameColored = ColorUtil.wrapWithColorTag(
                "[" + config.clanName() + "]",
                config.clanColor()
        );
        announcement.append(clanNameColored).append(" ");
        
        // Add ironman icon if configured
        String ironIcon = config.ironmanType().getIcon();
        if (!ironIcon.isEmpty())
        {
            announcement.append(ironIcon).append(" ");
        }
        
        // Handle pet vs regular drop messaging
        if (config.isPet())
        {
            FakeDropConfig.Pet pet = config.selectedPet();
            String petName = pet == FakeDropConfig.Pet.CUSTOM ? config.customPetName() : pet.getPetName();
            
            if (pet.isSkilling())
            {
                // Skilling pet - show XP, not KC
                announcement.append(playerName)
                        .append(" received a skilling pet: ")
                        .append(petName)
                        .append(" (")
                        .append(formatNumber(config.petKillCountOrXP()))
                        .append(" ")
                        .append(pet.getSkill())
                        .append(" XP)");
            }
            else
            {
                // Boss pet - show KC
                String rarity = pet == FakeDropConfig.Pet.CUSTOM ? "Custom" : pet.getDefaultRarity();
                announcement.append(playerName)
                        .append(" received a pet: ")
                        .append(petName)
                        .append(" at ")
                        .append(formatNumber(config.petKillCountOrXP()))
                        .append(" KC (")
                        .append(rarity)
                        .append(")");
            }
        }
        else
        {
            announcement.append(playerName)
                    .append(" received a drop: ")
                    .append(config.dropName());
            
            // Add value for tradeable items
            if (!config.untradeable())
            {
                announcement.append(" (")
                        .append(formatNumber(config.dropValue()))
                        .append(" coins)");
            }
        }


        // Send to clan chat
        String message = announcement.toString();
        sendClanMessage(message);
        
        // Send collection log message if enabled
        if (config.collectionLog())
        {
            StringBuilder collectionMsg = new StringBuilder();
            
            // Add timestamp
            collectionMsg.append("[")
                    .append(timestamp)
                    .append("] ");
            
            // Add clan name with color (reuse the colored clan name)
            collectionMsg.append(clanNameColored).append(" ");
            
            // Add ironman icon if configured
            if (!ironIcon.isEmpty())
            {
                collectionMsg.append(ironIcon).append(" ");
            }
            
            String itemName;
            if (config.isPet())
            {
                FakeDropConfig.Pet pet = config.selectedPet();
                itemName = pet == FakeDropConfig.Pet.CUSTOM ? config.customPetName() : pet.getPetName();
            }
            else
            {
                itemName = config.dropName();
            }
            
            collectionMsg.append(playerName)
                    .append(" received a new collection log item: ")
                    .append(itemName)
                    .append(" (")
                    .append(config.collectionLogCount())
                    .append(")");
            
            String finalMsg = collectionMsg.toString();
            
            // Small delay before sending the second message
            clientThread.invokeLater(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Ignore
                }
                sendClanMessage(finalMsg);
            });
        }
    }

    private void sendClanMessage(String message)
    {
        clientThread.invokeLater(() ->
        {
            if (client.getGameState() == GameState.LOGGED_IN)
            {
                // Add fake clan system message to local chatbox (like drop broadcasts)
                client.addChatMessage(
                    ChatMessageType.CLAN_MESSAGE,
                    "",
                    message,
                    ""
                );
            }
        });
    }

    public void sendMsg(String msg)
    {
        clientThread.invokeLater(() ->
                client.addChatMessage(ChatMessageType.GAMEMESSAGE,
                        "",
                        msg,
                        null)
        );
    }

    private String formatTicksToTime(long ticks)
    {
        long totalMillis = ticks * 600;

        long minutes = totalMillis / 60000;
        long seconds = (totalMillis % 60000) / 1000;
        long millis = totalMillis % 1000;

        return String.format("%d:%02d.%03d", minutes, seconds, millis);
    }

    private String formatNumber(long value)
    {
        return NumberFormat.getInstance(Locale.US).format(value);
    }

    private void showCollectionLogPopup()
    {
        clientThread.invokeLater(() ->
        {
            try
            {
                // Define layout component IDs
                int RESIZABLE_CLASSIC_LAYOUT = (161 << 16) | 13;
                int RESIZABLE_MODERN_LAYOUT = (164 << 16) | 13;
                int FIXED_CLASSIC_LAYOUT = 35913770;

                // Determine which layout to use based on client state
                int componentId = client.isResized() 
                    ? client.getVarbitValue(Varbits.SIDE_PANELS) == 1 
                        ? RESIZABLE_MODERN_LAYOUT 
                        : RESIZABLE_CLASSIC_LAYOUT 
                    : FIXED_CLASSIC_LAYOUT;
                
                // Open the popup interface
                client.openInterface(componentId, 660, WidgetModalMode.MODAL_CLICKTHROUGH);

                // Run the script to display the collection log notification
                // Script 3343 takes: title, message, and icon ID (-1 for default)
                String itemName;
                if (config.isPet())
                {
                    FakeDropConfig.Pet pet = config.selectedPet();
                    itemName = pet == FakeDropConfig.Pet.CUSTOM ? config.customPetName() : pet.getPetName();
                }
                else
                {
                    itemName = config.dropName();
                }
                
                String message = "New item:<br><br><col=ffffff>" + itemName + "</col>";
                client.runScript(3343, "Collection Log", message, -1);
            }
            catch (Exception e)
            {
                log.error("Failed to show collection log popup", e);
            }
        });
    }
    
    /**
     * Quick switch between pet and boss mode
     */
    private void quickSwitchMode()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }
        
        boolean currentMode = config.isPet();
        boolean newMode = !currentMode;
        
        configManager.setConfiguration(CONFIG_GROUP, IS_PET_KEY, newMode);
        
        String modeText = newMode ? "Pet Drop" : "Boss Drop";
        
        // Show feedback message to user
        sendMsg("<col=00ff00>Switched to " + modeText + " mode</col>");
    }
}
