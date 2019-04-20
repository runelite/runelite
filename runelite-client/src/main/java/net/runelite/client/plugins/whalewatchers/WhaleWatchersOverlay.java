package net.runelite.client.plugins.whalewatchers;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.*;
import javax.inject.*;
import net.runelite.client.ui.overlay.components.*;
import java.awt.*;

public class WhaleWatchersOverlay extends Overlay
{
    private Client client;
    private final WhaleWatchersConfig config;
    private WhaleWatchersPlugin plugin;
    private PanelComponent panelComponent;
    private String lastOpponent;
    
    @Inject
    public WhaleWatchersOverlay(final WhaleWatchersConfig config, final Client client, final WhaleWatchersPlugin plugin) {
        this.lastOpponent = "-";
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
        if (this.plugin.inCombat && this.config.showDamageCounter()) {
            this.panelComponent.setBackgroundColor(this.config.damageBackgroundColor());
            final String opp = (this.client.getLocalPlayer().getInteracting() != null) ? this.client.getLocalPlayer().getInteracting().getName() : this.lastOpponent;
            if (this.client.getLocalPlayer().getInteracting() != null) {
                this.lastOpponent = this.client.getLocalPlayer().getInteracting().getName();
            }
            final String opponent = "Fight vs " + opp;
            final String damageTaken = "Damage Taken: " + this.plugin.damageTaken;
            final String damageDealt = "Damage Dealt: " + this.plugin.damageDone;
            this.panelComponent.getChildren().add(TitleComponent.builder().text(opponent).color(Color.BLACK).build());
            this.panelComponent.getChildren().add(TitleComponent.builder().text(damageDealt).color(Color.BLACK).build());
            this.panelComponent.getChildren().add(TitleComponent.builder().text(damageTaken).color(Color.BLACK).build());
            this.panelComponent.setPreferredSize(new Dimension(graphics.getFontMetrics().stringWidth(damageDealt) + graphics.getFontMetrics().stringWidth(opponent) + 10, 0));
        }
        else {
            this.panelComponent.getChildren().clear();
        }
        return this.panelComponent.render(graphics);
    }
}
