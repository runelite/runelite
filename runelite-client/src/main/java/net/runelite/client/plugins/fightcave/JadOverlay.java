package net.runelite.client.plugins.fightcave;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
public class JadOverlay extends Overlay
{
    private final Client client;
    private final FightCavePlugin plugin;
    private final FightCaveConfig config;
    private final PanelComponent imagePanelComponent = new PanelComponent();
    private BufferedImage protectFromMagicImg;
    private BufferedImage protectFromMissilesImg;
    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

    @Inject
    JadOverlay(Client client, FightCavePlugin plugin, FightCaveConfig config)
    {
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.HIGH);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        JadAttack attack = plugin.getAttack();
        int currentWave = plugin.getCurrentWave();
        if (currentWave == 0 || attack == null) {
            return null;
        }
        imagePanelComponent.getChildren().clear();
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        final BufferedImage prayerImage = getPrayerImage(attack);
        imagePanelComponent.getChildren().clear();
        imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
        imagePanelComponent.setBackgroundColor(client.isPrayerActive(attack.getPrayer())
                    ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                    : NOT_ACTIVATED_BACKGROUND_COLOR);
        imagePanelComponent.render(graphics);
        return imagePanelComponent.render(graphics);
    }

    private BufferedImage getPrayerImage(JadAttack attack)
    {
        return attack == JadAttack.MAGIC ? getProtectFromMagicImage() : getProtectFromMissilesImage();
    }

    private BufferedImage getProtectFromMagicImage()
    {
        if (protectFromMagicImg == null)
        {
            String path = "/prayers/protect_from_magic.png";
            protectFromMagicImg = getImage(path);
        }
        return protectFromMagicImg;
    }

    private BufferedImage getProtectFromMissilesImage()
    {
        if (protectFromMissilesImg == null)
        {
            String path = "/prayers/protect_from_missiles.png";
            protectFromMissilesImg = getImage(path);
        }
        return protectFromMissilesImg;
    }

    private BufferedImage getImage(String path)
    {
        BufferedImage image = null;
        try
        {
            synchronized (ImageIO.class)
            {
                image = ImageIO.read(FightCaveOverlay.class.getResourceAsStream(path));
            }
        }
        catch (IOException e)
        {
            log.warn("Error loading image", e);
        }
        return image;
    }
}
