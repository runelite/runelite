package net.runelite.client.plugins.kittennotifier;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.NPC;
import net.runelite.api.Client;
import javax.inject.Inject;

@PluginDescriptor(
        name = "Kitten Notifier",
        description = "Sends a notification when your kitten needs food, attention, or is grown.",
        tags = {"kitten, notifications"},
        type = "utility"
)
public class KittenNotifierPlugin extends Plugin{
    @Inject
    private Notifier notifier;
    @Inject
    private KittenNotifierConfig config;
    @Inject
    private Client client;
    @Provides
    KittenNotifierConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(KittenNotifierConfig.class);
    }
    @Subscribe
    public void onChatMessage(ChatMessage event) {
        if (event.getType() == ChatMessageType.ENGINE && !config.catOwned()) {
            if (!config.absolutelyNeeded()) {
                if (event.getMessage().contentEquals("<col=ef1020>Your kitten is hungry.</col>")) {
                    notifier.notify("Your kitten is hungry.");
                }
                if (event.getMessage().contentEquals("<col=ef1020>Your kitten wants attention.</col>")) {
                    notifier.notify("Your kitten wants attention.");
                }
            }
            if (event.getMessage().contentEquals("<col=ef1020>Your kitten is very hungry.</col>")) {
                notifier.notify("Your kitten is very hungry.");
            }
            if (event.getMessage().contentEquals("<col=ef1020>Your kitten really wants attention.</col>")) {
                notifier.notify("Your kitten really wants attention.");
            }
        }
    }
    @Subscribe
    public void onNpcActionChanged(NpcActionChanged event) {
        if (!config.catOwned()) {
            for (NPC npc : client.getNpcs()) {
                if (npc.getInteracting() != null) {
                    if (npc.getName().equals("Cat") && !config.catOwned()) {
                        // If this if statement is included in previous it could null.
                        if (npc.getInteracting().getName().contentEquals(client.getLocalPlayer().getName())) {
                            config.catOwned(true);
                            notifier.notify("Your kitten has grown into a cat.");
                        }
                    }
                }
            }
        }
    }
    @Subscribe
    public void onNpcSpawned(NpcSpawned event) {
        NPC cat = event.getNpc();
        if (cat.getName() != null) {
            if (cat.getName().equalsIgnoreCase("Kitten")) {
                if (cat.getInteracting().getName().contentEquals(client.getLocalPlayer().getName())) {
                    config.catOwned(false);
                }
            }
            else if (cat.getName().contentEquals("Cat")) {
                if (cat.getInteracting().getName().equalsIgnoreCase(client.getLocalPlayer().getName())) {
                    config.catOwned(true);
                }
            }
        }
    }
}
