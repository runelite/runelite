package net.runelite.client.plugins.inventorytagger;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class PresetBox extends JPanel
{
	PresetBox(TaggedItems ti)
	{
		BorderLayout layout = new BorderLayout();
		Color background = Color.black;
		setSize(100, 100);
		setBorder(new CompoundBorder
				(
						new LineBorder(getBackground().brighter(), 1),
						new EmptyBorder(5, 5, 5, 5)
				));

		// Item name
		JLabel itemName = new JLabel();
		itemName.setText("asd");
		add(itemName);
	}

}
