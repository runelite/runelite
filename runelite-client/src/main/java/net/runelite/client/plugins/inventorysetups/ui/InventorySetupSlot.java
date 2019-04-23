package net.runelite.client.plugins.inventorysetups.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.runelite.client.game.AsyncBufferedImage;

public class InventorySetupSlot extends JPanel
{
	private final JLabel imageLabel;

	public InventorySetupSlot(Color color)
	{
		imageLabel = new JLabel();
		imageLabel.setVerticalAlignment(SwingConstants.CENTER);
		setPreferredSize(new Dimension(46, 42));
		setBackground(color);
		add(imageLabel);

	}

	public void setImageLabel(String toolTip, AsyncBufferedImage itemImage)
	{
		if (itemImage == null || toolTip == null)
		{
			imageLabel.setToolTipText("");
			imageLabel.setIcon(null);
			imageLabel.revalidate();
			return;
		}

		imageLabel.setToolTipText(toolTip);
		itemImage.addTo(imageLabel);

		validate();
		repaint();
	}
}