package net.runelite.client.plugins.experiencedrops;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by bold on 1/18/17.
 */
public class ExpDropsOverlay extends Overlay
{
    private static Font currFont = new Font("Inconsolata", Font.TRUETYPE_FONT, 20);
    private static Client client = RuneLite.getClient();
    private static int[] oldXP = new int[23];
    private static int[] newXP = new int[23];
    public static boolean expChangeFlag = false;
    private static LinkedList<Drop> xp = new LinkedList<>();

    public ExpDropsOverlay(OverlayPosition position, OverlayPriority priority)
    {
        super(position, priority);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (client.getGameState() != GameState.LOGGED_IN)
            return null;
        if (expChangeFlag)
        {
            xp.add(updateExp());
        }
        graphics.setFont(currFont);
        graphics.setColor(Color.white);
        for (Drop d : xp)
        {
            String s = String.valueOf(d.getSumXP());
            graphics.drawString(s, 100 - graphics.getFontMetrics().stringWidth(s), d.getY());

            if (d.getY() <= graphics.getFontMetrics().getHeight())
                xp.remove(d);
            d.setY(d.getY() - 2);

        }
        expChangeFlag = false;
        return new Dimension(1000, 1000);
    }

    public Drop updateExp()
    {
        int sumXP = 0;

        newXP = Arrays.copyOf(client.getSkillExperiences(), 23);
        for (int i = 0; i < 23; i++)
        {
            if (newXP[i] != oldXP[i])
            {
                sumXP += (newXP[i] - oldXP[i]);
            }
        }
        oldXP = Arrays.copyOf(newXP, 23);
        int yCoord = client.isResized() ? client.getClientHeight() / 4 : client.getClientHeight() / 3;
        return new Drop(sumXP, null, yCoord);
    }
}
