package net.runelite.client.plugins.freezetimers;

import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.green;

public class FreezeTimersOverlay extends Overlay
{
	
	@Inject
	private Timers timers;
	
	private final FreezeTimersConfig config;
	private final Client client;
	private final Font timerFont = FontManager.getRunescapeBoldFont().deriveFont(14.0f);
	private final BufferedImage FREEZE_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "freeze.png");
	private final BufferedImage TB_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "teleblock.png");
	private final BufferedImage VENG_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "veng.png");
	
	@Inject
	public FreezeTimersOverlay(FreezeTimersConfig config, Client client)
	{
		this.config = config;
		this.client = client;
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}
	
	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showPlayers())
		{
			client.getPlayers().forEach((p) -> renderOverlayFor(graphics, p));
		}
		if (config.showNpcs())
		{
			client.getNpcs().forEach((npc) -> renderOverlayFor(graphics, npc));
		}
		return null;
	}
	
	private void renderOverlayFor(Graphics2D g, Actor actor)
	{
		if (timers.areAllTimersZero(actor))
		{
			return;
		}
		
		int overlaysDrawn = 0;
		
		if (drawFreezeOverlay(g, actor, overlaysDrawn))
		{
			overlaysDrawn++;
		}
		if (drawTBOverlay(g, actor, overlaysDrawn))
		{
			overlaysDrawn++;
		}
		if (drawVengOverlay(g, actor, overlaysDrawn))
		{
			overlaysDrawn++;
		}
	}
	
	private boolean drawFreezeOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (timers.getTimerEnd(actor, TimerType.FREEZE) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.FREEZE);
		
		String text = processTickCounter(finishedAt);
		
		renderActorText(g, actor, text, overlaysDrawn, FREEZE_IMAGE);
		return true;
	}
	
	private boolean drawTBOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (timers.getTimerEnd(actor, TimerType.TELEBLOCK) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.TELEBLOCK);
		
		String text = processTickCounter(finishedAt);
		
		renderActorText(g, actor, text, overlaysDrawn, TB_IMAGE);
		return true;
	}
	
	private boolean drawVengOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (timers.getTimerEnd(actor, TimerType.VENG) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.VENG);
		
		String text = processTickCounter(finishedAt);
		
		renderActorText(g, actor, text, overlaysDrawn, VENG_IMAGE);
		if (actor.getGraphic() == GraphicID.VENGEANCE || actor.getGraphic() == GraphicID.VENGEANCE_OTHER)
		{
			
			g.setColor(RED);
			Polygon poly = actor.getCanvasTilePoly();
			if (poly != null)
			{
				OverlayUtil.renderPolygon(g, poly, RED);
			}
			OverlayUtil.renderTextLocation(g, new Point((int)poly.getBounds2D().getCenterX(),
					(int)poly.getBounds2D().getCenterY()), actor.getName(), RED);
		}
		return true;
	}
	
	private void renderActorText(Graphics2D g, Actor actor, String text, int overlaysDrawn, BufferedImage image)
	{
		int yOffset = (overlaysDrawn * 18);
		g.setFont(timerFont);
		g.setColor(WHITE);
		Rectangle rect = actor.getConvexHull().getBounds();
		int xOffset = (int) rect.getWidth();
		OverlayUtil.renderActorTextAndImage(g, actor, text, Color.WHITE, image, yOffset,
				xOffset);
		g.setColor(RED);
		g.draw(actor.getConvexHull().getBounds());
	}
	
	private String processTickCounter(long finishedAt)
	{
		long currentTick = System.currentTimeMillis();
		long tickDifference = finishedAt - currentTick;
		long seconds = tickDifference / 1000;
		seconds++;
		int minutes = (int) (seconds / 60);
		seconds = seconds % 60;
		String text = seconds > 9 ? seconds + "" : "0" + seconds;
		if (minutes > 0)
		{
			text = minutes + ":" + text;
		}
		return text + "";
	}
}
