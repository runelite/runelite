package net.runelite.client.ui;

import java.awt.Dimension;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationPanel extends JPanel
{
	private static final Logger logger = LoggerFactory.getLogger(NavigationPanel.class);

	private static final int PANEL_WIDTH = 20, PANEL_HEIGHT = 503;

	private final JButton hiscores = new JButton();

	public NavigationPanel()
	{
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		try
		{
			hiscores.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/net/runelite/client/plugins/hiscore/hiscore.gif"))));
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		add(hiscores);
	}

	public JButton getHiscores()
	{
		return hiscores;
	}
}
