package net.runelite.client.plugins.combatlevel;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

public class CombatLevelOverlay extends Overlay {
	@Inject
	private Client client;

	@Inject
	private CombatLevelConfig config;

	@Inject
	private CombatLevelPlugin plugin;

	@Inject
	private TooltipManager tooltipManager;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showLevelsUntil() || plugin.getCombatLevel() == 126
			|| client.getVar(VarClientInt.CURRENT_TAB) != 0)
		{
			return null;
		}

		Point mousePoint = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		Rectangle combatCanvas = combatLevelWidget.getBounds();
		if (combatCanvas.contains(mousePoint))
		{
			Map<Skill, Integer> levels = plugin.getLevelsUntil();
			StringBuilder sb = new StringBuilder();
			sb.append("<col=ff981f>");
			sb.append("Levels until next level:</col></br>");
			sb.append(levels.get(Skill.ATTACK)).append(" Attack/Strength").append("</br>");
			sb.append(levels.get(Skill.DEFENCE)).append(" Defence/Hitpoints").append("</br>");
			sb.append(levels.get(Skill.MAGIC)).append(" Magic").append("</br>");
			sb.append(levels.get(Skill.RANGED)).append(" Ranged").append("</br>");
			sb.append(levels.get(Skill.PRAYER)).append(" Prayer");
			tooltipManager.add(new Tooltip(sb.toString()));
		}
		return null;
	}
}
