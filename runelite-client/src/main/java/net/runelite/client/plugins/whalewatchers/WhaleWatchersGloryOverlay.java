package net.runelite.client.plugins.whalewatchers;

import net.runelite.api.*;
import javax.inject.*;
import net.runelite.client.ui.overlay.*;
import net.runelite.api.kit.*;
import java.awt.*;
import net.runelite.client.ui.overlay.components.*;
import java.awt.image.*;
import net.runelite.client.game.*;

public class WhaleWatchersGloryOverlay extends Overlay
{
    private Client client;
    private final WhaleWatchersConfig config;
    private WhaleWatchersPlugin plugin;
    private PanelComponent panelComponent;
    @Inject
    private ItemManager itemManager;
    
    @Inject
    public WhaleWatchersGloryOverlay(final WhaleWatchersConfig config, final Client client, final WhaleWatchersPlugin plugin) {
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        this.setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.setPriority(OverlayPriority.HIGH);
        this.setPosition(OverlayPosition.DETACHED);
        this.panelComponent = new PanelComponent();
    }
    
    @Override
    public Dimension render(final Graphics2D graphics) {
        this.panelComponent.getChildren().clear();
        int amuletID = 0;
        try {
            amuletID = this.client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.AMULET);
        }
        catch (NullPointerException ex) {}
        if (this.config.gloryWarning() && amuletID == 1704) {
            this.panelComponent.setBackgroundColor(Color.lightGray);
            final AsyncBufferedImage gloryImage = this.itemManager.getImage(1704);
            this.panelComponent.getChildren().add(TitleComponent.builder().text("Uncharged Glory").color(Color.BLACK).build());
            this.panelComponent.getChildren().add(new ImageComponent(gloryImage));
        }
        return this.panelComponent.render(graphics);
    }
}
