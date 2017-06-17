package net.runelite.client.plugins.xpglobes;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.imageio.ImageIO;
import javax.swing.plaf.metal.MetalInternalFrameUI;
import javax.xml.bind.annotation.XmlType;
import java.awt.geom.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Steve on 6/17/2017.
 */
public class XpGlobesOverlay extends Overlay {

    private final XpGlobes plugin;
    private Client client = RuneLite.getClient();
    private final XpGlobesConfig config;


    private int DEFAULT_CIRCLE_WIDTH = 40;
    private int DEFAULT_CIRCLE_HEIGHT = 40;
    private int MINIMUM_STEP_WIDTH = DEFAULT_CIRCLE_WIDTH + 10;

    private int PROGRESS_RADIUS_START = 270;
    private int PROGRESS_RADIUS_REMAINDER = 0;

    private Color DEFAULT_XPGLOBE_BACKGROUND_COLOR = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
    private Color DEFAULT_PROGRESS_ARC_COLOR = new Color(Color.orange.getRed(), Color.orange.getGreen(), Color.orange.getBlue());;
    private Color DEFAULT_PROGRESS_REMAINDER_ARC_COLOR = new Color(Color.black.getRed(), Color.black.getGreen(), Color.black.getBlue());

    private int DEFAULT_START_Y = 10;

    private BufferedImage[] imgCache = new BufferedImage[23];

    public XpGlobesOverlay(XpGlobes plugin) {
        super(OverlayPosition.DYNAMIC);
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        // won't draw if not logged in or not enabled
        if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
        {
            return null;
        }

        int queueSize = plugin.getXpGlobesSize();
        if (queueSize > 0)
        {
            ArrayList<XpGlobe> xpChangedQueue = plugin.getXpGlobes();
            int markersLength = (queueSize * (DEFAULT_CIRCLE_WIDTH)) + ((MINIMUM_STEP_WIDTH - DEFAULT_CIRCLE_WIDTH) * (queueSize - 1));
            int startDrawX;
            if (client.isResized()) {
                startDrawX =  (client.getClientWidth()-markersLength)/2;
            } else {
                startDrawX = (client.getViewportHeight()-markersLength)/2;
            }
            for (XpGlobe xpGlobe : xpChangedQueue)
            {
                renderProgressCircle(graphics, xpGlobe, startDrawX, DEFAULT_START_Y);
                startDrawX+=MINIMUM_STEP_WIDTH;
            }

            plugin.removeExpiredXpGlobes();
        }

        return null;
    }

    private void renderProgressCircle (Graphics2D graphics, XpGlobe skillToDraw, int x, int y)
    {
        double radiusCurrentXp = skillToDraw.getSkillProgressRadius();
        double radiusToGoalXp = 360; //draw a circle

        drawEllipse(graphics, x, y);
		drawProgressArc(
		        graphics,
                x, y,
                DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT,
                PROGRESS_RADIUS_REMAINDER, radiusToGoalXp,
                5,
                DEFAULT_PROGRESS_REMAINDER_ARC_COLOR
        );
        drawProgressArc(
                graphics,
                x, y,
                DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT,
                PROGRESS_RADIUS_START, radiusCurrentXp,
                2,
                DEFAULT_PROGRESS_ARC_COLOR);

        drawSkillImage(graphics, skillToDraw, x, y);
    }

    private void drawProgressArc(Graphics2D graphics, int x, int y, int w, int h, double radiusStart, double radiusEnd, int strokeWidth, Color color)
    {
        graphics.setStroke(new BasicStroke(strokeWidth));
        graphics.setColor(color);
        graphics.draw(new Arc2D.Double(
                x, y,
                w, h,
                radiusStart, radiusEnd,
                Arc2D.OPEN));
    }

    private void drawEllipse(Graphics2D graphics, int x, int y)
    {
        graphics.setColor(DEFAULT_XPGLOBE_BACKGROUND_COLOR);
        Ellipse2D backgroundCircle = new Ellipse2D.Double(x, y,DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT);
        graphics.fill(backgroundCircle);
        graphics.draw(backgroundCircle);
    }

    private void drawSkillImage(Graphics2D graphics, XpGlobe xpGlobe, int x, int y)
    {
        int skillIdx = xpGlobe.getSkill().ordinal();

        if (imgCache[skillIdx] != null)
        {
            graphics.drawImage(
                    imgCache[skillIdx],
                    x+(DEFAULT_CIRCLE_WIDTH/2)-(imgCache[skillIdx].getWidth()/2),
                    y+(DEFAULT_CIRCLE_HEIGHT/2)-(imgCache[skillIdx].getHeight()/2),
                    null
            );
        }
        else
        {
            try
            {
                String skilLIconPath = "/skill_icons/"+ xpGlobe.getSkillName().toLowerCase() + ".png";
                System.out.println("Loading skill icon from {}" +  skilLIconPath);
                BufferedImage img = ImageIO.read(XpGlobesOverlay.class.getResourceAsStream(skilLIconPath));
                graphics.drawImage(
                        img,
                        x+(DEFAULT_CIRCLE_WIDTH/2)-(img.getWidth()/2),
                        y+(DEFAULT_CIRCLE_HEIGHT/2)-(img.getHeight()/2),
                        null
                );
                imgCache[skillIdx] = img;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
