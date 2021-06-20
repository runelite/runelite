package net.runelite.client.plugins.shootingstars;

import java.awt.Color;
import javax.swing.JButton;
import net.runelite.client.ui.PluginPanel;

public class ShootingStarsPanel extends PluginPanel
{
	public ShootingStarsPanel()
	{
		setBackground(Color.RED);
		JButton button = new JButton("Add Scout");
		add(button);
	}
}
