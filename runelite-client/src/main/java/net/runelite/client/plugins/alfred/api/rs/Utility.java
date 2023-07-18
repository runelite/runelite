package net.runelite.client.plugins.alfred.api.rs;

import java.awt.*;

public class Utility {
    private static Point getRandomPointFromBounds(int x, int y, int width, int height) {
        int partialWidth = (int) (width * 0.66);
        int partialHeight = (int) (height * 0.66);
        int halfPartialWidth = partialWidth / 2;
        int halfPartialHeight = partialHeight / 2;

        int xLowerBound = x + halfPartialWidth;
        int xUpperBound = x + width - halfPartialWidth;
        int yLowerBound = y + halfPartialHeight;
        int yUpperBound = y + height - halfPartialHeight;

        int randomX = (int) (Math.random() * (xUpperBound - xLowerBound)) + xLowerBound;
        int randomY = (int) (Math.random() * (yUpperBound - yLowerBound)) + yLowerBound;

        return new Point(randomX, randomY);
    }

    public static Point getRandomPointFromBounds(Rectangle rectangle) {
        return getRandomPointFromBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public static Point getRandomPointFromBounds(Polygon polygon) {
        return getRandomPointFromBounds(polygon.getBounds());
    }

}
