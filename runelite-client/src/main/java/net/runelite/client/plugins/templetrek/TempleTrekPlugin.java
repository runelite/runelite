package net.runelite.client.plugins.templetrek;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.ObjectID;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
        name = "Temple Trekking",
        description = "Helpers for the Temple Trek minigame",
        tags = {"minigame", "overlay", "temple trek"}
)
public class TempleTrekPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private TempleTrekOverlay overlay;

    @Inject
    private TempleTrekConfig config;

    @Getter
    private final Set<GroundObject> bogList = new HashSet<GroundObject>();


    @Provides
    TempleTrekConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TempleTrekConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        bogList.clear();
    }

    @Subscribe
    public void onGroundObjectSpawned(GroundObjectSpawned event)
    {
        GroundObject obj = event.getGroundObject();
        if (obj.getId() == ObjectID.BOG) {
            bogList.add(obj);
        }
    }

    @Subscribe
    public void onGroundObjectDespawned(GroundObjectDespawned event)
    {
        GroundObject obj = event.getGroundObject();
        if (obj.getId() == ObjectID.BOG) {
            bogList.clear();
        }
    }

}
