/**
 * Copyright (C) 2017 Kyle Fricilone
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.runelite.client.ui.overlay;

import net.runelite.api.*;
import net.runelite.api.Point;

import java.awt.*;

/**
 * Created by Kyle Fricilone on Jun 09, 2017.
 */
public class OverlayUtil
{

    public static void renderPolygon(Graphics2D graphics, Polygon poly, Color color)
    {
        graphics.setColor(color);
        graphics.setStroke(new BasicStroke(2));
        graphics.drawPolygon(poly);
        graphics.setColor(new Color(0, 0, 0, 50));
        graphics.fillPolygon(poly);
    }

    public static void rednerMinimapLocation(Graphics2D graphics, Point mini, Color color)
    {
        graphics.setColor(color);
        graphics.fillOval(mini.getX(), mini.getY(), 5, 5);
        graphics.setColor(Color.WHITE);
        graphics.setStroke(new BasicStroke(1));
        graphics.drawOval(mini.getX(), mini.getY(), 5, 5);
    }

    public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
    {
        int x = txtLoc.getX();
        int y = txtLoc.getY();

        graphics.setColor(Color.BLACK);
        graphics.drawString(text, x + 1, y + 1);

        graphics.setColor(color);
        graphics.drawString(text, x, y);
    }

    public static void renderActorOverlay(Graphics2D graphics, Actor actor, String text, Color color)
    {
        Polygon poly = actor.getCanvasTilePoly();
        if (poly != null)
        {
            renderPolygon(graphics, poly, color);
        }

        Point minimapLocation = actor.getMinimapLocation();
        if (minimapLocation != null)
        {
            rednerMinimapLocation(graphics, minimapLocation, color);
        }

        Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getModelHeight() + 40);
        if (textLocation != null)
        {
            renderTextLocation(graphics, textLocation, text, color);
        }
    }

    public static void renderTileOverlay(Graphics2D graphics, TileObject tileObject, String text, Color color)
    {
        Polygon poly = tileObject.getCanvasTilePoly();
        if (poly != null)
        {
            renderPolygon(graphics, poly, color);
        }

        Point minimapLocation = tileObject.getMinimapLocation();
        if (minimapLocation != null)
        {
            rednerMinimapLocation(graphics, minimapLocation, color);
        }

        Point textLocation = tileObject.getCanvasTextLocation(graphics, text, 0);
        if (textLocation != null)
        {
            renderTextLocation(graphics, textLocation, text, color);
        }
    }

}
