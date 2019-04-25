package net.runelite.client.flexo;

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.ClientUI;

import java.awt.*;
import java.util.Random;
import java.util.logging.Logger;

public class FlexoMouse {

    /*
    Should pass unstretched coords, handles all conversions here.
    */
    public static Point getClickPoint(Rectangle rect)
    {
        if (rect!=null) {
            Random r = new Random();
            int x = -1;
            int y = -1;
            x = rect.x+r.nextInt(rect.width);
            y = rect.y+r.nextInt(rect.height);

            if (Flexo.isStretched) {
                double wScale;
                double hScale;

                if (Flexo.client.isResized()) {
                    wScale = (Flexo.client.getStretchedDimensions().width / Flexo.client.getRealDimensions().width);
                    hScale = (Flexo.client.getStretchedDimensions().height / Flexo.client.getRealDimensions().height);
                    int newX = (int)(x*wScale);
                    int newY = (int)(y*hScale);
                    if (newX>0 && newX<ClientUI.frame.getWidth()) {
                        if (newY>0 && newY<ClientUI.frame.getHeight()) {
                            return new Point(newX, newY);
                        }
                    }
                    Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
                return null;
                } else {
                    if (x>0 && x<ClientUI.frame.getWidth()) {
                        if (y>0 && y<ClientUI.frame.getHeight()) {
                            return new Point(x, y);
                        }
                    }
                    Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
                    return null;
                }

            } else if (!Flexo.client.isResized()) {
                int fixedWidth = 765;
                int widthDif = ClientUI.frame.getWidth();

                if (ClientUI.pluginToolbar.isVisible()) {
                    widthDif -= ClientUI.pluginToolbar.getWidth();
                }
                if (ClientUI.pluginPanel!=null)
                    widthDif -= ClientUI.pluginPanel.getWidth();

                widthDif -= fixedWidth;
                if (x+(widthDif/2)>0 && x+(widthDif/2)<ClientUI.frame.getWidth()) {
                    if (y>0 && y<ClientUI.frame.getHeight()) {
                        return new Point(x, y);
                    }
                }
                Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
                return null;
            }
            else {
                if (x>0 && x<ClientUI.frame.getWidth()) {
                    if (y>0 && y<ClientUI.frame.getHeight()) {
                        return new Point(x, y);
                    }
                }
                Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
                return null;
            }
        }
        return null;
    }

    public static Rectangle getClickArea(Rectangle rect)
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

            int xPadding = (int)rect.getWidth()/5;
            int yPadding = (int)rect.getHeight()/5;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding*2;
            clickRect.height = rect.height-yPadding*2;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            if (clickRect.width>0&&clickRect.height>0) {
                int x = clickRect.x+r.nextInt(clickRect.width);
                int y = clickRect.y+r.nextInt(clickRect.height);
                double tScale = 1 + (Flexo.scale / 100);

                if (Flexo.client.isResized()) {
                    return new Rectangle((int)(clickRect.x * wScale), (int)(clickRect.y * wScale), (int)(clickRect.width * wScale), (int)(clickRect.getHeight()*hScale));
                } else {
                    return new Rectangle((int)(clickRect.x), (int)(clickRect.y), (int)(clickRect.width), (int)(clickRect.getHeight()));
                }
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
            int xPadding = (int)rect.getWidth()/5;
            int yPadding = (int)rect.getHeight()/5;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding;
            clickRect.height = rect.height-yPadding;
            clickRect.x = rect.x+xPadding+(widthDif/2);
            clickRect.y = rect.y+yPadding;
            if (clickRect.height>0&&clickRect.width>0) {
                int x = clickRect.x + r.nextInt(clickRect.width);
                int y = clickRect.y + r.nextInt(clickRect.height);
                return new Rectangle((int) (clickRect.x), (int) (clickRect.y), (int) (clickRect.width), (int) (clickRect.getHeight()));
            }
        }
        //Resizable, not stretched
        else {
            int xPadding = (int)rect.getWidth()/5;
            int yPadding = (int)rect.getHeight()/5;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding*2;
            clickRect.height = rect.height-yPadding*2;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            if (clickRect.height>0&&clickRect.width>0) {
                int x = clickRect.x+r.nextInt(clickRect.width);
                int y = clickRect.y+r.nextInt(clickRect.height);
                return new Rectangle((int)(clickRect.x), (int)(clickRect.y), (int)(clickRect.width), (int)(clickRect.getHeight()));
            }
        }

        return null;
    }

    public static Rectangle getGroundItemClickArea(Rectangle rect)
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

            int xPadding = (int)rect.getWidth()/(int)wScale*3;
            int yPadding = (int)rect.getHeight()/(int)hScale*3;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding*2;
            clickRect.height = rect.height-yPadding*2;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            if (clickRect.width>0&&clickRect.height>0) {
                int x = clickRect.x+r.nextInt(clickRect.width);
                int y = clickRect.y+r.nextInt(clickRect.height);
                double tScale = 1 + (Flexo.scale / 100);

                if (Flexo.client.isResized()) {
                    return new Rectangle((int)(clickRect.x * wScale), (int)(clickRect.y * wScale), (int)(clickRect.width * wScale), (int)(clickRect.getHeight()*hScale));
                } else {
                    return new Rectangle((int)(clickRect.x), (int)(clickRect.y), (int)(clickRect.width), (int)(clickRect.getHeight()));
                }
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
            int xPadding = (int)rect.getWidth()/3;
            int yPadding = (int)rect.getHeight()/3;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding;
            clickRect.height = rect.height-yPadding;
            clickRect.x = rect.x+xPadding+(widthDif/2);
            clickRect.y = rect.y+yPadding;
            if (clickRect.height>0&&clickRect.width>0) {
                int x = clickRect.x + r.nextInt(clickRect.width);
                int y = clickRect.y + r.nextInt(clickRect.height);
                return new Rectangle((int) (clickRect.x), (int) (clickRect.y), (int) (clickRect.width), (int) (clickRect.getHeight()));
            }
        }
        //Resizable, not stretched
        else {
            int xPadding = (int)rect.getWidth()/3;
            int yPadding = (int)rect.getHeight()/3;
            Random r = new Random();
            Rectangle clickRect = new Rectangle();
            clickRect.width = rect.width-xPadding*2;
            clickRect.height = rect.height-yPadding*2;
            clickRect.x = rect.x+xPadding;
            clickRect.y = rect.y+yPadding;
            if (clickRect.height>0&&clickRect.width>0) {
                int x = clickRect.x+r.nextInt(clickRect.width);
                int y = clickRect.y+r.nextInt(clickRect.height);
                return new Rectangle((int)(clickRect.x), (int)(clickRect.y), (int)(clickRect.width), (int)(clickRect.getHeight()));
            }
        }

        return null;
    }
}
