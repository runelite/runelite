package net.runelite.client.plugins.alfred;

import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AlfredOverlayBuilder {
    private Graphics2D graphics;
    private Rectangle bounds;
    private int padding = 5;
    private int topLeftCurrentLine = 0;
    private int topRightCurrentLine = 0;
    private FontMetrics fontMetrics = Alfred.getClient().getCanvas().getFontMetrics(FontManager.getRunescapeFont());


    private static BufferedImage chatBoxImage = ImageUtil.loadImageResource(AlfredPlugin.class, "chatbox.png");

    public AlfredOverlayBuilder(Graphics2D graphics, Rectangle bounds) {
        this.graphics = graphics;
        this.bounds = bounds;
    }

    public void drawBounds() {
        graphics.drawImage(chatBoxImage, bounds.x - 1, bounds.y, null);
    }


    private Point getTextStartingPoint(String text, boolean topLeft) {
        int textHeight = fontMetrics.getHeight();
        int textWidth = fontMetrics.stringWidth(text);

        int startingX = bounds.x + padding;
        if (!topLeft) {
            startingX = bounds.x + bounds.width - (padding * 2) - textWidth;
        }

        int startingY = bounds.y + padding + (topLeftCurrentLine * textHeight) + fontMetrics.getAscent();
        if (!topLeft) {
            startingY = bounds.y + padding + (topRightCurrentLine * textHeight) + fontMetrics.getAscent();
        }

        return new Point(startingX, startingY);
    }

    public void drawTitle(String title) {
        Point startingPoint = getTextStartingPoint(title, true);

        graphics.setFont(FontManager.getRunescapeBoldFont());
        graphics.setColor(Color.BLACK);
        graphics.drawString(title, startingPoint.x + 1, startingPoint.y + 1);
        graphics.setColor(Color.YELLOW);
        graphics.drawString(title, startingPoint.x, startingPoint.y);
        topLeftCurrentLine++;
    }

    private void internalDrawText(String title, Color titleColor, boolean titleShadow, String text, Color textColor, boolean topLeft) {
        Point startingPoint = getTextStartingPoint(title + text, topLeft);
        int titleWidth = fontMetrics.stringWidth(title);

        graphics.setFont(FontManager.getRunescapeFont());
        int titlePadding = 0;

        if (titleShadow) {
            graphics.setColor(new Color(0, 0, 0));
            if (!title.isEmpty()) {
                titlePadding = 5;
                graphics.drawString(title, startingPoint.x + 1, startingPoint.y + 1);
            }
        }

        String cleanedTitle = title != null ? title : "";
        String cleanedText = text != null ? text : "";

        graphics.setColor(titleColor);
        graphics.drawString(cleanedTitle, startingPoint.x, startingPoint.y);

        graphics.setColor(textColor);
        graphics.drawString(cleanedText, startingPoint.x + titleWidth + titlePadding, startingPoint.y);

        if (topLeft) {
            topLeftCurrentLine++;
        } else {
            topRightCurrentLine++;
        }
    }

    public void drawText(String text, boolean topLeft) {
        internalDrawText("", Color.BLACK, false, text, Color.BLUE, topLeft);
    }

    public void drawText(String title, String text, boolean topLeft) {
        internalDrawText(title, Color.YELLOW, true, text, Color.BLUE, topLeft);
    }

    public void drawText(String title, Color titleColor, boolean titleShadow, String text, Color textColor, boolean topLeft) {
        internalDrawText(title, titleColor, titleShadow, text, textColor, topLeft);
    }
}
