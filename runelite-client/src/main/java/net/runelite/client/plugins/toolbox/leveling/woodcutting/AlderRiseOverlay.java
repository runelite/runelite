package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import lombok.extern.slf4j.Slf4j;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.config.ConfigManager;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class AlderRiseOverlay extends OverlayPanel {

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    AlderRiseOverlay(AlderRisePlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        return super.render(graphics);
    }

    @Provides
    AlderRiseConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AlderRiseConfig.class);
    }
}