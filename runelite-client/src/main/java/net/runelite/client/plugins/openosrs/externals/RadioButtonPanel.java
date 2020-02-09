package net.runelite.client.plugins.openosrs.externals;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends JPanel
{
	public static final Orientation VERTICAL = Orientation.VERTICAL;
	public static final Orientation HORIZONTAL = Orientation.HORIZONTAL;

	private ButtonGroup buttonGroup = new ButtonGroup();

	public RadioButtonPanel(String title, JRadioButton... buttons)
	{
		this(VERTICAL, title, buttons);
	}

	public RadioButtonPanel(Orientation orientation, String title, JRadioButton... buttons)
	{
		if (orientation == VERTICAL)
		{
			this.setLayout(new GridLayout(buttons.length, 1));
		}
		else
		{
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
		}

		for (JRadioButton button : buttons)
		{
			buttonGroup.add(button);
			this.add(button);
		}

		if (title != null)
		{
			this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), title));
		}
	}

	public void clearSelection()
	{
		buttonGroup.clearSelection();
	}

	private enum Orientation
	{
		VERTICAL,
		HORIZONTAL
	}
}
