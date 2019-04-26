package net.runelite.client.plugins.ztob;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class VerzikNyloOverlay extends Overlay {

    private final Client client;
    private final TheatrePlugin plugin;
    private final TheatreConfig config;

    @Inject
    private VerzikNyloOverlay(Client client, TheatrePlugin plugin, TheatreConfig config) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

	public Dimension render(Graphics2D graphics)
	{

		if (plugin.isRunVerzik())
		{
			if (config.NyloTargetOverlay())
			{
				if (plugin.getCrabList().size() > 0)
				{

					for (NPC npc : plugin.getCrabList())
					{
						if (npc.isDead())
						{
                            continue;
                        }
                        String renderText = "";
						if (npc.getInteracting() != null)
						{

                            renderText = npc.getInteracting().getName();
							Point point = npc.getCanvasTextLocation(graphics, npc.getInteracting().getName(), 0);


							if (npc.getInteracting().getName().toLowerCase().equals(client.getLocalPlayer().getName().toLowerCase()))
							{
								point = npc.getCanvasTextLocation(graphics, client.getLocalPlayer().getName(), 0);
                                renderText = "YOU NIGGA RUN!";

							}
							else if (npc.getInteracting().getName().toLowerCase().equals("afyy"))
							{
								point = npc.getCanvasTextLocation(graphics, "Ricecup", 0);
                                renderText = "Ricecup";
                            }
							if (renderText.equals("YOU NIGGA RUN!"))
							{
                                renderTextLocation(graphics, renderText, 12, Font.BOLD, Color.RED, point);
							}
							else
							{
                                renderTextLocation(graphics, renderText, 12, Font.BOLD, Color.GREEN, point);
                            }
                        }

                    }
                }

            }
        }

        return null;
    }

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
        graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
            final Point canvasCenterPoint = new Point(
                    canvasPoint.getX(),
                    canvasPoint.getY());
            final Point canvasCenterPoint_shadow = new Point(
                    canvasPoint.getX() + 1,
				canvasPoint.getY() + 1);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
        }
    }
}
