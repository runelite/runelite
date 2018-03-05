package net.runelite.client.plugins.regenmeter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class RegenMeterOverlay extends Overlay {
	private final Client client;
	private Instant timerStart = Instant.now();
	private int lastHpAmount = 0;
	private boolean rapidHealActive = false;
	private float regenModifier = 1f;

	@Inject
	public RegenMeterOverlay(Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
	}

	public void onTick()
	{
		CheckStatus();
	}

	@Override
	public Dimension render(Graphics2D graphics, Point point)
	{
		Widget hpOrb = client.getWidget(WidgetInfo.MINIMAP_HEALTH_ORB);
		if (hpOrb == null)
		{
			return null;
		}

		Rectangle2D bounds = hpOrb.getBounds().getBounds2D();
		if (bounds.getX() <= 0)
		{
			return null;
		}

		int orbInnerX = (int) (bounds.getX() + 27);
		int orbInnerY = (int) (bounds.getY() + 4);

		long timeSinceStart = Duration.between(timerStart, Instant.now()).toMillis();

		float tickProgress = timeSinceStart / 600f;

		graphics.setColor(new Color(255, 255, 255, 100));
		graphics.fillArc(orbInnerX, orbInnerY, 26, 26, 90, (int) (3.6f * tickProgress * regenModifier));

		return new Dimension((int) bounds.getWidth(), (int) bounds.getHeight());
	}

	private void CheckStatus(){

		if (client.getBoostedSkillLevel(Skill.HITPOINTS) < lastHpAmount)
		{
			lastHpAmount = client.getBoostedSkillLevel(Skill.HITPOINTS);
		}

		if (rapidHealActive)
		{
			if (!client.isPrayerActive(Prayer.RAPID_HEAL))
			{
				rapidHealActive = false;
				timerStart = Instant.now();
				regenModifier = 1f;
				return;
			}
		}
		else if (client.isPrayerActive(Prayer.RAPID_HEAL))
		{
			rapidHealActive = true;
			timerStart = Instant.now();
			regenModifier = 2f;
			return;
		}

		if (client.getBoostedSkillLevel(Skill.HITPOINTS) > lastHpAmount)
		{
			lastHpAmount = client.getBoostedSkillLevel(Skill.HITPOINTS);
			timerStart = Instant.now();
		}
	}
}
