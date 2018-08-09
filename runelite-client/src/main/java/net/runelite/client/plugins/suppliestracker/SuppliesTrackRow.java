package net.runelite.client.plugins.suppliestracker;


import net.runelite.client.game.AsyncBufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;


class SuppliesTrackRow extends JPanel
{
	int quantity;
	long totalCost;
	int itemId;

	SuppliesTrackRow(AsyncBufferedImage icon, String name, int quant, long cost, int id)
	{
		//Set variables
		quantity = quant;
		totalCost = cost;
		itemId = id;

		//build components
		setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel();
		icon.addTo(iconLabel);
		String rowText = "  x " + quant + "   (" + String.format("%,d", cost) + "gp)";
		JLabel label = new JLabel(rowText);
		iconLabel.setToolTipText(buildToolTip(name, quant, cost));

		//add components
		add(label, BorderLayout.CENTER);
		add(iconLabel, BorderLayout.LINE_START);
	}

	private String buildToolTip(String name, int quantity, long cost)
	{
		return name + " x " + quantity + " (" + String.format("%,d", cost) + "gp)";
	}

}
