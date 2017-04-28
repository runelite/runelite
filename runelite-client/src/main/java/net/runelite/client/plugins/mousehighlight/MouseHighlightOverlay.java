package net.runelite.client.plugins.mousehighlight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

/**
 * Created by aria on 4/27/17.
 */
public class MouseHighlightOverlay extends Overlay
{
	public MouseHighlightOverlay()
	{
		super(OverlayPosition.DYNAMIC, OverlayPriority.MED);
	}

	private final Pattern p = Pattern.compile("^<col=([^>]+)>([^<]*)");

	// Not for <col=ffff>Poll booth
	@Override
	public Dimension render(Graphics2D graphics)
	{
		Client client = RuneLite.getClient();
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		String[] targets = client.getMenuTargets();
		String[] options = client.getMenuOptions();
		int count = client.getMenuCount() - 1;

		String colour = "ff0000";
		String target = "";
		if (targets[count] != "")
		{
			Matcher m = p.matcher(targets[count]);
			if (m.find())
			{
				colour = m.group(1);
				target = m.group(2);
			}
		}
		else
		{
			return null;
		}

		if (options[count] == "Walk here")
		{
			return null;
		}

		Point mouse = client.getMouseCanvasPosition();
		int x = mouse.getX();
		int y = mouse.getY();

		FontMetrics fm = graphics.getFontMetrics();
		int option_width = fm.stringWidth(options[count] + " ");
		int total_width = option_width + fm.stringWidth(target);
		int height = fm.getHeight();
		Color gray = new Color(Color.lightGray.getRed(), Color.lightGray.getGreen(), Color.lightGray.getBlue(), 125);
		graphics.setColor(gray);
		graphics.fillRect(x, y - (height / 2), total_width + 6, height);
		graphics.setColor(Color.cyan);
		graphics.drawRect(x, y - (height / 2), total_width + 6, height);
		x += 3;
		y += 3;
		graphics.setColor(Color.white);
		graphics.drawString(options[count] + " ", x, y);
		Color c = hex2rgb(colour);
		graphics.setColor(hex2rgb(colour));
		graphics.drawString(target, x + option_width, y);

		return null;
	}

	private static Color hex2rgb(String col)
	{
		if (col.length() < 6)
		{
			return new Color(255, 255, 255);
		}

		return new Color(
			Integer.valueOf(col.substring(0, 2), 16),
			Integer.valueOf(col.substring(2, 4), 16),
			Integer.valueOf(col.substring(4, 6), 16)
		);
	}
}
