package net.runelite.client.plugins.equipmentinspector;

import net.runelite.api.ItemComposition;
import net.runelite.api.kit.KitType;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class ItemPanel extends JPanel
{
	ItemPanel(ItemComposition item, KitType kitType)
	{
		setBorder(new EmptyBorder(3, 3, 3, 3));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		JLabel image = new JLabel();
		//b.getIcon().addTo(image);
		JLabel name = new JLabel(item.getName());
		JLabel location = new JLabel(kitType.toString());
		location.setFont(FontManager.getRunescapeSmallFont());

		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(image)
				.addGroup(layout.createSequentialGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(image)
				.addGap(8)
				.addGroup(layout.createParallelGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		// AWT's Z order is weird. This put image at the back of the stack
		setComponentZOrder(image, getComponentCount() - 1);
	}
}
