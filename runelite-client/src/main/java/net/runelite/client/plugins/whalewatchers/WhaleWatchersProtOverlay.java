package net.runelite.client.plugins.whalewatchers;

import javax.inject.*;

import net.runelite.api.Point;
import net.runelite.client.ui.*;
import net.runelite.api.*;
import net.runelite.client.ui.overlay.*;
import java.awt.*;

public class WhaleWatchersProtOverlay extends Overlay
{
    private Client client;
    private final WhaleWatchersConfig config;
    private WhaleWatchersPlugin plugin;
    
    @Inject
    public WhaleWatchersProtOverlay(final WhaleWatchersConfig config, final Client client, final WhaleWatchersPlugin plugin) {
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        this.setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.setPriority(OverlayPriority.HIGH);
        this.setPosition(OverlayPosition.DYNAMIC);
    }
    
    @Override
    public Dimension render(final Graphics2D graphics) {
        if (this.plugin.enableOverlay && this.config.protectItemWarning()) {
            final Rectangle rectangle = new Rectangle();
            rectangle.setBounds(this.client.getCanvas().getBounds());
            rectangle.setLocation(this.client.getCanvas().getLocation());
            final Stroke oldStroke = graphics.getStroke();
            graphics.setStroke(new BasicStroke(10.0f));
            graphics.setColor(Color.RED);
            graphics.draw(rectangle);
            final Font font = FontManager.getRunescapeBoldFont().deriveFont(1, 72.0f);
            graphics.setFont(font);
            OverlayUtil.renderTextLocation(graphics, new Point((int)rectangle.getCenterX() - 50, font.getSize()), "Protect item prayer disabled!!!", Color.red);
            graphics.setStroke(oldStroke);
        }
        return null;
    }
}
