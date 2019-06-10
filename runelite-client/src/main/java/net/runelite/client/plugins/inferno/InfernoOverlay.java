package net.runelite.client.plugins.inferno;

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;

import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class InfernoOverlay extends Overlay
{
	private final Client client;
	private final InfernoPlugin plugin;
	private final InfernoConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public InfernoOverlay(Client client, InfernoConfig config, InfernoPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!client.isInInstancedRegion() || client.getMapRegions()[0] != 9043) return null;

		for (InfernoNPC monster : plugin.getMonsters().values())
		{
			NPC npc = monster.getNpc();
			//if (npc == null || !config.showPrayer()) return;
			LocalPoint lp = npc.getLocalLocation();
			if (lp != null)
			{
				Point point = Perspective.localToCanvas(client, lp, client.getPlane(), npc.getLogicalHeight());
				if (point != null)
				{
					if (monster.getTicksTillAttack() == 1 || (monster.getName().equals("blob") && monster.getTicksTillAttack() <= 3))
					{
						renderTextLocation(graphics, monster, monster.info(), Color.GREEN);
					}
					else
					{
						renderTextLocation(graphics, monster, monster.info(), Color.RED);
					}
				}
			}
		}
		return null;
	}

	// renders text location
	public static void renderTextLocation(Graphics2D graphics, InfernoNPC actor, String text, Color color)
	{
		graphics.setFont(new Font("Arial", Font.BOLD, 15));
		Point textLocation = actor.getNpc().getCanvasTextLocation(graphics, text, actor.textLocHeight + 40);
		if (Strings.isNullOrEmpty(text))
		{
			return;
		}

		int x = textLocation.getX();
		int y = textLocation.getY();

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);

		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}
}
