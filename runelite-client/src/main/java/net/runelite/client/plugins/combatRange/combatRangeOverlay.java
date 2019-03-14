package net.runelite.client.plugins.combatRange;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import org.apache.commons.lang3.StringUtils;

public class combatRangeOverlay extends Overlay
{

	private final Client client;
	private final combatRangeConfig config;


	@Inject
	public combatRangeOverlay(final Client client, combatRangeConfig config)
	{
		this.client = client;
		this.config = config;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.enablePlugin())
		{
			Widget wildyTextWidget = client.getWidget(WidgetInfo.DEADMAN_PROTECTION_TEXT);
			String wildyTextString;
			if (client.getLocalPlayer() != null
				&& wildyTextWidget != null
				&& !wildyTextWidget.isHidden())
			{
				int combatLevel = client.getLocalPlayer().getCombatLevel();

				wildyTextString = wildyTextWidget.getText();
				int wildyLevel;

				wildyLevel = Integer.parseInt(StringUtils.remove(wildyTextString.split(":")[1], " "));

				int lowRange;
				int highRange;

				lowRange = combatLevel - wildyLevel;
				highRange = combatLevel + wildyLevel;

				if (lowRange < 3)
				{
					lowRange = 3;
				}
				if (highRange > 126)
				{
					highRange = 126;
				}

				graphics.setColor(Color.black);
				graphics.setFont(new Font("TimesRoman", Font.PLAIN, 12));
				graphics.drawString("Combat Range: " + lowRange + "-" + highRange, wildyTextWidget.getCanvasLocation().getX() - 55, Math.round(wildyTextWidget.getCanvasLocation().getY() / 1.45) + 1);

				graphics.setColor(Color.YELLOW);
				graphics.drawString("Combat Range: " + lowRange + "-" + highRange, wildyTextWidget.getCanvasLocation().getX() - 56, Math.round(wildyTextWidget.getCanvasLocation().getY() / 1.45));

			}
		}

		return null;
	}
}
