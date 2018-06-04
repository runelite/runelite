package net.runelite.client.plugins.skillcalculator;

import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.text.DecimalFormat;

class BankedExpPanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(35, 35);

	private final DecimalFormat FORMAT_COMMA = new DecimalFormat("#,###.#");

	BankedExpPanel(ItemManager itemManager, BankedItems item, int amount, double total)
	{
		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		AsyncBufferedImage icon = itemManager.getImage(item.getItemID());
		JLabel image = new JLabel();
		image.setMinimumSize(ICON_SIZE);
		image.setMaximumSize(ICON_SIZE);
		image.setPreferredSize(ICON_SIZE);
		image.setHorizontalAlignment(SwingConstants.LEFT);
		image.setBorder(new EmptyBorder(0, 8, 0, 0));

		Runnable resize = () ->
			image.setIcon(new ImageIcon(icon.getScaledInstance((int)ICON_SIZE.getWidth(), (int)ICON_SIZE.getHeight(), Image.SCALE_SMOOTH)));
		icon.onChanged(resize);
		resize.run();

		JShadowedLabel amountLabel = new JShadowedLabel(FORMAT_COMMA.format(amount));
		amountLabel.setForeground(Color.WHITE);
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JShadowedLabel expLabel = new JShadowedLabel(FORMAT_COMMA.format(total) + "xp");
		expLabel.setForeground(Color.WHITE);
		expLabel.setHorizontalAlignment(SwingConstants.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		add(image, c);
		c.gridx++;
		add(amountLabel, c);
		c.gridx++;
		add(expLabel, c);
	}
}
