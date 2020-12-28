package net.runelite.client.plugins.dagannothkings.overlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.dagannothkings.DKConfig;
import net.runelite.client.plugins.dagannothkings.DKPlugin;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class InfoboxOverlay extends Overlay
{
    private static final BufferedImage[] SPRITES = new BufferedImage[3];

    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

    private static final Dimension INFO_BOX_DIMENSION = new Dimension(40, 40);

    private static final PanelComponent PANEL_COMPONENT = new PanelComponent();
    private static final InfoBoxComponent PRAYER_COMPONENT = new InfoBoxComponent();

    static
    {
        PANEL_COMPONENT.getChildren().add(PRAYER_COMPONENT);
        PANEL_COMPONENT.setPreferredSize(INFO_BOX_DIMENSION);
        PANEL_COMPONENT.setBorder(new Rectangle(0, 0, 0, 0));

        PRAYER_COMPONENT.setPreferredSize(INFO_BOX_DIMENSION);
    }

    private final Client client;

    private final DKPlugin plugin;
    private final DKConfig config;

    private final SpriteManager spriteManager;

    @Inject
    public InfoboxOverlay(final Client client, final DKPlugin plugin, final DKConfig config, final SpriteManager spriteManager)
    {
        super(plugin);

        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.spriteManager = spriteManager;

        setPriority(OverlayPriority.HIGH);
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        determineLayer();
    }

    @Override
    public Dimension render(final Graphics2D graphics2D)
    {
        final Set<DagannothKing> dagannothKings = plugin.getDagannothKings();

        if (!config.showPrayerInfoboxOverlay() || dagannothKings.isEmpty())
        {
            return null;
        }

        final DagannothKing dk = dagannothKings.stream().sorted().findFirst().orElse(null);

        updatePrayerComponent(dk.getAttackStyle().getPrayer());

        return PANEL_COMPONENT.render(graphics2D);
    }

    public void determineLayer()
    {
        setLayer(config.mirrorMode() ? OverlayLayer.ALWAYS_ON_TOP : OverlayLayer.ABOVE_WIDGETS);
    }

    private void updatePrayerComponent(final Prayer prayer)
    {
        PRAYER_COMPONENT.setBackgroundColor(client.isPrayerActive(prayer)
                ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                : NOT_ACTIVATED_BACKGROUND_COLOR);

        PRAYER_COMPONENT.setImage(getPrayerSprite(prayer));
    }

    private BufferedImage getPrayerSprite(final Prayer prayer)
    {
        switch (prayer)
        {
            case PROTECT_FROM_MAGIC:
                if (SPRITES[0] == null)
                {
                    SPRITES[0] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0));
                }

                return SPRITES[0];
            case PROTECT_FROM_MISSILES:
                if (SPRITES[1] == null)
                {
                    SPRITES[1] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0));
                }

                return SPRITES[1];
            case PROTECT_FROM_MELEE:
                if (SPRITES[2] == null)
                {
                    SPRITES[2] = scaleSprite(spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0));
                }

                return SPRITES[2];
            default:
                throw new IllegalStateException("Unexpected prayer: " + prayer);
        }
    }

    private static BufferedImage scaleSprite(final BufferedImage bufferedImage)
    {
        if (bufferedImage == null)
        {
            return null;
        }

        final double width = bufferedImage.getWidth(null);
        final double height = bufferedImage.getHeight(null);
        final double size = 36;
        final double scalex = size / width;
        final double scaley = size / height;
        final double scale = Math.min(scalex, scaley);
        final int newWidth = (int) (width * scale);
        final int newHeight = (int) (height * scale);
        final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        final Graphics g = scaledImage.createGraphics();
        g.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return scaledImage;
    }
}