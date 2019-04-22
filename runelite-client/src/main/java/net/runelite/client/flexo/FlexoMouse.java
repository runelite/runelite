package net.runelite.client.flexo;

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.ClientUI;

import java.awt.*;
import java.util.Random;

public class FlexoMouse {

    /*
    Should pass unstretched coords, handles all conversions here.
    */
    public static net.runelite.api.Point getClickPoint(Rectangle rect)
    {
        if (Flexo.isStretched)
        {
            double wScale;
            double hScale;

            if (Flexo.client.isResized()) {
                wScale = (Flexo.client.getStretchedDimensions().width / Flexo.client.getRealDimensions().width);
                hScale = (Flexo.client.getStretchedDimensions().height / Flexo.client.getRealDimensions().height);
            } else {
                wScale = ((double)Flexo.client.getStretchedDimensions().width)  / Flexo.fixedWidth;
                hScale = ((double)Flexo.client.getStretchedDimensions().height)  / Flexo.fixedHeight;
            }

            int xPadding = (int)rect.getWidth()/8;
            int yPadding = (int)rect.getHeight()/8;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding;
            clickRect.height = rect.height-yPadding;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            int x = clickRect.x+r.nextInt(clickRect.width);
            int y = clickRect.y+r.nextInt(clickRect.height);
            double tScale = 1 + (Flexo.scale / 100);

            if (Flexo.client.isResized()) {
                return new net.runelite.api.Point( (int)(x * wScale * tScale), (int)(y * hScale * tScale));
            } else {
                return new net.runelite.api.Point( (int)(x * wScale), (int)(y * hScale));
            }

        }
        //Fixed, not stretched
        else if (!Flexo.client.isResized()) {
            int fixedWidth = 765;
            int widthDif = ClientUI.frame.getWidth();

            if (ClientUI.pluginToolbar.isVisible()) {
                widthDif -= ClientUI.pluginToolbar.getWidth();
            }
            if (ClientUI.pluginPanel!=null)
                widthDif -= ClientUI.pluginPanel.getWidth();

            widthDif -= fixedWidth;
            int xPadding = (int)rect.getWidth()/8;
            int yPadding = (int)rect.getHeight()/8;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding;
            clickRect.height = rect.height-yPadding;
            clickRect.x = rect.x+xPadding+(widthDif/2);
            clickRect.y = rect.y+yPadding;
            int x = clickRect.x+r.nextInt(clickRect.width);
            int y = clickRect.y+r.nextInt(clickRect.height);
            return new net.runelite.api.Point(x, y);
        }
        //Resizable, not stretched
        else {
            int xPadding = (int)rect.getWidth()/8;
            int yPadding = (int)rect.getHeight()/8;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding;
            clickRect.height = rect.height-yPadding;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            int x = clickRect.x+r.nextInt(clickRect.width);
            int y = clickRect.y+r.nextInt(clickRect.height);
            return new Point(x, y);
        }
    }
}
