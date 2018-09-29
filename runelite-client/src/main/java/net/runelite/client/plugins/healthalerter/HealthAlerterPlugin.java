package net.runelite.client.plugins.healthalerter;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Health Alerter",
        description = "Alerts you when your health gets too low",
        tags = {"player", "health", "hp", "hitpoints"},
        enabledByDefault = false
)
public class HealthAlerterPlugin extends Plugin {

    static final String CONFIG_GROUP = "healthAlerter";

    @Inject
    private Client client;

    @Inject
    private HealthAlerterConfig config;

    @Inject
    private Notifier notifier;

    @Provides
    HealthAlerterConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(HealthAlerterConfig.class);
    }

    @Subscribe
    public void onHitsplatApplied(HitsplatApplied event) {
        if (event.getActor().getName().equals(client.getLocalPlayer().getName())) {
            client.getLogger().warn("[" + client.getLocalPlayer().getName() + "] is getting hit!");
            if (client.getLocalPlayer().getHealth() <= config.healthAlert()) {
                client.getLogger().warn("Notifying about getting hit!");
                notifier.notify("[" + client.getLocalPlayer().getName() + "] is getting low health!");
            }
        }
    }

}
