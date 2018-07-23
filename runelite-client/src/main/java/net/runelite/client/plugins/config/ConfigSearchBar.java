package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.ui.components.IconTextField;

public class ConfigSearchBar extends IconTextField
{
	private static final int SEARCH_BAR_SIZE = 30;

	private static final ImageIcon SEARCH;
	private static final ImageIcon CLEAR;
	private static final ImageIcon CLEAR_HOVER;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
				CLEAR = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("clear.png")));
				CLEAR_HOVER = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("clear_hover.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public ConfigSearchBar()
	{
		super();

		setIcon(SEARCH);
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, SEARCH_BAR_SIZE));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);

		IconButton clearButton = new IconButton(CLEAR, CLEAR_HOVER);
		clearButton.setPreferredSize(new Dimension(SEARCH_BAR_SIZE, SEARCH_BAR_SIZE));
		clearButton.addActionListener(e -> this.setText(""));

		add(clearButton, BorderLayout.EAST);
	}
}
