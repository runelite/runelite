package net.runelite.client.plugins.nexthitnotifier;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.MiscUtils;

import javax.inject.Inject;
import java.awt.*;

public class NextHitNotifierOverlay extends Overlay
{
    private final Client client;
    private final NextHitNotifierPlugin plugin;
    private final NextHitNotifierConfig config;

    private final PanelComponent panelComponent = new PanelComponent();
    private final Dimension panelSize = new Dimension(48, 0);

    @Inject
    private NextHitNotifierOverlay(Client client, NextHitNotifierPlugin plugin, NextHitNotifierConfig config)
    {
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPosition(OverlayPosition.DYNAMIC);
        setPosition(OverlayPosition.DETACHED);

        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        panelComponent.setPreferredSize(panelSize);

        String lastHitText = Integer.toString(plugin.lastHit);
        int lastHit = plugin.lastHit;

        if (plugin.showTime < 0)
        {
            lastHitText = "0";
            lastHit = 0;
        }
        
        int g = (int)MiscUtils.clamp((float)Math.floor(lastHit / 30.f) * 255.f, 0.f, 255.f);
        int r = 255 - g;

        Color textColor = Color.getHSBColor(Color.RGBtoHSB(r, g, 0, null)[0], 1.f, 1.f);

        panelComponent.getChildren().add(TitleComponent.builder().text("Next hit:").color(Color.YELLOW).build());
        panelComponent.getChildren().add(TitleComponent.builder().text(lastHitText).color(textColor).build());

        return panelComponent.render(graphics);
    }
}