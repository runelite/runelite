package net.runelite.client.plugins.shootingstars;

import java.awt.GridLayout;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

public class ShootingStarsPanel extends PluginPanel
{
	private static final Border DEFAULT_BORDER = new EmptyBorder(5, 5, 5, 5);
	private final JPanel starsPanel = new JPanel();

	public ShootingStarsPanel()
	{
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(2, 1));
		instructionsPanel.setBorder(DEFAULT_BORDER);
		instructionsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel title = new JLabel("Shooting Stars");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(FontManager.getRunescapeBoldFont());
		instructionsPanel.add(title);

		JLabel text = new JLabel("<html>To begin, observe a star by using a telescope in your PoH.</html>");
		instructionsPanel.add(text);

		add(instructionsPanel);

		starsPanel.setLayout(new GridLayout(0, 1, 0, 5));
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
			setBorder(DEFAULT_BORDER);
			setLayout(new GridLayout(0, 1, 0, 5));

			JLabel worldLabel = new JLabel("W" + scoutedStar.getWorld() + " - " + scoutedStar.getRegion().getName());
			worldLabel.setFont(FontManager.getRunescapeBoldFont());
			worldLabel.setHorizontalAlignment(SwingConstants.CENTER);
			add(worldLabel);

			JComponent timeWindow = new JPanel();
			timeWindow.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			timeWindow.setLayout(new GridLayout(1, 2));
			add(timeWindow);

			JLabel earliestLabel = new JLabel("Earliest: " + scoutedStar.getEarliestTime().toLocalTime().truncatedTo(ChronoUnit.MINUTES));
			timeWindow.add(earliestLabel);

			JLabel latestLabel = new JLabel("Latest: " + scoutedStar.getLatestTime().toLocalTime().truncatedTo(ChronoUnit.MINUTES));
			latestLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			timeWindow.add(latestLabel);
		}
	}
}
