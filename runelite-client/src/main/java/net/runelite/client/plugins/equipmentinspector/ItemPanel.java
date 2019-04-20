package net.runelite.client.plugins.equipmentinspector;

import net.runelite.api.ItemComposition;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class ItemPanel extends JPanel
{

	ItemPanel(ItemComposition item, KitType kitType, AsyncBufferedImage icon)
	{
		setBorder(new EmptyBorder(3, 3, 3, 3));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		JLabel name = new JLabel(item.getName());

		JLabel location = new JLabel(StringUtils.capitalize(kitType.toString().toLowerCase()));
		location.setFont(FontManager.getRunescapeSmallFont());

		JLabel imageLabel = new JLabel();
		icon.addTo(imageLabel);

		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(imageLabel)
				.addGroup(layout.createSequentialGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(imageLabel)
				.addGap(8)
				.addGroup(layout.createParallelGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		// AWT's Z order is weird. This put image at the back of the stack
		setComponentZOrder(imageLabel, getComponentCount() - 1);
	}
}