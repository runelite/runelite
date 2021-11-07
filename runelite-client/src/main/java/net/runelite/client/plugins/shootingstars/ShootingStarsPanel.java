package net.runelite.client.plugins.shootingstars;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

public class ShootingStarsPanel extends PluginPanel
{
	private final JPanel starsPanel = new JPanel();

	public ShootingStarsPanel()
	{
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(2, 1));
		instructionsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		instructionsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel title = new JLabel("Shooting Stars");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(FontManager.getRunescapeBoldFont());
		instructionsPanel.add(title);

		JLabel text = new JLabel("<html>To begin, observe a star by using a telescope in your PoH.</html>");
		instructionsPanel.add(text);

		add(instructionsPanel);

		starsPanel.setLayout(new BoxLayout(starsPanel, BoxLayout.PAGE_AXIS));
		starsPanel.setBackground(Color.MAGENTA);
		add(starsPanel);
	}

	public void buildScoutedStarComponents(List<ScoutedStar> scoutedStars)
	{
		SwingUtilities.invokeLater(() -> {
			starsPanel.removeAll();

			for (ScoutedStar scoutedStar : scoutedStars)
			{
				starsPanel.add(new ScoutedStarComponent(scoutedStar));
				starsPanel.revalidate();
			}
		});
	}

	public static class ScoutedStarComponent extends JPanel
	{
		public ScoutedStarComponent(ScoutedStar scoutedStar)
		{
			setBackground(ColorScheme.DARKER_GRAY_COLOR);
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			add(new JLabel("W" + scoutedStar.getWorld() + " - " + scoutedStar.getRegion().getName()));
			add(new JLabel("Earliest " + scoutedStar.getEarliestTime().toLocalTime().truncatedTo(ChronoUnit.MINUTES)));
			add(new JLabel("Latest " + scoutedStar.getLatestTime().toLocalTime().truncatedTo(ChronoUnit.MINUTES)));
		}
	}
}
