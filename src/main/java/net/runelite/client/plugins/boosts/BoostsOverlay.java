package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class BoostsOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	private static final Skill[] SHOW = new Skill[] { Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.MAGIC };

	private static final int TOP_BORDER = 2;
	private static final int LEFT_BORDER = 2;
	private static final int RIGHT_BORDER = 2;

	private static final int SEPARATOR = 2;
	
	BoostsOverlay()
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Client client = RuneLite.getClient();

		if (client.getGameState() != GameState.LOGGED_IN)
			return null;
		
		FontMetrics metrics = graphics.getFontMetrics();

		int[] boostedSkills = client.getBoostedSkillLevels(),
			baseSkills = client.getRealSkillLevels();

		int height = TOP_BORDER;
		for (Skill skill : SHOW)
		{
			int boosted = boostedSkills[skill.ordinal()],
				base = baseSkills[skill.ordinal()];

			if (boosted == base)
				continue;

			height += metrics.getHeight() + SEPARATOR;
		}

		if (height == TOP_BORDER)
			return null;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		int y = TOP_BORDER;
		for (Skill skill : SHOW)
		{
			int boosted = boostedSkills[skill.ordinal()],
				base = baseSkills[skill.ordinal()];

			if (boosted == base)
				continue;

			graphics.setColor(Color.white);
			graphics.drawString(skill.getName(), LEFT_BORDER, y + metrics.getHeight());

			String str = boosted + "/" + base;
			graphics.drawString(str, WIDTH - RIGHT_BORDER - metrics.stringWidth(str), y + metrics.getHeight());

			y += metrics.getHeight() + SEPARATOR;
		}

		return new Dimension(WIDTH, height);
	}

}
