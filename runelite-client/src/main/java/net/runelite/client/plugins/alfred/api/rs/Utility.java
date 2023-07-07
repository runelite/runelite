package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

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

    public static Rectangle getTabBounds(WidgetInfo widgetInfo) {
        Widget widget = Alfred.getClient().getWidget(widgetInfo);
        if (widget == null || widget.isHidden()) {
            return null;
        }

        return widget.getBounds();
    }

    public static Rectangle getTabBounds(int widgetID) {
        Widget widget = Alfred.getClient().getWidget(widgetID);
        if (widget == null || widget.isHidden()) {
            return null;
        }

        return widget.getBounds();
    }

}
